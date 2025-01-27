package m9;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a */
    public final DataSetObservable f28531a = new DataSetObservable();

    public abstract int a();

    public abstract e b(Context context);

    public abstract g c(Context context, int i10);

    public float d(Context context, int i10) {
        return 1.0f;
    }

    public final void e() {
        this.f28531a.notifyChanged();
    }

    public final void f() {
        this.f28531a.notifyInvalidated();
    }

    public final void g(DataSetObserver dataSetObserver) {
        this.f28531a.registerObserver(dataSetObserver);
    }

    public final void h(DataSetObserver dataSetObserver) {
        this.f28531a.unregisterObserver(dataSetObserver);
    }
}
