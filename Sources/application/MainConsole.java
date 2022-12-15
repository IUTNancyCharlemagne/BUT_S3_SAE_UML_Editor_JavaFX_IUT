package application;

import composite.FileComposite;
import composite.FileFile;

public class MainConsole {
    public static void main(String[] args) {
        FileComposite root = new FileFile("composite.FileFile",".class");
        System.out.println(root.list());
    }
}

