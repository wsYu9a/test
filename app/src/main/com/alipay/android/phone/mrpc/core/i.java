package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* loaded from: classes.dex */
public final class i implements g {

    /* renamed from: a */
    public final /* synthetic */ aa f6369a;

    /* renamed from: b */
    public final /* synthetic */ h f6370b;

    public i(h hVar, aa aaVar) {
        this.f6370b = hVar;
        this.f6369a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final String a() {
        return this.f6369a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final ab b() {
        Context context;
        context = this.f6370b.f6368a;
        return l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final aa c() {
        return this.f6369a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.f6369a.c();
    }
}
