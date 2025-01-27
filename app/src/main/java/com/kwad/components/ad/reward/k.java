package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: com.kwad.components.ad.reward.k$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.network.l<com.kwad.components.core.request.l, RewardFraudVerifyRespInfo> {
        public AnonymousClass1() {
        }

        @NonNull
        private static RewardFraudVerifyRespInfo E(String str) {
            JSONObject jSONObject = new JSONObject(str);
            RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo = new RewardFraudVerifyRespInfo();
            rewardFraudVerifyRespInfo.parseJson(jSONObject);
            return rewardFraudVerifyRespInfo;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: gF */
        public com.kwad.components.core.request.l createRequest() {
            return new com.kwad.components.core.request.l(g.this.mAdTemplate);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ RewardFraudVerifyRespInfo parseData(String str) {
            return E(str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.k$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.network.o<com.kwad.components.core.request.l, RewardFraudVerifyRespInfo> {

        /* renamed from: com.kwad.components.ad.reward.k$2$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ RewardFraudVerifyRespInfo rI;

            public AnonymousClass1(RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo) {
                rewardFraudVerifyRespInfo = rewardFraudVerifyRespInfo;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                g.this.qC = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                g.this.qD = rewardFraudVerifyRespInfo.getCode();
            }
        }

        public AnonymousClass2() {
        }

        private void a(@NonNull RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.k.2.1
                final /* synthetic */ RewardFraudVerifyRespInfo rI;

                public AnonymousClass1(RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo2) {
                    rewardFraudVerifyRespInfo = rewardFraudVerifyRespInfo2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    g.this.qC = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                    g.this.qD = rewardFraudVerifyRespInfo.getCode();
                }
            });
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            a((RewardFraudVerifyRespInfo) baseResultData);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.request.l lVar, int i10, String str) {
            super.onError(lVar, i10, str);
            com.kwad.sdk.core.d.c.d("RewardFraudVerifyUtil", "error: " + i10);
        }
    }

    public static boolean a(g gVar, long j10, long j11, long j12) {
        long dj2 = com.kwad.sdk.core.response.b.a.dj(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate));
        if (j10 <= ((j11 - 800) - j12) - dj2 || dj2 <= 0 || !com.kwad.sdk.core.response.b.a.di(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate))) {
            return false;
        }
        h(gVar);
        return true;
    }

    private static void h(g gVar) {
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.l, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.1
            public AnonymousClass1() {
            }

            @NonNull
            private static RewardFraudVerifyRespInfo E(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo = new RewardFraudVerifyRespInfo();
                rewardFraudVerifyRespInfo.parseJson(jSONObject);
                return rewardFraudVerifyRespInfo;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gF */
            public com.kwad.components.core.request.l createRequest() {
                return new com.kwad.components.core.request.l(g.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardFraudVerifyRespInfo parseData(String str) {
                return E(str);
            }
        }.request(i(gVar));
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.l, RewardFraudVerifyRespInfo> i(g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.l, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.2

            /* renamed from: com.kwad.components.ad.reward.k$2$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ RewardFraudVerifyRespInfo rI;

                public AnonymousClass1(RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo2) {
                    rewardFraudVerifyRespInfo = rewardFraudVerifyRespInfo2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    g.this.qC = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                    g.this.qD = rewardFraudVerifyRespInfo.getCode();
                }
            }

            public AnonymousClass2() {
            }

            private void a(@NonNull RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo2) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.k.2.1
                    final /* synthetic */ RewardFraudVerifyRespInfo rI;

                    public AnonymousClass1(RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo22) {
                        rewardFraudVerifyRespInfo = rewardFraudVerifyRespInfo22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        g.this.qC = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                        g.this.qD = rewardFraudVerifyRespInfo.getCode();
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((RewardFraudVerifyRespInfo) baseResultData);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.request.l lVar, int i10, String str) {
                super.onError(lVar, i10, str);
                com.kwad.sdk.core.d.c.d("RewardFraudVerifyUtil", "error: " + i10);
            }
        };
    }
}
