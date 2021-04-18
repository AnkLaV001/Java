package Lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Denis", Arrays.asList(new Course("IT"), new Course("English"))),
                new Student("Olga", Arrays.asList(new Course("Math"), new Course("Phisics"),
                        new Course("Testing"))),
                new Student("Anna", Arrays.asList(new Course("IT"), new Course("Biology"),
                        new Course("Testing"))),
                new Student("Aleksey", Arrays.asList(new Course("Math"))),
                new Student("Elena", Arrays.asList(new Course("Phisics"), new Course("English"),
                        new Course("Math"), new Course("History")))
        ));


        System.out.println("Список курсов: " + f1(students));

        System.out.println("Список любохнательных студентов: " + f2(students));

        Course course = new Course("English");
        System.out.println("Студенты ходящие на " + course + " : ");

        System.out.println(students.stream()
                .filter(s -> s.getCourse().contains(course))
                .collect(Collectors.toList()));
    }

    public static Set<String> f1(List<Student> students){
        return students.stream()
                .map(s -> s.getCourse())
                .flatMap(c -> c.stream())
                .distinct()
                .map(g -> g.getName())
                .collect(Collectors.toSet());
    }

    public static List<Student> f2 (List<Student> students){
        return students.stream()
                .sorted((s1, s2) -> s2.getCourse().size() - s1.getCourse().size())
                .limit(3)
                .collect(Collectors.toList());
    }
}
