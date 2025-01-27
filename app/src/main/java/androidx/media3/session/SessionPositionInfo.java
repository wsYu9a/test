package androidx.media3.session;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.C;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import b5.r;

/* loaded from: classes.dex */
final class SessionPositionInfo implements Bundleable {
    public static final Bundleable.Creator<SessionPositionInfo> CREATOR;
    public static final SessionPositionInfo DEFAULT;
    public static final Player.PositionInfo DEFAULT_POSITION_INFO;
    private static final String FIELD_BUFFERED_PERCENTAGE;
    private static final String FIELD_BUFFERED_POSITION_MS;
    private static final String FIELD_CONTENT_BUFFERED_POSITION_MS;
    private static final String FIELD_CONTENT_DURATION_MS;
    private static final String FIELD_CURRENT_LIVE_OFFSET_MS;
    private static final String FIELD_DURATION_MS;
    private static final String FIELD_EVENT_TIME_MS;
    private static final String FIELD_IS_PLAYING_AD;
    private static final String FIELD_POSITION_INFO;
    private static final String FIELD_TOTAL_BUFFERED_DURATION_MS;
    public final int bufferedPercentage;
    public final long bufferedPositionMs;
    public final long contentBufferedPositionMs;
    public final long contentDurationMs;
    public final long currentLiveOffsetMs;
    public final long durationMs;
    public final long eventTimeMs;
    public final boolean isPlayingAd;
    public final Player.PositionInfo positionInfo;
    public final long totalBufferedDurationMs;

