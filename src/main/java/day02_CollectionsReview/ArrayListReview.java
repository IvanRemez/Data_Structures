package day02_CollectionsReview;

import java.util.*;

public class ArrayListReview {

    public static void main(String[] args) {

// Create ArrayList and a class

        List<Student> students = new ArrayList<>();

// add elements to ArrayList
        students.add(new Student(1, "Jack"));
        students.add(new Student(2, "Julia"));
        students.add(new Student(3, "Mike"));
        students.add(new Student(4, "Mary"));

// Iterate ArrayList
// 1. For Loop w/ get(index)
        System.out.println("Printing with legacy For Loop--------------");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

// 2. Iterator:
// Forward Iteration
        System.out.println("Printing with Iterator------------------");

        Iterator iterator = students.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
// Backward Iteration
        System.out.println("Printing Backwards with Iterator------------------");

        while (((ListIterator<?>) iterator).hasPrevious()) {
            System.out.println(((ListIterator<?>) iterator).previous());
        }

// 3. For Each loop
        System.out.println("Printing with For Each loop---------------------");

        for (Student student : students) {
            System.out.println(student);
        }

// 4. Lambda
        System.out.println("Printing with Lambda For Each---------------------");

        students.forEach(student -> System.out.println(student));

// Sorting elements in List using Comparator Interface
        System.out.println("Sorting w/ Comparator Interface by ID Descending");

        Collections.sort(students, new sortByIdDescending());
        students.forEach(student -> System.out.println(student));

        System.out.println("Sorting w/ Comparator Interface by Name Descending");

        Collections.sort(students, new sortByNameDescending());
        students.forEach(student -> System.out.println(student));
    }
// Implementation of Comparator
    static class sortByIdDescending implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o2.id - o1.id;
    }
}

    static class sortByNameDescending implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.name.compareToIgnoreCase(o1.name);
        }
    }
}
