package com.vivo.mobilead.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class d<T extends DialogInterface.OnDismissListener> implements DialogInterface.OnDismissListener {

    /* renamed from: a */
    protected WeakReference<T> f28847a;

    public d(T t) {
        this.f28847a = new WeakReference<>(t);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.f28847a.get() != null) {
            this.f28847a.get().onDismiss(dialogInterface);
        }
    }
}
