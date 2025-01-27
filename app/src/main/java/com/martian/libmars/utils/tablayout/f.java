package com.martian.libmars.utils.tablayout;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: classes2.dex */
public abstract class f {

    /* renamed from: a */
    private final DataSetObservable f10237a = new DataSetObservable();

    public abstract int a();

    public abstract h b(Context context);

    public abstract j c(Context context, int index);

    public float d(Context context, int index) {
        return 1.0f;
    }

    public final void e() {
        this.f10237a.notifyChanged();
    }

    public final void f() {
        this.f10237a.notifyInvalidated();
    }

    public final void g(DataSetObserver observer) {
        this.f10237a.registerObserver(observer);
    }

    public final void h(DataSetObserver observer) {
        this.f10237a.unregisterObserver(observer);
    }
}
