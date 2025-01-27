package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* loaded from: classes.dex */
class Chain {

    /* renamed from: a */
    private static final boolean f1221a = false;

    Chain() {
    }

    static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2) {
        int i3;
        int i4;
        ChainHead[] chainHeadArr;
        if (i2 == 0) {
            int i5 = constraintWidgetContainer.Y0;
            chainHeadArr = constraintWidgetContainer.b1;
            i4 = i5;
            i3 = 0;
        } else {
            i3 = 2;
            i4 = constraintWidgetContainer.Z0;
            chainHeadArr = constraintWidgetContainer.a1;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            ChainHead chainHead = chainHeadArr[i6];
            chainHead.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                b(constraintWidgetContainer, linearSystem, i2, i3, chainHead);
            } else if (!Optimizer.b(constraintWidgetContainer, linearSystem, i2, i3, chainHead)) {
                b(constraintWidgetContainer, linearSystem, i2, i3, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r8 == 2) goto L327;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:285:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:293:0x003c, code lost:
    
        if (r8 == 2) goto L327;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0362 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x017e  */
    /* JADX WARN: Type inference failed for: r2v50, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.b(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
