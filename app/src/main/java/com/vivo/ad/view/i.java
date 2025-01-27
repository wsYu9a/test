package com.vivo.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;

/* loaded from: classes4.dex */
public class i extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f27031a;

    /* renamed from: b */
    private int f27032b;

    /* renamed from: c */
    private int f27033c;

    /* renamed from: d */
    private int f27034d;

    /* renamed from: e */
    private k f27035e;

    public i(Context context) {
        super(context);
        this.f27031a = 0;
        this.f27032b = 0;
        this.f27033c = 0;
        this.f27034d = 0;
        setOnClickListener(this);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f27035e;
        if (kVar != null) {
            kVar.a(view, this.f27033c, this.f27034d, this.f27031a, this.f27032b, false);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f27033c = (int) motionEvent.getRawX();
            this.f27034d = (int) motionEvent.getRawY();
            this.f27031a = (int) motionEvent.getX();
            this.f27032b = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f27035e = kVar;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }
}
