package l9;

import android.app.Activity;
import android.view.View;
import android.widget.PopupWindow;

/* loaded from: classes3.dex */
public class q0 extends PopupWindow {

    /* renamed from: a */
    public Activity f28033a;

    /* renamed from: b */
    public boolean f28034b;

    /* renamed from: c */
    public boolean f28035c;

    /* renamed from: d */
    public int f28036d;

    public q0(Activity activity, View view) {
        this.f28034b = true;
        this.f28035c = true;
        this.f28036d = 17;
        this.f28033a = activity;
        setContentView(view);
    }

    public static q0 a(Activity activity, View view) {
        return b(activity, view, -1, -2);
    }

    public static q0 b(Activity activity, View view, int i10, int i11) {
        q0 q0Var = new q0(activity, view);
        q0Var.setWidth(i10);
        q0Var.setHeight(i11);
        return q0Var;
    }

    public q0 c(int i10) {
        setHeight(i10);
        return this;
    }

    public q0 d(int i10) {
        setAnimationStyle(i10);
        return this;
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        if (this.f28034b) {
            i0.s0(this.f28033a, false);
        }
    }

    public q0 e(boolean z10) {
        this.f28035c = z10;
        return this;
    }

    public q0 f(PopupWindow.OnDismissListener onDismissListener) {
        setOnDismissListener(onDismissListener);
        return this;
    }

    public q0 g() {
        setClippingEnabled(false);
        return this;
    }

    public q0 h(int i10) {
        this.f28036d = i10;
        return this;
    }

    public q0 j(boolean z10) {
        this.f28034b = z10;
        return this;
    }

    public q0 k() {
        if (this.f28034b) {
            i0.s0(this.f28033a, true);
        }
        if (this.f28035c) {
            setFocusable(true);
            setOutsideTouchable(true);
        }
        showAtLocation(this.f28033a.getWindow().getDecorView(), this.f28036d, 0, 0);
        return this;
    }

    public q0 l(int i10) {
        setWidth(i10);
        return this;
    }

    public q0(View view, int i10, int i11) {
        super(view, i10, i11);
        this.f28034b = true;
        this.f28035c = true;
        this.f28036d = 17;
    }

    public q0 i(View view) {
        return this;
    }
}
