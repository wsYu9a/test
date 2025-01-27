package com.vivo.push.b;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class c extends com.vivo.push.o {

    /* renamed from: a */
    private String f30894a;

    /* renamed from: b */
    private String f30895b;

    /* renamed from: c */
    private long f30896c;

    /* renamed from: d */
    private int f30897d;

    /* renamed from: e */
    private int f30898e;

    /* renamed from: f */
    private String f30899f;

    public c(int i2, String str) {
        super(i2);
        this.f30896c = -1L;
        this.f30897d = -1;
        this.f30894a = null;
        this.f30895b = str;
    }

    public final void a(int i2) {
        this.f30898e = i2;
    }

    public final void b(String str) {
        this.f30894a = str;
    }

    @Override // com.vivo.push.o
    protected void c(com.vivo.push.a aVar) {
        aVar.a("req_id", this.f30894a);
        aVar.a("package_name", this.f30895b);
        aVar.a("sdk_version", 323L);
        aVar.a("PUSH_APP_STATUS", this.f30897d);
        if (TextUtils.isEmpty(this.f30899f)) {
            return;
        }
        aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f30899f);
    }

    @Override // com.vivo.push.o
    protected void d(com.vivo.push.a aVar) {
        this.f30894a = aVar.a("req_id");
        this.f30895b = aVar.a("package_name");
        this.f30896c = aVar.b("sdk_version", 0L);
        this.f30897d = aVar.b("PUSH_APP_STATUS", 0);
        this.f30899f = aVar.a("BaseAppCommand.EXTRA__HYBRIDVERSION");
    }

    public final int f() {
        return this.f30898e;
    }

    public final void g() {
        this.f30899f = null;
    }

    public final String h() {
        return this.f30894a;
    }

    @Override // com.vivo.push.o
    public String toString() {
        return "BaseAppCommand";
    }

    public final int a(Context context) {
        if (this.f30897d == -1) {
            String str = this.f30895b;
            if (TextUtils.isEmpty(str)) {
                com.vivo.push.util.p.a("BaseAppCommand", "pkg name is null");
                String a2 = a();
                if (TextUtils.isEmpty(a2)) {
                    com.vivo.push.util.p.a("BaseAppCommand", "src is null");
                    return -1;
                }
                str = a2;
            }
            this.f30897d = com.vivo.push.util.t.b(context, str);
            if (!TextUtils.isEmpty(this.f30899f)) {
                this.f30897d = 2;
            }
        }
        return this.f30897d;
    }
}
