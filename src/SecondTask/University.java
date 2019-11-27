package SecondTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Const {
    public static final int countLessonsPeerDay = 8;
}


public class University {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Student studentIvanov = new Student("Ivan","Ivanov",123);
        Student studentSidorov = new Student("Alexey","Sidorov",456);
        Student studentPupkin = new Student("Vasiliy","Pupkin",789);
        Student studentKuksenko = new Student("Artem","Kuksenko",234);
        Student studentVyatkina = new Student("Alena","Vyatkina",345);

        Group group12 = new Group(12, 1);
        group12.addStudent(studentIvanov);
        group12.addStudent(studentPupkin);


        Group group42 = new Group(42, 4);
        group42.addStudent(studentKuksenko);
        group42.addStudent(studentKuksenko);

        Teacher teacherEgorov = new Teacher("Robert","Egorov","Professor");
        Teacher teacherKazakov = new Teacher("Anton","Kazakov","Professor");
        Teacher teacherKornilov = new Teacher("Filipp","Kornilov","Professor");

        Discipline mathDisp = new Discipline("math",80,teacherEgorov);
        mathDisp.addTeacher(teacherKazakov);

        Discipline javaDisp = new Discipline("java programming",50,teacherEgorov);
        Discipline webDisp = new Discipline("web programming",50,teacherKazakov);
        Discipline prologDisp = new Discipline("swi prolog",50,teacherEgorov);
        Discipline historyDisp = new Discipline("history",40,teacherKornilov);
        Discipline economyDisp = new Discipline("economy",40,teacherKornilov);

        Lesson mathLessn = new Lesson(teacherEgorov,mathDisp,group12);
        Lesson historyLessn = new Lesson(teacherKornilov,historyDisp,group12);
        Lesson economyLessn = new Lesson(teacherKornilov,economyDisp,group12);

        Lesson javaLessn = new Lesson(teacherEgorov,javaDisp,group42);
        Lesson webLessn = new Lesson(teacherKazakov,webDisp,group42);
        Lesson prologLessn = new Lesson(teacherEgorov,prologDisp,group42);

        Day monday = new Day(1);
        monday.addLesson(1,"a305",mathLessn);
        monday.addLesson(2,"a305",historyLessn);
        monday.addLesson(3,"a305",economyLessn);
        monday.addLesson(4,"a305",historyLessn);

        monday.addLesson(1,"131",webLessn);
        monday.addLesson(2,"131",prologLessn);
        monday.addLesson(3,"131",javaLessn);

        Day tuesday = new Day(2);
        tuesday.addLesson(4,"a305",mathLessn);
        tuesday.addLesson(3,"a305",historyLessn);
        tuesday.addLesson(2,"a305",economyLessn);
        tuesday.addLesson(1,"a305",historyLessn);

        tuesday.addLesson(4,"131",webLessn);
        tuesday.addLesson(3,"131",prologLessn);
        tuesday.addLesson(2,"131",javaLessn);

        Shedule shedule = new Shedule();
        shedule.addDay(1,monday);
        shedule.addDay(2,tuesday);

        System.out.println("Получить расписание по учителю");
        monday.giveLessonByTeacher(teacherEgorov);

        in.close();
    }
}


class Person {
    private String name;
    private String surname;
    Person(String name, String surname) {
        this.surname = name;
        this.name = surname;
    }
}

class Teacher extends Person {
    private String grade;
    Teacher(String name, String surname, String grade) {
        super(name, surname);
        this.grade = grade;
    }
}

class Student extends Person {
    private int course = 1;
    private int semester = 1;
    private String grade = "Бакалавр";
    private boolean studying = true;
    private int number;
    private int group;

    Student(String name, String surname, int number) {
        super(name, surname);
        this.number = number;
    }

    public void setGroup(int group) {
        this.group = group;
    }
    public int getGroup() {
        return  this.group;
    }

    public void passSession() {
        if (studying) {
            this.semester++;
            this.course = this.semester / 2;

            if (grade == "Бакалавр")
                if (semester == 8) {
                    this.grade = "Выпускник бакалавриата";
                    this.studying = false;
                }

            if (grade == "Магистр")
                if (semester == 4){
                    this.grade = "Выпускник магистратуры";
                    this.studying = false;
                }
        } else {
            System.out.println("Данный студент не может сдать сессию");
        }
    }

    public void enteryMagistr() {
        if (this.grade == "Выпускник магистратуры"){
            this.studying = true;
            this.course = 1;
            this.semester = 1;
        }
    }

}

class Group{
    private int number;
    private int course;
    private HashSet<Student> students = new HashSet<Student>();
    Group(int number, int course) {
        this.number = number;
        this.course = course;
    }
    public void addStudent(Student student) {
        this.students.add(student);
        student.setGroup(this.number);
    }
    public void removeStudent(Student student) {
        this.students.remove(student);
        student.setGroup(-1);
    }
}

class Discipline {
    private String name;
    private int count;
    private HashSet<Teacher> students = new HashSet<Teacher>();

    Discipline(String name, int count, Teacher teacher) {
        this.name = name;
        this.count = count;
        this.students.add(teacher);
    }

    public void addTeacher(Teacher teacher) {
        this.students.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        this.students.remove(teacher);
    }
}

class Lesson {
    private Teacher teacher;
    private Discipline discipline;
    private Group group;
    Lesson(Teacher teacher, Discipline discipline, Group group) {
        this.teacher = teacher;
        this.discipline = discipline;
        this.group = group;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

}



class Day {
    private HashMap <String,Lesson>[] lessons = new HashMap[Const.countLessonsPeerDay];
    private int number;

    Day(int number) {
        this.number = number;
    }

    public void addLesson(int number, String classRoom, Lesson lesson) {
        this.lessons[number] = new HashMap <String,Lesson>();
        this.lessons[number].put(classRoom, lesson);
    }

    public void giveLessonByTeacher(Teacher teacher) {
        for (int i = 0; i < Const.countLessonsPeerDay; i++) {
            System.out.println(i);
            if( lessons[i] != null)
                for (HashMap.Entry entry : lessons[i].entrySet()) {
                    System.out.println(entry.getValue());
//                    Lesson l = entry.getValue();
//                    if (l.getTeacher() == teacher) {
                        System.out.print("Урок: - ");
                        System.out.println(i);
                        System.out.print("Аудитория: - ");
                        System.out.println(entry.getKey());
//                    }
                }
        }
    }

    public void giveLessonByStudent(Student student) {
        int group = student.getGroup();
        for (int i = 0; i < Const.countLessonsPeerDay; i++) {
            System.out.println(i);
            if( lessons[i] != null)
                for (HashMap.Entry entry : lessons[i].entrySet()) {
                    System.out.println(entry.getValue());
//                    Lesson l = entry.getValue();
//                    if (l.getGroup() == group) {
                    System.out.print("Урок: - ");
                    System.out.println(i);
                    System.out.print("Аудитория: - ");
                    System.out.println(entry.getKey());
//                    }
                }
        }
    }

    public void removeLesson(int number, String classRoom) {
        this.lessons[number].remove(classRoom);
    }

//    public void getLessons()
}

class Shedule {
    private Day[] shedule = new Day[12];
    Shedule(){};

    public void addDay(int number, Day day) {
        this.shedule[number] = day;
    }

}