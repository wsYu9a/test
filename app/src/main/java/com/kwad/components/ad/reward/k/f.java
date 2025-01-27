package com.kwad.components.ad.reward.k;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    /* renamed from: com.kwad.components.ad.reward.k.f$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ String yI;

        public AnonymousClass1(String str) {
            str = str;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            boolean z10;
            try {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                z10 = aVar.yK;
            } catch (Exception unused) {
                z10 = false;
            }
            f.this.V(z10);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean yK;
    }

    public void V(boolean z10) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        bt.postOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.k.f.1
            final /* synthetic */ String yI;

            public AnonymousClass1(String str2) {
                str = str2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                boolean z10;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z10 = aVar.yK;
                } catch (Exception unused) {
                    z10 = false;
                }
                f.this.V(z10);
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
