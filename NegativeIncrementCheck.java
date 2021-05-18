import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

public class NegativeIncrementCheck extends AbstractCheck {
    private boolean insideCycle = false;
    @Override
    public int[] getDefaultTokens() {
        return new int[]{TokenTypes.LITERAL_FOR, TokenTypes.FOR_ITERATOR, TokenTypes.POST_DEC, TokenTypes.DEC, TokenTypes.MINUS_ASSIGN};
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }

    @Override
    public void visitToken(DetailAST ast) {
        if (ast.getType() == TokenTypes.FOR_ITERATOR) {
           insideCycle = true;
        } else if (insideCycle) {
            checkIncrement(ast);
        }
    }

    private void checkIncrement(DetailAST ast) {
//        if (ast.getType() == TokenTypes.POST_DEC || ast.getType() == TokenTypes.DEC || ast.getType() == TokenTypes.MINUT_ASSIGN) {
        log(ast, "Negative increment:" + ast);
//        }
    }

    public void leaveToken(DetailAST ast) {
        if (ast.getType() == TokenTypes.FOR_ITERATOR) {
            insideCycle = false;
        }
    }


}