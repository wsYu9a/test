package com.bytedance.sdk.openadsdk.live;

import java.io.Serializable;

/* loaded from: classes2.dex */
public interface TTLiveAuthCallback extends Serializable {
    void onAuth(TTLiveToken tTLiveToken);

    void onFailed(Throwable th2);
}
