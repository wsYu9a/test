package com.vivo.ic.dm.network;

import android.content.Context;
import com.vivo.ic.dm.DownloadInfo;
import com.vivo.ic.dm.StopRequestException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes4.dex */
public interface IHttpDownload {
    void addRequestHeaders();

    void addRequestProperty(String str, String str2);

    void attachDownloadInfo(Context context, DownloadInfo downloadInfo, String str, int i2);

    void close();

    int getExpectResponseCode();

    String getHeader(String str);

    int getResponseCode() throws IOException;

    InputStream openResponseEntity() throws IOException;

    void sendRequest() throws StopRequestException;

    void setRequestProperty(String str, String str2);
}
