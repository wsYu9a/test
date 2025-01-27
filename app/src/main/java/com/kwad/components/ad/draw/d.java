package com.kwad.components.ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: com.kwad.components.ad.draw.d$1 */
    public class AnonymousClass1 extends com.kwad.components.core.request.d {

        /* renamed from: com.kwad.components.ad.draw.d$1$1 */
        public class C03661 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C03661(int i10, String str) {
                i10 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                KsLoadManager.DrawAdListener.this.onError(i10, str);
            }
        }

        /* renamed from: com.kwad.components.ad.draw.d$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ List du;

            public AnonymousClass2(List list) {
                arrayList = list;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                KsAdLoadManager.M().b(arrayList);
                KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate)))) {
                    arrayList.add(new c(adTemplate));
                }
            }
            if (!arrayList.isEmpty()) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.draw.d.1.2
                    final /* synthetic */ List du;

                    public AnonymousClass2(List arrayList2) {
                        arrayList = arrayList2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                    }
                });
                return;
            }
            onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg + "(无视频资源)" : adResultData.testErrorMsg);
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.draw.d.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03661(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.DrawAdListener.this.onError(i10, str);
                }
            });
        }
    }

    public static void loadDrawAd(KsScene ksScene, @NonNull KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a10 = m.si().a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.M().a(new a.C0445a().e(new ImpInfo(covert)).aK(a10).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1

            /* renamed from: com.kwad.components.ad.draw.d$1$1 */
            public class C03661 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C03661(int i102, String str2) {
                    i10 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                    KsLoadManager.DrawAdListener.this.onError(i10, str);
                }
            }

            /* renamed from: com.kwad.components.ad.draw.d$1$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ List du;

                public AnonymousClass2(List arrayList2) {
                    arrayList = arrayList2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    KsAdLoadManager.M().b(arrayList);
                    KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void b(@NonNull AdResultData adResultData) {
                List arrayList2 = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(e.eb(adTemplate)))) {
                        arrayList2.add(new c(adTemplate));
                    }
                }
                if (!arrayList2.isEmpty()) {
                    bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.draw.d.1.2
                        final /* synthetic */ List du;

                        public AnonymousClass2(List arrayList22) {
                            arrayList = arrayList22;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            KsAdLoadManager.M().b(arrayList);
                            KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                        }
                    });
                    return;
                }
                onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg + "(无视频资源)" : adResultData.testErrorMsg);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.ad.draw.d.1.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public C03661(int i1022, String str22) {
                        i10 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i10), str));
                        KsLoadManager.DrawAdListener.this.onError(i10, str);
                    }
                });
            }
        }).rA());
    }
}
