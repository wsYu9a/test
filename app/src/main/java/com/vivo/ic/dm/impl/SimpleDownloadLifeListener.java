package com.vivo.ic.dm.impl;

import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.StopRequestException;
import com.vivo.ic.dm.network.IHttpDownload;

/* loaded from: classes4.dex */
public class SimpleDownloadLifeListener implements DownloadLifeListener {
    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onAfterRequest(DownloadInfo downloadInfo) throws StopRequestException {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onBeforeDownload(DownloadInfo downloadInfo) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onBeforeRequest(DownloadInfo downloadInfo) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadFailed(DownloadInfo downloadInfo, int i2) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadPaused(DownloadInfo downloadInfo, int i2) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadPausedByNetChange(long[] jArr) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadSizeChange(DownloadInfo downloadInfo, long j2, long j3, long j4) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadSpeedChange(DownloadInfo downloadInfo, long j2) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadStartByNetChange(long[] jArr) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadStatusChanged(DownloadInfo downloadInfo, int i2) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onDownloadSucceed(DownloadInfo downloadInfo, int i2) {
    }

    @Override // com.vivo.ic.dm.impl.DownloadLifeListener
    public void onRequestFailed(DownloadInfo downloadInfo, IHttpDownload iHttpDownload) throws StopRequestException {
    }
}
