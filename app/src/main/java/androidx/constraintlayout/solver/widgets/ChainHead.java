package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ChainHead {

    /* renamed from: a */
    protected ConstraintWidget f1222a;

    /* renamed from: b */
    protected ConstraintWidget f1223b;

    /* renamed from: c */
    protected ConstraintWidget f1224c;

    /* renamed from: d */
    protected ConstraintWidget f1225d;

    /* renamed from: e */
    protected ConstraintWidget f1226e;

    /* renamed from: f */
    protected ConstraintWidget f1227f;

    /* renamed from: g */
    protected ConstraintWidget f1228g;

    /* renamed from: h */
    protected ArrayList<ConstraintWidget> f1229h;

    /* renamed from: i */
    protected int f1230i;

    /* renamed from: j */
    protected int f1231j;
    protected float k = 0.0f;
    private int l;
    private boolean m;
    protected boolean n;
    protected boolean o;
    protected boolean p;
    private boolean q;

    public ChainHead(ConstraintWidget constraintWidget, int i2, boolean z) {
        this.m = false;
        this.f1222a = constraintWidget;
        this.l = i2;
        this.m = z;
    }

    private void a() {
        int i2 = this.l * 2;
        ConstraintWidget constraintWidget = this.f1222a;
        boolean z = false;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z2 = false;
        while (!z2) {
            this.f1230i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.I0;
            int i3 = this.l;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i3] = null;
            constraintWidget.H0[i3] = null;
            if (constraintWidget.getVisibility() != 8) {
                if (this.f1223b == null) {
                    this.f1223b = constraintWidget;
                }
                this.f1225d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.N;
                int i4 = this.l;
                if (dimensionBehaviourArr[i4] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    int[] iArr = constraintWidget.p;
                    if (iArr[i4] == 0 || iArr[i4] == 3 || iArr[i4] == 2) {
                        this.f1231j++;
                        float[] fArr = constraintWidget.G0;
                        float f2 = fArr[i4];
                        if (f2 > 0.0f) {
                            this.k += fArr[i4];
                        }
                        if (b(constraintWidget, i4)) {
                            if (f2 < 0.0f) {
                                this.n = true;
                            } else {
                                this.o = true;
                            }
                            if (this.f1229h == null) {
                                this.f1229h = new ArrayList<>();
                            }
                            this.f1229h.add(constraintWidget);
                        }
                        if (this.f1227f == null) {
                            this.f1227f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f1228g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.H0[this.l] = constraintWidget;
                        }
                        this.f1228g = constraintWidget;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.I0[this.l] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.L[i2 + 1].f1237f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f1235d;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.L;
                if (constraintAnchorArr[i2].f1237f != null && constraintAnchorArr[i2].f1237f.f1235d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z2 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        this.f1224c = constraintWidget;
        if (this.l == 0 && this.m) {
            this.f1226e = constraintWidget;
        } else {
            this.f1226e = this.f1222a;
        }
        if (this.o && this.n) {
            z = true;
        }
        this.p = z;
    }

    private static boolean b(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget.getVisibility() != 8 && constraintWidget.N[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.p;
            if (iArr[i2] == 0 || iArr[i2] == 3) {
                return true;
            }
        }
        return false;
    }

    public void define() {
        if (!this.q) {
            a();
        }
        this.q = true;
    }

    public ConstraintWidget getFirst() {
        return this.f1222a;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.f1227f;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.f1223b;
    }

    public ConstraintWidget getHead() {
        return this.f1226e;
    }

    public ConstraintWidget getLast() {
        return this.f1224c;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.f1228g;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.f1225d;
    }

    public float getTotalWeight() {
        return this.k;
    }
}
