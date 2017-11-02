package com.xuansondao.lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FunctionTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
//        students.add(new Student(25, "Đào Xuân Sơn"));
//        students.add(new Student(21, "Lê Công Vũ"));
//        students.add(new Student(22, "Đinh Bảo Khánh"));
//        students.add(new Student(22, "Lê Bá Nam"));
//        students.add(new Student(20, "Nguyễn Thị Ôn"));
//        students.add(new Student(24, "Hà Văn Sửu"));
//        students.add(new Student(23, "Lê Bá Hữu Trí"));
//        students.add(new Student(26, "Đồ Văn Thừ"));
        Consumer<Student> c = (student) -> {
           if(student.getAge() > 22) student.setAge(22);
        } ;
        c.accept(new Student(28, "Nguyễn Khánh An"));

        System.out.println(students.get(0));
    }
}
