package com.tencent.open.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class a extends RelativeLayout {

    /* renamed from: a */
    private static final String f25489a = a.class.getName();

    /* renamed from: b */
    private Rect f25490b;

    /* renamed from: c */
    private boolean f25491c;

    /* renamed from: d */
    private InterfaceC0532a f25492d;

    /* renamed from: com.tencent.open.c.a$a */
    public interface InterfaceC0532a {
        void a();

        void a(int i2);
    }

    public a(Context context) {
        super(context);
        this.f25490b = null;
        this.f25491c = false;
        this.f25492d = null;
        this.f25490b = new Rect();
    }

    public void a(InterfaceC0532a interfaceC0532a) {
        this.f25492d = interfaceC0532a;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        Activity activity = (Activity) getContext();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(this.f25490b);
        int height = (activity.getWindowManager().getDefaultDisplay().getHeight() - this.f25490b.top) - size;
        InterfaceC0532a interfaceC0532a = this.f25492d;
        if (interfaceC0532a != null && size != 0) {
            if (height > 100) {
                interfaceC0532a.a((Math.abs(this.f25490b.height()) - getPaddingBottom()) - getPaddingTop());
            } else {
                interfaceC0532a.a();
            }
        }
        super.onMeasure(i2, i3);
    }
}
