package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes2.dex */
class co extends j {

    /* renamed from: b */
    final /* synthetic */ cn f7081b;

    public co(cn cnVar) {
        this.f7081b = cnVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    public Object i() {
        String a10;
        String a11;
        Context context;
        String a12;
        try {
            a10 = this.f7081b.a("key_crash_trace");
            a11 = this.f7081b.a("key_crash_ad");
            if (TextUtils.isEmpty(a10)) {
                return null;
            }
            ck a13 = ck.a();
            context = this.f7081b.f7079m;
            a13.a(context);
            a12 = this.f7081b.a("key_crash_source");
            a13.a(a12, a10, a11);
            this.f7081b.g();
            return null;
        } catch (Exception e10) {
            bt.a().a(e10);
            return null;
        }
    }
}
