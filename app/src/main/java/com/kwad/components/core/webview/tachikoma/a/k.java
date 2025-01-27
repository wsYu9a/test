package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class k extends w {
    b acR = new b() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1

        /* renamed from: com.kwad.components.core.webview.tachikoma.a.k$1$1 */
        public class C04551 extends bd {
            final /* synthetic */ long acT;

            public C04551(long j10) {
                j10 = j10;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a aVar = new a((byte) 0);
                aVar.creativeId = j10;
                k.this.oN.a(aVar);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.k.b
        public final void M(long j10) {
            if (k.this.oN != null) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    final /* synthetic */ long acT;

                    public C04551(long j102) {
                        j10 = j102;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j10;
                        k.this.oN.a(aVar);
                    }
                });
            }
        }
    };
    private com.kwad.sdk.core.webview.c.c oN;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.k$1 */
    public class AnonymousClass1 implements b {

        /* renamed from: com.kwad.components.core.webview.tachikoma.a.k$1$1 */
        public class C04551 extends bd {
            final /* synthetic */ long acT;

            public C04551(long j102) {
                j10 = j102;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a aVar = new a((byte) 0);
                aVar.creativeId = j10;
                k.this.oN.a(aVar);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.webview.tachikoma.a.k.b
        public final void M(long j102) {
            if (k.this.oN != null) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.webview.tachikoma.a.k.1.1
                    final /* synthetic */ long acT;

                    public C04551(long j1022) {
                        j10 = j1022;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        a aVar = new a((byte) 0);
                        aVar.creativeId = j10;
                        k.this.oN.a(aVar);
                    }
                });
            }
        }
    }

    public static class a implements com.kwad.sdk.core.b {
        public long creativeId;

        private a() {
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "creativeId", this.creativeId);
            return jSONObject;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public interface b {
        void M(long j10);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerAdConvertListener";
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.components.core.e.d.a.b(this.acR);
    }

    @Override // com.kwad.components.core.webview.tachikoma.a.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.oN = cVar;
        com.kwad.components.core.e.d.a.a(this.acR);
    }
}
