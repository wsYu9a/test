package com.vivo.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class f extends TextView implements View.OnClickListener {

    /* renamed from: a */
    private int f27018a;

    /* renamed from: b */
    private int f27019b;

    /* renamed from: c */
    private int f27020c;

    /* renamed from: d */
    private int f27021d;

    /* renamed from: e */
    private k f27022e;

    public f(Context context) {
        this(context, null);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.f27022e;
        if (kVar != null) {
            kVar.a(view, this.f27020c, this.f27021d, this.f27018a, this.f27019b, true);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f27018a = (int) motionEvent.getX();
            this.f27019b = (int) motionEvent.getY();
            this.f27020c = (int) motionEvent.getRawX();
            this.f27021d = (int) motionEvent.getRawY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetClickListener(k kVar) {
        this.f27022e = kVar;
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27018a = 0;
        this.f27019b = 0;
        this.f27020c = 0;
        this.f27021d = 0;
        setOnClickListener(this);
    }
}
