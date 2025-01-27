package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class ConstraintWidgetGroup {

    /* renamed from: a */
    int f1264a;

    /* renamed from: b */
    int f1265b;

    /* renamed from: c */
    List<ConstraintWidget> f1266c;

    /* renamed from: d */
    List<ConstraintWidget> f1267d;

    /* renamed from: e */
    HashSet<ConstraintWidget> f1268e;

    /* renamed from: f */
    HashSet<ConstraintWidget> f1269f;

    /* renamed from: g */
    List<ConstraintWidget> f1270g;

    /* renamed from: h */
    List<ConstraintWidget> f1271h;
    public List<ConstraintWidget> mConstrainedGroup;
    public final int[] mGroupDimensions;
    public boolean mSkipSolver;

    ConstraintWidgetGroup(List<ConstraintWidget> list) {
        this.f1264a = -1;
        this.f1265b = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{-1, -1};
        this.f1266c = new ArrayList();
        this.f1267d = new ArrayList();
        this.f1268e = new HashSet<>();
        this.f1269f = new HashSet<>();
        this.f1270g = new ArrayList();
        this.f1271h = new ArrayList();
        this.mConstrainedGroup = list;
    }

    private void d(ArrayList<ConstraintWidget> arrayList, ConstraintWidget constraintWidget) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget.B0) {
            return;
        }
        arrayList.add(constraintWidget);
        constraintWidget.B0 = true;
        if (constraintWidget.isFullyResolved()) {
            return;
        }
        if (constraintWidget instanceof Helper) {
            Helper helper = (Helper) constraintWidget;
            int i2 = helper.M0;
            for (int i3 = 0; i3 < i2; i3++) {
                d(arrayList, helper.L0[i3]);
            }
        }
        int length = constraintWidget.L.length;
        for (int i4 = 0; i4 < length; i4++) {
            ConstraintAnchor constraintAnchor = constraintWidget.L[i4].f1237f;
            if (constraintAnchor != null && (constraintWidget2 = constraintAnchor.f1235d) != constraintWidget.getParent()) {
                d(arrayList, constraintWidget2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(androidx.constraintlayout.solver.widgets.ConstraintWidget r7) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.ConstraintWidgetGroup.e(androidx.constraintlayout.solver.widgets.ConstraintWidget):void");
    }

    void a(ConstraintWidget constraintWidget, int i2) {
        if (i2 == 0) {
            this.f1268e.add(constraintWidget);
        } else if (i2 == 1) {
            this.f1269f.add(constraintWidget);
        }
    }

    Set<ConstraintWidget> b(int i2) {
        if (i2 == 0) {
            return this.f1268e;
        }
        if (i2 == 1) {
            return this.f1269f;
        }
        return null;
    }

    List<ConstraintWidget> c() {
        if (!this.f1270g.isEmpty()) {
            return this.f1270g;
        }
        int size = this.mConstrainedGroup.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = this.mConstrainedGroup.get(i2);
            if (!constraintWidget.z0) {
                d((ArrayList) this.f1270g, constraintWidget);
            }
        }
        this.f1271h.clear();
        this.f1271h.addAll(this.mConstrainedGroup);
        this.f1271h.removeAll(this.f1270g);
        return this.f1270g;
    }

    void f() {
        int size = this.f1271h.size();
        for (int i2 = 0; i2 < size; i2++) {
            e(this.f1271h.get(i2));
        }
    }

    public List<ConstraintWidget> getStartWidgets(int i2) {
        if (i2 == 0) {
            return this.f1266c;
        }
        if (i2 == 1) {
            return this.f1267d;
        }
        return null;
    }

    ConstraintWidgetGroup(List<ConstraintWidget> list, boolean z) {
        this.f1264a = -1;
        this.f1265b = -1;
        this.mSkipSolver = false;
        this.mGroupDimensions = new int[]{-1, -1};
        this.f1266c = new ArrayList();
        this.f1267d = new ArrayList();
        this.f1268e = new HashSet<>();
        this.f1269f = new HashSet<>();
        this.f1270g = new ArrayList();
        this.f1271h = new ArrayList();
        this.mConstrainedGroup = list;
        this.mSkipSolver = z;
    }
}
