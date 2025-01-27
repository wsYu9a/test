package com.vivo.ic.dm.impl;

import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.StopRequestException;
import com.vivo.ic.dm.network.IHttpDownload;

/* loaded from: classes4.dex */
public interface DownloadLifeListener {
    void onAfterRequest(DownloadInfo downloadInfo) throws StopRequestException;

    void onBeforeDownload(DownloadInfo downloadInfo) throws StopRequestException;

    void onBeforeRequest(DownloadInfo downloadInfo) throws StopRequestException;

    void onDownloadFailed(DownloadInfo downloadInfo, int i2);

    void onDownloadPaused(DownloadInfo downloadInfo, int i2);

    void onDownloadPausedByNetChange(long[] jArr);

    void onDownloadSizeChange(DownloadInfo downloadInfo, long j2, long j3, long j4);

    @Deprecated
    void onDownloadSpeedChange(DownloadInfo downloadInfo, long j2);

    void onDownloadStartByNetChange(long[] jArr);

    void onDownloadStatusChanged(DownloadInfo downloadInfo, int i2);

    void onDownloadSucceed(DownloadInfo downloadInfo, int i2);

    void onRequestFailed(DownloadInfo downloadInfo, IHttpDownload iHttpDownload) throws StopRequestException;
}
