package com.vivo.mobilead.unified.interstitial.m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.RelativeLayout;
import com.vivo.ad.view.k;

/* loaded from: classes4.dex */
public class a extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a */
    private int f30445a;

    /* renamed from: b */
    private float[] f30446b;

    /* renamed from: c */
    private Path f30447c;

    /* renamed from: d */
    private RectF f30448d;

    /* renamed from: e */
    private int f30449e;

    /* renamed from: f */
    private int f30450f;

    /* renamed from: g */
    private int f30451g;

    /* renamed from: h */
    private int f30452h;

    /* renamed from: i */
    private k f30453i;

    public a(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.f30448d.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.f30447c.reset();
        this.f30447c.addRoundRect(this.f30448d, this.f30446b, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.f30447c);
        super.draw(canvas);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void onClick(View view) {
        k kVar = this.f30453i;
        if (kVar != null) {
            kVar.a(view, this.f30449e, this.f30450f, this.f30451g, this.f30452h, false);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f30449e = (int) motionEvent.getRawX();
            this.f30450f = (int) motionEvent.getRawY();
            this.f30451g = (int) motionEvent.getX();
            this.f30452h = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f30453i = kVar;
    }

    public void setRadius(int i2) {
        this.f30445a = i2;
        float f2 = i2;
        this.f30446b = new float[]{f2, f2, f2, f2, f2, f2, f2, f2};
        requestLayout();
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30445a = 5;
        float f2 = 5;
        this.f30446b = new float[]{f2, f2, f2, f2, f2, f2, f2, f2};
        this.f30447c = new Path();
        this.f30448d = new RectF();
        setBackground(new ColorDrawable(0));
        setOnClickListener(this);
    }

    public void setRadius(float[] fArr) {
        this.f30446b = fArr;
        requestLayout();
    }
}
