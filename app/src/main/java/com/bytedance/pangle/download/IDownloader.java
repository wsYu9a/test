package com.bytedance.pangle.download;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: classes2.dex */
public interface IDownloader {
    void downloader(Context context, String str, String str2, boolean z10, String str3, int i10, String str4, List<String> list, IZeusDownloadListener iZeusDownloadListener, IZeusDownloadInterceptor iZeusDownloadInterceptor);
}
