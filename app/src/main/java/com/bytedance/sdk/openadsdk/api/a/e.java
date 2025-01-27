package com.bytedance.sdk.openadsdk.api.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;

/* loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.api.b implements DownloadStatusChangeListener {
    public e(EventListener eventListener) {
        this.f8037a = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i10) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i10).b()).b());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).b()).b());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).b()).b());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i10) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i10).b()).b());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new c(downloadModel)).a(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new a(downloadController)).b()).b());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, a() ? null : com.bykv.a.a.a.a.a.a().a(com.bykv.a.a.a.a.b.a().a(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new d(downloadShortInfo)).b()).b());
    }
}
