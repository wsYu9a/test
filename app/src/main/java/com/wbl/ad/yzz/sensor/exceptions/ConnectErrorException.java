package com.wbl.ad.yzz.sensor.exceptions;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class ConnectErrorException extends Exception {
    private int mRetryAfter;

    public ConnectErrorException(String str) {
        super(str);
        this.mRetryAfter = 30000;
    }

    public int getRetryAfter() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10701, this, null);
    }

    public ConnectErrorException(String str, String str2) {
        super(str);
        try {
            this.mRetryAfter = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            this.mRetryAfter = 0;
        }
    }

    public ConnectErrorException(Throwable th) {
        super(th);
    }
}
