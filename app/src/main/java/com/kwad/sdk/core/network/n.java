package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.o;

/* loaded from: classes2.dex */
public abstract class n<R extends o, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private h<R, T> mListener = null;

    private void onRequest(@NonNull h<R, T> hVar) {
        this.mListener = hVar;
    }

    @Override // com.kwad.sdk.core.network.a
    protected void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    protected void fetchImpl() {
        String str;
        o oVar = (o) createRequest();
        c cVar = null;
        try {
            String url = oVar.getUrl();
            cVar = oVar.getMethod().equals("POST") ? com.kwad.sdk.b.rZ().doPost(url, oVar.getHeader(), oVar.getBody()) : com.kwad.sdk.b.rZ().doGet(url, oVar.getHeader());
            if (cVar == null || cVar.code != 200) {
                str = "normal request failed";
            } else {
                str = "normal request success:" + cVar.code;
            }
            com.kwad.sdk.core.d.b.d(TAG, str);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            if (cVar == null) {
                cVar = new c();
            }
            cVar.code = -1;
            cVar.age = e2;
        }
        onResponse((n<R, T>) oVar, cVar);
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.wb()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r, createResponseData);
        } else {
            h<R, T> hVar = this.mListener;
            int i2 = cVar.code;
            Exception exc = cVar.age;
            hVar.onError(r, i2, exc != null ? exc.getMessage() : "");
        }
    }

    protected void parseResponse(T t, c cVar) {
        t.parseResponse(cVar);
    }

    public void request(@NonNull h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
