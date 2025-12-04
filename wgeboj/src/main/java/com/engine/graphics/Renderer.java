package com.engine.graphics;

import com.engine.math.Matrix4x4;
import com.engine.math.Triangle;
import com.engine.math.Vector3D;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

public class Renderer {
    private int width, height;

    public Renderer(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void drawMesh(Graphics g, Mesh mesh, Matrix4x4 matProj, Matrix4x4 matWorld) {
        g.setColor(Color.WHITE);

        for (Triangle tri : mesh.tris) {
            Triangle triProjected = new Triangle();
            Triangle triTransformed = new Triangle();

            // Transform vertices
            for (int i = 0; i < 3; i++) {
                matWorld.multiplyVector(tri.p[i], triTransformed.p[i]);
            }

            // Project vertices from 3D to 2D
            for (int i = 0; i < 3; i++) {
                matProj.multiplyVector(triTransformed.p[i], triProjected.p[i]);

                // Scale into view
                triProjected.p[i].x += 1.0f;
                triProjected.p[i].y += 1.0f;
                triProjected.p[i].x *= 0.5f * (float) width;
                triProjected.p[i].y *= 0.5f * (float) height;
            }

            // Draw triangle (wireframe for now)
            g.drawLine((int) triProjected.p[0].x, (int) triProjected.p[0].y, (int) triProjected.p[1].x,
                    (int) triProjected.p[1].y);
            g.drawLine((int) triProjected.p[1].x, (int) triProjected.p[1].y, (int) triProjected.p[2].x,
                    (int) triProjected.p[2].y);
            g.drawLine((int) triProjected.p[2].x, (int) triProjected.p[2].y, (int) triProjected.p[0].x,
                    (int) triProjected.p[0].y);
        }
    }
}
