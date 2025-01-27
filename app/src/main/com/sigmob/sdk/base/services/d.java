package com.sigmob.sdk.base.services;

import android.content.Context;
import android.content.IntentFilter;
import com.sigmob.sdk.base.common.u;
import com.sigmob.sdk.base.services.j;

/* loaded from: classes4.dex */
public class d implements j.a {

    /* renamed from: a */
    public c f18353a;

    /* renamed from: b */
    public k f18354b = k.STOP;

    public d() {
        if (this.f18353a == null) {
            this.f18353a = new c();
        }
    }

    public void a(Context context) {
        u.a(context, this.f18353a, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), true);
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void b() {
        b(com.sigmob.sdk.a.d());
        this.f18354b = k.STOP;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k c() {
        return null;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error d() {
        return null;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean a() {
        a(com.sigmob.sdk.a.d());
        this.f18354b = k.RUNNING;
        return false;
    }

    public void b(Context context) {
        context.unregisterReceiver(this.f18353a);
    }
}
