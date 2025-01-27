package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class ConstraintHorizontalLayout extends ConstraintWidgetContainer {
    private ContentAlignment g1;

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

    public ConstraintHorizontalLayout() {
        this.g1 = ContentAlignment.MIDDLE;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        if (this.L0.size() != 0) {
            int i2 = 0;
            int size = this.L0.size();
            ConstraintHorizontalLayout constraintHorizontalLayout = this;
            while (i2 < size) {
                ConstraintWidget constraintWidget = this.L0.get(i2);
                if (constraintHorizontalLayout != this) {
                    ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.connect(type, constraintHorizontalLayout, type2);
                    constraintHorizontalLayout.connect(type2, constraintWidget, type);
                } else {
                    ConstraintAnchor.Strength strength = ConstraintAnchor.Strength.STRONG;
                    if (this.g1 == ContentAlignment.END) {
                        strength = ConstraintAnchor.Strength.WEAK;
                    }
                    ConstraintAnchor.Type type3 = ConstraintAnchor.Type.LEFT;
                    constraintWidget.connect(type3, constraintHorizontalLayout, type3, 0, strength);
                }
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.TOP;
                constraintWidget.connect(type4, this, type4);
                ConstraintAnchor.Type type5 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.connect(type5, this, type5);
                i2++;
                constraintHorizontalLayout = constraintWidget;
            }
            if (constraintHorizontalLayout != this) {
                ConstraintAnchor.Strength strength2 = ConstraintAnchor.Strength.STRONG;
                if (this.g1 == ContentAlignment.BEGIN) {
                    strength2 = ConstraintAnchor.Strength.WEAK;
                }
                ConstraintAnchor.Type type6 = ConstraintAnchor.Type.RIGHT;
                constraintHorizontalLayout.connect(type6, this, type6, 0, strength2);
            }
        }
        super.addToSolver(linearSystem);
    }

    public ConstraintHorizontalLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.g1 = ContentAlignment.MIDDLE;
    }

    public ConstraintHorizontalLayout(int i2, int i3) {
        super(i2, i3);
        this.g1 = ContentAlignment.MIDDLE;
    }
}
