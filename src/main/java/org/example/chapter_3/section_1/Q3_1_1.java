package org.example.chapter_3.section_1;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Q3_1_1 {

    public static void main(String[] args) {
        SequentialSearchST<String, Double> grades = new SequentialSearchST<>();
        grades.put("A+", 4.33);
        grades.put("A", 4.00);
        grades.put("A-", 3.67);
        grades.put("B+", 3.33);
        grades.put("B", 3.00);
        grades.put("B-", 2.67);
        grades.put("C+", 2.33);
        grades.put("C", 2.00);
        grades.put("C-", 1.67);
        grades.put("D", 1.00);
        grades.put("F", 0.00);

        double total = 0;
        int n = 0;
        while (!StdIn.isEmpty()) {
            String grade = StdIn.readString();
            double value = grades.get(grade);
            total += value;
            n++;
        }
        double gpa = total / n;
        StdOut.println("GPA = " + gpa);

    }
}
