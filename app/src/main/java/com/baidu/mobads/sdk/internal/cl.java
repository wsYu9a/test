package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
class cl extends h {

    /* renamed from: b */
    final /* synthetic */ ck f5740b;

    cl(ck ckVar) {
        this.f5740b = ckVar;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    protected Object i() {
        String a2;
        String a3;
        Context context;
        String a4;
        try {
            a2 = this.f5740b.a("key_crash_trace");
            a3 = this.f5740b.a("key_crash_ad");
            if (TextUtils.isEmpty(a2)) {
                return null;
            }
            ch a5 = ch.a();
            context = this.f5740b.f5738h;
            a5.a(context);
            a4 = this.f5740b.a("key_crash_source");
            a5.a(a4, a2, a3);
            this.f5740b.g();
            return null;
        } catch (Exception e2) {
            bq.a().a(e2);
            return null;
        }
    }
}
