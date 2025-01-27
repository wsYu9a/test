package com.heytap.msp.mobad.api.params;

/* loaded from: classes.dex */
public class RewardVideoAdParams {
    public final long fetchTimeout;

    public static class Builder {
        private static final long DEFAULT_FETCH_TIMEOUT = 5000;
        private static final long MIX_FETCH_TIMEOUT = 1000;
        private long fetchTimeout = 5000;

        public RewardVideoAdParams build() {
            return new RewardVideoAdParams(this);
        }

        public Builder setFetchTimeout(long j2) {
            if (j2 >= 1000) {
                this.fetchTimeout = j2;
            }
            return this;
        }
    }

    public RewardVideoAdParams(Builder builder) {
        this.fetchTimeout = builder.fetchTimeout;
    }
}
