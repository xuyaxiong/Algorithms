package org.example.utils;

import edu.princeton.cs.algs4.Stopwatch;

public class Util {
    public static String getResourcePath(String path) {
        return Util.class.getClassLoader().getResource(path).getPath();
    }

    public static double timeit(Function f) {
        Stopwatch stopwatch = new Stopwatch();
        f.exec();
        double time = stopwatch.elapsedTime();
//        System.out.println(time + " seconds");
        return time;
    }

    /**
     * @param colour  颜色代号：背景颜色代号(41-46)；前景色代号(31-36)
     * @param type    样式代号：0无；1加粗；3斜体；4下划线
     * @param content 要打印的内容
     */
    public static String getFormatLogString(String content, int colour, int type) {
        boolean hasType = type == 1 || type == 3 || type == 4;
        if (hasType) {
            return String.format("\033[%d;%dm%s\033[0m", colour, type, content);
        } else {
            return String.format("\033[%dm%s\033[0m", colour, content);
        }
    }

    public static String getGreenString(String content) {
        return getFormatLogString(content, 36, 0);
    }

    public static String getRedString(String content) {
        return getFormatLogString(content, 31, 0);
    }
}
