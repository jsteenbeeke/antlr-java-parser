package com.github.antlrjavaparser.adapter;

import com.github.antlrjavaparser.Java7Parser.LambdaBodyContext;
import com.github.antlrjavaparser.ParseException;
import com.github.antlrjavaparser.api.expr.LambdaBlockBodyExpr;
import com.github.antlrjavaparser.api.expr.LambdaBodyExpr;
import com.github.antlrjavaparser.api.expr.LambdaExpressionBodyExpr;

public class LambdaBodyContextAdapter implements
		Adapter<LambdaBodyExpr, LambdaBodyContext> {
	@Override
	public LambdaBodyExpr adapt(LambdaBodyContext context,
			AdapterParameters adapterParameters) {

		if (context.expression() != null) {
			LambdaExpressionBodyExpr expr = new LambdaExpressionBodyExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);
			expr.setExpression(Adapters.getExpressionContextAdapter().adapt(
					context.expression(), adapterParameters));

			return expr;
		}
		if (context.block() != null) {
			LambdaBlockBodyExpr expr = new LambdaBlockBodyExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);

			expr.setBlock(Adapters.getBlockContextAdapter().adapt(
					context.block(), adapterParameters));

			return expr;
		}

		throw new ParseException("Unknown lambda expression body");
	}
}
