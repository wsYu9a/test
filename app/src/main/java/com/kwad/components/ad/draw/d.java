package com.kwad.components.ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.k;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: com.kwad.components.ad.draw.d$1 */
    static class AnonymousClass1 extends com.kwad.components.core.n.c {

        /* renamed from: com.kwad.components.ad.draw.d$1$1 */
        final class RunnableC01211 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01211(int i2, String str) {
                i2 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                KsLoadManager.DrawAdListener.this.onError(i2, str);
            }
        }

        /* renamed from: com.kwad.components.ad.draw.d$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ List cn;

            AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // java.lang.Runnable
            public final void run() {
                KsAdLoadManager.ac().b(arrayList);
                KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
            }
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                    arrayList.add(new c(adTemplate));
                }
            }
            if (!arrayList.isEmpty()) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.2
                    final /* synthetic */ List cn;

                    AnonymousClass2(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        KsAdLoadManager.ac().b(arrayList);
                        KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                    }
                });
                return;
            }
            onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg + "(无视频资源)" : adResultData.testErrorMsg);
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01211(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    KsLoadManager.DrawAdListener.this.onError(i2, str);
                }
            });
        }
    }

    public static void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = k.pP().a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0180a().e(new com.kwad.components.core.n.kwai.b(covert)).aH(a2).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.draw.d.1

            /* renamed from: com.kwad.components.ad.draw.d$1$1 */
            final class RunnableC01211 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01211(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    KsLoadManager.DrawAdListener.this.onError(i2, str);
                }
            }

            /* renamed from: com.kwad.components.ad.draw.d$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ List cn;

                AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    KsAdLoadManager.ac().b(arrayList);
                    KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                }
            }

            AnonymousClass1() {
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void a(@NonNull AdResultData adResultData) {
                List arrayList2 = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                        arrayList2.add(new c(adTemplate));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.2
                        final /* synthetic */ List cn;

                        AnonymousClass2(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ac().b(arrayList);
                            KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg + "(无视频资源)" : adResultData.testErrorMsg);
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.draw.d.1.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    RunnableC01211(int i222, String str22) {
                        i2 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        KsLoadManager.DrawAdListener.this.onError(i2, str);
                    }
                });
            }
        }).pj());
    }
}
