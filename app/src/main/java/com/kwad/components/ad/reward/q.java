package com.kwad.components.ad.reward;

import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bb;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: com.kwad.components.ad.reward.q$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ AdTemplate eI;
        final /* synthetic */ String qx;

        AnonymousClass1(String str, AdTemplate adTemplate) {
            bC = str;
            adTemplate = adTemplate;
        }

        private void S(String str) {
            com.kwad.components.core.m.a.pb().c(adTemplate, 1, str);
        }

        private void gv() {
            com.kwad.components.core.m.a.pb().c(adTemplate, 0, bw.o);
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str;
            try {
                com.kwad.sdk.core.network.c doGet = com.kwad.sdk.b.rZ().doGet(bC, null);
                if (doGet == null) {
                    str = "Network Error: url invalid";
                } else if (doGet.code != 200) {
                    S("Network Error: " + doGet.agf);
                    return;
                } else {
                    a aVar = new a(doGet.agf);
                    if (aVar.isValid()) {
                        gv();
                        return;
                    }
                    str = aVar.errorMsg;
                }
                S(str);
            } catch (Throwable th) {
                S("Request Error: " + th.getMessage());
            }
        }
    }

    static class a {
        private String errorMsg;
        private boolean qy;

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = "-";
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.qy = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject != null) {
                this.qy = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }

        public final boolean isValid() {
            return this.qy;
        }
    }

    public static void b(AdTemplate adTemplate, AdInfo adInfo) {
        String bC = com.kwad.sdk.core.response.a.a.bC(adInfo);
        com.kwad.sdk.core.d.b.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + bC);
        if (bb.isNullString(bC)) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.reward.q.1
            final /* synthetic */ AdTemplate eI;
            final /* synthetic */ String qx;

            AnonymousClass1(String bC2, AdTemplate adTemplate2) {
                bC = bC2;
                adTemplate = adTemplate2;
            }

            private void S(String str) {
                com.kwad.components.core.m.a.pb().c(adTemplate, 1, str);
            }

            private void gv() {
                com.kwad.components.core.m.a.pb().c(adTemplate, 0, bw.o);
            }

            @Override // java.lang.Runnable
            public final void run() {
                String str;
                try {
                    com.kwad.sdk.core.network.c doGet = com.kwad.sdk.b.rZ().doGet(bC, null);
                    if (doGet == null) {
                        str = "Network Error: url invalid";
                    } else if (doGet.code != 200) {
                        S("Network Error: " + doGet.agf);
                        return;
                    } else {
                        a aVar = new a(doGet.agf);
                        if (aVar.isValid()) {
                            gv();
                            return;
                        }
                        str = aVar.errorMsg;
                    }
                    S(str);
                } catch (Throwable th) {
                    S("Request Error: " + th.getMessage());
                }
            }
        });
    }
}
