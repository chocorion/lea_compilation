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
Intager_hexa = 0x[0-9A-Fa-f]
//Decimal = ({Integer}(\.{Integer})?)|(\.{Integer})
//Float = [+-]?{Decimal}([eE][+-]?{Integer})?

%%

{Comm}	{}
//Token KEYWORDS
"type" 	        { System.out.print("[TYPE "	 	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_TYPE		, yyline, yycolumn); }
"string" 	    { System.out.print("[STRING "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_STRING	, yyline, yycolumn); }
"integer"		{ System.out.print("[INTEGER "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_INTEGER	, yyline, yycolumn); }
"boolean"		{ System.out.print("[BOOLEAN "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_BOOLEAN	, yyline, yycolumn); }
"array" 	    { System.out.print("[ARRAY "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_ARRAY	, yyline, yycolumn); }
"of"	 	    { System.out.print("[OF] "); 		return new Symbol(Terminals.TOKEN_OF			, yyline, yycolumn); }
"struct"	 	{ System.out.print("[STRUCT] "); 	return new Symbol(Terminals.TOKEN_STRUCT		, yyline, yycolumn); }
"var"	 	    { System.out.print("[VAR] "); 		return new Symbol(Terminals.TOKEN_VAR			, yyline, yycolumn); }
"procedure"	 	{ System.out.print("[PROCEDURE] "); return new Symbol(Terminals.TOKEN_PROCEDURE		, yyline, yycolumn); }
"function"	 	{ System.out.print("[FUNCTION] "); 	return new Symbol(Terminals.TOKEN_FUNCTION		, yyline, yycolumn); }
"begin"	 	    { System.out.print("[BEGIN] "); 	return new Symbol(Terminals.TOKEN_BEGIN			, yyline, yycolumn); }
"end"	 	    { System.out.print("[END] "); 		return new Symbol(Terminals.TOKEN_END			, yyline, yycolumn); }
"new"	 	    { System.out.print("[NEW] "); 		return new Symbol(Terminals.TOKEN_NEW			, yyline, yycolumn); }
"dispose"	 	{ System.out.print("[DISPOSE] "); 	return new Symbol(Terminals.TOKEN_DISPOSE		, yyline, yycolumn); }
"println"	 	{ System.out.print("[PRINTLN] "); 	return new Symbol(Terminals.TOKEN_PRINTLN		, yyline, yycolumn); }
"readln"	 	{ System.out.print("[READLN ] "); 	return new Symbol(Terminals.TOKEN_READLN		, yyline, yycolumn); }
"return"	 	{ System.out.print("[RETURN] "); 	return new Symbol(Terminals.TOKEN_RETURN		, yyline, yycolumn); }
"if"	 	    { System.out.print("[IF] "); 		return new Symbol(Terminals.TOKEN_IF			, yyline, yycolumn); }
"then"	 	    { System.out.print("[THEN] "); 		return new Symbol(Terminals.TOKEN_THEN			, yyline, yycolumn); }
"else"	 	    { System.out.print("[ELSE] "); 		return new Symbol(Terminals.TOKEN_ELSE			, yyline, yycolumn); }
"while"	 	    { System.out.print("[WHILE] "); 	return new Symbol(Terminals.TOKEN_WHILE			, yyline, yycolumn); }
"do"	 	    { System.out.print("[DO] "); 		return new Symbol(Terminals.TOKEN_DO			, yyline, yycolumn); }
"switch"	 	{ System.out.print("[SWITCH ] "); 	return new Symbol(Terminals.TOKEN_SWITCH		, yyline, yycolumn); }
"case"	 	    { System.out.print("[CASE] "); 		return new Symbol(Terminals.TOKEN_CASE			, yyline, yycolumn); }
"default"	 	{ System.out.print("[DEFAULT] "); 	return new Symbol(Terminals.TOKEN_DEFAULT		, yyline, yycolumn); }

