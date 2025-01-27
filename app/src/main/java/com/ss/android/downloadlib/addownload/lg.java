package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.gm;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.lg.p;
import com.ss.android.downloadlib.lg.pa;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class lg implements p.j {

    /* renamed from: g */
    private q f24186g;

    /* renamed from: i */
    private boolean f24187i = false;

    /* renamed from: j */
    private long f24188j;
    private zx q;
    private com.ss.android.downloadlib.addownload.zx.q zx;

    /* renamed from: com.ss.android.downloadlib.addownload.lg$1 */
    class AnonymousClass1 implements gm {

        /* renamed from: j */
        final /* synthetic */ gm f24189j;

        AnonymousClass1(gm gmVar) {
            gmVar = gmVar;
        }

        @Override // com.ss.android.download.api.config.gm
        public void j() {
            gmVar.j();
        }

        @Override // com.ss.android.download.api.config.gm
        public void j(String str) {
            pa.i().j(1, pa.getContext(), lg.this.zx.zx, "您已禁止使用存储权限，请授权后再下载", null, 1);
            com.ss.android.downloadlib.g.j.j().zx(lg.this.f24188j, 1);
            gmVar.j(str);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.lg$3 */
    class AnonymousClass3 implements zx {
        AnonymousClass3() {
        }

        @Override // com.ss.android.downloadlib.addownload.lg.zx
        public void j(DownloadInfo downloadInfo) {
            com.ss.android.downloadlib.g.j.j().j(lg.this.f24188j, 2, downloadInfo);
        }
    }

    static class j extends AbsDownloadExtListener {

        /* renamed from: j */
        private p f24192j;

        j(p pVar) {
            this.f24192j = pVar;
        }

        private void j(DownloadInfo downloadInfo, int i2) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i2;
            this.f24192j.sendMessage(obtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            j(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            j(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            j(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            j(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            j(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            j(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            j(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            j(downloadInfo, 11);
        }
    }

    public interface zx {
        void j(DownloadInfo downloadInfo);
    }

    public lg(q qVar) {
        this.f24186g = qVar;
    }

    private boolean g() {
        DownloadModel downloadModel = this.zx.zx;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.zx.zx.getDownloadUrl())) ? false : true;
    }

    private boolean gv() {
        return com.ss.android.downloadlib.lg.nt.j(this.zx.zx) && y.j(this.zx.f24238g.getLinkMode());
    }

    private boolean i() {
        return g() && q();
    }

    private boolean q() {
        return this.zx.f24238g.isAddToDownloadManage();
    }

    @Override // com.ss.android.downloadlib.lg.p.j
    public void j(Message message) {
    }

    /* renamed from: com.ss.android.downloadlib.addownload.lg$2 */
    class AnonymousClass2 implements pa.j {

        /* renamed from: j */
        final /* synthetic */ gm f24190j;

        AnonymousClass2(gm gmVar) {
            gmVar = gmVar;
        }

        @Override // com.ss.android.downloadlib.lg.pa.j
        public void j() {
            gm gmVar = gmVar;
            if (gmVar != null) {
                gmVar.j();
            }
        }

        @Override // com.ss.android.downloadlib.lg.pa.j
        public void j(String str) {
            gm gmVar = gmVar;
            if (gmVar != null) {
                gmVar.j(str);
            }
        }
    }

    private boolean gv(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    private boolean q(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.lg.nt.j(this.zx.zx) && gv(downloadInfo);
    }

    void i(DownloadInfo downloadInfo) {
        if (!y.j(this.zx.zx) || this.f24187i) {
            return;
        }
        com.ss.android.downloadlib.g.j.j().j("file_status", (downloadInfo == null || !com.ss.android.downloadlib.lg.nt.zx(downloadInfo.getTargetFilePath())) ? 2 : 1, this.zx);
        this.f24187i = true;
    }

    public void j(long j2) {
        this.f24188j = j2;
        com.ss.android.downloadlib.addownload.zx.q q = com.ss.android.downloadlib.addownload.zx.gv.j().q(j2);
        this.zx = q;
        if (q.mx()) {
            com.ss.android.downloadlib.q.i.j().j("setAdId ModelBox notValid");
        }
    }

    public void zx(@Nullable DownloadInfo downloadInfo) {
        zx zxVar = this.q;
        if (zxVar != null) {
            zxVar.j(downloadInfo);
            this.q = null;
        }
    }

    boolean g(DownloadInfo downloadInfo) {
        return gv() || q(downloadInfo);
    }

    private void zx(gm gmVar) {
        if (!com.ss.android.downloadlib.lg.pa.zx(com.kuaishou.weapon.p0.g.f9325j)) {
            com.ss.android.downloadlib.lg.pa.j(new String[]{com.kuaishou.weapon.p0.g.f9325j}, new pa.j() { // from class: com.ss.android.downloadlib.addownload.lg.2

                /* renamed from: j */
                final /* synthetic */ gm f24190j;

                AnonymousClass2(gm gmVar2) {
                    gmVar = gmVar2;
                }

                @Override // com.ss.android.downloadlib.lg.pa.j
                public void j() {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.j();
                    }
                }

                @Override // com.ss.android.downloadlib.lg.pa.j
                public void j(String str) {
                    gm gmVar2 = gmVar;
                    if (gmVar2 != null) {
                        gmVar2.j(str);
                    }
                }
            });
        } else if (gmVar2 != null) {
            gmVar2.j();
        }
    }

    public void j(DownloadInfo downloadInfo) {
        this.f24187i = false;
        zx(downloadInfo);
    }

    boolean j(Context context, int i2, boolean z) {
        if (com.ss.android.downloadlib.lg.nt.j(this.zx.zx)) {
            com.ss.android.downloadad.api.j.zx g2 = com.ss.android.downloadlib.addownload.zx.gv.j().g(this.zx.f24240j);
            if (g2 != null) {
                DownloadNotificationManager.getInstance().cancelNotification(g2.v());
            }
            return com.ss.android.downloadlib.zx.j.j(this.zx);
        }
        if (j(i2) && !TextUtils.isEmpty(this.zx.zx.getPackageName()) && pa.k().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.zx.j.j(this.zx, i2)) {
                return true;
            }
            return this.f24186g.k() && this.f24186g.g(true);
        }
        if (!z || this.zx.f24238g.getDownloadMode() != 4 || this.f24186g.q()) {
            return false;
        }
        this.f24186g.i(true);
        return true;
    }

    @Nullable
    public String zx() {
        File externalFilesDir = pa.getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        if (externalFilesDir == null) {
            return null;
        }
        if (!externalFilesDir.exists()) {
            externalFilesDir.mkdirs();
        }
        if (externalFilesDir.exists()) {
            return externalFilesDir.getAbsolutePath();
        }
        return null;
    }

    @NonNull
    public static List<com.ss.android.download.api.download.j> zx(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.j) {
                    arrayList.add((com.ss.android.download.api.download.j) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof com.ss.android.download.api.download.j) {
                        arrayList.add((com.ss.android.download.api.download.j) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private boolean j(int i2) {
        if (this.zx.f24238g.getDownloadMode() == 2 && i2 == 2) {
            return true;
        }
        return this.zx.f24238g.getDownloadMode() == 2 && i2 == 1 && pa.k().optInt("disable_lp_if_market", 0) == 1;
    }

    boolean j(boolean z) {
        return !z && this.zx.f24238g.getDownloadMode() == 1;
    }

    void j(@NonNull gm gmVar) {
        if (!TextUtils.isEmpty(this.zx.zx.getFilePath())) {
            String filePath = this.zx.zx.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                gmVar.j();
                return;
            } else {
                try {
                    if (filePath.startsWith(pa.getContext().getExternalCacheDir().getParent())) {
                        gmVar.j();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        zx(new gm() { // from class: com.ss.android.downloadlib.addownload.lg.1

            /* renamed from: j */
            final /* synthetic */ gm f24189j;

            AnonymousClass1(gm gmVar2) {
                gmVar = gmVar2;
            }

            @Override // com.ss.android.download.api.config.gm
            public void j() {
                gmVar.j();
            }

            @Override // com.ss.android.download.api.config.gm
            public void j(String str) {
                pa.i().j(1, pa.getContext(), lg.this.zx.zx, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.g.j.j().zx(lg.this.f24188j, 1);
                gmVar.j(str);
            }
        });
    }

    void j(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        zx zxVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i2 = message.arg1;
        if (i2 != 1 && i2 != 6 && i2 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.lg j2 = com.ss.android.downloadlib.lg.j();
                com.ss.android.downloadlib.addownload.zx.q qVar = this.zx;
                j2.j(qVar.zx, qVar.f24238g, qVar.f24239i);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.g.j.j().j(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        k.j(downloadShortInfo);
        int j3 = com.ss.android.socialbase.appdownloader.i.j(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (zxVar = this.q) != null) {
            zxVar.j(downloadInfo);
            this.q = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : j(map)) {
            if (j3 != 1) {
                if (j3 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, k.j(downloadInfo.getId(), curBytes));
                } else if (j3 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.lg.nt.j(this.zx.zx)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, k.j(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.j> it = zx(map).iterator();
                while (it.hasNext()) {
                    it.next().j(downloadInfo);
                }
            }
        }
    }

    void j() {
        if (this.q == null) {
            this.q = new zx() { // from class: com.ss.android.downloadlib.addownload.lg.3
                AnonymousClass3() {
                }

                @Override // com.ss.android.downloadlib.addownload.lg.zx
                public void j(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.g.j.j().j(lg.this.f24188j, 2, downloadInfo);
                }
            };
        }
    }

    int j(Context context, IDownloadListener iDownloadListener) {
        HttpHeader j2;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.zx.zx.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (pa.k().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.zx.zx.getLogExtra()) && (j2 = j(this.zx.zx.getLogExtra())) != null) {
            arrayList.add(j2);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        String j3 = com.ss.android.downloadlib.lg.g.j(String.valueOf(this.zx.zx.getId()), this.zx.zx.getNotificationJumpUrl(), this.zx.zx.isShowToast(), String.valueOf(this.zx.zx.getModelType()));
        DownloadSetting zx2 = com.ss.android.downloadlib.lg.q.zx(this.zx.zx);
        JSONObject j4 = com.ss.android.downloadlib.lg.q.j(this.zx.zx);
        if (!this.zx.f24238g.enableAH()) {
            j4 = com.ss.android.downloadlib.lg.nt.j(j4);
            com.ss.android.downloadlib.lg.nt.j(j4, DownloadSettingKeys.KEY_AH_PLANS, new JSONArray());
        }
        int executorGroup = this.zx.zx.getExecutorGroup();
        if (this.zx.zx.isAd() || y.zx(this.zx.zx)) {
            executorGroup = 4;
        }
        String j5 = j(zx2);
        DownloadInfo downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(DownloadComponentManager.getDownloadId(this.zx.zx.getDownloadUrl(), j5));
        if (downloadInfo != null && 3 == this.zx.zx.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.gv w = new com.ss.android.socialbase.appdownloader.gv(context, this.zx.zx.getDownloadUrl()).zx(this.zx.zx.getBackupUrls()).j(this.zx.zx.getName()).g(j3).j(arrayList).j(this.zx.zx.isShowNotification()).i(this.zx.zx.isNeedWifi()).zx(this.zx.zx.getFileName()).i(j5).pa(this.zx.zx.getAppIcon()).lg(this.zx.zx.getMd5()).k(this.zx.zx.getSdkMonitorScene()).j(this.zx.zx.getExpectFileLength()).j(iDownloadListener).nt(this.zx.zx.needIndependentProcess() || zx2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).j(this.zx.zx.getDownloadFileUriProvider()).zx(this.zx.zx.autoInstallWithoutNotification()).gv(this.zx.zx.getPackageName()).g(1000).q(100).j(j4).k(true).pa(true).zx(zx2.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, 5)).i(zx2.optInt("backup_url_retry_count", 0)).pa(true).p(zx2.optInt("need_head_connection", 0) == 1).g(zx2.optInt("need_https_to_http_retry", 0) == 1).y(zx2.optInt(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).lg(zx2.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).y(zx2.optString("retry_delay_time_array")).t(zx2.optInt("need_reuse_runnable", 0) == 1).gv(executorGroup).s(this.zx.zx.isAutoInstall()).w(this.zx.zx.distinctDir());
        if (!TextUtils.isEmpty(this.zx.zx.getMimeType())) {
            w.q(this.zx.zx.getMimeType());
        } else {
            w.q(AdBaseConstants.MIME_APK);
        }
        if (zx2.optInt("notification_opt_2", 0) == 1) {
            w.j(false);
            w.zx(true);
        }
        com.ss.android.downloadlib.addownload.i.j jVar = null;
        if (zx2.optInt("clear_space_use_disk_handler", 0) == 1) {
            jVar = new com.ss.android.downloadlib.addownload.i.j();
            w.j(jVar);
        }
        int j6 = y.j(this.zx, i(), w);
        if (jVar != null) {
            jVar.j(j6);
        }
        return j6;
    }

    private String j(DownloadSetting downloadSetting) {
        if (!TextUtils.isEmpty(this.zx.zx.getFilePath())) {
            return this.zx.zx.getFilePath();
        }
        DownloadInfo j2 = com.ss.android.socialbase.appdownloader.g.pa().j(pa.getContext(), this.zx.zx.getDownloadUrl());
        boolean zx2 = com.ss.android.downloadlib.lg.pa.zx(com.kuaishou.weapon.p0.g.f9325j);
        String zx3 = zx();
        if (j2 != null && !TextUtils.isEmpty(j2.getSavePath())) {
            String savePath = j2.getSavePath();
            if (zx2 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(zx3)) {
                    if (savePath.startsWith(zx3)) {
                        return savePath;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(j2.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(zx2 ? 1 : 2));
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.g.j.j().j("label_external_permission", jSONObject, this.zx);
        String str = null;
        try {
            str = com.ss.android.socialbase.appdownloader.i.zx();
        } catch (Exception unused) {
        }
        int j3 = com.ss.android.downloadlib.lg.q.j(downloadSetting);
        if (j3 != 0) {
            if (j3 != 4 && (zx2 || j3 != 2)) {
                if ((j3 == 3 || (!zx2 && j3 == 1)) && !TextUtils.isEmpty(zx3)) {
                    return zx3;
                }
            } else {
                File filesDir = pa.getContext().getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                if (filesDir.exists()) {
                    return filesDir.getAbsolutePath();
                }
            }
        }
        return str;
    }

    void j(DownloadInfo downloadInfo, boolean z) {
        if (this.zx.zx == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (y.j(this.zx.zx)) {
                com.ss.android.downloadlib.g.j.j().j(this.f24188j, 2);
            } else if (z && com.ss.android.downloadlib.g.i.j().i() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.g.j.j().j(this.f24188j, 2);
            }
        } else {
            com.ss.android.downloadlib.g.j.j().j(this.f24188j, 2);
        }
        switch (status) {
            case -4:
            case -1:
                j();
                com.ss.android.downloadlib.addownload.zx.gv j2 = com.ss.android.downloadlib.addownload.zx.gv.j();
                com.ss.android.downloadlib.addownload.zx.q qVar = this.zx;
                j2.j(new com.ss.android.downloadad.api.j.zx(qVar.zx, qVar.f24239i, qVar.f24238g, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.lg.nt.j(this.zx.zx)) {
                    com.ss.android.downloadlib.q.i.j().zx("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.g.j.j().j(this.f24188j, 5, downloadInfo);
                    if (z && com.ss.android.downloadlib.g.i.j().zx() && !com.ss.android.downloadlib.g.i.j().zx(this.f24188j, this.zx.zx.getLogExtra())) {
                        com.ss.android.downloadlib.g.j.j().j(this.f24188j, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.g.j.j().j(this.f24188j, 4, downloadInfo);
                if (z && com.ss.android.downloadlib.g.i.j().zx() && !com.ss.android.downloadlib.g.i.j().zx(this.f24188j, this.zx.zx.getLogExtra())) {
                    com.ss.android.downloadlib.g.j.j().j(this.f24188j, 2);
                    break;
                }
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
                com.ss.android.downloadlib.g.j.j().j(this.f24188j, 3, downloadInfo);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void j(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            if (r7 == 0) goto La8
            if (r8 != 0) goto Ld
            goto La8
        Ld:
            r0 = 0
            long r1 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L2b
            long r1 = r7.getCurBytes()     // Catch: java.lang.Exception -> L27
            r3 = 100
            long r1 = r1 * r3
            long r3 = r7.getTotalBytes()     // Catch: java.lang.Exception -> L27
            long r1 = r1 / r3
            int r2 = (int) r1
            goto L2c
        L27:
            r1 = move-exception
            r1.printStackTrace()
        L2b:
            r2 = 0
        L2c:
            if (r2 >= 0) goto L2f
            goto L30
        L2f:
            r0 = r2
        L30:
            r8.updateFromNewDownloadInfo(r7)
            com.ss.android.downloadlib.addownload.k.j(r8)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto La7
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L92;
                case -3: goto L80;
                case -2: goto L74;
                case -1: goto L70;
                case 0: goto L92;
                case 1: goto L64;
                case 2: goto L64;
                case 3: goto L64;
                case 4: goto L64;
                case 5: goto L64;
                case 6: goto L4d;
                case 7: goto L64;
                case 8: goto L64;
                case 9: goto L4d;
                case 10: goto L4d;
                case 11: goto L4e;
                default: goto L4d;
            }
        L4d:
            goto L3a
        L4e:
            boolean r2 = r1 instanceof com.ss.android.download.api.download.j
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.j r1 = (com.ss.android.download.api.download.j) r1
            r1.j(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.j(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.j(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.k.j(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            com.ss.android.downloadlib.addownload.zx.q r2 = r6.zx
            com.ss.android.download.api.download.DownloadModel r2 = r2.zx
            boolean r2 = com.ss.android.downloadlib.lg.nt.j(r2)
            if (r2 == 0) goto L8e
            r1.onInstalled(r8)
            goto L3a
        L8e:
            r1.onDownloadFinished(r8)
            goto L3a
        L92:
            com.ss.android.downloadlib.addownload.zx.q r2 = r6.zx
            com.ss.android.download.api.download.DownloadModel r2 = r2.zx
            boolean r2 = com.ss.android.downloadlib.lg.nt.j(r2)
            if (r2 == 0) goto La3
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3a
        La3:
            r1.onIdle()
            goto L3a
        La7:
            return
        La8:
            java.util.Iterator r7 = r9.iterator()
        Lac:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lbc
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto Lac
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.lg.j(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> j(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else if (obj instanceof SoftReference) {
                    SoftReference softReference = (SoftReference) obj;
                    if (softReference.get() instanceof DownloadStatusChangeListener) {
                        arrayList.add((DownloadStatusChangeListener) softReference.get());
                    }
                }
            }
        }
        return arrayList;
    }

    private HttpHeader j(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new HttpHeader("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e2) {
            pa.v().j(e2, "parseLogExtra Error");
            return null;
        }
    }
}
