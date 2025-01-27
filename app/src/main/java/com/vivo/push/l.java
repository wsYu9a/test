package com.vivo.push;

import android.content.Context;

/* loaded from: classes4.dex */
public abstract class l implements Runnable {

    /* renamed from: a */
    protected Context f25064a;

    /* renamed from: b */
    private int f25065b;

    /* renamed from: c */
    private o f25066c;

    public l(o oVar) {
        this.f25065b = -1;
        this.f25066c = oVar;
        int b10 = oVar.b();
        this.f25065b = b10;
        if (b10 < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f25064a = e.a().h();
    }

    public final int a() {
        return this.f25065b;
    }

    public abstract void a(o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f25064a;
        if (context != null && !(this.f25066c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f25066c);
        }
        a(this.f25066c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append("{");
        o oVar = this.f25066c;
        sb2.append(oVar == null ? "[null]" : oVar.toString());
        sb2.append(p3.f.f29748d);
        return sb2.toString();
    }
}
