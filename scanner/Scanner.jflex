package ubordeaux.deptinfo.compilation.project.main;

import beaver.Symbol;
import beaver.Scanner;
import java.lang.String;

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

Comm = \/\*~(\*\/)|\/\/.*
Identifier = [a-zA-Z_][a-zA-Z0-9_]*
String = \"[^\"]{0,64}\"
Integer = [0-9]+
Intager_hexa = 0x[0-9A-Fa-f]+
//Decimal = ({Integer}(\.{Integer})?)|(\.{Integer})
//Float = [+-]?{Decimal}([eE][+-]?{Integer})?

%%

{Comm}	{}
//Token KEYWORDS
"type" 	        { return new Symbol(Terminals.TOKEN_TYPE		, yyline, yycolumn); }
"string" 	    { return new Symbol(Terminals.TOKEN_STRING	, yyline, yycolumn); }
"integer"		{ return new Symbol(Terminals.TOKEN_INTEGER	, yyline, yycolumn); }
"boolean"		{ return new Symbol(Terminals.TOKEN_BOOLEAN	, yyline, yycolumn); }
"array" 	    { return new Symbol(Terminals.TOKEN_ARRAY	, yyline, yycolumn); }
"of"	 	    { return new Symbol(Terminals.TOKEN_OF			, yyline, yycolumn); }
"struct"	 	{ return new Symbol(Terminals.TOKEN_STRUCT		, yyline, yycolumn); }
"var"	 	    { return new Symbol(Terminals.TOKEN_VAR			, yyline, yycolumn); }
"procedure"	 	{ return new Symbol(Terminals.TOKEN_PROCEDURE		, yyline, yycolumn); }
"function"	 	{ return new Symbol(Terminals.TOKEN_FUNCTION		, yyline, yycolumn); }
"begin"	 	    { return new Symbol(Terminals.TOKEN_BEGIN			, yyline, yycolumn); }
"end"	 	    { return new Symbol(Terminals.TOKEN_END			, yyline, yycolumn); }
"new"	 	    { return new Symbol(Terminals.TOKEN_NEW			, yyline, yycolumn); }
"dispose"	 	{ return new Symbol(Terminals.TOKEN_DISPOSE		, yyline, yycolumn); }
"println"	 	{ return new Symbol(Terminals.TOKEN_PRINTLN		, yyline, yycolumn); }
"print"		 	{ return new Symbol(Terminals.TOKEN_PRINT			, yyline, yycolumn); }
"readln"	 	{ return new Symbol(Terminals.TOKEN_READLN		, yyline, yycolumn); }
"return"	 	{ return new Symbol(Terminals.TOKEN_RETURN		, yyline, yycolumn); }
"if"	 	    { return new Symbol(Terminals.TOKEN_IF			, yyline, yycolumn); }
"then"	 	    { return new Symbol(Terminals.TOKEN_THEN			, yyline, yycolumn); }
"else"	 	    { return new Symbol(Terminals.TOKEN_ELSE			, yyline, yycolumn); }
"while"	 	    { return new Symbol(Terminals.TOKEN_WHILE			, yyline, yycolumn); }
"do"	 	    { return new Symbol(Terminals.TOKEN_DO			, yyline, yycolumn); }
"switch"	 	{ return new Symbol(Terminals.TOKEN_SWITCH		, yyline, yycolumn); }
"case"	 	    { return new Symbol(Terminals.TOKEN_CASE			, yyline, yycolumn); }
"default"	 	{ return new Symbol(Terminals.TOKEN_DEFAULT		, yyline, yycolumn); }

//Token PONCTS
"," 	        { return new Symbol(Terminals.TOKEN_COMMA		, yyline, yycolumn); }
";" 	        { return new Symbol(Terminals.TOKEN_SEMIC		, yyline, yycolumn); }
".." 	        { return new Symbol(Terminals.TOKEN_DOTDOT	, yyline, yycolumn); }
":" 	        { return new Symbol(Terminals.TOKEN_COLON		, yyline, yycolumn); }
"(" 	        { return new Symbol(Terminals.TOKEN_LPAR		, yyline, yycolumn); }
")" 	        { return new Symbol(Terminals.TOKEN_RPAR		, yyline, yycolumn); }
"[" 	        { return new Symbol(Terminals.TOKEN_LBRACKET	, yyline, yycolumn); }
"]" 	        { return new Symbol(Terminals.TOKEN_RBRACKET	, yyline, yycolumn); }
"{" 	        { return new Symbol(Terminals.TOKEN_LBRACE	, yyline, yycolumn); }
"}" 	        { return new Symbol(Terminals.TOKEN_RBRACE	, yyline, yycolumn); }

//Token OPERATORS
"=" 	        { return new Symbol(Terminals.TOKEN_AFF		, yyline, yycolumn); }
"^" 	        { return new Symbol(Terminals.TOKEN_CIRC	, yyline, yycolumn); }
"+" 	        { return new Symbol(Terminals.TOKEN_PLUS	, yyline, yycolumn); }
"-" 	        { return new Symbol(Terminals.TOKEN_MINUS	, yyline, yycolumn); }
"*" 	        { return new Symbol(Terminals.TOKEN_TIMES	, yyline, yycolumn); }
"/" 	        { return new Symbol(Terminals.TOKEN_DIV		, yyline, yycolumn); }
"&&" 	        { return new Symbol(Terminals.TOKEN_AND		, yyline, yycolumn); }
"||" 	        { return new Symbol(Terminals.TOKEN_OR 		, yyline, yycolumn); }
"!" 	        { return new Symbol(Terminals.TOKEN_NOT 	, yyline, yycolumn); }
"<" 	        { return new Symbol(Terminals.TOKEN_LT 		, yyline, yycolumn); }
"<=" 	        { return new Symbol(Terminals.TOKEN_LE 		, yyline, yycolumn); }
">" 	        { return new Symbol(Terminals.TOKEN_GT 		, yyline, yycolumn); }
">=" 	        { return new Symbol(Terminals.TOKEN_GE 		, yyline, yycolumn); }
"==" 	        { return new Symbol(Terminals.TOKEN_EQ 		, yyline, yycolumn); }
"!=" 	        { return new Symbol(Terminals.TOKEN_NE 		, yyline, yycolumn); }

//Token LITERALS
{Integer}				   { return new Symbol(Terminals.TOKEN_LIT_INTEGER , yyline, yycolumn, (Integer)Integer.parseInt(yytext())); }
{Intager_hexa} 			   { return new Symbol(Terminals.TOKEN_LIT_INTEGER , yyline, yycolumn, (Integer)Integer.parseInt((yytext().split("0x"))[1], 16)); }
{String} 	        	   { return new Symbol(Terminals.TOKEN_LIT_STRING 	, yyline, yycolumn, yytext().substring(1, yytext().length() - 1)); }
"true" 	        		   { return new Symbol(Terminals.TOKEN_TRUE 		, yyline, yycolumn); }
"false" 	        	   { return new Symbol(Terminals.TOKEN_FALSE 	, yyline, yycolumn); }
"null" 	        		   { return new Symbol(Terminals.TOKEN_NULL 		, yyline, yycolumn); }
{Identifier} 	    	   { return new Symbol(Terminals.TOKEN_IDENTIFIER 	, yyline, yycolumn, yytext()); }

[^]	| \n	{ }