package com.aggmoread.sdk.z.d.a.a.d.b.m;

import android.view.View;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;

/* loaded from: classes.dex */
public class b implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static String f6065a = "AMGTAG";

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        e.b(f6065a, "attach a");
        Object[] objArr = l.f6059a.get(view);
        if (objArr != null) {
            objArr[2] = Boolean.TRUE;
        } else {
            e.b(f6065a, "attach a tag == null");
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        e.b(f6065a, "dettach a");
        Object[] objArr = l.f6059a.get(view);
        if (objArr != null) {
            objArr[2] = Boolean.FALSE;
        } else {
            e.b(f6065a, "dettach a tag == null");
        }
    }
}
