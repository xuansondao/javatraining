import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecutantQuanlitifiersRegexExample {
    public static void main(String[] args) {
        String text = "xxxjavaxxxxxxjava ";
        Pattern pattern = Pattern.compile(".*?va");
        Matcher matcher = pattern.matcher(text);

        System.out.println("recutant--->" + matcher.find());
        System.out.println(text.substring(matcher.start(), matcher.end()));
    }
}
