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
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.download.i;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.lg;
import com.ss.android.downloadlib.lg.p;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadProcessDispatcher;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
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
public class q implements gv, p.j {

    /* renamed from: j */
    private static final String f24201j = "q";

    /* renamed from: e */
    private boolean f24202e;
    private SoftReference<OnItemClickListener> ei;

    /* renamed from: g */
    private g f24203g;
    private SoftReference<IDownloadButtonClickListener> gm;
    private final Map<Integer, Object> gv;

    /* renamed from: i */
    private lg f24204i;
    private i k;
    private DownloadShortInfo lg;
    private long nt;
    private long p;
    private final IDownloadListener pa;
    private WeakReference<Context> q;
    private DownloadModel r;
    private DownloadController s;
    private boolean t;
    private final boolean v;
    private DownloadEventConfig w;
    private DownloadInfo y;
    private final p zx;

    /* renamed from: com.ss.android.downloadlib.addownload.q$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<DownloadStatusChangeListener> it = lg.j((Map<Integer, Object>) q.this.gv).iterator();
            while (it.hasNext()) {
                it.next().onInstalled(q.this.ei());
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.q$2 */
    class AnonymousClass2 implements j {

        /* renamed from: j */
        final /* synthetic */ int f24207j;
        final /* synthetic */ int zx;

        AnonymousClass2(int i2, int i3) {
            id = i2;
            status = i3;
        }

