package com.jiaos.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * @（#）:ClasspathPackageScanner.java
 * @description:
 * @author: jiaosen 2017/11/9
 * @version: Version 1.0
 */
public class ClasspathPackageScanner {
    private String basePackage;

    private ClassLoader cl;

    public ClasspathPackageScanner(String basePackage) {
        this.basePackage = basePackage;
        this.cl = getClass().getClassLoader();



        System.out.println(getClass().getResource(""));
        System.out.println(getClass().getResource("/"));
        System.out.println(this.cl.getResource(""));
        System.out.println(this.cl.getResource("/"));
    }

    public ClasspathPackageScanner(String basePackage, ClassLoader cl) {
        this.basePackage = basePackage;
        this.cl = cl;
    }

    public List<String> getFullQualifiedClassNameList() throws IOException {
        System.out.println("开始扫描" + basePackage + "下的所有包");
        return doScan(basePackage, new ArrayList<>());
    }

    public List<String> doScan(String basePackage, List<String> nameList) {
        String splashPath = StringUtils.doTopSplash(basePackage);

        //从classpath下获取文件
        URL url = cl.getResource(splashPath);
        String filePath = StringUtils.getRootPath(url);

        List<String> names = null;
        if (isJarFile(filePath)) {
            System.out.println(filePath + "是一个jar包");
            System.out.println();
            System.out.println();
            try {
                names = readFromJarFile(filePath, splashPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(filePath + "是一个目录");
            names = readFromDirectory(filePath);
        }

        if(names == null || names.size() <= 0){
            return null;
        }
        for (String name : names) {
            if (isClassFile(name)) {
                nameList.add(toFullQualifiedName(name, basePackage));
            } else {
                doScan(basePackage + "." + name, nameList);
            }
        }

        for (String n : nameList) {
            System.out.println("找到" + n);
        }
        return nameList;
    }

    public String toFullQualifiedName(String shortName, String basePackage) {
        StringBuilder stringBuilder = new StringBuilder(basePackage);
        stringBuilder.append('.');
        stringBuilder.append(StringUtils.trimExtention(shortName));

        return stringBuilder.toString();
    }

    public boolean isJarFile(String filePath) {
        return filePath.endsWith(".jar");
    }

    public List<String> readFromJarFile(String jarPath, String splashPath) throws IOException {
        System.out.println("从jar包中读取类");
        JarInputStream jarInputStream = new JarInputStream(new FileInputStream(jarPath));
        JarEntry entry = jarInputStream.getNextJarEntry();
        List<String> nameList = new ArrayList<>();
        while (null != entry) {
            String name = entry.getName();
            if (name.startsWith(splashPath) && isClassFile(name)) {
                nameList.add(name);
            }
            entry = jarInputStream.getNextJarEntry();
        }
        return nameList;
    }

    public List<String> readFromDirectory(String filePath) {
        File file = new File(filePath);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return Arrays.asList(names);
    }

    public boolean isClassFile(String name) {
        return name.endsWith(".class");
    }

    public static void main(String[] args) throws Exception {
        ClasspathPackageScanner scan = new ClasspathPackageScanner("com.jiaos");
        scan.getFullQualifiedClassNameList();
    }

}
