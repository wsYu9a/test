package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;

/* loaded from: classes2.dex */
public abstract class p<R extends g, T extends BaseResultData> implements h<R, T> {
    @Override // com.kwad.sdk.core.network.h
    public void onError(@NonNull R r, int i2, String str) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onStartRequest(@NonNull R r) {
    }

    @Override // com.kwad.sdk.core.network.h
    public void onSuccess(@NonNull R r, @NonNull T t) {
    }
}
