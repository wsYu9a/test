package yb;

import android.content.Context;
import com.martian.libmars.common.ConfigSingleton;

/* loaded from: classes3.dex */
public class d<E> extends n<E> {

    /* renamed from: h */
    public final Context f33442h;

    public d(Class<E> cls) {
        this("mibooks.db", cls);
    }

    @Override // yb.n
    public Context getContext() {
        return this.f33442h;
    }

    public d(int i10, Class<E> cls) {
        this("mibooks.db", i10, cls);
    }

    public d(String str, Class<E> cls) {
        super(str, 8, cls);
        this.f33442h = ConfigSingleton.D().getApplicationContext();
    }

    public d(String str, int i10, Class<E> cls) {
        super(str, i10, cls);
        this.f33442h = ConfigSingleton.D().getApplicationContext();
    }
}
