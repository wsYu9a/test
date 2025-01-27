package com.vivo.google.android.exoplayer3.source;

import com.vivo.google.android.exoplayer3.s3;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class TrackGroupArray {
    public static final TrackGroupArray EMPTY = new TrackGroupArray(new s3[0]);
    public int hashCode;
    public final int length;
    public final s3[] trackGroups;

    public TrackGroupArray(s3... s3VarArr) {
        this.trackGroups = s3VarArr;
        this.length = s3VarArr.length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
        return this.length == trackGroupArray.length && Arrays.equals(this.trackGroups, trackGroupArray.trackGroups);
    }

    public s3 get(int i2) {
        return this.trackGroups[i2];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public int indexOf(s3 s3Var) {
        for (int i2 = 0; i2 < this.length; i2++) {
            if (this.trackGroups[i2] == s3Var) {
                return i2;
            }
        }
        return -1;
    }
}
