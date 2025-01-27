package com.kwad.components.core.webview.a.kwai;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class w implements com.kwad.sdk.core.webview.b.a {
    private a US;

    /* renamed from: com.kwad.components.core.webview.a.kwai.w$1 */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ TKAdLiveShopItemInfo UT;

        AnonymousClass1(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
            tKAdLiveShopItemInfo = tKAdLiveShopItemInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (w.this.US != null) {
                w.this.US.a(tKAdLiveShopItemInfo);
            }
        }
    }

    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public w(a aVar) {
        this.US = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void handleJsCall(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            com.kwad.sdk.core.d.b.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.a.kwai.w.1
                final /* synthetic */ TKAdLiveShopItemInfo UT;

                AnonymousClass1(TKAdLiveShopItemInfo tKAdLiveShopItemInfo2) {
                    tKAdLiveShopItemInfo = tKAdLiveShopItemInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (w.this.US != null) {
                        w.this.US.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
    }
}
