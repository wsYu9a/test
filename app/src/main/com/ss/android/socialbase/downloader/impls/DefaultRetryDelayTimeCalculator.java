package com.ss.android.socialbase.downloader.impls;

import androidx.media3.common.C;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: classes4.dex */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i10, int i11) {
        if (i10 == 1) {
            return 3000L;
        }
        if (i10 == 2) {
            return C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        }
        if (i10 == 3) {
            return 30000L;
        }
        return i10 > 3 ? 300000L : 0L;
    }
}
