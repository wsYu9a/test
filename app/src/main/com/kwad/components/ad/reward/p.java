package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bm;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class p {

    /* renamed from: com.kwad.components.ad.reward.p$1 */
    public class AnonymousClass1 implements Runnable {
        final /* synthetic */ AdTemplate cP;
        final /* synthetic */ String rR;

        public AnonymousClass1(String str, AdTemplate adTemplate) {
            bQ = str;
            adTemplate = adTemplate;
        }

        private void G(String str) {
            com.kwad.components.core.o.a.ri().g(adTemplate, 1, str);
        }

        private void gJ() {
            com.kwad.components.core.o.a.ri().g(adTemplate, 0, "success");
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.kwad.sdk.core.network.c doGet = com.kwad.sdk.g.zc().doGet(bQ, null);
                if (doGet == null) {
                    G("Network Error: url invalid");
                    return;
                }
                if (doGet.code != 200) {
                    G("Network Error: " + doGet.azu);
                } else {
                    a aVar = new a(doGet.azu);
                    if (aVar.isValid()) {
                        gJ();
                    } else {
                        G(aVar.errorMsg);
                    }
                }
            } catch (Throwable th2) {
                G("Request Error: " + th2.getMessage());
            }
        }
    }

    public static class a {
        private String errorMsg;
        private boolean rS;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th2) {
                th2.printStackTrace();
                this.rS = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.rS = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.rS;
        }
    }

    public static void b(AdTemplate adTemplate, AdInfo adInfo) {
        String bQ = com.kwad.sdk.core.response.b.a.bQ(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bQ);
        if (bm.isNullString(bQ)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            final /* synthetic */ AdTemplate cP;
            final /* synthetic */ String rR;

            public AnonymousClass1(String bQ2, AdTemplate adTemplate2) {
                bQ = bQ2;
                adTemplate = adTemplate2;
            }

            private void G(String str) {
                com.kwad.components.core.o.a.ri().g(adTemplate, 1, str);
            }

            private void gJ() {
                com.kwad.components.core.o.a.ri().g(adTemplate, 0, "success");
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c doGet = com.kwad.sdk.g.zc().doGet(bQ, null);
                    if (doGet == null) {
                        G("Network Error: url invalid");
                        return;
                    }
                    if (doGet.code != 200) {
                        G("Network Error: " + doGet.azu);
                    } else {
                        a aVar = new a(doGet.azu);
                        if (aVar.isValid()) {
                            gJ();
                        } else {
                            G(aVar.errorMsg);
                        }
                    }
                } catch (Throwable th2) {
                    G("Request Error: " + th2.getMessage());
                }
            }
        });
    }
}
