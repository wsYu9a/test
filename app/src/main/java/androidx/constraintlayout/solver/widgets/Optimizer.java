package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* loaded from: classes.dex */
public class Optimizer {
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_GROUPS = 32;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 7;

    /* renamed from: a */
    static boolean[] f1273a = new boolean[3];

    /* renamed from: b */
    static final int f1274b = 0;

    /* renamed from: c */
    static final int f1275c = 1;

    /* renamed from: d */
    static final int f1276d = 2;

    static void a(int i2, ConstraintWidget constraintWidget) {
        constraintWidget.updateResolutionNodes();
        ResolutionAnchor resolutionNode = constraintWidget.D.getResolutionNode();
        ResolutionAnchor resolutionNode2 = constraintWidget.E.getResolutionNode();
        ResolutionAnchor resolutionNode3 = constraintWidget.F.getResolutionNode();
        ResolutionAnchor resolutionNode4 = constraintWidget.G.getResolutionNode();
        boolean z = (i2 & 8) == 8;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.N[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = dimensionBehaviour == dimensionBehaviour2 && d(constraintWidget, 0);
        if (resolutionNode.f1283i != 4 && resolutionNode3.f1283i != 4) {
            if (constraintWidget.N[0] == ConstraintWidget.DimensionBehaviour.FIXED || (z2 && constraintWidget.getVisibility() == 8)) {
                ConstraintAnchor constraintAnchor = constraintWidget.D.f1237f;
                if (constraintAnchor == null && constraintWidget.F.f1237f == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintAnchor != null && constraintWidget.F.f1237f == null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, constraintWidget.getWidth());
                    }
                } else if (constraintAnchor == null && constraintWidget.F.f1237f != null) {
                    resolutionNode.setType(1);
                    resolutionNode3.setType(1);
                    resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -constraintWidget.getWidth());
                    }
                } else if (constraintAnchor != null && constraintWidget.F.f1237f != null) {
                    resolutionNode.setType(2);
                    resolutionNode3.setType(2);
                    if (z) {
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                        constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                        resolutionNode.setOpposite(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                        resolutionNode3.setOpposite(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.setOpposite(resolutionNode3, -constraintWidget.getWidth());
                        resolutionNode3.setOpposite(resolutionNode, constraintWidget.getWidth());
                    }
                }
            } else if (z2) {
                int width = constraintWidget.getWidth();
                resolutionNode.setType(1);
                resolutionNode3.setType(1);
                ConstraintAnchor constraintAnchor2 = constraintWidget.D.f1237f;
                if (constraintAnchor2 == null && constraintWidget.F.f1237f == null) {
                    if (z) {
                        resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode3.dependsOn(resolutionNode, width);
                    }
                } else if (constraintAnchor2 == null || constraintWidget.F.f1237f != null) {
                    if (constraintAnchor2 != null || constraintWidget.F.f1237f == null) {
                        if (constraintAnchor2 != null && constraintWidget.F.f1237f != null) {
                            if (z) {
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode);
                                constraintWidget.getResolutionWidth().addDependent(resolutionNode3);
                            }
                            if (constraintWidget.R == 0.0f) {
                                resolutionNode.setType(3);
                                resolutionNode3.setType(3);
                                resolutionNode.setOpposite(resolutionNode3, 0.0f);
                                resolutionNode3.setOpposite(resolutionNode, 0.0f);
                            } else {
                                resolutionNode.setType(2);
                                resolutionNode3.setType(2);
                                resolutionNode.setOpposite(resolutionNode3, -width);
                                resolutionNode3.setOpposite(resolutionNode, width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (z) {
                        resolutionNode.dependsOn(resolutionNode3, -1, constraintWidget.getResolutionWidth());
                    } else {
                        resolutionNode.dependsOn(resolutionNode3, -width);
                    }
                } else if (z) {
                    resolutionNode3.dependsOn(resolutionNode, 1, constraintWidget.getResolutionWidth());
                } else {
                    resolutionNode3.dependsOn(resolutionNode, width);
                }
            }
        }
        boolean z3 = constraintWidget.N[1] == dimensionBehaviour2 && d(constraintWidget, 1);
        if (resolutionNode2.f1283i == 4 || resolutionNode4.f1283i == 4) {
            return;
        }
        if (constraintWidget.N[1] != ConstraintWidget.DimensionBehaviour.FIXED && (!z3 || constraintWidget.getVisibility() != 8)) {
            if (z3) {
                int height = constraintWidget.getHeight();
                resolutionNode2.setType(1);
                resolutionNode4.setType(1);
                ConstraintAnchor constraintAnchor3 = constraintWidget.E.f1237f;
                if (constraintAnchor3 == null && constraintWidget.G.f1237f == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        return;
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                        return;
                    }
                }
                if (constraintAnchor3 != null && constraintWidget.G.f1237f == null) {
                    if (z) {
                        resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
                        return;
                    } else {
                        resolutionNode4.dependsOn(resolutionNode2, height);
                        return;
                    }
                }
                if (constraintAnchor3 == null && constraintWidget.G.f1237f != null) {
                    if (z) {
                        resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
                        return;
                    } else {
                        resolutionNode2.dependsOn(resolutionNode4, -height);
                        return;
                    }
                }
                if (constraintAnchor3 == null || constraintWidget.G.f1237f == null) {
                    return;
                }
                if (z) {
                    constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
                    constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
                }
                if (constraintWidget.R == 0.0f) {
                    resolutionNode2.setType(3);
                    resolutionNode4.setType(3);
                    resolutionNode2.setOpposite(resolutionNode4, 0.0f);
                    resolutionNode4.setOpposite(resolutionNode2, 0.0f);
                    return;
                }
                resolutionNode2.setType(2);
                resolutionNode4.setType(2);
                resolutionNode2.setOpposite(resolutionNode4, -height);
                resolutionNode4.setOpposite(resolutionNode2, height);
                constraintWidget.setHeight(height);
                if (constraintWidget.d0 > 0) {
                    constraintWidget.H.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.d0);
                    return;
                }
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor4 = constraintWidget.E.f1237f;
        if (constraintAnchor4 == null && constraintWidget.G.f1237f == null) {
            resolutionNode2.setType(1);
            resolutionNode4.setType(1);
            if (z) {
                resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
            } else {
                resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
            }
            ConstraintAnchor constraintAnchor5 = constraintWidget.H;
            if (constraintAnchor5.f1237f != null) {
                constraintAnchor5.getResolutionNode().setType(1);
                resolutionNode2.dependsOn(1, constraintWidget.H.getResolutionNode(), -constraintWidget.d0);
                return;
            }
            return;
        }
        if (constraintAnchor4 != null && constraintWidget.G.f1237f == null) {
            resolutionNode2.setType(1);
            resolutionNode4.setType(1);
            if (z) {
                resolutionNode4.dependsOn(resolutionNode2, 1, constraintWidget.getResolutionHeight());
            } else {
                resolutionNode4.dependsOn(resolutionNode2, constraintWidget.getHeight());
            }
            if (constraintWidget.d0 > 0) {
                constraintWidget.H.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.d0);
                return;
            }
            return;
        }
        if (constraintAnchor4 == null && constraintWidget.G.f1237f != null) {
            resolutionNode2.setType(1);
            resolutionNode4.setType(1);
            if (z) {
                resolutionNode2.dependsOn(resolutionNode4, -1, constraintWidget.getResolutionHeight());
            } else {
                resolutionNode2.dependsOn(resolutionNode4, -constraintWidget.getHeight());
            }
            if (constraintWidget.d0 > 0) {
                constraintWidget.H.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.d0);
                return;
            }
            return;
        }
        if (constraintAnchor4 == null || constraintWidget.G.f1237f == null) {
            return;
        }
        resolutionNode2.setType(2);
        resolutionNode4.setType(2);
        if (z) {
            resolutionNode2.setOpposite(resolutionNode4, -1, constraintWidget.getResolutionHeight());
            resolutionNode4.setOpposite(resolutionNode2, 1, constraintWidget.getResolutionHeight());
            constraintWidget.getResolutionHeight().addDependent(resolutionNode2);
            constraintWidget.getResolutionWidth().addDependent(resolutionNode4);
        } else {
            resolutionNode2.setOpposite(resolutionNode4, -constraintWidget.getHeight());
            resolutionNode4.setOpposite(resolutionNode2, constraintWidget.getHeight());
        }
        if (constraintWidget.d0 > 0) {
            constraintWidget.H.getResolutionNode().dependsOn(1, resolutionNode2, constraintWidget.d0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:215:0x002e, code lost:
    
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x003c, code lost:
    
        if (r7 == 2) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r7 == 2) goto L255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002c, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00f8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r24, androidx.constraintlayout.solver.LinearSystem r25, int r26, int r27, androidx.constraintlayout.solver.widgets.ChainHead r28) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Optimizer.b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):boolean");
    }

    static void c(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.N[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.N[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i2 = constraintWidget.D.mMargin;
            int width = constraintWidgetContainer.getWidth() - constraintWidget.F.mMargin;
            ConstraintAnchor constraintAnchor = constraintWidget.D;
            constraintAnchor.k = linearSystem.createObjectVariable(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.F;
            constraintAnchor2.k = linearSystem.createObjectVariable(constraintAnchor2);
            linearSystem.addEquality(constraintWidget.D.k, i2);
            linearSystem.addEquality(constraintWidget.F.k, width);
            constraintWidget.mHorizontalResolution = 2;
            constraintWidget.setHorizontalDimension(i2, width);
        }
        if (constraintWidgetContainer.N[1] == dimensionBehaviour2 || constraintWidget.N[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            return;
        }
        int i3 = constraintWidget.E.mMargin;
        int height = constraintWidgetContainer.getHeight() - constraintWidget.G.mMargin;
        ConstraintAnchor constraintAnchor3 = constraintWidget.E;
        constraintAnchor3.k = linearSystem.createObjectVariable(constraintAnchor3);
        ConstraintAnchor constraintAnchor4 = constraintWidget.G;
        constraintAnchor4.k = linearSystem.createObjectVariable(constraintAnchor4);
        linearSystem.addEquality(constraintWidget.E.k, i3);
        linearSystem.addEquality(constraintWidget.G.k, height);
        if (constraintWidget.d0 > 0 || constraintWidget.getVisibility() == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.H;
            constraintAnchor5.k = linearSystem.createObjectVariable(constraintAnchor5);
            linearSystem.addEquality(constraintWidget.H.k, constraintWidget.d0 + i3);
        }
        constraintWidget.mVerticalResolution = 2;
        constraintWidget.setVerticalDimension(i3, height);
    }

    private static boolean d(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.N;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i2];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour != dimensionBehaviour2) {
            return false;
        }
        if (constraintWidget.R != 0.0f) {
            if (dimensionBehaviourArr[i2 != 0 ? (char) 0 : (char) 1] == dimensionBehaviour2) {
            }
            return false;
        }
        if (i2 == 0) {
            if (constraintWidget.n != 0 || constraintWidget.q != 0 || constraintWidget.r != 0) {
                return false;
            }
        } else if (constraintWidget.o != 0 || constraintWidget.t != 0 || constraintWidget.u != 0) {
            return false;
        }
        return true;
    }

    static void e(ConstraintWidget constraintWidget, int i2, int i3) {
        int i4 = i2 * 2;
        int i5 = i4 + 1;
        constraintWidget.L[i4].getResolutionNode().f1281g = constraintWidget.getParent().D.getResolutionNode();
        constraintWidget.L[i4].getResolutionNode().f1282h = i3;
        constraintWidget.L[i4].getResolutionNode().f1287b = 1;
        constraintWidget.L[i5].getResolutionNode().f1281g = constraintWidget.L[i4].getResolutionNode();
        constraintWidget.L[i5].getResolutionNode().f1282h = constraintWidget.getLength(i2);
        constraintWidget.L[i5].getResolutionNode().f1287b = 1;
    }
}
