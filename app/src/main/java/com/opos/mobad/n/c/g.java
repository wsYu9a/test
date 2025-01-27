package com.opos.mobad.n.c;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public abstract class g implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a */
    private int[] f22030a = new int[4];

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, this.f22030a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f22030a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f22030a[0] = (int) motionEvent.getX();
                this.f22030a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f22030a[2] = (int) motionEvent.getX();
                this.f22030a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
