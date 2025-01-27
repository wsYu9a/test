package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    private static volatile g f21618a;

    /* renamed from: f */
    private long f21623f;

    /* renamed from: c */
    private final List<com.ss.android.downloadlib.addownload.g> f21620c = new CopyOnWriteArrayList();

    /* renamed from: d */
    private final Map<String, com.ss.android.downloadlib.addownload.g> f21621d = new ConcurrentHashMap();

    /* renamed from: e */
    private final CopyOnWriteArrayList<Object> f21622e = new CopyOnWriteArrayList<>();

    /* renamed from: b */
    private final Handler f21619b = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.g$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadModel f21624a;

        /* renamed from: b */
        final /* synthetic */ DownloadController f21625b;

        /* renamed from: c */
        final /* synthetic */ DownloadEventConfig f21626c;

        public AnonymousClass1(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
            downloadModel = downloadModel;
            downloadController = downloadController;
            downloadEventConfig = downloadEventConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = g.this.f21622e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.a.a) {
                    ((com.ss.android.download.api.download.a.a) next).a(downloadModel, downloadController, downloadEventConfig);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadModel, downloadController, downloadEventConfig);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21628a;

        /* renamed from: b */
        final /* synthetic */ BaseException f21629b;

        /* renamed from: c */
        final /* synthetic */ String f21630c;

        public AnonymousClass2(DownloadInfo downloadInfo, BaseException baseException, String str) {
            downloadInfo = downloadInfo;
            baseException = baseException;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = g.this.f21622e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.a.a) {
                    ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, baseException, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, baseException, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21632a;

        /* renamed from: b */
        final /* synthetic */ String f21633b;

        public AnonymousClass3(DownloadInfo downloadInfo, String str) {
            downloadInfo = downloadInfo;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = g.this.f21622e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.a.a) {
                    ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21635a;

        /* renamed from: b */
        final /* synthetic */ String f21636b;

        public AnonymousClass4(DownloadInfo downloadInfo, String str) {
            downloadInfo = downloadInfo;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = g.this.f21622e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.a.a) {
                    ((com.ss.android.download.api.download.a.a) next).b(downloadInfo, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) softReference.get()).b(downloadInfo, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.g$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ DownloadInfo f21638a;

        public AnonymousClass5(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = g.this.f21622e.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.a.a) {
                    ((com.ss.android.download.api.download.a.a) next).a(downloadInfo);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo);
                    }
                }
            }
        }
    }

    private g() {
    }

    private synchronized void b(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        try {
            if (this.f21620c.size() <= 0) {
                c(context, i10, downloadStatusChangeListener, downloadModel);
            } else {
                com.ss.android.downloadlib.addownload.g remove = this.f21620c.remove(0);
                remove.b(context).b(i10, downloadStatusChangeListener).b(downloadModel).a();
                this.f21621d.put(downloadModel.getDownloadUrl(), remove);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void c(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i10, downloadStatusChangeListener).b(downloadModel).a();
        this.f21621d.put(downloadModel.getDownloadUrl(), eVar);
    }

    private void d() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.g gVar : this.f21620c) {
            if (!gVar.b() && currentTimeMillis - gVar.d() > 300000) {
                gVar.h();
                arrayList.add(gVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f21620c.removeAll(arrayList);
    }

    public static g a() {
        if (f21618a == null) {
            synchronized (g.class) {
                try {
                    if (f21618a == null) {
                        f21618a = new g();
                    }
                } finally {
                }
            }
        }
        return f21618a;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f21623f < 300000) {
            return;
        }
        this.f21623f = currentTimeMillis;
        if (this.f21620c.isEmpty()) {
            return;
        }
        d();
    }

    public void a(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z10 = k.j().optInt("filter_download_url_key", 0) == 1;
        String a10 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel.getDownloadUrl());
        if (z10 && !TextUtils.isEmpty(a10)) {
            gVar = this.f21621d.get(a10);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(a10);
                }
            }
        } else {
            gVar = this.f21621d.get(downloadModel.getDownloadUrl());
        }
        if (gVar != null) {
            gVar.b(context).b(i10, downloadStatusChangeListener).b(downloadModel).a();
            return;
        }
        if (this.f21620c.isEmpty()) {
            if (z10) {
                if (!TextUtils.isEmpty(a10)) {
                    b(context, i10, downloadStatusChangeListener, downloadModel, a10);
                    return;
                }
                String a11 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel);
                if (TextUtils.isEmpty(a11)) {
                    c(context, i10, downloadStatusChangeListener, downloadModel);
                    return;
                }
                b(context, i10, downloadStatusChangeListener, downloadModel, a11);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(a11);
                        return;
                    }
                    return;
                }
                return;
            }
            c(context, i10, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z10) {
            if (!TextUtils.isEmpty(a10)) {
                a(context, i10, downloadStatusChangeListener, downloadModel, a10);
                return;
            }
            String a12 = com.ss.android.downloadlib.addownload.f.a().a(downloadModel);
            if (TextUtils.isEmpty(a12)) {
                b(context, i10, downloadStatusChangeListener, downloadModel);
                return;
            }
            a(context, i10, downloadStatusChangeListener, downloadModel, a12);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(a12);
                    return;
                }
                return;
            }
            return;
        }
        b(context, i10, downloadStatusChangeListener, downloadModel);
    }

    private void b(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.e eVar = new com.ss.android.downloadlib.addownload.e();
        eVar.b(context).b(i10, downloadStatusChangeListener).b(downloadModel).a(str).a();
        this.f21621d.put(str, eVar);
        com.ss.android.downloadlib.addownload.f.a().a(str, downloadModel.getDownloadUrl());
    }

    public void b(DownloadInfo downloadInfo, String str) {
        this.f21619b.post(new Runnable() { // from class: com.ss.android.downloadlib.g.4

            /* renamed from: a */
            final /* synthetic */ DownloadInfo f21635a;

            /* renamed from: b */
            final /* synthetic */ String f21636b;

            public AnonymousClass4(DownloadInfo downloadInfo2, String str2) {
                downloadInfo = downloadInfo2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = g.this.f21622e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).b(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).b(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler b() {
        return this.f21619b;
    }

    public com.ss.android.downloadlib.addownload.e a(String str) {
        com.ss.android.downloadlib.addownload.g gVar;
        Map<String, com.ss.android.downloadlib.addownload.g> map = this.f21621d;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (k.j().optInt("filter_download_url_key", 0) == 1) {
                gVar = this.f21621d.get(com.ss.android.downloadlib.addownload.f.a().a(str));
            } else {
                gVar = this.f21621d.get(str);
            }
            if (gVar instanceof com.ss.android.downloadlib.addownload.e) {
                return (com.ss.android.downloadlib.addownload.e) gVar;
            }
        }
        return null;
    }

    private synchronized void a(Context context, int i10, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        try {
            if (this.f21620c.size() <= 0) {
                b(context, i10, downloadStatusChangeListener, downloadModel, str);
            } else {
                com.ss.android.downloadlib.addownload.g remove = this.f21620c.remove(0);
                remove.b(context).b(i10, downloadStatusChangeListener).b(downloadModel).a(str).a();
                this.f21621d.put(str, remove);
                com.ss.android.downloadlib.addownload.f.a().a(str, downloadModel.getDownloadUrl());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void a(String str, int i10) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z10 = k.j().optInt("filter_download_url_key", 0) == 1;
        String a10 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z10 && !TextUtils.isEmpty(a10)) {
            gVar = this.f21621d.get(a10);
        } else {
            gVar = this.f21621d.get(str);
        }
        if (gVar != null) {
            if (gVar.a(i10)) {
                this.f21620c.add(gVar);
                if (z10 && !TextUtils.isEmpty(a10)) {
                    this.f21621d.remove(a10);
                    com.ss.android.downloadlib.addownload.f.a().b(a10);
                } else {
                    this.f21621d.remove(str);
                }
            }
            c();
        }
    }

    public void a(String str, boolean z10) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z11 = k.j().optInt("filter_download_url_key", 0) == 1;
        String a10 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z11 && !TextUtils.isEmpty(a10)) {
            gVar = this.f21621d.get(a10);
        } else {
            gVar = this.f21621d.get(str);
        }
        if (gVar != null) {
            gVar.a(z10);
        }
    }

    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        a(str, j10, i10, downloadEventConfig, downloadController, null, null);
    }

    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        a(str, j10, i10, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void a(String str, long j10, int i10, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.g gVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z10 = k.j().optInt("filter_download_url_key", 0) == 1;
        String a10 = com.ss.android.downloadlib.addownload.f.a().a(str);
        if (z10 && !TextUtils.isEmpty(a10)) {
            gVar = this.f21621d.get(a10);
        } else {
            gVar = this.f21621d.get(str);
        }
        if (gVar != null) {
            gVar.a(j10).b(downloadEventConfig).b(downloadController).a(onItemClickListener).a(iDownloadButtonClickListener).b(i10);
        }
    }

    public void a(com.ss.android.download.api.download.a.a aVar) {
        if (aVar != null) {
            if (DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.f21622e.add(new SoftReference(aVar));
            } else {
                this.f21622e.add(aVar);
            }
        }
    }

    public void a(DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        this.f21619b.post(new Runnable() { // from class: com.ss.android.downloadlib.g.1

            /* renamed from: a */
            final /* synthetic */ DownloadModel f21624a;

            /* renamed from: b */
            final /* synthetic */ DownloadController f21625b;

            /* renamed from: c */
            final /* synthetic */ DownloadEventConfig f21626c;

            public AnonymousClass1(DownloadModel downloadModel2, DownloadController downloadController2, DownloadEventConfig downloadEventConfig2) {
                downloadModel = downloadModel2;
                downloadController = downloadController2;
                downloadEventConfig = downloadEventConfig2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = g.this.f21622e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.f21619b.post(new Runnable() { // from class: com.ss.android.downloadlib.g.2

            /* renamed from: a */
            final /* synthetic */ DownloadInfo f21628a;

            /* renamed from: b */
            final /* synthetic */ BaseException f21629b;

            /* renamed from: c */
            final /* synthetic */ String f21630c;

            public AnonymousClass2(DownloadInfo downloadInfo2, BaseException baseException2, String str2) {
                downloadInfo = downloadInfo2;
                baseException = baseException2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = g.this.f21622e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void a(DownloadInfo downloadInfo, String str) {
        this.f21619b.post(new Runnable() { // from class: com.ss.android.downloadlib.g.3

            /* renamed from: a */
            final /* synthetic */ DownloadInfo f21632a;

            /* renamed from: b */
            final /* synthetic */ String f21633b;

            public AnonymousClass3(DownloadInfo downloadInfo2, String str2) {
                downloadInfo = downloadInfo2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = g.this.f21622e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void a(DownloadInfo downloadInfo) {
        this.f21619b.post(new Runnable() { // from class: com.ss.android.downloadlib.g.5

            /* renamed from: a */
            final /* synthetic */ DownloadInfo f21638a;

            public AnonymousClass5(DownloadInfo downloadInfo2) {
                downloadInfo = downloadInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = g.this.f21622e.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.a.a) {
                        ((com.ss.android.download.api.download.a.a) next).a(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a.a) {
                            ((com.ss.android.download.api.download.a.a) softReference.get()).a(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
