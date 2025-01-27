package com.aggmoread.sdk.z.b.s;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

/* loaded from: classes.dex */
public class i extends CountDownTimer {

    /* renamed from: a, reason: collision with root package name */
    View f4903a;

    /* renamed from: b, reason: collision with root package name */
    a f4904b;

    public interface a {
        void a();

        void a(long j10);
    }

    public i(View view, a aVar, long j10, long j11) {
        super(j10, j11);
        this.f4903a = view;
        this.f4904b = aVar;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.f4904b.a();
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j10) {
        View view = this.f4903a;
        if (view instanceof TextView) {
            ((TextView) view).setText("跳过" + (j10 / 1000) + "s");
        }
        a aVar = this.f4904b;
        if (aVar != null) {
            aVar.a(j10);
        }
    }
}
