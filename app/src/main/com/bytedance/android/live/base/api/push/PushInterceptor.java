package com.bytedance.android.live.base.api.push;

/* loaded from: classes2.dex */
public interface PushInterceptor {

    public static class InterceptResult {
        public boolean intercept;
        public String interceptReason;

        public InterceptResult() {
        }

        public InterceptResult(boolean z10) {
            this(z10, "");
        }

        public InterceptResult(boolean z10, String str) {
            this.intercept = z10;
            this.interceptReason = "";
        }
    }

    InterceptResult intercept();
}
