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
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.addownload.m;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a */
    private static volatile i f21685a;

    /* renamed from: b */
    private final com.ss.android.download.api.a f21686b;

    /* renamed from: c */
    private final g f21687c;

    /* renamed from: d */
    private final com.ss.android.downloadad.api.a f21688d;

    /* renamed from: e */
    private com.ss.android.downloadad.api.b f21689e;

    /* renamed from: f */
    private long f21690f;

    /* renamed from: com.ss.android.downloadlib.i$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21691a;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            i unused = i.f21685a = new i(context);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21692a;

        /* renamed from: b */
        final /* synthetic */ int f21693b;

        public AnonymousClass2(String str, int i10) {
            str = str;
            i10 = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(str, i10);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21695a;

        /* renamed from: b */
        final /* synthetic */ boolean f21696b;

        public AnonymousClass3(String str, boolean z10) {
            str = str;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(str, z10);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f21698a;

        /* renamed from: b */
        final /* synthetic */ int f21699b;

        /* renamed from: c */
        final /* synthetic */ DownloadStatusChangeListener f21700c;

        /* renamed from: d */
        final /* synthetic */ DownloadModel f21701d;

        public AnonymousClass4(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
            context = context;
            i10 = i10;
            downloadStatusChangeListener = downloadStatusChangeListener;
            downloadModel = downloadModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(context, i10, downloadStatusChangeListener, downloadModel);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21703a;

        /* renamed from: b */
        final /* synthetic */ long f21704b;

        /* renamed from: c */
        final /* synthetic */ int f21705c;

        /* renamed from: d */
        final /* synthetic */ DownloadEventConfig f21706d;

        /* renamed from: e */
        final /* synthetic */ DownloadController f21707e;

        /* renamed from: f */
        final /* synthetic */ OnItemClickListener f21708f;

        /* renamed from: g */
        final /* synthetic */ IDownloadButtonClickListener f21709g;

        public AnonymousClass5(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
            str = str;
            j10 = j10;
            i10 = i10;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            onItemClickListener = onItemClickListener;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(str, j10, i10, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21711a;

        /* renamed from: b */
        final /* synthetic */ long f21712b;

        /* renamed from: c */
        final /* synthetic */ int f21713c;

        /* renamed from: d */
        final /* synthetic */ DownloadEventConfig f21714d;

        /* renamed from: e */
        final /* synthetic */ DownloadController f21715e;

        public AnonymousClass6(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
            str = str;
            j10 = j10;
            i10 = i10;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(str, j10, i10, downloadEventConfig, downloadController);
        }
    }

    /* renamed from: com.ss.android.downloadlib.i$7 */
    public class AnonymousClass7 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21717a;

        /* renamed from: b */
        final /* synthetic */ long f21718b;

        /* renamed from: c */
        final /* synthetic */ int f21719c;

        /* renamed from: d */
        final /* synthetic */ DownloadEventConfig f21720d;

        /* renamed from: e */
        final /* synthetic */ DownloadController f21721e;

        /* renamed from: f */
        final /* synthetic */ IDownloadButtonClickListener f21722f;

        public AnonymousClass7(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
            str = str;
            j10 = j10;
            i10 = i10;
            downloadEventConfig = downloadEventConfig;
            downloadController = downloadController;
            iDownloadButtonClickListener = iDownloadButtonClickListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.h().a(str, j10, i10, downloadEventConfig, downloadController, iDownloadButtonClickListener);
        }
    }

    public /* synthetic */ i(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    public g h() {
        return this.f21687c;
    }

    public void c() {
        this.f21690f = System.currentTimeMillis();
    }

    public com.ss.android.downloadad.api.a d() {
        return this.f21688d;
    }

    public com.ss.android.downloadad.api.b e() {
        if (this.f21689e == null) {
            this.f21689e = b.a();
        }
        return this.f21689e;
    }

    public String f() {
        return k.o();
    }

    public void g() {
        d.a().f();
    }

    private i(Context context) {
        this.f21687c = g.a();
        this.f21686b = new e();
        this.f21690f = System.currentTimeMillis();
        b(context);
        this.f21688d = a.a();
    }

    public static i a(Context context) {
        if (f21685a == null) {
            synchronized (i.class) {
                try {
                    if (f21685a == null) {
                        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.1

                            /* renamed from: a */
                            final /* synthetic */ Context f21691a;

                            public AnonymousClass1(Context context2) {
                                context = context2;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                i unused = i.f21685a = new i(context);
                            }
                        });
                    }
                } finally {
                }
            }
        }
        return f21685a;
    }

    private void b(Context context) {
        k.a(context);
        Downloader.getInstance(k.a());
        com.ss.android.downloadlib.addownload.b.f.a().b();
        com.ss.android.socialbase.appdownloader.d.j().a(k.a(), "misc_config", new com.ss.android.downloadlib.c.g(), new com.ss.android.downloadlib.c.f(context), new c());
        com.ss.android.downloadlib.c.d dVar = new com.ss.android.downloadlib.c.d();
        com.ss.android.socialbase.appdownloader.d.j().a(dVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(dVar);
        com.ss.android.socialbase.appdownloader.d.j().a(new m());
        DownloadComponentManager.setDownloadEventListener(new com.ss.android.downloadlib.c.e());
        com.ss.android.socialbase.appdownloader.d.j().a(com.ss.android.downloadlib.f.c.a());
    }

    public com.ss.android.download.api.a a() {
        return this.f21686b;
    }

    public com.ss.android.download.api.a a(String str) {
        com.ss.android.download.api.config.f b10 = f.a().b();
        if (b10 != null && b10.a(str)) {
            return b10.b(str);
        }
        return this.f21686b;
    }

    public long b() {
        return this.f21690f;
    }

    @MainThread
    public void a(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.4

            /* renamed from: a */
            final /* synthetic */ Context f21698a;

            /* renamed from: b */
            final /* synthetic */ int f21699b;

            /* renamed from: c */
            final /* synthetic */ DownloadStatusChangeListener f21700c;

            /* renamed from: d */
            final /* synthetic */ DownloadModel f21701d;

            public AnonymousClass4(Context context2, int i102, DownloadStatusChangeListener downloadStatusChangeListener2, DownloadModel downloadModel2) {
                context = context2;
                i10 = i102;
                downloadStatusChangeListener = downloadStatusChangeListener2;
                downloadModel = downloadModel2;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(context, i10, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    public DownloadInfo b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.d.j().a(k.a(), str);
    }

    @MainThread
    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.5

            /* renamed from: a */
            final /* synthetic */ String f21703a;

            /* renamed from: b */
            final /* synthetic */ long f21704b;

            /* renamed from: c */
            final /* synthetic */ int f21705c;

            /* renamed from: d */
            final /* synthetic */ DownloadEventConfig f21706d;

            /* renamed from: e */
            final /* synthetic */ DownloadController f21707e;

            /* renamed from: f */
            final /* synthetic */ OnItemClickListener f21708f;

            /* renamed from: g */
            final /* synthetic */ IDownloadButtonClickListener f21709g;

            public AnonymousClass5(String str2, long j102, int i102, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, OnItemClickListener onItemClickListener2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                str = str2;
                j10 = j102;
                i10 = i102;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                onItemClickListener = onItemClickListener2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(str, j10, i10, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.6

            /* renamed from: a */
            final /* synthetic */ String f21711a;

            /* renamed from: b */
            final /* synthetic */ long f21712b;

            /* renamed from: c */
            final /* synthetic */ int f21713c;

            /* renamed from: d */
            final /* synthetic */ DownloadEventConfig f21714d;

            /* renamed from: e */
            final /* synthetic */ DownloadController f21715e;

            public AnonymousClass6(String str2, long j102, int i102, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2) {
                str = str2;
                j10 = j102;
                i10 = i102;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(str, j10, i10, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.7

            /* renamed from: a */
            final /* synthetic */ String f21717a;

            /* renamed from: b */
            final /* synthetic */ long f21718b;

            /* renamed from: c */
            final /* synthetic */ int f21719c;

            /* renamed from: d */
            final /* synthetic */ DownloadEventConfig f21720d;

            /* renamed from: e */
            final /* synthetic */ DownloadController f21721e;

            /* renamed from: f */
            final /* synthetic */ IDownloadButtonClickListener f21722f;

            public AnonymousClass7(String str2, long j102, int i102, DownloadEventConfig downloadEventConfig2, DownloadController downloadController2, IDownloadButtonClickListener iDownloadButtonClickListener2) {
                str = str2;
                j10 = j102;
                i10 = i102;
                downloadEventConfig = downloadEventConfig2;
                downloadController = downloadController2;
                iDownloadButtonClickListener = iDownloadButtonClickListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(str, j10, i10, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void a(String str, int i10) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.2

            /* renamed from: a */
            final /* synthetic */ String f21692a;

            /* renamed from: b */
            final /* synthetic */ int f21693b;

            public AnonymousClass2(String str2, int i102) {
                str = str2;
                i10 = i102;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(str, i10);
            }
        });
    }

    @MainThread
    public void a(String str, boolean z10) {
        com.ss.android.downloadlib.e.b.a(new Runnable() { // from class: com.ss.android.downloadlib.i.3

            /* renamed from: a */
            final /* synthetic */ String f21695a;

            /* renamed from: b */
            final /* synthetic */ boolean f21696b;

            public AnonymousClass3(String str2, boolean z102) {
                str = str2;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.h().a(str, z10);
            }
        });
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        h().a(aVar);
    }

    public DownloadInfo a(String str, String str2, boolean z10) {
        if (TextUtils.isEmpty(str2) && z10) {
            return b(str);
        }
        return Downloader.getInstance(k.a()).getDownloadInfo(str, str2);
    }
}
