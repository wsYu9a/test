package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class m<R extends g, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private h<R, T> mListener = null;
    private final com.kwad.sdk.core.network.a.b mMonitorRecorder = com.kwad.sdk.core.network.a.c.wy();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.bd(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.kwai.e eVar;
        if (cVar == null || cVar.wb() || (eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)) == null || !ag.isNetworkConnected(eVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.AP();
    }

    private void notifyOnErrorListener(@NonNull R r, int i2, String str) {
        i.wf().b(r, i2);
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onError(r, i2, str);
        this.mMonitorRecorder.wx();
    }

    private void notifyOnErrorListener(@NonNull R r, c cVar, String str) {
        String url = r.getUrl();
        com.kwad.sdk.core.network.idc.a.wm().a(url, url.contains("/rest/zt/emoticon/package/list") ? "zt" : "api", new DomainException(cVar.agd, cVar.age));
        notifyOnErrorListener((m<R, T>) r, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onStartRequest(r);
    }

    private void notifyOnSuccess(@NonNull R r, T t) {
        h<R, T> hVar = this.mListener;
        if (hVar == null) {
            return;
        }
        hVar.onSuccess(r, t);
        this.mMonitorRecorder.wx();
    }

    private void onRequest(@NonNull h<R, T> hVar) {
        this.mMonitorRecorder.wr();
        this.mListener = hVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            r.wi().A(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void setMonitorRequestId(@NonNull g gVar) {
        Map<String, String> header = gVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.co(str);
        }
    }

    protected void afterParseData(T t) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    protected boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    protected void fetchImpl() {
        try {
            this.mMonitorRecorder.wv();
            R createRequest = createRequest();
            notifyOnStartRequest(createRequest);
            this.mMonitorRecorder.ck(createRequest.getUrl()).cl(createRequest.getUrl());
            setMonitorRequestId(createRequest);
            if (ag.isNetworkConnected(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext())) {
                c cVar = null;
                try {
                    String url = createRequest.getUrl();
                    AdHttpProxy rZ = com.kwad.sdk.b.rZ();
                    (rZ instanceof com.kwad.sdk.core.network.b.b ? this.mMonitorRecorder.cn("ok_http") : this.mMonitorRecorder.cn(HttpHost.DEFAULT_SCHEME_NAME)).wu();
                    cVar = isPostByJson() ? rZ.doPost(url, createRequest.getHeader(), createRequest.getBody()) : rZ.doPost(url, createRequest.getHeader(), createRequest.getBodyMap());
                } catch (Exception e2) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
                    this.mMonitorRecorder.cm("requestError:" + e2.getMessage());
                }
                this.mMonitorRecorder.ws().wt().bf(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(createRequest, cVar);
                } catch (Exception e3) {
                    this.mMonitorRecorder.cm("onResponseError:" + e3.getMessage());
                    com.kwad.sdk.core.d.b.printStackTraceOnly(e3);
                }
            } else {
                f fVar = f.agl;
                notifyOnErrorListener((m<R, T>) createRequest, fVar.errorCode, fVar.msg);
                this.mMonitorRecorder.bc(f.agl.errorCode).cm(f.agl.msg);
            }
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            try {
                try {
                    this.mMonitorRecorder.cm("requestError:" + th.getMessage());
                } catch (Throwable th2) {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused2) {
                    }
                    throw th2;
                }
            } catch (Exception unused3) {
            }
            com.kwad.sdk.core.d.b.printStackTrace(th);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused4) {
            }
        }
    }

    protected boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    protected void onResponse(R r, c cVar) {
        if (cVar == null) {
            f fVar = f.agl;
            notifyOnErrorListener((m<R, T>) r, fVar.errorCode, fVar.msg);
            this.mMonitorRecorder.cm("responseBase is null");
            com.kwad.sdk.core.d.b.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.bc(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.agf) || !cVar.wb()) {
            notifyOnErrorListener((m<R, T>) r, cVar, "网络错误");
            this.mMonitorRecorder.cm("httpCodeError:" + cVar.code + ":" + cVar.agf);
            StringBuilder sb = new StringBuilder("request responseBase httpCodeError:");
            sb.append(cVar.code);
            com.kwad.sdk.core.d.b.w(TAG, sb.toString());
            return;
        }
        try {
            parseCommonData(r.getUrl(), cVar.agf);
            T parseData = parseData(cVar.agf);
            afterParseData(parseData);
            if (cVar.agf != null) {
                this.mMonitorRecorder.L(r7.length()).ww().be(parseData.result);
            }
            if (!parseData.isResultOk()) {
                this.mMonitorRecorder.cm("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                if (parseData.notifyFailOnResultError()) {
                    notifyOnErrorListener((m<R, T>) r, parseData.result, parseData.errorMsg);
                    return;
                }
            }
            if (parseData.isDataEmpty()) {
                notifyOnErrorListener((m<R, T>) r, f.agn.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : f.agn.msg);
            } else {
                checkAndSetHasData(parseData);
                notifyOnSuccess(r, parseData);
            }
        } catch (Exception e2) {
            f fVar2 = f.agm;
            notifyOnErrorListener((m<R, T>) r, fVar2.errorCode, fVar2.msg);
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mMonitorRecorder.cm("parseDataError:" + e2.getMessage());
        }
    }

    @NonNull
    protected abstract T parseData(String str);

    public void request(@NonNull h<R, T> hVar) {
        onRequest(hVar);
        fetch();
    }
}
