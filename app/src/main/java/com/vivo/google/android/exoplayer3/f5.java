package com.vivo.google.android.exoplayer3;

import android.os.SystemClock;
import com.vivo.google.android.exoplayer3.trackselection.TrackSelection;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class f5 implements TrackSelection {
    public final long[] blacklistUntilTimes;
    public final Format[] formats;
    public final s3 group;
    public int hashCode;
    public final int length;
    public final int[] tracks;

    public static final class b implements Comparator<Format> {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(Format format, Format format2) {
            return format2.bitrate - format.bitrate;
        }
    }

    public f5(s3 s3Var, int... iArr) {
        int i2 = 0;
        g1.b(iArr.length > 0);
        this.group = (s3) g1.a(s3Var);
        int length = iArr.length;
        this.length = length;
        this.formats = new Format[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.formats[i3] = s3Var.a(iArr[i3]);
        }
        Arrays.sort(this.formats, new b());
        this.tracks = new int[this.length];
        while (true) {
            int i4 = this.length;
            if (i2 >= i4) {
                this.blacklistUntilTimes = new long[i4];
                return;
            } else {
                this.tracks[i2] = s3Var.a(this.formats[i2]);
                i2++;
            }
        }
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final boolean blacklist(int i2, long j2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean isBlacklisted = isBlacklisted(i2, elapsedRealtime);
        int i3 = 0;
        while (i3 < this.length && !isBlacklisted) {
            isBlacklisted = (i3 == i2 || isBlacklisted(i3, elapsedRealtime)) ? false : true;
            i3++;
        }
        if (!isBlacklisted) {
            return false;
        }
        long[] jArr = this.blacklistUntilTimes;
        jArr[i2] = Math.max(jArr[i2], elapsedRealtime + j2);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f5 f5Var = (f5) obj;
        return this.group == f5Var.group && Arrays.equals(this.tracks, f5Var.tracks);
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int evaluateQueueSize(long j2, List<? extends v3> list) {
        return list.size();
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final Format getFormat(int i2) {
        return this.formats[i2];
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final int getIndexInTrackGroup(int i2) {
        return this.tracks[i2];
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final Format getSelectedFormat() {
        return this.formats[getSelectedIndex()];
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final int getSelectedIndexInTrackGroup() {
        return this.tracks[getSelectedIndex()];
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final s3 getTrackGroup() {
        return this.group;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = (System.identityHashCode(this.group) * 31) + Arrays.hashCode(this.tracks);
        }
        return this.hashCode;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final int indexOf(int i2) {
        for (int i3 = 0; i3 < this.length; i3++) {
            if (this.tracks[i3] == i2) {
                return i3;
            }
        }
        return -1;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final int indexOf(Format format) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.formats[i2] == format) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean isBlacklisted(int i2, long j2) {
        return this.blacklistUntilTimes[i2] > j2;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public final int length() {
        return this.tracks.length;
    }
}
