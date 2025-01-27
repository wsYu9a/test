package com.kwad.components.offline.c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class c extends com.kwad.components.core.n.b.a<ITkOfflineCompo> {
    private static long afZ;
    private final List<com.kwad.components.core.n.a.d.a> afY;
    private final AtomicBoolean aga;

    /* renamed from: com.kwad.components.offline.c.c$1 */
    public class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo agb;
        final /* synthetic */ boolean agc;
        final /* synthetic */ long agd;
        final /* synthetic */ long age;
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.components.offline.c.c$1$1 */
        public class C04601 extends h {
            final /* synthetic */ b agg;

            /* renamed from: com.kwad.components.offline.c.c$1$1$1 */
            public class C04611 extends bd {
                final /* synthetic */ SdkConfigData agi;

                public C04611(SdkConfigData sdkConfigData) {
                    sdkConfigData = sdkConfigData;
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    C04601 c04601 = C04601.this;
                    bVar.onConfigRefresh(AnonymousClass1.this.hB, sdkConfigData.toJson());
                }
            }

            public C04601(b bVar) {
                bVar = bVar;
            }

            @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
            public final void d(@NonNull SdkConfigData sdkConfigData) {
                super.d(sdkConfigData);
                com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.offline.c.c.1.1.1
                    final /* synthetic */ SdkConfigData agi;

                    public C04611(SdkConfigData sdkConfigData2) {
                        sdkConfigData = sdkConfigData2;
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        C04601 c04601 = C04601.this;
                        bVar.onConfigRefresh(AnonymousClass1.this.hB, sdkConfigData.toJson());
                    }
                });
            }
        }

        public AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z10, long j10, long j11, Context context) {
            this.agb = iTkOfflineCompo;
            this.agc = z10;
            this.agd = j10;
            this.age = j11;
            this.hB = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i10) {
            c.this.av(i10);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z10) {
            try {
                b bVar = new b(this.agb);
                com.kwad.sdk.components.d.a(com.kwad.components.core.n.a.d.c.class, bVar);
                c.this.aga.set(true);
                int i10 = z10 ? 2 : 1;
                int i11 = this.agc ? 2 : 1;
                c.this.b(i10, i11, SystemClock.elapsedRealtime() - this.agd, this.age);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.age).setSoLoadTime(SystemClock.elapsedRealtime() - this.agd).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - l.At().AT()).setThreadPoolCoreSize(i.ym().yg().yH()).setOfflineSource(i11).setSoSource(i10).toJson());
                c.this.pC();
                g.b(new h() { // from class: com.kwad.components.offline.c.c.1.1
                    final /* synthetic */ b agg;

                    /* renamed from: com.kwad.components.offline.c.c$1$1$1 */
                    public class C04611 extends bd {
                        final /* synthetic */ SdkConfigData agi;

                        public C04611(SdkConfigData sdkConfigData2) {
                            sdkConfigData = sdkConfigData2;
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            C04601 c04601 = C04601.this;
                            bVar.onConfigRefresh(AnonymousClass1.this.hB, sdkConfigData.toJson());
                        }
                    }

                    public C04601(b bVar2) {
                        bVar = bVar2;
                    }

                    @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
                    public final void d(@NonNull SdkConfigData sdkConfigData2) {
                        super.d(sdkConfigData2);
                        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.components.offline.c.c.1.1.1
                            final /* synthetic */ SdkConfigData agi;

                            public C04611(SdkConfigData sdkConfigData22) {
                                sdkConfigData = sdkConfigData22;
                            }

                            @Override // com.kwad.sdk.utils.bd
                            public final void doTask() {
                                C04601 c04601 = C04601.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.hB, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    public static final class a {
        private static final c agk = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void ay(Context context) {
        afZ = SystemClock.elapsedRealtime();
        uR().init(context);
    }

    public static c uR() {
        return a.agk;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return com.kwad.sdk.core.g.a.HI();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pD() {
        return "TK";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pE() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pF() {
        return "3.3.71";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pG() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.71-2c1b8e2a82-567.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pH() {
        return "36d403768450ccd047315277b81be458";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pI() {
        return "ks_tk_3371";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String pJ() {
        return ITkOfflineCompo.IMPL;
    }

    private c() {
        this.afY = new CopyOnWriteArrayList();
        this.aga = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.afY.remove(aVar);
    }

    public void b(int i10, int i11, long j10, long j11) {
        Iterator<com.kwad.components.core.n.a.d.a> it = this.afY.iterator();
        while (it.hasNext()) {
            try {
                it.next().a(i10, i11, j10, j11);
            } catch (Throwable th2) {
                ServiceProvider.reportSdkCaughtException(th2);
            }
        }
    }

    @Override // com.kwad.components.core.n.b.a
    public void a(Context context, boolean z10, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z10, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - afZ, context));
    }

    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.aga.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.afY.add(aVar);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }
}
