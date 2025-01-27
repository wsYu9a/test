package com.bytedance.android.live.base.api.outer;

/* loaded from: classes2.dex */
public interface ILiveStatusListener {
    void onError(String str);

    void onFirstFrame();

    void onLiveStatusChange(boolean z10);

    void onPrepare();

    void onRoomInvalid();

    void onVideoSizeChanged(int i10, int i11);
}
