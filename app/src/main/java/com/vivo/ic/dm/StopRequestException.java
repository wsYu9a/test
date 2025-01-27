package com.vivo.ic.dm;

import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class StopRequestException extends Exception {

    /* renamed from: a */
    private static final long f28395a = -538399264924068849L;

    /* renamed from: b */
    private final int f28396b;

    public StopRequestException(int i2, String str) {
        super(str);
        this.f28396b = i2;
    }

    public static StopRequestException a(int i2, String str) throws StopRequestException {
        String str2 = "Unhandled HTTP response: " + i2 + " " + str;
        if (i2 >= 400 && i2 < 600) {
            throw new StopRequestException(i2, str2);
        }
        if (i2 < 300 || i2 >= 400) {
            throw new StopRequestException(Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE, str2);
        }
        throw new StopRequestException(493, str2);
    }

    public StopRequestException(int i2, Throwable th) {
        this(i2, th.getMessage());
        initCause(th);
    }

    public StopRequestException(int i2, String str, Throwable th) {
        this(i2, str);
        initCause(th);
    }

    public static int a(int i2) {
        if (Downloads.Impl.isStatusError(i2)) {
            return i2;
        }
        if (i2 < 300 || i2 >= 400) {
            return Downloads.Impl.STATUS_UNHANDLED_HTTP_CODE;
        }
        return 493;
    }

    public static int a(DownloadInfo downloadInfo) {
        DownloadInfo.NetworkState checkCanUseNetwork = downloadInfo.checkCanUseNetwork();
        if (checkCanUseNetwork != DownloadInfo.NetworkState.OK) {
            if (checkCanUseNetwork == DownloadInfo.NetworkState.MOBILE) {
                return 196;
            }
            return Downloads.Impl.STATUS_WAITING_FOR_NETWORK;
        }
        if (downloadInfo.getNumFailed() >= 30) {
            return Downloads.Impl.STATUS_HTTP_DATA_ERROR;
        }
        downloadInfo.setRecomNetType(0);
        return Downloads.Impl.STATUS_WAITING_TO_RETRY;
    }

    public int a() {
        return this.f28396b;
    }
}
