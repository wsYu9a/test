package com.kwad.sdk.core.response.model;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

@KsJson
/* loaded from: classes3.dex */
public class VideoPlayerStatus extends com.kwad.sdk.core.response.a.a implements Serializable {
    private static final long serialVersionUID = -9021213312245598171L;
    public int mVideoPlayerBehavior = 1;
    public int mVideoPlayerType;

    public void setVideoPlayerBehavior(int i10) {
        this.mVideoPlayerBehavior = i10;
    }

    public void setVideoPlayerType(int i10) {
        this.mVideoPlayerType = i10;
    }
}
