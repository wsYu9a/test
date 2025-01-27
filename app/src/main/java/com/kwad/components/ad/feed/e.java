package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$1 */
    static class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, com.kwad.sdk.core.network.f.agn.msg + "sdk not init");
        }
    }

    /* renamed from: com.kwad.components.ad.feed.e$2 */
    static class AnonymousClass2 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.FeedAdListener ek;
        final /* synthetic */ SceneImpl el;
        final /* synthetic */ boolean em;
        final /* synthetic */ long en;

        /* renamed from: com.kwad.components.ad.feed.e$2$1 */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            AnonymousClass1(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                com.kwad.components.ad.feed.monitor.a.d(i2, str);
                AnonymousClass2.this.ek.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.e$2$2 */
        final class RunnableC01272 implements Runnable {
            final /* synthetic */ List cn;

            /* renamed from: com.kwad.components.ad.feed.e$2$2$1 */
            final class AnonymousClass1 implements c.b {
                final /* synthetic */ c ep;
                final /* synthetic */ c.a eq;
                final /* synthetic */ KsFeedAd er;
                final /* synthetic */ long es;

                AnonymousClass1(c cVar, c.a aVar, KsFeedAd ksFeedAd, long j2) {
                    cVar = cVar;
                    aVar = aVar;
                    ksFeedAd = ksFeedAd;
                    elapsedRealtime = j2;
                }

                @Override // com.kwad.components.ad.feed.c.b
                public final void c(int i2, String str) {
                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                    com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i2, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                    if (aVar.ba()) {
                        com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.en);
                        KsAdLoadManager.ac().b(arrayList);
                        RunnableC01272 runnableC01272 = RunnableC01272.this;
                        AnonymousClass2.this.ek.onFeedAdLoad(arrayList);
                    }
                }
            }

            RunnableC01272(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                c.a aVar = new c.a(arrayList.size());
                for (KsFeedAd ksFeedAd : arrayList) {
                    c cVar = (c) ksFeedAd;
                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                    cVar.a(new c.b() { // from class: com.kwad.components.ad.feed.e.2.2.1
                        final /* synthetic */ c ep;
                        final /* synthetic */ c.a eq;
                        final /* synthetic */ KsFeedAd er;
                        final /* synthetic */ long es;

                        AnonymousClass1(c cVar2, c.a aVar2, KsFeedAd ksFeedAd2, long j2) {
                            cVar = cVar2;
                            aVar = aVar2;
                            ksFeedAd = ksFeedAd2;
                            elapsedRealtime = j2;
                        }

                        @Override // com.kwad.components.ad.feed.c.b
                        public final void c(int i2, String str) {
                            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                            com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i2, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                            if (aVar.ba()) {
                                com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.en);
                                KsAdLoadManager.ac().b(arrayList);
                                RunnableC01272 runnableC01272 = RunnableC01272.this;
                                AnonymousClass2.this.ek.onFeedAdLoad(arrayList);
                            }
                        }
                    });
                }
            }
        }

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j2) {
            this.ek = feedAdListener;
            this.el = sceneImpl;
            this.em = z;
            this.en = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adResultData.getAdTemplateList().size());
            String str = null;
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.el;
                        arrayList.add(new c(adTemplate, this.em));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.aW(cb)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.a.x(arrayList.size());
            if (!arrayList.isEmpty()) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "dataReady").bw(arrayList.size()).report();
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.2
                    final /* synthetic */ List cn;

                    /* renamed from: com.kwad.components.ad.feed.e$2$2$1 */
                    final class AnonymousClass1 implements c.b {
                        final /* synthetic */ c ep;
                        final /* synthetic */ c.a eq;
                        final /* synthetic */ KsFeedAd er;
                        final /* synthetic */ long es;

                        AnonymousClass1(c cVar2, c.a aVar2, KsFeedAd ksFeedAd2, long j2) {
                            cVar = cVar2;
                            aVar = aVar2;
                            ksFeedAd = ksFeedAd2;
                            elapsedRealtime = j2;
                        }

                        @Override // com.kwad.components.ad.feed.c.b
                        public final void c(int i2, String str) {
                            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                            com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i2, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                            if (aVar.ba()) {
                                com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.en);
                                KsAdLoadManager.ac().b(arrayList);
                                RunnableC01272 runnableC01272 = RunnableC01272.this;
                                AnonymousClass2.this.ek.onFeedAdLoad(arrayList);
                            }
                        }
                    }

                    RunnableC01272(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        c.a aVar2 = new c.a(arrayList.size());
                        for (KsFeedAd ksFeedAd2 : arrayList) {
                            c cVar2 = (c) ksFeedAd2;
                            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd2);
                            cVar2.a(new c.b() { // from class: com.kwad.components.ad.feed.e.2.2.1
                                final /* synthetic */ c ep;
                                final /* synthetic */ c.a eq;
                                final /* synthetic */ KsFeedAd er;
                                final /* synthetic */ long es;

                                AnonymousClass1(c cVar22, c.a aVar22, KsFeedAd ksFeedAd22, long j2) {
                                    cVar = cVar22;
                                    aVar = aVar22;
                                    ksFeedAd = ksFeedAd22;
                                    elapsedRealtime = j2;
                                }

                                @Override // com.kwad.components.ad.feed.c.b
                                public final void c(int i2, String str2) {
                                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                                    com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i2, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                    if (aVar.ba()) {
                                        com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.en);
                                        KsAdLoadManager.ac().b(arrayList);
                                        RunnableC01272 runnableC01272 = RunnableC01272.this;
                                        AnonymousClass2.this.ek.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            com.kwad.components.ad.feed.monitor.a.d(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg + str : adResultData.testErrorMsg);
            onError(com.kwad.sdk.core.network.f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.f.agn.msg + str : adResultData.testErrorMsg);
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                AnonymousClass1(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    com.kwad.components.ad.feed.monitor.a.d(i2, str);
                    AnonymousClass2.this.ek.onError(i2, str);
                }
            });
        }
    }

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.f.agn.errorCode, com.kwad.sdk.core.network.f.agn.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.a.w(covert.getAdNum());
        boolean a2 = k.pP().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new AnonymousClass2(feedAdListener, covert, z, elapsedRealtime)).pj());
    }
}
