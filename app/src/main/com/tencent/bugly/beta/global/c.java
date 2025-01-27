package com.tencent.bugly.beta.global;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public class c implements View.OnTouchListener {

    /* renamed from: a */
    final int f22095a;

    /* renamed from: b */
    final Object[] f22096b;

    public c(int i10, Object... objArr) {
        this.f22095a = i10;
        this.f22096b = objArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
        } catch (Exception e10) {
            if (!X.a(e10)) {
                e10.printStackTrace();
            }
        }
        if (this.f22095a != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0 || action == 2) {
            view.setBackgroundDrawable((Drawable) this.f22096b[0]);
        } else {
            view.setBackgroundDrawable((Drawable) this.f22096b[1]);
        }
        return false;
    }
}
