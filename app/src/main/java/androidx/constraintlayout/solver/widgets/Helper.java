package androidx.constraintlayout.solver.widgets;

import java.util.Arrays;

/* loaded from: classes.dex */
public class Helper extends ConstraintWidget {
    protected ConstraintWidget[] L0 = new ConstraintWidget[4];
    protected int M0 = 0;

    public void add(ConstraintWidget constraintWidget) {
        int i2 = this.M0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.L0;
        if (i2 > constraintWidgetArr.length) {
            this.L0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.L0;
        int i3 = this.M0;
        constraintWidgetArr2[i3] = constraintWidget;
        this.M0 = i3 + 1;
    }

    public void removeAllIds() {
        this.M0 = 0;
    }
}
