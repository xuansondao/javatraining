import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\w+)(\\S+)(\\*.)",Pattern.UNICODE_CHARACTER_CLASS);
        String text = "tôi học java";
        Matcher matcher = pattern.matcher(text);
        System.out.println(matcher.matches());
       try{
           System.out.println(matcher.group(1));
           System.out.println(matcher.group(2));
       }catch (IllegalStateException ie){
           System.out.println("Đã có lỗi xảy ra ở đây "  + ie.getMessage());
       }
    }
}
