package com.engine.graphics;

import com.engine.math.Triangle;
import com.engine.math.Vector3D;
import java.util.ArrayList;
import java.util.List;

public class Mesh {
    public List<Triangle> tris;

    public Mesh() {
        tris = new ArrayList<>();
    }

    public static Mesh createCube() {
        Mesh mesh = new Mesh();

        // SOUTH
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 0.0f, 0.0f), new Vector3D(0.0f, 1.0f, 0.0f),
                new Vector3D(1.0f, 1.0f, 0.0f)));
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 0.0f, 0.0f), new Vector3D(1.0f, 1.0f, 0.0f),
                new Vector3D(1.0f, 0.0f, 0.0f)));

        // EAST
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 0.0f), new Vector3D(1.0f, 1.0f, 0.0f),
                new Vector3D(1.0f, 1.0f, 1.0f)));
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 0.0f), new Vector3D(1.0f, 1.0f, 1.0f),
                new Vector3D(1.0f, 0.0f, 1.0f)));

        // NORTH
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 1.0f), new Vector3D(1.0f, 1.0f, 1.0f),
                new Vector3D(0.0f, 1.0f, 1.0f)));
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 1.0f), new Vector3D(0.0f, 1.0f, 1.0f),
                new Vector3D(0.0f, 0.0f, 1.0f)));

        // WEST
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 0.0f, 1.0f), new Vector3D(0.0f, 1.0f, 1.0f),
                new Vector3D(0.0f, 1.0f, 0.0f)));
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 0.0f, 1.0f), new Vector3D(0.0f, 1.0f, 0.0f),
                new Vector3D(0.0f, 0.0f, 0.0f)));

        // TOP
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 1.0f, 0.0f), new Vector3D(0.0f, 1.0f, 1.0f),
                new Vector3D(1.0f, 1.0f, 1.0f)));
        mesh.tris.add(new Triangle(new Vector3D(0.0f, 1.0f, 0.0f), new Vector3D(1.0f, 1.0f, 1.0f),
                new Vector3D(1.0f, 1.0f, 0.0f)));

        // BOTTOM
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 1.0f), new Vector3D(0.0f, 0.0f, 1.0f),
                new Vector3D(0.0f, 0.0f, 0.0f)));
        mesh.tris.add(new Triangle(new Vector3D(1.0f, 0.0f, 1.0f), new Vector3D(0.0f, 0.0f, 0.0f),
                new Vector3D(1.0f, 0.0f, 0.0f)));

        return mesh;
    }
}
