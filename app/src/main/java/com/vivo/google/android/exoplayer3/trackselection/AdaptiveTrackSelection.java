package com.vivo.google.android.exoplayer3.trackselection;

import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.f5;
import com.vivo.google.android.exoplayer3.m5;
import com.vivo.google.android.exoplayer3.s3;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import com.vivo.google.android.exoplayer3.v3;
import java.util.List;

/* loaded from: classes4.dex */
public class AdaptiveTrackSelection extends f5 {
    public static final float DEFAULT_BANDWIDTH_FRACTION = 0.75f;
    public static final int DEFAULT_MAX_DURATION_FOR_QUALITY_DECREASE_MS = 25000;
    public static final int DEFAULT_MAX_INITIAL_BITRATE = 800000;
    public static final int DEFAULT_MIN_DURATION_FOR_QUALITY_INCREASE_MS = 10000;
    public static final int DEFAULT_MIN_DURATION_TO_RETAIN_AFTER_DISCARD_MS = 25000;
    public final float bandwidthFraction;
    public final m5 bandwidthMeter;
    public final long maxDurationForQualityDecreaseUs;
    public final int maxInitialBitrate;
    public final long minDurationForQualityIncreaseUs;
    public final long minDurationToRetainAfterDiscardUs;
    public int reason;
    public int selectedIndex;

    public static final class Factory implements TrackSelection.Factory {
        public final float bandwidthFraction;
        public final m5 bandwidthMeter;
        public final int maxDurationForQualityDecreaseMs;
        public final int maxInitialBitrate;
        public final int minDurationForQualityIncreaseMs;
        public final int minDurationToRetainAfterDiscardMs;

        public Factory(m5 m5Var) {
            this(m5Var, AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE, 10000, 25000, 25000, 0.75f);
        }

        public Factory(m5 m5Var, int i2, int i3, int i4, int i5, float f2) {
            this.bandwidthMeter = m5Var;
            this.maxInitialBitrate = i2;
            this.minDurationForQualityIncreaseMs = i3;
            this.maxDurationForQualityDecreaseMs = i4;
            this.minDurationToRetainAfterDiscardMs = i5;
            this.bandwidthFraction = f2;
        }

        @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection.Factory
        public AdaptiveTrackSelection createTrackSelection(s3 s3Var, int... iArr) {
            return new AdaptiveTrackSelection(s3Var, iArr, this.bandwidthMeter, this.maxInitialBitrate, this.minDurationForQualityIncreaseMs, this.maxDurationForQualityDecreaseMs, this.minDurationToRetainAfterDiscardMs, this.bandwidthFraction);
        }
    }

    public AdaptiveTrackSelection(s3 s3Var, int[] iArr, m5 m5Var) {
        this(s3Var, iArr, m5Var, DEFAULT_MAX_INITIAL_BITRATE, 10000L, 25000L, 25000L, 0.75f);
    }

    public AdaptiveTrackSelection(s3 s3Var, int[] iArr, m5 m5Var, int i2, long j2, long j3, long j4, float f2) {
        super(s3Var, iArr);
        this.bandwidthMeter = m5Var;
        this.maxInitialBitrate = i2;
        this.minDurationForQualityIncreaseUs = j2 * 1000;
        this.maxDurationForQualityDecreaseUs = j3 * 1000;
        this.minDurationToRetainAfterDiscardUs = j4 * 1000;
        this.bandwidthFraction = f2;
        this.selectedIndex = determineIdealSelectedIndex(Long.MIN_VALUE);
        this.reason = 1;
    }

    private int determineIdealSelectedIndex(long j2) {
        long bitrateEstimate = this.bandwidthMeter.getBitrateEstimate();
        long j3 = bitrateEstimate == -1 ? this.maxInitialBitrate : (long) (bitrateEstimate * this.bandwidthFraction);
        int i2 = 0;
        for (int i3 = 0; i3 < this.length; i3++) {
            if (j2 == Long.MIN_VALUE || !isBlacklisted(i3, j2)) {
                if (getFormat(i3).bitrate <= j3) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.vivo.google.android.exoplayer3.f5, com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int evaluateQueueSize(long j2, List<? extends v3> list) {
        int i2;
        int i3;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        if (list.get(size - 1).f28136c - j2 < this.minDurationToRetainAfterDiscardUs) {
            return size;
        }
        Format format = getFormat(determineIdealSelectedIndex(SystemClock.elapsedRealtime()));
        for (int i4 = 0; i4 < size; i4++) {
            v3 v3Var = list.get(i4);
            Format format2 = v3Var.f28134a;
            if (v3Var.f28135b - j2 >= this.minDurationToRetainAfterDiscardUs && format2.bitrate < format.bitrate && (i2 = format2.height) != -1 && i2 < 720 && (i3 = format2.width) != -1 && i3 < 1280 && i2 < format.height) {
                return i4;
            }
        }
        return size;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public Object getSelectionData() {
        return null;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.reason;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public void updateSelectedTrack(long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.selectedIndex;
        int determineIdealSelectedIndex = determineIdealSelectedIndex(elapsedRealtime);
        this.selectedIndex = determineIdealSelectedIndex;
        if (determineIdealSelectedIndex == i2) {
            return;
        }
        if (!isBlacklisted(i2, elapsedRealtime)) {
            Format format = getFormat(i2);
            int i3 = getFormat(this.selectedIndex).bitrate;
            int i4 = format.bitrate;
            if ((i3 > i4 && j2 < this.minDurationForQualityIncreaseUs) || (i3 < i4 && j2 >= this.maxDurationForQualityDecreaseUs)) {
                this.selectedIndex = i2;
            }
        }
        if (this.selectedIndex != i2) {
            this.reason = 3;
        }
    }
}
