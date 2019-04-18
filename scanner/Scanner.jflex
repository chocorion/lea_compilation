package ubordeaux.deptinfo.compilation.project.main;

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
String = \"[^\"]{0,64}\"
Integer = [0-9]+
Intager_hexa = 0x[0-9A-Fa-f]{0, 5}
//Decimal = ({Integer}(\.{Integer})?)|(\.{Integer})
//Float = [+-]?{Decimal}([eE][+-]?{Integer})?

%%

{Comm}	{}
//Token KEYWORDS
"type" 	        { System.out.println("TYPE  	-> " + yytext()); return new Symbol(Terminals.TOKEN_TYPE		, yyline, yycolumn); }
"string" 	    { System.out.println("STRING  	-> " + yytext()); return new Symbol(Terminals.TOKEN_STRING		, yyline, yycolumn); }
"integer"		{ System.out.println("INTEGER  	-> " + yytext()); return new Symbol(Terminals.TOKEN_INTEGER		, yyline, yycolumn); }
"boolean"		{ System.out.println("BOOLEAN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_BOOLEAN		, yyline, yycolumn); }
"array" 	    { System.out.println("ARRAY  	-> " + yytext()); return new Symbol(Terminals.TOKEN_ARRAY		, yyline, yycolumn); }
"of"	 	    { System.out.println("OF  		-> " + yytext()); return new Symbol(Terminals.TOKEN_OF			, yyline, yycolumn); }
"struct"	 	{ System.out.println("STRUCT  	-> " + yytext()); return new Symbol(Terminals.TOKEN_STRUCT		, yyline, yycolumn); }
"var"	 	    { System.out.println("VAR  		-> " + yytext()); return new Symbol(Terminals.TOKEN_VAR			, yyline, yycolumn); }
"procedure"	 	{ System.out.println("PROCEDURE	-> " + yytext()); return new Symbol(Terminals.TOKEN_PROCEDURE	, yyline, yycolumn); }
"function"	 	{ System.out.println("FUNCTION	-> " + yytext()); return new Symbol(Terminals.TOKEN_FUNCTION	, yyline, yycolumn); }
"begin"	 	    { System.out.println("BEGIN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_BEGIN		, yyline, yycolumn); }
"end"	 	    { System.out.println("END  		-> " + yytext()); return new Symbol(Terminals.TOKEN_END			, yyline, yycolumn); }
"new"	 	    { System.out.println("NEW  		-> " + yytext()); return new Symbol(Terminals.TOKEN_NEW			, yyline, yycolumn); }
"dispose"	 	{ System.out.println("DISPOSE  	-> " + yytext()); return new Symbol(Terminals.TOKEN_DISPOSE		, yyline, yycolumn); }
"println"	 	{ System.out.println("PRINTLN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_PRINTLN		, yyline, yycolumn); }
"readln"	 	{ System.out.println("READLN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_READLN		, yyline, yycolumn); }
"return"	 	{ System.out.println("RETURN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_RETURN		, yyline, yycolumn); }
"if"	 	    { System.out.println("IF  		-> " + yytext()); return new Symbol(Terminals.TOKEN_IF			, yyline, yycolumn); }
"then"	 	    { System.out.println("THEN  	-> " + yytext()); return new Symbol(Terminals.TOKEN_THEN		, yyline, yycolumn); }
"else"	 	    { System.out.println("ELSE  	-> " + yytext()); return new Symbol(Terminals.TOKEN_ELSE		, yyline, yycolumn); }
"while"	 	    { System.out.println("WHILE  	-> " + yytext()); return new Symbol(Terminals.TOKEN_WHILE		, yyline, yycolumn); }
"do"	 	    { System.out.println("DO  		-> " + yytext()); return new Symbol(Terminals.TOKEN_DO			, yyline, yycolumn); }
"switch"	 	{ System.out.println("SWITCH  	-> " + yytext()); return new Symbol(Terminals.TOKEN_SWITCH		, yyline, yycolumn); }
"case"	 	    { System.out.println("CASE  	-> " + yytext()); return new Symbol(Terminals.TOKEN_CASE		, yyline, yycolumn); }
"default"	 	{ System.out.println("DEFAULT  	-> " + yytext()); return new Symbol(Terminals.TOKEN_DEFAULT		, yyline, yycolumn); }

//Token PONCTS
"," 	        { System.out.println("COMMA  	-> " + yytext()); return new Symbol(Terminals.TOKEN_COMMA		, yyline, yycolumn); }
";" 	        { System.out.println("SEMI   	-> " + yytext()); return new Symbol(Terminals.TOKEN_SEMIC		, yyline, yycolumn); }
".." 	        { System.out.println("DOTDOT 	-> " + yytext()); return new Symbol(Terminals.TOKEN_DOTDOT		, yyline, yycolumn); }
":" 	        { System.out.println("COLON  	-> " + yytext()); return new Symbol(Terminals.TOKEN_COLON		, yyline, yycolumn); }
"(" 	        { System.out.println("LPAR   	-> " + yytext()); return new Symbol(Terminals.TOKEN_LPAR		, yyline, yycolumn); }
")" 	        { System.out.println("RPAR   	-> " + yytext()); return new Symbol(Terminals.TOKEN_RPAR		, yyline, yycolumn); }
"[" 	        { System.out.println("LBRACKET  -> " + yytext()); return new Symbol(Terminals.TOKEN_LBRACKET	, yyline, yycolumn); }
"]" 	        { System.out.println("RBRACKET  -> " + yytext()); return new Symbol(Terminals.TOKEN_RBRACKET	, yyline, yycolumn); }
"{" 	        { System.out.println("LBRACE   	-> " + yytext()); return new Symbol(Terminals.TOKEN_LBRACE		, yyline, yycolumn); }
"}" 	        { System.out.println("RBRACE   	-> " + yytext()); return new Symbol(Terminals.TOKEN_RBRACE		, yyline, yycolumn); }

//Token OPERATORS
"=" 	        { System.out.println("AFF 		-> " + yytext()); return new Symbol(Terminals.TOKEN_AFF		, yyline, yycolumn); }
"^" 	        { System.out.println("CIRC		-> " + yytext()); return new Symbol(Terminals.TOKEN_CIRC	, yyline, yycolumn); }
"+" 	        { System.out.println("PLUS   	-> " + yytext()); return new Symbol(Terminals.TOKEN_PLUS	, yyline, yycolumn); }
"-" 	        { System.out.println("MINUS  	-> " + yytext()); return new Symbol(Terminals.TOKEN_MINUS	, yyline, yycolumn); }
"*" 	        { System.out.println("MULT   	-> " + yytext()); return new Symbol(Terminals.TOKEN_TIMES	, yyline, yycolumn); }
"/" 	        { System.out.println("DIV    	-> " + yytext()); return new Symbol(Terminals.TOKEN_DIV		, yyline, yycolumn); }
"&&" 	        { System.out.println("AND    	-> " + yytext()); return new Symbol(Terminals.TOKEN_AND		, yyline, yycolumn); }
"||" 	        { System.out.println("OR     	-> " + yytext()); return new Symbol(Terminals.TOKEN_OR 		, yyline, yycolumn); }
"!" 	        { System.out.println("NOT    	-> " + yytext()); return new Symbol(Terminals.TOKEN_NOT 	, yyline, yycolumn); }
"<" 	        { System.out.println("LT     	-> " + yytext()); return new Symbol(Terminals.TOKEN_LT 		, yyline, yycolumn); }
"<=" 	        { System.out.println("LE     	-> " + yytext()); return new Symbol(Terminals.TOKEN_LE 		, yyline, yycolumn); }
">" 	        { System.out.println("GT     	-> " + yytext()); return new Symbol(Terminals.TOKEN_GT 		, yyline, yycolumn); }
">=" 	        { System.out.println("GE     	-> " + yytext()); return new Symbol(Terminals.TOKEN_GE 		, yyline, yycolumn); }
"==" 	        { System.out.println("EQ     	-> " + yytext()); return new Symbol(Terminals.TOKEN_EQ 		, yyline, yycolumn); }
"!=" 	        { System.out.println("NE     	-> " + yytext()); return new Symbol(Terminals.TOKEN_NE 		, yyline, yycolumn); }

//Token LITERALS
{Integer} | {Intager_hexa} { System.out.println("LIT_INTEGER   	-> " + yytext()); return new Symbol(Terminals.TOKEN_LIT_INTEGER , yyline, yycolumn); }
{String} 	        	   { System.out.println("LIT_STRING    	-> " + yytext()); return new Symbol(Terminals.TOKEN_LIT_STRING 	, yyline, yycolumn); }
"true" 	        		   { System.out.println("TRUE     		-> " + yytext()); return new Symbol(Terminals.TOKEN_TRUE 		, yyline, yycolumn); }
"false" 	        	   { System.out.println("FALSE     		-> " + yytext()); return new Symbol(Terminals.TOKEN_FALSE 		, yyline, yycolumn); }
"null" 	        		   { System.out.println("NULL     		-> " + yytext()); return new Symbol(Terminals.TOKEN_NULL 		, yyline, yycolumn); }
{Identifier} 	    	   { System.out.println("IDENTIFIER    	-> " + yytext()); return new Symbol(Terminals.TOKEN_IDENTIFIER 	, yyline, yycolumn); }


[^]|\n		{ }
