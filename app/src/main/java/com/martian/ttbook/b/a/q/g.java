package com.martian.ttbook.b.a.q;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class g extends CountDownTimer {

    /* renamed from: a */
    TextView f15167a;

    /* renamed from: b */
    a f15168b;

    public interface a {
        void a();

        void a(long j2);
    }

    public g(a aVar, long j2, long j3) {
        super(j2, j3);
        this.f15168b = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f15168b.a();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        this.f15168b.a(j2);
        TextView textView = this.f15167a;
        if (textView != null) {
            textView.setText("跳过(" + (j2 / 1000) + ")");
        }
    }
}
