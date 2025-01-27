package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bm;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class al implements com.kwad.sdk.core.webview.c.a {
    private final com.kwad.sdk.core.webview.b YR;
    private int aae = 0;
    private a aaf;

    public interface a {
        void onAdShow();
    }

    public static final class b extends com.kwad.sdk.core.report.a implements com.kwad.sdk.core.b {
        private String Li;
        private String MI;
        private int aag;
        private int actionType;
        private AdTemplate adTemplate;

        public final int getActionType() {
            return this.actionType;
        }

        public final String nB() {
            return this.Li;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.actionType = jSONObject.optInt("actionType");
            this.aag = jSONObject.optInt("refreshType");
            this.MI = jSONObject.optString("payload");
            this.Li = jSONObject.optString("creativeId");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
            if (this.adTemplate == null && jSONObject.has("adCacheId")) {
                this.adTemplate = com.kwad.sdk.core.response.b.c.a(com.kwad.components.core.n.a.d.a.a.au(jSONObject.optInt("adCacheId")), this.Li);
            }
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "actionType", this.actionType);
            com.kwad.sdk.utils.x.putValue(jSONObject, "payload", this.MI);
            com.kwad.sdk.utils.x.putValue(jSONObject, "refreshType", this.aag);
            com.kwad.sdk.utils.x.a(jSONObject, "adTemplate", this.adTemplate);
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", this.Li);
            return jSONObject;
        }

        public final String ts() {
            return this.MI;
        }
    }

    public al(com.kwad.sdk.core.webview.b bVar) {
        this.YR = bVar;
    }

    private AdTemplate c(@NonNull b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.YR.dg(bVar.Li);
    }

    public void a(com.kwad.sdk.core.adlog.c.b bVar) {
    }

    public void b(boolean z10, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        com.kwad.components.core.s.b.sc().a(adTemplate, null, bVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public final void a(a aVar) {
        this.aaf = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            if (c(bVar) == null) {
                cVar.onError(-1, "native adTemplate is null");
            }
            a(bVar);
            cVar.a(null);
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            cVar.onError(-1, e10.getMessage());
        }
    }

    @SuppressLint({"SwitchIntDef"})
    public void a(@NonNull b bVar) {
        com.kwad.sdk.core.d.c.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.actionType);
        if (bVar.actionType == 1) {
            com.kwad.sdk.core.adlog.c.b m35do = new com.kwad.sdk.core.adlog.c.b().m35do(bVar.MI);
            a aVar = this.aaf;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate != null) {
                m35do.cP(this.aae);
                b(true, bVar.adTemplate, null, m35do);
                return;
            } else {
                if (bm.isNullString(bVar.nB())) {
                    b(true, this.YR.getAdTemplate(), null, m35do);
                    return;
                }
                for (AdTemplate adTemplate : this.YR.IB()) {
                    if (bm.isEquals(bVar.nB(), String.valueOf(com.kwad.sdk.core.response.b.e.el(adTemplate)))) {
                        b(false, adTemplate, null, m35do);
                        return;
                    }
                }
                return;
            }
        }
        if (bVar.actionType != 2) {
            if (bVar.actionType == 12006) {
                com.kwad.components.core.o.a.ri().c(c(bVar), bVar.aag, this.aae);
                return;
            }
            if (bVar.actionType != 140) {
                if (bVar.actionType == 141) {
                    com.kwad.sdk.core.adlog.c.e(c(bVar), this.YR.mReportExtData, new com.kwad.sdk.core.adlog.c.b().m35do(bVar.MI));
                    return;
                } else {
                    com.kwad.sdk.core.adlog.c.a(c(bVar), bVar.actionType, this.YR.mReportExtData, bVar.MI);
                    com.kwad.components.core.webview.tachikoma.d.a.uf().bb(bVar.MI);
                    return;
                }
            }
            com.kwad.sdk.core.adlog.c.d(c(bVar), this.YR.mReportExtData, new com.kwad.sdk.core.adlog.c.b().m35do(bVar.MI));
            return;
        }
        com.kwad.sdk.widget.e eVar = this.YR.aIc;
        com.kwad.sdk.core.adlog.c.b m35do2 = new com.kwad.sdk.core.adlog.c.b().cP(this.aae).m35do(bVar.MI);
        if (eVar != null) {
            m35do2.f(eVar.getTouchCoords());
        }
        a(m35do2);
        com.kwad.sdk.core.adlog.c.a(c(bVar), m35do2, this.YR.mReportExtData);
    }
}
