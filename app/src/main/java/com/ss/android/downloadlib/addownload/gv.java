package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* loaded from: classes4.dex */
public interface gv {
    long g();

    gv j(long j2);

    gv j(IDownloadButtonClickListener iDownloadButtonClickListener);

    gv j(OnItemClickListener onItemClickListener);

    void j();

    void j(boolean z);

    boolean j(int i2);

    void y();

    gv zx(int i2, DownloadStatusChangeListener downloadStatusChangeListener);

    gv zx(Context context);

    gv zx(DownloadController downloadController);

    gv zx(DownloadEventConfig downloadEventConfig);

    gv zx(DownloadModel downloadModel);

    void zx(int i2);

    boolean zx();
}
