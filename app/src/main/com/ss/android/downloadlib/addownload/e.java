package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.c;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.h;
import com.ss.android.downloadlib.g.n;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e implements g, n.a {

    /* renamed from: a */
    private static final String f21409a = "e";

    /* renamed from: b */
    private final com.ss.android.downloadlib.g.n f21410b;

    /* renamed from: c */
    private h f21411c;

    /* renamed from: d */
    private d f21412d;

    /* renamed from: e */
    private WeakReference<Context> f21413e;

    /* renamed from: f */
    private final Map<Integer, Object> f21414f;

    /* renamed from: g */
    private DownloadShortInfo f21415g;

    /* renamed from: h */
    private DownloadInfo f21416h;

    /* renamed from: i */
    private c f21417i;

    /* renamed from: j */
    private final IDownloadListener f21418j;

    /* renamed from: k */
    private boolean f21419k;

    /* renamed from: l */
    private long f21420l;

    /* renamed from: m */
    private String f21421m;

    /* renamed from: n */
    private long f21422n;

    /* renamed from: o */
    private DownloadModel f21423o;

    /* renamed from: p */
    private DownloadEventConfig f21424p;

    /* renamed from: q */
    private DownloadController f21425q;

    /* renamed from: r */
    private SoftReference<OnItemClickListener> f21426r;

    /* renamed from: s */
    private boolean f21427s;

    /* renamed from: t */
    private final boolean f21428t;

    /* renamed from: u */
    private SoftReference<IDownloadButtonClickListener> f21429u;

    /* renamed from: com.ss.android.downloadlib.addownload.e$2 */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<DownloadStatusChangeListener> it = h.a((Map<Integer, Object>) e.this.f21414f).iterator();
            while (it.hasNext()) {
                it.next().onInstalled(e.this.r());
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$3 */
    public class AnonymousClass3 implements a {

        /* renamed from: a */
        final /* synthetic */ int f21433a;

        /* renamed from: b */
        final /* synthetic */ int f21434b;

        public AnonymousClass3(int i10, int i11) {
            id2 = i10;
            status = i11;
        }

        @Override // com.ss.android.downloadlib.addownload.e.a
        public void a() {
            if (e.this.f21412d.a()) {
                return;
            }
            e eVar = e.this;
            eVar.a(id2, status, eVar.f21416h);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.d().a(13, k.a(), e.this.f21423o, "已恢复下载", null, 0);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$5 */
    public class AnonymousClass5 implements com.ss.android.downloadlib.addownload.a.c {
        public AnonymousClass5() {
        }

        @Override // com.ss.android.downloadlib.addownload.a.c
        public void a() {
            e.this.a(true);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$6 */
    public class AnonymousClass6 implements com.ss.android.downloadlib.addownload.d.h {

        /* renamed from: a */
        final /* synthetic */ int f21438a;

        /* renamed from: b */
        final /* synthetic */ boolean f21439b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21440c;

        /* renamed from: d */
        final /* synthetic */ int f21441d;

        public AnonymousClass6(int i10, boolean z10, com.ss.android.downloadad.api.a.b bVar, int i11) {
            id2 = i10;
            z10 = z10;
            a10 = bVar;
            status = i11;
        }

        @Override // com.ss.android.downloadlib.addownload.d.h
        public void a(com.ss.android.downloadad.api.a.b bVar) {
            if (e.this.f21416h == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                e.this.f21416h = Downloader.getInstance(k.a()).getDownloadInfo(id2);
            }
            e.this.f21411c.a(e.this.f21416h, z10);
            if (e.this.f21416h != null && DownloadUtils.isWifi(k.a()) && e.this.f21416h.isPauseReserveOnWifi()) {
                e.this.f21416h.stopPauseReserveOnWifi();
                com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel_on_wifi", a10);
            } else {
                e eVar = e.this;
                eVar.a(id2, status, eVar.f21416h);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$7 */
    public class AnonymousClass7 implements com.ss.android.downloadlib.addownload.d.h {

        /* renamed from: a */
        final /* synthetic */ int f21443a;

        /* renamed from: b */
        final /* synthetic */ boolean f21444b;

        /* renamed from: c */
        final /* synthetic */ com.ss.android.downloadad.api.a.b f21445c;

        /* renamed from: d */
        final /* synthetic */ int f21446d;

        public AnonymousClass7(int i10, boolean z10, com.ss.android.downloadad.api.a.b bVar, int i11) {
            id2 = i10;
            z10 = z10;
            a10 = bVar;
            status = i11;
        }

        @Override // com.ss.android.downloadlib.addownload.d.h
        public void a(com.ss.android.downloadad.api.a.b bVar) {
            if (e.this.f21416h == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                e.this.f21416h = Downloader.getInstance(k.a()).getDownloadInfo(id2);
            }
            e.this.f21411c.a(e.this.f21416h, z10);
            if (e.this.f21416h != null && DownloadUtils.isWifi(k.a()) && e.this.f21416h.isPauseReserveOnWifi()) {
                e.this.f21416h.stopPauseReserveOnWifi();
                com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", a10);
            } else {
                e eVar = e.this;
                eVar.a(id2, status, eVar.f21416h);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$9 */
    public class AnonymousClass9 implements a {

        /* renamed from: a */
        final /* synthetic */ boolean f21450a;

        public AnonymousClass9(boolean z10) {
            z10 = z10;
        }

        @Override // com.ss.android.downloadlib.addownload.e.a
        public void a() {
            if (e.this.f21412d.a()) {
                return;
            }
            e.this.h(z10);
        }
    }

    public interface a {
        void a();
    }

    public interface b {
        void a(long j10);
    }

    public class c extends AsyncTask<String, Void, DownloadInfo> {
        private c() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (e.this.f21423o != null && !TextUtils.isEmpty(e.this.f21423o.getFilePath())) {
                downloadInfo = !TextUtils.isEmpty(str) ? Downloader.getInstance(k.a()).getDownloadInfo(Downloader.getInstance(k.a()).getDownloadId(str, e.this.f21423o.getFilePath())) : Downloader.getInstance(k.a()).getDownloadInfo(str2, e.this.f21423o.getFilePath());
            }
            return downloadInfo == null ? !TextUtils.isEmpty(str) ? com.ss.android.socialbase.appdownloader.d.j().a(k.a(), str) : com.ss.android.socialbase.appdownloader.d.j().a(k.a(), str2) : downloadInfo;
        }

        public /* synthetic */ c(e eVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || e.this.f21423o == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.b.c a10 = com.ss.android.downloadlib.g.m.a(e.this.f21423o.getPackageName(), e.this.f21423o.getVersionCode(), e.this.f21423o.getVersionName());
                com.ss.android.downloadlib.addownload.b.h.a().a(e.this.f21423o.getVersionCode(), a10.b(), com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo));
                boolean a11 = a10.a();
                if (downloadInfo == null || downloadInfo.getId() == 0 || (!a11 && Downloader.getInstance(k.a()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    if (downloadInfo != null && Downloader.getInstance(k.a()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        e.this.f21416h = null;
                    }
                    if (e.this.f21416h != null) {
                        Downloader.getInstance(k.a()).removeTaskMainListener(e.this.f21416h.getId());
                        if (e.this.f21428t) {
                            Downloader.getInstance(e.this.l()).setMainThreadListener(e.this.f21416h.getId(), e.this.f21418j, false);
                        } else {
                            Downloader.getInstance(e.this.l()).setMainThreadListener(e.this.f21416h.getId(), e.this.f21418j);
                        }
                    }
                    if (!a11) {
                        Iterator<DownloadStatusChangeListener> it = h.a((Map<Integer, Object>) e.this.f21414f).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        e.this.f21416h = null;
                    } else {
                        e eVar = e.this;
                        eVar.f21416h = new DownloadInfo.Builder(eVar.f21423o.getDownloadUrl()).build();
                        e.this.f21416h.setStatus(-3);
                        e.this.f21411c.a(e.this.f21416h, e.this.r(), h.a((Map<Integer, Object>) e.this.f21414f), a11);
                    }
                    e.this.f21411c.c(e.this.f21416h);
                }
                Downloader.getInstance(k.a()).removeTaskMainListener(downloadInfo.getId());
                if (e.this.f21416h == null || e.this.f21416h.getStatus() != -4) {
                    e.this.f21416h = downloadInfo;
                    if (e.this.f21428t) {
                        Downloader.getInstance(k.a()).setMainThreadListener(e.this.f21416h.getId(), e.this.f21418j, false);
                    } else {
                        Downloader.getInstance(k.a()).setMainThreadListener(e.this.f21416h.getId(), e.this.f21418j);
                    }
                } else {
                    e.this.f21416h = null;
                }
                e.this.f21411c.a(e.this.f21416h, e.this.r(), h.a((Map<Integer, Object>) e.this.f21414f), a11);
                e.this.f21411c.c(e.this.f21416h);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public e() {
        com.ss.android.downloadlib.g.n nVar = new com.ss.android.downloadlib.g.n(Looper.getMainLooper(), this);
        this.f21410b = nVar;
        this.f21414f = new ConcurrentHashMap();
        this.f21418j = new h.a(nVar);
        this.f21422n = -1L;
        this.f21423o = null;
        this.f21424p = null;
        this.f21425q = null;
        this.f21411c = new h(this);
        this.f21412d = new d(nVar);
        this.f21428t = DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");
    }

    private void k() {
        SoftReference<OnItemClickListener> softReference = this.f21426r;
        if (softReference == null || softReference.get() == null) {
            k.c().a(l(), this.f21423o, n(), m());
        } else {
            this.f21426r.get().onItemClick(this.f21423o, m(), n());
            this.f21426r = null;
        }
    }

    public Context l() {
        WeakReference<Context> weakReference = this.f21413e;
        return (weakReference == null || weakReference.get() == null) ? k.a() : this.f21413e.get();
    }

    @NonNull
    private DownloadEventConfig m() {
        DownloadEventConfig downloadEventConfig = this.f21424p;
        return downloadEventConfig == null ? new c.a().a() : downloadEventConfig;
    }

    @NonNull
    private DownloadController n() {
        if (this.f21425q == null) {
            this.f21425q = new com.ss.android.download.api.download.b();
        }
        return this.f21425q;
    }

    private void o() {
        String str = f21409a;
        com.ss.android.downloadlib.g.k.a(str, "pICD", null);
        if (this.f21411c.d(this.f21416h)) {
            com.ss.android.downloadlib.g.k.a(str, "pICD BC", null);
            f(false);
        } else {
            com.ss.android.downloadlib.g.k.a(str, "pICD IC", null);
            k();
        }
    }

    private boolean p() {
        if (!DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            DownloadInfo downloadInfo = this.f21416h;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(k.a()).canResume(this.f21416h.getId())) || this.f21416h.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.f21416h;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.f21416h.getCurBytes() <= 0) || this.f21416h.getStatus() == 0 || this.f21416h.getStatus() == -4) {
            return true;
        }
        return DownloadUtils.isDownloadSuccessAndFileNotExist(this.f21416h.getStatus(), this.f21416h.getSavePath(), this.f21416h.getName());
    }

    private void q() {
        c cVar = this.f21417i;
        if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.f21417i.cancel(true);
        }
        this.f21417i = new c();
        if (TextUtils.isEmpty(this.f21421m)) {
            com.ss.android.downloadlib.g.b.a(this.f21417i, this.f21423o.getDownloadUrl(), this.f21423o.getPackageName());
        } else {
            com.ss.android.downloadlib.g.b.a(this.f21417i, this.f21423o.getDownloadUrl(), this.f21423o.getPackageName(), this.f21421m);
        }
    }

    public DownloadShortInfo r() {
        if (this.f21415g == null) {
            this.f21415g = new DownloadShortInfo();
        }
        return this.f21415g;
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$8 */
    public class AnonymousClass8 implements t {

        /* renamed from: a */
        final /* synthetic */ boolean f21448a;

        public AnonymousClass8(boolean z10) {
            z11 = z10;
        }

        @Override // com.ss.android.download.api.config.t
        public void a() {
            com.ss.android.downloadlib.g.k.a(e.f21409a, "pBCD start download", null);
            e.this.g(z11);
        }

        @Override // com.ss.android.download.api.config.t
        public void a(String str) {
            com.ss.android.downloadlib.g.k.a(e.f21409a, "pBCD onDenied", null);
        }
    }

    public void g(boolean z10) {
        this.f21412d.a(new com.ss.android.downloadlib.addownload.b.e(this.f21422n, this.f21423o, m(), n()));
        this.f21412d.a(0, 0L, 0L, new a() { // from class: com.ss.android.downloadlib.addownload.e.9

            /* renamed from: a */
            final /* synthetic */ boolean f21450a;

            public AnonymousClass9(boolean z102) {
                z10 = z102;
            }

            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f21412d.a()) {
                    return;
                }
                e.this.h(z10);
            }
        });
    }

    public void h(boolean z10) {
        Iterator<DownloadStatusChangeListener> it = h.a(this.f21414f).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.f21423o, n());
        }
        int a10 = this.f21411c.a(k.a(), this.f21418j);
        String str = f21409a;
        com.ss.android.downloadlib.g.k.a(str, "beginDown id:" + a10, null);
        if (a10 == 0) {
            DownloadInfo build = new DownloadInfo.Builder(this.f21423o.getDownloadUrl()).build();
            build.setStatus(-1);
            a(build);
            com.ss.android.downloadlib.d.a.a().a(this.f21422n, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.e.c.a().b("beginDown");
        } else if (this.f21416h != null && !DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            this.f21411c.a(this.f21416h, false);
        } else if (z10) {
            this.f21411c.a();
        }
        if (this.f21411c.a(c())) {
            com.ss.android.downloadlib.g.k.a(str, "beginDown IC id:" + a10, null);
            k();
        }
    }

    public boolean c() {
        DownloadInfo downloadInfo = this.f21416h;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public long d() {
        return this.f21420l;
    }

    public boolean e() {
        return k.j().optInt("quick_app_enable_switch", 0) == 0 && this.f21423o.getQuickAppModel() != null && !TextUtils.isEmpty(this.f21423o.getQuickAppModel().a()) && com.ss.android.downloadlib.addownload.c.a(this.f21416h) && com.ss.android.downloadlib.g.m.a(l(), new Intent("android.intent.action.VIEW", Uri.parse(this.f21423o.getQuickAppModel().a())));
    }

    public void f() {
        this.f21410b.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.2
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = h.a((Map<Integer, Object>) e.this.f21414f).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(e.this.r());
                }
            }
        });
    }

    public boolean i() {
        SoftReference<IDownloadButtonClickListener> softReference = this.f21429u;
        if (softReference == null) {
            return false;
        }
        return i.a(this.f21423o, softReference.get());
    }

    private boolean c(int i10) {
        if (!e()) {
            return false;
        }
        String a10 = this.f21423o.getQuickAppModel().a();
        int i11 = i10 != 1 ? i10 != 2 ? -1 : 4 : 5;
        DownloadModel downloadModel = this.f21423o;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean c10 = com.ss.android.downloadlib.g.i.c(k.a(), a10);
        if (c10) {
            com.ss.android.downloadlib.d.a.a().a(this.f21422n, i10);
            Message obtain = Message.obtain();
            obtain.what = i11;
            obtain.obj = Long.valueOf(this.f21423o.getId());
            com.ss.android.downloadlib.addownload.c.a().a(this, i11, this.f21423o);
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.f21422n, false, 0);
        }
        return c10;
    }

    private void f(boolean z10) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = f21409a;
        com.ss.android.downloadlib.g.k.a(str, "pBCD", null);
        if (p()) {
            com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(this.f21422n);
            if (this.f21427s) {
                if (i()) {
                    if (d(false) && (downloadController2 = e10.f21219d) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        a(z10, true);
                        return;
                    }
                    return;
                }
                a(z10, true);
                return;
            }
            if (this.f21423o.isAd() && (downloadController = e10.f21219d) != null && downloadController.enableShowComplianceDialog() && e10.f21217b != null && com.ss.android.downloadlib.addownload.compliance.b.a().a(e10.f21217b) && com.ss.android.downloadlib.addownload.compliance.b.a().a(e10)) {
                return;
            }
            a(z10, true);
            return;
        }
        com.ss.android.downloadlib.g.k.a(str, "pBCD continue download, status:" + this.f21416h.getStatus(), null);
        DownloadInfo downloadInfo = this.f21416h;
        if (downloadInfo != null && (downloadModel = this.f21423o) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        int status = this.f21416h.getStatus();
        int id2 = this.f21416h.getId();
        com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(this.f21416h);
        if (status != -2 && status != -1) {
            if (n.a(status)) {
                if (this.f21423o.enablePause()) {
                    this.f21412d.a(true);
                    com.ss.android.downloadlib.c.h.a().b(com.ss.android.downloadlib.addownload.b.f.a().d(this.f21422n));
                    if (com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) a10).optInt("cancel_pause_optimise_switch", 0) == 1) {
                        com.ss.android.downloadlib.addownload.d.d.a().a(a10, status, new com.ss.android.downloadlib.addownload.d.h() { // from class: com.ss.android.downloadlib.addownload.e.6

                            /* renamed from: a */
                            final /* synthetic */ int f21438a;

                            /* renamed from: b */
                            final /* synthetic */ boolean f21439b;

                            /* renamed from: c */
                            final /* synthetic */ com.ss.android.downloadad.api.a.b f21440c;

                            /* renamed from: d */
                            final /* synthetic */ int f21441d;

                            public AnonymousClass6(int id22, boolean z102, com.ss.android.downloadad.api.a.b a102, int status2) {
                                id2 = id22;
                                z10 = z102;
                                a10 = a102;
                                status = status2;
                            }

                            @Override // com.ss.android.downloadlib.addownload.d.h
                            public void a(com.ss.android.downloadad.api.a.b bVar) {
                                if (e.this.f21416h == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                    e.this.f21416h = Downloader.getInstance(k.a()).getDownloadInfo(id2);
                                }
                                e.this.f21411c.a(e.this.f21416h, z10);
                                if (e.this.f21416h != null && DownloadUtils.isWifi(k.a()) && e.this.f21416h.isPauseReserveOnWifi()) {
                                    e.this.f21416h.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.d.a.a().a("cancel_pause_reserve_wifi_cancel_on_wifi", a10);
                                } else {
                                    e eVar = e.this;
                                    eVar.a(id2, status, eVar.f21416h);
                                }
                            }
                        }, new com.ss.android.downloadlib.addownload.a.c() { // from class: com.ss.android.downloadlib.addownload.e.5
                            public AnonymousClass5() {
                            }

                            @Override // com.ss.android.downloadlib.addownload.a.c
                            public void a() {
                                e.this.a(true);
                            }
                        });
                        return;
                    } else {
                        com.ss.android.downloadlib.addownload.d.k.a().a(a102, status2, new com.ss.android.downloadlib.addownload.d.h() { // from class: com.ss.android.downloadlib.addownload.e.7

                            /* renamed from: a */
                            final /* synthetic */ int f21443a;

                            /* renamed from: b */
                            final /* synthetic */ boolean f21444b;

                            /* renamed from: c */
                            final /* synthetic */ com.ss.android.downloadad.api.a.b f21445c;

                            /* renamed from: d */
                            final /* synthetic */ int f21446d;

                            public AnonymousClass7(int id22, boolean z102, com.ss.android.downloadad.api.a.b a102, int status2) {
                                id2 = id22;
                                z10 = z102;
                                a10 = a102;
                                status = status2;
                            }

                            @Override // com.ss.android.downloadlib.addownload.d.h
                            public void a(com.ss.android.downloadad.api.a.b bVar) {
                                if (e.this.f21416h == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                    e.this.f21416h = Downloader.getInstance(k.a()).getDownloadInfo(id2);
                                }
                                e.this.f21411c.a(e.this.f21416h, z10);
                                if (e.this.f21416h != null && DownloadUtils.isWifi(k.a()) && e.this.f21416h.isPauseReserveOnWifi()) {
                                    e.this.f21416h.stopPauseReserveOnWifi();
                                    com.ss.android.downloadlib.d.a.a().b("pause_reserve_wifi_cancel_on_wifi", a10);
                                } else {
                                    e eVar = e.this;
                                    eVar.a(id2, status, eVar.f21416h);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            }
            this.f21411c.a(this.f21416h, z102);
            a(id22, status2, this.f21416h);
            return;
        }
        this.f21411c.a(this.f21416h, z102);
        if (a102 != null) {
            a102.h(System.currentTimeMillis());
            a102.i(this.f21416h.getCurBytes());
        }
        this.f21416h.setDownloadFromReserveWifi(false);
        this.f21412d.a(new com.ss.android.downloadlib.addownload.b.e(this.f21422n, this.f21423o, m(), n()));
        this.f21412d.a(id22, this.f21416h.getCurBytes(), this.f21416h.getTotalBytes(), new a() { // from class: com.ss.android.downloadlib.addownload.e.3

            /* renamed from: a */
            final /* synthetic */ int f21433a;

            /* renamed from: b */
            final /* synthetic */ int f21434b;

            public AnonymousClass3(int id22, int status2) {
                id2 = id22;
                status = status2;
            }

            @Override // com.ss.android.downloadlib.addownload.e.a
            public void a() {
                if (e.this.f21412d.a()) {
                    return;
                }
                e eVar = e.this;
                eVar.a(id2, status, eVar.f21416h);
            }
        });
        if (status2 == -2 && com.ss.android.downloadlib.g.e.a((com.ss.android.downloadad.api.a.a) a102).optInt("show_pause_continue_toast", 0) == 1) {
            com.ss.android.downloadlib.g.a().b().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.e.4
                public AnonymousClass4() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    k.d().a(13, k.a(), e.this.f21423o, "已恢复下载", null, 0);
                }
            }, 500L);
        }
    }

    public boolean d(boolean z10) {
        SoftReference<IDownloadButtonClickListener> softReference = this.f21429u;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z10) {
                    this.f21429u.get().handleComplianceDialog(true);
                } else {
                    this.f21429u.get().handleMarketFailedComplianceDialog();
                }
                this.f21429u = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.e.c.a().b("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void g() {
        if (this.f21414f.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = h.a(this.f21414f).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.f21416h;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.g
    /* renamed from: a */
    public e b(Context context) {
        if (context != null) {
            this.f21413e = new WeakReference<>(context);
        }
        k.b(context);
        return this;
    }

    private void e(boolean z10) {
        if (com.ss.android.downloadlib.g.e.b(this.f21423o).optInt("notification_opt_2") == 1 && this.f21416h != null) {
            DownloadNotificationManager.getInstance().cancelNotification(this.f21416h.getId());
        }
        f(z10);
    }

    @Override // com.ss.android.downloadlib.addownload.g
    /* renamed from: a */
    public e b(int i10, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (k.j().optInt("back_use_softref_listener") == 1) {
                this.f21414f.put(Integer.valueOf(i10), downloadStatusChangeListener);
            } else if (k.j().optInt("use_weakref_listener") == 1) {
                this.f21414f.put(Integer.valueOf(i10), new WeakReference(downloadStatusChangeListener));
            } else {
                this.f21414f.put(Integer.valueOf(i10), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public boolean b() {
        return this.f21419k;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void b(int i10) {
        if (i10 != 1 && i10 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f21411c.a(this.f21422n);
        if (!com.ss.android.downloadlib.addownload.b.f.a().e(this.f21422n).y()) {
            com.ss.android.downloadlib.e.c.a().a("handleDownload ModelBox !isStrictValid");
        }
        if (this.f21411c.a(i10, this.f21423o)) {
            com.ss.android.downloadlib.addownload.compliance.f.a().a(this.f21411c.f21456a, new com.ss.android.downloadlib.addownload.compliance.h() { // from class: com.ss.android.downloadlib.addownload.e.1

                /* renamed from: a */
                final /* synthetic */ int f21430a;

                public AnonymousClass1(int i102) {
                    i10 = i102;
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.h
                public void a(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (com.ss.android.downloadlib.g.h.a(e.this.l(), e.this.f21411c.f21456a, str, jSONObject, true, i10)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 1);
                            com.ss.android.downloadlib.addownload.compliance.f.a().a(0, e.this.f21411c.f21456a, jSONObject);
                        } else {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.f.a().a(1, e.this.f21411c.f21456a, jSONObject);
                            int i11 = i10;
                            if (i11 == 1) {
                                Logger.d(e.f21409a, "miui new rollback fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                                e.this.c(true);
                            } else if (i11 == 2) {
                                Logger.d(e.f21409a, "miui new rollback fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                                e.this.b(true);
                            }
                        }
                    } catch (Exception e10) {
                        com.ss.android.downloadlib.e.c.a().a(e10, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.h
                public void a() {
                    int i11 = i10;
                    if (i11 == 1) {
                        Logger.d(e.f21409a, "miui new get miui deeplink fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                        e.this.c(true);
                        return;
                    }
                    if (i11 != 2) {
                        return;
                    }
                    Logger.d(e.f21409a, "miui new get miui deeplink fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                    e.this.b(true);
                }
            });
            return;
        }
        if (this.f21411c.a(l(), i102, this.f21427s)) {
            return;
        }
        boolean c10 = c(i102);
        if (i102 == 1) {
            if (c10) {
                return;
            }
            com.ss.android.downloadlib.g.k.a(f21409a, "handleDownload id:" + this.f21422n + ",pIC:", null);
            c(true);
            return;
        }
        if (i102 == 2 && !c10) {
            com.ss.android.downloadlib.g.k.a(f21409a, "handleDownload id:" + this.f21422n + ",pBC:", null);
            b(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.g
    /* renamed from: a */
    public e b(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.e.c.a().a("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.e.c.a().a(false, "setDownloadModel id=0");
                if (DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.b.f.a().a(downloadModel);
            this.f21422n = downloadModel.getId();
            this.f21423o = downloadModel;
            if (i.a(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(this.f21422n);
                if (d10 != null && d10.l() != 3) {
                    d10.e(3L);
                    com.ss.android.downloadlib.addownload.b.i.a().a(d10);
                }
            }
        }
        return this;
    }

    /* renamed from: com.ss.android.downloadlib.addownload.e$1 */
    public class AnonymousClass1 implements com.ss.android.downloadlib.addownload.compliance.h {

        /* renamed from: a */
        final /* synthetic */ int f21430a;

        public AnonymousClass1(int i102) {
            i10 = i102;
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.h
        public void a(String str) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_miui_new_market", 1);
                jSONObject.putOpt("download_miui_market_deeplink", str);
                if (com.ss.android.downloadlib.g.h.a(e.this.l(), e.this.f21411c.f21456a, str, jSONObject, true, i10)) {
                    jSONObject.putOpt("download_miui_jump_market_success", 1);
                    com.ss.android.downloadlib.addownload.compliance.f.a().a(0, e.this.f21411c.f21456a, jSONObject);
                } else {
                    jSONObject.putOpt("download_miui_jump_market_success", 0);
                    com.ss.android.downloadlib.addownload.compliance.f.a().a(1, e.this.f21411c.f21456a, jSONObject);
                    int i11 = i10;
                    if (i11 == 1) {
                        Logger.d(e.f21409a, "miui new rollback fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                        e.this.c(true);
                    } else if (i11 == 2) {
                        Logger.d(e.f21409a, "miui new rollback fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                        e.this.b(true);
                    }
                }
            } catch (Exception e10) {
                com.ss.android.downloadlib.e.c.a().a(e10, "generate miui new market param error");
            }
        }

        @Override // com.ss.android.downloadlib.addownload.compliance.h
        public void a() {
            int i11 = i10;
            if (i11 == 1) {
                Logger.d(e.f21409a, "miui new get miui deeplink fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
                e.this.c(true);
                return;
            }
            if (i11 != 2) {
                return;
            }
            Logger.d(e.f21409a, "miui new get miui deeplink fail: handleDownload id:" + e.this.f21422n + ",tryPerformButtonClick:", null);
            e.this.b(true);
        }
    }

    public void c(boolean z10) {
        if (z10) {
            com.ss.android.downloadlib.d.a.a().a(this.f21422n, 1);
        }
        o();
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void h() {
        com.ss.android.downloadlib.addownload.b.f.a().f(this.f21422n);
    }

    public void b(boolean z10) {
        e(z10);
    }

    @Override // com.ss.android.downloadlib.addownload.g
    /* renamed from: a */
    public e b(DownloadController downloadController) {
        JSONObject extra;
        this.f21425q = downloadController;
        if (com.ss.android.downloadlib.g.e.b(this.f21423o).optInt("force_auto_open") == 1) {
            n().setLinkMode(1);
        }
        if (DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.f21423o.getExtra()) != null && extra.optInt("subprocess") > 0) {
            n().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f21422n, n());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    /* renamed from: a */
    public e b(DownloadEventConfig downloadEventConfig) {
        this.f21424p = downloadEventConfig;
        this.f21427s = m().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f21422n, m());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.f21426r = null;
        } else {
            this.f21426r = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void a() {
        this.f21419k = true;
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f21422n, m());
        com.ss.android.downloadlib.addownload.b.f.a().a(this.f21422n, n());
        this.f21411c.a(this.f21422n);
        q();
        if (k.j().optInt("enable_empty_listener", 1) == 1 && this.f21414f.get(Integer.MIN_VALUE) == null) {
            b(Integer.MIN_VALUE, new com.ss.android.download.api.config.a());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public boolean a(int i10) {
        if (i10 == 0) {
            this.f21414f.clear();
        } else {
            this.f21414f.remove(Integer.valueOf(i10));
        }
        if (this.f21414f.isEmpty()) {
            this.f21419k = false;
            this.f21420l = System.currentTimeMillis();
            if (this.f21416h != null) {
                Downloader.getInstance(k.a()).removeTaskMainListener(this.f21416h.getId());
            }
            c cVar = this.f21417i;
            if (cVar != null && cVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.f21417i.cancel(true);
            }
            this.f21411c.a(this.f21416h);
            String str = f21409a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.f21416h;
            sb2.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.g.k.a(str, sb2.toString(), null);
            this.f21410b.removeCallbacksAndMessages(null);
            this.f21415g = null;
            this.f21416h = null;
            return true;
        }
        if (this.f21414f.size() == 1 && this.f21414f.containsKey(Integer.MIN_VALUE)) {
            this.f21411c.b(this.f21416h);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public void a(boolean z10) {
        if (this.f21416h != null) {
            if (z10) {
                com.ss.android.socialbase.appdownloader.c.d b10 = com.ss.android.socialbase.appdownloader.d.j().b();
                if (b10 != null) {
                    b10.a(this.f21416h);
                }
                Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(this.f21416h.getId(), true);
                return;
            }
            Intent intent = new Intent(k.a(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.f21416h.getId());
            k.a().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(long j10) {
        if (j10 != 0) {
            DownloadModel a10 = com.ss.android.downloadlib.addownload.b.f.a().a(j10);
            if (a10 != null) {
                this.f21423o = a10;
                this.f21422n = j10;
                this.f21411c.a(j10);
            }
        } else {
            com.ss.android.downloadlib.e.c.a().a(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.g.n.a
    public void a(Message message) {
        if (message != null && this.f21419k && message.what == 3) {
            this.f21416h = (DownloadInfo) message.obj;
            this.f21411c.a(message, r(), this.f21414f);
        }
    }

    public void a(boolean z10, boolean z11) {
        if (z10) {
            com.ss.android.downloadlib.d.a.a().a(this.f21422n, 2);
        }
        if (!com.ss.android.downloadlib.g.m.a()) {
            if (!com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE") && !n().enableNewActivity()) {
                this.f21423o.setFilePath(this.f21411c.b());
            }
        } else if (!com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_VIDEO") && !n().enableNewActivity()) {
            this.f21423o.setFilePath(this.f21411c.b());
        }
        if (com.ss.android.downloadlib.g.e.c(this.f21423o) == 0) {
            com.ss.android.downloadlib.g.k.a(f21409a, "pBCD not start", null);
            this.f21411c.a(new t() { // from class: com.ss.android.downloadlib.addownload.e.8

                /* renamed from: a */
                final /* synthetic */ boolean f21448a;

                public AnonymousClass8(boolean z112) {
                    z11 = z112;
                }

                @Override // com.ss.android.download.api.config.t
                public void a() {
                    com.ss.android.downloadlib.g.k.a(e.f21409a, "pBCD start download", null);
                    e.this.g(z11);
                }

                @Override // com.ss.android.download.api.config.t
                public void a(String str) {
                    com.ss.android.downloadlib.g.k.a(e.f21409a, "pBCD onDenied", null);
                }
            });
        } else {
            g(z112);
        }
    }

    public void a(int i10, int i11, @NonNull DownloadInfo downloadInfo) {
        if (DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            if (i11 != -3 && !DownloadProcessDispatcher.getInstance().canResume(i10)) {
                a(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.d.j().a(k.a(), i10, i11);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.d.j().a(k.a(), i10, i11);
    }

    private void a(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.f21410b.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21421m = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.g
    public g a(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.f21429u = null;
        } else {
            this.f21429u = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
