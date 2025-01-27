package com.martian.libmars.utils;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes2.dex */
public class r0 extends PopupWindow {

    /* renamed from: a */
    private Activity f10187a;

    /* renamed from: b */
    private boolean f10188b;

    /* renamed from: c */
    private boolean f10189c;

    /* renamed from: d */
    private int f10190d;

    public r0(Activity activity, View contentView) {
        this.f10188b = true;
        this.f10189c = true;
        this.f10190d = 17;
        this.f10187a = activity;
        setContentView(contentView);
    }

    public static r0 a(Activity activity, View view) {
        return b(activity, view, -1, -2);
    }

    public static r0 b(Activity activity, View view, int width, int height) {
        r0 r0Var = new r0(activity, view);
        r0Var.setWidth(width);
        r0Var.setHeight(height);
        return r0Var;
    }

    public r0 c(int height) {
        setHeight(height);
        return this;
    }

    public r0 d(int animation) {
        setAnimationStyle(animation);
        return this;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (this.f10188b) {
            k0.L(this.f10187a, false);
        }
    }

    public r0 e(boolean cancelable) {
        this.f10189c = cancelable;
        return this;
    }

    public r0 f(PopupWindow.OnDismissListener listener) {
        setOnDismissListener(listener);
        return this;
    }

    public r0 g() {
        setClippingEnabled(false);
        return this;
    }

    public r0 h(int gravity) {
        this.f10190d = gravity;
        return this;
    }

    public r0 i(View view) {
        return this;
    }

    public r0 j(boolean mask) {
        this.f10188b = mask;
        return this;
    }

    public r0 k() {
        if (this.f10188b) {
            k0.L(this.f10187a, true);
        }
        if (this.f10189c) {
            setFocusable(true);
            setOutsideTouchable(true);
        }
        showAtLocation(this.f10187a.getWindow().getDecorView(), this.f10190d, 0, 0);
        return this;
    }

    public r0 l(int width) {
        setWidth(width);
        return this;
    }

    public r0(View contentView, int width, int height) {
        super(contentView, width, height);
        this.f10188b = true;
        this.f10189c = true;
        this.f10190d = 17;
    }
}
