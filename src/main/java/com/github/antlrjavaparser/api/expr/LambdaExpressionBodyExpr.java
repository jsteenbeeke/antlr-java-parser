package com.github.antlrjavaparser.api.expr;

import com.github.antlrjavaparser.api.visitor.GenericVisitor;
import com.github.antlrjavaparser.api.visitor.VoidVisitor;

public class LambdaExpressionBodyExpr extends LambdaBodyExpr {
	private Expression expression;

	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return expression.accept(v, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		expression.accept(v, arg);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

}
