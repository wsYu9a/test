package com.kwad.components.ad.reward;

import androidx.annotation.NonNull;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m {

    /* renamed from: com.kwad.components.ad.reward.m$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo> {
        final /* synthetic */ g rH;
        final /* synthetic */ int rK;

        public AnonymousClass1(int i10, g gVar) {
            i10 = i10;
            gVar = gVar;
        }

        @NonNull
        private static RewardCallBackRespInfo F(String str) {
            JSONObject jSONObject = new JSONObject(str);
            RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
            rewardCallBackRespInfo.parseJson(jSONObject);
            return rewardCallBackRespInfo;
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: gG */
        public com.kwad.components.core.request.e createRequest() {
            return new com.kwad.components.core.request.e(i10, gVar.mAdTemplate);
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
            return F(str);
        }
    }

    public static void a(int i10, g gVar) {
        AnonymousClass1 anonymousClass1 = new com.kwad.sdk.core.network.l<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.1
            final /* synthetic */ g rH;
            final /* synthetic */ int rK;

            public AnonymousClass1(int i102, g gVar2) {
                i10 = i102;
                gVar = gVar2;
            }

            @NonNull
            private static RewardCallBackRespInfo F(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: gG */
            public com.kwad.components.core.request.e createRequest() {
                return new com.kwad.components.core.request.e(i10, gVar.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ RewardCallBackRespInfo parseData(String str) {
                return F(str);
            }
        };
        if (i102 == 1) {
            anonymousClass1.request(k(gVar2));
        } else if (i102 == 2) {
            anonymousClass1.request(l(gVar2));
        }
    }

    public static void b(g gVar, long j10, long j11, long j12) {
        boolean m10 = m(gVar);
        long df2 = m10 ? com.kwad.sdk.core.response.b.a.df(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate)) : 0L;
        if (gVar.qF || !m10 || !gVar.mCheckExposureResult || j10 <= ((j11 - 800) - j12) - df2 || df2 <= 0) {
            return;
        }
        if (com.kwad.sdk.core.response.b.a.dg(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate))) {
            gVar.qE = 1;
            a(2, gVar);
        } else {
            gVar.f11688qe.onRewardVerify();
        }
        gVar.qF = true;
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> k(g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.2

            /* renamed from: com.kwad.components.ad.reward.m$2$1 */
            public class AnonymousClass1 implements Runnable {
                final /* synthetic */ RewardCallBackRespInfo rL;

                public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                }
            }

            /* renamed from: com.kwad.components.ad.reward.m$2$2 */
            public class RunnableC03992 implements Runnable {
                public RunnableC03992() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.mCheckExposureResult = false;
                }
            }

            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.TY = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.1
                    final /* synthetic */ RewardCallBackRespInfo rL;

                    public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                        rewardCallBackRespInfo = rewardCallBackRespInfo2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.TY, rewardCallBackRespInfo2.result, rewardCallBackRespInfo2.errorMsg);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.2
                    public RunnableC03992() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.mCheckExposureResult = false;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.TY, i10, str);
            }
        };
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> l(g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.m.3

            /* renamed from: com.kwad.components.ad.reward.m$3$1 */
            public class AnonymousClass1 extends bd {
                final /* synthetic */ RewardCallBackRespInfo rL;

                public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (rewardCallBackRespInfo.result == 1) {
                        g.this.qE = 1;
                    } else {
                        g.this.qE = 2;
                    }
                    g.this.f11688qe.onRewardVerify();
                }
            }

            /* renamed from: com.kwad.components.ad.reward.m$3$2 */
            public class AnonymousClass2 extends bd {
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    g.this.qE = 2;
                }
            }

            public AnonymousClass3() {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
                eVar.TY = System.currentTimeMillis();
                com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.m.3.1
                    final /* synthetic */ RewardCallBackRespInfo rL;

                    public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                        rewardCallBackRespInfo = rewardCallBackRespInfo2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        if (rewardCallBackRespInfo.result == 1) {
                            g.this.qE = 1;
                        } else {
                            g.this.qE = 2;
                        }
                        g.this.f11688qe.onRewardVerify();
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.TY, rewardCallBackRespInfo2.result, rewardCallBackRespInfo2.errorMsg);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
                super.onError(eVar, i10, str);
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.m.3.2
                    public AnonymousClass2() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        g.this.qE = 2;
                    }
                });
                com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.TY, i10, str);
            }
        };
    }

    private static boolean m(g gVar) {
        return !gVar.qF && com.kwad.sdk.core.response.b.a.dh(com.kwad.sdk.core.response.b.e.eb(gVar.mAdTemplate));
    }

    /* renamed from: com.kwad.components.ad.reward.m$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> {

        /* renamed from: com.kwad.components.ad.reward.m$2$1 */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ RewardCallBackRespInfo rL;

            public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                rewardCallBackRespInfo = rewardCallBackRespInfo2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }
        }

        /* renamed from: com.kwad.components.ad.reward.m$2$2 */
        public class RunnableC03992 implements Runnable {
            public RunnableC03992() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                g.this.mCheckExposureResult = false;
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
            eVar.TY = System.currentTimeMillis();
            com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 1);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo2) {
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.1
                final /* synthetic */ RewardCallBackRespInfo rL;

                public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo22) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
                }
            });
            com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.TY, rewardCallBackRespInfo22.result, rewardCallBackRespInfo22.errorMsg);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
            super.onError(eVar, i10, str);
            bt.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.m.2.2
                public RunnableC03992() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    g.this.mCheckExposureResult = false;
                }
            });
            com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 1, System.currentTimeMillis() - eVar.TY, i10, str);
        }
    }

    /* renamed from: com.kwad.components.ad.reward.m$3 */
    public class AnonymousClass3 extends com.kwad.sdk.core.network.o<com.kwad.components.core.request.e, RewardCallBackRespInfo> {

        /* renamed from: com.kwad.components.ad.reward.m$3$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ RewardCallBackRespInfo rL;

            public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo2) {
                rewardCallBackRespInfo = rewardCallBackRespInfo2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                if (rewardCallBackRespInfo.result == 1) {
                    g.this.qE = 1;
                } else {
                    g.this.qE = 2;
                }
                g.this.f11688qe.onRewardVerify();
            }
        }

        /* renamed from: com.kwad.components.ad.reward.m$3$2 */
        public class AnonymousClass2 extends bd {
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                g.this.qE = 2;
            }
        }

        public AnonymousClass3() {
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onStartRequest(@NonNull com.kwad.components.core.request.e eVar) {
            eVar.TY = System.currentTimeMillis();
            com.kwad.components.ad.reward.check.a.b(g.this.mAdTemplate, 2);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onSuccess(@NonNull com.kwad.components.core.request.e eVar, @NonNull RewardCallBackRespInfo rewardCallBackRespInfo2) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.m.3.1
                final /* synthetic */ RewardCallBackRespInfo rL;

                public AnonymousClass1(RewardCallBackRespInfo rewardCallBackRespInfo22) {
                    rewardCallBackRespInfo = rewardCallBackRespInfo22;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    if (rewardCallBackRespInfo.result == 1) {
                        g.this.qE = 1;
                    } else {
                        g.this.qE = 2;
                    }
                    g.this.f11688qe.onRewardVerify();
                }
            });
            com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.TY, rewardCallBackRespInfo22.result, rewardCallBackRespInfo22.errorMsg);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull com.kwad.components.core.request.e eVar, int i10, String str) {
            super.onError(eVar, i10, str);
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.reward.m.3.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    g.this.qE = 2;
                }
            });
            com.kwad.components.ad.reward.check.a.a(g.this.mAdTemplate, 2, System.currentTimeMillis() - eVar.TY, i10, str);
        }
    }
}
