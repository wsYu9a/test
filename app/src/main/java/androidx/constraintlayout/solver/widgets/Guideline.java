package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Guideline extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = -1;
    public static final int VERTICAL = 1;
    protected float L0 = -1.0f;
    protected int M0 = -1;
    protected int N0 = -1;
    private ConstraintAnchor O0 = this.E;
    private int P0 = 0;
    private boolean Q0 = false;
    private int R0 = 0;
    private Rectangle S0 = new Rectangle();
    private int T0 = 8;

    /* renamed from: androidx.constraintlayout.solver.widgets.Guideline$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1272a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f1272a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1272a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1272a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1272a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1272a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1272a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1272a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1272a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1272a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.M.clear();
        this.M.add(this.O0);
        int length = this.L.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.L[i2] = this.O0;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) getParent();
        if (constraintWidgetContainer == null) {
            return;
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget constraintWidget = this.O;
        boolean z = constraintWidget != null && constraintWidget.N[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (this.P0 == 0) {
            anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
            anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
            ConstraintWidget constraintWidget2 = this.O;
            z = constraintWidget2 != null && constraintWidget2.N[1] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        }
        if (this.M0 != -1) {
            SolverVariable createObjectVariable = linearSystem.createObjectVariable(this.O0);
            linearSystem.addEquality(createObjectVariable, linearSystem.createObjectVariable(anchor), this.M0, 6);
            if (z) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(anchor2), createObjectVariable, 0, 5);
                return;
            }
            return;
        }
        if (this.N0 == -1) {
            if (this.L0 != -1.0f) {
                linearSystem.addConstraint(LinearSystem.createRowDimensionPercent(linearSystem, linearSystem.createObjectVariable(this.O0), linearSystem.createObjectVariable(anchor), linearSystem.createObjectVariable(anchor2), this.L0, this.Q0));
                return;
            }
            return;
        }
        SolverVariable createObjectVariable2 = linearSystem.createObjectVariable(this.O0);
        SolverVariable createObjectVariable3 = linearSystem.createObjectVariable(anchor2);
        linearSystem.addEquality(createObjectVariable2, createObjectVariable3, -this.N0, 6);
        if (z) {
            linearSystem.addGreaterThan(createObjectVariable2, linearSystem.createObjectVariable(anchor), 0, 5);
            linearSystem.addGreaterThan(createObjectVariable3, createObjectVariable2, 0, 5);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i2) {
        ConstraintWidget parent = getParent();
        if (parent == null) {
            return;
        }
        if (getOrientation() == 1) {
            this.E.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), 0);
            this.G.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), 0);
            if (this.M0 != -1) {
                this.D.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), this.M0);
                this.F.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), this.M0);
                return;
            } else if (this.N0 != -1) {
                this.D.getResolutionNode().dependsOn(1, parent.F.getResolutionNode(), -this.N0);
                this.F.getResolutionNode().dependsOn(1, parent.F.getResolutionNode(), -this.N0);
                return;
            } else {
                if (this.L0 == -1.0f || parent.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
                    return;
                }
                int i3 = (int) (parent.P * this.L0);
                this.D.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), i3);
                this.F.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), i3);
                return;
            }
        }
        this.D.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), 0);
        this.F.getResolutionNode().dependsOn(1, parent.D.getResolutionNode(), 0);
        if (this.M0 != -1) {
            this.E.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), this.M0);
            this.G.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), this.M0);
        } else if (this.N0 != -1) {
            this.E.getResolutionNode().dependsOn(1, parent.G.getResolutionNode(), -this.N0);
            this.G.getResolutionNode().dependsOn(1, parent.G.getResolutionNode(), -this.N0);
        } else {
            if (this.L0 == -1.0f || parent.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.FIXED) {
                return;
            }
            int i4 = (int) (parent.Q * this.L0);
            this.E.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), i4);
            this.G.getResolutionNode().dependsOn(1, parent.E.getResolutionNode(), i4);
        }
    }

    public void cyclePosition() {
        if (this.M0 != -1) {
            l();
        } else if (this.L0 != -1.0f) {
            k();
        } else if (this.N0 != -1) {
            j();
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.O0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.M;
    }

    public Rectangle getHead() {
        Rectangle rectangle = this.S0;
        int drawX = getDrawX() - this.T0;
        int drawY = getDrawY();
        int i2 = this.T0;
        rectangle.setBounds(drawX, drawY - (i2 * 2), i2 * 2, i2 * 2);
        if (getOrientation() == 0) {
            Rectangle rectangle2 = this.S0;
            int drawX2 = getDrawX() - (this.T0 * 2);
            int drawY2 = getDrawY();
            int i3 = this.T0;
            rectangle2.setBounds(drawX2, drawY2 - i3, i3 * 2, i3 * 2);
        }
        return this.S0;
    }

    public int getOrientation() {
        return this.P0;
    }

    public int getRelativeBegin() {
        return this.M0;
    }

    public int getRelativeBehaviour() {
        if (this.L0 != -1.0f) {
            return 0;
        }
        if (this.M0 != -1) {
            return 1;
        }
        return this.N0 != -1 ? 2 : -1;
    }

    public int getRelativeEnd() {
        return this.N0;
    }

    public float getRelativePercent() {
        return this.L0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    void j() {
        int x = getX();
        if (this.P0 == 0) {
            x = getY();
        }
        setGuideBegin(x);
    }

    void k() {
        int width = getParent().getWidth() - getX();
        if (this.P0 == 0) {
            width = getParent().getHeight() - getY();
        }
        setGuideEnd(width);
    }

    void l() {
        float x = getX() / getParent().getWidth();
        if (this.P0 == 0) {
            x = getY() / getParent().getHeight();
        }
        setGuidePercent(x);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDrawOrigin(int i2, int i3) {
        if (this.P0 == 1) {
            int i4 = i2 - this.b0;
            if (this.M0 != -1) {
                setGuideBegin(i4);
                return;
            } else if (this.N0 != -1) {
                setGuideEnd(getParent().getWidth() - i4);
                return;
            } else {
                if (this.L0 != -1.0f) {
                    setGuidePercent(i4 / getParent().getWidth());
                    return;
                }
                return;
            }
        }
        int i5 = i3 - this.c0;
        if (this.M0 != -1) {
            setGuideBegin(i5);
        } else if (this.N0 != -1) {
            setGuideEnd(getParent().getHeight() - i5);
        } else if (this.L0 != -1.0f) {
            setGuidePercent(i5 / getParent().getHeight());
        }
    }

    public void setGuideBegin(int i2) {
        if (i2 > -1) {
            this.L0 = -1.0f;
            this.M0 = i2;
            this.N0 = -1;
        }
    }

    public void setGuideEnd(int i2) {
        if (i2 > -1) {
            this.L0 = -1.0f;
            this.M0 = -1;
            this.N0 = i2;
        }
    }

    public void setGuidePercent(int i2) {
        setGuidePercent(i2 / 100.0f);
    }

    public void setMinimumPosition(int i2) {
        this.R0 = i2;
    }

    public void setOrientation(int i2) {
        if (this.P0 == i2) {
            return;
        }
        this.P0 = i2;
        this.M.clear();
        if (this.P0 == 1) {
            this.O0 = this.D;
        } else {
            this.O0 = this.E;
        }
        this.M.add(this.O0);
        int length = this.L.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.L[i3] = this.O0;
        }
    }

    public void setPositionRelaxed(boolean z) {
        if (this.Q0 == z) {
            return;
        }
        this.Q0 = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        if (getParent() == null) {
            return;
        }
        int objectVariableValue = linearSystem.getObjectVariableValue(this.O0);
        if (this.P0 == 1) {
            setX(objectVariableValue);
            setY(0);
            setHeight(getParent().getHeight());
            setWidth(0);
            return;
        }
        setX(0);
        setY(objectVariableValue);
        setWidth(getParent().getWidth());
        setHeight(0);
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.f1272a[type.ordinal()]) {
            case 1:
            case 2:
                if (this.P0 == 1) {
                    return this.O0;
                }
                break;
            case 3:
            case 4:
                if (this.P0 == 0) {
                    return this.O0;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(type.name());
    }

    public void setGuidePercent(float f2) {
        if (f2 > -1.0f) {
            this.L0 = f2;
            this.M0 = -1;
            this.N0 = -1;
        }
    }
}
