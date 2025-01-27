package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import l5.c;

/* loaded from: classes.dex */
public class PathParser {
    private static final String LOGTAG = "PathParser";

    public static class ExtractFloatResult {
        int mEndPosition;
        boolean mEndWithNegOrDot;
    }

    private PathParser() {
    }

    private static void addNode(ArrayList<PathDataNode> arrayList, char c10, float[] fArr) {
        arrayList.add(new PathDataNode(c10, fArr));
    }

    public static boolean canMorph(@Nullable PathDataNode[] pathDataNodeArr, @Nullable PathDataNode[] pathDataNodeArr2) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr.length != pathDataNodeArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            PathDataNode pathDataNode = pathDataNodeArr[i10];
            char c10 = pathDataNode.mType;
            PathDataNode pathDataNode2 = pathDataNodeArr2[i10];
            if (c10 != pathDataNode2.mType || pathDataNode.mParams.length != pathDataNode2.mParams.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] copyOfRange(float[] fArr, int i10, int i11) {
        if (i10 > i11) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int min = Math.min(i12, length - i10);
        float[] fArr2 = new float[i12];
        System.arraycopy(fArr, i10, fArr2, 0, min);
        return fArr2;
    }

    public static PathDataNode[] createNodesFromPathData(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int nextStart = nextStart(str, i10);
            String trim = str.substring(i11, nextStart).trim();
            if (trim.length() > 0) {
                addNode(arrayList, trim.charAt(0), getFloats(trim));
            }
            i11 = nextStart;
            i10 = nextStart + 1;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            addNode(arrayList, str.charAt(i11), new float[0]);
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
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing " + str, e10);
        }
    }

    public static PathDataNode[] deepCopyNodes(PathDataNode[] pathDataNodeArr) {
        if (pathDataNodeArr == null) {
            return null;
        }
        PathDataNode[] pathDataNodeArr2 = new PathDataNode[pathDataNodeArr.length];
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr2[i10] = new PathDataNode(pathDataNodeArr[i10]);
        }
        return pathDataNodeArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void extract(java.lang.String r8, int r9, androidx.core.graphics.PathParser.ExtractFloatResult r10) {
        /*
            r0 = 0
            r10.mEndWithNegOrDot = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L36
        L27:
            r10.mEndWithNegOrDot = r7
        L29:
            r2 = 0
            r4 = 1
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.mEndWithNegOrDot = r7
            goto L29
        L33:
            r2 = 0
            goto L36
        L35:
            r2 = 1
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.mEndPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.PathParser.extract(java.lang.String, int, androidx.core.graphics.PathParser$ExtractFloatResult):void");
    }

    private static float[] getFloats(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            ExtractFloatResult extractFloatResult = new ExtractFloatResult();
            int length = str.length();
            int i10 = 1;
            int i11 = 0;
            while (i10 < length) {
                extract(str, i10, extractFloatResult);
                int i12 = extractFloatResult.mEndPosition;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                i10 = extractFloatResult.mEndWithNegOrDot ? i12 : i12 + 1;
            }
            return copyOfRange(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e10);
        }
    }

    public static boolean interpolatePathDataNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2, PathDataNode[] pathDataNodeArr3, float f10) {
        if (pathDataNodeArr == null || pathDataNodeArr2 == null || pathDataNodeArr3 == null) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes cannot be null");
        }
        if (pathDataNodeArr.length != pathDataNodeArr2.length || pathDataNodeArr2.length != pathDataNodeArr3.length) {
            throw new IllegalArgumentException("The nodes to be interpolated and resulting nodes must have the same length");
        }
        if (!canMorph(pathDataNodeArr2, pathDataNodeArr3)) {
            return false;
        }
        for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
            pathDataNodeArr[i10].interpolatePathDataNode(pathDataNodeArr2[i10], pathDataNodeArr3[i10], f10);
        }
        return true;
    }

    private static int nextStart(String str, int i10) {
        while (i10 < str.length()) {
            char charAt = str.charAt(i10);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static void updateNodes(PathDataNode[] pathDataNodeArr, PathDataNode[] pathDataNodeArr2) {
        for (int i10 = 0; i10 < pathDataNodeArr2.length; i10++) {
            pathDataNodeArr[i10].mType = pathDataNodeArr2[i10].mType;
            int i11 = 0;
            while (true) {
                float[] fArr = pathDataNodeArr2[i10].mParams;
                if (i11 < fArr.length) {
                    pathDataNodeArr[i10].mParams[i11] = fArr[i11];
                    i11++;
                }
            }
        }
    }

    public static class PathDataNode {
        public float[] mParams;
        public char mType;

        public PathDataNode(char c10, float[] fArr) {
            this.mType = c10;
            this.mParams = fArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        private static void addCommand(Path path, float[] fArr, char c10, char c11, float[] fArr2) {
            int i10;
            int i11;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            char c12 = c11;
            float f18 = fArr[0];
            float f19 = fArr[1];
            float f20 = fArr[2];
            float f21 = fArr[3];
            float f22 = fArr[4];
            float f23 = fArr[5];
            switch (c12) {
                case 'A':
                case 'a':
                    i10 = 7;
                    break;
                case 'C':
                case 'c':
                    i10 = 6;
                    break;
                case 'H':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_BACKUP_URLS /* 86 */:
                case 'h':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_START_TOAST /* 118 */:
                    i10 = 1;
                    break;
                case 'L':
                case 'M':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXTRA_VALUE /* 84 */:
                case 'l':
                case 'm':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXECUTOR_GROUP /* 116 */:
                default:
                    i10 = 2;
                    break;
                case 'Q':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_GET_EXPECT_FILE_LENGTH /* 83 */:
                case 'q':
                case TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY /* 115 */:
                    i10 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path.moveTo(f22, f23);
                    f18 = f22;
                    f20 = f18;
                    f19 = f23;
                    f21 = f19;
                    i10 = 2;
                    break;
            }
            float f24 = f18;
            float f25 = f19;
            float f26 = f22;
            float f27 = f23;
            int i12 = 0;
            char c13 = c10;
            while (i12 < fArr2.length) {
                if (c12 != 'A') {
                    if (c12 == 'C') {
                        i11 = i12;
                        int i13 = i11 + 2;
                        int i14 = i11 + 3;
                        int i15 = i11 + 4;
                        int i16 = i11 + 5;
                        path.cubicTo(fArr2[i11], fArr2[i11 + 1], fArr2[i13], fArr2[i14], fArr2[i15], fArr2[i16]);
                        f24 = fArr2[i15];
                        float f28 = fArr2[i16];
                        float f29 = fArr2[i13];
                        float f30 = fArr2[i14];
                        f25 = f28;
                        f21 = f30;
                        f20 = f29;
                    } else if (c12 == 'H') {
                        i11 = i12;
                        path.lineTo(fArr2[i11], f25);
                        f24 = fArr2[i11];
                    } else if (c12 == 'Q') {
                        i11 = i12;
                        int i17 = i11 + 1;
                        int i18 = i11 + 2;
                        int i19 = i11 + 3;
                        path.quadTo(fArr2[i11], fArr2[i17], fArr2[i18], fArr2[i19]);
                        float f31 = fArr2[i11];
                        float f32 = fArr2[i17];
                        f24 = fArr2[i18];
                        f25 = fArr2[i19];
                        f20 = f31;
                        f21 = f32;
                    } else if (c12 == 'V') {
                        i11 = i12;
                        path.lineTo(f24, fArr2[i11]);
                        f25 = fArr2[i11];
                    } else if (c12 != 'a') {
                        if (c12 != 'c') {
                            if (c12 == 'h') {
                                path.rLineTo(fArr2[i12], 0.0f);
                                f24 += fArr2[i12];
                            } else if (c12 != 'q') {
                                if (c12 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i12]);
                                    f13 = fArr2[i12];
                                } else if (c12 == 'L') {
                                    int i20 = i12 + 1;
                                    path.lineTo(fArr2[i12], fArr2[i20]);
                                    f24 = fArr2[i12];
                                    f25 = fArr2[i20];
                                } else if (c12 == 'M') {
                                    f24 = fArr2[i12];
                                    f25 = fArr2[i12 + 1];
                                    if (i12 > 0) {
                                        path.lineTo(f24, f25);
                                    } else {
                                        path.moveTo(f24, f25);
                                        i11 = i12;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 'S') {
                                    if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    float f33 = f25;
                                    float f34 = f24;
                                    int i21 = i12 + 1;
                                    int i22 = i12 + 2;
                                    int i23 = i12 + 3;
                                    path.cubicTo(f34, f33, fArr2[i12], fArr2[i21], fArr2[i22], fArr2[i23]);
                                    f10 = fArr2[i12];
                                    f11 = fArr2[i21];
                                    f24 = fArr2[i22];
                                    f25 = fArr2[i23];
                                    f20 = f10;
                                    f21 = f11;
                                } else if (c12 == 'T') {
                                    if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                        f24 = (f24 * 2.0f) - f20;
                                        f25 = (f25 * 2.0f) - f21;
                                    }
                                    int i24 = i12 + 1;
                                    path.quadTo(f24, f25, fArr2[i12], fArr2[i24]);
                                    i11 = i12;
                                    f21 = f25;
                                    f20 = f24;
                                    f24 = fArr2[i12];
                                    f25 = fArr2[i24];
                                } else if (c12 == 'l') {
                                    int i25 = i12 + 1;
                                    path.rLineTo(fArr2[i12], fArr2[i25]);
                                    f24 += fArr2[i12];
                                    f13 = fArr2[i25];
                                } else if (c12 == 'm') {
                                    float f35 = fArr2[i12];
                                    f24 += f35;
                                    float f36 = fArr2[i12 + 1];
                                    f25 += f36;
                                    if (i12 > 0) {
                                        path.rLineTo(f35, f36);
                                    } else {
                                        path.rMoveTo(f35, f36);
                                        i11 = i12;
                                        f27 = f25;
                                        f26 = f24;
                                    }
                                } else if (c12 == 's') {
                                    if (c13 == 'c' || c13 == 's' || c13 == 'C' || c13 == 'S') {
                                        float f37 = f24 - f20;
                                        f14 = f25 - f21;
                                        f15 = f37;
                                    } else {
                                        f15 = 0.0f;
                                        f14 = 0.0f;
                                    }
                                    int i26 = i12 + 1;
                                    int i27 = i12 + 2;
                                    int i28 = i12 + 3;
                                    path.rCubicTo(f15, f14, fArr2[i12], fArr2[i26], fArr2[i27], fArr2[i28]);
                                    f10 = fArr2[i12] + f24;
                                    f11 = fArr2[i26] + f25;
                                    f24 += fArr2[i27];
                                    f12 = fArr2[i28];
                                } else if (c12 == 't') {
                                    if (c13 == 'q' || c13 == 't' || c13 == 'Q' || c13 == 'T') {
                                        f16 = f24 - f20;
                                        f17 = f25 - f21;
                                    } else {
                                        f17 = 0.0f;
                                        f16 = 0.0f;
                                    }
                                    int i29 = i12 + 1;
                                    path.rQuadTo(f16, f17, fArr2[i12], fArr2[i29]);
                                    float f38 = f16 + f24;
                                    float f39 = f17 + f25;
                                    f24 += fArr2[i12];
                                    f25 += fArr2[i29];
                                    f21 = f39;
                                    f20 = f38;
                                }
                                f25 += f13;
                            } else {
                                int i30 = i12 + 1;
                                int i31 = i12 + 2;
                                int i32 = i12 + 3;
                                path.rQuadTo(fArr2[i12], fArr2[i30], fArr2[i31], fArr2[i32]);
                                f10 = fArr2[i12] + f24;
                                f11 = fArr2[i30] + f25;
                                f24 += fArr2[i31];
                                f12 = fArr2[i32];
                            }
                            i11 = i12;
                        } else {
                            int i33 = i12 + 2;
                            int i34 = i12 + 3;
                            int i35 = i12 + 4;
                            int i36 = i12 + 5;
                            path.rCubicTo(fArr2[i12], fArr2[i12 + 1], fArr2[i33], fArr2[i34], fArr2[i35], fArr2[i36]);
                            f10 = fArr2[i33] + f24;
                            f11 = fArr2[i34] + f25;
                            f24 += fArr2[i35];
                            f12 = fArr2[i36];
                        }
                        f25 += f12;
                        f20 = f10;
                        f21 = f11;
                        i11 = i12;
                    } else {
                        int i37 = i12 + 5;
                        int i38 = i12 + 6;
                        i11 = i12;
                        drawArc(path, f24, f25, fArr2[i37] + f24, fArr2[i38] + f25, fArr2[i12], fArr2[i12 + 1], fArr2[i12 + 2], fArr2[i12 + 3] != 0.0f, fArr2[i12 + 4] != 0.0f);
                        f24 += fArr2[i37];
                        f25 += fArr2[i38];
                    }
                    i12 = i11 + i10;
                    c13 = c11;
                    c12 = c13;
                } else {
                    i11 = i12;
                    int i39 = i11 + 5;
                    int i40 = i11 + 6;
                    drawArc(path, f24, f25, fArr2[i39], fArr2[i40], fArr2[i11], fArr2[i11 + 1], fArr2[i11 + 2], fArr2[i11 + 3] != 0.0f, fArr2[i11 + 4] != 0.0f);
                    f24 = fArr2[i39];
                    f25 = fArr2[i40];
                }
                f21 = f25;
                f20 = f24;
                i12 = i11 + i10;
                c13 = c11;
                c12 = c13;
            }
            fArr[0] = f24;
            fArr[1] = f25;
            fArr[2] = f20;
            fArr[3] = f21;
            fArr[4] = f26;
            fArr[5] = f27;
        }

        private static void arcToBezier(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18) {
            double d19 = d12;
            int ceil = (int) Math.ceil(Math.abs((d18 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d16);
            double sin = Math.sin(d16);
            double cos2 = Math.cos(d17);
            double sin2 = Math.sin(d17);
            double d20 = -d19;
            double d21 = d20 * cos;
            double d22 = d13 * sin;
            double d23 = (d21 * sin2) - (d22 * cos2);
            double d24 = d20 * sin;
            double d25 = d13 * cos;
            double d26 = (sin2 * d24) + (cos2 * d25);
            double d27 = d18 / ceil;
            double d28 = d17;
            double d29 = d26;
            double d30 = d23;
            int i10 = 0;
            double d31 = d14;
            double d32 = d15;
            while (i10 < ceil) {
                double d33 = d28 + d27;
                double sin3 = Math.sin(d33);
                double cos3 = Math.cos(d33);
                double d34 = (d10 + ((d19 * cos) * cos3)) - (d22 * sin3);
                double d35 = d11 + (d19 * sin * cos3) + (d25 * sin3);
                double d36 = (d21 * sin3) - (d22 * cos3);
                double d37 = (sin3 * d24) + (cos3 * d25);
                double d38 = d33 - d28;
                double tan = Math.tan(d38 / 2.0d);
                double sin4 = (Math.sin(d38) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d39 = d31 + (d30 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d39, (float) (d32 + (d29 * sin4)), (float) (d34 - (sin4 * d36)), (float) (d35 - (sin4 * d37)), (float) d34, (float) d35);
                i10++;
                d27 = d27;
                sin = sin;
                d31 = d34;
                d24 = d24;
                cos = cos;
                d28 = d33;
                d29 = d37;
                d30 = d36;
                ceil = ceil;
                d32 = d35;
                d19 = d12;
            }
        }

        private static void drawArc(Path path, float f10, float f11, float f12, float f13, float f14, float f15, float f16, boolean z10, boolean z11) {
            double d10;
            double d11;
            double radians = Math.toRadians(f16);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d12 = f10;
            double d13 = d12 * cos;
            double d14 = f11;
            double d15 = f14;
            double d16 = (d13 + (d14 * sin)) / d15;
            double d17 = ((-f10) * sin) + (d14 * cos);
            double d18 = f15;
            double d19 = d17 / d18;
            double d20 = f13;
            double d21 = ((f12 * cos) + (d20 * sin)) / d15;
            double d22 = (((-f12) * sin) + (d20 * cos)) / d18;
            double d23 = d16 - d21;
            double d24 = d19 - d22;
            double d25 = (d16 + d21) / 2.0d;
            double d26 = (d19 + d22) / 2.0d;
            double d27 = (d23 * d23) + (d24 * d24);
            if (d27 == c.f27899e) {
                Log.w(PathParser.LOGTAG, " Points are coincident");
                return;
            }
            double d28 = (1.0d / d27) - 0.25d;
            if (d28 < c.f27899e) {
                Log.w(PathParser.LOGTAG, "Points are too far apart " + d27);
                float sqrt = (float) (Math.sqrt(d27) / 1.99999d);
                drawArc(path, f10, f11, f12, f13, f14 * sqrt, f15 * sqrt, f16, z10, z11);
                return;
            }
            double sqrt2 = Math.sqrt(d28);
            double d29 = d23 * sqrt2;
            double d30 = sqrt2 * d24;
            if (z10 == z11) {
                d10 = d25 - d30;
                d11 = d26 + d29;
            } else {
                d10 = d25 + d30;
                d11 = d26 - d29;
            }
            double atan2 = Math.atan2(d19 - d11, d16 - d10);
            double atan22 = Math.atan2(d22 - d11, d21 - d10) - atan2;
            if (z11 != (atan22 >= c.f27899e)) {
                atan22 = atan22 > c.f27899e ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d31 = d10 * d15;
            double d32 = d11 * d18;
            arcToBezier(path, (d31 * cos) - (d32 * sin), (d31 * sin) + (d32 * cos), d15, d18, d12, d14, radians, atan2, atan22);
        }

        public static void nodesToPath(PathDataNode[] pathDataNodeArr, Path path) {
            float[] fArr = new float[6];
            char c10 = 'm';
            for (int i10 = 0; i10 < pathDataNodeArr.length; i10++) {
                PathDataNode pathDataNode = pathDataNodeArr[i10];
                addCommand(path, fArr, c10, pathDataNode.mType, pathDataNode.mParams);
                c10 = pathDataNodeArr[i10].mType;
            }
        }

        public void interpolatePathDataNode(PathDataNode pathDataNode, PathDataNode pathDataNode2, float f10) {
            this.mType = pathDataNode.mType;
            int i10 = 0;
            while (true) {
                float[] fArr = pathDataNode.mParams;
                if (i10 >= fArr.length) {
                    return;
                }
                this.mParams[i10] = (fArr[i10] * (1.0f - f10)) + (pathDataNode2.mParams[i10] * f10);
                i10++;
            }
        }

        public PathDataNode(PathDataNode pathDataNode) {
            this.mType = pathDataNode.mType;
            float[] fArr = pathDataNode.mParams;
            this.mParams = PathParser.copyOfRange(fArr, 0, fArr.length);
        }
    }
}
