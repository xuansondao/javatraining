package com.xuansondao.lab4;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;

public class RobotExample {
    public static void leftClick(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);
    }

    public static void type(Robot robot, String str) {
        byte[] bytes = str.getBytes();
        for (byte ele : bytes
                ) {
            int code = ele;
            if (code > 96 && code < 123) {
                code = code - 32;
            }
            robot.delay(300);
            robot.keyPress(code);
            robot.keyRelease(code);


        }
    }

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.delay(200);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            robot.mouseMove((int) dim.getWidth() / 2, (int) (dim.getHeight() / 2));
            leftClick(robot);
            String userDir = System.getProperty("user.home");
            File file = new File(new File(userDir), "temp.txt");
            if (!(file.exists())) file.createNewFile();
            Desktop.getDesktop().edit(file);
            robot.delay(500);
            type(robot, "Hello,  I am Son handsome");
            robot.delay(5 * 1000);
            System.exit(0);

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
