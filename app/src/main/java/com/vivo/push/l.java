package com.vivo.push;

import android.content.Context;

/* loaded from: classes4.dex */
public abstract class l implements Runnable {

    /* renamed from: a */
    protected Context f31028a;

    /* renamed from: b */
    private int f31029b;

    /* renamed from: c */
    private o f31030c;

    public l(o oVar) {
        this.f31029b = -1;
        this.f31030c = oVar;
        int b2 = oVar.b();
        this.f31029b = b2;
        if (b2 < 0) {
            throw new IllegalArgumentException("PushTask need a > 0 task id.");
        }
        this.f31028a = e.a().h();
    }

    public final int a() {
        return this.f31029b;
    }

    protected abstract void a(o oVar);

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f31028a;
        if (context != null && !(this.f31030c instanceof com.vivo.push.b.n)) {
            com.vivo.push.util.p.a(context, "[执行指令]" + this.f31030c);
        }
        a(this.f31030c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("{");
        o oVar = this.f31030c;
        sb.append(oVar == null ? "[null]" : oVar.toString());
        sb.append("}");
        return sb.toString();
    }
}
