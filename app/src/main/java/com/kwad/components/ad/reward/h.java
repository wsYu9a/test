package com.kwad.components.ad.reward;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bw;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class h {

    static class a {
        private static h oK = new h((byte) 0);
    }

    static class b extends com.kwad.sdk.core.network.m<i, BaseResultData> {

        @NonNull
        private AdTemplate adTemplate;
        private com.kwad.sdk.core.network.p<i, BaseResultData> oL = new com.kwad.sdk.core.network.p<i, BaseResultData>() { // from class: com.kwad.components.ad.reward.h.b.1
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull i iVar, int i2, String str) {
                super.onError(iVar, i2, str);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull i iVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(iVar, baseResultData);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 0, bw.o);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        };

        /* renamed from: com.kwad.components.ad.reward.h$b$1 */
        final class AnonymousClass1 extends com.kwad.sdk.core.network.p<i, BaseResultData> {
            AnonymousClass1() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull i iVar, int i2, String str) {
                super.onError(iVar, i2, str);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 1, str);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify failed");
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull i iVar, @NonNull BaseResultData baseResultData) {
                super.onSuccess(iVar, baseResultData);
                com.kwad.components.core.m.a.pb().c(b.this.adTemplate, 0, bw.o);
                com.kwad.sdk.core.d.b.i("RewardCallbackVerifyHelper", "callbackUrlInfo verify success");
            }
        }

        public b(@NonNull AdTemplate adTemplate) {
            this.adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: fz */
        public i createRequest() {
            return new i(this.adTemplate);
        }

        public final void fy() {
            request(this.oL);
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final BaseResultData parseData(String str) {
            BaseResultData baseResultData = new BaseResultData() { // from class: com.kwad.components.ad.reward.RewardCallbackVerifyHelper$ServerCallbackNetworking$2
            };
            if (!TextUtils.isEmpty(str)) {
                try {
                    baseResultData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
            }
            return baseResultData;
        }
    }

    private h() {
    }

    /* synthetic */ h(byte b2) {
        this();
    }

    public static h fw() {
        return a.oK;
    }

    private static void n(AdTemplate adTemplate) {
        new b(adTemplate).fy();
    }

    public final void m(AdTemplate adTemplate) {
        com.kwad.sdk.core.d.b.d("RewardCallbackVerifyHelper", "handleRewardVerify");
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.bD(cb))) {
            q.b(adTemplate, cb);
        } else {
            n(adTemplate);
        }
    }
}
