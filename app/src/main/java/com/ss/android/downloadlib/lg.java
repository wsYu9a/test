package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alipay.mobilesecuritysdk.constant.a;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
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
public class lg {

    /* renamed from: j */
    private static volatile lg f24314j;
    private long gv;

    /* renamed from: i */
    private final List<com.ss.android.downloadlib.addownload.gv> f24316i = new CopyOnWriteArrayList();

    /* renamed from: g */
    private final Map<String, com.ss.android.downloadlib.addownload.gv> f24315g = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> q = new CopyOnWriteArrayList<>();
    private final Handler zx = new Handler(Looper.getMainLooper());

    /* renamed from: com.ss.android.downloadlib.lg$1 */
    class AnonymousClass1 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ DownloadEventConfig f24318i;

        /* renamed from: j */
        final /* synthetic */ DownloadModel f24319j;
        final /* synthetic */ DownloadController zx;

        AnonymousClass1(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
            downloadModel = downloadModel;
            downloadController = downloadController;
            downloadEventConfig = downloadEventConfig;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = lg.this.q.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.j.j) {
                    ((com.ss.android.download.api.download.j.j) next).j(downloadModel, downloadController, downloadEventConfig);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadModel, downloadController, downloadEventConfig);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: i */
        final /* synthetic */ String f24321i;

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24322j;
        final /* synthetic */ BaseException zx;

