package com.alimm.tanx.core.ad.event.track.expose;

/* loaded from: classes.dex */
public interface ExposeCallback {
    void onFail(int i10, String str, String str2);

    void onSucceed(int i10, String str);

    void send(String str);
}
