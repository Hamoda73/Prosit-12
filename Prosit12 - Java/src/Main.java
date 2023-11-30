import java.util.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
         Etudiant student1 = new Etudiant(1, "Lamar", 20);
        Etudiant student2 = new Etudiant(2, "Med", 22);
        Etudiant student3 = new Etudiant(3, "Steve", 21);

         List<Etudiant> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);

         StudentManagement studentManagement = new StudentManagement();

         System.out.println("All the students:");
        studentManagement.displayStudents(students, System.out::println);

         System.out.println("\nStudents older than 20:");
        Predicate<Etudiant> filterByAge = student -> student.getAge() > 20;
        studentManagement.displayStudentsByFilter(students, filterByAge, System.out::println);

         System.out.println("\nNames of all the students:");
        Function<Etudiant, String> getStudentName = Etudiant::getNom;
        String allNames = studentManagement.returnStudentsNames(students, getStudentName);
        System.out.println(allNames);

         System.out.println("\nCreate student:");
        Supplier<Etudiant> createNewStudent = () -> new Etudiant(4, "David", 23);
        Etudiant newStudent = studentManagement.createStudent(createNewStudent);
        System.out.println(newStudent);

         System.out.println("\nSort  by ID:");
        Comparator<Etudiant> compareById = Comparator.comparingInt(Etudiant::getId);
        List<Etudiant> sortedStudents = studentManagement.sortStudentsById(students, compareById);
        sortedStudents.forEach(System.out::println);

         System.out.println("\nConverting list to a stream:");
        studentManagement.convertToStream(students).forEach(System.out::println);
    }
}
