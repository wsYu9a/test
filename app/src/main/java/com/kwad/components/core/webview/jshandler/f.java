package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.m;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private static String aK(String str) {
        m.a aVar = new m.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        return TextUtils.isEmpty(aVar.key) ? "" : com.kwad.sdk.utils.y.b(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", aVar.key, "");
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "getStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.onError(-1, "data is empty");
            return;
        }
        String aK = aK(str);
        m.a aVar = new m.a();
        aVar.value = aK;
        cVar.a(aVar);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
