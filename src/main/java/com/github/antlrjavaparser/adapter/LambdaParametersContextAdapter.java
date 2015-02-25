package com.github.antlrjavaparser.adapter;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;

import com.github.antlrjavaparser.Java7Parser.LambdaParametersContext;
import com.github.antlrjavaparser.ParseException;
import com.github.antlrjavaparser.api.expr.FormalLambdaParameterExpr;
import com.github.antlrjavaparser.api.expr.LambdaParameterExpr;
import com.github.antlrjavaparser.api.expr.SimpleLambdaParameterExpr;

public class LambdaParametersContextAdapter implements
		Adapter<LambdaParameterExpr, LambdaParametersContext> {
	@Override
	public LambdaParameterExpr adapt(LambdaParametersContext context,
			AdapterParameters adapterParameters) {
		if (context.Identifier() != null) {
			// Simple, with a single identifier
			SimpleLambdaParameterExpr expr = new SimpleLambdaParameterExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);

			List<String> identifiers = new ArrayList<>(1);
			identifiers.add(context.Identifier().getText());
			expr.setIdentifiers(identifiers);

			return expr;

		} else if (context.inferredFormalParameterList() != null) {
			// Simple, with multiple identifiers
			SimpleLambdaParameterExpr expr = new SimpleLambdaParameterExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);

			List<TerminalNode> identifierNodes = context
					.inferredFormalParameterList().inferredFormalParameters()
					.Identifier();
			List<String> identifiers = new ArrayList<>(identifierNodes.size());
			for (TerminalNode terminalNode : identifierNodes) {
				identifiers.add(terminalNode.getText());
			}
			expr.setIdentifiers(identifiers);

			return expr;
		} else if (context.formalParameters() != null) {
			// A list of formal parameters
			FormalLambdaParameterExpr expr = new FormalLambdaParameterExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);

			expr.setParameters(Adapters.getFormalParametersContextAdapter()
					.adapt(context.formalParameters(), adapterParameters));

			return expr;

		}

		throw new ParseException("Invalid Lambda expression parameters");
	}
}
