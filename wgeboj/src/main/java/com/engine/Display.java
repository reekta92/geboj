package com.engine;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Display extends Canvas {
    private JFrame frame;
    private String title;
    private int width, height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));

        frame = new JFrame(title);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        // Clear screen
        g.clearRect(0, 0, width, height);

        // Draw here

        g.dispose();
        bs.show();
    }

    public Graphics getGraphicsBuffer() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return null;
        }
        return bs.getDrawGraphics();
    }

    public void swapBuffers() {
        BufferStrategy bs = getBufferStrategy();
        if (bs != null) {
            bs.show();
        }
    }
}
