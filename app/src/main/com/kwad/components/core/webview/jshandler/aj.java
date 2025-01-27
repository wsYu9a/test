package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class aj implements com.kwad.sdk.core.webview.c.a {
    private final Handler Zm = new Handler(Looper.getMainLooper());

    @Nullable
    private com.kwad.sdk.core.webview.c.c Zn;

    /* renamed from: eg */
    private b f11947eg;

    /* renamed from: com.kwad.components.core.webview.jshandler.aj$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ a mA;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (aj.this.Zn != null) {
                aj.this.Zn.a(null);
            }
            aj.this.b(aVar);
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int aaa = -1;
        public int type;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public aj(b bVar) {
        this.f11947eg = bVar;
    }

    public void b(a aVar) {
        b bVar = this.f11947eg;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "hide";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.f11947eg = null;
        this.Zn = null;
        this.Zm.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            this.Zn = cVar;
            a aVar = new a();
            if (!TextUtils.isEmpty(str)) {
                aVar.parseJson(new JSONObject(str));
            }
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.aj.1
                final /* synthetic */ a mA;

                public AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (aj.this.Zn != null) {
                        aj.this.Zn.a(null);
                    }
                    aj.this.b(aVar);
                }
            });
        } catch (Exception e10) {
            this.Zn.onError(-1, e10.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
