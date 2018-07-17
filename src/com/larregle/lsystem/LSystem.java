package com.larregle.lsystem;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LSystem {

    private static final LSystem instance;

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    private int iterations;

    static { instance = new LSystem(); }

    private LSystem() {
        iterations = 5;
    }

    public static LSystem getInstance() { return instance; }

    public void generate(String axiom, Rule rule) throws Exception {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        String sentence = axiom;

        for (int i = 0; i < iterations; i++) {
            StringBuilder nextSentence = new StringBuilder();
            for (int j = 0; j < sentence.length(); j++) {
                if (sentence.charAt(j) == rule.getHaving()) {
                    nextSentence.append(rule.getResults());
                } else {
                    nextSentence.append(sentence.charAt(j));
                }
            }
            sentence = nextSentence.toString();
        }

        drawTree(graphics, sentence);

        ImageIO.write(image, "png", new File("l-system.png"));
    }

    private void drawTree(Graphics2D graphics, String sentence) {
        int x = WIDTH / 2;
        int y = HEIGHT;
        int angle = 90;
        float len = 10F;
        int x2 = x - (int) (Math.cos(Math.toRadians(angle)) * len);
        int y2 = y - (int) (Math.sin(Math.toRadians(angle)) * len);

        Deque<Branch> branches = new LinkedList<>();
        graphics.setColor(Color.WHITE);
        for (int i = 0; i < sentence.length(); i++) {
            graphics.setStroke(new BasicStroke(0.2F));
            if (sentence.charAt(i) == 'F') {
                graphics.drawLine(x, y, x2, y2);
                x = x2;
                y = y2;
            } else if (sentence.charAt(i) == '+') {
                angle += 25;
            } else if (sentence.charAt(i) == '-') {
                angle -= 25;
            } else if (sentence.charAt(i) == '[') {
                branches.addFirst(new Branch(x, y, angle));
            } else if (sentence.charAt(i) == ']') {
                Branch branch = branches.pollFirst();
                if (branch != null) {
                    x = branch.getX();
                    y = branch.getY();
                    angle = branch.getAngle();
                }
            }
            x2 = x - (int) (Math.cos(Math.toRadians(angle)) * len);
            y2 = y - (int) (Math.sin(Math.toRadians(angle)) * len);
        }
    }
}
