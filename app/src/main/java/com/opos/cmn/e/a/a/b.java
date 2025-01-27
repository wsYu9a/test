package com.opos.cmn.e.a.a;

import android.view.MotionEvent;
import android.view.View;

/* loaded from: classes4.dex */
public class b implements View.OnTouchListener {

    /* renamed from: a */
    private int[] f16924a;

    public b(int[] iArr) {
        this.f16924a = iArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f16924a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f16924a[0] = (int) motionEvent.getX();
                this.f16924a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f16924a[2] = (int) motionEvent.getX();
                this.f16924a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
