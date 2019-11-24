package SecondTask;
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

    Student(String name, String surname, int number) {
        super(name, surname);
        this.number = number;
    }

    public void PassSession() {
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

    public void EnteryMagistr() {
        if (this.grade == "Выпускник магистратуры"){
            this.studying = true;
            this.course = 1;
            this.semester = 1;
        }
    }

}

class Group{
    private int number;
    private HashSet<Student> students = new HashSet<Student>();
    Group(int number) {
        this.number = number;
    }
    public void AddStudent(Student student) {
        this.students.add(student);
    }
    public void RemoveStudent(Student student) {
        this.students.remove(student);
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
    private int number;
    private String classRoom;
    private Teacher teacher;
    private Discipline discipline;
    private Group group;
    Lesson(int number, String classRoom, Teacher teacher, Discipline discipline, Group group) {
        this.number = number;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.discipline = discipline;
        this.group = group;
    }
}

class Day {
    private Lesson[] lessons = new Lesson[Const.countLessonsPeerDay];
    private int number;

    Day(int number) {
        this.number = number;
    }

    public void addLesson(int number,Lesson lesson) {
        this.lessons[number] = lesson;
    }

    public void removeLesson(int number) {
        this.lessons[number] = null;
    }
}

class Shedule {
    private Day[] shedule = new Day[12];
    Shedule(int number, Day day) {
        this.shedule[number] = day;
    }
}