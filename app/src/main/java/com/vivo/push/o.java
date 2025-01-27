package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public abstract class o {

    /* renamed from: a */
    private int f25078a;

    /* renamed from: b */
    private String f25079b;

    public o(int i10) {
        this.f25078a = -1;
        if (i10 < 0) {
            throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
        }
        this.f25078a = i10;
    }

    private void e(a aVar) {
        aVar.a(b7.b.X, this.f25078a);
        aVar.a("client_pkgname", this.f25079b);
        c(aVar);
    }

    public final String a() {
        return this.f25079b;
    }

    public final int b() {
        return this.f25078a;
    }

    public abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    public abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.f25079b = str;
    }

    public final void b(Intent intent) {
        a a10 = a.a(intent);
        if (a10 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a10.a(h3.e.f26414s, this.f25078a);
        e(a10);
        Bundle b10 = a10.b();
        if (b10 != null) {
            intent.putExtras(b10);
        }
    }

    public final void a(Intent intent) {
        a a10 = a.a(intent);
        if (a10 == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a10);
        Bundle b10 = a10.b();
        if (b10 != null) {
            intent.putExtras(b10);
        }
    }

    public final void a(a aVar) {
        String a10 = p.a(this.f25078a);
        if (a10 == null) {
            a10 = "";
        }
        aVar.a(h3.e.f26414s, a10);
        e(aVar);
    }

    public final void b(a aVar) {
        String a10 = aVar.a();
        if (!TextUtils.isEmpty(a10)) {
            this.f25079b = a10;
        } else {
            this.f25079b = aVar.a("client_pkgname");
        }
        d(aVar);
    }
}
