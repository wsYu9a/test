package com.kwad.components.ad.reward.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d rE;

    /* renamed from: com.kwad.components.ad.reward.c.f$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ b sR;

        public AnonymousClass1(b bVar) {
            bVar = bVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (f.this.rE != null) {
                f.this.rE.a(bVar);
            }
        }
    }

    public f(d dVar) {
        this.rE = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.rE = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.c.f.1
                final /* synthetic */ b sR;

                public AnonymousClass1(b bVar2) {
                    bVar = bVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (f.this.rE != null) {
                        f.this.rE.a(bVar);
                    }
                }
            });
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
