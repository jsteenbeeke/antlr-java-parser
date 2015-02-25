package com.github.antlrjavaparser.api.expr;

import java.util.List;

import com.github.antlrjavaparser.api.body.Parameter;
import com.github.antlrjavaparser.api.visitor.GenericVisitor;
import com.github.antlrjavaparser.api.visitor.VoidVisitor;

public class FormalLambdaParameterExpr extends LambdaParameterExpr {
	private List<Parameter> parameters;

	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);

	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}

}
