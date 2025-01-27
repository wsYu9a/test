package com.bytedance.android.live.base.api.push;

import com.bytedance.android.live.base.api.push.model.PushData;

/* loaded from: classes2.dex */
public interface PushCallback {
    void onFailed(Throwable th2);

    void onSuccess(PushData pushData);
}
