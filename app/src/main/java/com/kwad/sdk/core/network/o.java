package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* loaded from: classes3.dex */
public abstract class o<R extends f, T extends BaseResultData> implements g<R, T> {
    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull R r10, int i10, String str) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull R r10) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull R r10, @NonNull T t10) {
    }
}
