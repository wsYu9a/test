package com.vivo.ad.c;

import android.content.Context;
import android.view.Surface;
import com.vivo.google.android.exoplayer3.extend.VideoConstant;

/* loaded from: classes4.dex */
public class e extends a {

    /* renamed from: d */
    private a f26605d;

    public e(Context context, VideoConstant.PlayerType playerType) {
        if (playerType == VideoConstant.PlayerType.EXO) {
            this.f26605d = new c(context);
        } else {
            this.f26605d = new d();
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(long j2) {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.a(j2);
        }
    }

    @Override // com.vivo.ad.c.a
    public long b() {
        a aVar = this.f26605d;
        if (aVar != null) {
            return aVar.b();
        }
        return 0L;
    }

    @Override // com.vivo.ad.c.a
    public void c() {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.vivo.ad.c.a
    public void d() {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.vivo.ad.c.a
    public void e() {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.vivo.ad.c.a
    public void f() {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(String str) {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.vivo.ad.c.a
    public long a() {
        a aVar = this.f26605d;
        if (aVar != null) {
            return aVar.a();
        }
        return 0L;
    }

    @Override // com.vivo.ad.c.a
    public void a(float f2) {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(Surface surface) {
        a aVar = this.f26605d;
        if (aVar != null) {
            aVar.a(surface);
        }
    }

    @Override // com.vivo.ad.c.a
    public void a(com.vivo.ad.d.a.a aVar) {
        a aVar2 = this.f26605d;
        if (aVar2 != null) {
            aVar2.a(aVar);
        }
    }
}
