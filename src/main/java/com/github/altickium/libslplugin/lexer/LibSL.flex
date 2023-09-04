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
//%eof{  return;
//%eof}

EOL=\R

NEWLINE=(\r|\n|\r\n)+
WHITESPACE=(\s|\t)+

%%
<YYINITIAL> {
  "import"              { return IMPORT; }
  "include"              { return INCLUDE; }
  "libsl"             { return LIBSL; }
  "library"           { return LIBRARY; }
  "version"               { return VERSION; }
  "language"             { return LANGUAGE; }
  "url"           { return URL; }
  "typealias"                { return TYPEALIAS; }
  "type"                { return TYPE; }
  "types"                { return TYPES; }
  "enum"                { return ENUM; }
  "annotation"                { return ANNOTATION; }
  "BAD_CHARACTER"    { return BAD_CHARACTER; }

  {NEWLINE}         { return NEWLINE; }
  {WHITESPACE}      { return WHITESPACE; }
}

[^] { return BAD_CHARACTER; }