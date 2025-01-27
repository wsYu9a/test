package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.bd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class g {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean TZ = false;
    private static final List<a> Ua = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.request.g$1 */
    public class AnonymousClass1 extends bd {
        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            Context MA = ServiceProvider.MA();
            ad.l(MA, ad.cs(MA) + 1);
            com.kwad.sdk.core.config.d.bj(MA);
            g.rs();
            g.rr();
        }
    }

    /* renamed from: com.kwad.components.core.request.g$2 */
    public class AnonymousClass2 extends com.kwad.sdk.core.network.l<f, SdkConfigData> {
        @NonNull
        private static SdkConfigData ay(String str) {
            SdkConfigData sdkConfigData = new SdkConfigData();
            try {
                ad.ak(ServiceProvider.MA(), str);
                sdkConfigData.parseJson(new JSONObject(str));
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
            return sdkConfigData;
        }

        @NonNull
        private static f rv() {
            return new f();
        }

        @Override // com.kwad.sdk.core.network.a
        @NonNull
        public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
            return rv();
        }

        @Override // com.kwad.sdk.core.network.l
        @NonNull
        public final /* synthetic */ SdkConfigData parseData(String str) {
            return ay(str);
        }
    }

    /* renamed from: com.kwad.components.core.request.g$3 */
    public class AnonymousClass3 extends o<f, SdkConfigData> {
        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public void onError(@NonNull f fVar, int i10, String str) {
            super.onError(fVar, i10, str);
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i10 + " errorMsg=" + str);
            g.m(i10, str);
        }

        private static void c(@NonNull SdkConfigData sdkConfigData) {
            try {
                com.kwad.sdk.core.d.c.T("ConfigRequestManager", "load config success");
                com.kwad.sdk.core.config.b.bh(ServiceProvider.MA());
                com.kwad.sdk.core.config.d.f(sdkConfigData);
                g.access$102(true);
                g.a(sdkConfigData);
                ac.Np();
                ac.Nj();
                ad.l(ServiceProvider.MA(), 0);
                g.sHasInit.set(true);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }

        @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
            c((SdkConfigData) baseResultData);
        }
    }

    public interface a {
        void d(@NonNull SdkConfigData sdkConfigData);

        void rw();
    }

    public interface b extends a {
        void rx();
    }

    public static synchronized void a(a aVar) {
        synchronized (g.class) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
            if (sHasInit.get()) {
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
            } else {
                Ua.add(aVar);
                com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.core.request.g.1
                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        Context MA = ServiceProvider.MA();
                        ad.l(MA, ad.cs(MA) + 1);
                        com.kwad.sdk.core.config.d.bj(MA);
                        g.rs();
                        g.rr();
                    }
                });
            }
        }
    }

    public static /* synthetic */ boolean access$102(boolean z10) {
        TZ = true;
        return true;
    }

    public static void m(int i10, String str) {
        for (a aVar : Ua) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).rx();
                }
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static void rr() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.2
            @NonNull
            private static SdkConfigData ay(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ad.ak(ServiceProvider.MA(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
                return sdkConfigData;
            }

            @NonNull
            private static f rv() {
                return new f();
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final /* synthetic */ com.kwad.sdk.core.network.f createRequest() {
                return rv();
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return ay(str);
            }
        }.request(new o<f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* renamed from: a */
            public void onError(@NonNull f fVar, int i10, String str) {
                super.onError(fVar, i10, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i10 + " errorMsg=" + str);
                g.m(i10, str);
            }

            private static void c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.T("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bh(ServiceProvider.MA());
                    com.kwad.sdk.core.config.d.f(sdkConfigData);
                    g.access$102(true);
                    g.a(sdkConfigData);
                    ac.Np();
                    ac.Nj();
                    ad.l(ServiceProvider.MA(), 0);
                    g.sHasInit.set(true);
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }
        });
    }

    public static void rs() {
        Iterator<a> it = Ua.iterator();
        while (it.hasNext()) {
            try {
                it.next().rw();
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static void b(a aVar) {
        try {
            Ua.add(aVar);
            if (com.kwad.sdk.core.config.d.isLoaded()) {
                aVar.rw();
            }
            if (TZ) {
                aVar.d(com.kwad.sdk.core.config.d.DA());
            }
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    public static void a(@NonNull SdkConfigData sdkConfigData) {
        Iterator<a> it = Ua.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }
}
