package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class Analyzer {
    private Analyzer() {
    }

    private static boolean a(ConstraintWidget constraintWidget, List<ConstraintWidgetGroup> list, boolean z) {
        ConstraintWidgetGroup constraintWidgetGroup = new ConstraintWidgetGroup(new ArrayList(), true);
        list.add(constraintWidgetGroup);
        return i(constraintWidget, constraintWidgetGroup, list, z);
    }

    private static int b(ConstraintWidgetGroup constraintWidgetGroup, int i2) {
        int i3 = i2 * 2;
        List<ConstraintWidget> startWidgets = constraintWidgetGroup.getStartWidgets(i2);
        int size = startWidgets.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            ConstraintWidget constraintWidget = startWidgets.get(i5);
            ConstraintAnchor[] constraintAnchorArr = constraintWidget.L;
            int i6 = i3 + 1;
            i4 = Math.max(i4, c(constraintWidget, i2, constraintAnchorArr[i6].f1237f == null || !(constraintAnchorArr[i3].f1237f == null || constraintAnchorArr[i6].f1237f == null), 0));
        }
        constraintWidgetGroup.mGroupDimensions[i2] = i4;
        return i4;
    }

    private static int c(ConstraintWidget constraintWidget, int i2, boolean z, int i3) {
        int height;
        int baselineDistance;
        int i4;
        int i5;
        int i6;
        int width;
        int i7;
        int i8;
        int i9;
        int i10 = 0;
        if (!constraintWidget.z0) {
            return 0;
        }
        boolean z2 = constraintWidget.H.f1237f != null && i2 == 1;
        if (z) {
            height = constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            i5 = i2 * 2;
            i4 = i5 + 1;
        } else {
            height = constraintWidget.getHeight() - constraintWidget.getBaselineDistance();
            baselineDistance = constraintWidget.getBaselineDistance();
            i4 = i2 * 2;
            i5 = i4 + 1;
        }
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.L;
        if (constraintAnchorArr[i4].f1237f == null || constraintAnchorArr[i5].f1237f != null) {
            i6 = 1;
        } else {
            i6 = -1;
            int i11 = i4;
            i4 = i5;
            i5 = i11;
        }
        int i12 = z2 ? i3 - height : i3;
        int margin = (constraintAnchorArr[i5].getMargin() * i6) + d(constraintWidget, i2);
        int i13 = i12 + margin;
        int width2 = (i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6;
        Iterator<ResolutionNode> it = constraintWidget.L[i5].getResolutionNode().f1286a.iterator();
        while (it.hasNext()) {
            i10 = Math.max(i10, c(((ResolutionAnchor) it.next()).f1277c.f1235d, i2, z, i13));
        }
        int i14 = 0;
        for (Iterator<ResolutionNode> it2 = constraintWidget.L[i4].getResolutionNode().f1286a.iterator(); it2.hasNext(); it2 = it2) {
            i14 = Math.max(i14, c(((ResolutionAnchor) it2.next()).f1277c.f1235d, i2, z, width2 + i13));
        }
        if (z2) {
            i10 -= height;
            width = i14 + baselineDistance;
        } else {
            width = i14 + ((i2 == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight()) * i6);
        }
        int i15 = 1;
        if (i2 == 1) {
            Iterator<ResolutionNode> it3 = constraintWidget.H.getResolutionNode().f1286a.iterator();
            int i16 = 0;
            while (it3.hasNext()) {
                Iterator<ResolutionNode> it4 = it3;
                ResolutionAnchor resolutionAnchor = (ResolutionAnchor) it3.next();
                if (i6 == i15) {
                    i16 = Math.max(i16, c(resolutionAnchor.f1277c.f1235d, i2, z, height + i13));
                    i9 = i4;
                } else {
                    i9 = i4;
                    i16 = Math.max(i16, c(resolutionAnchor.f1277c.f1235d, i2, z, (baselineDistance * i6) + i13));
                }
                it3 = it4;
                i4 = i9;
                i15 = 1;
            }
            i7 = i4;
            int i17 = i16;
            i8 = (constraintWidget.H.getResolutionNode().f1286a.size() <= 0 || z2) ? i17 : i6 == 1 ? i17 + height : i17 - baselineDistance;
        } else {
            i7 = i4;
            i8 = 0;
        }
        int max = margin + Math.max(i10, Math.max(width, i8));
        int i18 = width2 + i13;
        if (i6 == -1) {
            i18 = i13;
            i13 = i18;
        }
        if (z) {
            Optimizer.e(constraintWidget, i2, i13);
            constraintWidget.setFrame(i13, i18, i2);
        } else {
            constraintWidget.A.a(constraintWidget, i2);
            constraintWidget.i(i13, i2);
        }
        if (constraintWidget.getDimensionBehaviour(i2) == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.R != 0.0f) {
            constraintWidget.A.a(constraintWidget, i2);
        }
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget.L;
        if (constraintAnchorArr2[i5].f1237f != null && constraintAnchorArr2[i7].f1237f != null) {
            ConstraintWidget parent = constraintWidget.getParent();
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget.L;
            if (constraintAnchorArr3[i5].f1237f.f1235d == parent && constraintAnchorArr3[i7].f1237f.f1235d == parent) {
                constraintWidget.A.a(constraintWidget, i2);
            }
        }
        return max;
    }

    private static int d(ConstraintWidget constraintWidget, int i2) {
        ConstraintAnchor constraintAnchor;
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.L;
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i3 + 1];
        ConstraintAnchor constraintAnchor4 = constraintAnchor2.f1237f;
        if (constraintAnchor4 == null) {
            return 0;
        }
        ConstraintWidget constraintWidget2 = constraintAnchor4.f1235d;
        ConstraintWidget constraintWidget3 = constraintWidget.O;
        if (constraintWidget2 != constraintWidget3 || (constraintAnchor = constraintAnchor3.f1237f) == null || constraintAnchor.f1235d != constraintWidget3) {
            return 0;
        }
        return (int) ((((constraintWidget3.getLength(i2) - constraintAnchor2.getMargin()) - constraintAnchor3.getMargin()) - constraintWidget.getLength(i2)) * (i2 == 0 ? constraintWidget.i0 : constraintWidget.j0));
    }

    public static void determineGroups(ConstraintWidgetContainer constraintWidgetContainer) {
        if ((constraintWidgetContainer.getOptimizationLevel() & 32) != 32) {
            h(constraintWidgetContainer);
            return;
        }
        constraintWidgetContainer.mSkipSolver = true;
        constraintWidgetContainer.mGroupsWrapOptimized = false;
        constraintWidgetContainer.mHorizontalWrapOptimized = false;
        constraintWidgetContainer.mVerticalWrapOptimized = false;
        ArrayList<ConstraintWidget> arrayList = constraintWidgetContainer.L0;
        List<ConstraintWidgetGroup> list = constraintWidgetContainer.mWidgetGroups;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z = horizontalDimensionBehaviour == dimensionBehaviour;
        boolean z2 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour;
        boolean z3 = z || z2;
        list.clear();
        for (ConstraintWidget constraintWidget : arrayList) {
            constraintWidget.A = null;
            constraintWidget.B0 = false;
            constraintWidget.resetResolutionNodes();
        }
        for (ConstraintWidget constraintWidget2 : arrayList) {
            if (constraintWidget2.A == null && !a(constraintWidget2, list, z3)) {
                h(constraintWidgetContainer);
                constraintWidgetContainer.mSkipSolver = false;
                return;
            }
        }
        int i2 = 0;
        int i3 = 0;
        for (ConstraintWidgetGroup constraintWidgetGroup : list) {
            i2 = Math.max(i2, b(constraintWidgetGroup, 0));
            i3 = Math.max(i3, b(constraintWidgetGroup, 1));
        }
        if (z) {
            constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setWidth(i2);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mHorizontalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedWidth = i2;
        }
        if (z2) {
            constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            constraintWidgetContainer.setHeight(i3);
            constraintWidgetContainer.mGroupsWrapOptimized = true;
            constraintWidgetContainer.mVerticalWrapOptimized = true;
            constraintWidgetContainer.mWrapFixedHeight = i3;
        }
        setPosition(list, 0, constraintWidgetContainer.getWidth());
        setPosition(list, 1, constraintWidgetContainer.getHeight());
    }

    private static void e(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidget constraintWidget, ConstraintWidgetGroup constraintWidgetGroup) {
        constraintWidgetGroup.mSkipSolver = false;
        constraintWidgetContainer.mSkipSolver = false;
        constraintWidget.z0 = false;
    }

    private static int f(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (horizontalDimensionBehaviour == dimensionBehaviour) {
            int height = (int) (constraintWidget.S == 0 ? constraintWidget.getHeight() * constraintWidget.R : constraintWidget.getHeight() / constraintWidget.R);
            constraintWidget.setWidth(height);
            return height;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() != dimensionBehaviour) {
            return -1;
        }
        int width = (int) (constraintWidget.S == 1 ? constraintWidget.getWidth() * constraintWidget.R : constraintWidget.getWidth() / constraintWidget.R);
        constraintWidget.setHeight(width);
        return width;
    }

    private static void g(ConstraintAnchor constraintAnchor) {
        ResolutionAnchor resolutionNode = constraintAnchor.getResolutionNode();
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1237f;
        if (constraintAnchor2 == null || constraintAnchor2.f1237f == constraintAnchor) {
            return;
        }
        constraintAnchor2.getResolutionNode().addDependent(resolutionNode);
    }

    private static void h(ConstraintWidgetContainer constraintWidgetContainer) {
        constraintWidgetContainer.mWidgetGroups.clear();
        constraintWidgetContainer.mWidgetGroups.add(0, new ConstraintWidgetGroup(constraintWidgetContainer.L0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x015b, code lost:
    
        if (r4.f1235d == r5) goto L286;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0112, code lost:
    
        if (r4.f1235d == r5) goto L259;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean i(androidx.constraintlayout.solver.widgets.ConstraintWidget r8, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup r9, java.util.List<androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup> r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Analyzer.i(androidx.constraintlayout.solver.widgets.ConstraintWidget, androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup, java.util.List, boolean):boolean");
    }

    private static void j(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = constraintWidget.L;
        ConstraintAnchor constraintAnchor = constraintAnchorArr[i4];
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i4 + 1];
        if ((constraintAnchor.f1237f == null || constraintAnchor2.f1237f == null) ? false : true) {
            Optimizer.e(constraintWidget, i2, d(constraintWidget, i2) + constraintAnchor.getMargin());
            return;
        }
        if (constraintWidget.R == 0.0f || constraintWidget.getDimensionBehaviour(i2) != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int e2 = i3 - constraintWidget.e(i2);
            int length = e2 - constraintWidget.getLength(i2);
            constraintWidget.setFrame(length, e2, i2);
            Optimizer.e(constraintWidget, i2, length);
            return;
        }
        int f2 = f(constraintWidget);
        int i5 = (int) constraintWidget.L[i4].getResolutionNode().f1282h;
        constraintAnchor2.getResolutionNode().f1281g = constraintAnchor.getResolutionNode();
        constraintAnchor2.getResolutionNode().f1282h = f2;
        constraintAnchor2.getResolutionNode().f1287b = 1;
        constraintWidget.setFrame(i5, i5 + f2, i2);
    }

    public static void setPosition(List<ConstraintWidgetGroup> list, int i2, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            for (ConstraintWidget constraintWidget : list.get(i4).b(i2)) {
                if (constraintWidget.z0) {
                    j(constraintWidget, i2, i3);
                }
            }
        }
    }
}
