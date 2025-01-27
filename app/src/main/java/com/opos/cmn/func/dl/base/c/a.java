package com.opos.cmn.func.dl.base.c;

import android.content.Context;
import com.opos.cmn.func.dl.base.c.d;
import java.io.InputStream;

/* loaded from: classes4.dex */
public class a implements d {

    /* renamed from: a */
    public static final String f17281a = "a";

    /* renamed from: b */
    d f17282b;

    /* renamed from: d */
    private d f17284d;

    /* renamed from: e */
    private int f17285e = 2;

    /* renamed from: c */
    public e f17283c = new f();

    public a(d.a aVar) {
        this.f17284d = aVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a() {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        return dVar.a();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final InputStream a(Context context, String str, b bVar) {
        int i2;
        InputStream a2;
        do {
            this.f17284d.a(context, str, bVar);
            this.f17283c.a(context, this, str, bVar);
            if (com.opos.cmn.func.dl.base.h.a.a(d()) && (a2 = a()) != null) {
                return a2;
            }
            i2 = this.f17285e;
            this.f17285e = i2 - 1;
        } while (i2 >= 0);
        return null;
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String a(String str) {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        return dVar.a(str);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void a(String str, String str2) {
        this.f17284d.a(str, str2);
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final String b() {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        return dVar.b();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final void c() {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        dVar.c();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final int d() {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        return dVar.d();
    }

    @Override // com.opos.cmn.func.dl.base.c.d
    public final long e() {
        d dVar = this.f17282b;
        if (dVar == null) {
            dVar = this.f17284d;
        }
        long e2 = dVar.e();
        if (e2 == -1) {
            e2 = com.opos.cmn.func.dl.base.h.a.b(a("Content-Range"));
        }
        if ("chunked".equals(a("Transfer-Encoding"))) {
            com.opos.cmn.an.f.a.c(f17281a, "Transfer-Encoding is chunked !!");
        }
        return e2;
    }
}
