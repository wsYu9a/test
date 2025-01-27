package com.bytedance.android.livehostapi.platform;

/* loaded from: classes2.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable th2);

    void onSuccess(TokenInfo tokenInfo);
}
