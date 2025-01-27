package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.ReportResultData;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class x extends com.kwad.sdk.core.network.a<y> {
    private ReportResultData ajU;

    @NonNull
    private ReportResultData a(com.kwad.sdk.core.network.c cVar) {
        if (this.ajU == null) {
            this.ajU = new ReportResultData() { // from class: com.kwad.sdk.core.report.ReportNetwork$1
                @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
                public void parseJson(@Nullable JSONObject jSONObject) {
                    super.parseJson(jSONObject);
                }
            };
        }
        if (cVar != null) {
            try {
                this.ajU.parseJson(new JSONObject(cVar.agf));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.ajU;
    }

    private void a(y yVar) {
        try {
            List<String> xm = yVar.xm();
            for (String str : xm) {
                com.kwad.sdk.core.network.c doGetWithoutResponse = com.kwad.sdk.b.rZ().doGetWithoutResponse(str, null);
                if (!isValidUrl(str) || doGetWithoutResponse.code != 200) {
                    KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_track").J("trackUrlError", str).aF(yVar.getAdTemplate()).report();
                }
            }
            a(yVar.getAdTemplate(), xm);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static void a(@NonNull AdTemplate adTemplate, List<String> list) {
        if (adTemplate.mTrackUrlReported || list == null || list.isEmpty()) {
            return;
        }
        adTemplate.mTrackUrlReported = true;
        q qVar = new q(10217L, adTemplate);
        qVar.ajx = com.kwad.sdk.utils.t.toJsonArray(list);
        h.a2(qVar);
    }

    private static void a(String str, int i2, AdTemplate adTemplate, @NonNull com.kwad.sdk.core.network.c cVar) {
        if (TextUtils.isEmpty(str) || str.contains(" ") || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || cVar.code != 200) {
            KSLoggerReporter.ReportClient.RESPONE_MONITOR.buildNormalApmReporter().cC("response_biz_error_track").J(i2 == 1 ? "showUrlError" : i2 == 2 ? "clickUrlError" : "convertUrlError", str).aF(adTemplate).report();
        }
    }

    private static boolean isValidUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URI uri = new URI(str);
            if (uri.getHost() == null) {
                return false;
            }
            return uri.getScheme().equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) || uri.getScheme().equalsIgnoreCase(b.b.a.b.b.f4198a);
        } catch (URISyntaxException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void fetch() {
        super.fetch();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0074  */
    @Override // com.kwad.sdk.core.network.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void fetchImpl() {
        /*
            r6 = this;
            java.lang.Class<com.kwad.sdk.service.kwai.e> r0 = com.kwad.sdk.service.kwai.e.class
            java.lang.Object r0 = com.kwad.sdk.service.ServiceProvider.get(r0)
            com.kwad.sdk.service.kwai.e r0 = (com.kwad.sdk.service.kwai.e) r0
            android.content.Context r0 = r0.getContext()
            boolean r0 = com.kwad.sdk.utils.ag.isNetworkConnected(r0)
            java.lang.String r1 = "ReportNetwork"
            if (r0 != 0) goto L1a
            java.lang.String r0 = "no network while report log"
            com.kwad.sdk.core.d.b.w(r1, r0)
            return
        L1a:
            com.kwad.sdk.core.network.g r0 = r6.createRequest()
            com.kwad.sdk.core.report.y r0 = (com.kwad.sdk.core.report.y) r0
            r2 = 0
            java.lang.String r3 = r0.getUrl()     // Catch: java.lang.Exception -> L52
            com.kwad.sdk.export.proxy.AdHttpProxy r4 = com.kwad.sdk.b.rZ()     // Catch: java.lang.Exception -> L50
            org.json.JSONObject r5 = r0.getBody()     // Catch: java.lang.Exception -> L50
            com.kwad.sdk.core.network.c r2 = r4.doPost(r3, r2, r5)     // Catch: java.lang.Exception -> L50
            if (r2 == 0) goto L4d
            int r4 = r2.code     // Catch: java.lang.Exception -> L50
            r5 = 200(0xc8, float:2.8E-43)
            if (r4 != r5) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
            java.lang.String r5 = "report success actionType:"
            r4.<init>(r5)     // Catch: java.lang.Exception -> L50
            int r5 = r0.ajV     // Catch: java.lang.Exception -> L50
            r4.append(r5)     // Catch: java.lang.Exception -> L50
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L50
        L49:
            com.kwad.sdk.core.d.b.d(r1, r4)     // Catch: java.lang.Exception -> L50
            goto L57
        L4d:
            java.lang.String r4 = "report fail result is null"
            goto L49
        L50:
            r1 = move-exception
            goto L54
        L52:
            r1 = move-exception
            r3 = r2
        L54:
            com.kwad.sdk.core.d.b.printStackTrace(r1)
        L57:
            com.kwad.sdk.core.response.model.ReportResultData r1 = r6.a(r2)
            boolean r4 = r1.isCheatingFlow()
            if (r4 == 0) goto L6c
            com.kwad.sdk.core.response.model.AdTemplate r4 = r0.getAdTemplate()
            boolean r5 = r1.isCheatingFlow()
            r4.setCheatingFlow(r5)
        L6c:
            com.kwad.sdk.core.response.model.AdTemplate r4 = r0.getAdTemplate()
            boolean r4 = r4.mCheatingFlow
            if (r4 != 0) goto L77
            r6.a(r0)
        L77:
            int r4 = r0.getActionType()
            com.kwad.sdk.core.response.model.AdTemplate r0 = r0.getAdTemplate()
            a(r3, r4, r0, r2)
            java.lang.Boolean r0 = com.kwad.b.kwai.a.bI
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Lb9
            boolean r0 = r1.isResultOk()
            if (r0 == 0) goto L91
            goto Lb9
        L91:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "请求返回失败 code:"
            r2.<init>(r4)
            int r4 = r1.result
            r2.append(r4)
            java.lang.String r4 = ", errorMsg:"
            r2.append(r4)
            java.lang.String r1 = r1.errorMsg
            r2.append(r1)
            java.lang.String r1 = "\n url="
            r2.append(r1)
            r2.append(r3)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        Lb9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.report.x.fetchImpl():void");
    }

    @Override // com.kwad.sdk.core.network.a
    public /* bridge */ /* synthetic */ void onResponse(y yVar, com.kwad.sdk.core.network.c cVar) {
    }
}
