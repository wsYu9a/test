package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class bf implements com.kwad.sdk.core.webview.c.a {

    @Nullable
    private com.kwad.sdk.core.webview.c.c Zn;
    private b aaZ;

    /* renamed from: com.kwad.components.core.webview.jshandler.bf$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ a aba;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            bf.this.b(aVar);
            if (bf.this.Zn != null) {
                bf.this.Zn.a(null);
            }
        }
    }

    @KsJson
    public static final class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public bf(b bVar) {
        this.aaZ = bVar;
    }

    public void b(a aVar) {
        b bVar = this.aaZ;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.aaZ = null;
        this.Zn = null;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Zn = cVar;
        a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
        bt.postOnUiThread(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.bf.1
            final /* synthetic */ a aba;

            public AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                bf.this.b(aVar);
                if (bf.this.Zn != null) {
                    bf.this.Zn.a(null);
                }
            }
        });
    }
}
