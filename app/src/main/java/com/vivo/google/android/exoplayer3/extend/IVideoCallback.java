package com.vivo.google.android.exoplayer3.extend;

/* loaded from: classes4.dex */
public interface IVideoCallback {
    void onCompletion();

    void onError(int i2, int i3);

    void onInfo(int i2, int i3);

    void onInit();

    void onLoadEnd();

    void onLoading();

    void onPause();

    void onPrepared();

    void onRelease();

    void onResume();

    void onStart();

    void onStop();
}
