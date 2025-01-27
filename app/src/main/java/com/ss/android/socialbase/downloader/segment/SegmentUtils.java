package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;
import java.util.List;

/* loaded from: classes4.dex */
public class SegmentUtils {
    public static long getDownloadedBytes(@NonNull List<Segment> list) {
        long j2;
        long j3;
        long j4 = 0;
        loop0: while (true) {
            j2 = -1;
            j3 = -1;
            for (Segment segment : list) {
                if (j2 == -1) {
                    if (segment.getDownloadBytes() > 0) {
                        j2 = segment.getStartOffset();
                        j3 = segment.getCurrentOffset();
                    }
                } else if (segment.getStartOffset() > j3) {
                    j4 += j3 - j2;
                    if (segment.getDownloadBytes() > 0) {
                        j2 = segment.getStartOffset();
                        j3 = segment.getCurrentOffset();
                    }
                } else if (segment.getCurrentOffset() > j3) {
                    j3 = segment.getCurrentOffset();
                }
            }
        }
        return (j2 < 0 || j3 <= j2) ? j4 : j4 + (j3 - j2);
    }

    public static long getFirstOffset(@NonNull List<Segment> list) {
        int size = list.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Segment segment = list.get(i2);
            if (segment.getStartOffset() > j2) {
                break;
            }
            if (segment.getCurrentOffsetRead() > j2) {
                j2 = segment.getCurrentOffsetRead();
            }
        }
        return j2;
    }
}
