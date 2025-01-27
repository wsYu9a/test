package com.kwad.components.core.webview.jshandler;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.opos.mobad.activity.VideoActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ac implements com.kwad.sdk.core.webview.b.a {
    private int Tq = 0;
    private a kq;
    private final com.kwad.sdk.core.webview.b mBridgeContext;

    public interface a {
        void onAdShow();
    }

    public static final class b implements com.kwad.sdk.core.b {
        private int Tr;
        private String Ts;
        private int Tt;
        private AdTemplate adTemplate;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Tr = jSONObject.optInt(VideoActivity.EXTRA_KEY_ACTION_TYPE);
            this.Tt = jSONObject.optInt("refreshType");
            this.Ts = jSONObject.optString("payload");
            try {
                if (jSONObject.has("adTemplate")) {
                    String string = jSONObject.getString("adTemplate");
                    if (this.adTemplate == null) {
                        this.adTemplate = new AdTemplate();
                    }
                    this.adTemplate.parseJson(new JSONObject(string));
                }
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, VideoActivity.EXTRA_KEY_ACTION_TYPE, this.Tr);
            com.kwad.sdk.utils.t.putValue(jSONObject, "payload", this.Ts);
            com.kwad.sdk.utils.t.putValue(jSONObject, "refreshType", this.Tt);
            com.kwad.sdk.utils.t.a(jSONObject, "adTemplate", this.adTemplate);
            return jSONObject;
        }
    }

    public ac(com.kwad.sdk.core.webview.b bVar) {
        this.mBridgeContext = bVar;
    }

    @SuppressLint({"SwitchIntDef"})
    private void a(@NonNull b bVar) {
        com.kwad.sdk.core.d.b.d("WebCardLogHandler", "handleH5Log actionType actionType" + bVar.Tr);
        if (bVar.Tr == 1) {
            com.kwad.sdk.core.report.i cy = new com.kwad.sdk.core.report.i().cy(bVar.Ts);
            a aVar = this.kq;
            if (aVar != null) {
                aVar.onAdShow();
            }
            if (bVar.adTemplate == null) {
                com.kwad.components.core.r.b.pK().a(this.mBridgeContext.getAdTemplate(), null, cy);
                return;
            } else {
                cy.bm(this.Tq);
                com.kwad.components.core.r.b.pK().a(bVar.adTemplate, null, cy);
                return;
            }
        }
        if (bVar.Tr != 2) {
            if (bVar.Tr == 12006) {
                com.kwad.components.core.m.a.pb().a(b(bVar), bVar.Tt, this.Tq);
                return;
            } else {
                com.kwad.sdk.core.report.a.a(b(bVar), bVar.Tr, this.mBridgeContext.mReportExtData, bVar.Ts);
                return;
            }
        }
        com.kwad.sdk.widget.e eVar = this.mBridgeContext.app;
        com.kwad.sdk.core.report.i cy2 = new com.kwad.sdk.core.report.i().bm(this.Tq).cy(bVar.Ts);
        if (eVar != null) {
            cy2.c(eVar.getTouchCoords());
        }
        a(cy2);
        com.kwad.sdk.core.report.a.a(b(bVar), cy2, this.mBridgeContext.mReportExtData);
    }

    private AdTemplate b(@NonNull b bVar) {
        return bVar.adTemplate != null ? bVar.adTemplate : this.mBridgeContext.getAdTemplate();
    }

    public final void a(a aVar) {
        this.kq = aVar;
    }

    protected void a(com.kwad.sdk.core.report.i iVar) {
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public String getKey() {
        return "log";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.mBridgeContext.yU()) {
            cVar.onError(-1, "native adTemplate is null");
        }
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            a(bVar);
            cVar.a(null);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public void onDestroy() {
    }
}
