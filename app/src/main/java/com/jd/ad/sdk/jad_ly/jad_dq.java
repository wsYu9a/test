package com.jd.ad.sdk.jad_ly;

import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.VideoSkipView;

/* loaded from: classes2.dex */
public class jad_dq implements Runnable {
    public final /* synthetic */ VideoRenderView jad_an;

    public jad_dq(VideoRenderView videoRenderView) {
        this.jad_an = videoRenderView;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoSkipView videoSkipView = this.jad_an.jad_it;
        if (videoSkipView != null) {
            int i10 = videoSkipView.jad_an;
            if (i10 < 1 || i10 > 30) {
                videoSkipView.jad_an = 5;
            }
            videoSkipView.post(videoSkipView.jad_er);
        }
    }
}
