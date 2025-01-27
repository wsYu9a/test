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

/* loaded from: classes2.dex */
public final class ab implements com.kwad.sdk.core.webview.b.a {
    private final WebView Lc;
    private Handler Sw;

    @Nullable
    private com.kwad.sdk.core.webview.b.c Sx;
    private boolean Tn;

    @Nullable
    private b cX;

    /* renamed from: com.kwad.components.core.webview.jshandler.ab$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ a To;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ab.this.Lc != null && ab.this.Tn) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ab.this.Lc.getLayoutParams();
                marginLayoutParams.width = -1;
                a aVar = aVar;
                marginLayoutParams.height = aVar.height;
                marginLayoutParams.leftMargin = aVar.leftMargin;
                marginLayoutParams.rightMargin = aVar.rightMargin;
                marginLayoutParams.bottomMargin = aVar.bottomMargin;
                ab.this.Lc.setLayoutParams(marginLayoutParams);
            }
            if (ab.this.cX != null) {
                ab.this.cX.a(aVar);
            }
        }
    }

    /* renamed from: com.kwad.components.core.webview.jshandler.ab$2 */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ab.this.Sx != null) {
                ab.this.Sx.a(null);
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
            com.kwad.sdk.utils.t.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.t.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.t.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public ab(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    private ab(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z) {
        this.Tn = true;
        this.Sw = new Handler(Looper.getMainLooper());
        this.Lc = bVar.Lc;
        this.cX = bVar2;
        this.Tn = true;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.Sx = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.1
                final /* synthetic */ a To;

                AnonymousClass1(a aVar2) {
                    aVar = aVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (ab.this.Lc != null && ab.this.Tn) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ab.this.Lc.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        ab.this.Lc.setLayoutParams(marginLayoutParams);
                    }
                    if (ab.this.cX != null) {
                        ab.this.cX.a(aVar);
                    }
                }
            });
            this.Sw.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ab.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (ab.this.Sx != null) {
                        ab.this.Sx.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Sx = null;
        this.cX = null;
        this.Sw.removeCallbacksAndMessages(null);
    }
}
