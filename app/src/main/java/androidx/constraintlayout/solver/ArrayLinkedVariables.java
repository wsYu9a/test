package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ArrayLinkedVariables {

    /* renamed from: a */
    private static final boolean f1178a = false;

    /* renamed from: b */
    private static final int f1179b = -1;

    /* renamed from: c */
    private static final boolean f1180c = false;

    /* renamed from: e */
    private final ArrayRow f1182e;

    /* renamed from: f */
    private final Cache f1183f;

    /* renamed from: d */
    int f1181d = 0;

    /* renamed from: g */
    private int f1184g = 8;

    /* renamed from: h */
    private SolverVariable f1185h = null;

    /* renamed from: i */
    private int[] f1186i = new int[8];

    /* renamed from: j */
    private int[] f1187j = new int[8];
    private float[] k = new float[8];
    private int l = -1;
    private int m = -1;
    private boolean n = false;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.f1182e = arrayRow;
        this.f1183f = cache;
    }

    private boolean k(SolverVariable solverVariable, LinearSystem linearSystem) {
        return solverVariable.usageInRowCount <= 1;
    }

    final void a(SolverVariable solverVariable, float f2, boolean z) {
        if (f2 == 0.0f) {
            return;
        }
        int i2 = this.l;
        if (i2 == -1) {
            this.l = 0;
            this.k[0] = f2;
            this.f1186i[0] = solverVariable.id;
            this.f1187j[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.f1182e);
            this.f1181d++;
            if (this.n) {
                return;
            }
            int i3 = this.m + 1;
            this.m = i3;
            int[] iArr = this.f1186i;
            if (i3 >= iArr.length) {
                this.n = true;
                this.m = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f1181d; i5++) {
            int[] iArr2 = this.f1186i;
            int i6 = iArr2[i2];
            int i7 = solverVariable.id;
            if (i6 == i7) {
                float[] fArr = this.k;
                fArr[i2] = fArr[i2] + f2;
                if (fArr[i2] == 0.0f) {
                    if (i2 == this.l) {
                        this.l = this.f1187j[i2];
                    } else {
                        int[] iArr3 = this.f1187j;
                        iArr3[i4] = iArr3[i2];
                    }
                    if (z) {
                        solverVariable.removeFromRow(this.f1182e);
                    }
                    if (this.n) {
                        this.m = i2;
                    }
                    solverVariable.usageInRowCount--;
                    this.f1181d--;
                    return;
                }
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f1187j[i2];
        }
        int i8 = this.m;
        int i9 = i8 + 1;
        if (this.n) {
            int[] iArr4 = this.f1186i;
            if (iArr4[i8] != -1) {
                i8 = iArr4.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr5 = this.f1186i;
        if (i8 >= iArr5.length && this.f1181d < iArr5.length) {
            int i10 = 0;
            while (true) {
                int[] iArr6 = this.f1186i;
                if (i10 >= iArr6.length) {
                    break;
                }
                if (iArr6[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr7 = this.f1186i;
        if (i8 >= iArr7.length) {
            i8 = iArr7.length;
            int i11 = this.f1184g * 2;
            this.f1184g = i11;
            this.n = false;
            this.m = i8 - 1;
            this.k = Arrays.copyOf(this.k, i11);
            this.f1186i = Arrays.copyOf(this.f1186i, this.f1184g);
            this.f1187j = Arrays.copyOf(this.f1187j, this.f1184g);
        }
        this.f1186i[i8] = solverVariable.id;
        this.k[i8] = f2;
        if (i4 != -1) {
            int[] iArr8 = this.f1187j;
            iArr8[i8] = iArr8[i4];
            iArr8[i4] = i8;
        } else {
            this.f1187j[i8] = this.l;
            this.l = i8;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.f1182e);
        this.f1181d++;
        if (!this.n) {
            this.m++;
        }
        int i12 = this.m;
        int[] iArr9 = this.f1186i;
        if (i12 >= iArr9.length) {
            this.n = true;
            this.m = iArr9.length - 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    androidx.constraintlayout.solver.SolverVariable b(androidx.constraintlayout.solver.LinearSystem r15) {
        /*
            r14 = this;
            int r0 = r14.l
            r1 = 0
            r2 = 0
            r3 = 0
            r2 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        Lb:
            r9 = -1
            if (r0 == r9) goto L98
            int r9 = r14.f1181d
            if (r4 >= r9) goto L98
            float[] r9 = r14.k
            r10 = r9[r0]
            r11 = 981668463(0x3a83126f, float:0.001)
            androidx.constraintlayout.solver.Cache r12 = r14.f1183f
            androidx.constraintlayout.solver.SolverVariable[] r12 = r12.f1196c
            int[] r13 = r14.f1186i
            r13 = r13[r0]
            r12 = r12[r13]
            int r13 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r13 >= 0) goto L36
            r11 = -1165815185(0xffffffffba83126f, float:-0.001)
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 <= 0) goto L42
            r9[r0] = r3
            androidx.constraintlayout.solver.ArrayRow r9 = r14.f1182e
            r12.removeFromRow(r9)
            goto L41
        L36:
            int r11 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r11 >= 0) goto L42
            r9[r0] = r3
            androidx.constraintlayout.solver.ArrayRow r9 = r14.f1182e
            r12.removeFromRow(r9)
        L41:
            r10 = 0
        L42:
            r9 = 1
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 == 0) goto L90
            androidx.constraintlayout.solver.SolverVariable$Type r11 = r12.k
            androidx.constraintlayout.solver.SolverVariable$Type r13 = androidx.constraintlayout.solver.SolverVariable.Type.UNRESTRICTED
            if (r11 != r13) goto L6c
            if (r2 != 0) goto L57
            boolean r2 = r14.k(r12, r15)
        L53:
            r5 = r2
            r7 = r10
            r2 = r12
            goto L90
        L57:
            int r11 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r11 <= 0) goto L60
            boolean r2 = r14.k(r12, r15)
            goto L53
        L60:
            if (r5 != 0) goto L90
            boolean r11 = r14.k(r12, r15)
            if (r11 == 0) goto L90
            r7 = r10
            r2 = r12
            r5 = 1
            goto L90
        L6c:
            if (r2 != 0) goto L90
            int r11 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r11 >= 0) goto L90
            if (r1 != 0) goto L7c
            boolean r1 = r14.k(r12, r15)
        L78:
            r6 = r1
            r8 = r10
            r1 = r12
            goto L90
        L7c:
            int r11 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r11 <= 0) goto L85
            boolean r1 = r14.k(r12, r15)
            goto L78
        L85:
            if (r6 != 0) goto L90
            boolean r11 = r14.k(r12, r15)
            if (r11 == 0) goto L90
            r8 = r10
            r1 = r12
            r6 = 1
        L90:
            int[] r9 = r14.f1187j
            r0 = r9[r0]
            int r4 = r4 + 1
            goto Lb
        L98:
            if (r2 == 0) goto L9b
            return r2
        L9b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.ArrayLinkedVariables.b(androidx.constraintlayout.solver.LinearSystem):androidx.constraintlayout.solver.SolverVariable");
    }

    final boolean c(SolverVariable solverVariable) {
        int i2 = this.l;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            if (this.f1186i[i2] == solverVariable.id) {
                return true;
            }
            i2 = this.f1187j[i2];
        }
        return false;
    }

    public final void clear() {
        int i2 = this.l;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            SolverVariable solverVariable = this.f1183f.f1196c[this.f1186i[i2]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.f1182e);
            }
            i2 = this.f1187j[i2];
        }
        this.l = -1;
        this.m = -1;
        this.n = false;
        this.f1181d = 0;
    }

    void d(float f2) {
        int i2 = this.l;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            float[] fArr = this.k;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.f1187j[i2];
        }
    }

    public void display() {
        int i2 = this.f1181d;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable g2 = g(i3);
            if (g2 != null) {
                System.out.print(g2 + " = " + h(i3) + " ");
            }
        }
        System.out.println(" }");
    }

    SolverVariable e() {
        SolverVariable solverVariable = this.f1185h;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i2 = this.l;
        SolverVariable solverVariable2 = null;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            if (this.k[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.f1183f.f1196c[this.f1186i[i2]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i2 = this.f1187j[i2];
        }
        return solverVariable2;
    }

    SolverVariable f(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int i2 = this.l;
        SolverVariable solverVariable2 = null;
        float f2 = 0.0f;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            float[] fArr = this.k;
            if (fArr[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.f1183f.f1196c[this.f1186i[i2]];
                if ((zArr == null || !zArr[solverVariable3.id]) && solverVariable3 != solverVariable && ((type = solverVariable3.k) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR)) {
                    float f3 = fArr[i2];
                    if (f3 < f2) {
                        f2 = f3;
                        solverVariable2 = solverVariable3;
                    }
                }
            }
            i2 = this.f1187j[i2];
        }
        return solverVariable2;
    }

    final SolverVariable g(int i2) {
        int i3 = this.l;
        for (int i4 = 0; i3 != -1 && i4 < this.f1181d; i4++) {
            if (i4 == i2) {
                return this.f1183f.f1196c[this.f1186i[i3]];
            }
            i3 = this.f1187j[i3];
        }
        return null;
    }

    public final float get(SolverVariable solverVariable) {
        int i2 = this.l;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            if (this.f1186i[i2] == solverVariable.id) {
                return this.k[i2];
            }
            i2 = this.f1187j[i2];
        }
        return 0.0f;
    }

    final float h(int i2) {
        int i3 = this.l;
        for (int i4 = 0; i3 != -1 && i4 < this.f1181d; i4++) {
            if (i4 == i2) {
                return this.k[i3];
            }
            i3 = this.f1187j[i3];
        }
        return 0.0f;
    }

    boolean i() {
        int i2 = this.l;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            if (this.k[i2] > 0.0f) {
                return true;
            }
            i2 = this.f1187j[i2];
        }
        return false;
    }

    void j() {
        int i2 = this.l;
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            float[] fArr = this.k;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f1187j[i2];
        }
    }

    int l() {
        return (this.f1186i.length * 4 * 3) + 0 + 36;
    }

    final void m(ArrayRow arrayRow, ArrayRow arrayRow2, boolean z) {
        int i2 = this.l;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
                int i4 = this.f1186i[i2];
                SolverVariable solverVariable = arrayRow2.f1190c;
                if (i4 == solverVariable.id) {
                    float f2 = this.k[i2];
                    remove(solverVariable, z);
                    ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                    int i5 = arrayLinkedVariables.l;
                    for (int i6 = 0; i5 != -1 && i6 < arrayLinkedVariables.f1181d; i6++) {
                        a(this.f1183f.f1196c[arrayLinkedVariables.f1186i[i5]], arrayLinkedVariables.k[i5] * f2, z);
                        i5 = arrayLinkedVariables.f1187j[i5];
                    }
                    arrayRow.f1191d += arrayRow2.f1191d * f2;
                    if (z) {
                        arrayRow2.f1190c.removeFromRow(arrayRow);
                    }
                    i2 = this.l;
                } else {
                    i2 = this.f1187j[i2];
                }
            }
            return;
        }
    }

    void n(ArrayRow arrayRow, ArrayRow[] arrayRowArr) {
        int i2 = this.l;
        while (true) {
            for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
                SolverVariable solverVariable = this.f1183f.f1196c[this.f1186i[i2]];
                if (solverVariable.f1218i != -1) {
                    float f2 = this.k[i2];
                    remove(solverVariable, true);
                    ArrayRow arrayRow2 = arrayRowArr[solverVariable.f1218i];
                    if (!arrayRow2.f1193f) {
                        ArrayLinkedVariables arrayLinkedVariables = arrayRow2.variables;
                        int i4 = arrayLinkedVariables.l;
                        for (int i5 = 0; i4 != -1 && i5 < arrayLinkedVariables.f1181d; i5++) {
                            a(this.f1183f.f1196c[arrayLinkedVariables.f1186i[i4]], arrayLinkedVariables.k[i4] * f2, true);
                            i4 = arrayLinkedVariables.f1187j[i4];
                        }
                    }
                    arrayRow.f1191d += arrayRow2.f1191d * f2;
                    arrayRow2.f1190c.removeFromRow(arrayRow);
                    i2 = this.l;
                } else {
                    i2 = this.f1187j[i2];
                }
            }
            return;
        }
    }

    public final void put(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i2 = this.l;
        if (i2 == -1) {
            this.l = 0;
            this.k[0] = f2;
            this.f1186i[0] = solverVariable.id;
            this.f1187j[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.f1182e);
            this.f1181d++;
            if (this.n) {
                return;
            }
            int i3 = this.m + 1;
            this.m = i3;
            int[] iArr = this.f1186i;
            if (i3 >= iArr.length) {
                this.n = true;
                this.m = iArr.length - 1;
                return;
            }
            return;
        }
        int i4 = -1;
        for (int i5 = 0; i2 != -1 && i5 < this.f1181d; i5++) {
            int[] iArr2 = this.f1186i;
            int i6 = iArr2[i2];
            int i7 = solverVariable.id;
            if (i6 == i7) {
                this.k[i2] = f2;
                return;
            }
            if (iArr2[i2] < i7) {
                i4 = i2;
            }
            i2 = this.f1187j[i2];
        }
        int i8 = this.m;
        int i9 = i8 + 1;
        if (this.n) {
            int[] iArr3 = this.f1186i;
            if (iArr3[i8] != -1) {
                i8 = iArr3.length;
            }
        } else {
            i8 = i9;
        }
        int[] iArr4 = this.f1186i;
        if (i8 >= iArr4.length && this.f1181d < iArr4.length) {
            int i10 = 0;
            while (true) {
                int[] iArr5 = this.f1186i;
                if (i10 >= iArr5.length) {
                    break;
                }
                if (iArr5[i10] == -1) {
                    i8 = i10;
                    break;
                }
                i10++;
            }
        }
        int[] iArr6 = this.f1186i;
        if (i8 >= iArr6.length) {
            i8 = iArr6.length;
            int i11 = this.f1184g * 2;
            this.f1184g = i11;
            this.n = false;
            this.m = i8 - 1;
            this.k = Arrays.copyOf(this.k, i11);
            this.f1186i = Arrays.copyOf(this.f1186i, this.f1184g);
            this.f1187j = Arrays.copyOf(this.f1187j, this.f1184g);
        }
        this.f1186i[i8] = solverVariable.id;
        this.k[i8] = f2;
        if (i4 != -1) {
            int[] iArr7 = this.f1187j;
            iArr7[i8] = iArr7[i4];
            iArr7[i4] = i8;
        } else {
            this.f1187j[i8] = this.l;
            this.l = i8;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.f1182e);
        int i12 = this.f1181d + 1;
        this.f1181d = i12;
        if (!this.n) {
            this.m++;
        }
        int[] iArr8 = this.f1186i;
        if (i12 >= iArr8.length) {
            this.n = true;
        }
        if (this.m >= iArr8.length) {
            this.n = true;
            this.m = iArr8.length - 1;
        }
    }

    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.f1185h == solverVariable) {
            this.f1185h = null;
        }
        int i2 = this.l;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.f1181d) {
            if (this.f1186i[i2] == solverVariable.id) {
                if (i2 == this.l) {
                    this.l = this.f1187j[i2];
                } else {
                    int[] iArr = this.f1187j;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.removeFromRow(this.f1182e);
                }
                solverVariable.usageInRowCount--;
                this.f1181d--;
                this.f1186i[i2] = -1;
                if (this.n) {
                    this.m = i2;
                }
                return this.k[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.f1187j[i2];
        }
        return 0.0f;
    }

    public String toString() {
        int i2 = this.l;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.f1181d; i3++) {
            str = ((str + " -> ") + this.k[i2] + " : ") + this.f1183f.f1196c[this.f1186i[i2]];
            i2 = this.f1187j[i2];
        }
        return str;
    }
}
