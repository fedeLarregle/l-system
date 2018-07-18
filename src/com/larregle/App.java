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
        LSystem.getInstance().setIterations(6);
        LSystem.getInstance().generate("X",
                Arrays.asList(
                        new Rule('X', "F[+X][-X]FX"),
                        new Rule('F', "FF")
                ),
                "l-system3.png"
        );
        LSystem.getInstance().setAnglePower(90F);
        LSystem.getInstance().generate("X",
                Arrays.asList(
                        new Rule('X', "-YF+XFX+FY-"),
                        new Rule('Y', "+XF-YFY-FX+")
                ),
                "l-system4.png"
        );
        LSystem.getInstance().setAnglePower(25F);
        LSystem.getInstance().setIterations(LSystem.DEFAULT_ITERATIONS);
        LSystem.getInstance().generate("F", new Rule('F', "F[+F]F[-F][F]"), "l-system5.png");
    }
}
