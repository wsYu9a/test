package c.a.a.a.a;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import c.a.a.a.a.n;

/* loaded from: classes5.dex */
public abstract class n<T extends n<T>> {

    /* renamed from: a */
    public static final String f5135a = "request_code";

    /* renamed from: b */
    public static final String f5136b = "cancelable_oto";

    /* renamed from: c */
    public static final String f5137c = "transparent_background";

    /* renamed from: d */
    public static final String f5138d = "simple_dialog";

    /* renamed from: e */
    public static final int f5139e = -42;

    /* renamed from: f */
    protected final Context f5140f;

    /* renamed from: g */
    protected final FragmentManager f5141g;

    /* renamed from: h */
    protected final Class<? extends o> f5142h;

    /* renamed from: i */
    private Fragment f5143i;

    /* renamed from: j */
    private boolean f5144j = false;
    private boolean k = true;
    private boolean l = true;
    protected String m = f5138d;
    private int n = -42;

    public n(Context context, FragmentManager fragmentManager, Class<? extends o> clazz) {
        this.f5141g = fragmentManager;
        this.f5140f = context.getApplicationContext();
        this.f5142h = clazz;
    }

    protected o a() {
        Bundle c2 = c();
        o oVar = (o) Fragment.instantiate(this.f5140f, this.f5142h.getName(), c2);
        c2.putBoolean(f5136b, this.l);
        c2.putBoolean(f5137c, this.f5144j);
        Fragment fragment = this.f5143i;
        if (fragment != null) {
            oVar.setTargetFragment(fragment, this.n);
        } else {
            c2.putInt(f5135a, this.n);
        }
        oVar.setCancelable(this.k);
        return oVar;
    }

    public String b() {
        return this.m;
    }

    protected abstract Bundle c();

    protected abstract T d();

    public T e(boolean cancelable) {
        this.k = cancelable;
        return d();
    }

    public T f(boolean cancelable) {
        this.l = cancelable;
        if (cancelable) {
            this.k = true;
        }
        return d();
    }

    public T g(int requestCode) {
        this.n = requestCode;
        return d();
    }

    public T h(String tag) {
        this.m = tag;
        return d();
    }

    public T i(Fragment fragment, int requestCode) {
        this.f5143i = fragment;
        this.n = requestCode;
        return d();
    }

    public T j(boolean transparent) {
        this.f5144j = transparent;
        return d();
    }

    public DialogFragment k() {
        o a2 = a();
        a2.show(this.f5141g, this.m);
        return a2;
    }

    public DialogFragment l() {
        o a2 = a();
        a2.e(this.f5141g, this.m);
        return a2;
    }
}
