package com.google.android.material.j;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a */
    private View f7404a;

    /* renamed from: b */
    private j f7405b;

    /* renamed from: c */
    private ScrollView f7406c;

    /* renamed from: d */
    private final int[] f7407d = new int[2];

    /* renamed from: e */
    private final int[] f7408e = new int[2];

    /* renamed from: f */
    private final ViewTreeObserver.OnScrollChangedListener f7409f = new a();

    class a implements ViewTreeObserver.OnScrollChangedListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            h.this.e();
        }
    }

    public h(View view, j jVar, ScrollView scrollView) {
        this.f7404a = view;
        this.f7405b = jVar;
        this.f7406c = scrollView;
    }

    public void a(ScrollView scrollView) {
        this.f7406c = scrollView;
    }

    public void b(j jVar) {
        this.f7405b = jVar;
    }

    public void c(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.addOnScrollChangedListener(this.f7409f);
    }

    public void d(@NonNull ViewTreeObserver viewTreeObserver) {
        viewTreeObserver.removeOnScrollChangedListener(this.f7409f);
    }

    public void e() {
        ScrollView scrollView = this.f7406c;
        if (scrollView == null) {
            return;
        }
        if (scrollView.getChildCount() == 0) {
            throw new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        }
        this.f7406c.getLocationInWindow(this.f7407d);
        this.f7406c.getChildAt(0).getLocationInWindow(this.f7408e);
        int top = (this.f7404a.getTop() - this.f7407d[1]) + this.f7408e[1];
        int height = this.f7404a.getHeight();
        int height2 = this.f7406c.getHeight();
        if (top < 0) {
            this.f7405b.o0(Math.max(0.0f, Math.min(1.0f, (top / height) + 1.0f)));
            this.f7404a.invalidate();
            return;
        }
        if (top + height > height2) {
            this.f7405b.o0(Math.max(0.0f, Math.min(1.0f, 1.0f - ((r0 - height2) / height))));
            this.f7404a.invalidate();
        } else if (this.f7405b.z() != 1.0f) {
            this.f7405b.o0(1.0f);
            this.f7404a.invalidate();
        }
    }
}
