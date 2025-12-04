package com.engine.math;

public class Triangle {
    public Vector3D[] p;

    public Triangle() {
        p = new Vector3D[3];
        p[0] = new Vector3D();
        p[1] = new Vector3D();
        p[2] = new Vector3D();
    }

    public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
        p = new Vector3D[3];
        p[0] = p1;
        p[1] = p2;
        p[2] = p3;
    }
}
