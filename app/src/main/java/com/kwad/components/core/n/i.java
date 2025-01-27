package com.kwad.components.core.n;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.response.model.AdResultData;

/* loaded from: classes2.dex */
public interface i<T extends AdResultData> {
    @WorkerThread
    void a(@NonNull T t);

    @WorkerThread
    void onError(int i2, String str);
}
