package com.martian.ttbook.b.c.a.a.d.b.m;

import android.view.View;
import com.martian.ttbook.b.c.a.a.d.b.l;

/* loaded from: classes4.dex */
public class b implements View.OnAttachStateChangeListener {

    /* renamed from: a */
    private static String f15800a = "ADGLOBALTAG";

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15800a, "attach a");
        Object[] objArr = l.f15795a.get(view);
        if (objArr != null) {
            objArr[5] = Boolean.TRUE;
        } else {
            com.martian.ttbook.b.c.a.a.e.d.g(f15800a, "attach a tag == null");
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        com.martian.ttbook.b.c.a.a.e.d.g(f15800a, "dettach a");
        Object[] objArr = l.f15795a.get(view);
        if (objArr != null) {
            objArr[5] = Boolean.FALSE;
        } else {
            com.martian.ttbook.b.c.a.a.e.d.g(f15800a, "dettach a tag == null");
        }
    }
}
