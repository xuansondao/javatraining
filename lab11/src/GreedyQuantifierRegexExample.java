import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyQuantifierRegexExample {
    public static void main(String[] args) {
        String text = "xxxjavaxxxxxxjava ";
        Pattern pattern = Pattern.compile(".*va",Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher("text");
        System.out.println("greedy------>" + matcher.find());
        try{
            System.out.println(text.substring(matcher.start(), matcher.end()));
            System.out.println("greedy------>" + matcher.find(matcher.end()));
        }catch (IllegalStateException ie){
            System.out.println("Đã có lỗi xảy ra" + ie.getMessage());
        }
    }
}
