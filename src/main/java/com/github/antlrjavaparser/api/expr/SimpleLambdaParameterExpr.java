package com.github.antlrjavaparser.api.expr;

import java.util.List;

import com.github.antlrjavaparser.api.visitor.GenericVisitor;
import com.github.antlrjavaparser.api.visitor.VoidVisitor;

public class SimpleLambdaParameterExpr extends LambdaParameterExpr {
	private List<String> identifiers;

	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return v.visit(this, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		v.visit(this, arg);
	}

	public List<String> getIdentifiers() {
		return identifiers;
	}

	public void setIdentifiers(List<String> identifiers) {
		this.identifiers = identifiers;
	}
}
