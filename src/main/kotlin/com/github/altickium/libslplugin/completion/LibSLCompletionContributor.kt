package com.github.altickium.libslplugin.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.PlatformPatterns.*
import com.intellij.patterns.PsiElementPattern
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement
import com.github.altickium.libslplugin.psi.*
import com.github.altickium.libslplugin.psi.parserrules.LibSLAssignmentRight
import com.github.altickium.libslplugin.psi.parserrules.LibSLIdentifierRule
import com.github.altickium.libslplugin.psi.parserrules.LibSLPeriodSeparatedFullName
import com.github.altickium.libslplugin.psi.parserrules.LibSLVariableDecl
import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider

class LibSLCompletionContributor: CompletionContributor() {
    init {
        //extend(CompletionType.BASIC, RIGHT_HAND_IDENTIFIER_PATTERN, LibSLRightHandCompletionProvider())
        extend(CompletionType.BASIC, psiElement(LibSLTypes.Identifier), LibSLRightHandCompletionProvider())
    }
}

// private val MY_TEST =
private val RIGHT_HAND_IDENTIFIER_PATTERN = identifierExpressionWithParent(
    psiElement(LibSLVariableDecl::class.java)
)

private fun identifierExpressionWithParent(parent: PsiElementPattern.Capture<out PsiElement>): PsiElementPattern.Capture<PsiElement> {
    return psiElement(LibSLTypes.Identifier)
        .withParent(
            psiElement(LibSLIdentifierRule::class.java)
                .withParent(
                    psiElement(LibSLPeriodSeparatedFullName::class.java)
                        .withParent(parent)
                )
        )
}