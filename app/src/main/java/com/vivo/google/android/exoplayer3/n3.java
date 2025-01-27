package com.vivo.google.android.exoplayer3;

import java.io.IOException;

/* loaded from: classes4.dex */
public class n3 extends v6 {

    /* renamed from: a */
    public final /* synthetic */ IOException f27865a;

    /* renamed from: b */
    public final /* synthetic */ l3 f27866b;

    public n3(l3 l3Var, IOException iOException) {
        this.f27866b = l3Var;
        this.f27865a = iOException;
    }

    @Override // com.vivo.google.android.exoplayer3.v6
    public void a() {
        this.f27866b.f27647e.onLoadError(this.f27865a);
    }
}
