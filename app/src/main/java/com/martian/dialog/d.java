package com.martian.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import c.a.a.a.a.n;
import c.a.a.a.a.o;
import com.martian.dialog.d;

/* loaded from: classes2.dex */
public abstract class d<T extends d<T>> extends n<T> {
    protected o.a o;
    private DialogInterface.OnCancelListener p;

    public d(Context context, FragmentManager fragmentManager, Class<? extends o> clazz) {
        super(context, fragmentManager, clazz);
        this.o = new o.a(null, context, LayoutInflater.from(context), null);
    }

    public o.a m() {
        return this.o;
    }

    public o.a n(o dialogFragment, Context context, LayoutInflater inflater, ViewGroup container) {
        return this.o.o(dialogFragment, context, inflater, container);
    }

    public T o(DialogInterface.OnCancelListener l) {
        this.p = l;
        return (T) d();
    }

    public T p(int titleResourceId) {
        this.o.b0(titleResourceId);
        return (T) d();
    }

    public T q(String title) {
        this.o.c0(title);
        return (T) d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.a.a.a.a.n
    /* renamed from: r */
    public e k() {
        e eVar = (e) a();
        eVar.f((d) d());
        DialogInterface.OnCancelListener onCancelListener = this.p;
        if (onCancelListener != null) {
            eVar.g(onCancelListener);
        }
        try {
            eVar.show(this.f5141g, this.m);
        } catch (IllegalStateException unused) {
        }
        return eVar;
    }
}
