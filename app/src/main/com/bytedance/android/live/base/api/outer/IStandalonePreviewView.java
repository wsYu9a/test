package com.bytedance.android.live.base.api.outer;

import android.view.View;

/* loaded from: classes2.dex */
public interface IStandalonePreviewView {
    View getView();

    void release();

    void setLiveStatusListener(ILiveStatusListener iLiveStatusListener);

    void setMute(boolean z10);

    void show();

    void stream();
}
