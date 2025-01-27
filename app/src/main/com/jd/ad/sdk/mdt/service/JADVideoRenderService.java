package com.jd.ad.sdk.mdt.service;

import android.content.Context;
import androidx.annotation.NonNull;
import com.jd.ad.sdk.bl.video.VideoRenderView;
import com.jd.ad.sdk.bl.video.listener.OnVideoRenderListener;
import com.jd.ad.sdk.bl.video.listener.VideoInteractionListener;
import com.jd.ad.sdk.bl.video.listener.VideoLoadListener;
import com.jd.ad.sdk.dl.model.JADSlot;

/* loaded from: classes2.dex */
public interface JADVideoRenderService {
    VideoRenderView createVideoRendView(Context context, @NonNull String str, @NonNull JADSlot jADSlot, long j10, OnVideoRenderListener onVideoRenderListener, VideoLoadListener videoLoadListener);

    void registerAdViewClick(Context context, VideoRenderView videoRenderView, VideoInteractionListener videoInteractionListener);
}