//Token PONCTS
"," 	        { System.out.print("[COMMA "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_COMMA		, yyline, yycolumn); }
";" 	        { System.out.print("[SEMI "		+ yytext() + "] "); return new Symbol(Terminals.TOKEN_SEMIC		, yyline, yycolumn); }
".." 	        { System.out.print("[DOTDOT "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_DOTDOT	, yyline, yycolumn); }
":" 	        { System.out.print("[COLON "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_COLON		, yyline, yycolumn); }
"(" 	        { System.out.print("[LPAR "		+ yytext() + "] "); return new Symbol(Terminals.TOKEN_LPAR		, yyline, yycolumn); }
")" 	        { System.out.print("[RPAR "		+ yytext() + "] "); return new Symbol(Terminals.TOKEN_RPAR		, yyline, yycolumn); }
"[" 	        { System.out.print("[LBRACKET "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_LBRACKET	, yyline, yycolumn); }
"]" 	        { System.out.print("[RBRACKET "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_RBRACKET	, yyline, yycolumn); }
"{" 	        { System.out.print("[LBRACE "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_LBRACE	, yyline, yycolumn); }
"}" 	        { System.out.print("[RBRACE "	+ yytext() + "] "); return new Symbol(Terminals.TOKEN_RBRACE	, yyline, yycolumn); }

//Token OPERATORS
"=" 	        { System.out.print("[AFF "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_AFF		, yyline, yycolumn); }
"^" 	        { System.out.print("[CIRC "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_CIRC	, yyline, yycolumn); }
"+" 	        { System.out.print("[PLUS "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_PLUS	, yyline, yycolumn); }
"-" 	        { System.out.print("[MINUS " + yytext() + "] "); return new Symbol(Terminals.TOKEN_MINUS	, yyline, yycolumn); }
"*" 	        { System.out.print("[MULT "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_TIMES	, yyline, yycolumn); }
"/" 	        { System.out.print("[DIV "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_DIV		, yyline, yycolumn); }
"&&" 	        { System.out.print("[AND "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_AND		, yyline, yycolumn); }
"||" 	        { System.out.print("[OR "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_OR 		, yyline, yycolumn); }
"!" 	        { System.out.print("[NOT "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_NOT 	, yyline, yycolumn); }
"<" 	        { System.out.print("[LT "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_LT 		, yyline, yycolumn); }
"<=" 	        { System.out.print("[LE "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_LE 		, yyline, yycolumn); }
">" 	        { System.out.print("[GT "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_GT 		, yyline, yycolumn); }
">=" 	        { System.out.print("[GE "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_GE 		, yyline, yycolumn); }
"==" 	        { System.out.print("[EQ "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_EQ 		, yyline, yycolumn); }
"!=" 	        { System.out.print("[NE "	 + yytext() + "] "); return new Symbol(Terminals.TOKEN_NE 		, yyline, yycolumn); }

//Token LITERALS
{Integer}				   { System.out.print("[LIT_INTEGER	" + yytext() + "] "); return new Symbol(Terminals.TOKEN_LIT_INTEGER , yyline, yycolumn, Integer.parseInt(yytext())); }
{Intager_hexa} 			   { System.out.print("[LIT_INTEGER	" + yytext() + "] "); return new Symbol(Terminals.TOKEN_LIT_INTEGER , yyline, yycolumn, Integer.parseInt(yytext(), 16)); }
{String} 	        	   { System.out.print("[LIT_STRING	" + yytext() + "] "); return new Symbol(Terminals.TOKEN_LIT_STRING 	, yyline, yycolumn, yytext()); }
"true" 	        		   { System.out.print("[TRUE] "); 	return new Symbol(Terminals.TOKEN_TRUE 		, yyline, yycolumn); }
"false" 	        	   { System.out.print("[FALSE] "); 	return new Symbol(Terminals.TOKEN_FALSE 	, yyline, yycolumn); }
"null" 	        		   { System.out.print("[NULL] "); 	return new Symbol(Terminals.TOKEN_NULL 		, yyline, yycolumn); }
{Identifier} 	    	   { System.out.print("[IDENTIFIER " + yytext() + "] "); return new Symbol(Terminals.TOKEN_IDENTIFIER 	, yyline, yycolumn); }

\n {System.out.println(""); }
[^]		{ }
