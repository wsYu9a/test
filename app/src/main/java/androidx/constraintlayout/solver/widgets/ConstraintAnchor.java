package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public class ConstraintAnchor {
    public static final int AUTO_CONSTRAINT_CREATOR = 2;
    public static final int SCOUT_CREATOR = 1;
    public static final int USER_CREATOR = 0;

    /* renamed from: a */
    private static final boolean f1232a = false;

    /* renamed from: b */
    private static final int f1233b = -1;

    /* renamed from: d */
    final ConstraintWidget f1235d;

    /* renamed from: e */
    final Type f1236e;

    /* renamed from: f */
    ConstraintAnchor f1237f;
    SolverVariable k;

    /* renamed from: c */
    private ResolutionAnchor f1234c = new ResolutionAnchor(this);
    public int mMargin = 0;

    /* renamed from: g */
    int f1238g = -1;

    /* renamed from: h */
    private Strength f1239h = Strength.NONE;

    /* renamed from: i */
    private ConnectionType f1240i = ConnectionType.RELAXED;

    /* renamed from: j */
    private int f1241j = 0;

    /* renamed from: androidx.constraintlayout.solver.widgets.ConstraintAnchor$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1242a;

        static {
            int[] iArr = new int[Type.values().length];
            f1242a = iArr;
            try {
                iArr[Type.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1242a[Type.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1242a[Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1242a[Type.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1242a[Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1242a[Type.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1242a[Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1242a[Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1242a[Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public enum ConnectionType {
        RELAXED,
        STRICT
    }

    public enum Strength {
        NONE,
        STRONG,
        WEAK
    }

    public enum Type {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1235d = constraintWidget;
        this.f1236e = type;
    }

    private boolean a(ConstraintWidget constraintWidget, HashSet<ConstraintWidget> hashSet) {
        if (hashSet.contains(constraintWidget)) {
            return false;
        }
        hashSet.add(constraintWidget);
        if (constraintWidget == getOwner()) {
            return true;
        }
        ArrayList<ConstraintAnchor> anchors = constraintWidget.getAnchors();
        int size = anchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = anchors.get(i2);
            if (constraintAnchor.isSimilarDimensionConnection(this) && constraintAnchor.isConnected() && a(constraintAnchor.getTarget().getOwner(), hashSet)) {
                return true;
            }
        }
        return false;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, Strength strength, int i3) {
        return connect(constraintAnchor, i2, -1, strength, i3, false);
    }

    public int getConnectionCreator() {
        return this.f1241j;
    }

    public ConnectionType getConnectionType() {
        return this.f1240i;
    }

    public int getMargin() {
        ConstraintAnchor constraintAnchor;
        if (this.f1235d.getVisibility() == 8) {
            return 0;
        }
        return (this.f1238g <= -1 || (constraintAnchor = this.f1237f) == null || constraintAnchor.f1235d.getVisibility() != 8) ? this.mMargin : this.f1238g;
    }

    public final ConstraintAnchor getOpposite() {
        switch (AnonymousClass1.f1242a[this.f1236e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f1235d.F;
            case 3:
                return this.f1235d.D;
            case 4:
                return this.f1235d.G;
            case 5:
                return this.f1235d.E;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public ConstraintWidget getOwner() {
        return this.f1235d;
    }

    public int getPriorityLevel() {
        switch (AnonymousClass1.f1242a[this.f1236e.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 2;
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public ResolutionAnchor getResolutionNode() {
        return this.f1234c;
    }

    public int getSnapPriorityLevel() {
        switch (AnonymousClass1.f1242a[this.f1236e.ordinal()]) {
            case 1:
                return 3;
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 0;
            case 6:
                return 2;
            case 7:
                return 0;
            case 8:
                return 1;
            case 9:
                return 0;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public SolverVariable getSolverVariable() {
        return this.k;
    }

    public Strength getStrength() {
        return this.f1239h;
    }

    public ConstraintAnchor getTarget() {
        return this.f1237f;
    }

    public Type getType() {
        return this.f1236e;
    }

    public boolean isConnected() {
        return this.f1237f != null;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget, ConstraintAnchor constraintAnchor) {
        return isConnectionAllowed(constraintWidget);
    }

    public boolean isSideAnchor() {
        switch (AnonymousClass1.f1242a[this.f1236e.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public boolean isSimilarDimensionConnection(ConstraintAnchor constraintAnchor) {
        Type type = constraintAnchor.getType();
        Type type2 = this.f1236e;
        if (type == type2) {
            return true;
        }
        switch (AnonymousClass1.f1242a[type2.ordinal()]) {
            case 1:
                return type != Type.BASELINE;
            case 2:
            case 3:
            case 7:
                return type == Type.LEFT || type == Type.RIGHT || type == Type.CENTER_X;
            case 4:
            case 5:
            case 6:
            case 8:
                return type == Type.TOP || type == Type.BOTTOM || type == Type.CENTER_Y || type == Type.BASELINE;
            case 9:
                return false;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public boolean isSnapCompatibleWith(ConstraintAnchor constraintAnchor) {
        Type type = this.f1236e;
        if (type == Type.CENTER) {
            return false;
        }
        if (type == constraintAnchor.getType()) {
            return true;
        }
        int[] iArr = AnonymousClass1.f1242a;
        switch (iArr[this.f1236e.ordinal()]) {
            case 1:
            case 6:
            case 9:
                return false;
            case 2:
                int i2 = iArr[constraintAnchor.getType().ordinal()];
                return i2 == 3 || i2 == 7;
            case 3:
                int i3 = iArr[constraintAnchor.getType().ordinal()];
                return i3 == 2 || i3 == 7;
            case 4:
                int i4 = iArr[constraintAnchor.getType().ordinal()];
                return i4 == 5 || i4 == 8;
            case 5:
                int i5 = iArr[constraintAnchor.getType().ordinal()];
                return i5 == 4 || i5 == 8;
            case 7:
                int i6 = iArr[constraintAnchor.getType().ordinal()];
                return i6 == 2 || i6 == 3;
            case 8:
                int i7 = iArr[constraintAnchor.getType().ordinal()];
                return i7 == 4 || i7 == 5;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public boolean isValidConnection(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = constraintAnchor.getType();
        Type type2 = this.f1236e;
        if (type == type2) {
            return type2 != Type.BASELINE || (constraintAnchor.getOwner().hasBaseline() && getOwner().hasBaseline());
        }
        switch (AnonymousClass1.f1242a[type2.ordinal()]) {
            case 1:
                return (type == Type.BASELINE || type == Type.CENTER_X || type == Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = type == Type.LEFT || type == Type.RIGHT;
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z || type == Type.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = type == Type.TOP || type == Type.BOTTOM;
                if (constraintAnchor.getOwner() instanceof Guideline) {
                    return z2 || type == Type.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public boolean isVerticalAnchor() {
        switch (AnonymousClass1.f1242a[this.f1236e.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 7:
                return false;
            case 4:
            case 5:
            case 6:
            case 8:
            case 9:
                return true;
            default:
                throw new AssertionError(this.f1236e.name());
        }
    }

    public void reset() {
        this.f1237f = null;
        this.mMargin = 0;
        this.f1238g = -1;
        this.f1239h = Strength.STRONG;
        this.f1241j = 0;
        this.f1240i = ConnectionType.RELAXED;
        this.f1234c.reset();
    }

    public void resetSolverVariable(Cache cache) {
        SolverVariable solverVariable = this.k;
        if (solverVariable == null) {
            this.k = new SolverVariable(SolverVariable.Type.UNRESTRICTED, (String) null);
        } else {
            solverVariable.reset();
        }
    }

    public void setConnectionCreator(int i2) {
        this.f1241j = i2;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.f1240i = connectionType;
    }

    public void setGoneMargin(int i2) {
        if (isConnected()) {
            this.f1238g = i2;
        }
    }

    public void setMargin(int i2) {
        if (isConnected()) {
            this.mMargin = i2;
        }
    }

    public void setStrength(Strength strength) {
        if (isConnected()) {
            this.f1239h = strength;
        }
    }

    public String toString() {
        return this.f1235d.getDebugName() + ":" + this.f1236e.toString();
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, int i3, Strength strength, int i4, boolean z) {
        if (constraintAnchor == null) {
            this.f1237f = null;
            this.mMargin = 0;
            this.f1238g = -1;
            this.f1239h = Strength.NONE;
            this.f1241j = 2;
            return true;
        }
        if (!z && !isValidConnection(constraintAnchor)) {
            return false;
        }
        this.f1237f = constraintAnchor;
        if (i2 > 0) {
            this.mMargin = i2;
        } else {
            this.mMargin = 0;
        }
        this.f1238g = i3;
        this.f1239h = strength;
        this.f1241j = i4;
        return true;
    }

    public boolean isConnectionAllowed(ConstraintWidget constraintWidget) {
        if (a(constraintWidget, new HashSet<>())) {
            return false;
        }
        ConstraintWidget parent = getOwner().getParent();
        return parent == constraintWidget || constraintWidget.getParent() == parent;
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2, int i3) {
        return connect(constraintAnchor, i2, -1, Strength.STRONG, i3, false);
    }

    public boolean connect(ConstraintAnchor constraintAnchor, int i2) {
        return connect(constraintAnchor, i2, -1, Strength.STRONG, 0, false);
    }
}
