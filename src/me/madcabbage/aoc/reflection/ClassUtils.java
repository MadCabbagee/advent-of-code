package me.madcabbage.aoc.reflection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassUtils {

    public static List<Class<?>> getClasses(String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        String path = packageName.replace('.', '/');
        File packageDirectory = new File(ClassLoader.getSystemResource(path).getFile());

        for (File file : Objects.requireNonNull(packageDirectory.listFiles())) {
            String className = file.getName().replace(".class", "");
            try {
                classes.add(Class.forName(packageName + "." + className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return classes;
    }
}
