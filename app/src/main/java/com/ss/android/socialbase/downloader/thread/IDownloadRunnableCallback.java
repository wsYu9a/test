package com.ss.android.socialbase.downloader.thread;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.RetryCheckStatus;
import com.ss.android.socialbase.downloader.exception.RetryThrowable;
import com.ss.android.socialbase.downloader.model.DownloadChunk;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;

/* loaded from: classes4.dex */
public interface IDownloadRunnableCallback {
    boolean canRetry(BaseException baseException);

    void checkSpaceOverflow(long j2) throws BaseException;

    DownloadChunk getUnCompletedSubChunk(int i2);

    void handleFirstConnection(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, long j2) throws BaseException, RetryThrowable;

    void onAllChunkRetryWithReset(BaseException baseException, boolean z);

    void onChunkDowngradeRetry(BaseException baseException);

    void onCompleted(DownloadChunkRunnable downloadChunkRunnable);

    void onError(BaseException baseException);

    boolean onProgress(long j2) throws BaseException;

    RetryCheckStatus onRetry(BaseException baseException, long j2);

    RetryCheckStatus onSingleChunkRetry(DownloadChunk downloadChunk, BaseException baseException, long j2);

    void setHttpResponseStatus(IDownloadHeadHttpConnection iDownloadHeadHttpConnection);
}
