package com.kwad.components.offline.tk;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.n.f;
import com.kwad.components.core.n.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class b extends com.kwad.components.core.offline.init.a {
    private static long Xx;
    private final List<com.kwad.components.core.offline.api.a.a> Xw;
    private final AtomicBoolean Xy;

    /* renamed from: com.kwad.components.offline.tk.b$1 */
    final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ boolean Kd;
        final /* synthetic */ long XA;
        final /* synthetic */ long XB;
        final /* synthetic */ ITkOfflineCompo Xz;
        final /* synthetic */ Context jN;

        /* renamed from: com.kwad.components.offline.tk.b$1$1 */
        final class C02001 extends g {
            final /* synthetic */ TkCompoImpl XD;

            /* renamed from: com.kwad.components.offline.tk.b$1$1$1 */
            final class RunnableC02011 implements Runnable {
                final /* synthetic */ SdkConfigData Xg;

                RunnableC02011(SdkConfigData sdkConfigData) {
                    sdkConfigData = sdkConfigData;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    C02001 c02001 = C02001.this;
                    tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jN, sdkConfigData.toJson());
                }
            }

            C02001(TkCompoImpl tkCompoImpl) {
                tkCompoImpl = tkCompoImpl;
            }

            @Override // com.kwad.components.core.n.g, com.kwad.components.core.n.f.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                super.a(sdkConfigData);
                com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.offline.tk.b.1.1.1
                    final /* synthetic */ SdkConfigData Xg;

                    RunnableC02011(SdkConfigData sdkConfigData2) {
                        sdkConfigData = sdkConfigData2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C02001 c02001 = C02001.this;
                        tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jN, sdkConfigData.toJson());
                    }
                });
            }
        }

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, long j2, long j3, boolean z, Context context) {
            this.Xz = iTkOfflineCompo;
            this.XA = j2;
            this.XB = j3;
            this.Kd = z;
            this.jN = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            TkCompoImpl tkCompoImpl = new TkCompoImpl(this.Xz);
            com.kwad.sdk.components.c.a(com.kwad.components.core.offline.api.a.c.class, tkCompoImpl);
            b.this.Xy.set(true);
            TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.XA).setSoLoadTime(SystemClock.elapsedRealtime() - this.XB).setOfflineSource(this.Kd ? 1 : 2).setSoSource(z ? 2 : 1).toJson());
            com.kwad.sdk.core.d.b.i(b.this.getTag(), "offlineComponent load success");
            b.this.nO();
            b.this.rR();
            f.a(new g() { // from class: com.kwad.components.offline.tk.b.1.1
                final /* synthetic */ TkCompoImpl XD;

                /* renamed from: com.kwad.components.offline.tk.b$1$1$1 */
                final class RunnableC02011 implements Runnable {
                    final /* synthetic */ SdkConfigData Xg;

                    RunnableC02011(SdkConfigData sdkConfigData2) {
                        sdkConfigData = sdkConfigData2;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        C02001 c02001 = C02001.this;
                        tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jN, sdkConfigData.toJson());
                    }
                }

                C02001(TkCompoImpl tkCompoImpl2) {
                    tkCompoImpl = tkCompoImpl2;
                }

                @Override // com.kwad.components.core.n.g, com.kwad.components.core.n.f.a
                public final void a(@NonNull SdkConfigData sdkConfigData2) {
                    super.a(sdkConfigData2);
                    com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.offline.tk.b.1.1.1
                        final /* synthetic */ SdkConfigData Xg;

                        RunnableC02011(SdkConfigData sdkConfigData22) {
                            sdkConfigData = sdkConfigData22;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            C02001 c02001 = C02001.this;
                            tkCompoImpl.onConfigRefresh(AnonymousClass1.this.jN, sdkConfigData.toJson());
                        }
                    });
                }
            });
        }
    }

    static final class a {
        private static final b XG = new b((byte) 0);
    }

    private b() {
        this.Xw = new CopyOnWriteArrayList();
        this.Xy = new AtomicBoolean(false);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.offline.init.b.class, methodId = "initOC")
    public static void ak(Context context) {
        Xx = SystemClock.elapsedRealtime();
        rQ().init(context);
    }

    public static b rQ() {
        return a.XG;
    }

    public void rR() {
        Iterator<com.kwad.components.core.offline.api.a.a> it = this.Xw.iterator();
        while (it.hasNext()) {
            it.next().onSuccess();
        }
    }

    public final void a(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.Xy.get()) {
            aVar.onSuccess();
        }
        this.Xw.add(aVar);
    }

    public final void b(com.kwad.components.core.offline.api.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.Xw.remove(aVar);
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        ITkOfflineCompo iTkOfflineCompo = (ITkOfflineCompo) a(classLoader, ITkOfflineCompo.IMPL);
        if (iTkOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("TkInitModule", "onPluginLoaded components is null");
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long elapsedRealtime2 = SystemClock.elapsedRealtime() - Xx;
        boolean h2 = y.h(context, nJ(), nK());
        com.kwad.sdk.core.d.b.d(getTag(), "offlineComponent load " + h2 + " components classLoader: " + iTkOfflineCompo.getClass().getClassLoader());
        iTkOfflineCompo.initReal(context, ServiceProvider.CB(), new c(), new AnonymousClass1(iTkOfflineCompo, elapsedRealtime2, elapsedRealtime, h2, context));
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return ((Boolean) d.b(com.kwad.sdk.core.config.c.acL)).booleanValue();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final int nG() {
        return 1;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean nH() {
        return false;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nJ() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nK() {
        return "3.3.40";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nL() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.40-c7665df844-282.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nM() {
        return "4b490564376f5186e9438abf66d292da";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String nN() {
        return "ks_tk_134ad9665";
    }
}
