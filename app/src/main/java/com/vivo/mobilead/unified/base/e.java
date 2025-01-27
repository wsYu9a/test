package com.vivo.mobilead.unified.base;

import android.content.Context;
import com.vivo.mobilead.util.j0;
import com.vivo.mobilead.util.l0;

/* loaded from: classes4.dex */
public abstract class e<T> {

    /* renamed from: a */
    private com.vivo.mobilead.g.b f29748a;

    /* renamed from: b */
    protected Context f29749b;

    /* renamed from: c */
    protected AdParams f29750c;

    /* renamed from: d */
    protected T f29751d;

    /* renamed from: e */
    protected j0 f29752e = new j0();

    public e(Context context, AdParams adParams) {
        this.f29749b = context;
        this.f29750c = adParams;
    }

    public void a() {
    }

    public void a(T t) {
        this.f29751d = t;
    }

    public abstract void b();

    public void b(String str) {
        this.f29752e.f30661b = str;
    }

    public void c(String str) {
        this.f29752e.f30660a = str;
    }

    public void a(com.vivo.mobilead.g.b bVar) {
        this.f29748a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l0 l0Var) {
        com.vivo.mobilead.g.b bVar = this.f29748a;
        if (bVar != null) {
            bVar.a(l0Var);
        }
    }

    public void a(String str) {
        this.f29752e.f30662c = str;
    }
}
