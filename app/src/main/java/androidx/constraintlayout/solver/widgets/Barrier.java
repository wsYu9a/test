package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Barrier extends Helper {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private int N0 = 0;
    private ArrayList<ResolutionAnchor> O0 = new ArrayList<>(4);
    private boolean P0 = true;

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z;
        int i2;
        int i3;
        ConstraintAnchor[] constraintAnchorArr2 = this.L;
        constraintAnchorArr2[0] = this.D;
        constraintAnchorArr2[2] = this.E;
        constraintAnchorArr2[1] = this.F;
        constraintAnchorArr2[3] = this.G;
        int i4 = 0;
        while (true) {
            constraintAnchorArr = this.L;
            if (i4 >= constraintAnchorArr.length) {
                break;
            }
            constraintAnchorArr[i4].k = linearSystem.createObjectVariable(constraintAnchorArr[i4]);
            i4++;
        }
        int i5 = this.N0;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i5];
        for (int i6 = 0; i6 < this.M0; i6++) {
            ConstraintWidget constraintWidget = this.L0[i6];
            if ((this.P0 || constraintWidget.allowedInBarrier()) && ((((i2 = this.N0) == 0 || i2 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) || (((i3 = this.N0) == 2 || i3 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT))) {
                z = true;
                break;
            }
        }
        z = false;
        int i7 = this.N0;
        if (i7 == 0 || i7 == 1 ? getParent().getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT : getParent().getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            z = false;
        }
        for (int i8 = 0; i8 < this.M0; i8++) {
            ConstraintWidget constraintWidget2 = this.L0[i8];
            if (this.P0 || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.L[this.N0]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.L;
                int i9 = this.N0;
                constraintAnchorArr3[i9].k = createObjectVariable;
                if (i9 == 0 || i9 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor.k, createObjectVariable, z);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor.k, createObjectVariable, z);
                }
            }
        }
        int i10 = this.N0;
        if (i10 == 0) {
            linearSystem.addEquality(this.F.k, this.D.k, 0, 6);
            if (z) {
                return;
            }
            linearSystem.addEquality(this.D.k, this.O.F.k, 0, 5);
            return;
        }
        if (i10 == 1) {
            linearSystem.addEquality(this.D.k, this.F.k, 0, 6);
            if (z) {
                return;
            }
            linearSystem.addEquality(this.D.k, this.O.D.k, 0, 5);
            return;
        }
        if (i10 == 2) {
            linearSystem.addEquality(this.G.k, this.E.k, 0, 6);
            if (z) {
                return;
            }
            linearSystem.addEquality(this.E.k, this.O.G.k, 0, 5);
            return;
        }
        if (i10 == 3) {
            linearSystem.addEquality(this.E.k, this.G.k, 0, 6);
            if (z) {
                return;
            }
            linearSystem.addEquality(this.E.k, this.O.E.k, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.P0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i2) {
        ResolutionAnchor resolutionNode;
        ConstraintWidget constraintWidget = this.O;
        if (constraintWidget != null && ((ConstraintWidgetContainer) constraintWidget).optimizeFor(2)) {
            int i3 = this.N0;
            if (i3 == 0) {
                resolutionNode = this.D.getResolutionNode();
            } else if (i3 == 1) {
                resolutionNode = this.F.getResolutionNode();
            } else if (i3 == 2) {
                resolutionNode = this.E.getResolutionNode();
            } else if (i3 != 3) {
                return;
            } else {
                resolutionNode = this.G.getResolutionNode();
            }
            resolutionNode.setType(5);
            int i4 = this.N0;
            if (i4 == 0 || i4 == 1) {
                this.E.getResolutionNode().resolve(null, 0.0f);
                this.G.getResolutionNode().resolve(null, 0.0f);
            } else {
                this.D.getResolutionNode().resolve(null, 0.0f);
                this.F.getResolutionNode().resolve(null, 0.0f);
            }
            this.O0.clear();
            for (int i5 = 0; i5 < this.M0; i5++) {
                ConstraintWidget constraintWidget2 = this.L0[i5];
                if (this.P0 || constraintWidget2.allowedInBarrier()) {
                    int i6 = this.N0;
                    ResolutionAnchor resolutionNode2 = i6 != 0 ? i6 != 1 ? i6 != 2 ? i6 != 3 ? null : constraintWidget2.G.getResolutionNode() : constraintWidget2.E.getResolutionNode() : constraintWidget2.F.getResolutionNode() : constraintWidget2.D.getResolutionNode();
                    if (resolutionNode2 != null) {
                        this.O0.add(resolutionNode2);
                        resolutionNode2.addDependent(resolutionNode);
                    }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetResolutionNodes() {
        super.resetResolutionNodes();
        this.O0.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resolve() {
        ResolutionAnchor resolutionNode;
        float f2;
        ResolutionAnchor resolutionAnchor;
        int i2 = this.N0;
        float f3 = Float.MAX_VALUE;
        if (i2 != 0) {
            if (i2 == 1) {
                resolutionNode = this.F.getResolutionNode();
            } else if (i2 == 2) {
                resolutionNode = this.E.getResolutionNode();
            } else if (i2 != 3) {
                return;
            } else {
                resolutionNode = this.G.getResolutionNode();
            }
            f3 = 0.0f;
        } else {
            resolutionNode = this.D.getResolutionNode();
        }
        int size = this.O0.size();
        ResolutionAnchor resolutionAnchor2 = null;
        for (int i3 = 0; i3 < size; i3++) {
            ResolutionAnchor resolutionAnchor3 = this.O0.get(i3);
            if (resolutionAnchor3.f1287b != 1) {
                return;
            }
            int i4 = this.N0;
            if (i4 == 0 || i4 == 2) {
                f2 = resolutionAnchor3.f1282h;
                if (f2 < f3) {
                    resolutionAnchor = resolutionAnchor3.f1281g;
                    resolutionAnchor2 = resolutionAnchor;
                    f3 = f2;
                }
            } else {
                f2 = resolutionAnchor3.f1282h;
                if (f2 > f3) {
                    resolutionAnchor = resolutionAnchor3.f1281g;
                    resolutionAnchor2 = resolutionAnchor;
                    f3 = f2;
                }
            }
        }
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().barrierConnectionResolved++;
        }
        resolutionNode.f1281g = resolutionAnchor2;
        resolutionNode.f1282h = f3;
        resolutionNode.didResolve();
        int i5 = this.N0;
        if (i5 == 0) {
            this.F.getResolutionNode().resolve(resolutionAnchor2, f3);
            return;
        }
        if (i5 == 1) {
            this.D.getResolutionNode().resolve(resolutionAnchor2, f3);
        } else if (i5 == 2) {
            this.G.getResolutionNode().resolve(resolutionAnchor2, f3);
        } else {
            if (i5 != 3) {
                return;
            }
            this.E.getResolutionNode().resolve(resolutionAnchor2, f3);
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.P0 = z;
    }

    public void setBarrierType(int i2) {
        this.N0 = i2;
    }
}
