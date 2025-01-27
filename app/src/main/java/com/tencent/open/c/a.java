package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class a extends RelativeLayout {

    /* renamed from: a */
    private static final String f23223a = "com.tencent.open.c.a";

    /* renamed from: b */
    private Rect f23224b;

    /* renamed from: c */
    private boolean f23225c;

    /* renamed from: d */
    private InterfaceC0661a f23226d;

    /* renamed from: com.tencent.open.c.a$a */
    public interface InterfaceC0661a {
        void a();

        void a(int i10);
    }

    public a(Context context) {
        super(context);
        this.f23224b = null;
        this.f23225c = false;
        this.f23226d = null;
        this.f23224b = new Rect();
    }

    public void a(InterfaceC0661a interfaceC0661a) {
        this.f23226d = interfaceC0661a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i11);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f23224b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f23224b.top) - size;
        InterfaceC0661a interfaceC0661a = this.f23226d;
        if (interfaceC0661a != null && size != 0) {
            if (height > 100) {
                interfaceC0661a.a((Math.abs(this.f23224b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0661a.a();
            }
        }
        super.onMeasure(i10, i11);
    }
}
