package com.shu.priory.listener;

import com.shu.priory.conn.VideoDataRef;

/* loaded from: classes3.dex */
public interface IFLYVideoListener extends IFLYBaseAdListener<VideoDataRef> {
    void onAdClick();

    void onAdPlayError();

    void onVideoCached();

    void onVideoComplete();

    void onVideoReplay();

    void onVideoStart();
}
