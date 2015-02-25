package com.github.antlrjavaparser.adapter;

import com.github.antlrjavaparser.Java7Parser;
import com.github.antlrjavaparser.ParseException;
import com.github.antlrjavaparser.api.expr.Expression;
import com.github.antlrjavaparser.api.expr.LambdaBodyExpr;
import com.github.antlrjavaparser.api.expr.LambdaExpr;
import com.github.antlrjavaparser.api.expr.LambdaParameterExpr;

/**
 * User: mdehaan Date: 3/19/14
 */
public class LambdaExpressionContextAdapter implements
		Adapter<Expression, Java7Parser.LambdaExpressionContext> {

	@Override
	public Expression adapt(Java7Parser.LambdaExpressionContext context,
			AdapterParameters adapterParameters) {

		if (context.LAMBDA() != null && context.lambdaParameters() != null
				&& context.lambdaBody() != null) {
			LambdaExpr expr = new LambdaExpr();
			AdapterUtil.setComments(expr, context, adapterParameters);
			AdapterUtil.setPosition(expr, context);

			LambdaParameterExpr lambdaParameters = Adapters
					.getLambdaParameterExpressionContextAdapter().adapt(
							context.lambdaParameters(), adapterParameters);

			LambdaBodyExpr lambdaBody = Adapters.getLambdaBodyContextAdapter()
					.adapt(context.lambdaBody(), adapterParameters);

			expr.setBody(lambdaBody);
			expr.setParameters(lambdaParameters);

			return expr;
		}

		if (context.conditionalExpression() != null) {
			return Adapters.getConditionalExpressionContextAdapter().adapt(
					context.conditionalExpression(), adapterParameters);
		}

		throw new ParseException("Unknown Expression");
	}

}