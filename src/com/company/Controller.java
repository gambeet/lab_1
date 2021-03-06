package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static ArrayList<Student> students = new ArrayList<>();

    private static void showAllStudent() {
        for (Student student : Controller.students) {
            student.showStudentInfo();
        }
    }

    private static void showFreeStudent() {
        for (Student student : Controller.students) {
            if (student.getUserStatus().equalsIgnoreCase("Бюджет"))
                student.showStudentInfo();
        }
    }

    private static void addStudent() {
        ArrayList listMarks = new ArrayList();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = in.nextLine();
        System.out.print("Введите фамилию: ");
        String surname = in.nextLine();
        System.out.print("Введите оценки: ");
        String stringMarks = in.nextLine();

        for (String mark : stringMarks.split(" ")) {
            if (mark.equalsIgnoreCase("a")
                    || mark.equalsIgnoreCase("b")
                    || mark.equalsIgnoreCase("c")
                    || mark.equalsIgnoreCase("d")
                    || mark.equalsIgnoreCase("e"))
            {

                listMarks.add(mark);
            } else {
                try {
                    int numOfMark = Integer.parseInt(mark);
                    if(numOfMark >= 0 && numOfMark <= 100){
                        listMarks.add(numOfMark);
                    } else {
                        System.out.println("ОШИБКА ДОБАВЛЕНИЯ");
                        return;
                    }
                } catch (Exception e){
                    System.out.println("ОШИБКА ДОБАВЛЕНИЯ");
                    return;
                }
            }
        }

        Student newStudent = new Student(name, surname, listMarks);
        Controller.students.add(newStudent);
    }

    static void renderConsoleMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("0. Выход");
            System.out.println("1. Добавить студента");
            System.out.println("2. Показать студентов на стипендии");
            System.out.println("3. Показать всех студентов");

            String input = in.nextLine();
            int changer = 0;
            try {
                changer = Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Проверьте правильность ввода");
                continue;
            }

            switch (changer) {
                case 0:
                    return;

                case 1:
                    addStudent();
                    break;

                case 2:
                    showFreeStudent();
                    break;

                case 3:
                    showAllStudent();
                    break;

                default:
                    System.out.print("Проверьте правильность ввода");
                    break;

            }
        }

    }
}
