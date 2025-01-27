package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bi;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: com.kwad.components.ad.reward.n$1 */
    static class AnonymousClass1 extends com.kwad.sdk.core.network.m<com.kwad.components.core.n.d, RewardCallBackRespInfo> {
        final /* synthetic */ int qo;
        final /* synthetic */ j qp;

        AnonymousClass1(int i2, j jVar) {
            i2 = i2;
            jVar = jVar;
        }

        @NonNull
        private static RewardCallBackRespInfo R(String str) {
            JSONObject jSONObject = new JSONObject(str);
            RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
            rewardCallBackRespInfo.parseJson(jSONObject);
            return rewardCallBackRespInfo;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: gq */
        public com.kwad.components.core.n.d createRequest() {
            return new com.kwad.components.core.n.d(i2, jVar.mAdTemplate);
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
            return R(str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n$2 */
    static class AnonymousClass2 extends com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> {

        /* renamed from: com.kwad.components.ad.reward.n$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ RewardCallBackRespInfo qq;

            AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo) {
                rewardCallBackRespInfo = rewardCallBackRespInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                j.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }
        }

        /* renamed from: com.kwad.components.ad.reward.n$2$2 */
        final class RunnableC01502 implements Runnable {
            RunnableC01502() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                j.this.mCheckExposureResult = false;
            }
        }

        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.n.d dVar) {
            dVar.Om = System.currentTimeMillis();
            com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 1);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.n.d dVar, int i2, String str) {
            super.onError(dVar, i2, str);
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.2
                RunnableC01502() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.mCheckExposureResult = false;
                }
            });
            com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.n.d dVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
            bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.1
                final /* synthetic */ RewardCallBackRespInfo qq;

                AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                }
            });
            com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo2.result, rewardCallBackRespInfo2.errorMsg);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.n$3 */
    static class AnonymousClass3 extends com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> {

        /* renamed from: com.kwad.components.ad.reward.n$3$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ RewardCallBackRespInfo qq;

            AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo) {
                rewardCallBackRespInfo = rewardCallBackRespInfo;
            }

            @Override // java.lang.Runnable
            public final void run() {
                j jVar;
                int i2 = 1;
                if (rewardCallBackRespInfo.result == 1) {
                    jVar = j.this;
                } else {
                    jVar = j.this;
                    i2 = 2;
                }
                jVar.pn = i2;
                j.this.mAdOpenInteractionListener.onRewardVerify();
            }
        }

        /* renamed from: com.kwad.components.ad.reward.n$3$2 */
        final class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                j.this.pn = 2;
            }
        }

        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.n.d dVar) {
            dVar.Om = System.currentTimeMillis();
            com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 2);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.n.d dVar, int i2, String str) {
            super.onError(dVar, i2, str);
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.2
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.pn = 2;
                }
            });
            com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.n.d dVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.1
                final /* synthetic */ RewardCallBackRespInfo qq;

                AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j jVar;
                    int i2 = 1;
                    if (rewardCallBackRespInfo.result == 1) {
                        jVar = j.this;
                    } else {
                        jVar = j.this;
                        i2 = 2;
                    }
                    jVar.pn = i2;
                    j.this.mAdOpenInteractionListener.onRewardVerify();
                }
            });
            com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo2.result, rewardCallBackRespInfo2.errorMsg);
        }
    }

    public static void a(int i2, j jVar) {
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.network.m<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.1
            final /* synthetic */ int qo;
            final /* synthetic */ j qp;

            AnonymousClass1(int i22, j jVar2) {
                i2 = i22;
                jVar = jVar2;
            }

            @NonNull
            private static RewardCallBackRespInfo R(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gq */
            public com.kwad.components.core.n.d createRequest() {
                return new com.kwad.components.core.n.d(i2, jVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return R(str);
            }
        };
        if (i22 == 1) {
            anonymousClass1.request(n(jVar2));
        } else if (i22 == 2) {
            anonymousClass1.request(o(jVar2));
        }
    }

    public static void a(j jVar, long j2, long j3, long j4) {
        boolean p = p(jVar);
        long cB = p ? com.kwad.sdk.core.response.a.a.cB(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate)) : 0L;
        if (jVar.po || !p || !jVar.mCheckExposureResult || j2 <= ((j3 - 800) - j4) - cB || cB <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.a.a.cC(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate))) {
            jVar.pn = 1;
            a(2, jVar);
        } else {
            jVar.mAdOpenInteractionListener.onRewardVerify();
        }
        jVar.po = true;
    }

    private static com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> n(j jVar) {
        return new com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.2

            /* renamed from: com.kwad.components.ad.reward.n$2$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ RewardCallBackRespInfo qq;

                AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                }
            }

            /* renamed from: com.kwad.components.ad.reward.n$2$2 */
            final class RunnableC01502 implements Runnable {
                RunnableC01502() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.mCheckExposureResult = false;
                }
            }

            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.n.d dVar) {
                dVar.Om = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 1);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.n.d dVar, int i2, String str) {
                super.onError(dVar, i2, str);
                bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.2
                    RunnableC01502() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.n.d dVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo2) {
                bi.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.2.1
                    final /* synthetic */ RewardCallBackRespInfo qq;

                    AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo22) {
                        rewardCallBackRespInfo = rewardCallBackRespInfo22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 1, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo22.result, rewardCallBackRespInfo22.errorMsg);
            }
        };
    }

    private static com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo> o(j jVar) {
        return new com.kwad.sdk.core.network.p<com.kwad.components.core.n.d, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.n.3

            /* renamed from: com.kwad.components.ad.reward.n$3$1 */
            final class AnonymousClass1 implements Runnable {
                final /* synthetic */ RewardCallBackRespInfo qq;

                AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j jVar;
                    int i2 = 1;
                    if (rewardCallBackRespInfo.result == 1) {
                        jVar = j.this;
                    } else {
                        jVar = j.this;
                        i2 = 2;
                    }
                    jVar.pn = i2;
                    j.this.mAdOpenInteractionListener.onRewardVerify();
                }
            }

            /* renamed from: com.kwad.components.ad.reward.n$3$2 */
            final class AnonymousClass2 implements Runnable {
                AnonymousClass2() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    j.this.pn = 2;
                }
            }

            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.n.d dVar) {
                dVar.Om = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.c(j.this.mAdTemplate, 2);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.n.d dVar, int i2, String str) {
                super.onError(dVar, i2, str);
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.2
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.pn = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.n.d dVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo2) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.n.3.1
                    final /* synthetic */ RewardCallBackRespInfo qq;

                    AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo22) {
                        rewardCallBackRespInfo = rewardCallBackRespInfo22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        j jVar2;
                        int i2 = 1;
                        if (rewardCallBackRespInfo.result == 1) {
                            jVar2 = j.this;
                        } else {
                            jVar2 = j.this;
                            i2 = 2;
                        }
                        jVar2.pn = i2;
                        j.this.mAdOpenInteractionListener.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(j.this.mAdTemplate, 2, System.currentTimeMillis() - dVar.Om, rewardCallBackRespInfo22.result, rewardCallBackRespInfo22.errorMsg);
            }
        };
    }

    private static boolean p(j jVar) {
        return !jVar.po && com.kwad.sdk.core.response.a.a.cD(com.kwad.sdk.core.response.a.d.cb(jVar.mAdTemplate));
    }
}
