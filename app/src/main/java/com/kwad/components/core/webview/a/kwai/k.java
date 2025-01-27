package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k extends v {
    b UI = new b() { // from class: com.kwad.components.core.webview.a.kwai.k.1
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.k.b
        public final void z(long j2) {
            if (k.this.nN != null) {
                a aVar = new a((byte) 0);
                aVar.creativeId = j2;
                k.this.nN.a(aVar);
            }
        }
    };
    private com.kwad.sdk.core.webview.b.c nN;

    /* renamed from: com.kwad.components.core.webview.a.kwai.k$1 */
    final class AnonymousClass1 implements b {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.a.kwai.k.b
        public final void z(long j2) {
            if (k.this.nN != null) {
                a aVar = new a((byte) 0);
                aVar.creativeId = j2;
                k.this.nN.a(aVar);
            }
        }
    }

    static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }
    }

    public interface b {
        void z(long j2);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.nN = cVar;
        com.kwad.components.core.d.b.a.a(this.UI);
    }

    @Override // com.kwad.components.core.webview.a.kwai.v, com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        com.kwad.components.core.d.b.a.b(this.UI);
    }
}
