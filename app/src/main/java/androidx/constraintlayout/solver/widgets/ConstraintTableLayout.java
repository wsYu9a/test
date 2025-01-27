package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ConstraintTableLayout extends ConstraintWidgetContainer {
    public static final int ALIGN_CENTER = 0;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    private static final int g1 = 3;
    private boolean h1;
    private int i1;
    private int j1;
    private int k1;
    private ArrayList<VerticalSlice> l1;
    private ArrayList<HorizontalSlice> m1;
    private ArrayList<Guideline> n1;
    private ArrayList<Guideline> o1;
    private LinearSystem p1;

    class HorizontalSlice {

        /* renamed from: a */
        ConstraintWidget f1243a;

        /* renamed from: b */
        ConstraintWidget f1244b;

        /* renamed from: c */
        int f1245c;

        HorizontalSlice() {
        }
    }

    class VerticalSlice {

        /* renamed from: a */
        ConstraintWidget f1247a;

        /* renamed from: b */
        ConstraintWidget f1248b;

        /* renamed from: c */
        int f1249c = 1;

        /* renamed from: d */
        int f1250d;

        VerticalSlice() {
        }
    }

    public ConstraintTableLayout() {
        this.h1 = true;
        this.i1 = 0;
        this.j1 = 0;
        this.k1 = 8;
        this.l1 = new ArrayList<>();
        this.m1 = new ArrayList<>();
        this.n1 = new ArrayList<>();
        this.o1 = new ArrayList<>();
        this.p1 = null;
    }

    private void n() {
        int size = this.L0.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.L0.get(i3);
            int containerItemSkip = i2 + constraintWidget.getContainerItemSkip();
            int i4 = this.i1;
            int i5 = containerItemSkip % i4;
            HorizontalSlice horizontalSlice = this.m1.get(containerItemSkip / i4);
            VerticalSlice verticalSlice = this.l1.get(i5);
            ConstraintWidget constraintWidget2 = verticalSlice.f1247a;
            ConstraintWidget constraintWidget3 = verticalSlice.f1248b;
            ConstraintWidget constraintWidget4 = horizontalSlice.f1243a;
            ConstraintWidget constraintWidget5 = horizontalSlice.f1244b;
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.getAnchor(type).connect(constraintWidget2.getAnchor(type), this.k1);
            if (constraintWidget3 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget3.getAnchor(type), this.k1);
            } else {
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                constraintWidget.getAnchor(type2).connect(constraintWidget3.getAnchor(type2), this.k1);
            }
            int i6 = verticalSlice.f1249c;
            if (i6 == 1) {
                constraintWidget.getAnchor(type).setStrength(ConstraintAnchor.Strength.STRONG);
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.WEAK);
            } else if (i6 == 2) {
                constraintWidget.getAnchor(type).setStrength(ConstraintAnchor.Strength.WEAK);
                constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).setStrength(ConstraintAnchor.Strength.STRONG);
            } else if (i6 == 3) {
                constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
            }
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.getAnchor(type3).connect(constraintWidget4.getAnchor(type3), this.k1);
            if (constraintWidget5 instanceof Guideline) {
                constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget5.getAnchor(type3), this.k1);
            } else {
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                constraintWidget.getAnchor(type4).connect(constraintWidget5.getAnchor(type4), this.k1);
            }
            i2 = containerItemSkip + 1;
        }
    }

    private void o() {
        this.m1.clear();
        float f2 = 100.0f / this.j1;
        ConstraintWidget constraintWidget = this;
        float f3 = f2;
        for (int i2 = 0; i2 < this.j1; i2++) {
            HorizontalSlice horizontalSlice = new HorizontalSlice();
            horizontalSlice.f1243a = constraintWidget;
            if (i2 < this.j1 - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(0);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                horizontalSlice.f1244b = guideline;
                this.o1.add(guideline);
            } else {
                horizontalSlice.f1244b = this;
            }
            constraintWidget = horizontalSlice.f1244b;
            this.m1.add(horizontalSlice);
        }
        q();
    }

    private void p() {
        this.l1.clear();
        float f2 = 100.0f / this.i1;
        ConstraintWidget constraintWidget = this;
        float f3 = f2;
        for (int i2 = 0; i2 < this.i1; i2++) {
            VerticalSlice verticalSlice = new VerticalSlice();
            verticalSlice.f1247a = constraintWidget;
            if (i2 < this.i1 - 1) {
                Guideline guideline = new Guideline();
                guideline.setOrientation(1);
                guideline.setParent(this);
                guideline.setGuidePercent((int) f3);
                f3 += f2;
                verticalSlice.f1248b = guideline;
                this.n1.add(guideline);
            } else {
                verticalSlice.f1248b = this;
            }
            constraintWidget = verticalSlice.f1248b;
            this.l1.add(verticalSlice);
        }
        q();
    }

    private void q() {
        if (this.p1 == null) {
            return;
        }
        int size = this.n1.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n1.get(i2).setDebugSolverName(this.p1, getDebugName() + ".VG" + i2);
        }
        int size2 = this.o1.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.o1.get(i3).setDebugSolverName(this.p1, getDebugName() + ".HG" + i3);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem) {
        super.addToSolver(linearSystem);
        int size = this.L0.size();
        if (size == 0) {
            return;
        }
        setTableDimensions();
        if (linearSystem == this.S0) {
            int size2 = this.n1.size();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= size2) {
                    break;
                }
                Guideline guideline = this.n1.get(i2);
                if (getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z = false;
                }
                guideline.setPositionRelaxed(z);
                guideline.addToSolver(linearSystem);
                i2++;
            }
            int size3 = this.o1.size();
            for (int i3 = 0; i3 < size3; i3++) {
                Guideline guideline2 = this.o1.get(i3);
                guideline2.setPositionRelaxed(getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                guideline2.addToSolver(linearSystem);
            }
            for (int i4 = 0; i4 < size; i4++) {
                this.L0.get(i4).addToSolver(linearSystem);
            }
        }
    }

    public void computeGuidelinesPercentPositions() {
        int size = this.n1.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n1.get(i2).l();
        }
        int size2 = this.o1.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.o1.get(i3).l();
        }
    }

    public void cycleColumnAlignment(int i2) {
        VerticalSlice verticalSlice = this.l1.get(i2);
        int i3 = verticalSlice.f1249c;
        if (i3 == 0) {
            verticalSlice.f1249c = 2;
        } else if (i3 == 1) {
            verticalSlice.f1249c = 0;
        } else if (i3 == 2) {
            verticalSlice.f1249c = 1;
        }
        n();
    }

    public String getColumnAlignmentRepresentation(int i2) {
        int i3 = this.l1.get(i2).f1249c;
        return i3 == 1 ? "L" : i3 == 0 ? "C" : i3 == 3 ? "F" : i3 == 2 ? "R" : "!";
    }

    public String getColumnsAlignmentRepresentation() {
        int size = this.l1.size();
        String str = "";
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = this.l1.get(i2).f1249c;
            if (i3 == 1) {
                str = str + "L";
            } else if (i3 == 0) {
                str = str + "C";
            } else if (i3 == 3) {
                str = str + "F";
            } else if (i3 == 2) {
                str = str + "R";
            }
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getHorizontalGuidelines() {
        return this.o1;
    }

    public int getNumCols() {
        return this.i1;
    }

    public int getNumRows() {
        return this.j1;
    }

    public int getPadding() {
        return this.k1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintTableLayout";
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public ArrayList<Guideline> getVerticalGuidelines() {
        return this.n1;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
    public boolean handlesInternalConstraints() {
        return true;
    }

    public boolean isVerticalGrowth() {
        return this.h1;
    }

    public void setColumnAlignment(int i2, int i3) {
        if (i2 < this.l1.size()) {
            this.l1.get(i2).f1249c = i3;
            n();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.p1 = linearSystem;
        super.setDebugSolverName(linearSystem, str);
        q();
    }

    public void setNumCols(int i2) {
        if (!this.h1 || this.i1 == i2) {
            return;
        }
        this.i1 = i2;
        p();
        setTableDimensions();
    }

    public void setNumRows(int i2) {
        if (this.h1 || this.i1 == i2) {
            return;
        }
        this.j1 = i2;
        o();
        setTableDimensions();
    }

    public void setPadding(int i2) {
        if (i2 > 1) {
            this.k1 = i2;
        }
    }

    public void setTableDimensions() {
        int size = this.L0.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.L0.get(i3).getContainerItemSkip();
        }
        int i4 = size + i2;
        if (this.h1) {
            if (this.i1 == 0) {
                setNumCols(1);
            }
            int i5 = this.i1;
            int i6 = i4 / i5;
            if (i5 * i6 < i4) {
                i6++;
            }
            if (this.j1 == i6 && this.n1.size() == this.i1 - 1) {
                return;
            }
            this.j1 = i6;
            o();
        } else {
            if (this.j1 == 0) {
                setNumRows(1);
            }
            int i7 = this.j1;
            int i8 = i4 / i7;
            if (i7 * i8 < i4) {
                i8++;
            }
            if (this.i1 == i8 && this.o1.size() == this.j1 - 1) {
                return;
            }
            this.i1 = i8;
            p();
        }
        n();
    }

    public void setVerticalGrowth(boolean z) {
        this.h1 = z;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void updateFromSolver(LinearSystem linearSystem) {
        super.updateFromSolver(linearSystem);
        if (linearSystem == this.S0) {
            int size = this.n1.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.n1.get(i2).updateFromSolver(linearSystem);
            }
            int size2 = this.o1.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.o1.get(i3).updateFromSolver(linearSystem);
            }
        }
    }

    public void setColumnAlignment(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == 'L') {
                setColumnAlignment(i2, 1);
            } else if (charAt == 'C') {
                setColumnAlignment(i2, 0);
            } else if (charAt == 'F') {
                setColumnAlignment(i2, 3);
            } else if (charAt == 'R') {
                setColumnAlignment(i2, 2);
            } else {
                setColumnAlignment(i2, 0);
            }
        }
    }

    public ConstraintTableLayout(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.h1 = true;
        this.i1 = 0;
        this.j1 = 0;
        this.k1 = 8;
        this.l1 = new ArrayList<>();
        this.m1 = new ArrayList<>();
        this.n1 = new ArrayList<>();
        this.o1 = new ArrayList<>();
        this.p1 = null;
    }

    public ConstraintTableLayout(int i2, int i3) {
        super(i2, i3);
        this.h1 = true;
        this.i1 = 0;
        this.j1 = 0;
        this.k1 = 8;
        this.l1 = new ArrayList<>();
        this.m1 = new ArrayList<>();
        this.n1 = new ArrayList<>();
        this.o1 = new ArrayList<>();
        this.p1 = null;
    }
}
