package com.ss.android.socialbase.downloader.network;

import com.ss.android.socialbase.downloader.model.HttpHeader;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public interface IDownloadHeadHttpService {
    IDownloadHeadHttpConnection downloadWithConnection(String str, List<HttpHeader> list) throws IOException;
}
