package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PathParser {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1735a = "PathParser";

    private static class ExtractFloatResult {

        /* renamed from: a, reason: collision with root package name */
        int f1736a;

        /* renamed from: b, reason: collision with root package name */
        boolean f1737b;

        ExtractFloatResult() {
        }
    }

    private PathParser() {
    }

    private static void a(ArrayList<PathDataNode> arrayList, char c2, float[] fArr) {
        arrayList.add(new PathDataNode(c2, fArr));
    }

    static float[] b(float[] fArr, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i2 < 0 || i2 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i4 = i3 - i2;
        int min = Math.min(i4, length - i2);
        float[] fArr2 = new float[i4];
        System.arraycopy(fArr, i2, fArr2, 0, min);
        return fArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003a A[LOOP:0: B:2:0x0007->B:14:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.f1737b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L37
        L27:
            r10.f1737b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f1737b = r7
            goto L35
        L31:
            r2 = 0
            goto L37
        L33:
            r2 = 1
            goto L37
        L35:
            r2 = 0
            r4 = 1
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f1736a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.c(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            if (pathDataNodeArr[i2].mType != pathDataNodeArr2[i2].mType || pathDataNodeArr[i2].mParams.length != pathDataNodeArr2[i2].mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int e2 = e(str, i2);
            String trim = str.substring(i3, e2).trim();
            if (trim.length() > 0) {
                a(arrayList, trim.charAt(0), d(trim));
            }
            i3 = e2;
            i2 = e2 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a(arrayList, str.charAt(i3), new float[0]);
        }
        return (PathDataNode[]) arrayList.toArray(new PathDataNode[arrayList.size()]);
    }

    public static Path createPathFromPathData(String str) {
        Path path = new Path();
        PathDataNode[] createNodesFromPathData = createNodesFromPathData(str);
        if (createNodesFromPathData == null) {
            return null;
        }
        try {
            PathDataNode.nodesToPath(createNodesFromPathData, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    private static float[] d(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i2 = 1;
            int i3 = 0;
            while (i2 < length) {
                c(str, i2, extractFloatResult);
                int i4 = extractFloatResult.f1736a;
                if (i2 < i4) {
                    fArr[i3] = Float.parseFloat(str.substring(i2, i4));
                    i3++;
                }
                i2 = extractFloatResult.f1737b ? i4 : i4 + 1;
            }
            return b(fArr, 0, i3);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr2[i2] = new PathDataNode(pathDataNodeArr[i2]);
        }
        return pathDataNodeArr2;
    }

    private static int e(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
            pathDataNodeArr[i2].interpolatePathDataNode(pathDataNodeArr2[i2], pathDataNodeArr3[i2], f2);
        }
        return true;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i2 = 0; i2 < pathDataNodeArr2.length; i2++) {
            pathDataNodeArr[i2].mType = pathDataNodeArr2[i2].mType;
            for (int i3 = 0; i3 < pathDataNodeArr2[i2].mParams.length; i3++) {
                pathDataNodeArr[i2].mParams[i3] = pathDataNodeArr2[i2].mParams[i3];
            }
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        PathDataNode(char c2, float[] fArr) {
            this.mType = c2;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            char c4 = c3;
            float f10 = fArr[0];
            float f11 = fArr[1];
            float f12 = fArr[2];
            float f13 = fArr[3];
            float f14 = fArr[4];
            float f15 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case 'l':
                case 'm':
                case 't':
                default:
                    i2 = 2;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f14, f15);
                    f10 = f14;
                    f12 = f10;
                    f11 = f15;
                    f13 = f11;
                    i2 = 2;
                    break;
            }
            float f16 = f10;
            float f17 = f11;
            float f18 = f14;
            float f19 = f15;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr2.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i5], fArr2[i6], fArr2[i7], fArr2[i8]);
                        f16 = fArr2[i7];
                        float f20 = fArr2[i8];
                        float f21 = fArr2[i5];
                        float f22 = fArr2[i6];
                        f17 = f20;
                        f13 = f22;
                        f12 = f21;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path.lineTo(fArr2[i9], f17);
                        f16 = fArr2[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path.quadTo(fArr2[i10], fArr2[i11], fArr2[i12], fArr2[i13]);
                        float f23 = fArr2[i10];
                        float f24 = fArr2[i11];
                        f16 = fArr2[i12];
                        f17 = fArr2[i13];
                        f12 = f23;
                        f13 = f24;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path.lineTo(f16, fArr2[i14]);
                        f17 = fArr2[i14];
                    } else if (c4 != 'a') {
                        if (c4 != 'c') {
                            if (c4 == 'h') {
                                int i15 = i4 + 0;
                                path.rLineTo(fArr2[i15], 0.0f);
                                f16 += fArr2[i15];
                            } else if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i16 = i4 + 0;
                                    path.rLineTo(0.0f, fArr2[i16]);
                                    f5 = fArr2[i16];
                                } else if (c4 == 'L') {
                                    int i17 = i4 + 0;
                                    int i18 = i4 + 1;
                                    path.lineTo(fArr2[i17], fArr2[i18]);
                                    f16 = fArr2[i17];
                                    f17 = fArr2[i18];
                                } else if (c4 == 'M') {
                                    int i19 = i4 + 0;
                                    f16 = fArr2[i19];
                                    int i20 = i4 + 1;
                                    f17 = fArr2[i20];
                                    if (i4 > 0) {
                                        path.lineTo(fArr2[i19], fArr2[i20]);
                                    } else {
                                        path.moveTo(fArr2[i19], fArr2[i20]);
                                        i3 = i4;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c4 == 'S') {
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    float f25 = f17;
                                    int i21 = i4 + 0;
                                    int i22 = i4 + 1;
                                    int i23 = i4 + 2;
                                    int i24 = i4 + 3;
                                    path.cubicTo(f16, f25, fArr2[i21], fArr2[i22], fArr2[i23], fArr2[i24]);
                                    f2 = fArr2[i21];
                                    f3 = fArr2[i22];
                                    f16 = fArr2[i23];
                                    f17 = fArr2[i24];
                                    f12 = f2;
                                    f13 = f3;
                                } else if (c4 == 'T') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f16 = (f16 * 2.0f) - f12;
                                        f17 = (f17 * 2.0f) - f13;
                                    }
                                    int i25 = i4 + 0;
                                    int i26 = i4 + 1;
                                    path.quadTo(f16, f17, fArr2[i25], fArr2[i26]);
                                    float f26 = fArr2[i25];
                                    float f27 = fArr2[i26];
                                    i3 = i4;
                                    f13 = f17;
                                    f12 = f16;
                                    f16 = f26;
                                    f17 = f27;
                                } else if (c4 == 'l') {
                                    int i27 = i4 + 0;
                                    int i28 = i4 + 1;
                                    path.rLineTo(fArr2[i27], fArr2[i28]);
                                    f16 += fArr2[i27];
                                    f5 = fArr2[i28];
                                } else if (c4 == 'm') {
                                    int i29 = i4 + 0;
                                    f16 += fArr2[i29];
                                    int i30 = i4 + 1;
                                    f17 += fArr2[i30];
                                    if (i4 > 0) {
                                        path.rLineTo(fArr2[i29], fArr2[i30]);
                                    } else {
                                        path.rMoveTo(fArr2[i29], fArr2[i30]);
                                        i3 = i4;
                                        f19 = f17;
                                        f18 = f16;
                                    }
                                } else if (c4 == 's') {
                                    if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                        float f28 = f16 - f12;
                                        f6 = f17 - f13;
                                        f7 = f28;
                                    } else {
                                        f7 = 0.0f;
                                        f6 = 0.0f;
                                    }
                                    int i31 = i4 + 0;
                                    int i32 = i4 + 1;
                                    int i33 = i4 + 2;
                                    int i34 = i4 + 3;
                                    path.rCubicTo(f7, f6, fArr2[i31], fArr2[i32], fArr2[i33], fArr2[i34]);
                                    f2 = fArr2[i31] + f16;
                                    f3 = fArr2[i32] + f17;
                                    f16 += fArr2[i33];
                                    f4 = fArr2[i34];
                                } else if (c4 == 't') {
                                    if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                        f8 = f16 - f12;
                                        f9 = f17 - f13;
                                    } else {
                                        f9 = 0.0f;
                                        f8 = 0.0f;
                                    }
                                    int i35 = i4 + 0;
                                    int i36 = i4 + 1;
                                    path.rQuadTo(f8, f9, fArr2[i35], fArr2[i36]);
                                    float f29 = f8 + f16;
                                    float f30 = f9 + f17;
                                    f16 += fArr2[i35];
                                    f17 += fArr2[i36];
                                    f13 = f30;
                                    f12 = f29;
                                }
                                f17 += f5;
                            } else {
                                int i37 = i4 + 0;
                                int i38 = i4 + 1;
                                int i39 = i4 + 2;
                                int i40 = i4 + 3;
                                path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                                f2 = fArr2[i37] + f16;
                                f3 = fArr2[i38] + f17;
                                f16 += fArr2[i39];
                                f4 = fArr2[i40];
                            }
                            i3 = i4;
                        } else {
                            int i41 = i4 + 2;
                            int i42 = i4 + 3;
                            int i43 = i4 + 4;
                            int i44 = i4 + 5;
                            path.rCubicTo(fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                            f2 = fArr2[i41] + f16;
                            f3 = fArr2[i42] + f17;
                            f16 += fArr2[i43];
                            f4 = fArr2[i44];
                        }
                        f17 += f4;
                        f12 = f2;
                        f13 = f3;
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        int i46 = i4 + 6;
                        i3 = i4;
                        c(path, f16, f17, fArr2[i45] + f16, fArr2[i46] + f17, fArr2[i4 + 0], fArr2[i4 + 1], fArr2[i4 + 2], fArr2[i4 + 3] != 0.0f, fArr2[i4 + 4] != 0.0f);
                        f16 += fArr2[i45];
                        f17 += fArr2[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    c(path, f16, f17, fArr2[i47], fArr2[i48], fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i3 + 2], fArr2[i3 + 3] != 0.0f, fArr2[i3 + 4] != 0.0f);
                    f16 = fArr2[i47];
                    f17 = fArr2[i48];
                }
                f13 = f17;
                f12 = f16;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f16;
            fArr[1] = f17;
            fArr[2] = f12;
            fArr[3] = f13;
            fArr[4] = f18;
            fArr[5] = f19;
        }

        private static void b(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = ceil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i2 = 0;
            double d24 = d6;
            double d25 = d7;
            while (i2 < ceil) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d28 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d29 = (d13 * sin3) - (d14 * cos3);
                double d30 = (sin3 * d16) + (cos3 * d17);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sin4 = (Math.sin(d31) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d32 = d24 + (d23 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d32, (float) (d25 + (d22 * sin4)), (float) (d27 - (sin4 * d29)), (float) (d28 - (sin4 * d30)), (float) d27, (float) d28);
                i2++;
                d20 = d20;
                sin = sin;
                d24 = d27;
                d16 = d16;
                cos = cos;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                ceil = ceil;
                d25 = d28;
                d11 = d4;
            }
        }

        private static void c(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z, boolean z2) {
            double d2;
            double d3;
            double radians = Math.toRadians(f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = f2;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = f3;
            Double.isNaN(d6);
            double d7 = f6;
            Double.isNaN(d7);
            double d8 = (d5 + (d6 * sin)) / d7;
            double d9 = -f2;
            Double.isNaN(d9);
            Double.isNaN(d6);
            double d10 = (d9 * sin) + (d6 * cos);
            double d11 = f7;
            Double.isNaN(d11);
            double d12 = d10 / d11;
            double d13 = f4;
            Double.isNaN(d13);
            double d14 = f5;
            Double.isNaN(d14);
            Double.isNaN(d7);
            double d15 = ((d13 * cos) + (d14 * sin)) / d7;
            double d16 = -f4;
            Double.isNaN(d16);
            Double.isNaN(d14);
            Double.isNaN(d11);
            double d17 = ((d16 * sin) + (d14 * cos)) / d11;
            double d18 = d8 - d15;
            double d19 = d12 - d17;
            double d20 = (d8 + d15) / 2.0d;
            double d21 = (d12 + d17) / 2.0d;
            double d22 = (d18 * d18) + (d19 * d19);
            if (d22 == 0.0d) {
                Log.w(PathParser.f1735a, " Points are coincident");
                return;
            }
            double d23 = (1.0d / d22) - 0.25d;
            if (d23 < 0.0d) {
                Log.w(PathParser.f1735a, "Points are too far apart " + d22);
                float sqrt = (float) (Math.sqrt(d22) / 1.99999d);
                c(path, f2, f3, f4, f5, f6 * sqrt, f7 * sqrt, f8, z, z2);
                return;
            }
            double sqrt2 = Math.sqrt(d23);
            double d24 = d18 * sqrt2;
            double d25 = sqrt2 * d19;
            if (z == z2) {
                d2 = d20 - d25;
                d3 = d21 + d24;
            } else {
                d2 = d20 + d25;
                d3 = d21 - d24;
            }
            double atan2 = Math.atan2(d12 - d3, d8 - d2);
            double atan22 = Math.atan2(d17 - d3, d15 - d2) - atan2;
            if (z2 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d7);
            double d26 = d2 * d7;
            Double.isNaN(d11);
            double d27 = d3 * d11;
            b(path, (d26 * cos) - (d27 * sin), (d26 * sin) + (d27 * cos), d7, d11, d4, d6, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                a(path, fArr, c2, pathDataNodeArr[i2].mType, pathDataNodeArr[i2].mParams);
                c2 = pathDataNodeArr[i2].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f2) {
            this.mType = pathDataNode.mType;
            int i2 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i2 >= fArr.length) {
                    return;
                }
                this.mParams[i2] = (fArr[i2] * (1.0f - f2)) + (pathDataNode2.mParams[i2] * f2);
                i2++;
            }
        }

        PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.b(fArr, 0, fArr.length);
        }
    }
}
