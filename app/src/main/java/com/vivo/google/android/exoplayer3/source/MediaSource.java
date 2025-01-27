package com.vivo.google.android.exoplayer3.source;

import com.vivo.google.android.exoplayer3.ExoPlayer;
import com.vivo.google.android.exoplayer3.Timeline;
import com.vivo.google.android.exoplayer3.k5;
import com.vivo.google.android.exoplayer3.o3;

/* loaded from: classes4.dex */
public interface MediaSource {

    public interface Listener {
        void onSourceInfoRefreshed(Timeline timeline, Object obj);
    }

    o3 createPeriod(int i2, k5 k5Var, long j2);

    void maybeThrowSourceInfoRefreshError();

    void prepareSource(ExoPlayer exoPlayer, boolean z, Listener listener);

    void releasePeriod(o3 o3Var);

    void releaseSource();
}
