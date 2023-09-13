import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;

public abstract class LibSLLexerBase extends Lexer {

    private Token lastToken = null;
    public LibSLLexerBase(CharStream input) {
        super(input);
    }
    @Override
    public String[] getRuleNames() {
        return new String[0];
    }

    @Override
    public String getGrammarFileName() {
        return null;
    }

    @Override
    public Token nextToken() {
        Token next = super.nextToken();

        if (next.getChannel() == Token.DEFAULT_CHANNEL) {
            // Keep track of the last token on the default channel.
            this.lastToken = next;
        }

        return next;
    }

    @Override
    public ATN getATN() {
        return null;
    }
}
