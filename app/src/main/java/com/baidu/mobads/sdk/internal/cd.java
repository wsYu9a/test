package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.an;

/* loaded from: classes.dex */
class cd implements an.a {

    /* renamed from: a */
    final /* synthetic */ bw f5691a;

    cd(bw bwVar) {
        this.f5691a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.an.a
    public void a() {
        boolean z;
        z = this.f5691a.A;
        if (z) {
            this.f5691a.A = false;
            this.f5691a.a(false, "remote update Network access failed");
        }
    }
}
