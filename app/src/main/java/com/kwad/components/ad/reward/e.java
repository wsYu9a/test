package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e {

    public static class a {

        /* renamed from: qb */
        private static e f11665qb = new e((byte) 0);
    }

    public /* synthetic */ e(byte b10) {
        this();
    }

    private static void H(AdTemplate adTemplate) {
        new b(adTemplate).fL();
    }

    public static e fJ() {
        return a.f11665qb;
    }

    public final void G(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.c.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.bR(eb2))) {
            p.b(adTemplate, eb2);
        } else {
            H(adTemplate);
        }
    }

    public static class b extends com.kwad.sdk.core.network.l<f, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;

        /* renamed from: qc */
        private com.kwad.sdk.core.network.o<f, BaseResultData> f11666qc = new com.kwad.sdk.core.network.o<f, BaseResultData>() { // from class: com.kwad.components.ad.reward.e.b.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.o.a.ri().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull f fVar, int i10, String str) {
                super.onError(fVar, i10, str);
                com.kwad.components.core.o.a.ri().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        };

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: fM */
        public f createRequest() {
            return new f(this.adTemplate);
        }

        public final void fL() {
            request(this.f11666qc);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final BaseResultData parseData(String str) {
            RewardCallbackVerifyHelper$ServerCallbackNetworking$2 rewardCallbackVerifyHelper$ServerCallbackNetworking$2 = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
                public RewardCallbackVerifyHelper$ServerCallbackNetworking$2() {
                }
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    rewardCallbackVerifyHelper$ServerCallbackNetworking$2.parseJson(new JSONObject(str));
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
            return rewardCallbackVerifyHelper$ServerCallbackNetworking$2;
        }

        /* renamed from: com.kwad.components.ad.reward.e$b$1 */
        public class AnonymousClass1 extends com.kwad.sdk.core.network.o<f, BaseResultData> {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(fVar, baseResultData);
                com.kwad.components.core.o.a.ri().g(b.this.adTemplate, 0, "success");
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull f fVar, int i10, String str) {
                super.onError(fVar, i10, str);
                com.kwad.components.core.o.a.ri().g(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.c.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }
        }
    }

    private e() {
    }
}
