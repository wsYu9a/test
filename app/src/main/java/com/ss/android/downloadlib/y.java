package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.t;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: j */
    private static volatile y f24353j;

    /* renamed from: g */
    private final com.ss.android.downloadad.api.j f24354g;
    private long gv;

    /* renamed from: i */
    private final lg f24355i;
    private com.ss.android.downloadad.api.zx q;
    private final com.ss.android.download.api.j zx;

    /* renamed from: com.ss.android.downloadlib.y$1 */
    static class AnonymousClass1 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ Context f24356j;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            y unused = y.f24353j = new y(context);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f24358j;
        final /* synthetic */ int zx;

        AnonymousClass2(String str, int i2) {
            str = str;
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(str, i2);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ String f24360j;
        final /* synthetic */ boolean zx;

        AnonymousClass3(String str, boolean z) {
            str = str;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(str, z);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ DownloadModel f24361g;

        /* renamed from: i */
        final /* synthetic */ DownloadStatusChangeListener f24362i;

        /* renamed from: j */
        final /* synthetic */ Context f24363j;
        final /* synthetic */ int zx;

        AnonymousClass4(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
            context = context;
            i2 = i2;
            downloadStatusChangeListener = downloadStatusChangeListener;
            downloadModel = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(context, i2, downloadStatusChangeListener, downloadModel);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ DownloadEventConfig f24364g;
        final /* synthetic */ OnItemClickListener gv;

        /* renamed from: i */
        final /* synthetic */ int f24365i;

        /* renamed from: j */
        final /* synthetic */ String f24366j;
        final /* synthetic */ IDownloadButtonClickListener lg;
        final /* synthetic */ DownloadController q;
        final /* synthetic */ long zx;

        AnonymousClass5(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
            str = str;
            j2 = j2;
            i2 = i2;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            onItemClickListener = onItemClickListener;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(str, j2, i2, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ DownloadEventConfig f24367g;

        /* renamed from: i */
        final /* synthetic */ int f24368i;

        /* renamed from: j */
        final /* synthetic */ String f24369j;
        final /* synthetic */ DownloadController q;
        final /* synthetic */ long zx;

        AnonymousClass6(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
            str = str;
            j2 = j2;
            i2 = i2;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(str, j2, i2, downloadEventConfig, downloadController);
        }
    }

    /* renamed from: com.ss.android.downloadlib.y$7 */
    class AnonymousClass7 implements Runnable {

        /* renamed from: g */
        final /* synthetic */ DownloadEventConfig f24370g;
        final /* synthetic */ IDownloadButtonClickListener gv;

        /* renamed from: i */
        final /* synthetic */ int f24371i;

        /* renamed from: j */
        final /* synthetic */ String f24372j;
        final /* synthetic */ DownloadController q;
        final /* synthetic */ long zx;

        AnonymousClass7(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
            str = str;
            j2 = j2;
            i2 = i2;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            y.this.y().j(str, j2, i2, downloadEventConfig, downloadController, iDownloadButtonClickListener);
        }
    }

    /* synthetic */ y(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    public lg y() {
        return this.f24355i;
    }

    public com.ss.android.downloadad.api.j g() {
        return this.f24354g;
    }

    public String gv() {
        return pa.p();
    }

    public void i() {
        this.gv = System.currentTimeMillis();
    }

    public void lg() {
        g.j().q();
    }

    public com.ss.android.downloadad.api.zx q() {
        if (this.q == null) {
            this.q = zx.j();
        }
        return this.q;
    }

    private y(Context context) {
        this.f24355i = lg.j();
        this.zx = new q();
        this.gv = System.currentTimeMillis();
        zx(context);
        this.f24354g = j.j();
    }

    public static y j(Context context) {
        if (f24353j == null) {
            synchronized (y.class) {
                if (f24353j == null) {
                    com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.1

                        /* renamed from: j */
                        final /* synthetic */ Context f24356j;

                        AnonymousClass1(Context context2) {
                            context = context2;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            y unused = y.f24353j = new y(context);
                        }
                    });
                }
            }
        }
        return f24353j;
    }

    private void zx(Context context) {
        pa.j(context);
        Downloader.getInstance(pa.getContext());
        com.ss.android.downloadlib.addownload.zx.gv.j().zx();
        com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), "misc_config", new com.ss.android.downloadlib.i.lg(), new com.ss.android.downloadlib.i.gv(context), new i());
        com.ss.android.downloadlib.i.g gVar = new com.ss.android.downloadlib.i.g();
        com.ss.android.socialbase.appdownloader.g.pa().j(gVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(gVar);
        com.ss.android.socialbase.appdownloader.g.pa().j(new t());
        DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.i.q());
        com.ss.android.socialbase.appdownloader.g.pa().j(com.ss.android.downloadlib.gv.i.j());
    }

    public com.ss.android.download.api.j j() {
        return this.zx;
    }

    public com.ss.android.download.api.j j(String str) {
        com.ss.android.download.api.config.gv zx = gv.j().zx();
        if (zx != null && zx.j(str)) {
            return zx.zx(str);
        }
        return this.zx;
    }

    public long zx() {
        return this.gv;
    }

    @MainThread
    public void j(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.4

            /* renamed from: g */
            final /* synthetic */ DownloadModel f24361g;

            /* renamed from: i */
            final /* synthetic */ DownloadStatusChangeListener f24362i;

            /* renamed from: j */
            final /* synthetic */ Context f24363j;
            final /* synthetic */ int zx;

            AnonymousClass4(Context context2, int i22, DownloadStatusChangeListener downloadStatusChangeListener2, DownloadModel downloadModel2) {
                context = context2;
                i2 = i22;
                downloadStatusChangeListener = downloadStatusChangeListener2;
                downloadModel = downloadModel2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(context, i2, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo zx(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), str);
    }

    @MainThread
    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.5

            /* renamed from: g */
            final /* synthetic */ DownloadEventConfig f24364g;
            final /* synthetic */ OnItemClickListener gv;

            /* renamed from: i */
            final /* synthetic */ int f24365i;

            /* renamed from: j */
            final /* synthetic */ String f24366j;
            final /* synthetic */ IDownloadButtonClickListener lg;
            final /* synthetic */ DownloadController q;
            final /* synthetic */ long zx;

            AnonymousClass5(String str2, long j22, int i22, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, OnItemClickListener onItemClickListener2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                str = str2;
                j2 = j22;
                i2 = i22;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                onItemClickListener = onItemClickListener2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(str, j2, i2, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.6

            /* renamed from: g */
            final /* synthetic */ DownloadEventConfig f24367g;

            /* renamed from: i */
            final /* synthetic */ int f24368i;

            /* renamed from: j */
            final /* synthetic */ String f24369j;
            final /* synthetic */ DownloadController q;
            final /* synthetic */ long zx;

            AnonymousClass6(String str2, long j22, int i22, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2) {
                str = str2;
                j2 = j22;
                i2 = i22;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(str, j2, i2, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.7

            /* renamed from: g */
            final /* synthetic */ DownloadEventConfig f24370g;
            final /* synthetic */ IDownloadButtonClickListener gv;

            /* renamed from: i */
            final /* synthetic */ int f24371i;

            /* renamed from: j */
            final /* synthetic */ String f24372j;
            final /* synthetic */ DownloadController q;
            final /* synthetic */ long zx;

            AnonymousClass7(String str2, long j22, int i22, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                str = str2;
                j2 = j22;
                i2 = i22;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(str, j2, i2, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void j(String str, int i2) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.2

            /* renamed from: j */
            final /* synthetic */ String f24358j;
            final /* synthetic */ int zx;

            AnonymousClass2(String str2, int i22) {
                str = str2;
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(str, i2);
            }
        });
    }

    @MainThread
    public void j(String str, boolean z) {
        com.ss.android.downloadlib.q.zx.j(new Runnable() { // from class: com.ss.android.downloadlib.y.3

            /* renamed from: j */
            final /* synthetic */ String f24360j;
            final /* synthetic */ boolean zx;

            AnonymousClass3(String str2, boolean z2) {
                str = str2;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                y.this.y().j(str, z);
            }
        });
    }

    public void j(com.ss.android.download.api.download.j.j jVar) {
        y().j(jVar);
    }
}
