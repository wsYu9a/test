package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bt;

/* loaded from: classes3.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private g<R, T> mListener = null;

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        c cVar;
        n nVar = (n) createRequest();
        try {
            String url = nVar.getUrl();
            cVar = nVar.getMethod().equals("POST") ? com.kwad.sdk.g.zc().doPost(url, nVar.getHeader(), nVar.getBody()) : com.kwad.sdk.g.zc().doGet(url, nVar.getHeader());
            if (cVar == null || cVar.code != 200) {
                com.kwad.sdk.core.d.c.d(TAG, "normal request failed");
            } else {
                com.kwad.sdk.core.d.c.d(TAG, "normal request success:" + cVar.code);
            }
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            cVar = 0 == 0 ? new c() : null;
            cVar.code = -1;
            cVar.azt = e10;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    public void parseResponse(T t10, c cVar) {
        t10.parseResponse(cVar);
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th2) {
            gVar.onError(null, e.azF.errorCode, bt.t(th2));
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r10, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.Fr()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r10, createResponseData);
        } else {
            g<R, T> gVar = this.mListener;
            int i10 = cVar.code;
            Exception exc = cVar.azt;
            gVar.onError(r10, i10, exc != null ? exc.getMessage() : "");
        }
    }
}
