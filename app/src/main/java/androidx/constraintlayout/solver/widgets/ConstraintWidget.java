package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintWidget {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int UNKNOWN = -1;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;

    /* renamed from: a */
    private static final boolean f1252a = false;

    /* renamed from: b */
    protected static final int f1253b = 1;

    /* renamed from: c */
    protected static final int f1254c = 2;

    /* renamed from: d */
    private static final int f1255d = -2;

    /* renamed from: e */
    protected static final int f1256e = 0;

    /* renamed from: f */
    protected static final int f1257f = 1;

    /* renamed from: g */
    protected static final int f1258g = 2;

    /* renamed from: h */
    protected static final int f1259h = 3;

    /* renamed from: i */
    protected static final int f1260i = 4;

    /* renamed from: j */
    static final int f1261j = 0;
    static final int k = 1;
    ConstraintWidgetGroup A;
    boolean A0;
    private int[] B;
    boolean B0;
    private float C;
    int C0;
    ConstraintAnchor D;
    int D0;
    ConstraintAnchor E;
    boolean E0;
    ConstraintAnchor F;
    boolean F0;
    ConstraintAnchor G;
    float[] G0;
    ConstraintAnchor H;
    protected ConstraintWidget[] H0;
    ConstraintAnchor I;
    protected ConstraintWidget[] I0;
    ConstraintAnchor J;
    ConstraintWidget J0;
    ConstraintAnchor K;
    ConstraintWidget K0;
    protected ConstraintAnchor[] L;
    protected ArrayList<ConstraintAnchor> M;
    protected DimensionBehaviour[] N;
    ConstraintWidget O;
    int P;
    int Q;
    protected float R;
    protected int S;
    protected int T;
    protected int U;
    int V;
    int W;
    private int X;
    private int Y;
    private int Z;
    private int a0;
    protected int b0;
    protected int c0;
    int d0;
    protected int e0;
    protected int f0;
    private int g0;
    private int h0;
    float i0;
    float j0;
    private Object k0;
    ResolutionDimension l;
    private int l0;
    ResolutionDimension m;
    private int m0;
    public int mHorizontalResolution;
    public int mVerticalResolution;
    int n;
    private String n0;
    int o;
    private String o0;
    int[] p;
    int p0;
    int q;
    int q0;
    int r;
    int r0;
    float s;
    int s0;
    int t;
    boolean t0;
    int u;
    boolean u0;
    float v;
    boolean v0;
    boolean w;
    boolean w0;
    boolean x;
    boolean x0;
    int y;
    boolean y0;
    float z;
    boolean z0;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1262a;

        /* renamed from: b */
        static final /* synthetic */ int[] f1263b;

        static {
            int[] iArr = new int[DimensionBehaviour.values().length];
            f1263b = iArr;
            try {
                iArr[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1263b[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1263b[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1263b[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ConstraintAnchor.Type.values().length];
            f1262a = iArr2;
            try {
                iArr2[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1262a[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1262a[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1262a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1262a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1262a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1262a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1262a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1262a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum ContentAlignment {
        BEGIN,
        MIDDLE,
        END,
        TOP,
        VERTICAL_MIDDLE,
        BOTTOM,
        LEFT,
        RIGHT
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.n = 0;
        this.o = 0;
        this.p = new int[2];
        this.q = 0;
        this.r = 0;
        this.s = 1.0f;
        this.t = 0;
        this.u = 0;
        this.v = 1.0f;
        this.y = -1;
        this.z = 1.0f;
        this.A = null;
        this.B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.C = 0.0f;
        this.D = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.E = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.F = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.G = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.H = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.I = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.J = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.K = constraintAnchor;
        this.L = new ConstraintAnchor[]{this.D, this.F, this.E, this.G, this.H, constraintAnchor};
        this.M = new ArrayList<>();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.N = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.O = null;
        this.P = 0;
        this.Q = 0;
        this.R = 0.0f;
        this.S = -1;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        float f2 = DEFAULT_BIAS;
        this.i0 = f2;
        this.j0 = f2;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = null;
        this.o0 = null;
        this.z0 = false;
        this.A0 = false;
        this.B0 = false;
        this.C0 = 0;
        this.D0 = 0;
        this.G0 = new float[]{-1.0f, -1.0f};
        this.H0 = new ConstraintWidget[]{null, null};
        this.I0 = new ConstraintWidget[]{null, null};
        this.J0 = null;
        this.K0 = null;
        a();
    }

    private void a() {
        this.M.add(this.D);
        this.M.add(this.E);
        this.M.add(this.F);
        this.M.add(this.G);
        this.M.add(this.I);
        this.M.add(this.J);
        this.M.add(this.K);
        this.M.add(this.H);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02e6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02f3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x028e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(androidx.constraintlayout.solver.LinearSystem r25, boolean r26, androidx.constraintlayout.solver.SolverVariable r27, androidx.constraintlayout.solver.SolverVariable r28, androidx.constraintlayout.solver.widgets.ConstraintWidget.DimensionBehaviour r29, boolean r30, androidx.constraintlayout.solver.widgets.ConstraintAnchor r31, androidx.constraintlayout.solver.widgets.ConstraintAnchor r32, int r33, int r34, int r35, int r36, float r37, boolean r38, boolean r39, int r40, int r41, int r42, float r43, boolean r44) {
        /*
            Method dump skipped, instructions count: 803
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.b(androidx.constraintlayout.solver.LinearSystem, boolean, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.SolverVariable, androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.solver.widgets.ConstraintAnchor, androidx.constraintlayout.solver.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, int, int, int, float, boolean):void");
    }

    private boolean h(int i2) {
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.L;
        if (constraintAnchorArr[i3].f1237f != null && constraintAnchorArr[i3].f1237f.f1237f != constraintAnchorArr[i3]) {
            int i4 = i3 + 1;
            if (constraintAnchorArr[i4].f1237f != null && constraintAnchorArr[i4].f1237f.f1237f == constraintAnchorArr[i4]) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0196 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0233 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0234  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addToSolver(androidx.constraintlayout.solver.LinearSystem r42) {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidget.addToSolver(androidx.constraintlayout.solver.LinearSystem):void");
    }

    public boolean allowedInBarrier() {
        return this.m0 != 8;
    }

    public void analyze(int i2) {
        Optimizer.a(i2, this);
    }

    int c() {
        return this.X;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3) {
        connect(constraintAnchor, constraintAnchor2, i2, ConstraintAnchor.Strength.STRONG, i3);
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i2, 0);
        this.C = f2;
    }

    public void connectedTo(ConstraintWidget constraintWidget) {
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.D);
        linearSystem.createObjectVariable(this.E);
        linearSystem.createObjectVariable(this.F);
        linearSystem.createObjectVariable(this.G);
        if (this.d0 > 0) {
            linearSystem.createObjectVariable(this.H);
        }
    }

    int d() {
        return this.Y;
    }

    public void disconnectUnlockedWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = anchors.get(i2);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget && constraintAnchor.getConnectionCreator() == 2) {
                constraintAnchor.reset();
            }
        }
    }

    public void disconnectWidget(ConstraintWidget constraintWidget) {
        ArrayList<ConstraintAnchor> anchors = getAnchors();
        int size = anchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = anchors.get(i2);
            if (constraintAnchor.isConnected() && constraintAnchor.getTarget().getOwner() == constraintWidget) {
                constraintAnchor.reset();
            }
        }
    }

    int e(int i2) {
        if (i2 == 0) {
            return this.V;
        }
        if (i2 == 1) {
            return this.W;
        }
        return 0;
    }

    protected int f() {
        return this.T + this.b0;
    }

    public void forceUpdateDrawPosition() {
        int i2 = this.T;
        int i3 = this.U;
        int i4 = this.P + i2;
        int i5 = this.Q + i3;
        this.X = i2;
        this.Y = i3;
        this.Z = i4 - i2;
        this.a0 = i5 - i3;
    }

    protected int g() {
        return this.U + this.c0;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f1262a[type.ordinal()]) {
            case 1:
                return this.D;
            case 2:
                return this.E;
            case 3:
                return this.F;
            case 4:
                return this.G;
            case 5:
                return this.H;
            case 6:
                return this.K;
            case 7:
                return this.I;
            case 8:
                return this.J;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.M;
    }

    public int getBaselineDistance() {
        return this.d0;
    }

    public float getBiasPercent(int i2) {
        if (i2 == 0) {
            return this.i0;
        }
        if (i2 == 1) {
            return this.j0;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.Q;
    }

    public Object getCompanionWidget() {
        return this.k0;
    }

    public int getContainerItemSkip() {
        return this.l0;
    }

    public String getDebugName() {
        return this.n0;
    }

    public DimensionBehaviour getDimensionBehaviour(int i2) {
        if (i2 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i2 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.R;
    }

    public int getDimensionRatioSide() {
        return this.S;
    }

    public int getDrawBottom() {
        return getDrawY() + this.a0;
    }

    public int getDrawHeight() {
        return this.a0;
    }

    public int getDrawRight() {
        return getDrawX() + this.Z;
    }

    public int getDrawWidth() {
        return this.Z;
    }

    public int getDrawX() {
        return this.X + this.b0;
    }

    public int getDrawY() {
        return this.Y + this.c0;
    }

    public int getHeight() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.Q;
    }

    public float getHorizontalBiasPercent() {
        return this.i0;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.C0;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.N[0];
    }

    public int getInternalDrawBottom() {
        return this.Y + this.a0;
    }

    public int getInternalDrawRight() {
        return this.X + this.Z;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i2) {
        if (i2 == 0) {
            return getWidth();
        }
        if (i2 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.B[1];
    }

    public int getMaxWidth() {
        return this.B[0];
    }

    public int getMinHeight() {
        return this.f0;
    }

    public int getMinWidth() {
        return this.e0;
    }

    public int getOptimizerWrapHeight() {
        int i2;
        int i3 = this.Q;
        if (this.N[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i3;
        }
        if (this.o == 1) {
            i2 = Math.max(this.t, i3);
        } else {
            i2 = this.t;
            if (i2 > 0) {
                this.Q = i2;
            } else {
                i2 = 0;
            }
        }
        int i4 = this.u;
        return (i4 <= 0 || i4 >= i2) ? i2 : i4;
    }

    public int getOptimizerWrapWidth() {
        int i2;
        int i3 = this.P;
        if (this.N[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i3;
        }
        if (this.n == 1) {
            i2 = Math.max(this.q, i3);
        } else {
            i2 = this.q;
            if (i2 > 0) {
                this.P = i2;
            } else {
                i2 = 0;
            }
        }
        int i4 = this.r;
        return (i4 <= 0 || i4 >= i2) ? i2 : i4;
    }

    public ConstraintWidget getParent() {
        return this.O;
    }

    public ResolutionDimension getResolutionHeight() {
        if (this.m == null) {
            this.m = new ResolutionDimension();
        }
        return this.m;
    }

    public ResolutionDimension getResolutionWidth() {
        if (this.l == null) {
            this.l = new ResolutionDimension();
        }
        return this.l;
    }

    public int getRight() {
        return getX() + this.P;
    }

    public WidgetContainer getRootWidgetContainer() {
        ConstraintWidget constraintWidget = this;
        while (constraintWidget.getParent() != null) {
            constraintWidget = constraintWidget.getParent();
        }
        if (constraintWidget instanceof WidgetContainer) {
            return (WidgetContainer) constraintWidget;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.o0;
    }

    public float getVerticalBiasPercent() {
        return this.j0;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.D0;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.N[1];
    }

    public int getVisibility() {
        return this.m0;
    }

    public int getWidth() {
        if (this.m0 == 8) {
            return 0;
        }
        return this.P;
    }

    public int getWrapHeight() {
        return this.h0;
    }

    public int getWrapWidth() {
        return this.g0;
    }

    public int getX() {
        return this.T;
    }

    public int getY() {
        return this.U;
    }

    public boolean hasAncestor(ConstraintWidget constraintWidget) {
        ConstraintWidget parent = getParent();
        if (parent == constraintWidget) {
            return true;
        }
        if (parent == constraintWidget.getParent()) {
            return false;
        }
        while (parent != null) {
            if (parent == constraintWidget || parent == constraintWidget.getParent()) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean hasBaseline() {
        return this.d0 > 0;
    }

    void i(int i2, int i3) {
        if (i3 == 0) {
            this.V = i2;
        } else if (i3 == 1) {
            this.W = i2;
        }
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i2, i3, ConstraintAnchor.Strength.STRONG, 0, true);
    }

    public boolean isFullyResolved() {
        return this.D.getResolutionNode().f1287b == 1 && this.F.getResolutionNode().f1287b == 1 && this.E.getResolutionNode().f1287b == 1 && this.G.getResolutionNode().f1287b == 1;
    }

    public boolean isHeightWrapContent() {
        return this.x;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.D;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1237f;
        if (constraintAnchor2 != null && constraintAnchor2.f1237f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.F;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1237f;
        return constraintAnchor4 != null && constraintAnchor4.f1237f == constraintAnchor3;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.E;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1237f;
        if (constraintAnchor2 != null && constraintAnchor2.f1237f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.G;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1237f;
        return constraintAnchor4 != null && constraintAnchor4.f1237f == constraintAnchor3;
    }

    public boolean isInsideConstraintLayout() {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return false;
        }
        while (parent != null) {
            if (parent instanceof ConstraintWidgetContainer) {
                return true;
            }
            parent = parent.getParent();
        }
        return false;
    }

    public boolean isRoot() {
        return this.O == null;
    }

    public boolean isRootContainer() {
        ConstraintWidget constraintWidget;
        return (this instanceof ConstraintWidgetContainer) && ((constraintWidget = this.O) == null || !(constraintWidget instanceof ConstraintWidgetContainer));
    }

    public boolean isSpreadHeight() {
        return this.o == 0 && this.R == 0.0f && this.t == 0 && this.u == 0 && this.N[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.n == 0 && this.R == 0.0f && this.q == 0 && this.r == 0 && this.N[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.w;
    }

    public void reset() {
        this.D.reset();
        this.E.reset();
        this.F.reset();
        this.G.reset();
        this.H.reset();
        this.I.reset();
        this.J.reset();
        this.K.reset();
        this.O = null;
        this.C = 0.0f;
        this.P = 0;
        this.Q = 0;
        this.R = 0.0f;
        this.S = -1;
        this.T = 0;
        this.U = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0;
        this.g0 = 0;
        this.h0 = 0;
        float f2 = DEFAULT_BIAS;
        this.i0 = f2;
        this.j0 = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.N;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.o0 = null;
        this.x0 = false;
        this.y0 = false;
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = false;
        this.F0 = false;
        float[] fArr = this.G0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.B;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.n = 0;
        this.o = 0;
        this.s = 1.0f;
        this.v = 1.0f;
        this.r = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.q = 0;
        this.t = 0;
        this.y = -1;
        this.z = 1.0f;
        ResolutionDimension resolutionDimension = this.l;
        if (resolutionDimension != null) {
            resolutionDimension.reset();
        }
        ResolutionDimension resolutionDimension2 = this.m;
        if (resolutionDimension2 != null) {
            resolutionDimension2.reset();
        }
        this.A = null;
        this.z0 = false;
        this.A0 = false;
        this.B0 = false;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
        if (this instanceof ConstraintWidgetContainer) {
            return;
        }
        DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.MATCH_CONSTRAINT;
        if (horizontalDimensionBehaviour == dimensionBehaviour) {
            if (getWidth() == getWrapWidth()) {
                setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getWidth() > getMinWidth()) {
                setHorizontalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
        if (getVerticalDimensionBehaviour() == dimensionBehaviour) {
            if (getHeight() == getWrapHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            } else if (getHeight() > getMinHeight()) {
                setVerticalDimensionBehaviour(DimensionBehaviour.FIXED);
            }
        }
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.i0 = 0.5f;
            this.j0 = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.i0 = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.j0 = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.M.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.M.get(i2).reset();
        }
    }

    public void resetResolutionNodes() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.L[i2].getResolutionNode().reset();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.D.resetSolverVariable(cache);
        this.E.resetSolverVariable(cache);
        this.F.resetSolverVariable(cache);
        this.G.resetSolverVariable(cache);
        this.H.resetSolverVariable(cache);
        this.K.resetSolverVariable(cache);
        this.I.resetSolverVariable(cache);
        this.J.resetSolverVariable(cache);
    }

    public void resolve() {
    }

    public void setBaselineDistance(int i2) {
        this.d0 = i2;
    }

    public void setCompanionWidget(Object obj) {
        this.k0 = obj;
    }

    public void setContainerItemSkip(int i2) {
        if (i2 >= 0) {
            this.l0 = i2;
        } else {
            this.l0 = 0;
        }
    }

    public void setDebugName(String str) {
        this.n0 = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.n0 = str;
        SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.D);
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.E);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(this.F);
        SolverVariable createObjectVariable4 = linearSystem.createObjectVariable(this.G);
        createObjectVariable.setName(str + ".left");
        createObjectVariable2.setName(str + ".top");
        createObjectVariable3.setName(str + ".right");
        createObjectVariable4.setName(str + ".bottom");
        if (this.d0 > 0) {
            linearSystem.createObjectVariable(this.H).setName(str + ".baseline");
        }
    }

    public void setDimension(int i2, int i3) {
        this.P = i2;
        int i4 = this.e0;
        if (i2 < i4) {
            this.P = i4;
        }
        this.Q = i3;
        int i5 = this.f0;
        if (i3 < i5) {
            this.Q = i5;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0084 -> B:31:0x0085). Please report as a decompilation issue!!! */
    public void setDimensionRatio(String str) {
        float f2;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            this.R = 0.0f;
            return;
        }
        int i3 = -1;
        int length = str.length();
        int indexOf = str.indexOf(44);
        int i4 = 0;
        if (indexOf > 0 && indexOf < length - 1) {
            String substring = str.substring(0, indexOf);
            if (substring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i3 = 0;
            } else if (substring.equalsIgnoreCase("H")) {
                i3 = 1;
            }
            i4 = indexOf + 1;
        }
        int indexOf2 = str.indexOf(58);
        if (indexOf2 < 0 || indexOf2 >= length - 1) {
            String substring2 = str.substring(i4);
            if (substring2.length() > 0) {
                f2 = Float.parseFloat(substring2);
            }
            f2 = 0.0f;
        } else {
            String substring3 = str.substring(i4, indexOf2);
            String substring4 = str.substring(indexOf2 + 1);
            if (substring3.length() > 0 && substring4.length() > 0) {
                float parseFloat = Float.parseFloat(substring3);
                float parseFloat2 = Float.parseFloat(substring4);
                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                    f2 = i3 == 1 ? Math.abs(parseFloat2 / parseFloat) : Math.abs(parseFloat / parseFloat2);
                }
            }
            f2 = 0.0f;
        }
        i2 = (f2 > i2 ? 1 : (f2 == i2 ? 0 : -1));
        if (i2 > 0) {
            this.R = f2;
            this.S = i3;
        }
    }

    public void setDrawHeight(int i2) {
        this.a0 = i2;
    }

    public void setDrawOrigin(int i2, int i3) {
        int i4 = i2 - this.b0;
        this.X = i4;
        int i5 = i3 - this.c0;
        this.Y = i5;
        this.T = i4;
        this.U = i5;
    }

    public void setDrawWidth(int i2) {
        this.Z = i2;
    }

    public void setDrawX(int i2) {
        int i3 = i2 - this.b0;
        this.X = i3;
        this.T = i3;
    }

    public void setDrawY(int i2) {
        int i3 = i2 - this.c0;
        this.Y = i3;
        this.U = i3;
    }

    public void setFrame(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.T = i2;
        this.U = i3;
        if (this.m0 == 8) {
            this.P = 0;
            this.Q = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.N;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.FIXED;
        if (dimensionBehaviour == dimensionBehaviour2 && i8 < (i7 = this.P)) {
            i8 = i7;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i9 < (i6 = this.Q)) {
            i9 = i6;
        }
        this.P = i8;
        this.Q = i9;
        int i10 = this.f0;
        if (i9 < i10) {
            this.Q = i10;
        }
        int i11 = this.e0;
        if (i8 < i11) {
            this.P = i11;
        }
        this.A0 = true;
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i2) {
        int i3 = AnonymousClass1.f1262a[type.ordinal()];
        if (i3 == 1) {
            this.D.f1238g = i2;
            return;
        }
        if (i3 == 2) {
            this.E.f1238g = i2;
        } else if (i3 == 3) {
            this.F.f1238g = i2;
        } else {
            if (i3 != 4) {
                return;
            }
            this.G.f1238g = i2;
        }
    }

    public void setHeight(int i2) {
        this.Q = i2;
        int i3 = this.f0;
        if (i2 < i3) {
            this.Q = i3;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.x = z;
    }

    public void setHorizontalBiasPercent(float f2) {
        this.i0 = f2;
    }

    public void setHorizontalChainStyle(int i2) {
        this.C0 = i2;
    }

    public void setHorizontalDimension(int i2, int i3) {
        this.T = i2;
        int i4 = i3 - i2;
        this.P = i4;
        int i5 = this.e0;
        if (i4 < i5) {
            this.P = i5;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.N[0] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setWidth(this.g0);
        }
    }

    public void setHorizontalMatchStyle(int i2, int i3, int i4, float f2) {
        this.n = i2;
        this.q = i3;
        this.r = i4;
        this.s = f2;
        if (f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.n = 2;
    }

    public void setHorizontalWeight(float f2) {
        this.G0[0] = f2;
    }

    public void setLength(int i2, int i3) {
        if (i3 == 0) {
            setWidth(i2);
        } else if (i3 == 1) {
            setHeight(i2);
        }
    }

    public void setMaxHeight(int i2) {
        this.B[1] = i2;
    }

    public void setMaxWidth(int i2) {
        this.B[0] = i2;
    }

    public void setMinHeight(int i2) {
        if (i2 < 0) {
            this.f0 = 0;
        } else {
            this.f0 = i2;
        }
    }

    public void setMinWidth(int i2) {
        if (i2 < 0) {
            this.e0 = 0;
        } else {
            this.e0 = i2;
        }
    }

    public void setOffset(int i2, int i3) {
        this.b0 = i2;
        this.c0 = i3;
    }

    public void setOrigin(int i2, int i3) {
        this.T = i2;
        this.U = i3;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.O = constraintWidget;
    }

    public void setType(String str) {
        this.o0 = str;
    }

    public void setVerticalBiasPercent(float f2) {
        this.j0 = f2;
    }

    public void setVerticalChainStyle(int i2) {
        this.D0 = i2;
    }

    public void setVerticalDimension(int i2, int i3) {
        this.U = i2;
        int i4 = i3 - i2;
        this.Q = i4;
        int i5 = this.f0;
        if (i4 < i5) {
            this.Q = i5;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.N[1] = dimensionBehaviour;
        if (dimensionBehaviour == DimensionBehaviour.WRAP_CONTENT) {
            setHeight(this.h0);
        }
    }

    public void setVerticalMatchStyle(int i2, int i3, int i4, float f2) {
        this.o = i2;
        this.t = i3;
        this.u = i4;
        this.v = f2;
        if (f2 >= 1.0f || i2 != 0) {
            return;
        }
        this.o = 2;
    }

    public void setVerticalWeight(float f2) {
        this.G0[1] = f2;
    }

    public void setVisibility(int i2) {
        this.m0 = i2;
    }

    public void setWidth(int i2) {
        this.P = i2;
        int i3 = this.e0;
        if (i2 < i3) {
            this.P = i3;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.w = z;
    }

    public void setWrapHeight(int i2) {
        this.h0 = i2;
    }

    public void setWrapWidth(int i2) {
        this.g0 = i2;
    }

    public void setX(int i2) {
        this.T = i2;
    }

    public void setY(int i2) {
        this.U = i2;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.y == -1) {
            if (z3 && !z4) {
                this.y = 0;
            } else if (!z3 && z4) {
                this.y = 1;
                if (this.S == -1) {
                    this.z = 1.0f / this.z;
                }
            }
        }
        if (this.y == 0 && (!this.E.isConnected() || !this.G.isConnected())) {
            this.y = 1;
        } else if (this.y == 1 && (!this.D.isConnected() || !this.F.isConnected())) {
            this.y = 0;
        }
        if (this.y == -1 && (!this.E.isConnected() || !this.G.isConnected() || !this.D.isConnected() || !this.F.isConnected())) {
            if (this.E.isConnected() && this.G.isConnected()) {
                this.y = 0;
            } else if (this.D.isConnected() && this.F.isConnected()) {
                this.z = 1.0f / this.z;
                this.y = 1;
            }
        }
        if (this.y == -1) {
            if (z && !z2) {
                this.y = 0;
            } else if (!z && z2) {
                this.z = 1.0f / this.z;
                this.y = 1;
            }
        }
        if (this.y == -1) {
            int i2 = this.q;
            if (i2 > 0 && this.t == 0) {
                this.y = 0;
            } else if (i2 == 0 && this.t > 0) {
                this.z = 1.0f / this.z;
                this.y = 1;
            }
        }
        if (this.y == -1 && z && z2) {
            this.z = 1.0f / this.z;
            this.y = 1;
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.o0 != null) {
            str = "type: " + this.o0 + " ";
        } else {
            str = "";
        }
        sb.append(str);
        if (this.n0 != null) {
            str2 = "id: " + this.n0 + " ";
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.T);
        sb.append(", ");
        sb.append(this.U);
        sb.append(") - (");
        sb.append(this.P);
        sb.append(" x ");
        sb.append(this.Q);
        sb.append(") wrap: (");
        sb.append(this.g0);
        sb.append(" x ");
        sb.append(this.h0);
        sb.append(")");
        return sb.toString();
    }

    public void updateDrawPosition() {
        int i2 = this.T;
        int i3 = this.U;
        int i4 = this.P + i2;
        int i5 = this.Q + i3;
        this.X = i2;
        this.Y = i3;
        this.Z = i4 - i2;
        this.a0 = i5 - i3;
    }

    public void updateFromSolver(LinearSystem linearSystem) {
        int objectVariableValue = linearSystem.getObjectVariableValue(this.D);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.E);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.F);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.G);
        int i2 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i2 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void updateResolutionNodes() {
        for (int i2 = 0; i2 < 6; i2++) {
            this.L[i2].getResolutionNode().update();
        }
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        connect(constraintAnchor, constraintAnchor2, i2, ConstraintAnchor.Strength.STRONG, 0);
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, ConstraintAnchor.Strength strength, int i3) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i2, strength, i3);
        }
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        connect(type, constraintWidget, type2, i2, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0, ConstraintAnchor.Strength.STRONG);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, ConstraintAnchor.Strength strength) {
        connect(type, constraintWidget, type2, i2, strength, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, ConstraintAnchor.Strength strength, int i3) {
        ConstraintAnchor.Type type3;
        ConstraintAnchor.Type type4;
        ConstraintAnchor.Type type5;
        boolean z;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.CENTER;
        int i4 = 0;
        if (type == type6) {
            if (type2 == type6) {
                ConstraintAnchor.Type type7 = ConstraintAnchor.Type.LEFT;
                ConstraintAnchor anchor = getAnchor(type7);
                ConstraintAnchor.Type type8 = ConstraintAnchor.Type.RIGHT;
                ConstraintAnchor anchor2 = getAnchor(type8);
                ConstraintAnchor.Type type9 = ConstraintAnchor.Type.TOP;
                ConstraintAnchor anchor3 = getAnchor(type9);
                ConstraintAnchor.Type type10 = ConstraintAnchor.Type.BOTTOM;
                ConstraintAnchor anchor4 = getAnchor(type10);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    type5 = type10;
                    connect(type7, constraintWidget, type7, 0, strength, i3);
                    connect(type8, constraintWidget, type8, 0, strength, i3);
                    z = true;
                } else {
                    type5 = type10;
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    connect(type9, constraintWidget, type9, 0, strength, i3);
                    connect(type5, constraintWidget, type5, 0, strength, i3);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(type6).connect(constraintWidget.getAnchor(type6), 0, i3);
                    return;
                }
                if (z) {
                    ConstraintAnchor.Type type11 = ConstraintAnchor.Type.CENTER_X;
                    getAnchor(type11).connect(constraintWidget.getAnchor(type11), 0, i3);
                    return;
                } else {
                    if (z2) {
                        ConstraintAnchor.Type type12 = ConstraintAnchor.Type.CENTER_Y;
                        getAnchor(type12).connect(constraintWidget.getAnchor(type12), 0, i3);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor.Type type13 = ConstraintAnchor.Type.LEFT;
            if (type2 != type13 && type2 != ConstraintAnchor.Type.RIGHT) {
                ConstraintAnchor.Type type14 = ConstraintAnchor.Type.TOP;
                if (type2 == type14 || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(type14, constraintWidget, type2, 0, strength, i3);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0, strength, i3);
                    getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0, i3);
                    return;
                }
                return;
            }
            connect(type13, constraintWidget, type2, 0, strength, i3);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0, strength, i3);
            getAnchor(type6).connect(constraintWidget.getAnchor(type2), 0, i3);
            return;
        }
        ConstraintAnchor.Type type15 = ConstraintAnchor.Type.CENTER_X;
        if (type == type15 && (type2 == (type4 = ConstraintAnchor.Type.LEFT) || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(type4);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0, i3);
            anchor7.connect(anchor6, 0, i3);
            getAnchor(type15).connect(anchor6, 0, i3);
            return;
        }
        ConstraintAnchor.Type type16 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type16 && (type2 == (type3 = ConstraintAnchor.Type.TOP) || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(type3).connect(anchor8, 0, i3);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0, i3);
            getAnchor(type16).connect(anchor8, 0, i3);
            return;
        }
        if (type == type15 && type2 == type15) {
            ConstraintAnchor.Type type17 = ConstraintAnchor.Type.LEFT;
            getAnchor(type17).connect(constraintWidget.getAnchor(type17), 0, i3);
            ConstraintAnchor.Type type18 = ConstraintAnchor.Type.RIGHT;
            getAnchor(type18).connect(constraintWidget.getAnchor(type18), 0, i3);
            getAnchor(type15).connect(constraintWidget.getAnchor(type2), 0, i3);
            return;
        }
        if (type == type16 && type2 == type16) {
            ConstraintAnchor.Type type19 = ConstraintAnchor.Type.TOP;
            getAnchor(type19).connect(constraintWidget.getAnchor(type19), 0, i3);
            ConstraintAnchor.Type type20 = ConstraintAnchor.Type.BOTTOM;
            getAnchor(type20).connect(constraintWidget.getAnchor(type20), 0, i3);
            getAnchor(type16).connect(constraintWidget.getAnchor(type2), 0, i3);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            ConstraintAnchor.Type type21 = ConstraintAnchor.Type.BASELINE;
            if (type == type21) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
            } else {
                if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                    if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                        ConstraintAnchor anchor13 = getAnchor(type6);
                        if (anchor13.getTarget() != anchor10) {
                            anchor13.reset();
                        }
                        ConstraintAnchor opposite = getAnchor(type).getOpposite();
                        ConstraintAnchor anchor14 = getAnchor(type15);
                        if (anchor14.isConnected()) {
                            opposite.reset();
                            anchor14.reset();
                        }
                    }
                } else {
                    ConstraintAnchor anchor15 = getAnchor(type21);
                    if (anchor15 != null) {
                        anchor15.reset();
                    }
                    ConstraintAnchor anchor16 = getAnchor(type6);
                    if (anchor16.getTarget() != anchor10) {
                        anchor16.reset();
                    }
                    ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor17 = getAnchor(type16);
                    if (anchor17.isConnected()) {
                        opposite2.reset();
                        anchor17.reset();
                    }
                }
                i4 = i2;
            }
            anchor9.connect(anchor10, i4, strength, i3);
            anchor10.getOwner().connectedTo(anchor9.getOwner());
        }
    }

    public void resetAnchors(int i2) {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.M.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintAnchor constraintAnchor = this.M.get(i3);
            if (i2 == constraintAnchor.getConnectionCreator()) {
                if (constraintAnchor.isVerticalAnchor()) {
                    setVerticalBiasPercent(DEFAULT_BIAS);
                } else {
                    setHorizontalBiasPercent(DEFAULT_BIAS);
                }
                constraintAnchor.reset();
            }
        }
    }

    public void setFrame(int i2, int i3, int i4) {
        if (i4 == 0) {
            setHorizontalDimension(i2, i3);
        } else if (i4 == 1) {
            setVerticalDimension(i2, i3);
        }
        this.A0 = true;
    }

    public void setDimensionRatio(float f2, int i2) {
        this.R = f2;
        this.S = i2;
    }

    public ConstraintWidget(int i2, int i3, int i4, int i5) {
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.n = 0;
        this.o = 0;
        this.p = new int[2];
        this.q = 0;
        this.r = 0;
        this.s = 1.0f;
        this.t = 0;
        this.u = 0;
        this.v = 1.0f;
        this.y = -1;
        this.z = 1.0f;
        this.A = null;
        this.B = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.C = 0.0f;
        this.D = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.E = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.F = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.G = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.H = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.I = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.J = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.K = constraintAnchor;
        this.L = new ConstraintAnchor[]{this.D, this.F, this.E, this.G, this.H, constraintAnchor};
        this.M = new ArrayList<>();
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.N = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.O = null;
        this.P = 0;
        this.Q = 0;
        this.R = 0.0f;
        this.S = -1;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        float f2 = DEFAULT_BIAS;
        this.i0 = f2;
        this.j0 = f2;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = null;
        this.o0 = null;
        this.z0 = false;
        this.A0 = false;
        this.B0 = false;
        this.C0 = 0;
        this.D0 = 0;
        this.G0 = new float[]{-1.0f, -1.0f};
        this.H0 = new ConstraintWidget[]{null, null};
        this.I0 = new ConstraintWidget[]{null, null};
        this.J0 = null;
        this.K0 = null;
        this.T = i2;
        this.U = i3;
        this.P = i4;
        this.Q = i5;
        a();
        forceUpdateDrawPosition();
    }

    public ConstraintWidget(int i2, int i3) {
        this(0, 0, i2, i3);
    }
}
