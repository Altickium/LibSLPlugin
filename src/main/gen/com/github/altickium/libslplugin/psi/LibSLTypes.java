// This is a generated file. Not intended for manual editing.
package com.github.altickium.libslplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.altickium.libslplugin.psi.impl.*;

public interface LibSLTypes {

  IElementType PROPERTY = new LibSLElementType("PROPERTY");

  IElementType ACTION = new LibSLTokenType("action");
  IElementType ANNOTATION = new LibSLTokenType("annotation");
  IElementType AS = new LibSLTokenType("as");
  IElementType ASSIGNS = new LibSLTokenType("assigns");
  IElementType AT = new LibSLTokenType("@");
  IElementType AUTOMATON = new LibSLTokenType("automaton");
  IElementType BY = new LibSLTokenType("by");
  IElementType COMMENT = new LibSLTokenType("COMMENT");
  IElementType CONCEPT = new LibSLTokenType("concept");
  IElementType CONSTRUCTOR = new LibSLTokenType("constructor");
  IElementType CRLF = new LibSLTokenType("CRLF");
  IElementType DEFINE = new LibSLTokenType("define");
  IElementType DESTRUCTOR = new LibSLTokenType("destructor");
  IElementType ELSE = new LibSLTokenType("else");
  IElementType ENSURES = new LibSLTokenType("ensures");
  IElementType ENUM = new LibSLTokenType("enum");
  IElementType FALSE = new LibSLTokenType("false");
  IElementType FINISHSTATE = new LibSLTokenType("finishstate");
  IElementType FUN = new LibSLTokenType("fun");
  IElementType IF = new LibSLTokenType("if");
  IElementType IMPORT = new LibSLTokenType("import");
  IElementType INCLUDE = new LibSLTokenType("include");
  IElementType INITSTATE = new LibSLTokenType("initstate");
  IElementType IS = new LibSLTokenType("is");
  IElementType KEY = new LibSLTokenType("KEY");
  IElementType LANGUAGE = new LibSLTokenType("language");
  IElementType LIBRARY = new LibSLTokenType("library");
  IElementType LIBSL = new LibSLTokenType("libsl");
  IElementType NEW = new LibSLTokenType("new");
  IElementType NEWLINE = new LibSLTokenType("regexp = (\\r|\\n|\\r\\n)");
  IElementType NULL = new LibSLTokenType("null");
  IElementType PROC = new LibSLTokenType("proc");
  IElementType REQUIRES = new LibSLTokenType("requires");
  IElementType SEPARATOR = new LibSLTokenType("SEPARATOR");
  IElementType SHIFT = new LibSLTokenType("shift");
  IElementType STATE = new LibSLTokenType("state");
  IElementType TRUE = new LibSLTokenType("true");
  IElementType TYPE = new LibSLTokenType("type");
  IElementType TYPEALIAS = new LibSLTokenType("typealias");
  IElementType TYPES = new LibSLTokenType("types");
  IElementType URL = new LibSLTokenType("url");
  IElementType VAL = new LibSLTokenType("val");
  IElementType VALUE = new LibSLTokenType("VALUE");
  IElementType VAR = new LibSLTokenType("var");
  IElementType VERSION = new LibSLTokenType("version");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new LibSLPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
