package com.vivo.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class b extends ImageView implements View.OnClickListener {

    /* renamed from: a */
    private int f26994a;

    /* renamed from: b */
    private int f26995b;

    /* renamed from: c */
    private int f26996c;

    /* renamed from: d */
    private int f26997d;

    /* renamed from: e */
    private k f26998e;

    public b(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f26998e;
        if (kVar != null) {
            kVar.a(view, this.f26996c, this.f26997d, this.f26994a, this.f26995b, false);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f26996c = (int) motionEvent.getRawX();
            this.f26997d = (int) motionEvent.getRawY();
            this.f26994a = (int) motionEvent.getX();
            this.f26995b = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f26998e = kVar;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f26994a = 0;
        this.f26995b = 0;
        this.f26996c = 0;
        this.f26997d = 0;
        setOnClickListener(this);
    }
}
