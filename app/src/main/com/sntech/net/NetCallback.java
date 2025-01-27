package com.sntech.net;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes4.dex */
public interface NetCallback {
    @Keep
    void onFailure(Exception exc);

    @Keep
    void onSuccess(String str);
}
