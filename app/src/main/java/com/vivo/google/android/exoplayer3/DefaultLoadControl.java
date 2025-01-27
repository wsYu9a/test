package com.vivo.google.android.exoplayer3;

import com.vivo.google.android.exoplayer3.source.TrackGroupArray;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelectionArray;
import com.vivo.google.android.exoplayer3.util.Util;

/* loaded from: classes4.dex */
public final class DefaultLoadControl implements e {
    public static final int ABOVE_HIGH_WATERMARK = 0;
    public static final int BELOW_LOW_WATERMARK = 2;
    public static final int BETWEEN_WATERMARKS = 1;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_MAX_BUFFER_MS = 8000;
    public static final int DEFAULT_MIN_BUFFER_MS = 3000;
    public final r5 allocator;
    public final long bufferForPlaybackAfterRebufferUs;
    public final long bufferForPlaybackUs;
    public boolean isBuffering;
    public final long maxBufferUs;
    public final long minBufferUs;
    public final q6 priorityTaskManager;
    public int targetBufferSize;

    public DefaultLoadControl() {
        this(new r5(true, 65536));
    }

    public DefaultLoadControl(r5 r5Var) {
        this(r5Var, 3000, DEFAULT_MAX_BUFFER_MS, 2500L, 5000L);
    }

    public DefaultLoadControl(r5 r5Var, int i2, int i3, long j2, long j3) {
        this(r5Var, i2, i3, j2, j3, null);
    }

    public DefaultLoadControl(r5 r5Var, int i2, int i3, long j2, long j3, q6 q6Var) {
        this.allocator = r5Var;
        this.minBufferUs = i2 * 1000;
        this.maxBufferUs = i3 * 1000;
        this.bufferForPlaybackUs = j2 * 1000;
        this.bufferForPlaybackAfterRebufferUs = j3 * 1000;
        this.priorityTaskManager = q6Var;
    }

    private int getBufferTimeState(long j2) {
        if (j2 > this.maxBufferUs) {
            return 0;
        }
        return j2 < this.minBufferUs ? 2 : 1;
    }

    private void reset(boolean z) {
        this.targetBufferSize = 0;
        this.isBuffering = false;
        if (z) {
            this.allocator.d();
        }
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public k5 getAllocator() {
        return this.allocator;
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public void onPrepared() {
        reset(false);
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public void onReleased() {
        reset(true);
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public void onStopped() {
        reset(true);
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.targetBufferSize = 0;
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            if (trackSelectionArray.get(i2) != null) {
                this.targetBufferSize += Util.getDefaultBufferSize(rendererArr[i2].getTrackType());
            }
        }
        this.allocator.a(this.targetBufferSize);
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public boolean shouldContinueLoading(long j2) {
        int bufferTimeState = getBufferTimeState(j2);
        boolean z = false;
        boolean z2 = this.allocator.c() >= this.targetBufferSize;
        boolean z3 = this.isBuffering;
        if (bufferTimeState == 2 || (bufferTimeState == 1 && z3 && !z2)) {
            z = true;
        }
        this.isBuffering = z;
        return z;
    }

    @Override // com.vivo.google.android.exoplayer3.e
    public boolean shouldStartPlayback(long j2, boolean z) {
        long j3 = z ? this.bufferForPlaybackAfterRebufferUs : this.bufferForPlaybackUs;
        return j3 <= 0 || j2 >= j3;
    }
}
