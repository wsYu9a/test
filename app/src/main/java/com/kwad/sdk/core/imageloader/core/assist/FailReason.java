package com.kwad.sdk.core.imageloader.core.assist;

/* loaded from: classes3.dex */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    public FailReason(FailType failType, Throwable th2) {
        this.type = failType;
        this.cause = th2;
    }

    public Throwable getCause() {
        return this.cause;
    }

    public FailType getType() {
        return this.type;
    }

    public String toString() {
        return "FailReason{type=" + this.type + ", cause=" + this.cause + '}';
    }
}
