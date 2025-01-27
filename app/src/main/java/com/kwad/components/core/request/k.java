package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes3.dex */
public interface k<T extends AdResultData> {
    @WorkerThread
    void b(@NonNull T t10);

    @WorkerThread
    void onError(int i10, String str);
}
