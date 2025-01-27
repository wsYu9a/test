package com.aggmoread.sdk.z.b.m;

import android.os.CountDownTimer;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private CountDownTimer f4723a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f4724b = true;

    /* renamed from: c, reason: collision with root package name */
    private long f4725c;

    /* renamed from: d, reason: collision with root package name */
    private long f4726d;

    /* renamed from: e, reason: collision with root package name */
    private long f4727e;

    public class a extends CountDownTimer {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            m.this.c();
            m.this.g();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            m.this.a(j10);
            m mVar = m.this;
            mVar.a(j10, mVar.f4725c - j10);
        }
    }

    public m(long j10, long j11) {
        this.f4725c = j10;
        this.f4726d = j11;
        this.f4727e = j10;
    }

    public long a() {
        return this.f4727e;
    }

    public abstract void a(long j10, long j11);

    public final synchronized void b(long j10, long j11) {
        String str;
        String str2;
        try {
            this.f4727e = j10;
            this.f4726d = j11;
            if (this.f4725c <= 0 || j11 <= 0) {
                str = "ApiCountdownTimer";
                str2 = "invalid parameter";
            } else {
                if (!this.f4724b) {
                    g();
                }
                if (this.f4724b) {
                    a aVar = new a(a(), this.f4726d);
                    this.f4723a = aVar;
                    try {
                        aVar.start();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    this.f4724b = false;
                } else {
                    str = "ApiCountdownTimer";
                    str2 = "ignore start";
                }
            }
            Log.d(str, str2);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public abstract void c();

    public final void d() {
        if (this.f4724b) {
            return;
        }
        try {
            this.f4723a.cancel();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f4724b = true;
    }

    public final void e() {
        if (b()) {
            return;
        }
        b(this.f4727e, this.f4726d);
    }

    public final void f() {
        b(this.f4727e, this.f4726d);
    }

    public final void g() {
        try {
            this.f4723a.cancel();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.f4724b = true;
        this.f4727e = this.f4725c;
    }

    public final boolean b() {
        return !this.f4724b;
    }

    public final void a(long j10) {
        this.f4727e = j10;
    }
}
