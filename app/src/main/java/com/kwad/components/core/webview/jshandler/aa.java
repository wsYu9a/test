package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class aa implements com.kwad.sdk.core.webview.b.a {
    private final Handler Sw = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sx;
    private b cY;

    /* renamed from: com.kwad.components.core.webview.jshandler.aa$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a kv;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (aa.this.Sx != null) {
                aa.this.Sx.a(null);
            }
            aa.this.b(aVar);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int Tm = -1;
        public int type;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public aa(b bVar) {
        this.cY = bVar;
    }

    public void b(a aVar) {
        b bVar = this.cY;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.Sx = cVar;
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.aa.1
                final /* synthetic */ a kv;

                AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (aa.this.Sx != null) {
                        aa.this.Sx.a(null);
                    }
                    aa.this.b(aVar);
                }
            });
        } catch (Exception e2) {
            this.Sx.onError(-1, e2.getMessage());
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.cY = null;
        this.Sx = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
