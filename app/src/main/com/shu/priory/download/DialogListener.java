package com.shu.priory.download;

import com.shu.priory.bean.DownloadDialogInfo;

/* loaded from: classes3.dex */
public interface DialogListener {
    void onCancel();

    void onConfirm();

    void onDownloading();

    boolean onShowDownloadDialog(DownloadDialogInfo downloadDialogInfo, DownLoadDialogCallback downLoadDialogCallback);
}
