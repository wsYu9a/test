package com.czhj.sdk.common.mta;

/* loaded from: classes2.dex */
public abstract class PointEntityCrash extends PointEntitySuper {

    /* renamed from: r */
    public String f8494r;

    /* renamed from: s */
    public long f8495s = 0;

    public String getCrashMessage() {
        return this.f8494r;
    }

    public long getCrashTime() {
        return this.f8495s;
    }

    public void setCrashMessage(String str) {
        this.f8494r = str;
    }

    public void setCrashTime(long j10) {
        this.f8495s = j10;
    }
}
