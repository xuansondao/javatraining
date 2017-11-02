package com.xuansondao.lab7;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchFileNIOExample {
    public static void main(String[] args) {
        Charset charset = Charset.forName("utf-8");
        Pattern pattern = Pattern.compile("s\\S", Pattern.CASE_INSENSITIVE);
        File file = new File("C:\\Temp2\\test1\\io_sample.txt");
        try {
            FileInputStream stream = new FileInputStream(file);
            FileChannel channel = stream.getChannel();

            ByteBuffer bytes = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
            CharBuffer charBuffer = charset.decode(bytes);
            Matcher matcher = pattern.matcher(charBuffer);
            if(matcher.find()){
                System.out.println("Found at " + Integer.toString(matcher.start()));
                System.out.println("Value " + charBuffer.subSequence(matcher.start(), matcher.end()) + "");
            }else {
                System.out.println("Not found");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
