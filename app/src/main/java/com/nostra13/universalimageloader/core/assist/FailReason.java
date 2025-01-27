package com.nostra13.universalimageloader.core.assist;

/* loaded from: classes4.dex */
public class FailReason {

    /* renamed from: a */
    private final FailType f15912a;

    /* renamed from: b */
    private final Throwable f15913b;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th) {
        this.f15912a = failType;
        this.f15913b = th;
    }

    public Throwable a() {
        return this.f15913b;
    }

    public FailType getType() {
        return this.f15912a;
    }
}