    static {
        Player.PositionInfo positionInfo = new Player.PositionInfo(null, 0, null, null, 0, 0L, 0L, -1, -1);
        DEFAULT_POSITION_INFO = positionInfo;
        DEFAULT = new SessionPositionInfo(positionInfo, false, C.TIME_UNSET, C.TIME_UNSET, 0L, 0, 0L, C.TIME_UNSET, C.TIME_UNSET, 0L);
        FIELD_POSITION_INFO = Util.intToStringMaxRadix(0);
        FIELD_IS_PLAYING_AD = Util.intToStringMaxRadix(1);
        FIELD_EVENT_TIME_MS = Util.intToStringMaxRadix(2);
        FIELD_DURATION_MS = Util.intToStringMaxRadix(3);
        FIELD_BUFFERED_POSITION_MS = Util.intToStringMaxRadix(4);
        FIELD_BUFFERED_PERCENTAGE = Util.intToStringMaxRadix(5);
        FIELD_TOTAL_BUFFERED_DURATION_MS = Util.intToStringMaxRadix(6);
        FIELD_CURRENT_LIVE_OFFSET_MS = Util.intToStringMaxRadix(7);
        FIELD_CONTENT_DURATION_MS = Util.intToStringMaxRadix(8);
        FIELD_CONTENT_BUFFERED_POSITION_MS = Util.intToStringMaxRadix(9);
        CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.xd
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                SessionPositionInfo fromBundle;
                fromBundle = SessionPositionInfo.fromBundle(bundle);
                return fromBundle;
            }
        };
    }

    public SessionPositionInfo(Player.PositionInfo positionInfo, boolean z10, long j10, long j11, long j12, int i10, long j13, long j14, long j15, long j16) {
        Assertions.checkArgument(z10 == (positionInfo.adGroupIndex != -1));
        this.positionInfo = positionInfo;
        this.isPlayingAd = z10;
        this.eventTimeMs = j10;
        this.durationMs = j11;
        this.bufferedPositionMs = j12;
        this.bufferedPercentage = i10;
        this.totalBufferedDurationMs = j13;
        this.currentLiveOffsetMs = j14;
        this.contentDurationMs = j15;
        this.contentBufferedPositionMs = j16;
    }

    public static SessionPositionInfo fromBundle(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(FIELD_POSITION_INFO);
        return new SessionPositionInfo(bundle2 == null ? DEFAULT_POSITION_INFO : Player.PositionInfo.CREATOR.fromBundle(bundle2), bundle.getBoolean(FIELD_IS_PLAYING_AD, false), bundle.getLong(FIELD_EVENT_TIME_MS, C.TIME_UNSET), bundle.getLong(FIELD_DURATION_MS, C.TIME_UNSET), bundle.getLong(FIELD_BUFFERED_POSITION_MS, 0L), bundle.getInt(FIELD_BUFFERED_PERCENTAGE, 0), bundle.getLong(FIELD_TOTAL_BUFFERED_DURATION_MS, 0L), bundle.getLong(FIELD_CURRENT_LIVE_OFFSET_MS, C.TIME_UNSET), bundle.getLong(FIELD_CONTENT_DURATION_MS, C.TIME_UNSET), bundle.getLong(FIELD_CONTENT_BUFFERED_POSITION_MS, 0L));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SessionPositionInfo.class != obj.getClass()) {
            return false;
        }
        SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) obj;
        return this.positionInfo.equals(sessionPositionInfo.positionInfo) && this.isPlayingAd == sessionPositionInfo.isPlayingAd && this.eventTimeMs == sessionPositionInfo.eventTimeMs && this.durationMs == sessionPositionInfo.durationMs && this.bufferedPositionMs == sessionPositionInfo.bufferedPositionMs && this.bufferedPercentage == sessionPositionInfo.bufferedPercentage && this.totalBufferedDurationMs == sessionPositionInfo.totalBufferedDurationMs && this.currentLiveOffsetMs == sessionPositionInfo.currentLiveOffsetMs && this.contentDurationMs == sessionPositionInfo.contentDurationMs && this.contentBufferedPositionMs == sessionPositionInfo.contentBufferedPositionMs;
    }

    public int hashCode() {
        return r.b(this.positionInfo, Boolean.valueOf(this.isPlayingAd));
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        return toBundle(true, true);
    }

    public String toString() {
        return "SessionPositionInfo {PositionInfo {mediaItemIndex=" + this.positionInfo.mediaItemIndex + ", periodIndex=" + this.positionInfo.periodIndex + ", positionMs=" + this.positionInfo.positionMs + ", contentPositionMs=" + this.positionInfo.contentPositionMs + ", adGroupIndex=" + this.positionInfo.adGroupIndex + ", adIndexInAdGroup=" + this.positionInfo.adIndexInAdGroup + "}, isPlayingAd=" + this.isPlayingAd + ", eventTimeMs=" + this.eventTimeMs + ", durationMs=" + this.durationMs + ", bufferedPositionMs=" + this.bufferedPositionMs + ", bufferedPercentage=" + this.bufferedPercentage + ", totalBufferedDurationMs=" + this.totalBufferedDurationMs + ", currentLiveOffsetMs=" + this.currentLiveOffsetMs + ", contentDurationMs=" + this.contentDurationMs + ", contentBufferedPositionMs=" + this.contentBufferedPositionMs + p3.f.f29748d;
    }

    public Bundle toBundle(boolean z10, boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putBundle(FIELD_POSITION_INFO, this.positionInfo.toBundle(z10, z11));
        bundle.putBoolean(FIELD_IS_PLAYING_AD, z10 && this.isPlayingAd);
        bundle.putLong(FIELD_EVENT_TIME_MS, this.eventTimeMs);
        String str = FIELD_DURATION_MS;
        long j10 = C.TIME_UNSET;
        bundle.putLong(str, z10 ? this.durationMs : -9223372036854775807L);
        bundle.putLong(FIELD_BUFFERED_POSITION_MS, z10 ? this.bufferedPositionMs : 0L);
        bundle.putInt(FIELD_BUFFERED_PERCENTAGE, z10 ? this.bufferedPercentage : 0);
        bundle.putLong(FIELD_TOTAL_BUFFERED_DURATION_MS, z10 ? this.totalBufferedDurationMs : 0L);
        bundle.putLong(FIELD_CURRENT_LIVE_OFFSET_MS, z10 ? this.currentLiveOffsetMs : -9223372036854775807L);
        String str2 = FIELD_CONTENT_DURATION_MS;
        if (z10) {
            j10 = this.contentDurationMs;
        }
        bundle.putLong(str2, j10);
        bundle.putLong(FIELD_CONTENT_BUFFERED_POSITION_MS, z10 ? this.contentBufferedPositionMs : 0L);
        return bundle;
    }
}
