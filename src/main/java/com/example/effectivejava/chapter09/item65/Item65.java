package com.example.effectivejava.chapter09.item65;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class Item65 {
    private static final String treeSet = "java.util.TreeSet";
    private static String[] strings = {"Apple", "Banana", "Coconut"};

    public static void main(String[] args) {
        Class<? extends Set<String>> cl = null;
        try {
          cl = (Class<? extends Set<String>>) Class.forName(treeSet);
        } catch (ClassNotFoundException e) {
          fatalError("클래스를 찾을 수 없습니다.");
        }

        Constructor<? extends Set<String>> cons = null;
        try {
          cons = cl.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
          fatalError("매개변수 없는 생성자를 찾을 수 없습니다.");
        }

        Set<String> s = null;
        try {
          s = cons.newInstance();
        } catch (IllegalAccessException e) {
          fatalError("생성자에 접근할 수 없습니다.");
        } catch (InstantiationException e) {
          fatalError("클래스를 인스턴스화 할 수 없습니다.");
        } catch (InvocationTargetException e) {
          fatalError("생성자가 예외를 던졌습니다." + e.getCause());
        } catch (ClassCastException e) {
          fatalError("Set을 구현하지 않은 클래스입니다.");
        }
        //    s.addAll(Arrays.asList(args).subList(1, args.length));
        s.addAll(Arrays.asList(strings));
        System.out.println(s);
    }

    private static void fatalError(String s) {
        System.err.println(s);
        System.exit(1);
    }
}
