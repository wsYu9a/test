package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    private volatile boolean jS;
    private l<com.kwad.components.core.request.a, AdResultData> jT;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1 */
    public class AnonymousClass1 extends j {
        final /* synthetic */ SceneImpl bV;
        final /* synthetic */ b jU;
        final /* synthetic */ long jv;

        /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$1 */
        public class C03781 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C03781(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ AdResultData jX;

            /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2$1 */
            public class C03791 extends bd {
                final /* synthetic */ List du;

                public C03791(List list) {
                    arrayList = list;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    AnonymousClass1.this.jU.onInterstitialAdLoad(arrayList);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    c cVar = c.this;
                    c.a(adResultData, anonymousClass1.jv);
                }
            }

            public AnonymousClass2(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = AnonymousClass1.this.bV;
                        }
                        arrayList.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                    }
                }
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                    final /* synthetic */ List du;

                    public C03791(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        AnonymousClass1.this.jU.onInterstitialAdLoad(arrayList);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c cVar = c.this;
                        c.a(adResultData, anonymousClass1.jv);
                    }
                });
            }
        }

        public AnonymousClass1(SceneImpl sceneImpl, b bVar, long j10) {
            this.bV = sceneImpl;
            this.jU = bVar;
            this.jv = j10;
        }

        @Override // com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                final /* synthetic */ AdResultData jX;

                /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2$1 */
                public class C03791 extends bd {
                    final /* synthetic */ List du;

                    public C03791(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        AnonymousClass1.this.jU.onInterstitialAdLoad(arrayList);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c cVar = c.this;
                        c.a(adResultData, anonymousClass1.jv);
                    }
                }

                public AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    List arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.bV;
                            }
                            arrayList2.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                        }
                    }
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        final /* synthetic */ List du;

                        public C03791(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            AnonymousClass1.this.jU.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.jv);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03781(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$2 */
    public class AnonymousClass2 extends o<com.kwad.components.core.request.a, AdResultData> {
        final /* synthetic */ j jZ;

        public AnonymousClass2(j jVar) {
            jVar = jVar;
        }

        private void e(@NonNull AdResultData adResultData) {
            c.a(c.this, false);
            if (adResultData.isAdResultDataEmpty()) {
                jVar.onError(e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.azA.msg : adResultData.testErrorMsg);
            } else {
                jVar.b(adResultData);
            }
        }

        private void i(int i10, String str) {
            c.a(c.this, false);
            jVar.onError(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
            i(i10, str);
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
            e((AdResultData) baseResultData);
        }
    }

    public static class a {

        /* renamed from: ka */
        private static c f11581ka = new c((byte) 0);
    }

    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c cT() {
        return a.f11581ka;
    }

    public final void release() {
        l<com.kwad.components.core.request.a, AdResultData> lVar = this.jT;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private c() {
        this.jS = false;
    }

    public static /* synthetic */ boolean a(c cVar, boolean z10) {
        cVar.jS = false;
        return false;
    }

    public final void a(int i10, int i11, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.jS) {
            return;
        }
        SceneImpl m40clone = sceneImpl.m40clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m40clone.setAdStyle(16);
        m40clone.setAdNum(i11);
        a(new ImpInfo(m40clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    private void a(ImpInfo impInfo, @NonNull j jVar) {
        com.kwad.components.core.m.a aVar = new com.kwad.components.core.m.a(impInfo);
        this.jT = aVar;
        aVar.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            final /* synthetic */ j jZ;

            public AnonymousClass2(j jVar2) {
                jVar = jVar2;
            }

            private void e(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    jVar.onError(e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.azA.msg : adResultData.testErrorMsg);
                } else {
                    jVar.b(adResultData);
                }
            }

            private void i(int i10, String str) {
                c.a(c.this, false);
                jVar.onError(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i10, String str) {
                i(i10, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                e((AdResultData) baseResultData);
            }
        });
    }

    public static void a(AdResultData adResultData, long j10) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.ri().g(adTemplate, elapsedRealtime - j10);
    }
}
