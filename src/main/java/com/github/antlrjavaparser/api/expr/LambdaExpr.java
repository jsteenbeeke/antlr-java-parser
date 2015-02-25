package com.github.antlrjavaparser.api.expr;

import com.github.antlrjavaparser.api.visitor.GenericVisitor;
import com.github.antlrjavaparser.api.visitor.VoidVisitor;

/**
 * User: mdehaan Date: 3/19/14
 */
public class LambdaExpr extends Expression {
	private LambdaParameterExpr parameters;

	private LambdaBodyExpr body;

	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);
	}

	public LambdaParameterExpr getParameters() {
		return parameters;
	}

	public void setParameters(LambdaParameterExpr parameters) {
		this.parameters = parameters;
	}

	public LambdaBodyExpr getBody() {
		return body;
	}

	public void setBody(LambdaBodyExpr body) {
		this.body = body;
	}
}
