package com.sigmob.sdk.base.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.Md5Util;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.downloader.f;
import com.sigmob.sdk.downloader.l;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes4.dex */
public class n {

    public class a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.sigmob.sdk.downloader.f f17971a;

        public a(com.sigmob.sdk.downloader.f fVar) {
            this.f17971a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17971a.f();
        }
    }

    public class b implements b0.g {
        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                pointEntitySigmob.getOptions().put("error", "cancel download");
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ com.sigmob.sdk.downloader.f f17972a;

        /* renamed from: b */
        public final /* synthetic */ BaseAdUnit f17973b;

        public c(com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
            this.f17972a = fVar;
            this.f17973b = baseAdUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.a(com.sigmob.sdk.a.d(), this.f17972a.j().getAbsolutePath(), this.f17973b);
        }
    }

    public class d extends com.sigmob.sdk.downloader.h {

        /* renamed from: f */
        public l.a f17974f;

        /* renamed from: g */
        public final /* synthetic */ BaseAdUnit f17975g;

        /* renamed from: h */
        public final /* synthetic */ Context f17976h;

        public class a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.downloader.f f17977a;

            public a(com.sigmob.sdk.downloader.f fVar) {
                this.f17977a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                p.a(com.sigmob.sdk.a.d(), this.f17977a.j().getAbsolutePath(), d.this.f17975g);
            }
        }

        public class b implements b0.g {
            public b() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
                }
            }
        }

        public class c implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ Exception f17980a;

            public c(Exception exc) {
                this.f17980a = exc;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                    pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                    pointEntitySigmob.getOptions().put("error", this.f17980a.getMessage());
                }
            }
        }

        /* renamed from: com.sigmob.sdk.base.common.n$d$d */
        public class C0567d implements b0.g {
            public C0567d() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
                }
            }
        }

        public class e implements b0.g {
            public e() {
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                if (obj instanceof PointEntitySigmob) {
                    ((PointEntitySigmob) obj).getOptions().put("status", String.valueOf(1));
                }
            }
        }

        public class f implements b0.g {

            /* renamed from: a */
            public final /* synthetic */ com.sigmob.sdk.videoAd.f f17984a;

            public f(com.sigmob.sdk.videoAd.f fVar) {
                this.f17984a = fVar;
            }

            @Override // com.sigmob.sdk.base.common.b0.g
            public void a(Object obj) {
                PointEntitySigmob pointEntitySigmob;
                Map<String, String> options;
                int i10;
                if (obj instanceof PointEntitySigmob) {
                    pointEntitySigmob = (PointEntitySigmob) obj;
                    String event = this.f17984a.getEvent();
                    event.hashCode();
                    switch (event) {
                        case "download_quarter":
                            options = pointEntitySigmob.getOptions();
                            i10 = 25;
                            break;
                        case "download_three_quarter":
                            options = pointEntitySigmob.getOptions();
                            i10 = 75;
                            break;
                        case "download_two_quarter":
                            options = pointEntitySigmob.getOptions();
                            i10 = 50;
                            break;
                        default:
                            return;
                    }
                    options.put("status", String.valueOf(i10));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, BaseAdUnit baseAdUnit, Context context2) {
            super(context);
            this.f17975g = baseAdUnit;
            this.f17976h = context2;
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0590a
        public void a(com.sigmob.sdk.downloader.f fVar, int i10, long j10, long j11) {
            super.a(fVar, i10, j10, j11);
            HashMap hashMap = new HashMap();
            hashMap.put(p3.i.f29758c, "1");
            hashMap.put("downloadId", this.f17975g.getDownloadId());
            BaseBroadcastReceiver.a(this.f17976h, this.f17975g.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void b(com.sigmob.sdk.downloader.f fVar) {
            l.a aVar = this.f17974f;
            l.a aVar2 = l.a.CANCELED;
            if (aVar == aVar2) {
                return;
            }
            this.f17974f = aVar2;
            super.b(fVar);
            b0.a(PointCategory.APKDOWNLOAD, "pause", this.f17975g, new e());
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void c(com.sigmob.sdk.downloader.f fVar) {
            this.f17974f = l.a.COMPLETED;
            super.c(fVar);
            this.f17975g.enableUseDownloadApk(true);
            if (this.f17975g.isRecord()) {
                b0.b(PointCategory.DOWNLOAD_END, "1", this.f17975g);
                com.sigmob.sdk.base.network.f.a(this.f17975g, com.sigmob.sdk.base.common.a.H);
            }
            WindAds.sharedAds().getHandler().post(new a(fVar));
            b0.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.f17975g, new b());
            HashMap hashMap = new HashMap();
            hashMap.put(p3.i.f29758c, "1");
            hashMap.put("downloadId", this.f17975g.getDownloadId());
            BaseBroadcastReceiver.a(this.f17976h, this.f17975g.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void d(com.sigmob.sdk.downloader.f fVar) {
            this.f17974f = l.a.RUNNING;
            super.d(fVar);
            b0.a(PointCategory.APKDOWNLOAD, "start", this.f17975g, new C0567d());
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.c
        public void a(com.sigmob.sdk.downloader.f fVar, Exception exc) {
            this.f17974f = l.a.UNKNOWN;
            super.a(fVar, exc);
            if (fVar.G()) {
                return;
            }
            g0.makeText(this.f17976h, "下载失败，" + exc.getMessage(), 1).show();
            if (this.f17975g.isRecord()) {
                b0.b(PointCategory.DOWNLOAD_END, "0", this.f17975g);
            }
            b0.a(PointCategory.APKDOWNLOAD, PointCategory.END, this.f17975g, new c(exc));
            HashMap hashMap = new HashMap();
            hashMap.put(p3.i.f29758c, "0");
            hashMap.put("downloadId", this.f17975g.getDownloadId());
            BaseBroadcastReceiver.a(this.f17976h, this.f17975g.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }

        @Override // com.sigmob.sdk.downloader.h, com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0590a
        public void a(com.sigmob.sdk.downloader.f fVar, long j10, long j11) {
            this.f17974f = l.a.RUNNING;
            super.a(fVar, j10, j11);
            List<com.sigmob.sdk.videoAd.f> a10 = com.sigmob.sdk.videoAd.f.a(this.f17975g.getDownloadQuarterTrack(), com.sigmob.sdk.base.common.a.f17663p, j10, j11);
            if (a10.size() > 0) {
                for (com.sigmob.sdk.videoAd.f fVar2 : a10) {
                    fVar2.setTracked();
                    b0.a(PointCategory.APKDOWNLOAD, "progress", this.f17975g, new f(fVar2));
                }
            }
        }
    }

    public class e implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f17986a;

        /* renamed from: b */
        public final /* synthetic */ String f17987b;

        public e(String str, String str2) {
            this.f17986a = str;
            this.f17987b = str2;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(this.f17986a);
                HashMap hashMap = new HashMap();
                hashMap.put("apkfile", this.f17987b);
                hashMap.put("apkurl", this.f17986a);
                pointEntitySigmob.setOptions(hashMap);
            }
        }
    }

    public class f implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f17988a;

        /* renamed from: b */
        public final /* synthetic */ String f17989b;

        public f(String str, String str2) {
            this.f17988a = str;
            this.f17989b = str2;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(this.f17988a);
                HashMap hashMap = new HashMap();
                hashMap.put("apkfile", this.f17989b);
                hashMap.put("apkurl", this.f17988a);
                pointEntitySigmob.setOptions(hashMap);
            }
        }
    }

    public class g implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ Throwable f17990a;

        /* renamed from: b */
        public final /* synthetic */ Context f17991b;

        public g(Throwable th2, Context context) {
            this.f17990a = th2;
            this.f17991b = context;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.getOptions().put("status", String.valueOf(0));
                pointEntitySigmob.getOptions().put("error", this.f17990a.getMessage());
                g0.makeText(this.f17991b, "下载失败，" + this.f17990a.getMessage(), 1).show();
            }
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a */
        public static final /* synthetic */ int[] f17992a;

        static {
            int[] iArr = new int[l.a.values().length];
            f17992a = iArr;
            try {
                iArr[l.a.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17992a[l.a.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17992a[l.a.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17992a[l.a.CANCELED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class i extends BroadcastReceiver {

        /* renamed from: c */
        public static final String f17993c = "downloadButtonAction";

        /* renamed from: d */
        public static final String f17994d = "downloadAction";

        /* renamed from: a */
        public final com.sigmob.sdk.downloader.f f17995a;

        /* renamed from: b */
        public final BaseAdUnit f17996b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i.this.f17995a.f();
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                p.a(com.sigmob.sdk.a.d(), i.this.f17995a.j().getAbsolutePath(), i.this.f17996b);
            }
        }

        public i(com.sigmob.sdk.downloader.f fVar, BaseAdUnit baseAdUnit) {
            this.f17995a = fVar;
            this.f17996b = baseAdUnit;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.f17995a == null) {
                return;
            }
            if (!Objects.equals(intent.getAction(), "downloadButtonAction_" + this.f17996b.getUuid() + hf.e.f26694a + this.f17995a.b())) {
                if (com.sigmob.sdk.downloader.l.c(this.f17995a)) {
                    WindAds.sharedAds().getHandler().post(new b());
                }
            } else {
                if (!com.sigmob.sdk.downloader.l.e(this.f17995a)) {
                    this.f17995a.g();
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(p3.i.f29758c, "1");
                hashMap.put("downloadId", this.f17996b.getDownloadId());
                BaseBroadcastReceiver.a(context, this.f17996b.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
                WindAds.sharedAds().getHandler().postDelayed(new a(), 200L);
            }
        }
    }

    public static int a(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return -1;
        }
        downloadTask.c((com.sigmob.sdk.downloader.c) null);
        downloadTask.f();
        com.sigmob.sdk.downloader.g.j().a().g(downloadTask.b());
        File z10 = downloadTask.z();
        if (z10 != null && z10.exists()) {
            z10.delete();
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.cancel(downloadTask.b());
        }
        File j10 = downloadTask.j();
        if (j10 != null && j10.exists()) {
            j10.delete();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(p3.i.f29758c, "0");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        baseAdUnit.setDownloadId(null);
        baseAdUnit.setDownloadTask(null);
        if (baseAdUnit.isRecord()) {
            b0.b(PointCategory.DOWNLOAD_END, "0", baseAdUnit);
        }
        b0.a(PointCategory.APKDOWNLOAD, PointCategory.END, baseAdUnit, new b());
        return 0;
    }

    public static int b(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null || !com.sigmob.sdk.downloader.l.e(downloadTask)) {
            return -1;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(p3.i.f29758c, "1");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_PAUSE);
        WindAds.sharedAds().getHandler().postDelayed(new a(downloadTask), 200L);
        return 0;
    }

    public static long[] c(Context context, BaseAdUnit baseAdUnit) {
        l.a c10;
        long[] jArr = {-1, -1, 0};
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null) {
            return jArr;
        }
        com.sigmob.sdk.downloader.core.breakpoint.c n10 = downloadTask.n();
        if (n10 != null) {
            jArr[0] = n10.j();
            jArr[1] = n10.i();
            c10 = com.sigmob.sdk.downloader.l.b(downloadTask);
        } else {
            c10 = com.sigmob.sdk.downloader.l.c(baseAdUnit.getDownloadUrl(), com.sigmob.sdk.base.utils.d.a(context).getAbsolutePath(), baseAdUnit.getApkName());
        }
        int i10 = h.f17992a[c10.ordinal()];
        if (i10 == 1) {
            jArr[2] = 2;
        } else if (i10 == 2) {
            jArr[2] = 8;
        } else if (i10 == 3) {
            jArr[2] = 1;
        } else if (i10 != 4) {
            jArr[2] = 16;
        } else {
            jArr[2] = 4;
        }
        return jArr;
    }

    public static int d(Context context, BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.downloader.f downloadTask = baseAdUnit.getDownloadTask();
        if (downloadTask == null || com.sigmob.sdk.downloader.l.e(downloadTask)) {
            return -1;
        }
        downloadTask.g();
        return 0;
    }

    public static String a(BaseAdUnit baseAdUnit, String str) {
        String apkMd5 = baseAdUnit.getApkMd5();
        if (TextUtils.isEmpty(apkMd5)) {
            apkMd5 = Md5Util.md5(str);
        }
        return apkMd5 + ".apk";
    }

    public static void a(String str, BaseAdUnit baseAdUnit, boolean z10) {
        String str2;
        Object obj;
        String str3;
        com.sigmob.sdk.downloader.f downloadTask;
        int i10;
        int i11;
        Context d10;
        com.sigmob.sdk.downloader.core.breakpoint.g a10;
        Context d11 = com.sigmob.sdk.a.d();
        try {
            downloadTask = baseAdUnit.getDownloadTask();
            if (downloadTask != null) {
                str3 = downloadTask.j().getAbsolutePath();
                try {
                    if (com.sigmob.sdk.downloader.l.c(downloadTask)) {
                        if (baseAdUnit.isRecord()) {
                            com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.H);
                        }
                        WindAds.sharedAds().getHandler().post(new c(downloadTask, baseAdUnit));
                        return;
                    } else {
                        if (com.sigmob.sdk.downloader.l.e(downloadTask)) {
                            g0.makeText(d11, "正在下载", 1).show();
                            HashMap hashMap = new HashMap();
                            hashMap.put(p3.i.f29758c, "1");
                            hashMap.put("downloadId", baseAdUnit.getDownloadId());
                            BaseBroadcastReceiver.a(d11, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
                            return;
                        }
                        str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                        obj = "downloadId";
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                    obj = "downloadId";
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put(p3.i.f29758c, "0");
                    hashMap2.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(d11, baseAdUnit.getUuid(), hashMap2, str2);
                    b0.a("download_start", "0", baseAdUnit, new f(str, str3));
                    b0.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new g(th, d11));
                }
            } else {
                f.a b10 = new f.a(str, com.sigmob.sdk.base.utils.d.a(d11)).a(baseAdUnit.getApkName()).b(false);
                b10.a("User-Agent", Networking.getUserAgent());
                downloadTask = z10 ? b10.a() : b10.a(1).a();
                if (com.sigmob.sdk.downloader.l.e(downloadTask)) {
                    com.sigmob.sdk.downloader.g.j().e().a((com.sigmob.sdk.downloader.core.a) downloadTask);
                }
                File j10 = downloadTask.j();
                if (j10 != null && j10.exists()) {
                    j10.delete();
                }
                if (j10.getParentFile().exists()) {
                    j10.getParentFile().mkdirs();
                }
                d dVar = new d(com.sigmob.sdk.a.d(), baseAdUnit, d11);
                Intent intent = new Intent("downloadButtonAction_" + baseAdUnit.getUuid() + hf.e.f26694a + downloadTask.b());
                intent.setPackage(com.sigmob.sdk.a.d().getPackageName());
                i iVar = new i(downloadTask, baseAdUnit);
                str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("downloadAction_");
                    obj = "downloadId";
                    try {
                        sb2.append(baseAdUnit.getUuid());
                        sb2.append(hf.e.f26694a);
                        sb2.append(downloadTask.b());
                        IntentFilter intentFilter = new IntentFilter(sb2.toString());
                        intentFilter.addAction("downloadButtonAction_" + baseAdUnit.getUuid() + hf.e.f26694a + downloadTask.b());
                        u.a(d11, iVar, intentFilter);
                        Intent intent2 = new Intent("downloadAction_" + baseAdUnit.getUuid() + hf.e.f26694a + downloadTask.b());
                        intent2.setPackage(com.sigmob.sdk.a.d().getPackageName());
                        List<com.sigmob.sdk.videoAd.f> arrayList = new ArrayList<>();
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.f17663p, 0.25f));
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.f17647a0, 0.5f));
                        arrayList.add(new com.sigmob.sdk.videoAd.f(com.sigmob.sdk.base.common.a.f17649b0, 0.75f));
                        baseAdUnit.setDownloadQuarterTrack(arrayList);
                        dVar.a(baseAdUnit.getIconUrl(), baseAdUnit.getAppName(), baseAdUnit.getDesc());
                        if (Build.VERSION.SDK_INT >= 31) {
                            i10 = 201326592;
                            i11 = 0;
                            dVar.a(PendingIntent.getBroadcast(com.sigmob.sdk.a.d(), 0, intent, 201326592));
                            d10 = com.sigmob.sdk.a.d();
                        } else {
                            i10 = 134217728;
                            i11 = 0;
                            dVar.a(PendingIntent.getBroadcast(com.sigmob.sdk.a.d(), 0, intent, 134217728));
                            d10 = com.sigmob.sdk.a.d();
                        }
                        dVar.b(PendingIntent.getBroadcast(d10, i11, intent2, i10));
                        downloadTask.c(dVar);
                        baseAdUnit.setDownloadTask(downloadTask);
                        if (!baseAdUnit.isResumableDownload() && (a10 = com.sigmob.sdk.downloader.g.j().a()) != null) {
                            a10.g(downloadTask.b());
                        }
                        str3 = null;
                    } catch (Throwable th3) {
                        th = th3;
                        str3 = null;
                        HashMap hashMap22 = new HashMap();
                        hashMap22.put(p3.i.f29758c, "0");
                        hashMap22.put(obj, baseAdUnit.getDownloadId());
                        BaseBroadcastReceiver.a(d11, baseAdUnit.getUuid(), hashMap22, str2);
                        b0.a("download_start", "0", baseAdUnit, new f(str, str3));
                        b0.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new g(th, d11));
                    }
                } catch (Throwable th4) {
                    th = th4;
                    obj = "downloadId";
                    str3 = null;
                    HashMap hashMap222 = new HashMap();
                    hashMap222.put(p3.i.f29758c, "0");
                    hashMap222.put(obj, baseAdUnit.getDownloadId());
                    BaseBroadcastReceiver.a(d11, baseAdUnit.getUuid(), hashMap222, str2);
                    b0.a("download_start", "0", baseAdUnit, new f(str, str3));
                    b0.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new g(th, d11));
                }
            }
        } catch (Throwable th5) {
            th = th5;
            str2 = IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START;
        }
        try {
            baseAdUnit.setDownloadId(Long.valueOf(downloadTask.b()));
            downloadTask.g();
            g0.makeText(d11, "已开始下载", 1).show();
            if (baseAdUnit.isRecord()) {
                com.sigmob.sdk.base.network.f.a(baseAdUnit, "download_start");
                b0.a("download_start", "1", baseAdUnit, new e(str, str3));
            }
        } catch (Throwable th6) {
            th = th6;
            HashMap hashMap2222 = new HashMap();
            hashMap2222.put(p3.i.f29758c, "0");
            hashMap2222.put(obj, baseAdUnit.getDownloadId());
            BaseBroadcastReceiver.a(d11, baseAdUnit.getUuid(), hashMap2222, str2);
            b0.a("download_start", "0", baseAdUnit, new f(str, str3));
            b0.a(PointCategory.APKDOWNLOAD, "start", baseAdUnit, new g(th, d11));
        }
    }
}
