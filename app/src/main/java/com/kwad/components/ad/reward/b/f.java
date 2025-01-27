package com.kwad.components.ad.reward.b;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f implements com.kwad.sdk.core.webview.b.a {
    private d ql;

    /* renamed from: com.kwad.components.ad.reward.b.f$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ b rv;

        AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (f.this.ql != null) {
                f.this.ql.a(bVar);
            }
        }
    }

    public f(d dVar) {
        this.ql = dVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.b.f.1
                final /* synthetic */ b rv;

                AnonymousClass1(b bVar2) {
                    bVar = bVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (f.this.ql != null) {
                        f.this.ql.a(bVar);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.ql = null;
    }
}
