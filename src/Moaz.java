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
      case IF:
      case FOR:
      case WHILE:
      case PRINT:
      case VAR_:
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
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR_:
      n = Declaration();
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
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
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

  static final public ConditionNode condition() throws ParseException {
  ConditionNode res = new ConditionNode();
  Token t;
  SyntaxTreeNode n1, n2;
    n1 = E();
    t = jj_consume_token(LOGICAL);
    n2 = E();
    res.setOperator(t.image);
    res.addChild(n1);
    res.addChild(n2);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public BlockNode Declaration() throws ParseException {
        BlockNode b = new BlockNode();
    SyntaxTreeNode n = null;
    jj_consume_token(VAR_);
    n = Variable();
      b.addChild(n);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 41:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      jj_consume_token(41);
      n = Variable();
         b.addChild(n);
    }
    jj_consume_token(SEMI);
     {if (true) return b;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode Variable() throws ParseException {
    AssignNode res = new AssignNode();
        Token t;
        SyntaxTreeNode n = null;
    t = jj_consume_token(VAR);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ASSIGN:
      jj_consume_token(ASSIGN);
      n = E();
      break;
    default:
      jj_la1[3] = jj_gen;
      ;
    }
            res.setVariable(t.image);
            res.addChild(n);
            {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

  static final public AssignNode assignstmt() throws ParseException {
  AssignNode res = new AssignNode();
  SyntaxTreeNode n;
  Token t;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case VAR_:
      jj_consume_token(VAR_);
      break;
    default:
      jj_la1[4] = jj_gen;
      ;
    }
    t = jj_consume_token(VAR);
    jj_consume_token(ASSIGN);
    n = E();
    jj_consume_token(SEMI);
    res.setVariable(t.image);
    res.addChild(n);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////// For statment ////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
  static final public ForNode forstmt() throws ParseException {
  ForNode res = new ForNode();
  SyntaxTreeNode c1 = null;
  SyntaxTreeNode c2 = null;
  SyntaxTreeNode c3 = null;
  SyntaxTreeNode c4 = null;
    jj_consume_token(FOR);
    jj_consume_token(LP);
    c1 = assignstmt();
    c2 = condition();
    jj_consume_token(SEMI);
    c3 = E();
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
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
      c4 = SingleOP();
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      res.addChild(c4);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////// while statment ////////////////////////////////////////
//////////////////////  with one statment after it or multi statment //////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
  static final public WhileNode whilestmt() throws ParseException {
  WhileNode res = new WhileNode();
  SyntaxTreeNode c = null;
    jj_consume_token(WHILE);
    jj_consume_token(LP);
    c = condition();
    jj_consume_token(RP);
      res.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
      c = SingleOP();
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
      res.addChild(c);
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////// if else statment ////////////////////////////////////////
//////////////////////with one statment after it or multi statment //////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
  static final public IfNode ifstmt() throws ParseException {
  IfNode res = new IfNode();
  SyntaxTreeNode c = null;
    jj_consume_token(IF);
    jj_consume_token(LP);
    c = condition();
    jj_consume_token(RP);
      res.addChild(c);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LB:
      jj_consume_token(LB);
      c = block();
      jj_consume_token(RB);
      break;
    case IF:
    case FOR:
    case WHILE:
    case PRINT:
    case VAR_:
      c = SingleOP();
      break;
    default:
      jj_la1[7] = jj_gen;
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
      case IF:
      case FOR:
      case WHILE:
      case PRINT:
      case VAR_:
        c = SingleOP();
        break;
      default:
        jj_la1[8] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      res.addChild(c);
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
    {if (true) return res;}
    throw new Error("Missing return statement in function");
  }

///////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////
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
  static final public ExpressionNode E() throws ParseException {
  ExpressionNode n1, n2 = null;
  Token t = null;
    n1 = F();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PLUS:
    case SUB:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        t = jj_consume_token(PLUS);
        break;
      case SUB:
        t = jj_consume_token(SUB);
        break;
      default:
        jj_la1[10] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      n2 = E();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    if (t == null)
    {if (true) return n1;}
    else
    {
      ExpressionNode res = new ExpressionNode();
      res.setOperator(t.image);
      res.addChild(n1);
      res.addChild(n2);
      {if (true) return res;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode F() throws ParseException {
  ExpressionNode n1, n2 = null;
  Token t = null;
    n1 = N();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MULTIPLY:
    case DIV:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLY:
        t = jj_consume_token(MULTIPLY);
        break;
      case DIV:
        t = jj_consume_token(DIV);
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      n2 = F();
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
    if (t == null)
    {if (true) return n1;}
    else
    {
      ExpressionNode res = new ExpressionNode();
      res.setOperator(t.image);
      res.addChild(n1);
      res.addChild(n2);
      {if (true) return res;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionNode N() throws ParseException {
  Token t;
  ExpressionNode e;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      t = jj_consume_token(NUM);
      ConstantNode n = new ConstantNode();
      n.setValue(Double.parseDouble(t.image));
      {if (true) return n;}
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
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
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
  static private int jj_gen;
  static final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0xd500000,0xd500000,0x0,0x20000,0x8000000,0x4d500000,0x4d500000,0x4d500000,0x4d500000,0x200000,0x60,0x60,0x180,0x180,0x10000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x200,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x3,};
   }

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
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MoazTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
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

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[42];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 42; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
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

}
