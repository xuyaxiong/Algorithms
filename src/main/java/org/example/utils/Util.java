package org.example.utils;

import edu.princeton.cs.algs4.Stopwatch;

public class Util {
    public static String getResourcePath(String path) {
        return Util.class.getClassLoader().getResource(path).getPath();
    }

    public static void timeit(Function f) {
        Stopwatch stopwatch = new Stopwatch();
        f.exec();
        double time = stopwatch.elapsedTime();
        System.out.println(time + " seconds");
    }
}
