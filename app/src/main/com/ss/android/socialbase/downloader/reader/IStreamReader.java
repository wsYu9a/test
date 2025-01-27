package com.ss.android.socialbase.downloader.reader;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.segment.Buffer;
import java.io.IOException;

/* loaded from: classes4.dex */
public interface IStreamReader {
    void close();

    Buffer read() throws IOException, BaseException, InterruptedException;

    void recycle(Buffer buffer);
}
