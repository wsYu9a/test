package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class av implements com.kwad.sdk.core.webview.b.a {
    private static Handler Uk;
    private com.kwad.components.core.d.b.c IM;
    private b Ul;
    private com.kwad.sdk.core.webview.b jsBridgeContext;

    /* renamed from: com.kwad.components.core.webview.jshandler.av$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ int eK;

        AnonymousClass1(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (av.this.Ul != null) {
                av.this.Ul.S(i2);
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int jU;
    }

    public interface b {
        @MainThread
        void S(int i2);
    }

    public av(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.d.b.c cVar, b bVar2) {
        this.jsBridgeContext = bVar;
        this.IM = cVar;
        this.Ul = bVar2;
        if (Uk == null) {
            Uk = new Handler(Looper.getMainLooper());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "playableConvert";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            Uk.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.av.1
                final /* synthetic */ int eK;

                AnonymousClass1(int i2) {
                    i2 = i2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (av.this.Ul != null) {
                        av.this.Ul.S(i2);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
