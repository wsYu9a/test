package com.ss.android.socialbase.downloader.network;

import java.io.IOException;

/* loaded from: classes4.dex */
public interface IDownloadHeadHttpConnection {
    void cancel();

    int getResponseCode() throws IOException;

    String getResponseHeaderField(String str);
}
