package com.heytap.msp.mobad.api.params;

/* loaded from: classes.dex */
public class NativeAdParams {
    public final long fetchTimeout;

    public static class Builder {
        private static final long MAX_FETCH_TIMEOUT = 30000;
        private static final long MIX_FETCH_TIMEOUT = 500;
        private long fetchTimeout = MAX_FETCH_TIMEOUT;

        public NativeAdParams build() {
            return new NativeAdParams(this);
        }

        public Builder setFetchTimeout(long j2) {
            if (j2 >= 500 && j2 <= MAX_FETCH_TIMEOUT) {
                this.fetchTimeout = j2;
            }
            return this;
        }
    }

    public NativeAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
    }

    public String toString() {
        return "NativeAdParams{fetchTimeout=" + this.fetchTimeout + '}';
    }
}
