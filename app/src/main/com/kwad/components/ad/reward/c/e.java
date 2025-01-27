package com.kwad.components.ad.reward.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes2.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private String TAG;
    private com.kwad.sdk.core.webview.c.c oN;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public String sQ;
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.c.d(str, "create: ");
    }

    private void H(String str) {
        if (TextUtils.isEmpty(str) || this.oN == null) {
            return;
        }
        a aVar = new a();
        aVar.sQ = str;
        this.oN.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d(this.TAG, "handleJsCall: " + cVar);
        this.oN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    public final void hl() {
        com.kwad.sdk.core.d.c.d(this.TAG, "notifyDialogClose: ");
        H("close");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.c.d(this.TAG, "onDestroy: ");
        this.oN = null;
    }
}
