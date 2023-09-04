package com.github.altickium.libslplugin.lexer;

import com.intellij.lexer.FlexAdapter;

public class LibSLLexerAdapter extends FlexAdapter {
    public  LibSLLexerAdapter(){
        super(new LibSLLexer(null));
    }
}
