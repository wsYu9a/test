package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class ah implements com.kwad.sdk.core.webview.b.a {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public ah(Context context, AdTemplate adTemplate) {
        this.mContext = context;
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "openWechatMiniProgram";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.components.core.webview.kwai.c cVar2 = new com.kwad.components.core.webview.kwai.c();
        if (this.mContext == null) {
            com.kwad.sdk.core.report.a.k(this.mAdTemplate, 2);
            cVar.onError(-1, "context为空");
        }
        try {
            cVar2.parseJson(new JSONObject(str));
            AdInfo cb = com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate);
            if (com.kwad.sdk.core.response.a.a.L(cb) || com.kwad.components.core.d.b.e.a(this.mContext, cb.adConversionInfo.smallAppJumpInfo.mediaSmallAppId, cVar2.RY, cVar2.RZ, this.mAdTemplate) != 1) {
                cVar.onError(-1, "跳转失败");
            } else {
                cVar.a(null);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.report.a.k(this.mAdTemplate, 2);
            cVar.onError(-1, "解析失败");
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
