package com.kwad.components.ad.reward.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;

/* loaded from: classes.dex */
public final class e implements com.kwad.sdk.core.webview.b.a {
    private String TAG;
    private com.kwad.sdk.core.webview.b.c nN;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public String ru;
    }

    public e() {
        String str = "ExtraDialogListener" + hashCode();
        this.TAG = str;
        com.kwad.sdk.core.d.b.d(str, "create: ");
    }

    private void T(String str) {
        if (TextUtils.isEmpty(str) || this.nN == null) {
            return;
        }
        a aVar = new a();
        aVar.ru = str;
        this.nN.a(aVar);
    }

    public final void gV() {
        com.kwad.sdk.core.d.b.d(this.TAG, "notifyDialogClose: ");
        T("close");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerExtraDialogListener";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        com.kwad.sdk.core.d.b.d(this.TAG, "handleJsCall: " + cVar);
        this.nN = cVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.sdk.core.d.b.d(this.TAG, "onDestroy: ");
        this.nN = null;
    }
}
