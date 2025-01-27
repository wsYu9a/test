package com.ss.android.download.api.download.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public interface j {
    void j(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void j(@NonNull DownloadInfo downloadInfo);

    void j(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void j(@NonNull DownloadInfo downloadInfo, String str);

    void zx(@Nullable DownloadInfo downloadInfo, String str);
}
