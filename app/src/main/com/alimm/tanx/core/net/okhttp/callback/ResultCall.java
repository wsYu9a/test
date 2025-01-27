package com.alimm.tanx.core.net.okhttp.callback;

/* loaded from: classes.dex */
public interface ResultCall {
    void inProgress(float f10);

    void onAfter();

    void onBefore();

    void onError(int i10, String str);

    void onSuccess(String str);
}
