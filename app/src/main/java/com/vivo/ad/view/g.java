package com.vivo.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.RelativeLayout;

/* loaded from: classes4.dex */
public class g extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f27023a;

    /* renamed from: b */
    private int f27024b;

    /* renamed from: c */
    private int f27025c;

    /* renamed from: d */
    private int f27026d;

    /* renamed from: e */
    private k f27027e;

    public g(Context context) {
        super(context);
        this.f27023a = 0;
        this.f27024b = 0;
        this.f27025c = 0;
        this.f27026d = 0;
        setOnClickListener(this);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f27027e;
        if (kVar != null) {
            kVar.a(view, this.f27025c, this.f27026d, this.f27023a, this.f27024b, false);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f27025c = (int) motionEvent.getRawX();
            this.f27026d = (int) motionEvent.getRawY();
            this.f27023a = (int) motionEvent.getX();
            this.f27024b = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f27027e = kVar;
    }
}
