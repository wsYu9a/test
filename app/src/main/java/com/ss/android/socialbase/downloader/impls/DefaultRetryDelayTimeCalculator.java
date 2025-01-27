package com.ss.android.socialbase.downloader.impls;

import com.alipay.mobilesecuritysdk.constant.a;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;

/* loaded from: classes4.dex */
public class DefaultRetryDelayTimeCalculator implements IRetryDelayTimeCalculator {
    @Override // com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator
    public long calculateRetryDelayTime(int i2, int i3) {
        if (i2 == 1) {
            return 3000L;
        }
        if (i2 == 2) {
            return 15000L;
        }
        if (i2 == 3) {
            return 30000L;
        }
        if (i2 > 3) {
            return a.k;
        }
        return 0L;
    }
}
