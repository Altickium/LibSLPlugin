package com.github.altickium.libslplugin.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.util.ProcessingContext
class LibSLRightHandCompletionProvider : CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        result.addElement(LibSLLookupElements.NULL)
        result.addElement(LibSLLookupElements.TRUE)
        result.addElement(LibSLLookupElements.FALSE)
        result.addElement(LibSLLookupElements.IF)
        result.addElement(LibSLLookupElements.FUN)
        result.addElement(LibSLLookupElements.NEW)
        result.addElement(LibSLLookupElements.CONCEPT)
        result.addElement(LibSLLookupElements.AUTOMATON)
    }
}