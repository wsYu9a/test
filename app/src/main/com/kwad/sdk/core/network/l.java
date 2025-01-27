package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.idc.DomainException;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.bt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class l<R extends f, T extends BaseResultData> extends a<R> {
    private static final String TAG = "Networking";

    @Nullable
    private g<R, T> mListener = null;
    private final com.kwad.sdk.core.network.b.b mMonitorRecorder = com.kwad.sdk.core.network.b.c.FO();

    private void checkAndSetHasData(BaseResultData baseResultData) {
        if (baseResultData.hasData()) {
            this.mMonitorRecorder.dh(1);
        }
    }

    private void checkIpDirect(c cVar) {
        com.kwad.sdk.service.a.f fVar;
        if (cVar == null || cVar.Fr() || (fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)) == null || !al.isNetworkConnected(fVar.getContext())) {
            return;
        }
        com.kwad.sdk.ip.direct.a.Kx();
    }

    private String getHostTypeByUrl(@NonNull String str) {
        return str.contains("/rest/zt/emoticon/package/list") ? "zt" : "api";
    }

    private void notifyOnErrorListener(@NonNull R r10, c cVar, String str) {
        String url = r10.getUrl();
        DomainException domainException = new DomainException(cVar.azs, cVar.azt);
        com.kwad.sdk.core.network.idc.a.Fz().a(url, getHostTypeByUrl(url), domainException);
        notifyOnErrorListener((l<R, T>) r10, cVar.code, str);
    }

    private void notifyOnStartRequest(@NonNull R r10) {
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onStartRequest(r10);
    }

    private void notifyOnSuccess(@NonNull R r10, T t10) {
        if (com.kwad.sdk.core.network.idc.a.Fz().FB()) {
            String hostTypeByUrl = getHostTypeByUrl(r10.getUrl());
            if ("api".equals(hostTypeByUrl)) {
                com.kwad.sdk.core.network.idc.a.Fz().ed(hostTypeByUrl);
            }
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onSuccess(r10, t10);
        this.mMonitorRecorder.FN();
    }

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mMonitorRecorder.FH();
        this.mListener = gVar;
    }

    private void parseCommonData(String str, String str2) {
        try {
            q.Fv().U(str, new JSONObject(str2).optString("requestSessionData"));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
    }

    private void reportSdkCaughtException(Throwable th2) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th2);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th2);
        }
    }

    private void setMonitorRequestId(@NonNull f fVar) {
        Map<String, String> header = fVar.getHeader();
        if (header != null) {
            String str = header.get(d.TRACK_ID_KEY);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mMonitorRecorder.en(str);
        }
    }

    public void afterParseData(T t10) {
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public boolean enableCrashReport() {
        return true;
    }

    public boolean enableMonitorReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    @WorkerThread
    public void fetchImpl() {
        R r10;
        Throwable th2;
        c cVar = null;
        try {
            this.mMonitorRecorder.FL();
            r10 = createRequest();
        } catch (Throwable th3) {
            r10 = null;
            th2 = th3;
        }
        try {
            notifyOnStartRequest(r10);
            this.mMonitorRecorder.ej(r10.getUrl()).ek(r10.getUrl());
            setMonitorRequestId(r10);
            if (al.isNetworkConnected(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext())) {
                try {
                    String url = r10.getUrl();
                    AdHttpProxy zc2 = com.kwad.sdk.g.zc();
                    if (zc2 instanceof com.kwad.sdk.core.network.c.b) {
                        this.mMonitorRecorder.em("ok_http").FK();
                    } else {
                        this.mMonitorRecorder.em("http").FK();
                    }
                    cVar = isPostByJson() ? zc2.doPost(url, r10.getHeader(), r10.getBody()) : zc2.doPost(url, r10.getHeader(), r10.getBodyMap());
                    com.kwad.sdk.core.d.c.i(TAG, "url: " + url + ", response: " + cVar);
                } catch (Exception e10) {
                    notifyOnErrorListener((l<R, T>) r10, e.azF.errorCode, bt.t(e10));
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
                    this.mMonitorRecorder.el("requestError:" + e10.getMessage());
                }
                this.mMonitorRecorder.FI().FJ().dj(com.kwad.sdk.ip.direct.a.getType());
                try {
                    onResponse(r10, cVar);
                } catch (Exception e11) {
                    notifyOnErrorListener((l<R, T>) r10, e.azF.errorCode, bt.t(e11));
                    this.mMonitorRecorder.el("onResponseError:" + e11.getMessage());
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e11);
                }
            } else {
                e eVar = e.azy;
                notifyOnErrorListener((l<R, T>) r10, eVar.errorCode, eVar.msg);
                this.mMonitorRecorder.dg(e.azy.errorCode).el(e.azy.msg);
            }
        } catch (Throwable th4) {
            th2 = th4;
            try {
                try {
                    this.mMonitorRecorder.el("requestError:" + th2.getMessage());
                } finally {
                    try {
                        if (enableMonitorReport()) {
                            this.mMonitorRecorder.report();
                        }
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
            }
            notifyOnErrorListener((l<R, T>) r10, e.azF.errorCode, bt.t(th2));
            com.kwad.sdk.core.d.c.printStackTrace(th2);
            try {
                if (enableMonitorReport()) {
                    this.mMonitorRecorder.report();
                }
            } catch (Exception unused3) {
            }
        }
    }

    public boolean isPostByJson() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r10, c cVar) {
        if (cVar == null) {
            e eVar = e.azy;
            notifyOnErrorListener((l<R, T>) r10, eVar.errorCode, eVar.msg);
            this.mMonitorRecorder.el("responseBase is null");
            com.kwad.sdk.core.d.c.e(TAG, "request responseBase is null");
            return;
        }
        this.mMonitorRecorder.dg(cVar.code);
        checkIpDirect(cVar);
        if (TextUtils.isEmpty(cVar.azu) || !cVar.Fr()) {
            notifyOnErrorListener((l<R, T>) r10, cVar, "网络错误");
            this.mMonitorRecorder.el("httpCodeError:" + cVar.code + ":" + cVar.azu);
            StringBuilder sb2 = new StringBuilder("request responseBase httpCodeError:");
            sb2.append(cVar.code);
            com.kwad.sdk.core.d.c.w(TAG, sb2.toString());
            return;
        }
        try {
            parseCommonData(r10.getUrl(), cVar.azu);
            T parseData = parseData(cVar.azu);
            afterParseData(parseData);
            if (cVar.azu != null) {
                this.mMonitorRecorder.at(r7.length()).FM().di(parseData.result);
            }
            if (!parseData.isResultOk()) {
                this.mMonitorRecorder.el("serverCodeError:" + parseData.result + ":" + parseData.errorMsg);
                if (parseData.notifyFailOnResultError()) {
                    notifyOnErrorListener((l<R, T>) r10, parseData.result, parseData.errorMsg);
                    return;
                }
            }
            if (parseData.isDataEmpty()) {
                notifyOnErrorListener((l<R, T>) r10, e.azA.errorCode, !TextUtils.isEmpty(parseData.testErrorMsg) ? parseData.testErrorMsg : e.azA.msg);
            } else {
                checkAndSetHasData(parseData);
                notifyOnSuccess(r10, parseData);
            }
        } catch (Exception e10) {
            e eVar2 = e.azz;
            notifyOnErrorListener((l<R, T>) r10, eVar2.errorCode, eVar2.msg);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            this.mMonitorRecorder.el("parseDataError:" + e10.getMessage());
        }
    }

    @NonNull
    public abstract T parseData(String str);

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th2) {
            notifyOnErrorListener((l<R, T>) null, e.azF.errorCode, bt.t(th2));
            reportSdkCaughtException(th2);
        }
    }

    private void notifyOnErrorListener(@NonNull R r10, int i10, String str) {
        try {
            h.Fs().b(r10, i10);
        } catch (Throwable th2) {
            reportSdkCaughtException(th2);
        }
        g<R, T> gVar = this.mListener;
        if (gVar == null) {
            return;
        }
        gVar.onError(r10, i10, str);
        this.mMonitorRecorder.FN();
    }
}
