package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.ExoPlayer;

/* loaded from: classes4.dex */
public interface Renderer extends ExoPlayer.ExoPlayerComponent {
    public static final int STATE_DISABLED = 0;
    public static final int STATE_ENABLED = 1;
    public static final int STATE_STARTED = 2;

    void disable();

    void enable(h hVar, Format[] formatArr, p3 p3Var, long j2, boolean z, long j3);

    g getCapabilities();

    k6 getMediaClock();

    int getState();

    p3 getStream();

    int getTrackType();

    boolean hasReadStreamToEnd();

    boolean isCurrentStreamFinal();

    boolean isEnded();

    boolean isReady();

    void maybeThrowStreamError();

    void render(long j2, long j3);

    void replaceStream(Format[] formatArr, p3 p3Var, long j2);

    void resetPosition(long j2);

    void setCurrentStreamFinal();

    void setIndex(int i2);

    void start();

    void stop();
}
