/* Generated By:JavaCC: Do not edit this line. Moaz.java */
import nodes.*;

public class Moaz implements MoazConstants {
  public static void main(String args []) throws ParseException
  {
    Moaz parser = new Moaz(System.in);
    SyntaxTreeNode n = start();
    n.execute(new Context());
  }

  static final public BlockNode start() throws ParseException {
  BlockNode b;
    b = block();
    jj_consume_token(COLON);
    {if (true) return b;}
    throw new Error("Missing return statement in function");
  }

  static final public BlockNode block() throws ParseException {
  BlockNode b = new BlockNode();
  SyntaxTreeNode n = null;
    label_1:
    while (true) {
      n = SingleOP();
      b.addChild(n);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SUB:
      case Fact:
      case IF:
      case FOR:
      case WHILE:
      case PRINT:
      case VAR_:
      case Break:
      case Continue:
      case Switch:
      case LP:
      case VAR:
      case INCR:
      case DECR:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case 69:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
    {if (true) return b;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode SingleOP() throws ParseException {
  SyntaxTreeNode n;
    if (jj_2_1(2)) {
      n = Declaration();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Switch:
        n = Switch();
        break;
      case FOR:
        n = forstmt();
        break;
      case WHILE:
        n = whilestmt();
        break;
      case IF:
        n = ifstmt();
        break;
      case PRINT:
        n = printstmt();
        break;
      case Break:
        n = Break();
        break;
      case Continue:
        n = Continue();
        break;
      case SUB:
      case Fact:
      case LP:
      case VAR:
      case INCR:
      case DECR:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case 69:
        n = Unary();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode Unary() throws ParseException {
  SyntaxTreeNode n;
    n = UnaryExpression();
    jj_consume_token(SEMI);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode Continue() throws ParseException {
  ContinueNode n = new ContinueNode();
    jj_consume_token(Continue);
    jj_consume_token(SEMI);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode Break() throws ParseException {
  BreakNode n = new BreakNode();
    jj_consume_token(Break);
    jj_consume_token(SEMI);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public WriteNode printstmt() throws ParseException {
  WriteNode res = new WriteNode();
  SyntaxTreeNode n;
    jj_consume_token(PRINT);
    jj_consume_token(LP);
    n = E();
    jj_consume_token(RP);
    jj_consume_token(SEMI);
    res.addChild(n);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

/*
ConditionNode condition() :
{
  ConditionNode res = new ConditionNode();
  Token t;
  SyntaxTreeNode n1, n2;
}
{
  n1 = E() t = < LOGICAL > n2 = E()
  {
    res.setOperator(t.image);
    res.addChild(n1);
    res.addChild(n2);
    return res;
  }
}
*/
  static final public BlockNode Declaration() throws ParseException {
        BlockNode b = new BlockNode();
    SyntaxTreeNode n = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      n = assignstmt();
      b.addChild(n);
      jj_consume_token(SEMI);
      break;
    case VAR_:
      jj_consume_token(VAR_);
      n = Variable();
      b.addChild(n);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 53:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_2;
        }
        jj_consume_token(53);
        n = Variable();
         b.addChild(n);
      }
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
     {if (true) return b;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode Variable() throws ParseException {
    AssignNode res = new AssignNode();
    Token t1 ,t2;
        SyntaxTreeNode n = null;
    t1 = jj_consume_token(VAR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      t2 = jj_consume_token(ASSIGN);
                                      res.setOp(t2.image);
      n = E();
                                                                     res.addChild(n);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
            res.setVariable(t1.image);
            {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode assignstmt() throws ParseException {
  AssignNode res = new AssignNode();
  SyntaxTreeNode n;
  Token t1 ,t2;
    t1 = jj_consume_token(VAR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ALLASSIGN:
      t2 = jj_consume_token(ALLASSIGN);
      break;
    case ASSIGN:
      t2 = jj_consume_token(ASSIGN);
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    n = E();
    res.setVariable(t1.image);
        res.setOp(t2.image);
    res.addChild(n);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

/////////////////////////////////////// Switch statment ///////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
  static final public SyntaxTreeNode Switch() throws ParseException {
  SwitchNode n = new SwitchNode();
  SyntaxTreeNode c = null;
  Token t;
    jj_consume_token(Switch);
    jj_consume_token(LP);
    t = jj_consume_token(VAR);
    jj_consume_token(RP);
    jj_consume_token(LB);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Case:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      c = Case();
      n.addChild(c);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Default_:
      c = Default();
      n.addChild(c);
      break;
    default:
      jj_la1[7] = jj_gen;
      ;
    }
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Case:
        ;
        break;
      default:
        jj_la1[8] = jj_gen;
        break label_4;
      }
      c = Case();
      n.addChild(c);
    }
    jj_consume_token(RB);
    n.setNameVar(t.image);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode Case() throws ParseException {
  CaseNode n = new CaseNode();
  SyntaxTreeNode c = null;
    jj_consume_token(Case);
    c = E();
    jj_consume_token(COLON);
    n.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case SUB:
    case Fact:
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
    case Break:
    case Continue:
    case Switch:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c = block();
      break;
    default:
      jj_la1[9] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      n.addChild(c);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

  static final public SyntaxTreeNode Default() throws ParseException {
  DefaultNode n = new DefaultNode();
  SyntaxTreeNode c = null;
    jj_consume_token(Default_);
    jj_consume_token(COLON);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case SUB:
    case Fact:
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
    case Break:
    case Continue:
    case Switch:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c = block();
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      n.addChild(c);
    {if (true) return n;}
    throw new Error("Missing return statement in function");
  }

/////////////////////////////////////// For statment //////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
  static final public ForNode forstmt() throws ParseException {
  ForNode res = new ForNode();
  SyntaxTreeNode c1 = null;
  SyntaxTreeNode c2 = null;
  SyntaxTreeNode c3 = null;
  SyntaxTreeNode c4 = null;
    jj_consume_token(FOR);
    jj_consume_token(LP);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR_:
    case VAR:
      c1 = Declaration();
      break;
    case SEMI:
      jj_consume_token(SEMI);
      break;
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SUB:
    case Fact:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c2 = E();
      break;
    default:
      jj_la1[12] = jj_gen;
      ;
    }
    jj_consume_token(SEMI);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR:
      c3 = assignstmt();
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    jj_consume_token(RP);
      res.addChild(c1);
      res.addChild(c2);
      res.addChild(c3);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c4 = block();
      jj_consume_token(RB);
      break;
    case SUB:
    case Fact:
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
    case Break:
    case Continue:
    case Switch:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c4 = SingleOP();
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      res.addChild(c4);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

/////////////////////////////////////// while statment ////////////////////////////////////////
//////////////////////  with one statment after it or multi statment //////////////////////////////
  static final public WhileNode whilestmt() throws ParseException {
  WhileNode res = new WhileNode();
  SyntaxTreeNode c = null;
    jj_consume_token(WHILE);
    jj_consume_token(LP);
    c = E();
    jj_consume_token(RP);
      res.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case SUB:
    case Fact:
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
    case Break:
    case Continue:
    case Switch:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c = SingleOP();
      break;
    default:
      jj_la1[15] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      res.addChild(c);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

/////////////////////////////////////// if else statment ////////////////////////////////////////
//////////////////////with one statment after it or multi statment //////////////////////////////
  static final public IfNode ifstmt() throws ParseException {
  IfNode res = new IfNode();
  SyntaxTreeNode c = null;
    jj_consume_token(IF);
    jj_consume_token(LP);
    c = E();
    jj_consume_token(RP);
      res.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case SUB:
    case Fact:
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
    case Break:
    case Continue:
    case Switch:
    case LP:
    case VAR:
    case INCR:
    case DECR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
    case 69:
      c = SingleOP();
      break;
    default:
      jj_la1[16] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      res.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ELSE:
      jj_consume_token(ELSE);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LB:
        jj_consume_token(LB);
        c = block();
        jj_consume_token(RB);
        break;
      case SUB:
      case Fact:
      case IF:
      case FOR:
      case WHILE:
      case PRINT:
      case VAR_:
      case Break:
      case Continue:
      case Switch:
      case LP:
      case VAR:
      case INCR:
      case DECR:
      case INTEGER_LITERAL:
      case FLOATING_POINT_LITERAL:
      case STRING_LITERAL:
      case BOOLEAN_LITERAL:
      case 69:
        c = SingleOP();
        break;
      default:
        jj_la1[17] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      res.addChild(c);
      break;
    default:
      jj_la1[18] = jj_gen;
      ;
    }
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

/////////////////////////////////////// Begin mathematical ////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
//ExpressionNode increment():
//{
//  ExpressionNode n1,n2 = null;
//  Token t = null;
//}
//{
//  
//  return n1;
//}

/*
ExpressionNode E() :
{
	Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
}
{
  e=AssignmentExpression()
  (
  	t="," e2=AssignmentExpression()
    														{
                                	e = new ExpressionNode( t, e, e2);
                                }
  )*
                                {
                                  return e;
                                }
}


JSExpression AssignmentExpression() :
{
	Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
}
{
  e=ConditionalExpression()
  (
  	( t="=" | t="&&=" | t="||=" | t="+=" | t="-=" | t="*=" | t="/=" | t="&=" | t="|=" | t="^=" | t="%=" | t="<<=" | t=">>=" | t=">>>=" )
    e2=ConditionalExpression()
    														{
                                	e = new ExpressionNode( t, e, e2);
                                }
  )*
                                {
                                  return e;
                                }
}
*/
  static final public ExpressionNode E() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
  ExpressionNode e3;
    e = OrExpression();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 54:
      t = jj_consume_token(54);
      e2 = E();
      jj_consume_token(COLON);
      e3 = E();
      e = new ExpressionNode(t.image, e, e2, e3);
      break;
    default:
      jj_la1[19] = jj_gen;
      ;
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode OrExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = AndExpression();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        ;
        break;
      default:
        jj_la1[20] = jj_gen;
        break label_5;
      }
      t = jj_consume_token(55);
      e2 = AndExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode AndExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = BitwiseOrExpression();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 56:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_6;
      }
      t = jj_consume_token(56);
      e2 = BitwiseOrExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode BitwiseOrExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = BitwiseXorExpression();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 57:
        ;
        break;
      default:
        jj_la1[22] = jj_gen;
        break label_7;
      }
      t = jj_consume_token(57);
      e2 = BitwiseXorExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode BitwiseXorExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = BitwiseAndExpression();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 58:
        ;
        break;
      default:
        jj_la1[23] = jj_gen;
        break label_8;
      }
      t = jj_consume_token(58);
      e2 = BitwiseAndExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode BitwiseAndExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = EqualityExpression();
    label_9:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 59:
        ;
        break;
      default:
        jj_la1[24] = jj_gen;
        break label_9;
      }
      t = jj_consume_token(59);
      e2 = EqualityExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode EqualityExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = RelationalExpression();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
      case 61:
        ;
        break;
      default:
        jj_la1[25] = jj_gen;
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 60:
        t = jj_consume_token(60);
        break;
      case 61:
        t = jj_consume_token(61);
        break;
      default:
        jj_la1[26] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e2 = RelationalExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode RelationalExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = ShiftExpression();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 62:
      case 63:
      case 64:
      case 65:
        ;
        break;
      default:
        jj_la1[27] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 62:
        t = jj_consume_token(62);
        break;
      case 63:
        t = jj_consume_token(63);
        break;
      case 64:
        t = jj_consume_token(64);
        break;
      case 65:
        t = jj_consume_token(65);
        break;
      default:
        jj_la1[28] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e2 = ShiftExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode ShiftExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = AdditiveExpression();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case READ:
      case 66:
      case 67:
        ;
        break;
      default:
        jj_la1[29] = jj_gen;
        break label_12;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 66:
        t = jj_consume_token(66);
        break;
      case READ:
        t = jj_consume_token(READ);
        break;
      case 67:
        t = jj_consume_token(67);
        break;
      default:
        jj_la1[30] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e2 = AdditiveExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode AdditiveExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2;
    e = MultiplicativeExpression();
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case SUB:
        ;
        break;
      default:
        jj_la1[31] = jj_gen;
        break label_13;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        t = jj_consume_token(PLUS);
        break;
      case SUB:
        t = jj_consume_token(SUB);
        break;
      default:
        jj_la1[32] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e2 = MultiplicativeExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode MultiplicativeExpression() throws ParseException {
  Token t;
  ExpressionNode e = null;
  ExpressionNode e2 = null;
    e = UnaryExpression();
    label_14:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
      case DIV:
      case 68:
        ;
        break;
      default:
        jj_la1[33] = jj_gen;
        break label_14;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        t = jj_consume_token(MULTIPLY);
        break;
      case DIV:
        t = jj_consume_token(DIV);
        break;
      case 68:
        t = jj_consume_token(68);
        break;
      default:
        jj_la1[34] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e2 = UnaryExpression();
      e = new ExpressionNode(t.image, e, e2);
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode UnaryExpression() throws ParseException {
  Token t = null;
  ExpressionNode e = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Fact:
    case 69:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case Fact:
        t = jj_consume_token(Fact);
        break;
      case 69:
        t = jj_consume_token(69);
        break;
      default:
        jj_la1[35] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e = UnaryExpression();
      break;
    case SUB:
      t = jj_consume_token(SUB);
      e = UnaryExpression();
      break;
    case INCR:
    case DECR:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
        t = jj_consume_token(INCR);
        break;
      case DECR:
        t = jj_consume_token(DECR);
        break;
      default:
        jj_la1[36] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      e = N();
      break;
    case LP:
    case VAR:
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
      e = N();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INCR:
      case DECR:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INCR:
          t = jj_consume_token(INCR);
          break;
        case DECR:
          t = jj_consume_token(DECR);
          break;
        default:
          jj_la1[37] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        break;
      default:
        jj_la1[38] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
            ExpressionNode res =null;
            if(t == null)
                res=new ExpressionNode(null , e);
            else res=new ExpressionNode(t.image , e);
            {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode N() throws ParseException {
  Token t;
  ExpressionNode e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
    case FLOATING_POINT_LITERAL:
    case STRING_LITERAL:
    case BOOLEAN_LITERAL:
      e = LiteralExpression();
      {if (true) return e;}
      break;
    case LP:
      jj_consume_token(LP);
      e = E();
      jj_consume_token(RP);
      {if (true) return e;}
      break;
    case VAR:
      t = jj_consume_token(VAR);
      VariableNode v = new VariableNode();
      v.setName(t.image);
      {if (true) return v;}
      break;
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode LiteralExpression() throws ParseException {
  ConstantNode e = null;
  Token t = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTEGER_LITERAL:
      t = jj_consume_token(INTEGER_LITERAL);
      e = new ConstantNode(Integer.valueOf(t.image));
      break;
    case FLOATING_POINT_LITERAL:
      t = jj_consume_token(FLOATING_POINT_LITERAL);
      e = new ConstantNode(Double.valueOf(t.image));
      break;
    case STRING_LITERAL:
      t = jj_consume_token(STRING_LITERAL);
      e = new ConstantNode(t.image);
      break;
    case BOOLEAN_LITERAL:
      t = jj_consume_token(BOOLEAN_LITERAL);
      e = new ConstantNode(Boolean.valueOf(t.image));
      break;
    default:
      jj_la1[41] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    {if (true) return e;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_3R_15() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_16()) {
    jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    }
    return false;
  }

  static private boolean jj_3R_16() {
    if (jj_3R_18()) return true;
    return false;
  }

  static private boolean jj_3R_17() {
    if (jj_scan_token(VAR_)) return true;
    if (jj_3R_19()) return true;
    return false;
  }

  static private boolean jj_3R_19() {
    if (jj_scan_token(VAR)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_15()) return true;
    return false;
  }

  static private boolean jj_3R_18() {
    if (jj_scan_token(VAR)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(16)) {
    jj_scanpos = xsp;
    if (jj_scan_token(17)) return true;
    }
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MoazTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[42];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x7d508040,0x75508040,0x0,0x8000000,0x20000,0x30000,0x80000000,0x0,0x80000000,0x7d508040,0x7d508040,0x8040000,0x8040,0x0,0x7d508040,0x7d508040,0x7d508040,0x7d508040,0x200000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x2000000,0x2000000,0x60,0x60,0x180,0x180,0x8000,0x0,0x0,0x0,0x8040,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0xaa0e2,0xaa0e2,0x200000,0x20,0x0,0x0,0x0,0x1,0x0,0xaa0ea,0xaa0ea,0x20,0xaa0e2,0x20,0xaa0ea,0xaa0ea,0xaa0ea,0xaa0ea,0x0,0x400000,0x800000,0x1000000,0x2000000,0x4000000,0x8000000,0x30000000,0x30000000,0xc0000000,0xc0000000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xc0,0xc0,0xc0,0xaa0e2,0xaa022,0xaa000,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0x20,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x20,0x20,0x0,0x20,0x0,0x20,0x20,0x20,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,0x3,0xc,0xc,0x0,0x0,0x10,0x10,0x20,0x0,0x0,0x0,0x20,0x0,0x0,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[1];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Moaz(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Moaz(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MoazTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Moaz(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MoazTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Moaz(MoazTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(MoazTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[70];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 42; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 70; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 1; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
