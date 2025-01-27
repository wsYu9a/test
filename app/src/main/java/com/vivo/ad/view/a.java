package com.vivo.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/* loaded from: classes4.dex */
public class a extends Button implements View.OnClickListener {

    /* renamed from: a */
    private int f26989a;

    /* renamed from: b */
    private int f26990b;

    /* renamed from: c */
    private int f26991c;

    /* renamed from: d */
    private int f26992d;

    /* renamed from: e */
    private k f26993e;

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f26993e;
        if (kVar != null) {
            kVar.a(view, this.f26991c, this.f26992d, this.f26989a, this.f26990b, true);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f26989a = (int) motionEvent.getX();
            this.f26990b = (int) motionEvent.getY();
            this.f26991c = (int) motionEvent.getRawX();
            this.f26992d = (int) motionEvent.getRawY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f26993e = kVar;
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26989a = 0;
        this.f26990b = 0;
        this.f26991c = 0;
        this.f26992d = 0;
        setOnClickListener(this);
    }
}
