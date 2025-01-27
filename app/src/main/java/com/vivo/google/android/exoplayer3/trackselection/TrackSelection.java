package com.vivo.google.android.exoplayer3.trackselection;

import com.vivo.google.android.exoplayer3.Format;
import com.vivo.google.android.exoplayer3.s3;
import com.vivo.google.android.exoplayer3.v3;
import java.util.List;

/* loaded from: classes4.dex */
public interface TrackSelection {

    public interface Factory {
        TrackSelection createTrackSelection(s3 s3Var, int... iArr);
    }

    boolean blacklist(int i2, long j2);

    int evaluateQueueSize(long j2, List<? extends v3> list);

    Format getFormat(int i2);

    int getIndexInTrackGroup(int i2);

    Format getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    Object getSelectionData();

    int getSelectionReason();

    s3 getTrackGroup();

    int indexOf(int i2);

    int indexOf(Format format);

    int length();

    void updateSelectedTrack(long j2);
}
