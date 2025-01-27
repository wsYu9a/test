package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.components.offline.api.core.network.IOfflineCompoRequestListener;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.h;

/* loaded from: classes2.dex */
public class RequestListenerAdapter<R extends IOfflineCompoRequest, T extends CommonOfflineCompoResultData> implements h<RequestAdapter<R>, ResultDataAdapter<T>> {
    private final IOfflineCompoRequestListener<R, T> mRequestListener;

    public RequestListenerAdapter(IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener) {
        this.mRequestListener = iOfflineCompoRequestListener;
    }

    @Override // com.kwad.sdk.core.network.h
    public void onError(@NonNull RequestAdapter<R> requestAdapter, int i2, String str) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onError(requestAdapter.getOfflineCompoRequest(), i2, str);
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public void onStartRequest(@NonNull RequestAdapter<R> requestAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onStartRequest(requestAdapter.getOfflineCompoRequest());
        }
    }

    @Override // com.kwad.sdk.core.network.h
    public void onSuccess(@NonNull RequestAdapter<R> requestAdapter, @NonNull ResultDataAdapter<T> resultDataAdapter) {
        IOfflineCompoRequestListener<R, T> iOfflineCompoRequestListener = this.mRequestListener;
        if (iOfflineCompoRequestListener != null) {
            iOfflineCompoRequestListener.onSuccess(requestAdapter.getOfflineCompoRequest(), resultDataAdapter.getOfflineCompoResultData());
        }
    }
}
