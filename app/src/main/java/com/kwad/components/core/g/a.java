package com.kwad.components.core.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.n.h;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    private static int Jv = 12;
    private static int Jw = 4;
    private static int Jx = 1;

    /* renamed from: com.kwad.components.core.g.a$1 */
    static class AnonymousClass1 extends h {
        final /* synthetic */ int Jl;
        final /* synthetic */ long hR;

        /* renamed from: com.kwad.components.core.g.a$1$1 */
        final class RunnableC01751 implements Runnable {
            final /* synthetic */ int ck;
            final /* synthetic */ String cl;

            RunnableC01751(int i2, String str) {
                i5 = i2;
                str = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i5), str));
                InterfaceC0176a.this.onError(i5, str);
            }
        }

        /* renamed from: com.kwad.components.core.g.a$1$2 */
        final class AnonymousClass2 implements Runnable {
            final /* synthetic */ AdResultData iv;

            AnonymousClass2(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    InterfaceC0176a.this.onRequestResult(adResultData.getAdTemplateList().size());
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                }
            }
        }

        /* renamed from: com.kwad.components.core.g.a$1$3 */
        final class AnonymousClass3 implements Runnable {
            final /* synthetic */ AdResultData iv;

            AnonymousClass3(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // java.lang.Runnable
            public final void run() {
                InterfaceC0176a.this.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i4));
                a.a(adResultData, elapsedRealtime);
            }
        }

        AnonymousClass1(int i2, long j2) {
            i4 = i2;
            elapsedRealtime = j2;
        }

        @Override // com.kwad.components.core.n.i
        public final void a(@NonNull AdResultData adResultData) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.2
                final /* synthetic */ AdResultData iv;

                AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        InterfaceC0176a.this.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            });
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.3
                final /* synthetic */ AdResultData iv;

                AnonymousClass3(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC0176a.this.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i4));
                    a.a(adResultData, elapsedRealtime);
                }
            });
        }

        @Override // com.kwad.components.core.n.i
        public final void onError(int i2, String str) {
            bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.1
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01751(int i22, String str2) {
                    i5 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i5), str));
                    InterfaceC0176a.this.onError(i5, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.g.a$2 */
    static class AnonymousClass2 extends com.kwad.components.core.k.a {
        final /* synthetic */ com.kwad.components.core.n.kwai.b Bk;
        final /* synthetic */ List JA;
        final /* synthetic */ boolean JB;
        final /* synthetic */ boolean JC;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.b bVar2, List list, boolean z, boolean z2) {
            super(bVar);
            bVar = bVar2;
            list2 = list;
            z4 = z;
            z5 = z2;
        }

        @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: mc */
        public final com.kwad.components.core.n.a createRequest() {
            com.kwad.components.core.n.a aVar = new com.kwad.components.core.n.a(bVar, list2, z4, null);
            aVar.aD(z5 ? 1 : 0);
            return aVar;
        }
    }

    /* renamed from: com.kwad.components.core.g.a$3 */
    static class AnonymousClass3 extends p<com.kwad.components.core.n.a, AdResultData> {
        final /* synthetic */ boolean JD;
        final /* synthetic */ h ix;

        AnonymousClass3(boolean z, h hVar) {
            z6 = z;
            hVar = hVar;
        }

        private void b(@NonNull AdResultData adResultData) {
            if (!adResultData.isAdResultDataEmpty() || z6) {
                hVar.a(adResultData);
            } else {
                hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
            }
        }

        private void e(int i2, String str) {
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

    /* renamed from: com.kwad.components.core.g.a$a */
    public interface InterfaceC0176a {
        void onError(int i2, String str);

        void onInnerAdLoad(@Nullable List<c> list);

        void onRequestResult(int i2);
    }

    private static void a(int i2, int i3, @NonNull SceneImpl sceneImpl, int i4, InterfaceC0176a interfaceC0176a) {
        SceneImpl m61clone = sceneImpl.m61clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m61clone.setAdStyle(i2);
        m61clone.setAdNum(i3);
        a(new com.kwad.components.core.n.kwai.b(m61clone), null, false, true, new h() { // from class: com.kwad.components.core.g.a.1
            final /* synthetic */ int Jl;
            final /* synthetic */ long hR;

            /* renamed from: com.kwad.components.core.g.a$1$1 */
            final class RunnableC01751 implements Runnable {
                final /* synthetic */ int ck;
                final /* synthetic */ String cl;

                RunnableC01751(int i22, String str2) {
                    i5 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i5), str));
                    InterfaceC0176a.this.onError(i5, str);
                }
            }

            /* renamed from: com.kwad.components.core.g.a$1$2 */
            final class AnonymousClass2 implements Runnable {
                final /* synthetic */ AdResultData iv;

                AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        InterfaceC0176a.this.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                    }
                }
            }

            /* renamed from: com.kwad.components.core.g.a$1$3 */
            final class AnonymousClass3 implements Runnable {
                final /* synthetic */ AdResultData iv;

                AnonymousClass3(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC0176a.this.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i4));
                    a.a(adResultData, elapsedRealtime);
                }
            }

            AnonymousClass1(int i42, long elapsedRealtime2) {
                i4 = i42;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.n.i
            public final void a(@NonNull AdResultData adResultData2) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.2
                    final /* synthetic */ AdResultData iv;

                    AnonymousClass2(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            InterfaceC0176a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.3
                    final /* synthetic */ AdResultData iv;

                    AnonymousClass3(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        InterfaceC0176a.this.onInnerAdLoad(a.b(adResultData.getAdTemplateList(), i4));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.n.i
            public final void onError(int i22, String str2) {
                bi.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.g.a.1.1
                    final /* synthetic */ int ck;
                    final /* synthetic */ String cl;

                    RunnableC01751(int i222, String str22) {
                        i5 = i222;
                        str = str22;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i5), str));
                        InterfaceC0176a.this.onError(i5, str);
                    }
                });
            }
        }, false);
    }

    private static void a(com.kwad.components.core.n.kwai.b bVar, List<String> list, boolean z, boolean z2, @NonNull h hVar, boolean z3) {
        new com.kwad.components.core.k.a(bVar) { // from class: com.kwad.components.core.g.a.2
            final /* synthetic */ com.kwad.components.core.n.kwai.b Bk;
            final /* synthetic */ List JA;
            final /* synthetic */ boolean JB;
            final /* synthetic */ boolean JC;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(com.kwad.components.core.n.kwai.b bVar2, com.kwad.components.core.n.kwai.b bVar22, List list2, boolean z4, boolean z22) {
                super(bVar22);
                bVar = bVar22;
                list2 = list2;
                z4 = z4;
                z5 = z22;
            }

            @Override // com.kwad.components.core.k.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: mc */
            public final com.kwad.components.core.n.a createRequest() {
                com.kwad.components.core.n.a aVar = new com.kwad.components.core.n.a(bVar, list2, z4, null);
                aVar.aD(z5 ? 1 : 0);
                return aVar;
            }
        }.request(new p<com.kwad.components.core.n.a, AdResultData>() { // from class: com.kwad.components.core.g.a.3
            final /* synthetic */ boolean JD;
            final /* synthetic */ h ix;

            AnonymousClass3(boolean z4, h hVar2) {
                z6 = z4;
                hVar = hVar2;
            }

            private void b(@NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z6) {
                    hVar.a(adResultData);
                } else {
                    hVar.onError(f.agn.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? f.agn.msg : adResultData.testErrorMsg);
                }
            }

            private void e(int i2, String str) {
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

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0176a interfaceC0176a) {
        a(15, Jw, sceneImpl, e.AGGREGATION, interfaceC0176a);
    }

    public static List<c> b(List<AdTemplate> list, int i2) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i2));
        }
        return arrayList;
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0176a interfaceC0176a) {
        a(17, Jx, sceneImpl, e.JH, interfaceC0176a);
    }
}
