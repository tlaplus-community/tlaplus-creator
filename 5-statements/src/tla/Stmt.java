package tla;

import java.util.List;

abstract class Stmt {
  interface Visitor<R> {
    R visitOpDefStmt(OpDef stmt);
    R visitPrintStmt(Print stmt);
  }
  static class OpDef extends Stmt {
    OpDef(Token name, Expr body) {
      this.name = name;
      this.body = body;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitOpDefStmt(this);
    }

    final Token name;
    final Expr body;
  }
  static class Print extends Stmt {
    Print(Expr expression) {
      this.expression = expression;
    }

    @Override
    <R> R accept(Visitor<R> visitor) {
      return visitor.visitPrintStmt(this);
    }

    final Expr expression;
  }

  abstract <R> R accept(Visitor<R> visitor);
}
