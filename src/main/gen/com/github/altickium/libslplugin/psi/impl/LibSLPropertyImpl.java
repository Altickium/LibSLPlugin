// This is a generated file. Not intended for manual editing.
package com.github.altickium.libslplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.altickium.libslplugin.psi.LibSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.altickium.libslplugin.psi.*;

public class LibSLPropertyImpl extends ASTWrapperPsiElement implements LibSLProperty {

  public LibSLPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LibSLVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LibSLVisitor) accept((LibSLVisitor)visitor);
    else super.accept(visitor);
  }

}