        AnonymousClass2(DownloadInfo downloadInfo, BaseException baseException, String str) {
            downloadInfo = downloadInfo;
            baseException = baseException;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = lg.this.q.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.j.j) {
                    ((com.ss.android.download.api.download.j.j) next).j(downloadInfo, baseException, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo, baseException, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24324j;
        final /* synthetic */ String zx;

        AnonymousClass3(DownloadInfo downloadInfo, String str) {
            downloadInfo = downloadInfo;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = lg.this.q.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.j.j) {
                    ((com.ss.android.download.api.download.j.j) next).j(downloadInfo, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24326j;
        final /* synthetic */ String zx;

        AnonymousClass4(DownloadInfo downloadInfo, String str) {
            downloadInfo = downloadInfo;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = lg.this.q.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.j.j) {
                    ((com.ss.android.download.api.download.j.j) next).zx(downloadInfo, str);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) softReference.get()).zx(downloadInfo, str);
                    }
                }
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.lg$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: j */
        final /* synthetic */ DownloadInfo f24327j;

        AnonymousClass5(DownloadInfo downloadInfo) {
            downloadInfo = downloadInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = lg.this.q.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof com.ss.android.download.api.download.j.j) {
                    ((com.ss.android.download.api.download.j.j) next).j(downloadInfo);
                } else if (next instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) next;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo);
                    }
                }
            }
        }
    }

    private lg() {
    }

    private void g() {
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.gv gvVar : this.f24316i) {
            if (!gvVar.zx() && currentTimeMillis - gvVar.g() > a.k) {
                gvVar.y();
                arrayList.add(gvVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f24316i.removeAll(arrayList);
    }

    private void i(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.q qVar = new com.ss.android.downloadlib.addownload.q();
        qVar.zx(context).zx(i2, downloadStatusChangeListener).zx(downloadModel).j();
        this.f24315g.put(downloadModel.getDownloadUrl(), qVar);
    }

    private synchronized void zx(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.f24316i.size() <= 0) {
            i(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.gv remove = this.f24316i.remove(0);
            remove.zx(context).zx(i2, downloadStatusChangeListener).zx(downloadModel).j();
            this.f24315g.put(downloadModel.getDownloadUrl(), remove);
        }
    }

    public static lg j() {
        if (f24314j == null) {
            synchronized (lg.class) {
                if (f24314j == null) {
                    f24314j = new lg();
                }
            }
        }
        return f24314j;
    }

    private void i() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.gv < a.k) {
            return;
        }
        this.gv = currentTimeMillis;
        if (this.f24316i.isEmpty()) {
            return;
        }
        g();
    }

    public void j(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        com.ss.android.downloadlib.addownload.gv gvVar = this.f24315g.get(downloadModel.getDownloadUrl());
        if (gvVar != null) {
            gvVar.zx(context).zx(i2, downloadStatusChangeListener).zx(downloadModel).j();
        } else if (!this.f24316i.isEmpty()) {
            zx(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            i(context, i2, downloadStatusChangeListener, downloadModel);
        }
    }

    public void zx(DownloadInfo downloadInfo, String str) {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.lg.4

            /* renamed from: j */
            final /* synthetic */ DownloadInfo f24326j;
            final /* synthetic */ String zx;

            AnonymousClass4(DownloadInfo downloadInfo2, String str2) {
                downloadInfo = downloadInfo2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = lg.this.q.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) next).zx(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                            ((com.ss.android.download.api.download.j.j) softReference.get()).zx(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler zx() {
        return this.zx;
    }

    public com.ss.android.downloadlib.addownload.q j(String str) {
        Map<String, com.ss.android.downloadlib.addownload.gv> map = this.f24315g;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            com.ss.android.downloadlib.addownload.gv gvVar = this.f24315g.get(str);
            if (gvVar instanceof com.ss.android.downloadlib.addownload.q) {
                return (com.ss.android.downloadlib.addownload.q) gvVar;
            }
        }
        return null;
    }

    public void j(String str, int i2) {
        com.ss.android.downloadlib.addownload.gv gvVar;
        if (TextUtils.isEmpty(str) || (gvVar = this.f24315g.get(str)) == null) {
            return;
        }
        if (gvVar.j(i2)) {
            this.f24316i.add(gvVar);
            this.f24315g.remove(str);
        }
        i();
    }

    public void j(String str, boolean z) {
        com.ss.android.downloadlib.addownload.gv gvVar;
        if (TextUtils.isEmpty(str) || (gvVar = this.f24315g.get(str)) == null) {
            return;
        }
        gvVar.j(z);
    }

    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        j(str, j2, i2, downloadEventConfig, downloadController, null, null);
    }

    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        j(str, j2, i2, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void j(String str, long j2, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.gv gvVar;
        if (TextUtils.isEmpty(str) || (gvVar = this.f24315g.get(str)) == null) {
            return;
        }
        gvVar.j(j2).zx(downloadEventConfig).zx(downloadController).j(onItemClickListener).j(iDownloadButtonClickListener).zx(i2);
    }

    public void j(com.ss.android.download.api.download.j.j jVar) {
        if (jVar != null) {
            if (DownloadSetting.obtainGlobal().optBugFix("fix_listener_oom", false)) {
                this.q.add(new SoftReference(jVar));
            } else {
                this.q.add(jVar);
            }
        }
    }

    public void j(DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig) {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.lg.1

            /* renamed from: i */
            final /* synthetic */ DownloadEventConfig f24318i;

            /* renamed from: j */
            final /* synthetic */ DownloadModel f24319j;
            final /* synthetic */ DownloadController zx;

            AnonymousClass1(DownloadModel downloadModel2, DownloadController downloadController2, DownloadEventConfig downloadEventConfig2) {
                downloadModel = downloadModel2;
                downloadController = downloadController2;
                downloadEventConfig = downloadEventConfig2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = lg.this.q.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) next).j(downloadModel, downloadController, downloadEventConfig);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                            ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void j(DownloadInfo downloadInfo, BaseException baseException, String str) {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.lg.2

            /* renamed from: i */
            final /* synthetic */ String f24321i;

            /* renamed from: j */
            final /* synthetic */ DownloadInfo f24322j;
            final /* synthetic */ BaseException zx;

            AnonymousClass2(DownloadInfo downloadInfo2, BaseException baseException2, String str2) {
                downloadInfo = downloadInfo2;
                baseException = baseException2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = lg.this.q.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) next).j(downloadInfo, baseException, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                            ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void j(DownloadInfo downloadInfo, String str) {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.lg.3

            /* renamed from: j */
            final /* synthetic */ DownloadInfo f24324j;
            final /* synthetic */ String zx;

            AnonymousClass3(DownloadInfo downloadInfo2, String str2) {
                downloadInfo = downloadInfo2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = lg.this.q.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) next).j(downloadInfo, str);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                            ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void j(DownloadInfo downloadInfo) {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.lg.5

            /* renamed from: j */
            final /* synthetic */ DownloadInfo f24327j;

            AnonymousClass5(DownloadInfo downloadInfo2) {
                downloadInfo = downloadInfo2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = lg.this.q.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next instanceof com.ss.android.download.api.download.j.j) {
                        ((com.ss.android.download.api.download.j.j) next).j(downloadInfo);
                    } else if (next instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) next;
                        if (softReference.get() instanceof com.ss.android.download.api.download.j.j) {
                            ((com.ss.android.download.api.download.j.j) softReference.get()).j(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
