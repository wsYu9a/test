package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.n.h;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class c {
    private volatile boolean iq;
    private m<com.kwad.components.core.n.a, AdResultData> ir;

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1 */
    final class AnonymousClass1 extends h {
        final /* synthetic */ SceneImpl el;
        final /* synthetic */ long hR;
        final /* synthetic */ b is;

        /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$1 */
        final class RunnableC01341 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01341(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
            }
        }

        /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ AdResultData iv;

            /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2$1 */
            final class RunnableC01351 implements Runnable {
                final /* synthetic */ List cn;

                RunnableC01351(List list) {
                    arrayList = list;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.is.onInterstitialAdLoad(arrayList);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    c cVar = c.this;
                    c.a(adResultData, anonymousClass1.hR);
                }
            }

            AnonymousClass2(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = AnonymousClass1.this.el;
                        }
                        arrayList.add(adTemplate);
                    }
                }
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                    final /* synthetic */ List cn;

                    RunnableC01351(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.is.onInterstitialAdLoad(arrayList);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c cVar = c.this;
                        c.a(adResultData, anonymousClass1.hR);
                    }
                });
            }
        }

        AnonymousClass1(SceneImpl sceneImpl, b bVar, long j2) {
            this.el = sceneImpl;
            this.is = bVar;
            this.hR = j2;
        }

        @Override // com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                final /* synthetic */ AdResultData iv;

                /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1$2$1 */
                final class RunnableC01351 implements Runnable {
                    final /* synthetic */ List cn;

                    RunnableC01351(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.is.onInterstitialAdLoad(arrayList);
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        c cVar = c.this;
                        c.a(adResultData, anonymousClass1.hR);
                    }
                }

                AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    List arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.el;
                            }
                            arrayList2.add(adTemplate);
                        }
                    }
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        final /* synthetic */ List cn;

                        RunnableC01351(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass1.this.is.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.hR);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01341(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                }
            });
        }
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$2 */
    final class AnonymousClass2 extends p<com.kwad.components.core.n.a, AdResultData> {
        final /* synthetic */ h ix;

        AnonymousClass2(h hVar) {
            hVar = hVar;
        }

        private void b(@NonNull AdResultData adResultData) {
            c.a(c.this, false);
            if (adResultData.isAdResultDataEmpty()) {
                hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
            } else {
                hVar.a(adResultData);
            }
        }

        private void e(int i2, String str) {
            c.a(c.this, false);
            hVar.onError(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
            e(i2, str);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
            b((AdResultData) baseResultData);
        }
    }

    static class a {
        private static c iy = new c((byte) 0);
    }

    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdTemplate> list);
    }

    private c() {
        this.iq = false;
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private void a(com.kwad.components.core.n.kwai.b bVar, @NonNull h hVar) {
        com.kwad.components.core.k.a aVar = new com.kwad.components.core.k.a(bVar);
        this.ir = aVar;
        aVar.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            final /* synthetic */ h ix;

            AnonymousClass2(h hVar2) {
                hVar = hVar2;
            }

            private void b(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                } else {
                    hVar.a(adResultData);
                }
            }

            private void e(int i2, String str) {
                c.a(c.this, false);
                hVar.onError(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onError(@NonNull g gVar, int i2, String str) {
                e(i2, str);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull g gVar, @NonNull BaseResultData baseResultData) {
                b((AdResultData) baseResultData);
            }
        });
    }

    public static void a(AdResultData adResultData, long j2) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.m.a.pb().c(adTemplate, elapsedRealtime - j2);
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.iq = false;
        return false;
    }

    public static c cA() {
        return a.iy;
    }

    public final void a(int i2, int i3, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.iq) {
            return;
        }
        SceneImpl m61clone = sceneImpl.m61clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m61clone.setAdStyle(16);
        m61clone.setAdNum(i3);
        a(new com.kwad.components.core.n.kwai.b(m61clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    public final void release() {
        m<com.kwad.components.core.n.a, AdResultData> mVar = this.ir;
        if (mVar != null) {
            mVar.cancel();
        }
    }
}
