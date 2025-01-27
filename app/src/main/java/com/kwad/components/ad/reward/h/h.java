package com.kwad.components.ad.reward.h;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h implements com.kwad.sdk.core.webview.b.a {
    private a wY;

    public interface a {
        void T(int i2);
    }

    public h(a aVar) {
        this.wY = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (this.wY != null) {
            int i2 = 0;
            try {
                i2 = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.wY.T(i2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.wY = null;
    }
}
