package com.xuansondao.lab9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student> filter(List<Student> students, Filter<Student> pred){
        List<Student> list = new ArrayList<>();
        for (Student student : students){
            if(pred.valid(student)) list.add(student);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(25, "Đào Xuân Sơn"));
        students.add(new Student(21, "Lê Công Vũ"));
        students.add(new Student(22, "Đinh Bảo Khánh"));
        students.add(new Student(22, "Lê Bá Nam"));
        students.add(new Student(20, "Nguyễn Thị Ôn"));
        students.add(new Student(24, "Hà Văn Sửu"));
        students.add(new Student(23, "Lê Bá Hữu Trí"));
        students.add(new Student(26, "Đồ Văn Thừ"));

//        Filter<Student> older = student -> student.getAge()>=22;
//        List<Student> filtered = filter(students, older);
//        for (Student student : filtered){
//            System.out.println(student.toString());
//        }
//        filtered.forEach(student -> System.out.println(student.toString()));
//        Stream<Student> stream = students.stream().filter(student -> student.getAge()>=22);
//        stream.forEach(student -> System.out.println(student.toString()));
//        Collections.sort(students, (student1, student2)->{
//            return -(student2.getAge() - student1.getAge());
//        });
//        students.forEach(student -> System.out.println(student.toString()));
//        Stream<Student> stream = students.stream().sorted((student1, student2)->{
//           return -student2.getAge() + student1.getAge() ;
//        });
//        stream.forEach(student -> System.out.println(student.toString());

        Comparator<Student> comparator = (student1, student2)->{ return -student2.getAge() + student1.getAge();};
        Stream<Student> stream = students.stream().sorted(comparator);
        stream.forEach(student -> System.out.println(student.toString()));
        System.out.println("Max is: " + students.stream().max(comparator));
        int sum = students.stream().mapToInt(Student::getAge).sum();
        System.out.println("Average of age is " + sum/students.size());
        students.parallelStream().forEach((it)-> System.out.println(Thread.currentThread().getName() + " hello " + it.getName() ));
    }
}
