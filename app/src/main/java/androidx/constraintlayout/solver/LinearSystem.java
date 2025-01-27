package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public class LinearSystem {
    public static final boolean FULL_DEBUG = false;

    /* renamed from: a */
    private static final boolean f1197a = false;

    /* renamed from: b */
    private static int f1198b = 1000;
    public static Metrics sMetrics;

    /* renamed from: e */
    private Row f1201e;

    /* renamed from: h */
    ArrayRow[] f1204h;
    final Cache m;
    private final Row q;

    /* renamed from: c */
    int f1199c = 0;

    /* renamed from: d */
    private HashMap<String, SolverVariable> f1200d = null;

    /* renamed from: f */
    private int f1202f = 32;

    /* renamed from: g */
    private int f1203g = 32;
    public boolean graphOptimizer = false;

    /* renamed from: i */
    private boolean[] f1205i = new boolean[32];

    /* renamed from: j */
    int f1206j = 1;
    int k = 0;
    private int l = 32;
    private SolverVariable[] n = new SolverVariable[f1198b];
    private int o = 0;
    private ArrayRow[] p = new ArrayRow[32];

    interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();
    }

    public LinearSystem() {
        this.f1204h = null;
        this.f1204h = new ArrayRow[32];
        v();
        Cache cache = new Cache();
        this.m = cache;
        this.f1201e = new GoalRow(cache);
        this.q = new ArrayRow(cache);
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.m.f1195b.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i2 = this.o;
        int i3 = f1198b;
        if (i2 >= i3) {
            int i4 = i3 * 2;
            f1198b = i4;
            this.n = (SolverVariable[]) Arrays.copyOf(this.n, i4);
        }
        SolverVariable[] solverVariableArr = this.n;
        int i5 = this.o;
        this.o = i5 + 1;
        solverVariableArr[i5] = acquire;
        return acquire;
    }

    private void b(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void c(ArrayRow arrayRow) {
        ArrayRow[] arrayRowArr = this.f1204h;
        int i2 = this.k;
        if (arrayRowArr[i2] != null) {
            this.m.f1194a.release(arrayRowArr[i2]);
        }
        ArrayRow[] arrayRowArr2 = this.f1204h;
        int i3 = this.k;
        arrayRowArr2[i3] = arrayRow;
        SolverVariable solverVariable = arrayRow.f1190c;
        solverVariable.f1218i = i3;
        this.k = i3 + 1;
        solverVariable.updateReferencesWithNewDefinition(arrayRow);
    }

    public static ArrayRow createRowCentering(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.c(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (z) {
            createRow.addError(linearSystem, 4);
        }
        return createRow;
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, float f2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        if (z) {
            linearSystem.b(createRow);
        }
        return createRow.e(solverVariable, solverVariable2, solverVariable3, f2);
    }

    public static ArrayRow createRowEquals(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (z) {
            linearSystem.d(createRow, 1);
        }
        return createRow;
    }

    public static ArrayRow createRowGreaterThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (z) {
            linearSystem.d(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        return createRow;
    }

    public static ArrayRow createRowLowerThan(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, int i2, boolean z) {
        SolverVariable createSlackVariable = linearSystem.createSlackVariable();
        ArrayRow createRow = linearSystem.createRow();
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (z) {
            linearSystem.d(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)));
        }
        return createRow;
    }

    private void d(ArrayRow arrayRow, int i2) {
        e(arrayRow, i2, 0);
    }

    private void f() {
        for (int i2 = 0; i2 < this.k; i2++) {
            ArrayRow arrayRow = this.f1204h[i2];
            arrayRow.f1190c.computedValue = arrayRow.f1191d;
        }
    }

    private SolverVariable g(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.f1206j + 1 >= this.f1203g) {
            s();
        }
        SolverVariable a2 = a(type, null);
        a2.setName(str);
        int i2 = this.f1199c + 1;
        this.f1199c = i2;
        this.f1206j++;
        a2.id = i2;
        if (this.f1200d == null) {
            this.f1200d = new HashMap<>();
        }
        this.f1200d.put(str, a2);
        this.m.f1196c[this.f1199c] = a2;
        return a2;
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void i() {
        j();
        String str = "";
        for (int i2 = 0; i2 < this.k; i2++) {
            str = (str + this.f1204h[i2]) + "\n";
        }
        System.out.println(str + this.f1201e + "\n");
    }

    private void j() {
        System.out.println("Display Rows (" + this.k + "x" + this.f1206j + ")\n");
    }

    private int l(Row row) throws Exception {
        float f2;
        boolean z;
        int i2 = 0;
        while (true) {
            f2 = 0.0f;
            if (i2 >= this.k) {
                z = false;
                break;
            }
            ArrayRow[] arrayRowArr = this.f1204h;
            if (arrayRowArr[i2].f1190c.k != SolverVariable.Type.UNRESTRICTED && arrayRowArr[i2].f1191d < 0.0f) {
                z = true;
                break;
            }
            i2++;
        }
        if (!z) {
            return 0;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            Metrics metrics = sMetrics;
            if (metrics != null) {
                metrics.bfs++;
            }
            i3++;
            float f3 = Float.MAX_VALUE;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            int i7 = 0;
            while (i4 < this.k) {
                ArrayRow arrayRow = this.f1204h[i4];
                if (arrayRow.f1190c.k != SolverVariable.Type.UNRESTRICTED && !arrayRow.f1193f && arrayRow.f1191d < f2) {
                    int i8 = 1;
                    while (i8 < this.f1206j) {
                        SolverVariable solverVariable = this.m.f1196c[i8];
                        float f4 = arrayRow.variables.get(solverVariable);
                        if (f4 > f2) {
                            for (int i9 = 0; i9 < 7; i9++) {
                                float f5 = solverVariable.f1219j[i9] / f4;
                                if ((f5 < f3 && i9 == i7) || i9 > i7) {
                                    i6 = i8;
                                    i7 = i9;
                                    f3 = f5;
                                    i5 = i4;
                                }
                            }
                        }
                        i8++;
                        f2 = 0.0f;
                    }
                }
                i4++;
                f2 = 0.0f;
            }
            if (i5 != -1) {
                ArrayRow arrayRow2 = this.f1204h[i5];
                arrayRow2.f1190c.f1218i = -1;
                Metrics metrics2 = sMetrics;
                if (metrics2 != null) {
                    metrics2.pivots++;
                }
                arrayRow2.j(this.m.f1196c[i6]);
                SolverVariable solverVariable2 = arrayRow2.f1190c;
                solverVariable2.f1218i = i5;
                solverVariable2.updateReferencesWithNewDefinition(arrayRow2);
            } else {
                z2 = true;
            }
            if (i3 > this.f1206j / 2) {
                z2 = true;
            }
            f2 = 0.0f;
        }
        return i3;
    }

    private String m(int i2) {
        int i3 = i2 * 4;
        int i4 = i3 / 1024;
        int i5 = i4 / 1024;
        if (i5 > 0) {
            return "" + i5 + " Mb";
        }
        if (i4 > 0) {
            return "" + i4 + " Kb";
        }
        return "" + i3 + " bytes";
    }

    private String n(int i2) {
        return i2 == 1 ? "LOW" : i2 == 2 ? "MEDIUM" : i2 == 3 ? "HIGH" : i2 == 4 ? "HIGHEST" : i2 == 5 ? "EQUALITY" : i2 == 6 ? "FIXED" : "NONE";
    }

    private void s() {
        int i2 = this.f1202f * 2;
        this.f1202f = i2;
        this.f1204h = (ArrayRow[]) Arrays.copyOf(this.f1204h, i2);
        Cache cache = this.m;
        cache.f1196c = (SolverVariable[]) Arrays.copyOf(cache.f1196c, this.f1202f);
        int i3 = this.f1202f;
        this.f1205i = new boolean[i3];
        this.f1203g = i3;
        this.l = i3;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i3);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private final int u(Row row, boolean z) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i2 = 0; i2 < this.f1206j; i2++) {
            this.f1205i[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i3++;
            if (i3 >= this.f1206j * 2) {
                return i3;
            }
            if (row.getKey() != null) {
                this.f1205i[row.getKey().id] = true;
            }
            SolverVariable pivotCandidate = row.getPivotCandidate(this, this.f1205i);
            if (pivotCandidate != null) {
                boolean[] zArr = this.f1205i;
                int i4 = pivotCandidate.id;
                if (zArr[i4]) {
                    return i3;
                }
                zArr[i4] = true;
            }
            if (pivotCandidate != null) {
                float f2 = Float.MAX_VALUE;
                int i5 = -1;
                for (int i6 = 0; i6 < this.k; i6++) {
                    ArrayRow arrayRow = this.f1204h[i6];
                    if (arrayRow.f1190c.k != SolverVariable.Type.UNRESTRICTED && !arrayRow.f1193f && arrayRow.h(pivotCandidate)) {
                        float f3 = arrayRow.variables.get(pivotCandidate);
                        if (f3 < 0.0f) {
                            float f4 = (-arrayRow.f1191d) / f3;
                            if (f4 < f2) {
                                i5 = i6;
                                f2 = f4;
                            }
                        }
                    }
                }
                if (i5 > -1) {
                    ArrayRow arrayRow2 = this.f1204h[i5];
                    arrayRow2.f1190c.f1218i = -1;
                    Metrics metrics3 = sMetrics;
                    if (metrics3 != null) {
                        metrics3.pivots++;
                    }
                    arrayRow2.j(pivotCandidate);
                    SolverVariable solverVariable = arrayRow2.f1190c;
                    solverVariable.f1218i = i5;
                    solverVariable.updateReferencesWithNewDefinition(arrayRow2);
                }
            }
            z2 = true;
        }
        return i3;
    }

    private void v() {
        int i2 = 0;
        while (true) {
            ArrayRow[] arrayRowArr = this.f1204h;
            if (i2 >= arrayRowArr.length) {
                return;
            }
            ArrayRow arrayRow = arrayRowArr[i2];
            if (arrayRow != null) {
                this.m.f1194a.release(arrayRow);
            }
            this.f1204h[i2] = null;
            i2++;
        }
    }

    private final void w(ArrayRow arrayRow) {
        if (this.k > 0) {
            arrayRow.variables.n(arrayRow, this.f1204h);
            if (arrayRow.variables.f1181d == 0) {
                arrayRow.f1193f = true;
            }
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d2 = f2;
        double sin = Math.sin(d2);
        double d3 = i2;
        Double.isNaN(d3);
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (sin * d3));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        double cos = Math.cos(d2);
        Double.isNaN(d3);
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (cos * d3));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, float f2, SolverVariable solverVariable3, SolverVariable solverVariable4, int i3, int i4) {
        ArrayRow createRow = createRow();
        createRow.c(solverVariable, solverVariable2, i2, f2, solverVariable3, solverVariable4, i3);
        if (i4 != 6) {
            createRow.addError(this, i4);
        }
        addConstraint(createRow);
    }

    public void addConstraint(ArrayRow arrayRow) {
        SolverVariable i2;
        if (arrayRow == null) {
            return;
        }
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.constraints++;
            if (arrayRow.f1193f) {
                metrics.simpleconstraints++;
            }
        }
        boolean z = true;
        if (this.k + 1 >= this.l || this.f1206j + 1 >= this.f1203g) {
            s();
        }
        boolean z2 = false;
        if (!arrayRow.f1193f) {
            w(arrayRow);
            if (arrayRow.isEmpty()) {
                return;
            }
            arrayRow.f();
            if (arrayRow.b(this)) {
                SolverVariable createExtraVariable = createExtraVariable();
                arrayRow.f1190c = createExtraVariable;
                c(arrayRow);
                this.q.initFromRow(arrayRow);
                u(this.q, true);
                if (createExtraVariable.f1218i == -1) {
                    if (arrayRow.f1190c == createExtraVariable && (i2 = arrayRow.i(createExtraVariable)) != null) {
                        Metrics metrics2 = sMetrics;
                        if (metrics2 != null) {
                            metrics2.pivots++;
                        }
                        arrayRow.j(i2);
                    }
                    if (!arrayRow.f1193f) {
                        arrayRow.f1190c.updateReferencesWithNewDefinition(arrayRow);
                    }
                    this.k--;
                }
            } else {
                z = false;
            }
            if (!arrayRow.g()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        c(arrayRow);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i2);
        if (i3 != 6) {
            createRow.addError(this, i3);
        }
        addConstraint(createRow);
        return createRow;
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            e(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), 1);
        }
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 6) {
            e(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, boolean z) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, 0);
        if (z) {
            e(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), 1);
        }
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i2, int i3) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i2);
        if (i3 != 6) {
            e(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i3);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f2, int i2) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f2);
        if (i2 != 6) {
            createRow.addError(this, i2);
        }
        addConstraint(createRow);
    }

    public SolverVariable createErrorVariable(int i2, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.f1206j + 1 >= this.f1203g) {
            s();
        }
        SolverVariable a2 = a(SolverVariable.Type.ERROR, str);
        int i3 = this.f1199c + 1;
        this.f1199c = i3;
        this.f1206j++;
        a2.id = i3;
        a2.strength = i2;
        this.m.f1196c[i3] = a2;
        this.f1201e.addError(a2);
        return a2;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.f1206j + 1 >= this.f1203g) {
            s();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, null);
        int i2 = this.f1199c + 1;
        this.f1199c = i2;
        this.f1206j++;
        a2.id = i2;
        this.m.f1196c[i2] = a2;
        return a2;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f1206j + 1 >= this.f1203g) {
            s();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.m);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i2 = solverVariable.id;
            if (i2 == -1 || i2 > this.f1199c || this.m.f1196c[i2] == null) {
                if (i2 != -1) {
                    solverVariable.reset();
                }
                int i3 = this.f1199c + 1;
                this.f1199c = i3;
                this.f1206j++;
                solverVariable.id = i3;
                solverVariable.k = SolverVariable.Type.UNRESTRICTED;
                this.m.f1196c[i3] = solverVariable;
            }
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire = this.m.f1194a.acquire();
        if (acquire == null) {
            acquire = new ArrayRow(this.m);
        } else {
            acquire.reset();
        }
        SolverVariable.c();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.f1206j + 1 >= this.f1203g) {
            s();
        }
        SolverVariable a2 = a(SolverVariable.Type.SLACK, null);
        int i2 = this.f1199c + 1;
        this.f1199c = i2;
        this.f1206j++;
        a2.id = i2;
        this.m.f1196c[i2] = a2;
        return a2;
    }

    public void displayVariablesReadableRows() {
        j();
        String str = "";
        for (int i2 = 0; i2 < this.k; i2++) {
            if (this.f1204h[i2].f1190c.k == SolverVariable.Type.UNRESTRICTED) {
                str = (str + this.f1204h[i2].l()) + "\n";
            }
        }
        System.out.println(str + this.f1201e + "\n");
    }

    void e(ArrayRow arrayRow, int i2, int i3) {
        arrayRow.a(createErrorVariable(i3, null), i2);
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.m;
    }

    public int getMemoryUsed() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.k; i3++) {
            ArrayRow[] arrayRowArr = this.f1204h;
            if (arrayRowArr[i3] != null) {
                i2 += arrayRowArr[i3].k();
            }
        }
        return i2;
    }

    public int getNumEquations() {
        return this.k;
    }

    public int getNumVariables() {
        return this.f1199c;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    void h() {
        j();
        String str = " #  ";
        for (int i2 = 0; i2 < this.k; i2++) {
            str = (str + this.f1204h[i2].l()) + "\n #  ";
        }
        if (this.f1201e != null) {
            str = str + this.f1201e + "\n";
        }
        System.out.println(str);
    }

    void k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1202f; i3++) {
            ArrayRow[] arrayRowArr = this.f1204h;
            if (arrayRowArr[i3] != null) {
                i2 += arrayRowArr[i3].k();
            }
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.k; i5++) {
            ArrayRow[] arrayRowArr2 = this.f1204h;
            if (arrayRowArr2[i5] != null) {
                i4 += arrayRowArr2[i5].k();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder();
        sb.append("Linear System -> Table size: ");
        sb.append(this.f1202f);
        sb.append(" (");
        int i6 = this.f1202f;
        sb.append(m(i6 * i6));
        sb.append(") -- row sizes: ");
        sb.append(m(i2));
        sb.append(", actual size: ");
        sb.append(m(i4));
        sb.append(" rows: ");
        sb.append(this.k);
        sb.append("/");
        sb.append(this.l);
        sb.append(" cols: ");
        sb.append(this.f1206j);
        sb.append("/");
        sb.append(this.f1203g);
        sb.append(" ");
        sb.append(0);
        sb.append(" occupied cells, ");
        sb.append(m(0));
        printStream.println(sb.toString());
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (!this.graphOptimizer) {
            t(this.f1201e);
            return;
        }
        if (metrics != null) {
            metrics.graphOptimizer++;
        }
        boolean z = false;
        int i2 = 0;
        while (true) {
            if (i2 >= this.k) {
                z = true;
                break;
            } else if (!this.f1204h[i2].f1193f) {
                break;
            } else {
                i2++;
            }
        }
        if (!z) {
            t(this.f1201e);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.fullySolved++;
        }
        f();
    }

    Row o() {
        return this.f1201e;
    }

    ArrayRow p(int i2) {
        return this.f1204h[i2];
    }

    float q(String str) {
        SolverVariable r = r(str, SolverVariable.Type.UNRESTRICTED);
        if (r == null) {
            return 0.0f;
        }
        return r.computedValue;
    }

    SolverVariable r(String str, SolverVariable.Type type) {
        if (this.f1200d == null) {
            this.f1200d = new HashMap<>();
        }
        SolverVariable solverVariable = this.f1200d.get(str);
        return solverVariable == null ? g(str, type) : solverVariable;
    }

    public void reset() {
        Cache cache;
        int i2 = 0;
        while (true) {
            cache = this.m;
            SolverVariable[] solverVariableArr = cache.f1196c;
            if (i2 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i2];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i2++;
        }
        cache.f1195b.releaseAll(this.n, this.o);
        this.o = 0;
        Arrays.fill(this.m.f1196c, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f1200d;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1199c = 0;
        this.f1201e.clear();
        this.f1206j = 1;
        for (int i3 = 0; i3 < this.k; i3++) {
            this.f1204h[i3].f1192e = false;
        }
        v();
        this.k = 0;
    }

    void t(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.f1206j);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.k);
        }
        w((ArrayRow) row);
        l(row);
        u(row, false);
        f();
    }

    public void addEquality(SolverVariable solverVariable, int i2) {
        int i3 = solverVariable.f1218i;
        if (i3 != -1) {
            ArrayRow arrayRow = this.f1204h[i3];
            if (arrayRow.f1193f) {
                arrayRow.f1191d = i2;
                return;
            }
            if (arrayRow.variables.f1181d == 0) {
                arrayRow.f1193f = true;
                arrayRow.f1191d = i2;
                return;
            } else {
                ArrayRow createRow = createRow();
                createRow.createRowEquals(solverVariable, i2);
                addConstraint(createRow);
                return;
            }
        }
        ArrayRow createRow2 = createRow();
        createRow2.d(solverVariable, i2);
        addConstraint(createRow2);
    }

    public void addGreaterThan(SolverVariable solverVariable, int i2) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, i2, createSlackVariable);
        addConstraint(createRow);
    }

    public void addEquality(SolverVariable solverVariable, int i2, int i3) {
        int i4 = solverVariable.f1218i;
        if (i4 != -1) {
            ArrayRow arrayRow = this.f1204h[i4];
            if (arrayRow.f1193f) {
                arrayRow.f1191d = i2;
                return;
            }
            ArrayRow createRow = createRow();
            createRow.createRowEquals(solverVariable, i2);
            createRow.addError(this, i3);
            addConstraint(createRow);
            return;
        }
        ArrayRow createRow2 = createRow();
        createRow2.d(solverVariable, i2);
        createRow2.addError(this, i3);
        addConstraint(createRow2);
    }
}