        @Override // com.ss.android.downloadlib.addownload.q.j
        public void j() {
            if (q.this.f24203g.j()) {
                return;
            }
            q qVar = q.this;
            qVar.j(id, status, qVar.y);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.q$3 */
    class AnonymousClass3 implements com.ss.android.downloadlib.addownload.g.i {

        /* renamed from: g */
        final /* synthetic */ int f24208g;

        /* renamed from: i */
        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24209i;

        /* renamed from: j */
        final /* synthetic */ int f24210j;
        final /* synthetic */ boolean zx;

        AnonymousClass3(int i2, boolean z, com.ss.android.downloadad.api.j.zx zxVar, int i3) {
            id = i2;
            z = z;
            j2 = zxVar;
            status = i3;
        }

        @Override // com.ss.android.downloadlib.addownload.g.i
        public void j(com.ss.android.downloadad.api.j.zx zxVar) {
            if (q.this.y == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                q.this.y = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
            }
            q.this.f24204i.j(q.this.y, z);
            if (q.this.y != null && DownloadUtils.isWifi(pa.getContext()) && q.this.y.isPauseReserveOnWifi()) {
                q.this.y.stopPauseReserveOnWifi();
                com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_cancel_on_wifi", j2);
            } else {
                q qVar = q.this;
                qVar.j(id, status, qVar.y);
            }
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.q$5 */
    class AnonymousClass5 implements j {

        /* renamed from: j */
        final /* synthetic */ boolean f24212j;

        AnonymousClass5(boolean z) {
            z = z;
        }

        @Override // com.ss.android.downloadlib.addownload.q.j
        public void j() {
            if (q.this.f24203g.j()) {
                return;
            }
            q.this.y(z);
        }
    }

    private class i extends AsyncTask<String, Void, DownloadInfo> {
        private i() {
        }

        @Override // android.os.AsyncTask
        /* renamed from: j */
        public DownloadInfo doInBackground(String... strArr) {
            DownloadInfo downloadInfo = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length >= 1 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = strArr[0];
            if (q.this.r != null && !TextUtils.isEmpty(q.this.r.getFilePath())) {
                downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(str, q.this.r.getFilePath());
            }
            return downloadInfo == null ? com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), str) : downloadInfo;
        }

        /* synthetic */ i(q qVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.os.AsyncTask
        /* renamed from: j */
        public void onPostExecute(DownloadInfo downloadInfo) {
            super.onPostExecute(downloadInfo);
            if (isCancelled() || q.this.r == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.zx.i j2 = com.ss.android.downloadlib.lg.nt.j(q.this.r.getPackageName(), q.this.r.getVersionCode(), q.this.r.getVersionName());
                com.ss.android.downloadlib.addownload.zx.y.j().j(q.this.r.getVersionCode(), j2.zx(), com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo));
                boolean j3 = j2.j();
                if (downloadInfo != null && downloadInfo.getId() != 0 && (j3 || !Downloader.getInstance(pa.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo))) {
                    Downloader.getInstance(pa.getContext()).removeTaskMainListener(downloadInfo.getId());
                    if (q.this.y == null || q.this.y.getStatus() != -4) {
                        q.this.y = downloadInfo;
                        if (q.this.v) {
                            Downloader.getInstance(pa.getContext()).setMainThreadListener(q.this.y.getId(), q.this.pa, false);
                        } else {
                            Downloader.getInstance(pa.getContext()).setMainThreadListener(q.this.y.getId(), q.this.pa);
                        }
                    } else {
                        q.this.y = null;
                    }
                    q.this.f24204i.j(q.this.y, q.this.ei(), lg.j((Map<Integer, Object>) q.this.gv));
                } else {
                    if (downloadInfo != null && Downloader.getInstance(pa.getContext()).isDownloadSuccessAndFileNotExist(downloadInfo)) {
                        DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                        q.this.y = null;
                    }
                    if (q.this.y != null) {
                        Downloader.getInstance(pa.getContext()).removeTaskMainListener(q.this.y.getId());
                        if (q.this.v) {
                            Downloader.getInstance(q.this.getContext()).setMainThreadListener(q.this.y.getId(), q.this.pa, false);
                        } else {
                            Downloader.getInstance(q.this.getContext()).setMainThreadListener(q.this.y.getId(), q.this.pa);
                        }
                    }
                    if (!j3) {
                        Iterator<DownloadStatusChangeListener> it = lg.j((Map<Integer, Object>) q.this.gv).iterator();
                        while (it.hasNext()) {
                            it.next().onIdle();
                        }
                        q.this.y = null;
                    } else {
                        q qVar = q.this;
                        qVar.y = new DownloadInfo.Builder(qVar.r.getDownloadUrl()).build();
                        q.this.y.setStatus(-3);
                        q.this.f24204i.j(q.this.y, q.this.ei(), lg.j((Map<Integer, Object>) q.this.gv));
                    }
                }
                q.this.f24204i.i(q.this.y);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    interface j {
        void j();
    }

    interface zx {
        void j(long j2);
    }

    public q() {
        p pVar = new p(Looper.getMainLooper(), this);
        this.zx = pVar;
        this.gv = new ConcurrentHashMap();
        this.pa = new lg.j(pVar);
        this.p = -1L;
        this.r = null;
        this.w = null;
        this.s = null;
        this.f24204i = new lg(this);
        this.f24203g = new g(pVar);
        this.v = DownloadSetting.obtainGlobal().optBugFix("ttdownloader_callback_twice");
    }

    public DownloadShortInfo ei() {
        if (this.lg == null) {
            this.lg = new DownloadShortInfo();
        }
        return this.lg;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.q;
        return (weakReference == null || weakReference.get() == null) ? pa.getContext() : this.q.get();
    }

    @NonNull
    private DownloadEventConfig nt() {
        DownloadEventConfig downloadEventConfig = this.w;
        return downloadEventConfig == null ? new i.j().j() : downloadEventConfig;
    }

    @NonNull
    private DownloadController p() {
        if (this.s == null) {
            this.s = new com.ss.android.download.api.download.zx();
        }
        return this.s;
    }

    private void r() {
        String str = f24201j;
        com.ss.android.downloadlib.lg.t.j(str, "pICD", null);
        if (this.f24204i.g(this.y)) {
            com.ss.android.downloadlib.lg.t.j(str, "pICD BC", null);
            gv(false);
        } else {
            com.ss.android.downloadlib.lg.t.j(str, "pICD IC", null);
            t();
        }
    }

    private void s() {
        i iVar = this.k;
        if (iVar != null && iVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.k.cancel(true);
        }
        i iVar2 = new i();
        this.k = iVar2;
        com.ss.android.downloadlib.lg.zx.j(iVar2, this.r.getDownloadUrl(), this.r.getPackageName());
    }

    private void t() {
        SoftReference<OnItemClickListener> softReference = this.ei;
        if (softReference == null || softReference.get() == null) {
            pa.zx().j(getContext(), this.r, p(), nt());
        } else {
            this.ei.get().onItemClick(this.r, nt(), p());
            this.ei = null;
        }
    }

    private boolean w() {
        if (!DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            DownloadInfo downloadInfo = this.y;
            if (downloadInfo == null) {
                return true;
            }
            return !(downloadInfo.getStatus() == -3 || Downloader.getInstance(pa.getContext()).canResume(this.y.getId())) || this.y.getStatus() == 0;
        }
        DownloadInfo downloadInfo2 = this.y;
        if (downloadInfo2 == null) {
            return true;
        }
        if ((downloadInfo2.getStatus() == -3 && this.y.getCurBytes() <= 0) || this.y.getStatus() == 0 || this.y.getStatus() == -4) {
            return true;
        }
        return DownloadUtils.isDownloadSuccessAndFileNotExist(this.y.getStatus(), this.y.getSavePath(), this.y.getName());
    }

    /* renamed from: com.ss.android.downloadlib.addownload.q$4 */
    class AnonymousClass4 implements gm {

        /* renamed from: j */
        final /* synthetic */ boolean f24211j;

        AnonymousClass4(boolean z) {
            z2 = z;
        }

        @Override // com.ss.android.download.api.config.gm
        public void j() {
            com.ss.android.downloadlib.lg.t.j(q.f24201j, "pBCD start download", null);
            q.this.lg(z2);
        }

        @Override // com.ss.android.download.api.config.gm
        public void j(String str) {
            com.ss.android.downloadlib.lg.t.j(q.f24201j, "pBCD onDenied", null);
        }
    }

    public void lg(boolean z) {
        this.f24203g.j(new com.ss.android.downloadlib.addownload.zx.q(this.p, this.r, nt(), p()));
        this.f24203g.j(0, 0L, 0L, new j() { // from class: com.ss.android.downloadlib.addownload.q.5

            /* renamed from: j */
            final /* synthetic */ boolean f24212j;

            AnonymousClass5(boolean z2) {
                z = z2;
            }

            @Override // com.ss.android.downloadlib.addownload.q.j
            public void j() {
                if (q.this.f24203g.j()) {
                    return;
                }
                q.this.y(z);
            }
        });
    }

    public void y(boolean z) {
        Iterator<DownloadStatusChangeListener> it = lg.j(this.gv).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.r, p());
        }
        int j2 = this.f24204i.j(pa.getContext(), this.pa);
        String str = f24201j;
        com.ss.android.downloadlib.lg.t.j(str, "beginDown id:" + j2, null);
        if (j2 == 0) {
            DownloadInfo build = new DownloadInfo.Builder(this.r.getDownloadUrl()).build();
            build.setStatus(-1);
            j(build);
            com.ss.android.downloadlib.g.j.j().j(this.p, new BaseException(2, "start download failed, id=0"));
            com.ss.android.downloadlib.q.i.j().zx("beginDown");
        } else if (this.y != null && !DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            this.f24204i.j(this.y, false);
        } else if (z) {
            this.f24204i.j();
        }
        if (this.f24204i.j(i())) {
            com.ss.android.downloadlib.lg.t.j(str, "beginDown IC id:" + j2, null);
            t();
        }
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public long g() {
        return this.nt;
    }

    public void gv() {
        this.zx.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.q.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<DownloadStatusChangeListener> it = lg.j((Map<Integer, Object>) q.this.gv).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(q.this.ei());
                }
            }
        });
    }

