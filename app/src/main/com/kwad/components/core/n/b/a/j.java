package com.kwad.components.core.n.b.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.webview.tachikoma.g;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISensorManagerProxy;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.components.offline.api.tk.model.report.TKExceptionUploadParams;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bq;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class j implements IOfflineHostApi {
    private IAsync OU;
    private IEnvironment OV;
    private IZipper OW;
    private INet OX;
    private IEncrypt OY;
    private IOfflineCompoLogcat OZ;
    private ICrash Pa;
    private ILoggerReporter Pb;
    private IDownloader Pc;
    private IImageLoader Pd;
    private IVideo Pe;
    private ILive Pf;
    private ICache Pg;
    private IWebView Ph;
    private IVibratorUtil Pi;
    private IIdc Pj;
    private IImagePlayer Pk;
    private ILifeCycle Pl;
    private INetworkManager Pm;
    private ISystemProperties Pn;
    private IFlowUuid Po;
    private ISensorManagerProxy Pp;

    /* renamed from: com.kwad.components.core.n.b.a.j$1 */
    public class AnonymousClass1 implements ICrash {

        /* renamed from: com.kwad.components.core.n.b.a.j$1$1 */
        public class C04361 implements com.kwad.sdk.service.a.c {
            final /* synthetic */ ICrashCustomKeyValue Pr;

            public C04361(ICrashCustomKeyValue iCrashCustomKeyValue) {
                iCrashCustomKeyValue = iCrashCustomKeyValue;
            }

            @Override // com.kwad.sdk.service.a.c
            public final String getKey() {
                ICrashCustomKeyValue iCrashCustomKeyValue = iCrashCustomKeyValue;
                if (iCrashCustomKeyValue != null) {
                    return iCrashCustomKeyValue.getKey();
                }
                return null;
            }

            @Override // com.kwad.sdk.service.a.c
            public final JSONObject getValue() {
                ICrashCustomKeyValue iCrashCustomKeyValue = iCrashCustomKeyValue;
                if (iCrashCustomKeyValue != null) {
                    return iCrashCustomKeyValue.getValue();
                }
                return null;
            }
        }

        /* renamed from: com.kwad.components.core.n.b.a.j$1$2 */
        public class AnonymousClass2 implements com.kwad.sdk.service.a.g {
            final /* synthetic */ ICrashOccurListener Pt;

            public AnonymousClass2(ICrashOccurListener iCrashOccurListener) {
                iCrashOccurListener = iCrashOccurListener;
            }

            @Override // com.kwad.sdk.service.a.g
            public final void l(int i10, String str) {
                ICrashOccurListener iCrashOccurListener = iCrashOccurListener;
                if (iCrashOccurListener != null) {
                    iCrashOccurListener.onCrashOccur(i10, str);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.kwad.components.offline.api.core.api.ICrash
        public final void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue) {
            com.kwad.sdk.service.c.b(new com.kwad.sdk.service.a.c() { // from class: com.kwad.components.core.n.b.a.j.1.1
                final /* synthetic */ ICrashCustomKeyValue Pr;

                public C04361(ICrashCustomKeyValue iCrashCustomKeyValue2) {
                    iCrashCustomKeyValue = iCrashCustomKeyValue2;
                }

                @Override // com.kwad.sdk.service.a.c
                public final String getKey() {
                    ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                    if (iCrashCustomKeyValue2 != null) {
                        return iCrashCustomKeyValue2.getKey();
                    }
                    return null;
                }

                @Override // com.kwad.sdk.service.a.c
                public final JSONObject getValue() {
                    ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                    if (iCrashCustomKeyValue2 != null) {
                        return iCrashCustomKeyValue2.getValue();
                    }
                    return null;
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.ICrash
        public final void addOnCrashListener(ICrashOccurListener iCrashOccurListener) {
            com.kwad.sdk.service.c.a(new com.kwad.sdk.service.a.g() { // from class: com.kwad.components.core.n.b.a.j.1.2
                final /* synthetic */ ICrashOccurListener Pt;

                public AnonymousClass2(ICrashOccurListener iCrashOccurListener2) {
                    iCrashOccurListener = iCrashOccurListener2;
                }

                @Override // com.kwad.sdk.service.a.g
                public final void l(int i10, String str) {
                    ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                    if (iCrashOccurListener2 != null) {
                        iCrashOccurListener2.onCrashOccur(i10, str);
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.ICrash
        public final void gatherException(Throwable th2) {
            com.kwad.sdk.service.c.gatherException(th2);
        }

        @Override // com.kwad.components.offline.api.core.api.ICrash
        public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
            com.kwad.sdk.service.c.G(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
        }
    }

    /* renamed from: com.kwad.components.core.n.b.a.j$2 */
    public class AnonymousClass2 implements ILoggerReporter {
        public AnonymousClass2() {
        }

        @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
        public final void reportEvent(com.kwad.sdk.commercial.c cVar) {
            com.kwad.sdk.commercial.b.d(cVar);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.a.j$3 */
    public class AnonymousClass3 implements IDownloader {
        public AnonymousClass3() {
        }

        @Override // com.kwad.components.offline.api.core.api.IDownloader
        @WorkerThread
        public final boolean downloadSync(File file, String str) {
            return com.kwad.sdk.core.download.a.d(str, file);
        }
    }

    /* renamed from: com.kwad.components.core.n.b.a.j$4 */
    public class AnonymousClass4 implements IBundleService {

        /* renamed from: com.kwad.components.core.n.b.a.j$4$1 */
        public class AnonymousClass1 implements g.b {
            final /* synthetic */ IBundleLoadListener Pu;

            public AnonymousClass1(IBundleLoadListener iBundleLoadListener) {
                iBundleLoadListener = iBundleLoadListener;
            }

            @Override // com.kwad.components.core.webview.tachikoma.g.b
            public final void onFailed(String str) {
                IBundleLoadListener iBundleLoadListener = iBundleLoadListener;
                if (iBundleLoadListener != null) {
                    iBundleLoadListener.onFailed(str);
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.g.b
            public final void onSuccess() {
                IBundleLoadListener iBundleLoadListener = iBundleLoadListener;
                if (iBundleLoadListener != null) {
                    iBundleLoadListener.onSuccess();
                }
            }
        }

        /* renamed from: com.kwad.components.core.n.b.a.j$4$2 */
        public class AnonymousClass2 implements g.b {
            final /* synthetic */ IBundleLoadListener Pu;

            public AnonymousClass2(IBundleLoadListener iBundleLoadListener) {
                iBundleLoadListener = iBundleLoadListener;
            }

            @Override // com.kwad.components.core.webview.tachikoma.g.b
            public final void onFailed(String str) {
                IBundleLoadListener iBundleLoadListener = iBundleLoadListener;
                if (iBundleLoadListener != null) {
                    iBundleLoadListener.onFailed(str);
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.g.b
            public final void onSuccess() {
                IBundleLoadListener iBundleLoadListener = iBundleLoadListener;
                if (iBundleLoadListener != null) {
                    iBundleLoadListener.onSuccess();
                }
            }
        }

        public AnonymousClass4() {
        }

        @Override // com.kwad.components.offline.api.core.api.IBundleService
        public final void loadBundle(Context context, String str, IBundleLoadListener iBundleLoadListener) {
            com.kwad.components.core.webview.tachikoma.g.tE().b(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.1
                final /* synthetic */ IBundleLoadListener Pu;

                public AnonymousClass1(IBundleLoadListener iBundleLoadListener2) {
                    iBundleLoadListener = iBundleLoadListener2;
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onFailed(String str2) {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onFailed(str2);
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onSuccess() {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onSuccess();
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.IBundleService
        public final void loadBundleWithString(Context context, String str, IBundleLoadListener iBundleLoadListener) {
            com.kwad.components.core.webview.tachikoma.g.tE().a(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.2
                final /* synthetic */ IBundleLoadListener Pu;

                public AnonymousClass2(IBundleLoadListener iBundleLoadListener2) {
                    iBundleLoadListener = iBundleLoadListener2;
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onFailed(String str2) {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onFailed(str2);
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onSuccess() {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onSuccess();
                    }
                }
            });
        }

        @Override // com.kwad.components.offline.api.core.api.IBundleService
        public final void unloadBundle(String str) {
            com.kwad.components.core.webview.tachikoma.g.tE().unloadBundle(str);
        }
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.OU == null) {
            this.OU = new a();
        }
        return this.OU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IBundleService bundleService() {
        return new IBundleService() { // from class: com.kwad.components.core.n.b.a.j.4

            /* renamed from: com.kwad.components.core.n.b.a.j$4$1 */
            public class AnonymousClass1 implements g.b {
                final /* synthetic */ IBundleLoadListener Pu;

                public AnonymousClass1(IBundleLoadListener iBundleLoadListener2) {
                    iBundleLoadListener = iBundleLoadListener2;
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onFailed(String str2) {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onFailed(str2);
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onSuccess() {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onSuccess();
                    }
                }
            }

            /* renamed from: com.kwad.components.core.n.b.a.j$4$2 */
            public class AnonymousClass2 implements g.b {
                final /* synthetic */ IBundleLoadListener Pu;

                public AnonymousClass2(IBundleLoadListener iBundleLoadListener2) {
                    iBundleLoadListener = iBundleLoadListener2;
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onFailed(String str2) {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onFailed(str2);
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.g.b
                public final void onSuccess() {
                    IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                    if (iBundleLoadListener2 != null) {
                        iBundleLoadListener2.onSuccess();
                    }
                }
            }

            public AnonymousClass4() {
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundle(Context context, String str, IBundleLoadListener iBundleLoadListener2) {
                com.kwad.components.core.webview.tachikoma.g.tE().b(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.1
                    final /* synthetic */ IBundleLoadListener Pu;

                    public AnonymousClass1(IBundleLoadListener iBundleLoadListener22) {
                        iBundleLoadListener = iBundleLoadListener22;
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener22 = iBundleLoadListener;
                        if (iBundleLoadListener22 != null) {
                            iBundleLoadListener22.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener22 = iBundleLoadListener;
                        if (iBundleLoadListener22 != null) {
                            iBundleLoadListener22.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundleWithString(Context context, String str, IBundleLoadListener iBundleLoadListener2) {
                com.kwad.components.core.webview.tachikoma.g.tE().a(context, str, new g.b() { // from class: com.kwad.components.core.n.b.a.j.4.2
                    final /* synthetic */ IBundleLoadListener Pu;

                    public AnonymousClass2(IBundleLoadListener iBundleLoadListener22) {
                        iBundleLoadListener = iBundleLoadListener22;
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener22 = iBundleLoadListener;
                        if (iBundleLoadListener22 != null) {
                            iBundleLoadListener22.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.g.b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener22 = iBundleLoadListener;
                        if (iBundleLoadListener22 != null) {
                            iBundleLoadListener22.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void unloadBundle(String str) {
                com.kwad.components.core.webview.tachikoma.g.tE().unloadBundle(str);
            }
        };
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.Pg == null) {
            this.Pg = new b();
        }
        return this.Pg;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.Pa == null) {
            this.Pa = new ICrash() { // from class: com.kwad.components.core.n.b.a.j.1

                /* renamed from: com.kwad.components.core.n.b.a.j$1$1 */
                public class C04361 implements com.kwad.sdk.service.a.c {
                    final /* synthetic */ ICrashCustomKeyValue Pr;

                    public C04361(ICrashCustomKeyValue iCrashCustomKeyValue2) {
                        iCrashCustomKeyValue = iCrashCustomKeyValue2;
                    }

                    @Override // com.kwad.sdk.service.a.c
                    public final String getKey() {
                        ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                        if (iCrashCustomKeyValue2 != null) {
                            return iCrashCustomKeyValue2.getKey();
                        }
                        return null;
                    }

                    @Override // com.kwad.sdk.service.a.c
                    public final JSONObject getValue() {
                        ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                        if (iCrashCustomKeyValue2 != null) {
                            return iCrashCustomKeyValue2.getValue();
                        }
                        return null;
                    }
                }

                /* renamed from: com.kwad.components.core.n.b.a.j$1$2 */
                public class AnonymousClass2 implements com.kwad.sdk.service.a.g {
                    final /* synthetic */ ICrashOccurListener Pt;

                    public AnonymousClass2(ICrashOccurListener iCrashOccurListener2) {
                        iCrashOccurListener = iCrashOccurListener2;
                    }

                    @Override // com.kwad.sdk.service.a.g
                    public final void l(int i10, String str) {
                        ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                        if (iCrashOccurListener2 != null) {
                            iCrashOccurListener2.onCrashOccur(i10, str);
                        }
                    }
                }

                public AnonymousClass1() {
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addCustomKeyValue(ICrashCustomKeyValue iCrashCustomKeyValue2) {
                    com.kwad.sdk.service.c.b(new com.kwad.sdk.service.a.c() { // from class: com.kwad.components.core.n.b.a.j.1.1
                        final /* synthetic */ ICrashCustomKeyValue Pr;

                        public C04361(ICrashCustomKeyValue iCrashCustomKeyValue22) {
                            iCrashCustomKeyValue = iCrashCustomKeyValue22;
                        }

                        @Override // com.kwad.sdk.service.a.c
                        public final String getKey() {
                            ICrashCustomKeyValue iCrashCustomKeyValue22 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue22 != null) {
                                return iCrashCustomKeyValue22.getKey();
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.service.a.c
                        public final JSONObject getValue() {
                            ICrashCustomKeyValue iCrashCustomKeyValue22 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue22 != null) {
                                return iCrashCustomKeyValue22.getValue();
                            }
                            return null;
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addOnCrashListener(ICrashOccurListener iCrashOccurListener2) {
                    com.kwad.sdk.service.c.a(new com.kwad.sdk.service.a.g() { // from class: com.kwad.components.core.n.b.a.j.1.2
                        final /* synthetic */ ICrashOccurListener Pt;

                        public AnonymousClass2(ICrashOccurListener iCrashOccurListener22) {
                            iCrashOccurListener = iCrashOccurListener22;
                        }

                        @Override // com.kwad.sdk.service.a.g
                        public final void l(int i10, String str) {
                            ICrashOccurListener iCrashOccurListener22 = iCrashOccurListener;
                            if (iCrashOccurListener22 != null) {
                                iCrashOccurListener22.onCrashOccur(i10, str);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th2) {
                    com.kwad.sdk.service.c.gatherException(th2);
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
                    com.kwad.sdk.service.c.G(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
                }
            };
        }
        return this.Pa;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.Pc == null) {
            this.Pc = new IDownloader() { // from class: com.kwad.components.core.n.b.a.j.3
                public AnonymousClass3() {
                }

                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return com.kwad.sdk.core.download.a.d(str, file);
                }
            };
        }
        return this.Pc;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.OY == null) {
            this.OY = new c();
        }
        return this.OY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.OV == null) {
            this.OV = new d();
        }
        return this.OV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFlowUuid flowUuid() {
        if (this.Po == null) {
            this.Po = new e();
        }
        return this.Po;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getAppIconId(Context context) {
        return ax.getAppIconId(context);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getDrawableId(Context context, String str) {
        return ax.au(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getId(Context context, String str) {
        return ax.getId(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final PackageInfo getPackageInfo(Context context, String str, int i10) {
        return ao.getPackageInfo(context, str, i10);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final long getSystemTimeInMs(Context context, boolean z10) {
        return bq.v(context, z10);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getTKErrorDetailCount() {
        return com.kwad.sdk.core.config.d.getTKErrorDetailCount();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final List<String> getTKPreloadMemCacheTemplates() {
        return com.kwad.sdk.core.config.d.getTKPreloadMemCacheTemplates();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.Pj == null) {
            this.Pj = new m();
        }
        return this.Pj;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.Pd == null) {
            this.Pd = new f();
        }
        return this.Pd;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImagePlayer imagePlayer() {
        com.kwad.components.core.g.d dVar = new com.kwad.components.core.g.d();
        this.Pk = dVar;
        return dVar;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean isOrientationPortrait() {
        return an.isOrientationPortrait();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILifeCycle lifeCycle() {
        if (this.Pl == null) {
            this.Pl = new g();
        }
        return this.Pl;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.Pf == null) {
            this.Pf = new com.kwad.components.core.n.b.b.a();
        }
        return this.Pf;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.OZ == null) {
            this.OZ = new k();
        }
        return this.OZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.Pb == null) {
            this.Pb = new ILoggerReporter() { // from class: com.kwad.components.core.n.b.a.j.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(com.kwad.sdk.commercial.c cVar) {
                    com.kwad.sdk.commercial.b.d(cVar);
                }
            };
        }
        return this.Pb;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.OX == null) {
            this.OX = new h();
        }
        return this.OX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INetworkManager networkManager() {
        if (this.Pm == null) {
            this.Pm = new i();
        }
        return this.Pm;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void saveTKTemplateCache(String str, int i10, String str2) {
        com.kwad.components.core.webview.tachikoma.h.tH().b(str, i10, str2);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISensorManagerProxy sensorManager() {
        if (this.Pp == null) {
            this.Pp = new o();
        }
        return this.Pp;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISystemProperties systemProperty() {
        if (this.Pn == null) {
            this.Pn = new n();
        }
        return this.Pn;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.Pi == null) {
            this.Pi = new p();
        }
        return this.Pi;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.Pe == null) {
            this.Pe = new com.kwad.components.core.n.b.c.e();
        }
        return this.Pe;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.Ph == null) {
            this.Ph = new com.kwad.components.core.n.b.d.b();
        }
        return this.Ph;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.OW == null) {
            this.OW = new q();
        }
        return this.OW;
    }
}
