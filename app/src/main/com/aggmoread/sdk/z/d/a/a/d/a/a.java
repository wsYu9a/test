package com.aggmoread.sdk.z.d.a.a.d.a;

import com.aggmoread.sdk.z.d.a.a.c.f;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import java.lang.ref.WeakReference;
import java.util.UUID;

/* loaded from: classes.dex */
public class a {

    /* renamed from: g */
    public f f5274g;

    /* renamed from: h */
    public d f5275h;

    /* renamed from: i */
    public e f5276i;

    /* renamed from: j */
    public int f5277j = 0;

    /* renamed from: k */
    public long f5278k = 0;

    /* renamed from: l */
    public boolean f5279l = false;

    /* renamed from: m */
    public boolean f5280m = true;

    /* renamed from: o */
    public WeakReference<com.aggmoread.sdk.z.d.a.a.d.b.m.a> f5282o = null;

    /* renamed from: f */
    public String f5273f = UUID.randomUUID().toString();

    /* renamed from: n */
    public Object[] f5281n = com.aggmoread.sdk.z.d.a.a.b.b();

    public a(d dVar, e eVar) {
        this.f5275h = dVar;
        this.f5276i = eVar;
    }

    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        return null;
    }

    public String toString() {
        String str = this.f5273f;
        d dVar = this.f5275h;
        return String.format("{id=%s, placementId=%s, clicks=%s, extime=%s, exposured=%s, showInvoke=%s}", str, dVar == null ? "unknown" : dVar.f5863i, Integer.valueOf(this.f5277j), Long.valueOf(this.f5278k), Boolean.valueOf(this.f5279l), Boolean.valueOf(this.f5280m));
    }

    public void a(i iVar) {
        new k(this.f5275h, this.f5276i).a(8).a(iVar).a(k.b.f6046n, this.f5273f).b();
        this.f5274g.a(iVar);
    }
}
