package com.github.altickium.libslplugin.completion

import com.intellij.codeInsight.completion.InsertHandler
import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
object LibSLLookupElements {
    val NULL = keyword("null")
    val TRUE = keyword("true")
    val FALSE = keyword("false")
    val IF = keywordWithParentheses("if")
    val ELSE = keyword("else")
    val SHIFT = keyword("shift")
    val FUN = keyword("fun")
    val CONSTRUCTOR = keyword("constructor")
    val DESTRUCTOR = keyword("destructor")
    val FINISHSTATE = keyword("finishstate")
    val STATE = keyword("state")
    val INITSTATE = keyword("initstate")
    val VAL = keyword("val")
    val ENUM = keyword("enum")
    val ANNOTATION = keywordWithBlock("annotation")
    val CONCEPT = keyword("concept")
    val VAR = keyword("var")
    val NEW = keyword("new")
    val AUTOMATON = keyword("automaton")
    val LIBRARY = keyword("library")
    val VERSION = keyword("version")
    val LANGUAGE = keyword("language")
    val TYPEALIAS = keyword("typealias")
    val TYPE = keyword("type")
    val TYPES = keywordWithBlock("types")
    val IMPORT = keyword("import")

    private fun keyword(keyword: String): LookupElement = LookupElementBuilder.create(keyword).bold()

    private fun keywordWithParentheses(keyword: String): LookupElement {
        return LookupElementBuilder.create("$keyword ()")
            .withInsertHandler(moveCaretRelatively(-1, 0))
            .withPresentableText(keyword).bold()
            .withTailText(" (...)")
    }

    private fun keywordWithBlock(keyword: String): LookupElement {
        return LookupElementBuilder.create("$keyword {\n\n}")
            .withInsertHandler(moveCaretRelatively(-1, -1))
            .withPresentableText(keyword).bold()
            .withTailText(" {...}")
    }

    private fun moveCaretRelatively(columnShift: Int, lineShift: Int): InsertHandler<LookupElement> {
        return InsertHandler { context, _ -> context.editor.caretModel.moveCaretRelatively(columnShift, lineShift, false, false, true) }
    }
}