package org.example.ch02;

public class Method1 {
    public static void main(String[] args) {
        Student student1 = makeStudent("학생1", 15, 90);
        Student student2 = makeStudent("학생2", 16, 80);
        printStudent(student1);
        printStudent(student2);
    }

    static void printStudent(Student student) {
        System.out.println("이름: " + student.name + " 나이:" + student.age + " 성적:" + student.grade);
    }

    public static Student makeStudent(String name, int age, int grade) {
        Student student = new Student();
        student.age = age;
        student.name = name;
        student.grade = grade;
        return student;
    }
}
