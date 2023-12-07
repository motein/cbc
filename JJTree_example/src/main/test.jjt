options {
  MULTI=true;
  NODE_PREFIX="";
}

PARSER_BEGIN(Test)
public class Test {
  public static void main(String[] args) throws Exception {
    Test parser = new Test(new java.io.StringReader("class A; class B;"));
    SimpleNode root = parser.Program();
    root.dump("");
  }
}
PARSER_END(Test)

TOKEN :
{
     < CLASS : "class" >
  |  < SCOL  : ";" >
  |  < ID    : (["a"-"z","A"-"Z"])+ >
}

SKIP :
{
  " " | "\t" | "\r" | "\n"
}

SimpleNode Program() #Program : 
{} 
{
  (Class_decl())* <EOF> {return jjtThis;}
}

void Class_decl() #ClassDecl :
{}
{    
  <CLASS> <ID> <SCOL>
}