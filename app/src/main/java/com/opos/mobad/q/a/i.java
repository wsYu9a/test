package com.opos.mobad.q.a;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public abstract class i implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a */
    private int[] f23344a = new int[4];

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, this.f23344a);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f23344a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f23344a[0] = (int) motionEvent.getX();
                this.f23344a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f23344a[2] = (int) motionEvent.getX();
                this.f23344a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
