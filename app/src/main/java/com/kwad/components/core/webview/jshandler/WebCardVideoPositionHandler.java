package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.b.a {
    private a Ui;
    private VideoPosition Uh = new VideoPosition();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    /* renamed from: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebCardVideoPositionHandler.this.Ui.a(WebCardVideoPositionHandler.this.Uh);
        }
    }

    @KsJson
    public static final class VideoPosition extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        @KsJson
        public static class KSAdJSCornerModel extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public final void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                KSAdJSCornerModel kSAdJSCornerModel = new KSAdJSCornerModel();
                this.cornerRadius = kSAdJSCornerModel;
                kSAdJSCornerModel.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }

    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.Ui = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.Uh.parseJson(new JSONObject(str));
            if (this.Ui != null) {
                this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        WebCardVideoPositionHandler.this.Ui.a(WebCardVideoPositionHandler.this.Uh);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
