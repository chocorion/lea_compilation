import beaver.Symbol;
import beaver.Scanner;

%%

%class ScannerExpr
%extends Scanner
%function nextToken
%type Symbol
%yylexthrow Scanner.Exception
%eofval{
	System.out.println("End of the file !");
	System.out.println(yytext()); return new Symbol(Terminals.EOF);
%eofval}
%unicode
%line
%column

Comm = \/\/~\n
Identifier = [a-zA-Z_][a-zA-Z0-9_]*
Integer = [0-9]+
Decimal = ({Integer}(\.{Integer})?)|(\.{Integer})
Float = [+-]?{Decimal}([eE][+-]?{Integer})?
UFunction = sin|sqrt|round
BFunction = min|max|pow

%%

{Comm}	{}

"+" 	        { System.out.println("PLUS   -> " + yytext()); return new Symbol(Terminals.PLUS	, yyline, yycolumn); }
"-" 	        { System.out.println("MINUS  -> " + yytext()); return new Symbol(Terminals.MINUS, yyline, yycolumn); }
"*" 	        { System.out.println("MULT   -> " + yytext()); return new Symbol(Terminals.MULT	, yyline, yycolumn); }
"/" 	        { System.out.println("DIV    -> " + yytext()); return new Symbol(Terminals.DIV	, yyline, yycolumn); }
"(" 	        { System.out.println("LPAR   -> " + yytext()); return new Symbol(Terminals.LPAR	, yyline, yycolumn); }
")" 	        { System.out.println("RPAR   -> " + yytext()); return new Symbol(Terminals.RPAR	, yyline, yycolumn); }
{UFunction}		{ System.out.println("UFCT   -> " + yytext()); return new Symbol(Terminals.UFCT	, yyline, yycolumn, yytext()); }
{BFunction}		{ System.out.println("BFCT   -> " + yytext()); return new Symbol(Terminals.BFCT	, yyline, yycolumn, yytext()); }
e				{ System.out.println("E      -> " + yytext()); return new Symbol(Terminals.E	, yyline, yycolumn, java.lang.Math.E);  }
pi				{ System.out.println("PI     -> " + yytext()); return new Symbol(Terminals.PI	, yyline, yycolumn, java.lang.Math.PI); }
"=" 	        { System.out.println("EQUALS -> " + yytext()); return new Symbol(Terminals.EQUALS	, yyline, yycolumn); }
"," 	        { System.out.println("COMMA  -> " + yytext()); return new Symbol(Terminals.COMMA	, yyline, yycolumn); }
";" 	        { System.out.println("SEMI   -> " + yytext()); return new Symbol(Terminals.SEMI	, yyline, yycolumn); }

{Integer}		{ System.out.println("INT    -> " + yytext()); return new Symbol(Terminals.INTEGER, yyline, yycolumn, new Integer(yytext())); }
{Float}			{ System.out.println("FLOAT  -> " + yytext()); return new Symbol(Terminals.FLOAT,   yyline, yycolumn, new Double(yytext()));  }
{Identifier}	{ System.out.println("ID     -> " + yytext()); return new Symbol(Terminals.ID, yyline, yycolumn, yytext()); }

[^]|\n		{ }
