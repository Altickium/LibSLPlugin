// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package com.github.altickium.libslplugin.lexer;


import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.intellij.sdk.language.psi.SimpleTypes;
import com.intellij.psi.TokenType;

%%

%class LibSLLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

/* Newline and whitespace */
NEWLINE=(\r|\n|\r\n)+
WHITESPACE=(\s|\t)+
EOL=\R

/* Operators */
colon                = :
minusArrow           = -> | \u2192
lArrow               = <
rArrow               = >
doubleRightArrow     = => | \u21D2
assign               = =
equal                = ==
dash                 = -
slash                = \/
percent              = %
plus                 = \+
increment            = \+\+
minus                = \-
decrement            = \-\-
pluseq               = \+\=
minuseq              = \-\=
asteriskeq           = \*\=
slasheq              = \/\=
percenteq            = \%\=

exlamationMark       = \!
exlamationEq         = \!\=

/* additional */

lArrowEq             = <=
rArrowEq             = =>
ampersand            = &
dampersand           = &&

/* bit */
bitor                = \|
logicor              = \|\|
xor                  = \^
tilda                = \~
ampersandeq          = \&\=
oreq                 = \|\=
xoreq                = \^\=
rshifteq             = >>=
lshifteq             = <<=
apostrophe           = \\'
backquote            = `

comma                = \,
semicolon            = ;
dot                  = \.
doubleDot            = \.\.
backSlash            = \\
underscore           = _
star                 = \* | \u2605
at                   = @

/* parentheses  */
leftParen            = \(
rightParen           = \)
leftBracket          = \[
rightBracket         = \]
leftBrace            = \{
rightBrace           = \}

LETTER = [:letter:] | "_"
DIGIT =  [:digit:]

IDENT = {LETTER} ({LETTER} | {DIGIT} )*

LINE_COMMENT = "//" [^\r\n]*
MULTILINE_COMMENT = "/*" ( ([^"*"]|[\r\n])* ("*"+ [^"*""/"] )? )* ("*" | "*"+"/")?

STR =      "\""
STRING = {STR} ( [^\"\\\n\r] | "\\" ("\\" | {STR} | {ESCAPES} | [0-8xuU] ) )* {STR}?
ESCAPES = [abfnrtv]

%%
    <YYINITIAL> {
    /* keywords */
          "import"                         { return IMPORT; }
          "include"                        { return INCLUDE; }
          "libsl"                          { return LIBSL; }
          "library"                        { return LIBRARY; }
          "version"                        { return VERSION; }
          "language"                       { return LANGUAGE; }
          "url"                            { return URL; }
          "typealias"                      { return TYPEALIAS; }
          "type"                           { return TYPE; }
          "types"                          { return TYPES; }
          "enum"                           { return ENUM; }
          "annotation"                     { return ANNOTATION; }
          "automaton"                      { return AUTOMATON; }
          "concept"                        { return CONCEPT; }
          "var"                            { return VAR; }
          "val"                            { return VAL; }
          "initstate"                      { return INITSTATE; }
          "state"                          { return STATE; }
          "finishstate"                    { return FINISHSTATE; }
          "shift"                          { return SHIFT; }
          "new"                            { return NEW; }
          "fun"                            { return FUN; }
          "constructor"                    { return CONSTRUCTOR; }
          "destructor"                     { return DESTRUCTOR; }
          "proc"                           { return PROC; }
          {at}                             { return AT; }
          "action"                         { return ACTION; }
          "requires"                       { return REQUIRES; }
          "ensures"                        { return ENSURES; }
          "assigns"                        { return ASSIGNS; }
          "true"                           { return TRUE; }
          "false"                          { return FALSE; }
          "define"                         { return DEFINE; }
          "if"                             { return IF; }
          "else"                           { return ELSE; }
          "by"                             { return BY; }
          "is"                             { return IS; }
          "as"                             { return AS; }
          "null"                           { return NULL; }


      /* parentheses */
              {leftParen}                  { return L_BRACKET; }
              {rightParen}                 { return R_BRACKET; }
              {leftBracket}                { return L_SQUARE_BRACKET; }
              {rightBracket}               { return R_SQUARE_BRACKET; }
              {leftBrace}                  { return L_BRACE; }
              {rightBrace}                 { return R_BRACE; }

      /* First three */
              {semicolon}                  { return SEMICOLON; }
              {assign}                     { return ASSIGN_OP; }
              {equal}                      { return EQ; }

      /* parentheses */
              {leftParen}                  { return L_BRACKET; }
              {rightParen}                 { return R_BRACKET; }
              {leftBracket}                { return L_SQUARE_BRACKET; }
              {rightBracket}               { return R_SQUARE_BRACKET; }
              {leftBrace}                  { return L_BRACE; }
              {rightBrace}                 { return R_BRACE; }

      /* special symbols */
              {dot}                        { return DOT; }
              {colon}                      { return COLON; }
              {comma}                      { return COMMA; }
              {minusArrow}                 { return MINUS_ARROW; }
              {lArrow}                     { return L_ARROW; }
              {rArrow}                     { return R_ARROW; }
              {star}                       { return ASTERISK; }
              {slash}                      { return SLASH; }
              {percent}                    { return PERCENT; }
              {plus}                       { return PLUS; }
              {minus}                      { return MINUS; }
              {increment}                  { return INCREMENT; }
              {decrement}                  { return DECREMENT; }
              {pluseq}                     { return PLUS_EQ; }
              {minuseq}                    { return MINUS_EQ; }
              {asteriskeq}                 { return ASTERISK_EQ; }
              {slasheq}                    { return SLASH_EQ; }
              {percenteq}                  { return PERCENT_EQ; }
              {exlamationMark}             { return EXLAMATION; }
              {exlamationEq}               { return EXLAMATION_EQ; }

      /* additional */
              {lArrowEq}                   { return L_ARROW_EQ; }
              {rArrowEq}                   { return R_ARROW_EQ; }
              {ampersand}                  { return AMPERSAND; }
              {dampersand}                 { return DOUBLE_AMPERSAND; }

      /* bit */
              {bitor}                      { return BIT_OR; }
              {logicor}                    { return LOGIC_OR; }
              {xor}                        { return XOR; }
              {tilda}                      { return TILDE; }
              {ampersandeq}                { return AMPERSAND_EQ; }
              {oreq}                       { return OR_EQ; }
              {xoreq}                      { return XOR_EQ; }
              {rshifteq}                   { return R_SHIFT_EQ; }
              {lshifteq}                   { return L_SHIFT_EQ; }
              {apostrophe}                 { return APOSTROPHE; }
              {backquote}                  { return BACK_QUOTE; }

      {NEWLINE}         { return NEWLINE; }
      {WHITESPACE}      { return WHITESPACE; }

      {IDENT}                                   {return Identifier; }
      {STRING}                                  {return DoubleQuotedString; }

      {LINE_COMMENT}                            { return LINE_COMMENT; }
      {MULTILINE_COMMENT}                       { return COMMENT; }
}

[^] { return BAD_CHARACTER; }