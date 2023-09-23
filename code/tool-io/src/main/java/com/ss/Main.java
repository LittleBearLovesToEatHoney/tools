package com.ss;

import com.ss.utils.FileUtils;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        InputStream resourceFile = FileUtils.getDirectoryFile("E:/new.html");
        System.out.println(FileUtils.streamToString(resourceFile,true));
    }
}