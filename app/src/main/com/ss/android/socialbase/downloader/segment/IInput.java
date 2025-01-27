package com.ss.android.socialbase.downloader.segment;

import androidx.annotation.NonNull;

/* loaded from: classes4.dex */
public interface IInput {
    @NonNull
    Buffer read() throws StreamClosedException, InterruptedException;
}
