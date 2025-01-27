package com.opos.exoplayer.core.h;

import android.content.Context;
import android.net.Uri;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.exoplayer.core.i.u;

/* loaded from: classes4.dex */
public final class l implements g {

    /* renamed from: a */
    private final Context f18947a;

    /* renamed from: b */
    private final t<? super g> f18948b;

    /* renamed from: c */
    private final g f18949c;

    /* renamed from: d */
    private g f18950d;

    /* renamed from: e */
    private g f18951e;

    /* renamed from: f */
    private g f18952f;

    /* renamed from: g */
    private g f18953g;

    /* renamed from: h */
    private g f18954h;

    /* renamed from: i */
    private g f18955i;

    /* renamed from: j */
    private g f18956j;

    public l(Context context, t<? super g> tVar, g gVar) {
        this.f18947a = context.getApplicationContext();
        this.f18948b = tVar;
        this.f18949c = (g) com.opos.exoplayer.core.i.a.a(gVar);
    }

    private g c() {
        if (this.f18950d == null) {
            this.f18950d = new p(this.f18948b);
        }
        return this.f18950d;
    }

    private g d() {
        if (this.f18951e == null) {
            this.f18951e = new c(this.f18947a, this.f18948b);
        }
        return this.f18951e;
    }

    private g e() {
        if (this.f18952f == null) {
            this.f18952f = new e(this.f18947a, this.f18948b);
        }
        return this.f18952f;
    }

    private g f() {
        if (this.f18953g == null) {
            try {
                this.f18953g = (g) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                com.opos.cmn.an.f.a.c("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e2) {
                throw new RuntimeException("Error instantiating RTMP extension", e2);
            }
            if (this.f18953g == null) {
                this.f18953g = this.f18949c;
            }
        }
        return this.f18953g;
    }

    private g g() {
        if (this.f18954h == null) {
            this.f18954h = new f();
        }
        return this.f18954h;
    }

    private g h() {
        if (this.f18955i == null) {
            this.f18955i = new s(this.f18947a, this.f18948b);
        }
        return this.f18955i;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i2, int i3) {
        return this.f18956j.a(bArr, i2, i3);
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) {
        g e2;
        com.opos.exoplayer.core.i.a.b(this.f18956j == null);
        String scheme = iVar.f18918a.getScheme();
        if (u.a(iVar.f18918a)) {
            if (!iVar.f18918a.getPath().startsWith("/android_asset/")) {
                e2 = c();
            }
            e2 = d();
        } else {
            if (!"asset".equals(scheme)) {
                e2 = "content".equals(scheme) ? e() : "rtmp".equals(scheme) ? f() : MiConfigSingleton.t0.equals(scheme) ? g() : "rawresource".equals(scheme) ? h() : this.f18949c;
            }
            e2 = d();
        }
        this.f18956j = e2;
        return this.f18956j.a(iVar);
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        g gVar = this.f18956j;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        g gVar = this.f18956j;
        if (gVar != null) {
            try {
                gVar.b();
            } finally {
                this.f18956j = null;
            }
        }
    }
}
