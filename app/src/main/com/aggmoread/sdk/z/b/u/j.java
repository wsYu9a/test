package com.aggmoread.sdk.z.b.u;

import android.os.CountDownTimer;
import android.widget.TextView;

/* loaded from: classes.dex */
public class j extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    TextView f5067a;

    /* renamed from: b, reason: collision with root package name */
    a f5068b;

    public interface a {
        void a();

        void a(long j10);
    }

    public j(a aVar, long j10, long j11) {
        super(j10, j11);
        this.f5068b = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f5068b.a();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j10) {
        this.f5068b.a(j10);
        TextView textView = this.f5067a;
        if (textView != null) {
            textView.setText("跳过(" + (j10 / 1000) + ")");
        }
    }
}
