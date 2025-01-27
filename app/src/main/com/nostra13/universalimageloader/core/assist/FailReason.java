package com.nostra13.universalimageloader.core.assist;

/* loaded from: classes3.dex */
public class FailReason {

    /* renamed from: a */
    public final FailType f16328a;

    /* renamed from: b */
    public final Throwable f16329b;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th2) {
        this.f16328a = failType;
        this.f16329b = th2;
    }

    public Throwable a() {
        return this.f16329b;
    }

    public FailType getType() {
        return this.f16328a;
    }
}
