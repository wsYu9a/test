package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static final boolean EARLY_TERMINATION = true;
    private static BasicMeasure.Measure measure = new BasicMeasure.Measure();
    private static int hcount = 0;
    private static int vcount = 0;

    private static boolean canMeasure(int i10, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.getParent() != null ? (ConstraintWidgetContainer) constraintWidget.getParent() : null;
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z10 = horizontalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedHorizontally() || horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (horizontalDimensionBehaviour == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0)) || (horizontalDimensionBehaviour == dimensionBehaviour2 && constraintWidget.mMatchConstraintDefaultWidth == 1 && constraintWidget.hasResolvedTargets(0, constraintWidget.getWidth()));
        boolean z11 = verticalDimensionBehaviour == dimensionBehaviour5 || constraintWidget.isResolvedVertically() || verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (verticalDimensionBehaviour == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1)) || (verticalDimensionBehaviour == dimensionBehaviour && constraintWidget.mMatchConstraintDefaultHeight == 1 && constraintWidget.hasResolvedTargets(1, constraintWidget.getHeight()));
        if (constraintWidget.mDimensionRatio <= 0.0f || !(z10 || z11)) {
            return z10 && z11;
        }
        return true;
    }

    private static void horizontalSolvingPass(int i10, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isHorizontalSolvingPassDone()) {
            return;
        }
        hcount++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i11 = i10 + 1;
            if (canMeasure(i11, constraintWidget)) {
                ConstraintWidgetContainer.measure(i11, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i12 = i10 + 1;
                boolean canMeasure = canMeasure(i12, constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    ConstraintWidgetContainer.measure(i12, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z11 = (next == constraintWidget2.mLeft && (constraintAnchor4 = constraintWidget2.mRight.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor3 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor3.hasFinalValue());
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.mLeft;
                        if (next == constraintAnchor5 && constraintWidget2.mRight.mTarget == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                            horizontalSolvingPass(i12, constraintWidget2, measurer, z10);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.mRight;
                            if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor6.getMargin();
                                constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                                horizontalSolvingPass(i12, constraintWidget2, measurer, z10);
                            } else if (z11 && !constraintWidget2.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(i12, measurer, constraintWidget2, z10);
                            }
                        }
                    }
                } else if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && ((constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == 0.0f)) && !constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout() && z11 && !constraintWidget2.isInHorizontalChain())) {
                    solveHorizontalMatchConstraint(i12, constraintWidget, measurer, constraintWidget2, z10);
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i13 = i10 + 1;
                boolean canMeasure2 = canMeasure(i13, constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                    ConstraintWidgetContainer.measure(i13, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z12 = (next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue());
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget3.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.mLeft;
                        if (next2 == constraintAnchor7 && constraintWidget3.mRight.mTarget == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                            horizontalSolvingPass(i13, constraintWidget3, measurer, z10);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.mRight;
                            if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                                horizontalSolvingPass(i13, constraintWidget3, measurer, z10);
                            } else if (z12 && !constraintWidget3.isInHorizontalChain()) {
                                solveHorizontalCenterConstraints(i13, measurer, constraintWidget3, z10);
                            }
                        }
                    }
                } else if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z12 && !constraintWidget3.isInHorizontalChain()) {
                        solveHorizontalMatchConstraint(i13, constraintWidget, measurer, constraintWidget3, z10);
                    }
                }
            }
        }
        constraintWidget.markHorizontalSolvingPassDone();
    }

    public static String ls(int i10) {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append("  ");
        }
        sb2.append("+-(" + i10 + ") ");
        return sb2.toString();
    }

    private static void solveBarrier(int i10, Barrier barrier, BasicMeasure.Measurer measurer, int i11, boolean z10) {
        if (barrier.allSolved()) {
            if (i11 == 0) {
                horizontalSolvingPass(i10 + 1, barrier, measurer, z10);
            } else {
                verticalSolvingPass(i10 + 1, barrier, measurer);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d4, code lost:
    
        if (r6.mOwner == r0) goto L245;
     */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0151  */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v43 */
    /* JADX WARN: Type inference failed for: r2v7, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r20, androidx.constraintlayout.core.LinearSystem r21, int r22, int r23, androidx.constraintlayout.core.widgets.ChainHead r24, boolean r25, boolean r26, boolean r27) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.Direct.solveChain(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, androidx.constraintlayout.core.LinearSystem, int, int, androidx.constraintlayout.core.widgets.ChainHead, boolean, boolean, boolean):boolean");
    }

    private static void solveHorizontalCenterConstraints(int i10, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z10) {
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i11 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i11 = (finalValue - finalValue2) - width;
        }
        int i12 = ((int) (i11 > 0 ? (horizontalBiasPercent * i11) + 0.5f : horizontalBiasPercent * i11)) + finalValue;
        int i13 = i12 + width;
        if (finalValue > finalValue2) {
            i13 = i12 - width;
        }
        constraintWidget.setFinalHorizontal(i12, i13);
        horizontalSolvingPass(i10 + 1, constraintWidget, measurer, z10);
    }

    private static void solveHorizontalMatchConstraint(int i10, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z10) {
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue2 >= finalValue) {
            int width = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i11 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i11 == 2) {
                    width = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getWidth() : constraintWidget.getParent().getWidth()));
                } else if (i11 == 0) {
                    width = finalValue2 - finalValue;
                }
                width = Math.max(constraintWidget2.mMatchConstraintMinWidth, width);
                int i12 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i12 > 0) {
                    width = Math.min(i12, width);
                }
            }
            int i13 = finalValue + ((int) ((horizontalBiasPercent * ((finalValue2 - finalValue) - width)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i13, width + i13);
            horizontalSolvingPass(i10 + 1, constraintWidget2, measurer, z10);
        }
    }

    private static void solveVerticalCenterConstraints(int i10, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i11 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i11 = (finalValue - finalValue2) - height;
        }
        int i12 = (int) (i11 > 0 ? (verticalBiasPercent * i11) + 0.5f : verticalBiasPercent * i11);
        int i13 = finalValue + i12;
        int i14 = i13 + height;
        if (finalValue > finalValue2) {
            i13 = finalValue - i12;
            i14 = i13 - height;
        }
        constraintWidget.setFinalVertical(i13, i14);
        verticalSolvingPass(i10 + 1, constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(int i10, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue2 >= finalValue) {
            int height = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i11 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i11 == 2) {
                    height = (int) (verticalBiasPercent * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getHeight() : constraintWidget.getParent().getHeight()));
                } else if (i11 == 0) {
                    height = finalValue2 - finalValue;
                }
                height = Math.max(constraintWidget2.mMatchConstraintMinHeight, height);
                int i12 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i12 > 0) {
                    height = Math.min(i12, height);
                }
            }
            int i13 = finalValue + ((int) ((verticalBiasPercent * ((finalValue2 - finalValue) - height)) + 0.5f));
            constraintWidget2.setFinalVertical(i13, height + i13);
            verticalSolvingPass(i10 + 1, constraintWidget2, measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        hcount = 0;
        vcount = 0;
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i10 = 0; i10 < size; i10++) {
            children.get(i10).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = children.get(i11);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i12 = 0; i12 < size; i12++) {
                ConstraintWidget constraintWidget2 = children.get(i12);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(0, guideline2, measurer, isRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(0, constraintWidgetContainer, measurer, isRtl);
        if (z11) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget3 = children.get(i13);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(0, barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = children.get(i14);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i15 = 0; i15 < size; i15++) {
                ConstraintWidget constraintWidget5 = children.get(i15);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(1, guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(0, constraintWidgetContainer, measurer);
        if (z13) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget6 = children.get(i16);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(0, barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i17 = 0; i17 < size; i17++) {
            ConstraintWidget constraintWidget7 = children.get(i17);
            if (constraintWidget7.isMeasureRequested() && canMeasure(0, constraintWidget7)) {
                ConstraintWidgetContainer.measure(0, constraintWidget7, measurer, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
                if (!(constraintWidget7 instanceof Guideline)) {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else if (((Guideline) constraintWidget7).getOrientation() == 0) {
                    verticalSolvingPass(0, constraintWidget7, measurer);
                } else {
                    horizontalSolvingPass(0, constraintWidget7, measurer, isRtl);
                }
            }
        }
    }

    private static void verticalSolvingPass(int i10, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.isVerticalSolvingPassDone()) {
            return;
        }
        vcount++;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested()) {
            int i11 = i10 + 1;
            if (canMeasure(i11, constraintWidget)) {
                ConstraintWidgetContainer.measure(i11, constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
            }
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                int i12 = i10 + 1;
                boolean canMeasure = canMeasure(i12, constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    ConstraintWidgetContainer.measure(i12, constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z10 = (next == constraintWidget2.mTop && (constraintAnchor4 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor4.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor3 = constraintWidget2.mTop.mTarget) != null && constraintAnchor3.hasFinalValue());
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget2.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour != dimensionBehaviour || canMeasure) {
                    if (!constraintWidget2.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor5 = constraintWidget2.mTop;
                        if (next == constraintAnchor5 && constraintWidget2.mBottom.mTarget == null) {
                            int margin = constraintAnchor5.getMargin() + finalValue;
                            constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                            verticalSolvingPass(i12, constraintWidget2, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.mBottom;
                            if (next == constraintAnchor6 && constraintAnchor5.mTarget == null) {
                                int margin2 = finalValue - constraintAnchor6.getMargin();
                                constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                                verticalSolvingPass(i12, constraintWidget2, measurer);
                            } else if (z10 && !constraintWidget2.isInVerticalChain()) {
                                solveVerticalCenterConstraints(i12, measurer, constraintWidget2);
                            }
                        }
                    }
                } else if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout() && z10 && !constraintWidget2.isInVerticalChain()) {
                        solveVerticalMatchConstraint(i12, constraintWidget, measurer, constraintWidget2);
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it2 = anchor2.getDependents().iterator();
            while (it2.hasNext()) {
                ConstraintAnchor next2 = it2.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                int i13 = i10 + 1;
                boolean canMeasure2 = canMeasure(i13, constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                    ConstraintWidgetContainer.measure(i13, constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                boolean z11 = (next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue());
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget3.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour2 != dimensionBehaviour2 || canMeasure2) {
                    if (!constraintWidget3.isMeasureRequested()) {
                        ConstraintAnchor constraintAnchor7 = constraintWidget3.mTop;
                        if (next2 == constraintAnchor7 && constraintWidget3.mBottom.mTarget == null) {
                            int margin3 = constraintAnchor7.getMargin() + finalValue2;
                            constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                            verticalSolvingPass(i13, constraintWidget3, measurer);
                        } else {
                            ConstraintAnchor constraintAnchor8 = constraintWidget3.mBottom;
                            if (next2 == constraintAnchor8 && constraintAnchor7.mTarget == null) {
                                int margin4 = finalValue2 - constraintAnchor8.getMargin();
                                constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                                verticalSolvingPass(i13, constraintWidget3, measurer);
                            } else if (z11 && !constraintWidget3.isInVerticalChain()) {
                                solveVerticalCenterConstraints(i13, measurer, constraintWidget3);
                            }
                        }
                    }
                } else if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                    if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z11 && !constraintWidget3.isInVerticalChain()) {
                        solveVerticalMatchConstraint(i13, constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
            int finalValue3 = anchor3.getFinalValue();
            Iterator<ConstraintAnchor> it3 = anchor3.getDependents().iterator();
            while (it3.hasNext()) {
                ConstraintAnchor next3 = it3.next();
                ConstraintWidget constraintWidget4 = next3.mOwner;
                int i14 = i10 + 1;
                boolean canMeasure3 = canMeasure(i14, constraintWidget4);
                if (constraintWidget4.isMeasureRequested() && canMeasure3) {
                    ConstraintWidgetContainer.measure(i14, constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if (constraintWidget4.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) {
                    if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.mBaseline) {
                        constraintWidget4.setFinalBaseline(next3.getMargin() + finalValue3);
                        verticalSolvingPass(i14, constraintWidget4, measurer);
                    }
                }
            }
        }
        constraintWidget.markVerticalSolvingPassDone();
    }
}
