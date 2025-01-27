package com.kwad.components.core.webview.tachikoma.a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private a adh;

    /* renamed from: com.kwad.components.core.webview.tachikoma.a.y$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ TKAdLiveShopItemInfo adi;

        public AnonymousClass1(TKAdLiveShopItemInfo tKAdLiveShopItemInfo) {
            tKAdLiveShopItemInfo = tKAdLiveShopItemInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (y.this.adh != null) {
                y.this.adh.a(tKAdLiveShopItemInfo);
            }
        }
    }

    public interface a {
        void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo);
    }

    public y(a aVar) {
        this.adh = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "updateLiveCurrentShopInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        try {
            com.kwad.sdk.core.d.c.d("UpdateLiveCurrentShopInfoHandler", "handleJsCall: " + str);
            TKAdLiveShopItemInfo tKAdLiveShopItemInfo = new TKAdLiveShopItemInfo();
            tKAdLiveShopItemInfo.parseJson(new JSONObject(str));
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.y.1
                final /* synthetic */ TKAdLiveShopItemInfo adi;

                public AnonymousClass1(TKAdLiveShopItemInfo tKAdLiveShopItemInfo2) {
                    tKAdLiveShopItemInfo = tKAdLiveShopItemInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    if (y.this.adh != null) {
                        y.this.adh.a(tKAdLiveShopItemInfo);
                    }
                }
            });
        } catch (Exception e10) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
        }
    }
}
