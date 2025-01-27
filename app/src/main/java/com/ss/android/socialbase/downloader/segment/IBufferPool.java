package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public interface IBufferPool {
    @NonNull
    Buffer obtain() throws StreamClosedException, InterruptedException;

    void recycle(@NonNull Buffer buffer);
}
