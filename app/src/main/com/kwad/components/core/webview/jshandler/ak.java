package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ak implements com.kwad.sdk.core.webview.c.a {
    private final WebView Qc;
    private Handler Zm;

    @Nullable
    private com.kwad.sdk.core.webview.c.c Zn;
    private boolean aab;

    /* renamed from: ef */
    @Nullable
    private b f11948ef;

    /* renamed from: com.kwad.components.core.webview.jshandler.ak$1 */
    public class AnonymousClass1 extends com.kwad.sdk.utils.bd {
        final /* synthetic */ a aac;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (ak.this.Qc != null && ak.this.aab) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ak.this.Qc.getLayoutParams();
                marginLayoutParams.width = -1;
                a aVar = aVar;
                marginLayoutParams.height = aVar.height;
                marginLayoutParams.leftMargin = aVar.leftMargin;
                marginLayoutParams.rightMargin = aVar.rightMargin;
                marginLayoutParams.bottomMargin = aVar.bottomMargin;
                ak.this.Qc.setLayoutParams(marginLayoutParams);
            }
            if (ak.this.f11948ef != null) {
                ak.this.f11948ef.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ak$2 */
    public class AnonymousClass2 extends com.kwad.sdk.utils.bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            if (ak.this.Zn != null) {
                ak.this.Zn.a(null);
            }
        }
    }

    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.x.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.x.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.x.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.x.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public ak(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Zn = null;
        this.f11948ef = null;
        this.Zm.removeCallbacksAndMessages(null);
    }

    private ak(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z10) {
        this.aab = true;
        this.Zm = new Handler(Looper.getMainLooper());
        this.Qc = bVar.Qc;
        this.f11948ef = bVar2;
        this.aab = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.Zn = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ak.1
                final /* synthetic */ a aac;

                public AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (ak.this.Qc != null && ak.this.aab) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ak.this.Qc.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        ak.this.Qc.setLayoutParams(marginLayoutParams);
                    }
                    if (ak.this.f11948ef != null) {
                        ak.this.f11948ef.a(aVar);
                    }
                }
            });
            this.Zm.post(new com.kwad.sdk.utils.bd() { // from class: com.kwad.components.core.webview.jshandler.ak.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (ak.this.Zn != null) {
                        ak.this.Zn.a(null);
                    }
                }
            });
        } catch (JSONException e10) {
            com.kwad.sdk.core.d.c.printStackTrace(e10);
            cVar.onError(-1, e10.getMessage());
        }
    }
}
