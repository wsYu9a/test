package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class ResolutionDimension extends ResolutionNode {

    /* renamed from: c */
    float f1285c = 0.0f;

    public void remove() {
        this.f1287b = 2;
    }

    @Override // androidx.constraintlayout.solver.widgets.ResolutionNode
    public void reset() {
        super.reset();
        this.f1285c = 0.0f;
    }

    public void resolve(int i2) {
        int i3 = this.f1287b;
        if (i3 == 0 || this.f1285c != i2) {
            this.f1285c = i2;
            if (i3 == 1) {
                invalidate();
            }
            didResolve();
        }
    }
}
