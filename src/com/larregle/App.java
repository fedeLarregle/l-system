package com.larregle;

import com.larregle.lsystem.LSystem;
import com.larregle.lsystem.Rule;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        LSystem.getInstance().generate("F", new Rule('F', "FF+[+F-F-F]-[-F+F+F]"));
        LSystem.getInstance().generate("X",
                Arrays.asList(
                        new Rule('X', "F-[[X]+X]+F[+FX]-X"),
                        new Rule('F', "FF")
                ),
                "l-system2.png"
        );
    }
}
