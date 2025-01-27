package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class ConstraintWidgetContainer extends WidgetContainer {
    private static final boolean M0 = true;
    private static final int N0 = 8;
    private static final boolean O0 = false;
    private static final boolean P0 = false;
    static final boolean Q0 = false;
    private boolean R0;
    protected LinearSystem S0;
    private Snapshot T0;
    int U0;
    int V0;
    int W0;
    int X0;
    int Y0;
    int Z0;
    ChainHead[] a1;
    ChainHead[] b1;
    private int c1;
    private boolean d1;
    private boolean e1;
    int f1;
    public boolean mGroupsWrapOptimized;
    public boolean mHorizontalWrapOptimized;
    public boolean mSkipSolver;
    public boolean mVerticalWrapOptimized;
    public List<ConstraintWidgetGroup> mWidgetGroups;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;

    public ConstraintWidgetContainer() {
        this.R0 = false;
        this.S0 = new LinearSystem();
        this.Y0 = 0;
        this.Z0 = 0;
        this.a1 = new ChainHead[4];
        this.b1 = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.c1 = 7;
        this.mSkipSolver = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = 0;
    }

    private void k(ConstraintWidget constraintWidget) {
        int i2 = this.Y0 + 1;
        ChainHead[] chainHeadArr = this.b1;
        if (i2 >= chainHeadArr.length) {
            this.b1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.b1[this.Y0] = new ChainHead(constraintWidget, 0, isRtl());
        this.Y0++;
    }

    private void l(ConstraintWidget constraintWidget) {
        int i2 = this.Z0 + 1;
        ChainHead[] chainHeadArr = this.a1;
        if (i2 >= chainHeadArr.length) {
            this.a1 = (ChainHead[]) Arrays.copyOf(chainHeadArr, chainHeadArr.length * 2);
        }
        this.a1[this.Z0] = new ChainHead(constraintWidget, 1, isRtl());
        this.Z0++;
    }

    private void m() {
        this.Y0 = 0;
        this.Z0 = 0;
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        addToSolver(linearSystem);
        int size = this.L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            if (constraintWidget instanceof ConstraintWidgetContainer) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.N;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                }
                constraintWidget.addToSolver(linearSystem);
                if (dimensionBehaviour == dimensionBehaviour3) {
                    constraintWidget.setHorizontalDimensionBehaviour(dimensionBehaviour);
                }
                if (dimensionBehaviour2 == dimensionBehaviour3) {
                    constraintWidget.setVerticalDimensionBehaviour(dimensionBehaviour2);
                }
            } else {
                Optimizer.c(this, linearSystem, constraintWidget);
                constraintWidget.addToSolver(linearSystem);
            }
        }
        if (this.Y0 > 0) {
            Chain.a(this, linearSystem, 0);
        }
        if (this.Z0 > 0) {
            Chain.a(this, linearSystem, 1);
        }
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void analyze(int i2) {
        super.analyze(i2);
        int size = this.L0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.L0.get(i3).analyze(i2);
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.S0.fillMetrics(metrics);
    }

    public ArrayList<Guideline> getHorizontalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 0) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public int getOptimizationLevel() {
        return this.c1;
    }

    public LinearSystem getSystem() {
        return this.S0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList<Guideline> getVerticalGuidelines() {
        ArrayList<Guideline> arrayList = new ArrayList<>();
        int size = this.L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    arrayList.add(guideline);
                }
            }
        }
        return arrayList;
    }

    public List<ConstraintWidgetGroup> getWidgetGroups() {
        return this.mWidgetGroups;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.e1;
    }

    public boolean isRtl() {
        return this.R0;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.d1;
    }

    void j(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            k(constraintWidget);
        } else if (i2 == 1) {
            l(constraintWidget);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0287  */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v25 */
    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layout() {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer.layout():void");
    }

    public void optimize() {
        if (!optimizeFor(8)) {
            analyze(this.c1);
        }
        solveGraph();
    }

    public boolean optimizeFor(int i2) {
        return (this.c1 & i2) == i2;
    }

    public void optimizeForDimensions(int i2, int i3) {
        ResolutionDimension resolutionDimension;
        ResolutionDimension resolutionDimension2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.N[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && (resolutionDimension2 = this.l) != null) {
            resolutionDimension2.resolve(i2);
        }
        if (this.N[1] == dimensionBehaviour2 || (resolutionDimension = this.m) == null) {
            return;
        }
        resolutionDimension.resolve(i3);
    }

    public void optimizeReset() {
        int size = this.L0.size();
        resetResolutionNodes();
        for (int i2 = 0; i2 < size; i2++) {
            this.L0.get(i2).resetResolutionNodes();
        }
    }

    public void preOptimize() {
        optimizeReset();
        analyze(this.c1);
    }

    @Override // androidx.constraintlayout.solver.widgets.WidgetContainer, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.S0.reset();
        this.U0 = 0;
        this.W0 = 0;
        this.V0 = 0;
        this.X0 = 0;
        this.mWidgetGroups.clear();
        this.mSkipSolver = false;
        super.reset();
    }

    public void resetGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.invalidateAnchors();
        resolutionNode2.invalidateAnchors();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void setOptimizationLevel(int i2) {
        this.c1 = i2;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.U0 = i2;
        this.V0 = i3;
        this.W0 = i4;
        this.X0 = i5;
    }

    public void setRtl(boolean z) {
        this.R0 = z;
    }

    public void solveGraph() {
        ResolutionAnchor resolutionNode = getAnchor(ConstraintAnchor.Type.LEFT).getResolutionNode();
        ResolutionAnchor resolutionNode2 = getAnchor(ConstraintAnchor.Type.TOP).getResolutionNode();
        resolutionNode.resolve(null, 0.0f);
        resolutionNode2.resolve(null, 0.0f);
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] zArr) {
        zArr[2] = false;
        updateFromSolver(linearSystem);
        int size = this.L0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.L0.get(i2);
            constraintWidget.updateFromSolver(linearSystem);
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.N[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && constraintWidget.getWidth() < constraintWidget.getWrapWidth()) {
                zArr[2] = true;
            }
            if (constraintWidget.N[1] == dimensionBehaviour2 && constraintWidget.getHeight() < constraintWidget.getWrapHeight()) {
                zArr[2] = true;
            }
        }
    }

    public ConstraintWidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
        this.R0 = false;
        this.S0 = new LinearSystem();
        this.Y0 = 0;
        this.Z0 = 0;
        this.a1 = new ChainHead[4];
        this.b1 = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.c1 = 7;
        this.mSkipSolver = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = 0;
    }

    public ConstraintWidgetContainer(int i2, int i3) {
        super(i2, i3);
        this.R0 = false;
        this.S0 = new LinearSystem();
        this.Y0 = 0;
        this.Z0 = 0;
        this.a1 = new ChainHead[4];
        this.b1 = new ChainHead[4];
        this.mWidgetGroups = new ArrayList();
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.c1 = 7;
        this.mSkipSolver = false;
        this.d1 = false;
        this.e1 = false;
        this.f1 = 0;
    }
}
