package com.opos.mobad.f;

import android.app.Activity;
import android.content.Context;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.g;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import com.opos.mobad.f.a.h;
import com.opos.mobad.service.a.e;
import java.util.List;

/* loaded from: classes4.dex */
public class d implements com.opos.mobad.ad.c {

    /* renamed from: a */
    private final List<e.a> f20809a;

    /* renamed from: b */
    private final e.a f20810b;

    /* renamed from: c */
    private final b f20811c;

    /* renamed from: d */
    private final long f20812d;

    /* renamed from: e */
    private com.opos.mobad.f.a.d.a f20813e;

    public d(com.opos.mobad.f.a.d.a aVar, List<e.a> list, e.a aVar2, long j2, b bVar) {
        this.f20813e = aVar;
        this.f20809a = list;
        this.f20810b = aVar2;
        this.f20811c = bVar;
        this.f20812d = j2;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.a a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.b bVar) {
        return new com.opos.mobad.f.a.a(activity, str, this.f20813e, false, bVar, this.f20809a, this.f20810b, this.f20812d, this.f20811c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.a a(Activity activity, String str, String str2, com.opos.mobad.ad.b.b bVar) {
        return new com.opos.mobad.f.a.d(activity, str, this.f20813e, bVar, this.f20809a, this.f20810b, this.f20812d, this.f20811c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.b.d dVar) {
        return new com.opos.mobad.f.a.e(activity, str, this.f20813e, dVar, z, this.f20809a, this.f20810b, this.f20812d, this.f20811c);
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        return new c.a(true, "");
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, com.opos.mobad.ad.c.f fVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public g a(Context context, String str, String str2, int i2, int i3, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        return new com.opos.mobad.f.a.f(context, str, this.f20813e, jVar, this.f20809a, this.f20810b, this.f20812d, this.f20811c, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        return new com.opos.mobad.f.a.g(context, sVar, str, this.f20813e, oVar, this.f20809a, this.f20810b, this.f20812d, this.f20811c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.d.b bVar) {
        return new h(context, str, this.f20813e, bVar, false, this.f20809a, this.f20810b, this.f20812d, this.f20811c);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.b a(Activity activity, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z) {
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
    }
}
