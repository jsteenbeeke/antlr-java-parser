/*
 * Copyright (C) 2007 J�lio Vilmar Gesser.
 *
 * This file is part of Java 1.5 parser and Abstract Syntax Tree.
 *
 * Java 1.5 parser and Abstract Syntax Tree is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Java 1.5 parser and Abstract Syntax Tree is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Java 1.5 parser and Abstract Syntax Tree.  If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Created on 05/10/2006
 */
package com.github.antlrjavaparser.api.visitor;

import com.github.antlrjavaparser.api.CompilationUnit;
import com.github.antlrjavaparser.api.ImportDeclaration;
import com.github.antlrjavaparser.api.PackageDeclaration;
import com.github.antlrjavaparser.api.TypeParameter;
import com.github.antlrjavaparser.api.body.*;
import com.github.antlrjavaparser.api.expr.*;
import com.github.antlrjavaparser.api.stmt.*;
import com.github.antlrjavaparser.api.type.ClassOrInterfaceType;
import com.github.antlrjavaparser.api.type.PrimitiveType;
import com.github.antlrjavaparser.api.type.ReferenceType;
import com.github.antlrjavaparser.api.type.VoidType;
import com.github.antlrjavaparser.api.type.WildcardType;

/**
 * @author Julio Vilmar Gesser
 */
public interface GenericVisitor<R, A> {

	// - Compilation Unit ----------------------------------

	public R visit(CompilationUnit n, A arg);

	public R visit(PackageDeclaration n, A arg);

	public R visit(ImportDeclaration n, A arg);

	public R visit(TypeParameter n, A arg);

	// - Body ----------------------------------------------

	public R visit(ClassOrInterfaceDeclaration n, A arg);

	// public R visit(Comment n, A arg);

	public R visit(EnumDeclaration n, A arg);

	public R visit(EmptyTypeDeclaration n, A arg);

	public R visit(EnumConstantDeclaration n, A arg);

	public R visit(AnnotationDeclaration n, A arg);

	public R visit(AnnotationMemberDeclaration n, A arg);

	public R visit(FieldDeclaration n, A arg);

	public R visit(VariableDeclarator n, A arg);

	public R visit(VariableDeclaratorId n, A arg);

	public R visit(ConstructorDeclaration n, A arg);

	public R visit(MethodDeclaration n, A arg);

	public R visit(Parameter n, A arg);

	public R visit(CatchParameter n, A arg);

	public R visit(Resource n, A arg);

	public R visit(EmptyMemberDeclaration n, A arg);

	public R visit(InitializerDeclaration n, A arg);

	// - Type ----------------------------------------------

	public R visit(ClassOrInterfaceType n, A arg);

	public R visit(PrimitiveType n, A arg);

	public R visit(ReferenceType n, A arg);

	public R visit(VoidType n, A arg);

	public R visit(WildcardType n, A arg);

	// - Expression ----------------------------------------

	public R visit(ArrayAccessExpr n, A arg);

	public R visit(ArrayCreationExpr n, A arg);

	public R visit(ArrayInitializerExpr n, A arg);

	public R visit(AssignExpr n, A arg);

	public R visit(BinaryExpr n, A arg);

	public R visit(CastExpr n, A arg);

	public R visit(ClassExpr n, A arg);

	public R visit(ConditionalExpr n, A arg);

	public R visit(EnclosedExpr n, A arg);

	public R visit(FieldAccessExpr n, A arg);

	public R visit(InstanceOfExpr n, A arg);

	public R visit(StringLiteralExpr n, A arg);

	public R visit(IntegerLiteralExpr n, A arg);

	public R visit(LongLiteralExpr n, A arg);

	public R visit(IntegerLiteralMinValueExpr n, A arg);

	public R visit(LongLiteralMinValueExpr n, A arg);

	public R visit(CharLiteralExpr n, A arg);

	public R visit(DoubleLiteralExpr n, A arg);

	public R visit(BooleanLiteralExpr n, A arg);

	public R visit(NullLiteralExpr n, A arg);

	public R visit(LambdaExpr n, A arg);

	public R visit(SimpleLambdaParameterExpr n, A arg);

	public R visit(FormalLambdaParameterExpr n, A arg);

	public R visit(MethodCallExpr n, A arg);

	public R visit(NameExpr n, A arg);

	public R visit(ObjectCreationExpr n, A arg);

	public R visit(QualifiedNameExpr n, A arg);

	public R visit(ThisExpr n, A arg);

	public R visit(SuperExpr n, A arg);

	public R visit(UnaryExpr n, A arg);

	public R visit(VariableDeclarationExpr n, A arg);

	public R visit(MarkerAnnotationExpr n, A arg);

	public R visit(SingleMemberAnnotationExpr n, A arg);

	public R visit(NormalAnnotationExpr n, A arg);

	public R visit(MemberValuePair n, A arg);

	public R visit(MethodReferenceExpr n, A arg);

	// - Statements ----------------------------------------

	public R visit(ExplicitConstructorInvocationStmt n, A arg);

	public R visit(TypeDeclarationStmt n, A arg);

	public R visit(AssertStmt n, A arg);

	public R visit(BlockStmt n, A arg);

	public R visit(LabeledStmt n, A arg);

	public R visit(EmptyStmt n, A arg);

	public R visit(ExpressionStmt n, A arg);

	public R visit(SwitchStmt n, A arg);

	public R visit(SwitchEntryStmt n, A arg);

	public R visit(BreakStmt n, A arg);

	public R visit(ReturnStmt n, A arg);

	public R visit(IfStmt n, A arg);

	public R visit(WhileStmt n, A arg);

	public R visit(ContinueStmt n, A arg);

	public R visit(DoStmt n, A arg);

	public R visit(ForeachStmt n, A arg);

	public R visit(ForStmt n, A arg);

	public R visit(ThrowStmt n, A arg);

	public R visit(SynchronizedStmt n, A arg);

	public R visit(TryStmt n, A arg);

	public R visit(CatchClause n, A arg);

}
