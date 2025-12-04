package com.engine.math;

public class Matrix4x4 {
    public float[][] m = new float[4][4];

    public void multiplyVector(Vector3D i, Vector3D o) {
        o.x = i.x * m[0][0] + i.y * m[1][0] + i.z * m[2][0] + m[3][0];
        o.y = i.x * m[0][1] + i.y * m[1][1] + i.z * m[2][1] + m[3][1];
        o.z = i.x * m[0][2] + i.y * m[1][2] + i.z * m[2][2] + m[3][2];
        float w = i.x * m[0][3] + i.y * m[1][3] + i.z * m[2][3] + m[3][3];

        if (w != 0.0f) {
            o.x /= w;
            o.y /= w;
            o.z /= w;
        }
    }

    public static Matrix4x4 makeIdentity() {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = 1.0f;
        matrix.m[1][1] = 1.0f;
        matrix.m[2][2] = 1.0f;
        matrix.m[3][3] = 1.0f;
        return matrix;
    }

    public static Matrix4x4 makeRotationX(float fAngleRad) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = 1.0f;
        matrix.m[1][1] = (float) Math.cos(fAngleRad);
        matrix.m[1][2] = (float) Math.sin(fAngleRad);
        matrix.m[2][1] = (float) -Math.sin(fAngleRad);
        matrix.m[2][2] = (float) Math.cos(fAngleRad);
        matrix.m[3][3] = 1.0f;
        return matrix;
    }

    public static Matrix4x4 makeRotationY(float fAngleRad) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = (float) Math.cos(fAngleRad);
        matrix.m[0][2] = (float) Math.sin(fAngleRad);
        matrix.m[1][1] = 1.0f;
        matrix.m[2][0] = (float) -Math.sin(fAngleRad);
        matrix.m[2][2] = (float) Math.cos(fAngleRad);
        matrix.m[3][3] = 1.0f;
        return matrix;
    }

    public static Matrix4x4 makeRotationZ(float fAngleRad) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = (float) Math.cos(fAngleRad);
        matrix.m[0][1] = (float) Math.sin(fAngleRad);
        matrix.m[1][0] = (float) -Math.sin(fAngleRad);
        matrix.m[1][1] = (float) Math.cos(fAngleRad);
        matrix.m[2][2] = 1.0f;
        matrix.m[3][3] = 1.0f;
        return matrix;
    }

    public static Matrix4x4 makeTranslation(float x, float y, float z) {
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = 1.0f;
        matrix.m[1][1] = 1.0f;
        matrix.m[2][2] = 1.0f;
        matrix.m[3][3] = 1.0f;
        matrix.m[3][0] = x;
        matrix.m[3][1] = y;
        matrix.m[3][2] = z;
        return matrix;
    }

    public static Matrix4x4 makeProjection(float fFovDegrees, float fAspectRatio, float fNear, float fFar) {
        float fFovRad = (float) (1.0f / Math.tan(fFovDegrees * 0.5f / 180.0f * Math.PI));
        Matrix4x4 matrix = new Matrix4x4();
        matrix.m[0][0] = fAspectRatio * fFovRad;
        matrix.m[1][1] = fFovRad;
        matrix.m[2][2] = fFar / (fFar - fNear);
        matrix.m[3][2] = (-fFar * fNear) / (fFar - fNear);
        matrix.m[2][3] = 1.0f;
        matrix.m[3][3] = 0.0f;
        return matrix;
    }

    public static Matrix4x4 multiplyMatrix(Matrix4x4 m1, Matrix4x4 m2) {
        Matrix4x4 matrix = new Matrix4x4();
        for (int c = 0; c < 4; c++)
            for (int r = 0; r < 4; r++)
                matrix.m[r][c] = m1.m[r][0] * m2.m[0][c] + m1.m[r][1] * m2.m[1][c] + m1.m[r][2] * m2.m[2][c]
                        + m1.m[r][3] * m2.m[3][c];
        return matrix;
    }
}
