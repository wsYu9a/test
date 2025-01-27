package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class ResolutionAnchor extends ResolutionNode {
    public static final int BARRIER_CONNECTION = 5;
    public static final int CENTER_CONNECTION = 2;
    public static final int CHAIN_CONNECTION = 4;
    public static final int DIRECT_CONNECTION = 1;
    public static final int MATCH_CONNECTION = 3;
    public static final int UNCONNECTED = 0;

    /* renamed from: c */
    ConstraintAnchor f1277c;

    /* renamed from: d */
    float f1278d;

    /* renamed from: e */
    ResolutionAnchor f1279e;

    /* renamed from: f */
    float f1280f;

    /* renamed from: g */
    ResolutionAnchor f1281g;

    /* renamed from: h */
    float f1282h;

    /* renamed from: j */
    private ResolutionAnchor f1284j;
    private float k;

    /* renamed from: i */
    int f1283i = 0;
    private ResolutionDimension l = null;
    private int m = 1;
    private ResolutionDimension n = null;
    private int o = 1;

    public ResolutionAnchor(ConstraintAnchor constraintAnchor) {
        this.f1277c = constraintAnchor;
    }

    void a(LinearSystem linearSystem) {
        SolverVariable solverVariable = this.f1277c.getSolverVariable();
        ResolutionAnchor resolutionAnchor = this.f1281g;
        if (resolutionAnchor == null) {
            linearSystem.addEquality(solverVariable, (int) (this.f1282h + 0.5f));
        } else {
            linearSystem.addEquality(solverVariable, linearSystem.createObjectVariable(resolutionAnchor.f1277c), (int) (this.f1282h + 0.5f), 6);
        }
    }

    String b(int i2) {
        return i2 == 1 ? "DIRECT" : i2 == 2 ? "CENTER" : i2 == 3 ? "MATCH" : i2 == 4 ? "CHAIN" : i2 == 5 ? "BARRIER" : "UNCONNECTED";
    }

    public void dependsOn(int i2, ResolutionAnchor resolutionAnchor, int i3) {
        this.f1283i = i2;
        this.f1279e = resolutionAnchor;
        this.f1280f = i3;
        resolutionAnchor.addDependent(this);
    }

    public float getResolvedValue() {
        return this.f1282h;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void remove(ResolutionDimension resolutionDimension) {
        ResolutionDimension resolutionDimension2 = this.l;
        if (resolutionDimension2 == resolutionDimension) {
            this.l = null;
            this.f1280f = this.m;
        } else if (resolutionDimension2 == this.n) {
            this.n = null;
            this.k = this.o;
        }
        resolve();
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void reset() {
        super.reset();
        this.f1279e = null;
        this.f1280f = 0.0f;
        this.l = null;
        this.m = 1;
        this.n = null;
        this.o = 1;
        this.f1281g = null;
        this.f1282h = 0.0f;
        this.f1278d = 0.0f;
        this.f1284j = null;
        this.k = 0.0f;
        this.f1283i = 0;
    }

    public void resolve(ResolutionAnchor resolutionAnchor, float f2) {
        int i2 = this.f1287b;
        if (i2 == 0 || !(this.f1281g == resolutionAnchor || this.f1282h == f2)) {
            this.f1281g = resolutionAnchor;
            this.f1282h = f2;
            if (i2 == 1) {
                invalidate();
            }
            didResolve();
        }
    }

    public void setOpposite(ResolutionAnchor resolutionAnchor, float f2) {
        this.f1284j = resolutionAnchor;
        this.k = f2;
    }

    public void setType(int i2) {
        this.f1283i = i2;
    }

    public String toString() {
        if (this.f1287b != 1) {
            return "{ " + this.f1277c + " UNRESOLVED} type: " + b(this.f1283i);
        }
        if (this.f1281g == this) {
            return "[" + this.f1277c + ", RESOLVED: " + this.f1282h + "]  type: " + b(this.f1283i);
        }
        return "[" + this.f1277c + ", RESOLVED: " + this.f1281g + ":" + this.f1282h + "] type: " + b(this.f1283i);
    }

    public void update() {
        ConstraintAnchor target = this.f1277c.getTarget();
        if (target == null) {
            return;
        }
        if (target.getTarget() == this.f1277c) {
            this.f1283i = 4;
            target.getResolutionNode().f1283i = 4;
        }
        int margin = this.f1277c.getMargin();
        ConstraintAnchor.Type type = this.f1277c.f1236e;
        if (type == ConstraintAnchor.Type.RIGHT || type == ConstraintAnchor.Type.BOTTOM) {
            margin = -margin;
        }
        dependsOn(target.getResolutionNode(), margin);
    }

    public void setOpposite(ResolutionAnchor resolutionAnchor, int i2, ResolutionDimension resolutionDimension) {
        this.f1284j = resolutionAnchor;
        this.n = resolutionDimension;
        this.o = i2;
    }

    public void dependsOn(ResolutionAnchor resolutionAnchor, int i2) {
        this.f1279e = resolutionAnchor;
        this.f1280f = i2;
        resolutionAnchor.addDependent(this);
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void resolve() {
        int i2;
        ResolutionAnchor resolutionAnchor;
        ResolutionAnchor resolutionAnchor2;
        ResolutionAnchor resolutionAnchor3;
        ResolutionAnchor resolutionAnchor4;
        ResolutionAnchor resolutionAnchor5;
        ResolutionAnchor resolutionAnchor6;
        float f2;
        float width;
        float f3;
        ResolutionAnchor resolutionAnchor7;
        boolean z = true;
        if (this.f1287b == 1 || (i2 = this.f1283i) == 4) {
            return;
        }
        ResolutionDimension resolutionDimension = this.l;
        if (resolutionDimension != null) {
            if (resolutionDimension.f1287b != 1) {
                return;
            } else {
                this.f1280f = this.m * resolutionDimension.f1285c;
            }
        }
        ResolutionDimension resolutionDimension2 = this.n;
        if (resolutionDimension2 != null) {
            if (resolutionDimension2.f1287b != 1) {
                return;
            } else {
                this.k = this.o * resolutionDimension2.f1285c;
            }
        }
        if (i2 == 1 && ((resolutionAnchor7 = this.f1279e) == null || resolutionAnchor7.f1287b == 1)) {
            if (resolutionAnchor7 == null) {
                this.f1281g = this;
                this.f1282h = this.f1280f;
            } else {
                this.f1281g = resolutionAnchor7.f1281g;
                this.f1282h = resolutionAnchor7.f1282h + this.f1280f;
            }
            didResolve();
            return;
        }
        if (i2 != 2 || (resolutionAnchor4 = this.f1279e) == null || resolutionAnchor4.f1287b != 1 || (resolutionAnchor5 = this.f1284j) == null || (resolutionAnchor6 = resolutionAnchor5.f1279e) == null || resolutionAnchor6.f1287b != 1) {
            if (i2 != 3 || (resolutionAnchor = this.f1279e) == null || resolutionAnchor.f1287b != 1 || (resolutionAnchor2 = this.f1284j) == null || (resolutionAnchor3 = resolutionAnchor2.f1279e) == null || resolutionAnchor3.f1287b != 1) {
                if (i2 == 5) {
                    this.f1277c.f1235d.resolve();
                    return;
                }
                return;
            }
            if (LinearSystem.getMetrics() != null) {
                LinearSystem.getMetrics().matchConnectionResolved++;
            }
            ResolutionAnchor resolutionAnchor8 = this.f1279e;
            this.f1281g = resolutionAnchor8.f1281g;
            ResolutionAnchor resolutionAnchor9 = this.f1284j;
            ResolutionAnchor resolutionAnchor10 = resolutionAnchor9.f1279e;
            resolutionAnchor9.f1281g = resolutionAnchor10.f1281g;
            this.f1282h = resolutionAnchor8.f1282h + this.f1280f;
            resolutionAnchor9.f1282h = resolutionAnchor10.f1282h + resolutionAnchor9.f1280f;
            didResolve();
            this.f1284j.didResolve();
            return;
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().centerConnectionResolved++;
        }
        ResolutionAnchor resolutionAnchor11 = this.f1279e;
        this.f1281g = resolutionAnchor11.f1281g;
        ResolutionAnchor resolutionAnchor12 = this.f1284j;
        ResolutionAnchor resolutionAnchor13 = resolutionAnchor12.f1279e;
        resolutionAnchor12.f1281g = resolutionAnchor13.f1281g;
        ConstraintAnchor.Type type = this.f1277c.f1236e;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
        int i3 = 0;
        if (type != type2 && type != ConstraintAnchor.Type.BOTTOM) {
            z = false;
        }
        if (z) {
            f2 = resolutionAnchor11.f1282h - resolutionAnchor13.f1282h;
        } else {
            f2 = resolutionAnchor13.f1282h - resolutionAnchor11.f1282h;
        }
        if (type != ConstraintAnchor.Type.LEFT && type != type2) {
            width = f2 - r2.f1235d.getHeight();
            f3 = this.f1277c.f1235d.j0;
        } else {
            width = f2 - r2.f1235d.getWidth();
            f3 = this.f1277c.f1235d.i0;
        }
        int margin = this.f1277c.getMargin();
        int margin2 = this.f1284j.f1277c.getMargin();
        if (this.f1277c.getTarget() == this.f1284j.f1277c.getTarget()) {
            f3 = 0.5f;
            margin2 = 0;
        } else {
            i3 = margin;
        }
        float f4 = i3;
        float f5 = margin2;
        float f6 = (width - f4) - f5;
        if (z) {
            ResolutionAnchor resolutionAnchor14 = this.f1284j;
            resolutionAnchor14.f1282h = resolutionAnchor14.f1279e.f1282h + f5 + (f6 * f3);
            this.f1282h = (this.f1279e.f1282h - f4) - (f6 * (1.0f - f3));
        } else {
            this.f1282h = this.f1279e.f1282h + f4 + (f6 * f3);
            ResolutionAnchor resolutionAnchor15 = this.f1284j;
            resolutionAnchor15.f1282h = (resolutionAnchor15.f1279e.f1282h - f5) - (f6 * (1.0f - f3));
        }
        didResolve();
        this.f1284j.didResolve();
    }

    public void dependsOn(ResolutionAnchor resolutionAnchor, int i2, ResolutionDimension resolutionDimension) {
        this.f1279e = resolutionAnchor;
        resolutionAnchor.addDependent(this);
        this.l = resolutionDimension;
        this.m = i2;
        resolutionDimension.addDependent(this);
    }
}
