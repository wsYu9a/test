package com.vivo.mobilead.unified.base.callback;

import com.vivo.mobilead.unified.base.VivoAdError;

/* loaded from: classes4.dex */
public interface MediaListener {
    void onVideoCached();

    void onVideoCompletion();

    void onVideoError(VivoAdError vivoAdError);

    void onVideoPause();

    void onVideoPlay();

    void onVideoStart();
}
