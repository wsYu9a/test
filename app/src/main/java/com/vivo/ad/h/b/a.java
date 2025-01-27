package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a extends TextView implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a */
    private InterfaceC0559a f26730a;

    /* renamed from: b */
    private int f26731b;

    /* renamed from: c */
    private int f26732c;

    /* renamed from: d */
    private int f26733d;

    /* renamed from: e */
    private int f26734e;

    /* renamed from: com.vivo.ad.h.b.a$a */
    public interface InterfaceC0559a {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0559a interfaceC0559a = this.f26730a;
        if (interfaceC0559a != null) {
            interfaceC0559a.a(view, this.f26731b, this.f26732c, this.f26733d, this.f26734e);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() != 1) {
            return false;
        }
        this.f26731b = (int) motionEvent.getRawX();
        this.f26732c = (int) motionEvent.getRawY();
        this.f26733d = (int) motionEvent.getX();
        this.f26734e = (int) motionEvent.getY();
        return false;
    }

    public void setOnAWClickListener(InterfaceC0559a interfaceC0559a) {
        this.f26730a = interfaceC0559a;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOnClickListener(this);
        setOnTouchListener(this);
        setGravity(17);
        setTextSize(1, 16.0f);
        setTextColor(-1);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.vivo.ad.h.a.a.a("#FF9013"));
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.b(context, 18.0f));
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
    }
}
