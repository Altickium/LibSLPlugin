package com.github.altickium.libslplugin.findusageprovider

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.PsiTreeUtil
import com.github.altickium.libslplugin.psi.LibSLTokenSets
import com.github.altickium.libslplugin.psi.LibSLTypes
import com.github.altickium.libslplugin.LibSLFileType
import com.github.altickium.libslplugin.psi.LibSLFile
import com.github.altickium.libslplugin.psi.parserrules.LibSLIdentifierRule

object LibSLElementFactory {
    fun createIdentifierTokenFromText(project: Project, text: String) : PsiElement {
        return createIdentifierFromText(project, text)
            .node
            .findChildByType(LibSLTypes.Identifier)
            ?.psi!!
    }
    fun createIdentifierFromText(project: Project, text: String) : LibSLIdentifierRule {
        val libSlFile = createFileFromText(project, text)
        return PsiTreeUtil.findChildOfType(libSlFile, LibSLIdentifierRule::class.java, true)!!
    }

    fun createFileFromText(project: Project, text: String) : LibSLFile {
        return PsiFileFactory.getInstance(project)
            .createFileFromText("dummy.lsl", LibSLFileType.INSTANCE, text) as LibSLFile
    }
}