package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: com.kwad.components.ad.feed.e$1 */
    public class AnonymousClass1 extends bd {
        public AnonymousClass1() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
        }
    }

    /* renamed from: com.kwad.components.ad.feed.e$2 */
    public class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl bV;
        final /* synthetic */ KsLoadManager.FeedAdListener fE;
        final /* synthetic */ boolean fF;
        final /* synthetic */ long fG;

        /* renamed from: com.kwad.components.ad.feed.e$2$1 */
        public class AnonymousClass1 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public AnonymousClass1(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                AnonymousClass2.this.fE.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.e$2$2 */
        public class C03702 extends bd {
            final /* synthetic */ List du;

            public C03702(List list) {
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                KsAdLoadManager.M().b(arrayList);
                AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
            }
        }

        /* renamed from: com.kwad.components.ad.feed.e$2$3 */
        public class AnonymousClass3 extends bd {
            final /* synthetic */ List du;

            /* renamed from: com.kwad.components.ad.feed.e$2$3$1 */
            public class AnonymousClass1 implements c.a {
                final /* synthetic */ c fI;
                final /* synthetic */ KsFeedAd fJ;
                final /* synthetic */ int[] fK;
                final /* synthetic */ int fL;
                final /* synthetic */ int fp;
                final /* synthetic */ long fq;

                public AnonymousClass1(c cVar, KsFeedAd ksFeedAd, int i10, long j10, int[] iArr, int i11) {
                    cVar = cVar;
                    ksFeedAd = ksFeedAd;
                    i10 = i10;
                    elapsedRealtime = j10;
                    iArr = iArr;
                    size = i11;
                }

                @Override // com.kwad.components.ad.feed.c.a
                public final void d(int i10, String str) {
                    com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                    com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i10, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                    int[] iArr = iArr;
                    int i11 = iArr[0] + 1;
                    iArr[0] = i11;
                    int i12 = size;
                    if (i11 == i12) {
                        com.kwad.components.ad.feed.monitor.b.a(i12, SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                        KsAdLoadManager.M().b(arrayList);
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                        com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
                    }
                }
            }

            public AnonymousClass3(List list) {
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                int size = arrayList.size();
                int[] iArr = {0};
                for (KsFeedAd ksFeedAd : arrayList) {
                    c cVar = (c) ksFeedAd;
                    com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                    cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                        final /* synthetic */ c fI;
                        final /* synthetic */ KsFeedAd fJ;
                        final /* synthetic */ int[] fK;
                        final /* synthetic */ int fL;
                        final /* synthetic */ int fp;
                        final /* synthetic */ long fq;

                        public AnonymousClass1(c cVar2, KsFeedAd ksFeedAd2, int i10, long j10, int[] iArr2, int size2) {
                            cVar = cVar2;
                            ksFeedAd = ksFeedAd2;
                            i10 = i10;
                            elapsedRealtime = j10;
                            iArr = iArr2;
                            size = size2;
                        }

                        @Override // com.kwad.components.ad.feed.c.a
                        public final void d(int i10, String str) {
                            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                            com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i10, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                            int[] iArr2 = iArr;
                            int i11 = iArr2[0] + 1;
                            iArr2[0] = i11;
                            int i12 = size;
                            if (i11 == i12) {
                                com.kwad.components.ad.feed.monitor.b.a(i12, SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                                KsAdLoadManager.M().b(arrayList);
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                                com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
                            }
                        }
                    });
                }
            }
        }

        public AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z10, long j10) {
            this.fE = feedAdListener;
            this.bV = sceneImpl;
            this.fF = z10;
            this.fG = j10;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.bA();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.bV;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(eb2))) {
                            Pair<Integer, String> h10 = com.kwad.components.ad.feed.monitor.a.h(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.f(((Integer) h10.first).intValue(), (String) h10.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate), this.fF));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.b.a.be(eb2)), FeedType.fromInt(adTemplate.type));
                        com.kwad.components.ad.feed.monitor.b.b(com.kwad.sdk.core.response.b.a.be(eb2), adTemplate.type, adTemplate);
                    }
                }
            }
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.t(arrayList.size());
            if (!arrayList.isEmpty()) {
                com.kwad.sdk.commercial.d.d.a(this.bV, arrayList.size());
                if (!com.kwad.sdk.core.config.d.CW() || (l.At().zB() && !(l.At().zB() && com.kwad.sdk.core.config.d.CX() == 1))) {
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.e.2.3
                        final /* synthetic */ List du;

                        /* renamed from: com.kwad.components.ad.feed.e$2$3$1 */
                        public class AnonymousClass1 implements c.a {
                            final /* synthetic */ c fI;
                            final /* synthetic */ KsFeedAd fJ;
                            final /* synthetic */ int[] fK;
                            final /* synthetic */ int fL;
                            final /* synthetic */ int fp;
                            final /* synthetic */ long fq;

                            public AnonymousClass1(c cVar2, KsFeedAd ksFeedAd2, int i10, long j10, int[] iArr2, int size2) {
                                cVar = cVar2;
                                ksFeedAd = ksFeedAd2;
                                i10 = i10;
                                elapsedRealtime = j10;
                                iArr = iArr2;
                                size = size2;
                            }

                            @Override // com.kwad.components.ad.feed.c.a
                            public final void d(int i10, String str) {
                                com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i10, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str);
                                int[] iArr2 = iArr;
                                int i11 = iArr2[0] + 1;
                                iArr2[0] = i11;
                                int i12 = size;
                                if (i11 == i12) {
                                    com.kwad.components.ad.feed.monitor.b.a(i12, SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                                    KsAdLoadManager.M().b(arrayList);
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                                    com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
                                }
                            }
                        }

                        public AnonymousClass3(List arrayList2) {
                            arrayList = arrayList2;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            int size2 = arrayList.size();
                            int[] iArr2 = {0};
                            for (KsFeedAd ksFeedAd2 : arrayList) {
                                c cVar2 = (c) ksFeedAd2;
                                com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd2);
                                cVar2.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                    final /* synthetic */ c fI;
                                    final /* synthetic */ KsFeedAd fJ;
                                    final /* synthetic */ int[] fK;
                                    final /* synthetic */ int fL;
                                    final /* synthetic */ int fp;
                                    final /* synthetic */ long fq;

                                    public AnonymousClass1(c cVar22, KsFeedAd ksFeedAd22, int i10, long j10, int[] iArr22, int size22) {
                                        cVar = cVar22;
                                        ksFeedAd = ksFeedAd22;
                                        i10 = i10;
                                        elapsedRealtime = j10;
                                        iArr = iArr22;
                                        size = size22;
                                    }

                                    @Override // com.kwad.components.ad.feed.c.a
                                    public final void d(int i10, String str2) {
                                        com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                        com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i10, i10, SystemClock.elapsedRealtime() - elapsedRealtime, str2);
                                        int[] iArr22 = iArr;
                                        int i11 = iArr22[0] + 1;
                                        iArr22[0] = i11;
                                        int i12 = size;
                                        if (i11 == i12) {
                                            com.kwad.components.ad.feed.monitor.b.a(i12, SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                                            KsAdLoadManager.M().b(arrayList);
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                } else {
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.e.2.2
                        final /* synthetic */ List du;

                        public C03702(List arrayList2) {
                            arrayList = arrayList2;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.fG);
                            KsAdLoadManager.M().b(arrayList);
                            AnonymousClass2.this.fE.onFeedAdLoad(arrayList);
                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.bV.getPosId(), (List<KsFeedAd>) arrayList);
                        }
                    });
                    return;
                }
            }
            com.kwad.components.ad.feed.monitor.b.e(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + str);
            onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + str);
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.e.2.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public AnonymousClass1(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    AnonymousClass2.this.fE.onError(i10, str);
                }
            });
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i102), str2));
            com.kwad.components.ad.feed.monitor.b.e(i102, str2);
            if (i102 == com.kwad.sdk.core.network.e.azv.errorCode || i102 == com.kwad.sdk.core.network.e.azA.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.g(i102, str2);
        }
    }

    public static void a(KsScene ksScene, @NonNull KsLoadManager.FeedAdListener feedAdListener, boolean z10) {
        if (!l.At().zE()) {
            com.kwad.sdk.core.d.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.feed.e.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsLoadManager.FeedAdListener.this.onError(com.kwad.sdk.core.network.e.azA.errorCode, com.kwad.sdk.core.network.e.azA.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.s(covert.getAdNum());
        boolean a10 = m.si().a(covert, "loadConfigFeedAd");
        covert.setAdStyle(1);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new AnonymousClass2(feedAdListener, covert, z10, elapsedRealtime)).rA());
    }
}
