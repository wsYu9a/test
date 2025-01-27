package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bh implements com.kwad.sdk.core.webview.c.a {
    private static Handler abi;
    private com.kwad.components.core.e.d.c MA;
    private com.kwad.sdk.core.webview.b abh;
    private b abj;

    /* renamed from: com.kwad.components.core.webview.jshandler.bh$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ int cO;

        public AnonymousClass1(int i10) {
            i10 = i10;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (bh.this.abj != null) {
                bh.this.abj.R(i10);
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int lz;
    }

    public interface b {
        @MainThread
        void R(int i10);
    }

    public bh(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, b bVar2) {
        this.abh = bVar;
        this.MA = cVar;
        this.abj = bVar2;
        if (abi == null) {
            abi = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            abi.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.bh.1
                final /* synthetic */ int cO;

                public AnonymousClass1(int i10) {
                    i10 = i10;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (bh.this.abj != null) {
                        bh.this.abj.R(i10);
                    }
                }
            });
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
        }
    }
}
