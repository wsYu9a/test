package t6;

import t5.l;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a */
    public final boolean f30738a;

    public e(boolean z10) {
        this.f30738a = z10;
    }

    public void a(l[] lVarArr) {
        if (!this.f30738a || lVarArr == null || lVarArr.length < 3) {
            return;
        }
        l lVar = lVarArr[0];
        lVarArr[0] = lVarArr[2];
        lVarArr[2] = lVar;
    }

    public boolean b() {
        return this.f30738a;
    }
}
