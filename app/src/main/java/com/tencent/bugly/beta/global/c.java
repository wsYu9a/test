package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class c implements View.OnTouchListener {

    /* renamed from: a */
    final int f24616a;

    /* renamed from: b */
    final Object[] f24617b;

    public c(int i2, Object... objArr) {
        this.f24616a = i2;
        this.f24617b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e2) {
            if (!X.a(e2)) {
                e2.printStackTrace();
            }
        }
        if (this.f24616a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundDrawable((Drawable) this.f24617b[0]);
        } else {
            view.setBackgroundDrawable((Drawable) this.f24617b[1]);
        }
        return false;
    }
}