    public boolean i() {
        DownloadInfo downloadInfo = this.y;
        return (downloadInfo == null || downloadInfo.getStatus() == 0) ? false : true;
    }

    public boolean k() {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference == null) {
            return false;
        }
        return y.j(this.r, softReference.get());
    }

    public boolean q() {
        return pa.k().optInt("quick_app_enable_switch", 0) == 0 && this.r.getQuickAppModel() != null && !TextUtils.isEmpty(this.r.getQuickAppModel().j()) && com.ss.android.downloadlib.addownload.i.j(this.y) && com.ss.android.downloadlib.lg.nt.j(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.r.getQuickAppModel().j())));
    }

    private void gv(boolean z) {
        DownloadModel downloadModel;
        DownloadController downloadController;
        DownloadController downloadController2;
        String str = f24201j;
        com.ss.android.downloadlib.lg.t.j(str, "pBCD", null);
        if (w()) {
            com.ss.android.downloadlib.addownload.zx.q q = com.ss.android.downloadlib.addownload.zx.gv.j().q(this.p);
            if (this.f24202e) {
                if (k()) {
                    if (g(false) && (downloadController2 = q.f24238g) != null && downloadController2.isAutoDownloadOnCardShow()) {
                        j(z, true);
                        return;
                    }
                    return;
                }
                j(z, true);
                return;
            }
            if (this.r.isAd() && (downloadController = q.f24238g) != null && downloadController.enableShowComplianceDialog() && q.zx != null && com.ss.android.downloadlib.addownload.compliance.zx.j().j(q.zx) && com.ss.android.downloadlib.addownload.compliance.zx.j().j(q)) {
                return;
            }
            j(z, true);
            return;
        }
        com.ss.android.downloadlib.lg.t.j(str, "pBCD continue download, status:" + this.y.getStatus(), null);
        DownloadInfo downloadInfo = this.y;
        if (downloadInfo != null && (downloadModel = this.r) != null) {
            downloadInfo.setOnlyWifi(downloadModel.isNeedWifi());
        }
        int status = this.y.getStatus();
        int id = this.y.getId();
        com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(this.y);
        if (status != -2 && status != -1) {
            if (nt.j(status)) {
                if (this.r.enablePause()) {
                    this.f24203g.j(true);
                    com.ss.android.downloadlib.i.y.j().zx(com.ss.android.downloadlib.addownload.zx.gv.j().g(this.p));
                    com.ss.android.downloadlib.addownload.g.gv.j().j(j2, status, new com.ss.android.downloadlib.addownload.g.i() { // from class: com.ss.android.downloadlib.addownload.q.3

                        /* renamed from: g */
                        final /* synthetic */ int f24208g;

                        /* renamed from: i */
                        final /* synthetic */ com.ss.android.downloadad.api.j.zx f24209i;

                        /* renamed from: j */
                        final /* synthetic */ int f24210j;
                        final /* synthetic */ boolean zx;

                        AnonymousClass3(int id2, boolean z2, com.ss.android.downloadad.api.j.zx j22, int status2) {
                            id = id2;
                            z = z2;
                            j2 = j22;
                            status = status2;
                        }

                        @Override // com.ss.android.downloadlib.addownload.g.i
                        public void j(com.ss.android.downloadad.api.j.zx zxVar) {
                            if (q.this.y == null && DownloadSetting.obtainGlobal().optBugFix("fix_handle_pause")) {
                                q.this.y = Downloader.getInstance(pa.getContext()).getDownloadInfo(id);
                            }
                            q.this.f24204i.j(q.this.y, z);
                            if (q.this.y != null && DownloadUtils.isWifi(pa.getContext()) && q.this.y.isPauseReserveOnWifi()) {
                                q.this.y.stopPauseReserveOnWifi();
                                com.ss.android.downloadlib.g.j.j().zx("pause_reserve_wifi_cancel_on_wifi", j2);
                            } else {
                                q qVar = q.this;
                                qVar.j(id, status, qVar.y);
                            }
                        }
                    });
                    return;
                }
                return;
            }
            this.f24204i.j(this.y, z2);
            j(id2, status2, this.y);
            return;
        }
        this.f24204i.j(this.y, z2);
        if (j22 != null) {
            j22.y(System.currentTimeMillis());
            j22.k(this.y.getCurBytes());
        }
        this.y.setDownloadFromReserveWifi(false);
        this.f24203g.j(new com.ss.android.downloadlib.addownload.zx.q(this.p, this.r, nt(), p()));
        this.f24203g.j(id2, this.y.getCurBytes(), this.y.getTotalBytes(), new j() { // from class: com.ss.android.downloadlib.addownload.q.2

            /* renamed from: j */
            final /* synthetic */ int f24207j;
            final /* synthetic */ int zx;

            AnonymousClass2(int id2, int status2) {
                id = id2;
                status = status2;
            }

            @Override // com.ss.android.downloadlib.addownload.q.j
            public void j() {
                if (q.this.f24203g.j()) {
                    return;
                }
                q qVar = q.this;
                qVar.j(id, status, qVar.y);
            }
        });
    }

    private boolean i(int i2) {
        if (!q()) {
            return false;
        }
        int i3 = -1;
        String j2 = this.r.getQuickAppModel().j();
        if (i2 == 1) {
            i3 = 5;
        } else if (i2 == 2) {
            i3 = 4;
        }
        DownloadModel downloadModel = this.r;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        boolean i4 = com.ss.android.downloadlib.lg.k.i(pa.getContext(), j2);
        if (i4) {
            com.ss.android.downloadlib.g.j.j().j(this.p, i2);
            Message obtain = Message.obtain();
            obtain.what = i3;
            obtain.obj = Long.valueOf(this.r.getId());
            com.ss.android.downloadlib.addownload.i.j().j(this, i3, this.r);
        } else {
            com.ss.android.downloadlib.g.j.j().j(this.p, false, 0);
        }
        return i4;
    }

    public boolean g(boolean z) {
        SoftReference<IDownloadButtonClickListener> softReference = this.gm;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z) {
                    this.gm.get().handleComplianceDialog(true);
                } else {
                    this.gm.get().handleMarketFailedComplianceDialog();
                }
                this.gm = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.q.i.j().zx("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.q.i.j().zx("mDownloadButtonClickListener has recycled");
        return false;
    }

    public void lg() {
        if (this.gv.size() == 0) {
            return;
        }
        Iterator<DownloadStatusChangeListener> it = lg.j(this.gv).iterator();
        while (it.hasNext()) {
            it.next().onIdle();
        }
        DownloadInfo downloadInfo = this.y;
        if (downloadInfo != null) {
            downloadInfo.setStatus(-4);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    /* renamed from: j */
    public q zx(Context context) {
        if (context != null) {
            this.q = new WeakReference<>(context);
        }
        pa.zx(context);
        return this;
    }

    private void q(boolean z) {
        if (com.ss.android.downloadlib.lg.q.zx(this.r).optInt("notification_opt_2") == 1 && this.y != null) {
            DownloadNotificationManager.getInstance().cancelNotification(this.y.getId());
        }
        gv(z);
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    /* renamed from: j */
    public q zx(int i2, DownloadStatusChangeListener downloadStatusChangeListener) {
        if (downloadStatusChangeListener != null) {
            if (pa.k().optInt("back_use_softref_listener") == 1) {
                this.gv.put(Integer.valueOf(i2), downloadStatusChangeListener);
            } else {
                this.gv.put(Integer.valueOf(i2), new SoftReference(downloadStatusChangeListener));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public boolean zx() {
        return this.t;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public void zx(int i2) {
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.f24204i.j(this.p);
        if (!com.ss.android.downloadlib.addownload.zx.gv.j().q(this.p).tf()) {
            com.ss.android.downloadlib.q.i.j().j("handleDownload ModelBox !isStrictValid");
        }
        if (this.f24204i.j(getContext(), i2, this.f24202e)) {
            return;
        }
        boolean i3 = i(i2);
        if (i2 == 1) {
            if (i3) {
                return;
            }
            com.ss.android.downloadlib.lg.t.j(f24201j, "handleDownload id:" + this.p + ",pIC:", null);
            i(true);
            return;
        }
        if (i2 == 2 && !i3) {
            com.ss.android.downloadlib.lg.t.j(f24201j, "handleDownload id:" + this.p + ",pBC:", null);
            zx(true);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    /* renamed from: j */
    public q zx(DownloadModel downloadModel) {
        if (downloadModel != null) {
            if (downloadModel.isAd()) {
                if (downloadModel.getId() <= 0 || TextUtils.isEmpty(downloadModel.getLogExtra())) {
                    com.ss.android.downloadlib.q.i.j().j("setDownloadModel ad error");
                }
            } else if (downloadModel.getId() == 0 && (downloadModel instanceof AdDownloadModel)) {
                com.ss.android.downloadlib.q.i.j().j(false, "setDownloadModel id=0");
                if (DownloadSetting.obtainGlobal().optBugFix("fix_model_id")) {
                    ((AdDownloadModel) downloadModel).setId(downloadModel.getDownloadUrl().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadModel);
            this.p = downloadModel.getId();
            this.r = downloadModel;
            if (y.j(downloadModel)) {
                ((AdDownloadModel) downloadModel).setExtraValue(3L);
                com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(this.p);
                if (g2 != null && g2.nt() != 3) {
                    g2.q(3L);
                    com.ss.android.downloadlib.addownload.zx.k.j().j(g2);
                }
            }
        }
        return this;
    }

    public void i(boolean z) {
        if (z) {
            com.ss.android.downloadlib.g.j.j().j(this.p, 1);
        }
        r();
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public void y() {
        com.ss.android.downloadlib.addownload.zx.gv.j().gv(this.p);
    }

    public void zx(boolean z) {
        q(z);
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    /* renamed from: j */
    public q zx(DownloadController downloadController) {
        JSONObject extra;
        this.s = downloadController;
        if (com.ss.android.downloadlib.lg.q.zx(this.r).optInt("force_auto_open") == 1) {
            p().setLinkMode(1);
        }
        if (DownloadSetting.obtainGlobal().optBugFix("fix_show_dialog") && (extra = this.r.getExtra()) != null && extra.optInt("subprocess") > 0) {
            p().setEnableNewActivity(false);
        }
        com.ss.android.downloadlib.addownload.zx.gv.j().j(this.p, p());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    /* renamed from: j */
    public q zx(DownloadEventConfig downloadEventConfig) {
        this.w = downloadEventConfig;
        this.f24202e = nt().getDownloadScene() == 0;
        com.ss.android.downloadlib.addownload.zx.gv.j().j(this.p, nt());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public gv j(OnItemClickListener onItemClickListener) {
        if (onItemClickListener == null) {
            this.ei = null;
        } else {
            this.ei = new SoftReference<>(onItemClickListener);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public void j() {
        this.t = true;
        com.ss.android.downloadlib.addownload.zx.gv.j().j(this.p, nt());
        com.ss.android.downloadlib.addownload.zx.gv.j().j(this.p, p());
        this.f24204i.j(this.p);
        s();
        if (pa.k().optInt("enable_empty_listener", 1) == 1 && this.gv.get(Integer.MIN_VALUE) == null) {
            zx(Integer.MIN_VALUE, new com.ss.android.download.api.config.j());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public boolean j(int i2) {
        if (i2 == 0) {
            this.gv.clear();
        } else {
            this.gv.remove(Integer.valueOf(i2));
        }
        if (this.gv.isEmpty()) {
            this.t = false;
            this.nt = System.currentTimeMillis();
            if (this.y != null) {
                Downloader.getInstance(pa.getContext()).removeTaskMainListener(this.y.getId());
            }
            i iVar = this.k;
            if (iVar != null && iVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.k.cancel(true);
            }
            this.f24204i.j(this.y);
            String str = f24201j;
            StringBuilder sb = new StringBuilder();
            sb.append("onUnbind removeCallbacksAndMessages, downloadUrl:");
            DownloadInfo downloadInfo = this.y;
            sb.append(downloadInfo == null ? "" : downloadInfo.getUrl());
            com.ss.android.downloadlib.lg.t.j(str, sb.toString(), null);
            this.zx.removeCallbacksAndMessages(null);
            this.lg = null;
            this.y = null;
            return true;
        }
        if (this.gv.size() == 1 && this.gv.containsKey(Integer.MIN_VALUE)) {
            this.f24204i.zx(this.y);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public void j(boolean z) {
        if (this.y != null) {
            if (z) {
                com.ss.android.socialbase.appdownloader.i.g zx2 = com.ss.android.socialbase.appdownloader.g.pa().zx();
                if (zx2 != null) {
                    zx2.j(this.y);
                }
                Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(this.y.getId(), true);
                return;
            }
            Intent intent = new Intent(pa.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.y.getId());
            pa.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public gv j(long j2) {
        if (j2 != 0) {
            DownloadModel j3 = com.ss.android.downloadlib.addownload.zx.gv.j().j(j2);
            if (j3 != null) {
                this.r = j3;
                this.p = j2;
                this.f24204i.j(j2);
            }
        } else {
            com.ss.android.downloadlib.q.i.j().j(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.lg.p.j
    public void j(Message message) {
        if (message != null && this.t && message.what == 3) {
            this.y = (DownloadInfo) message.obj;
            this.f24204i.j(message, ei(), this.gv);
        }
    }

    public void j(boolean z, boolean z2) {
        if (z) {
            com.ss.android.downloadlib.g.j.j().j(this.p, 2);
        }
        if (!com.ss.android.downloadlib.lg.pa.zx(com.kuaishou.weapon.p0.g.f9325j) && !p().enableNewActivity()) {
            this.r.setFilePath(this.f24204i.zx());
        }
        if (com.ss.android.downloadlib.lg.q.i(this.r) == 0) {
            com.ss.android.downloadlib.lg.t.j(f24201j, "pBCD not start", null);
            this.f24204i.j(new gm() { // from class: com.ss.android.downloadlib.addownload.q.4

                /* renamed from: j */
                final /* synthetic */ boolean f24211j;

                AnonymousClass4(boolean z22) {
                    z2 = z22;
                }

                @Override // com.ss.android.download.api.config.gm
                public void j() {
                    com.ss.android.downloadlib.lg.t.j(q.f24201j, "pBCD start download", null);
                    q.this.lg(z2);
                }

                @Override // com.ss.android.download.api.config.gm
                public void j(String str) {
                    com.ss.android.downloadlib.lg.t.j(q.f24201j, "pBCD onDenied", null);
                }
            });
        } else {
            lg(z22);
        }
    }

    public void j(int i2, int i3, @NonNull DownloadInfo downloadInfo) {
        if (DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) {
            if (i3 != -3 && !DownloadProcessDispatcher.getInstance().canResume(i2)) {
                j(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), i2, i3);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), i2, i3);
    }

    private void j(DownloadInfo downloadInfo) {
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = downloadInfo;
        this.zx.sendMessage(obtain);
    }

    @Override // com.ss.android.downloadlib.addownload.gv
    public gv j(IDownloadButtonClickListener iDownloadButtonClickListener) {
        if (iDownloadButtonClickListener == null) {
            this.gm = null;
        } else {
            this.gm = new SoftReference<>(iDownloadButtonClickListener);
        }
        return this;
    }
}
