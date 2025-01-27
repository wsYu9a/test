package com.opos.mobad;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.opos.mobad.ad.c;
import com.opos.mobad.ad.c.j;
import com.opos.mobad.ad.c.m;
import com.opos.mobad.ad.c.n;
import com.opos.mobad.ad.c.o;
import com.opos.mobad.ad.c.s;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class f implements com.opos.mobad.ad.c {

    /* renamed from: j */
    private static final String[] f20522j;

    /* renamed from: a */
    protected final com.opos.mobad.cmn.a.d f20523a;

    /* renamed from: b */
    protected com.opos.mobad.q.a.h f20524b;

    /* renamed from: c */
    protected com.opos.mobad.cmn.b.c f20525c;

    /* renamed from: d */
    private AtomicBoolean f20526d = new AtomicBoolean(false);

    /* renamed from: e */
    private Context f20527e;

    /* renamed from: f */
    private String f20528f;

    /* renamed from: g */
    private String f20529g;

    /* renamed from: h */
    private boolean f20530h;

    /* renamed from: i */
    private d f20531i;

    static {
        if (com.opos.mobad.cmn.a.b.f.l()) {
            f20522j = new String[]{com.kuaishou.weapon.p0.g.f9317b, com.kuaishou.weapon.p0.g.f9319d, "android.permission.INTERNET"};
        } else {
            f20522j = new String[]{com.kuaishou.weapon.p0.g.f9317b, com.kuaishou.weapon.p0.g.f9319d, "android.permission.INTERNET", "android.permission.QUERY_ALL_PACKAGES"};
        }
    }

    protected f(com.opos.mobad.q.a.h hVar, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.activity.webview.a aVar, com.opos.mobad.cmn.b.c cVar) {
        this.f20524b = hVar;
        this.f20525c = cVar;
        this.f20523a = dVar;
        com.opos.mobad.cmn.service.a.a().a(dVar, aVar);
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.a.a a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.a.b bVar) {
        if (a() && b.f19510a.booleanValue()) {
            return new com.opos.mobad.a.d(activity, str2, z, this.f20523a, bVar, this.f20525c);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.a a(Activity activity, String str, String str2, com.opos.mobad.ad.b.b bVar) {
        if (a() && b.f19511b.booleanValue()) {
            return new com.opos.mobad.interstitial.b(activity, str2, this.f20523a, bVar, this.f20524b);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.b.c a(Activity activity, String str, String str2, boolean z, com.opos.mobad.ad.b.d dVar) {
        if (a() && b.f19511b.booleanValue()) {
            return new com.opos.mobad.g.a(activity, str2, this.f20523a, this.f20524b, dVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public c.a a(Context context) {
        if (!com.opos.mobad.cmn.a.b.f.d()) {
            return new c.a(false, "sdk not support android sdk version <19 .");
        }
        if (!com.opos.cmn.i.i.a(this.f20527e, f20522j)) {
            return new c.a(false, "don't have some need normal permission.");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(context.getPackageName());
        sb.append(".MobFileProvider");
        return !com.opos.cmn.i.b.a(context, Uri.parse(sb.toString())) ? new c.a(false, "com.heytap.msp.mobad.api.MobFileProvider don't find in AndroidManifest.xml.") : new c.a(true, "");
    }

    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, int i2, m mVar) {
        if (a() && b.f19512c.booleanValue()) {
            return new com.opos.mobad.h.c(com.opos.mobad.service.b.a(context), str2, i2, this.f20523a, mVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.c a(Context context, String str, String str2, com.opos.mobad.ad.c.f fVar) {
        if (a() && b.f19512c.booleanValue()) {
            return new com.opos.mobad.h.c(com.opos.mobad.service.b.a(context), str2, this.f20523a, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.c.g a(Context context, String str, String str2, int i2, int i3, j jVar, com.opos.mobad.ad.privacy.a aVar) {
        if (a() && b.f19512c.booleanValue()) {
            return new com.opos.mobad.h.d(com.opos.mobad.service.b.a(context), str2, this.f20523a, jVar, aVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public n a(Context context, s sVar, String str, String str2, o oVar) {
        if (a() && b.f19512c.booleanValue()) {
            return new com.opos.mobad.h.e(com.opos.mobad.service.b.a(context), str2, sVar, this.f20523a, oVar, this.f20525c);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.d.a a(Context context, String str, String str2, boolean z, com.opos.mobad.ad.d.b bVar) {
        if (a() && b.f19513d.booleanValue()) {
            return new com.opos.mobad.j.a(com.opos.mobad.service.b.a(context), str2, this.f20523a, this.f20524b, bVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.a a(Context context, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        if (a() && b.f19514e.booleanValue()) {
            return new com.opos.mobad.k.a(context, str2, this.f20523a, cVar, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public com.opos.mobad.ad.e.b a(Activity activity, String str, String str2, com.opos.mobad.ad.e.f fVar, com.opos.mobad.ad.e.c cVar) {
        if (a() && b.f19514e.booleanValue()) {
            return new com.opos.mobad.k.c(activity, str2, this.f20523a, cVar, fVar);
        }
        return null;
    }

    @Override // com.opos.mobad.ad.c
    public void a(Context context, String str, String str2, String str3, boolean z) {
        String str4;
        if (context == null || TextUtils.isEmpty(str)) {
            str4 = "init with null content or appId ";
        } else {
            if (a(context).f19473a) {
                if (this.f20526d.compareAndSet(false, true)) {
                    this.f20527e = context.getApplicationContext();
                    this.f20528f = str;
                    this.f20529g = str2;
                    this.f20530h = z;
                    d dVar = new d();
                    this.f20531i = dVar;
                    dVar.a(context, str);
                    return;
                }
                return;
            }
            str4 = "init but fail";
        }
        com.opos.cmn.an.f.a.b("", str4);
    }

    protected boolean a() {
        return this.f20527e != null;
    }

    @Override // com.opos.mobad.ad.c
    public void b() {
        d dVar = this.f20531i;
        if (dVar != null) {
            dVar.a();
        }
    }
}
