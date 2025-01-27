package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* loaded from: classes2.dex */
class cg implements an.a {

    /* renamed from: a */
    final /* synthetic */ bz f7022a;

    public cg(bz bzVar) {
        this.f7022a = bzVar;
    }

    @Override // com.baidu.mobads.sdk.internal.an.a
    public void a() {
        boolean z10;
        z10 = this.f7022a.A;
        if (z10) {
            this.f7022a.A = false;
            this.f7022a.a(false, "remote update Network access failed");
        }
    }
}
