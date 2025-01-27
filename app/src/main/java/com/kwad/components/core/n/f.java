package com.kwad.components.core.n;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.x;
import com.kwad.sdk.utils.y;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class f {
    private static volatile boolean On = false;
    private static volatile boolean Oo = false;
    private static Context Op;
    private static final List<a> Oq = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.n.f$1 */
    static class AnonymousClass1 implements a {
        AnonymousClass1() {
        }

        @Override // com.kwad.components.core.n.f.a
        public final void a(@NonNull SdkConfigData sdkConfigData) {
        }

        @Override // com.kwad.components.core.n.f.a
        public final void nP() {
            try {
                Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.adN.getValue());
                for (String str : parseJSON2MapString.keySet()) {
                    GlobalThreadPools.m(str, Integer.parseInt(parseJSON2MapString.get(str)));
                }
                GlobalThreadPools.xK();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
        }
    }

    /* renamed from: com.kwad.components.core.n.f$2 */
    static class AnonymousClass2 extends aw {
        AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            y.j(f.Op, y.bR(f.Op) + 1);
            com.kwad.sdk.core.config.d.aH(f.Op);
            for (a aVar : f.Oq) {
                if (aVar != null) {
                    aVar.nP();
                }
            }
            f.pg();
        }
    }

    /* renamed from: com.kwad.components.core.n.f$3 */
    static class AnonymousClass3 extends m<e, SdkConfigData> {
        AnonymousClass3() {
        }

        @NonNull
        private static SdkConfigData ay(String str) {
            y.ac(f.Op, str);
            JSONObject jSONObject = new JSONObject(str);
            SdkConfigData sdkConfigData = new SdkConfigData();
            sdkConfigData.parseJson(jSONObject);
            try {
                com.kwad.sdk.core.config.d.sv();
                com.kwad.sdk.core.config.d.tZ();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            return sdkConfigData;
        }

        @NonNull
        private static e pi() {
            return new e();
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
            return pi();
        }

        @Override // com.kwad.sdk.core.network.m
        @NonNull
        public final /* synthetic */ SdkConfigData parseData(String str) {
            return ay(str);
        }
    }

    /* renamed from: com.kwad.components.core.n.f$4 */
    static class AnonymousClass4 extends p<e, SdkConfigData> {
        AnonymousClass4() {
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onStartRequest(@NonNull e eVar) {
            com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onStartRequest request url = " + eVar.getUrl());
            super.onStartRequest(eVar);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        /* renamed from: a */
        public void onError(@NonNull e eVar, int i2, String str) {
            super.onError(eVar, i2, str);
            com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
        }

        private static void b(@NonNull SdkConfigData sdkConfigData) {
            com.kwad.sdk.core.config.b.aF(f.Op);
            com.kwad.sdk.core.config.d.c(sdkConfigData);
            f.aF(true);
            for (a aVar : f.Oq) {
                if (aVar != null) {
                    aVar.a(sdkConfigData);
                }
            }
            if (sdkConfigData != null) {
                com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
            }
            x.Dl();
            x.Df();
            y.j(f.Op, 0);
        }

        @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
            b((SdkConfigData) baseResultData);
        }
    }

    public interface a {
        void a(@NonNull SdkConfigData sdkConfigData);

        void nP();
    }

    public static synchronized void a(Context context, a aVar) {
        synchronized (f.class) {
            if (On) {
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "config request manager has init-ed");
                return;
            }
            On = true;
            Op = context;
            List<a> list = Oq;
            list.add(aVar);
            list.add(new a() { // from class: com.kwad.components.core.n.f.1
                AnonymousClass1() {
                }

                @Override // com.kwad.components.core.n.f.a
                public final void a(@NonNull SdkConfigData sdkConfigData) {
                }

                @Override // com.kwad.components.core.n.f.a
                public final void nP() {
                    try {
                        Map<String, String> parseJSON2MapString = u.parseJSON2MapString(com.kwad.sdk.core.config.c.adN.getValue());
                        for (String str : parseJSON2MapString.keySet()) {
                            GlobalThreadPools.m(str, Integer.parseInt(parseJSON2MapString.get(str)));
                        }
                        GlobalThreadPools.xK();
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.printStackTrace(th);
                    }
                }
            });
            com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.components.core.n.f.2
                AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.aw
                public final void doTask() {
                    y.j(f.Op, y.bR(f.Op) + 1);
                    com.kwad.sdk.core.config.d.aH(f.Op);
                    for (a aVar2 : f.Oq) {
                        if (aVar2 != null) {
                            aVar2.nP();
                        }
                    }
                    f.pg();
                }
            });
        }
    }

    public static void a(a aVar) {
        Oq.add(aVar);
        if (isLoaded()) {
            aVar.nP();
        }
        if (Oo) {
            aVar.a(com.kwad.sdk.core.config.d.uu());
        }
    }

    static /* synthetic */ boolean aF(boolean z) {
        Oo = true;
        return true;
    }

    private static boolean isLoaded() {
        return com.kwad.sdk.core.config.d.isLoaded();
    }

    public static void pg() {
        com.kwad.sdk.core.d.b.d("ConfigRequestManager", "load()");
        new m<e, SdkConfigData>() { // from class: com.kwad.components.core.n.f.3
            AnonymousClass3() {
            }

            @NonNull
            private static SdkConfigData ay(String str) {
                y.ac(f.Op, str);
                JSONObject jSONObject = new JSONObject(str);
                SdkConfigData sdkConfigData = new SdkConfigData();
                sdkConfigData.parseJson(jSONObject);
                try {
                    com.kwad.sdk.core.config.d.sv();
                    com.kwad.sdk.core.config.d.tZ();
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.b.printStackTrace(th);
                }
                return sdkConfigData;
            }

            @NonNull
            private static e pi() {
                return new e();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.g createRequest() {
                return pi();
            }

            @Override // com.kwad.sdk.core.network.m
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return ay(str);
            }
        }.request(new p<e, SdkConfigData>() { // from class: com.kwad.components.core.n.f.4
            AnonymousClass4() {
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onStartRequest(@NonNull e eVar) {
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onStartRequest request url = " + eVar.getUrl());
                super.onStartRequest(eVar);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            /* renamed from: a */
            public void onError(@NonNull e eVar, int i2, String str) {
                super.onError(eVar, i2, str);
                com.kwad.sdk.core.d.b.d("ConfigRequestManager", "onError errorCode=" + i2 + " errorMsg=" + str);
            }

            private static void b(@NonNull SdkConfigData sdkConfigData) {
                com.kwad.sdk.core.config.b.aF(f.Op);
                com.kwad.sdk.core.config.d.c(sdkConfigData);
                f.aF(true);
                for (a aVar : f.Oq) {
                    if (aVar != null) {
                        aVar.a(sdkConfigData);
                    }
                }
                if (sdkConfigData != null) {
                    com.kwad.sdk.ip.direct.a.a(sdkConfigData.httpDnsInfo);
                }
                x.Dl();
                x.Df();
                y.j(f.Op, 0);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.g gVar, @NonNull BaseResultData baseResultData) {
                b((SdkConfigData) baseResultData);
            }
        });
    }
}
