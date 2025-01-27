package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a yM;

    public interface a {
        void S(int i10);
    }

    public h(a aVar) {
        this.yM = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        int i10;
        if (this.yM != null) {
            try {
                i10 = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e10) {
                e10.printStackTrace();
                i10 = 0;
            }
            this.yM.S(i10);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.yM = null;
    }
}
