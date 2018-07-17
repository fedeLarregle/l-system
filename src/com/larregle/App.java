package com.larregle;

import com.larregle.lsystem.LSystem;
import com.larregle.lsystem.Rule;

public class App {
    public static void main(String[] args) throws Exception {
        LSystem.getInstance().generate("F", new Rule('F', "FF+[+F-F-F]-[-F+F+F]"));
    }
}
