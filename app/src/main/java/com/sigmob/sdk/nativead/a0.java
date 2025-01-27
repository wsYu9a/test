package com.sigmob.sdk.nativead;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class a0 extends Handler {

    /* renamed from: c */
    public static final int f19916c = 87108;

    /* renamed from: a */
    public long f19917a;

    /* renamed from: b */
    public boolean f19918b;

    public a0() {
        this.f19917a = 100L;
        this.f19918b = true;
    }

    public boolean a() {
        return this.f19918b;
    }

    public void b() {
        sendEmptyMessageDelayed(f19916c, this.f19917a);
    }

    public a0(Looper looper) {
        super(looper);
        this.f19917a = 100L;
        this.f19918b = true;
    }

    public void a(boolean z10) {
        this.f19918b = z10;
    }
}
