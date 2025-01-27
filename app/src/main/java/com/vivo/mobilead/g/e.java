package com.vivo.mobilead.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class e<T extends DialogInterface.OnShowListener> implements DialogInterface.OnShowListener {

    /* renamed from: a */
    protected WeakReference<T> f28848a;

    public e(T t) {
        this.f28848a = new WeakReference<>(t);
    }

    @Override // android.content.DialogInterface.OnShowListener
    public void onShow(DialogInterface dialogInterface) {
        if (this.f28848a.get() != null) {
            this.f28848a.get().onShow(dialogInterface);
        }
    }
}
