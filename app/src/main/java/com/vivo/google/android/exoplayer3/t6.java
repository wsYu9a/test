package com.vivo.google.android.exoplayer3;

import android.os.SystemClock;

/* loaded from: classes4.dex */
public final class t6 implements k6 {

    /* renamed from: a */
    public boolean f28113a;

    /* renamed from: b */
    public long f28114b;

    /* renamed from: c */
    public long f28115c;

    /* renamed from: d */
    public PlaybackParameters f28116d = PlaybackParameters.DEFAULT;

    @Override // com.vivo.google.android.exoplayer3.k6
    public long a() {
        long j2 = this.f28114b;
        if (!this.f28113a) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f28115c;
        PlaybackParameters playbackParameters = this.f28116d;
        return j2 + (playbackParameters.speed == 1.0f ? C.msToUs(elapsedRealtime) : playbackParameters.getSpeedAdjustedDurationUs(elapsedRealtime));
    }

    public void a(long j2) {
        this.f28114b = j2;
        if (this.f28113a) {
            this.f28115c = SystemClock.elapsedRealtime();
        }
    }

    public void a(k6 k6Var) {
        a(k6Var.a());
        this.f28116d = k6Var.getPlaybackParameters();
    }

    @Override // com.vivo.google.android.exoplayer3.k6
    public PlaybackParameters getPlaybackParameters() {
        return this.f28116d;
    }

    @Override // com.vivo.google.android.exoplayer3.k6
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (this.f28113a) {
            a(a());
        }
        this.f28116d = playbackParameters;
        return playbackParameters;
    }
}
