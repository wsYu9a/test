package com.opos.mobad.service.j;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public class i implements d {

    /* renamed from: a */
    private long f23718a = 0;

    /* renamed from: b */
    private int f23719b;

    public i(int i2) {
        this.f23719b = i2;
    }

    @Override // com.opos.mobad.service.j.d
    public boolean a(Object obj) {
        long j2 = this.f23718a;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j2 <= 0) {
            this.f23718a = elapsedRealtime;
        } else if (elapsedRealtime - this.f23718a >= this.f23719b) {
            this.f23718a = SystemClock.elapsedRealtime();
            return true;
        }
        return false;
    }
}
