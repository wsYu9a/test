package com.oplus.log.core;

import android.text.TextUtils;
import com.oplus.log.core.e;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: b */
    public String f16131b;

    /* renamed from: c */
    public long f16132c;

    /* renamed from: d */
    public h f16133d;

    /* renamed from: e */
    private String f16134e;

    /* renamed from: f */
    private String f16135f;

    /* renamed from: g */
    private long f16136g;

    /* renamed from: h */
    private long f16137h;

    /* renamed from: i */
    private long f16138i;

    /* renamed from: j */
    private String f16139j;
    private String k;

    /* renamed from: a */
    public ConcurrentLinkedQueue<e> f16130a = new ConcurrentLinkedQueue<>();
    private SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd");

    d(c cVar) {
        if (!((TextUtils.isEmpty(cVar.f16113a) || TextUtils.isEmpty(cVar.f16114b) || cVar.f16120h == null || cVar.f16121i == null) ? false : true)) {
            throw new NullPointerException("config's param is invalid");
        }
        this.f16131b = cVar.f16114b;
        this.f16134e = cVar.f16113a;
        this.f16135f = cVar.f16115c;
        this.f16136g = cVar.f16117e;
        this.f16138i = cVar.f16119g;
        this.f16137h = cVar.f16116d;
        this.f16132c = cVar.f16118f;
        this.f16139j = new String(cVar.f16120h);
        this.k = new String(cVar.f16121i);
        if (this.f16133d == null) {
            h hVar = new h(this.f16130a, this.f16134e, this.f16131b, this.f16136g, this.f16137h, this.f16138i, this.f16139j, this.k, this.f16135f);
            this.f16133d = hVar;
            hVar.setName("logan-thread");
            this.f16133d.start();
        }
    }

    final void a(e.b bVar) {
        if (TextUtils.isEmpty(this.f16131b)) {
            return;
        }
        e eVar = new e();
        eVar.f16140a = e.a.f16146c;
        eVar.f16141b = bVar;
        this.f16130a.add(eVar);
        h hVar = this.f16133d;
        if (hVar != null) {
            hVar.c();
        }
    }

    public final void b(i iVar) {
        this.f16133d.f16151a = iVar;
    }
}
