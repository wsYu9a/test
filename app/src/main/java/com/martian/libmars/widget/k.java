package com.martian.libmars.widget;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes2.dex */
public class k implements uk.co.senab.actionbarpulltorefresh.library.k.c {

    /* renamed from: a */
    private boolean f10401a = false;

    /* renamed from: b */
    private final ScrollView f10402b;

    public k(final ScrollView sv) {
        this.f10402b = sv;
        sv.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.libmars.widget.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return k.this.c(view, motionEvent);
            }
        });
    }

    /* renamed from: b */
    public /* synthetic */ boolean c(View v, MotionEvent event) {
        this.f10401a = true;
        return false;
    }

    @Override // uk.co.senab.actionbarpulltorefresh.library.k.c
    public boolean a(View view, float x, float y) {
        if (view.getScrollY() > 0) {
            return false;
        }
        if (this.f10402b.getScrollY() <= 0 || !this.f10401a) {
            return true;
        }
        this.f10401a = false;
        return false;
    }
}
