package com.vivo.ad.b;

import android.content.Context;
import android.view.View;

/* loaded from: classes4.dex */
public abstract class a<T> {

    /* renamed from: a */
    private final View f26571a;

    /* renamed from: b */
    private T f26572b;

    /* renamed from: c */
    protected Context f26573c;

    public a(Context context) {
        this.f26573c = context;
        View d2 = d();
        this.f26571a = d2;
        d2.setTag(this);
    }

    protected abstract void a();

    public void a(T t) {
        this.f26572b = t;
        a();
    }

    public View b() {
        return this.f26571a;
    }

    public T c() {
        return this.f26572b;
    }

    protected abstract View d();
}
