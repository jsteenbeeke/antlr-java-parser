package com.github.antlrjavaparser.api.expr;

import com.github.antlrjavaparser.api.stmt.BlockStmt;
import com.github.antlrjavaparser.api.visitor.GenericVisitor;
import com.github.antlrjavaparser.api.visitor.VoidVisitor;

public class LambdaBlockBodyExpr extends LambdaBodyExpr {
	private BlockStmt block;

	@Override
	public <R, A> R accept(GenericVisitor<R, A> v, A arg) {
		return block.accept(v, arg);
	}

	@Override
	public <A> void accept(VoidVisitor<A> v, A arg) {
		block.accept(v, arg);
	}

	public BlockStmt getBlock() {
		return block;
	}

	public void setBlock(BlockStmt block) {
		this.block = block;
	}

}
