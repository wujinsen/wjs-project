import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;


public class IKAnaylerRun {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();
        IKSegmenter ik = new IKSegmenter(new StringReader("总裁追妻，大佬哥哥放过我"), false);
        try {
            Lexeme word = null;
            while ((word = ik.next()) != null) {
                result.append(word.getLexemeText()).append(" ");
            }
        } catch (
                IOException ex) {
            throw new RuntimeException(ex);
        }
        System.out.println(result);
    }

}
