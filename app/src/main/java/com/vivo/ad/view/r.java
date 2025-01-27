package com.vivo.ad.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public class r extends com.vivo.mobilead.unified.interstitial.m.a implements View.OnClickListener {

    /* renamed from: j */
    private int f27075j;
    private int k;
    private int l;
    private int m;
    private k n;

    public r(Context context) {
        super(context);
        this.f27075j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        setOnClickListener(this);
    }

    @Override // com.vivo.mobilead.unified.interstitial.m.a, android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.n;
        if (kVar != null) {
            kVar.a(view, this.l, this.m, this.f27075j, this.k, false);
        }
    }

    @Override // com.vivo.mobilead.unified.interstitial.m.a, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.l = (int) motionEvent.getRawX();
            this.m = (int) motionEvent.getRawY();
            this.f27075j = (int) motionEvent.getX();
            this.k = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.mobilead.unified.interstitial.m.a
    public void setOnADWidgetClickListener(k kVar) {
        this.n = kVar;
    }
}
