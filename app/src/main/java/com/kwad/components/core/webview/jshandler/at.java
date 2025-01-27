package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class at implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sx;
    private b Uc;

    /* renamed from: com.kwad.components.core.webview.jshandler.at$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a Ud;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            at.this.b(aVar);
            if (at.this.Sx != null) {
                at.this.Sx.a(null);
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public at(b bVar) {
        this.Uc = bVar;
    }

    public void b(a aVar) {
        b bVar = this.Uc;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.at.1
            final /* synthetic */ a Ud;

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                at.this.b(aVar);
                if (at.this.Sx != null) {
                    at.this.Sx.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Uc = null;
        this.Sx = null;
    }
}
