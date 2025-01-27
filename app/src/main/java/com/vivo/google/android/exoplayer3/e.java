package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;

/* loaded from: classes4.dex */
public interface e {
    k5 getAllocator();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

    boolean shouldContinueLoading(long j2);

    boolean shouldStartPlayback(long j2, boolean z);
}
