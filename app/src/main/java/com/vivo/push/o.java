package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public abstract class o {

    /* renamed from: a */
    private int f31042a;

    /* renamed from: b */
    private String f31043b;

    public o(int i2) {
        this.f31042a = -1;
        if (i2 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f31042a = i2;
    }

    private void e(a aVar) {
        aVar.a(com.heytap.mcssdk.n.b.P, this.f31042a);
        aVar.a("client_pkgname", this.f31043b);
        c(aVar);
    }

    public final String a() {
        return this.f31043b;
    }

    public final int b() {
        return this.f31042a;
    }

    protected abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    protected abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f31043b = str;
    }

    public final void b(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a2.a("method", this.f31042a);
        e(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(Intent intent) {
        a a2 = a.a(intent);
        if (a2 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a2);
        Bundle b2 = a2.b();
        if (b2 != null) {
            intent.putExtras(b2);
        }
    }

    public final void a(a aVar) {
        String a2 = p.a(this.f31042a);
        if (a2 == null) {
            a2 = "";
        }
        aVar.a("method", a2);
        e(aVar);
    }

    public final void b(a aVar) {
        String a2 = aVar.a();
        if (!TextUtils.isEmpty(a2)) {
            this.f31043b = a2;
        } else {
            this.f31043b = aVar.a("client_pkgname");
        }
        d(aVar);
    }
}
