package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* loaded from: classes.dex */
class bz implements ck.a {

    /* renamed from: a */
    final /* synthetic */ bw f5681a;

    bz(bw bwVar) {
        this.f5681a = bwVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(String str) {
        try {
            this.f5681a.b();
            this.f5681a.a(str);
        } catch (Throwable th) {
            bq.a().a(th);
        }
    }
}
