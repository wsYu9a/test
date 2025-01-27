package com.kwad.components.core.i;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class a {
    private static int NX = 12;
    private static int NY = 4;
    private static int NZ = 1;

    /* renamed from: com.kwad.components.core.i.a$1 */
    public class AnonymousClass1 extends j {
        final /* synthetic */ int Ng;
        final /* synthetic */ long jv;

        /* renamed from: com.kwad.components.core.i.a$1$1 */
        public class C04311 extends bd {
            final /* synthetic */ int bW;
            final /* synthetic */ String bX;

            public C04311(int i10, String str) {
                i13 = i10;
                str = str;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i13), str));
                InterfaceC0432a.this.onError(i13, str);
            }
        }

        /* renamed from: com.kwad.components.core.i.a$1$2 */
        public class AnonymousClass2 extends bd {
            final /* synthetic */ AdResultData jX;

            public AnonymousClass2(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                try {
                    InterfaceC0432a.this.onRequestResult(adResultData.getAdTemplateList().size());
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                }
            }
        }

        /* renamed from: com.kwad.components.core.i.a$1$3 */
        public class AnonymousClass3 extends bd {
            final /* synthetic */ AdResultData jX;

            public AnonymousClass3(AdResultData adResultData) {
                adResultData = adResultData;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                InterfaceC0432a.this.e(a.b(adResultData.getAdTemplateList(), i12));
                a.a(adResultData, elapsedRealtime);
            }
        }

        public AnonymousClass1(int i10, long j10) {
            i12 = i10;
            elapsedRealtime = j10;
        }

        @Override // com.kwad.components.core.request.k
        public final void b(@NonNull AdResultData adResultData) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.2
                final /* synthetic */ AdResultData jX;

                public AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        InterfaceC0432a.this.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            });
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.3
                final /* synthetic */ AdResultData jX;

                public AnonymousClass3(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    InterfaceC0432a.this.e(a.b(adResultData.getAdTemplateList(), i12));
                    a.a(adResultData, elapsedRealtime);
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(int i10, String str) {
            bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.1
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C04311(int i102, String str2) {
                    i13 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i13), str));
                    InterfaceC0432a.this.onError(i13, str);
                }
            });
        }
    }

    /* renamed from: com.kwad.components.core.i.a$2 */
    public class AnonymousClass2 extends com.kwad.components.core.m.a {
        final /* synthetic */ ImpInfo Du;
        final /* synthetic */ List Oc;
        final /* synthetic */ boolean Od;
        final /* synthetic */ boolean Oe;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ImpInfo impInfo, ImpInfo impInfo2, List list, boolean z10, boolean z11) {
            super(impInfo);
            impInfo = impInfo2;
            list2 = list;
            z13 = z10;
            z14 = z11;
        }

        @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
        @NonNull
        /* renamed from: nD */
        public final com.kwad.components.core.request.a createRequest() {
            com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z13, null);
            aVar.aG(z14 ? 1 : 0);
            return aVar;
        }
    }

    /* renamed from: com.kwad.components.core.i.a$3 */
    public class AnonymousClass3 extends o<com.kwad.components.core.request.a, AdResultData> {
        final /* synthetic */ boolean Of;
        final /* synthetic */ j jZ;

        public AnonymousClass3(boolean z10, j jVar) {
            z15 = z10;
            jVar = jVar;
        }

        private void e(@NonNull AdResultData adResultData) {
            if (!adResultData.isAdResultDataEmpty() || z15) {
                jVar.b(adResultData);
            } else {
                jVar.onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
            }
        }

        private void i(int i10, String str) {
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

    /* renamed from: com.kwad.components.core.i.a$a */
    public interface InterfaceC0432a {
        void e(@Nullable List<c> list);

        void onError(int i10, String str);

        void onRequestResult(int i10);
    }

    public static void a(@NonNull SceneImpl sceneImpl, InterfaceC0432a interfaceC0432a) {
        a(15, NY, sceneImpl, e.AGGREGATION, interfaceC0432a);
    }

    private static void a(int i10, int i11, @NonNull SceneImpl sceneImpl, int i12, InterfaceC0432a interfaceC0432a) {
        SceneImpl m40clone = sceneImpl.m40clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m40clone.setAdStyle(i10);
        m40clone.setAdNum(i11);
        a(new ImpInfo(m40clone), null, false, true, new j() { // from class: com.kwad.components.core.i.a.1
            final /* synthetic */ int Ng;
            final /* synthetic */ long jv;

            /* renamed from: com.kwad.components.core.i.a$1$1 */
            public class C04311 extends bd {
                final /* synthetic */ int bW;
                final /* synthetic */ String bX;

                public C04311(int i102, String str2) {
                    i13 = i102;
                    str = str2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i13), str));
                    InterfaceC0432a.this.onError(i13, str);
                }
            }

            /* renamed from: com.kwad.components.core.i.a$1$2 */
            public class AnonymousClass2 extends bd {
                final /* synthetic */ AdResultData jX;

                public AnonymousClass2(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    try {
                        InterfaceC0432a.this.onRequestResult(adResultData.getAdTemplateList().size());
                    } catch (Throwable th2) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                    }
                }
            }

            /* renamed from: com.kwad.components.core.i.a$1$3 */
            public class AnonymousClass3 extends bd {
                final /* synthetic */ AdResultData jX;

                public AnonymousClass3(AdResultData adResultData2) {
                    adResultData = adResultData2;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    InterfaceC0432a.this.e(a.b(adResultData.getAdTemplateList(), i12));
                    a.a(adResultData, elapsedRealtime);
                }
            }

            public AnonymousClass1(int i122, long elapsedRealtime2) {
                i12 = i122;
                elapsedRealtime = elapsedRealtime2;
            }

            @Override // com.kwad.components.core.request.k
            public final void b(@NonNull AdResultData adResultData2) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.2
                    final /* synthetic */ AdResultData jX;

                    public AnonymousClass2(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        try {
                            InterfaceC0432a.this.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th2) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
                        }
                    }
                });
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.3
                    final /* synthetic */ AdResultData jX;

                    public AnonymousClass3(AdResultData adResultData22) {
                        adResultData = adResultData22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        InterfaceC0432a.this.e(a.b(adResultData.getAdTemplateList(), i12));
                        a.a(adResultData, elapsedRealtime);
                    }
                });
            }

            @Override // com.kwad.components.core.request.k
            public final void onError(int i102, String str2) {
                bt.runOnUiThread(new bd() { // from class: com.kwad.components.core.i.a.1.1
                    final /* synthetic */ int bW;
                    final /* synthetic */ String bX;

                    public C04311(int i1022, String str22) {
                        i13 = i1022;
                        str = str22;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.w("RefluxAdLoadManager", "loadInnerAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i13), str));
                        InterfaceC0432a.this.onError(i13, str);
                    }
                });
            }
        }, false);
    }

    public static void b(@NonNull SceneImpl sceneImpl, InterfaceC0432a interfaceC0432a) {
        a(17, NZ, sceneImpl, e.Oj, interfaceC0432a);
    }

    public static List<c> b(List<AdTemplate> list, int i10) {
        ArrayList arrayList = new ArrayList();
        Iterator<AdTemplate> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new c(it.next(), i10));
        }
        return arrayList;
    }

    public static void a(AdResultData adResultData, long j10) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.ri().g(adTemplate, elapsedRealtime - j10);
    }

    private static void a(ImpInfo impInfo, List<String> list, boolean z10, boolean z11, @NonNull j jVar, boolean z12) {
        new com.kwad.components.core.m.a(impInfo) { // from class: com.kwad.components.core.i.a.2
            final /* synthetic */ ImpInfo Du;
            final /* synthetic */ List Oc;
            final /* synthetic */ boolean Od;
            final /* synthetic */ boolean Oe;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(ImpInfo impInfo2, ImpInfo impInfo22, List list2, boolean z102, boolean z112) {
                super(impInfo22);
                impInfo = impInfo22;
                list2 = list2;
                z13 = z102;
                z14 = z112;
            }

            @Override // com.kwad.components.core.m.a, com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: nD */
            public final com.kwad.components.core.request.a createRequest() {
                com.kwad.components.core.request.a aVar = new com.kwad.components.core.request.a(impInfo, list2, z13, null);
                aVar.aG(z14 ? 1 : 0);
                return aVar;
            }
        }.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.core.i.a.3
            final /* synthetic */ boolean Of;
            final /* synthetic */ j jZ;

            public AnonymousClass3(boolean z102, j jVar2) {
                z15 = z102;
                jVar = jVar2;
            }

            private void e(@NonNull AdResultData adResultData) {
                if (!adResultData.isAdResultDataEmpty() || z15) {
                    jVar.b(adResultData);
                } else {
                    jVar.onError(com.kwad.sdk.core.network.e.azA.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.azA.msg : adResultData.testErrorMsg);
                }
            }

            private void i(int i10, String str) {
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
}
