package com.martian.mibook.data;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/martian/mibook/data/VipStatusRetryInfo;", "", "()V", "vipStatusRetry", "", "getVipStatusRetry", "()Z", "setVipStatusRetry", "(Z)V", "vipStatusRetryEnableTime", "", "vipStatusRetryTimes", "", "getVipStatusRetryDelay", "setVipStatusRetryInfo", "", "retry", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VipStatusRetryInfo {
    private boolean vipStatusRetry;
    private long vipStatusRetryEnableTime;
    private int vipStatusRetryTimes;

    public static /* synthetic */ void setVipStatusRetryInfo$default(VipStatusRetryInfo vipStatusRetryInfo, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        vipStatusRetryInfo.setVipStatusRetryInfo(z10);
    }

    public final boolean getVipStatusRetry() {
        return this.vipStatusRetry;
    }

    public final long getVipStatusRetryDelay() {
        if (!this.vipStatusRetry || System.currentTimeMillis() < this.vipStatusRetryEnableTime) {
            return 0L;
        }
        int i10 = this.vipStatusRetryTimes;
        if (i10 < 10) {
            this.vipStatusRetryTimes = i10 + 1;
        } else {
            this.vipStatusRetryTimes = i10 * 2;
        }
        long j10 = this.vipStatusRetryTimes * 5000;
        this.vipStatusRetryEnableTime = System.currentTimeMillis() + j10;
        return j10;
    }

    public final void setVipStatusRetry(boolean z10) {
        this.vipStatusRetry = z10;
    }

    public final void setVipStatusRetryInfo(boolean retry) {
        this.vipStatusRetry = retry;
        this.vipStatusRetryTimes = 0;
        this.vipStatusRetryEnableTime = 0L;
    }
}
