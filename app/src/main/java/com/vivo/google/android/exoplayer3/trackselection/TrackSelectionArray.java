package com.vivo.google.android.exoplayer3.trackselection;

import java.util.Arrays;

/* loaded from: classes4.dex */
public final class TrackSelectionArray {
    public int hashCode;
    public final int length;
    public final TrackSelection[] trackSelections;

    public TrackSelectionArray(TrackSelection... trackSelectionArr) {
        this.trackSelections = trackSelectionArr;
        this.length = trackSelectionArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionArray.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.trackSelections, ((TrackSelectionArray) obj).trackSelections);
    }

    public TrackSelection get(int i2) {
        return this.trackSelections[i2];
    }

    public TrackSelection[] getAll() {
        return (TrackSelection[]) this.trackSelections.clone();
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackSelections) + 527;
        }
        return this.hashCode;
    }
}
