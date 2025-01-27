package com.baidu.mobads.sdk.internal;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: classes.dex */
class di extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ dg f5793a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    di(dg dgVar, long j2, long j3) {
        super(j2, j3);
        this.f5793a = dgVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f5793a.f5784b.a("CountDownTimer finished");
        this.f5793a.c();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        TextView textView;
        int i2 = (int) (j2 / 1000);
        if (i2 > 5) {
            i2 = 5;
        }
        textView = this.f5793a.f5786d;
        textView.setText(String.valueOf(i2));
    }
}
