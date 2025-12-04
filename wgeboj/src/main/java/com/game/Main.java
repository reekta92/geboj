package com.game;

import com.engine.Display;
import com.engine.graphics.Mesh;
import com.engine.graphics.Renderer;
import com.engine.math.Matrix4x4;
import java.awt.Color;
import java.awt.Graphics;

public class Main {
    public static void main(String[] args) {
        int width = 800;
        int height = 600;
        Display display = new Display("3D Engine Demo", width, height);
        Renderer renderer = new Renderer(width, height);
        Mesh meshCube = Mesh.createCube();

        // Projection Matrix
        float fNear = 0.1f;
        float fFar = 1000.0f;
        float fFov = 90.0f;
        float fAspectRatio = (float) height / (float) width;
        Matrix4x4 matProj = Matrix4x4.makeProjection(fFov, fAspectRatio, fNear, fFar);

        float fTheta = 0.0f;

        long lastTime = System.nanoTime();

        while (true) {
            long now = System.nanoTime();
            float deltaTime = (now - lastTime) / 1000000000.0f;
            lastTime = now;

            fTheta += 1.0f * deltaTime;

            // Rotation Matrices
            Matrix4x4 matRotZ = Matrix4x4.makeRotationZ(fTheta * 0.5f);
            Matrix4x4 matRotX = Matrix4x4.makeRotationX(fTheta);

            Matrix4x4 matTrans = Matrix4x4.makeTranslation(0.0f, 0.0f, 3.0f);

            Matrix4x4 matWorld;
            matWorld = Matrix4x4.makeIdentity();
            matWorld = Matrix4x4.multiplyMatrix(matRotZ, matRotX);
            matWorld = Matrix4x4.multiplyMatrix(matWorld, matTrans);

            // Render
            Graphics g = display.getGraphicsBuffer();
            if (g != null) {
                // Clear background
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, width, height);

                // Draw Mesh
                renderer.drawMesh(g, meshCube, matProj, matWorld);

                g.dispose();
                display.swapBuffers();
            }

            try {
                Thread.sleep(16); // ~60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
