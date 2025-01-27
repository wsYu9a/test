package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {
    private b Yz;

    /* renamed from: com.kwad.components.core.webview.jshandler.a$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ C0448a YA;

        public AnonymousClass1(C0448a c0448a) {
            c0448a = c0448a;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (a.this.Yz != null) {
                a.this.Yz.c(c0448a);
            }
        }
    }

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.a$a */
    public static class C0448a extends com.kwad.sdk.core.response.a.a {
        public String Li;
        public String YC;
        public String YD;
    }

    public interface b {
        void c(C0448a c0448a);
    }

    @KsJson
    public static class c extends com.kwad.sdk.core.response.a.a {
        public int YE;
        public long YF;
        public boolean YG;
        public int errorCode;
    }

    public a(b bVar) {
        this.Yz = bVar;
    }

    private void b(C0448a c0448a) {
        bt.postOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.a.1
            final /* synthetic */ C0448a YA;

            public AnonymousClass1(C0448a c0448a2) {
                c0448a = c0448a2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (a.this.Yz != null) {
                    a.this.Yz.c(c0448a);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "adOutCallback";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            C0448a c0448a = new C0448a();
            c0448a.parseJson(new JSONObject(str));
            b(c0448a);
        } catch (Throwable unused) {
        }
    }
}
