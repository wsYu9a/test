package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.l3;

/* loaded from: classes4.dex */
public class m3 extends v6 {

    /* renamed from: a */
    public final /* synthetic */ l3.d f27767a;

    /* renamed from: b */
    public final /* synthetic */ l3 f27768b;

    public m3(l3 l3Var, l3.d dVar) {
        this.f27768b = l3Var;
        this.f27767a = dVar;
    }

    @Override // com.vivo.google.android.exoplayer3.v6
    public void a() {
        l3.d dVar = this.f27767a;
        g0 g0Var = dVar.f27667c;
        if (g0Var != null) {
            g0Var.release();
            dVar.f27667c = null;
        }
        int size = this.f27768b.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f27768b.o.valueAt(i2).b();
        }
    }
}
