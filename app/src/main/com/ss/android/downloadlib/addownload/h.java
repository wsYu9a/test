package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.t;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.g.j;
import com.ss.android.downloadlib.g.n;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h implements n.a {

    /* renamed from: a */
    public com.ss.android.downloadlib.addownload.b.e f21456a;

    /* renamed from: b */
    private long f21457b;

    /* renamed from: c */
    private boolean f21458c = false;

    /* renamed from: d */
    private e f21459d;

    /* renamed from: e */
    private b f21460e;

    /* renamed from: com.ss.android.downloadlib.addownload.h$1 */
    public class AnonymousClass1 implements t {

        /* renamed from: a */
        final /* synthetic */ t f21461a;

        public AnonymousClass1(t tVar) {
            tVar = tVar;
        }

        @Override // com.ss.android.download.api.config.t
        public void a() {
            tVar.a();
        }

        @Override // com.ss.android.download.api.config.t
        public void a(String str) {
            k.d().a(1, k.a(), h.this.f21456a.f21217b, "您已禁止使用存储权限，请授权后再下载", null, 1);
            com.ss.android.downloadlib.d.a.a().b(h.this.f21457b, 1);
            tVar.a(str);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.h$3 */
    public class AnonymousClass3 implements b {
        public AnonymousClass3() {
        }

        @Override // com.ss.android.downloadlib.addownload.h.b
        public void a(DownloadInfo downloadInfo) {
            com.ss.android.downloadlib.d.a.a().a(h.this.f21457b, 2, downloadInfo);
        }
    }

    public static class a extends AbsDownloadExtListener {

        /* renamed from: a */
        private com.ss.android.downloadlib.g.n f21466a;

        public a(com.ss.android.downloadlib.g.n nVar) {
            this.f21466a = nVar;
        }

        private void a(DownloadInfo downloadInfo, int i10) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            obtain.obj = downloadInfo;
            obtain.arg1 = i10;
            this.f21466a.sendMessage(obtain);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onCanceled(DownloadInfo downloadInfo) {
            a(downloadInfo, -4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
            a(downloadInfo, -1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPause(DownloadInfo downloadInfo) {
            a(downloadInfo, -2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onPrepare(DownloadInfo downloadInfo) {
            a(downloadInfo, 1);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onProgress(DownloadInfo downloadInfo) {
            a(downloadInfo, 4);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onStart(DownloadInfo downloadInfo) {
            a(downloadInfo, 2);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(DownloadInfo downloadInfo) {
            a(downloadInfo, -3);
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadExtListener, com.ss.android.socialbase.downloader.depend.IDownloadExtListener
        public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
            a(downloadInfo, 11);
        }
    }

    public interface b {
        void a(DownloadInfo downloadInfo);
    }

    public h(e eVar) {
        this.f21459d = eVar;
    }

    private boolean c() {
        return d() && e();
    }

    private boolean d() {
        DownloadModel downloadModel = this.f21456a.f21217b;
        return (downloadModel == null || TextUtils.isEmpty(downloadModel.getPackageName()) || TextUtils.isEmpty(this.f21456a.f21217b.getDownloadUrl())) ? false : true;
    }

    private boolean e() {
        return this.f21456a.f21219d.isAddToDownloadManage();
    }

    private boolean f() {
        return com.ss.android.downloadlib.g.m.a(this.f21456a.f21217b) && i.a(this.f21456a.f21219d.getLinkMode());
    }

    @Override // com.ss.android.downloadlib.g.n.a
    public void a(Message message) {
    }

    public void b(@Nullable DownloadInfo downloadInfo) {
        b bVar = this.f21460e;
        if (bVar != null) {
            bVar.a(downloadInfo);
            this.f21460e = null;
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.h$2 */
    public class AnonymousClass2 implements j.a {

        /* renamed from: a */
        final /* synthetic */ t f21463a;

        public AnonymousClass2(t tVar) {
            tVar = tVar;
        }

        @Override // com.ss.android.downloadlib.g.j.a
        public void a() {
            t tVar = tVar;
            if (tVar != null) {
                tVar.a();
            }
        }

        @Override // com.ss.android.downloadlib.g.j.a
        public void a(String str) {
            t tVar = tVar;
            if (tVar != null) {
                tVar.a(str);
            }
        }
    }

    private boolean e(DownloadInfo downloadInfo) {
        return !com.ss.android.downloadlib.g.m.a(this.f21456a.f21217b) && f(downloadInfo);
    }

    private boolean f(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -3 && DownloadUtils.isFileExist(downloadInfo.getSavePath(), downloadInfo.getName());
    }

    public void c(DownloadInfo downloadInfo) {
        if (!i.a(this.f21456a.f21217b) || this.f21458c) {
            return;
        }
        com.ss.android.downloadlib.d.a.a().a("file_status", (downloadInfo == null || !com.ss.android.downloadlib.g.m.b(downloadInfo.getTargetFilePath())) ? 2 : 1, this.f21456a);
        this.f21458c = true;
    }

    public void a(long j10) {
        this.f21457b = j10;
        com.ss.android.downloadlib.addownload.b.e e10 = com.ss.android.downloadlib.addownload.b.f.a().e(j10);
        this.f21456a = e10;
        if (e10.x()) {
            com.ss.android.downloadlib.e.c.a().a("setAdId ModelBox notValid");
        }
    }

    private void b(t tVar) {
        String str;
        if (com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE")) {
            if (tVar != null) {
                tVar.a();
                return;
            }
            return;
        }
        if (com.ss.android.downloadlib.g.m.a()) {
            str = "android.permission.READ_MEDIA_IMAGES";
            if (com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_VIDEO")) {
                if (tVar != null) {
                    tVar.a();
                    return;
                }
                return;
            }
        } else {
            str = com.kuaishou.weapon.p0.g.f11108i;
        }
        com.ss.android.downloadlib.g.j.a(new String[]{str}, new j.a() { // from class: com.ss.android.downloadlib.addownload.h.2

            /* renamed from: a */
            final /* synthetic */ t f21463a;

            public AnonymousClass2(t tVar2) {
                tVar = tVar2;
            }

            @Override // com.ss.android.downloadlib.g.j.a
            public void a() {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.a();
                }
            }

            @Override // com.ss.android.downloadlib.g.j.a
            public void a(String str2) {
                t tVar2 = tVar;
                if (tVar2 != null) {
                    tVar2.a(str2);
                }
            }
        });
    }

    public boolean d(DownloadInfo downloadInfo) {
        return f() || e(downloadInfo);
    }

    public void a(DownloadInfo downloadInfo) {
        this.f21458c = false;
        b(downloadInfo);
    }

    public boolean a(Context context, int i10, boolean z10) {
        if (com.ss.android.downloadlib.g.m.a(this.f21456a.f21217b)) {
            com.ss.android.downloadad.api.a.b d10 = com.ss.android.downloadlib.addownload.b.f.a().d(this.f21456a.f21216a);
            if (d10 != null) {
                DownloadNotificationManager.getInstance().cancelNotification(d10.s());
            }
            return com.ss.android.downloadlib.b.a.a(this.f21456a);
        }
        if (a(i10) && !TextUtils.isEmpty(this.f21456a.f21217b.getPackageName()) && k.j().optInt("disable_market") != 1) {
            if (com.ss.android.downloadlib.b.a.a(this.f21456a, i10)) {
                return true;
            }
            return this.f21459d.i() && this.f21459d.d(true);
        }
        if (!z10 || this.f21456a.f21219d.getDownloadMode() != 4 || this.f21459d.e()) {
            return false;
        }
        this.f21459d.c(true);
        return true;
    }

    @Nullable
    public String b() {
        File externalFilesDir = k.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
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
    public static List<com.ss.android.download.api.download.a> b(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof com.ss.android.download.api.download.a) {
                    arrayList.add((com.ss.android.download.api.download.a) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.a) {
                            arrayList.add((com.ss.android.download.api.download.a) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof com.ss.android.download.api.download.a) {
                            arrayList.add((com.ss.android.download.api.download.a) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean a(int i10) {
        if (this.f21456a.f21219d.getDownloadMode() == 2 && i10 == 2) {
            return true;
        }
        return this.f21456a.f21219d.getDownloadMode() == 2 && i10 == 1 && k.j().optInt("disable_lp_if_market", 0) == 1;
    }

    public boolean a(int i10, DownloadModel downloadModel) {
        return com.ss.android.socialbase.appdownloader.f.e.c() && a(i10) && !com.ss.android.downloadlib.g.m.a(downloadModel);
    }

    public boolean a(boolean z10) {
        return !z10 && this.f21456a.f21219d.getDownloadMode() == 1;
    }

    public void a(@NonNull t tVar) {
        if (!TextUtils.isEmpty(this.f21456a.f21217b.getFilePath())) {
            String filePath = this.f21456a.f21217b.getFilePath();
            if (filePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                tVar.a();
                return;
            } else {
                try {
                    if (filePath.startsWith(k.a().getExternalCacheDir().getParent())) {
                        tVar.a();
                        return;
                    }
                } catch (Exception unused) {
                }
            }
        }
        b(new t() { // from class: com.ss.android.downloadlib.addownload.h.1

            /* renamed from: a */
            final /* synthetic */ t f21461a;

            public AnonymousClass1(t tVar2) {
                tVar = tVar2;
            }

            @Override // com.ss.android.download.api.config.t
            public void a() {
                tVar.a();
            }

            @Override // com.ss.android.download.api.config.t
            public void a(String str) {
                k.d().a(1, k.a(), h.this.f21456a.f21217b, "您已禁止使用存储权限，请授权后再下载", null, 1);
                com.ss.android.downloadlib.d.a.a().b(h.this.f21457b, 1);
                tVar.a(str);
            }
        });
    }

    public void a(Message message, DownloadShortInfo downloadShortInfo, Map<Integer, Object> map) {
        b bVar;
        if (message == null || message.what != 3) {
            return;
        }
        DownloadInfo downloadInfo = (DownloadInfo) message.obj;
        int i10 = message.arg1;
        if (i10 != 1 && i10 != 6 && i10 == 2) {
            if (downloadInfo.getIsFirstDownload()) {
                com.ss.android.downloadlib.g a10 = com.ss.android.downloadlib.g.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f21456a;
                a10.a(eVar.f21217b, eVar.f21219d, eVar.f21218c);
                downloadInfo.setFirstDownload(false);
            }
            com.ss.android.downloadlib.d.a.a().a(downloadInfo);
        }
        downloadShortInfo.updateFromNewDownloadInfo(downloadInfo);
        j.a(downloadShortInfo);
        int a11 = com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getStatus());
        long totalBytes = downloadInfo.getTotalBytes();
        int curBytes = totalBytes > 0 ? (int) ((downloadInfo.getCurBytes() * 100) / totalBytes) : 0;
        if ((totalBytes > 0 || DownloadSetting.obtainGlobal().optBugFix("fix_click_start")) && (bVar = this.f21460e) != null) {
            bVar.a(downloadInfo);
            this.f21460e = null;
        }
        for (DownloadStatusChangeListener downloadStatusChangeListener : a(map)) {
            if (a11 != 1) {
                if (a11 == 2) {
                    downloadStatusChangeListener.onDownloadPaused(downloadShortInfo, j.a(downloadInfo.getId(), curBytes));
                } else if (a11 == 3) {
                    if (downloadInfo.getStatus() == -4) {
                        downloadStatusChangeListener.onIdle();
                    } else if (downloadInfo.getStatus() == -1) {
                        downloadStatusChangeListener.onDownloadFailed(downloadShortInfo);
                    } else if (downloadInfo.getStatus() == -3) {
                        if (com.ss.android.downloadlib.g.m.a(this.f21456a.f21217b)) {
                            downloadStatusChangeListener.onInstalled(downloadShortInfo);
                        } else {
                            downloadStatusChangeListener.onDownloadFinished(downloadShortInfo);
                        }
                    }
                }
            } else if (downloadInfo.getStatus() != 11) {
                downloadStatusChangeListener.onDownloadActive(downloadShortInfo, j.a(downloadInfo.getId(), curBytes));
            } else {
                Iterator<com.ss.android.download.api.download.a> it = b(map).iterator();
                while (it.hasNext()) {
                    it.next().a(downloadInfo);
                }
            }
        }
    }

    public void a() {
        if (this.f21460e == null) {
            this.f21460e = new b() { // from class: com.ss.android.downloadlib.addownload.h.3
                public AnonymousClass3() {
                }

                @Override // com.ss.android.downloadlib.addownload.h.b
                public void a(DownloadInfo downloadInfo) {
                    com.ss.android.downloadlib.d.a.a().a(h.this.f21457b, 2, downloadInfo);
                }
            };
        }
    }

    public int a(Context context, IDownloadListener iDownloadListener) {
        com.ss.android.downloadlib.addownload.c.a aVar;
        HttpHeader a10;
        if (context == null) {
            return 0;
        }
        Map<String, String> headers = this.f21456a.f21217b.getHeaders();
        ArrayList arrayList = new ArrayList();
        if (k.j().optInt("enable_send_click_id_in_apk", 1) == 1 && !TextUtils.isEmpty(this.f21456a.f21217b.getLogExtra()) && (a10 = a(this.f21456a.f21217b.getLogExtra())) != null) {
            arrayList.add(a10);
        }
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                if (entry != null) {
                    arrayList.add(new HttpHeader(entry.getKey(), entry.getValue()));
                }
            }
        }
        String a11 = com.ss.android.downloadlib.g.d.a(String.valueOf(this.f21456a.f21217b.getId()), this.f21456a.f21217b.getNotificationJumpUrl(), this.f21456a.f21217b.isShowToast(), String.valueOf(this.f21456a.f21217b.getModelType()));
        DownloadSetting b10 = com.ss.android.downloadlib.g.e.b(this.f21456a.f21217b);
        JSONObject a12 = com.ss.android.downloadlib.g.e.a(this.f21456a.f21217b);
        if (!this.f21456a.f21219d.enableAH()) {
            a12 = com.ss.android.downloadlib.g.m.a(a12);
            com.ss.android.downloadlib.g.m.a(a12, DownloadSettingKeys.KEY_AH_PLANS, new JSONArray());
        }
        int executorGroup = this.f21456a.f21217b.getExecutorGroup();
        if (this.f21456a.f21217b.isAd() || i.b(this.f21456a.f21217b)) {
            executorGroup = 4;
        }
        String a13 = a(b10);
        DownloadInfo downloadInfo = Downloader.getInstance(k.a()).getDownloadInfo(DownloadComponentManager.getDownloadId(this.f21456a.f21217b.getDownloadUrl(), a13));
        if (downloadInfo != null && 3 == this.f21456a.f21217b.getModelType()) {
            downloadInfo.setFirstDownload(true);
        }
        com.ss.android.socialbase.appdownloader.f o10 = new com.ss.android.socialbase.appdownloader.f(context, this.f21456a.f21217b.getDownloadUrl()).b(this.f21456a.f21217b.getBackupUrls()).a(this.f21456a.f21217b.getName()).e(a11).a(arrayList).a(this.f21456a.f21217b.isShowNotification()).c(this.f21456a.f21217b.isNeedWifi()).b(this.f21456a.f21217b.getFileName()).c(a13).k(this.f21456a.f21217b.getAppIcon()).h(this.f21456a.f21217b.getMd5()).j(this.f21456a.f21217b.getSdkMonitorScene()).a(this.f21456a.f21217b.getExpectFileLength()).a(iDownloadListener).l(this.f21456a.f21217b.needIndependentProcess() || b10.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, 0) == 1).a(this.f21456a.f21217b.getDownloadFileUriProvider()).b(this.f21456a.f21217b.autoInstallWithoutNotification()).g(this.f21456a.f21217b.getPackageName()).d(1000).e(100).a(a12).i(true).j(true).b(b10.optInt(MonitorConstants.EXTRA_DOWNLOAD_RETRY_COUNT, 5)).c(b10.optInt("backup_url_retry_count", 0)).j(true).m(b10.optInt("need_head_connection", 0) == 1).d(b10.optInt("need_https_to_http_retry", 0) == 1).h(b10.optInt(MonitorConstants.EXTRA_NEED_CHUNK_DOWNGRADE_RETRY, 1) == 1).g(b10.optInt(MonitorConstants.EXTRA_DOWNLOAD_NEED_RETRY_DELAY, 0) == 1).i(b10.optString("retry_delay_time_array")).k(b10.optInt("need_reuse_runnable", 0) == 1).f(executorGroup).p(this.f21456a.f21217b.isAutoInstall()).o(this.f21456a.f21217b.distinctDir());
        if (!TextUtils.isEmpty(this.f21456a.f21217b.getMimeType())) {
            o10.f(this.f21456a.f21217b.getMimeType());
        } else {
            o10.f("application/vnd.android.package-archive");
        }
        if (b10.optInt("notification_opt_2", 0) == 1) {
            o10.a(false);
            o10.b(true);
        }
        if (b10.optInt("clear_space_use_disk_handler", 0) == 1) {
            aVar = new com.ss.android.downloadlib.addownload.c.a();
            o10.a(aVar);
        } else {
            aVar = null;
        }
        DownloadModel downloadModel = this.f21456a.f21217b;
        if ((downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(((AdDownloadModel) downloadModel).getTaskKey())) {
            o10.d(((AdDownloadModel) this.f21456a.f21217b).getTaskKey());
        }
        int a14 = i.a(this.f21456a, c(), o10);
        if (aVar != null) {
            aVar.a(a14);
        }
        return a14;
    }

    private String a(DownloadSetting downloadSetting) {
        boolean z10;
        String str;
        if (!TextUtils.isEmpty(this.f21456a.f21217b.getFilePath())) {
            return this.f21456a.f21217b.getFilePath();
        }
        DownloadInfo a10 = com.ss.android.socialbase.appdownloader.d.j().a(k.a(), this.f21456a.f21217b.getDownloadUrl());
        if (!com.ss.android.downloadlib.g.m.a()) {
            z10 = com.ss.android.downloadlib.g.j.b("android.permission.WRITE_EXTERNAL_STORAGE");
        } else {
            z10 = com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_IMAGES") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_AUDIO") || com.ss.android.downloadlib.g.j.b("android.permission.READ_MEDIA_VIDEO");
        }
        String b10 = b();
        if (a10 != null && !TextUtils.isEmpty(a10.getSavePath())) {
            String savePath = a10.getSavePath();
            if (z10 || savePath.startsWith(Environment.getDataDirectory().getAbsolutePath())) {
                return savePath;
            }
            try {
                if (!TextUtils.isEmpty(b10)) {
                    if (savePath.startsWith(b10)) {
                        return savePath;
                    }
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            Downloader.getInstance(DownloadComponentManager.getAppContext()).cancel(a10.getId());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ttdownloader_code", Integer.valueOf(z10 ? 1 : 2));
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("label_external_permission", jSONObject, this.f21456a);
        try {
            str = com.ss.android.socialbase.appdownloader.c.b();
        } catch (Exception unused) {
            str = null;
        }
        int a11 = com.ss.android.downloadlib.g.e.a(downloadSetting);
        if (a11 != 0) {
            if (a11 != 4 && (z10 || a11 != 2)) {
                if ((a11 == 3 || (!z10 && a11 == 1)) && !TextUtils.isEmpty(b10)) {
                    return b10;
                }
            } else {
                File filesDir = k.a().getFilesDir();
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

    public void a(DownloadInfo downloadInfo, boolean z10) {
        if (this.f21456a.f21217b == null || downloadInfo == null || downloadInfo.getId() == 0) {
            return;
        }
        int status = downloadInfo.getStatus();
        if (status != -1 && status != -4) {
            if (i.a(this.f21456a.f21217b)) {
                com.ss.android.downloadlib.d.a.a().a(this.f21457b, 2);
            } else if (z10 && com.ss.android.downloadlib.d.c.a().c() && (status == -2 || status == -3)) {
                com.ss.android.downloadlib.d.a.a().a(this.f21457b, 2);
            }
        } else {
            com.ss.android.downloadlib.d.a.a().a(this.f21457b, 2);
        }
        switch (status) {
            case -4:
            case -1:
                a();
                com.ss.android.downloadlib.addownload.b.f a10 = com.ss.android.downloadlib.addownload.b.f.a();
                com.ss.android.downloadlib.addownload.b.e eVar = this.f21456a;
                a10.a(new com.ss.android.downloadad.api.a.b(eVar.f21217b, eVar.f21218c, eVar.f21219d, downloadInfo.getId()));
                break;
            case -3:
                if (com.ss.android.downloadlib.g.m.a(this.f21456a.f21217b)) {
                    com.ss.android.downloadlib.e.c.a().b("SUCCESSED isInstalledApp");
                    break;
                } else {
                    com.ss.android.downloadlib.d.a.a().a(this.f21457b, 5, downloadInfo);
                    if (z10 && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.f21457b, this.f21456a.f21217b.getLogExtra())) {
                        com.ss.android.downloadlib.d.a.a().a(this.f21457b, 2);
                        break;
                    }
                }
                break;
            case -2:
                com.ss.android.downloadlib.d.a.a().a(this.f21457b, 4, downloadInfo);
                if (z10 && com.ss.android.downloadlib.d.c.a().b() && !com.ss.android.downloadlib.d.c.a().b(this.f21457b, this.f21456a.f21217b.getLogExtra())) {
                    com.ss.android.downloadlib.d.a.a().a(this.f21457b, 2);
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
                com.ss.android.downloadlib.d.a.a().a(this.f21457b, 3, downloadInfo);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.ss.android.socialbase.downloader.model.DownloadInfo r7, com.ss.android.download.api.model.DownloadShortInfo r8, java.util.List<com.ss.android.download.api.download.DownloadStatusChangeListener> r9, boolean r10) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            if (r7 == 0) goto La0
            if (r8 != 0) goto Ld
            goto La0
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
            com.ss.android.downloadlib.addownload.j.a(r8)
            java.util.Iterator r9 = r9.iterator()
        L3a:
            boolean r1 = r9.hasNext()
            if (r1 == 0) goto L9f
            java.lang.Object r1 = r9.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r1 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r1
            int r2 = r7.getStatus()
            switch(r2) {
                case -4: goto L8a;
                case -3: goto L80;
                case -2: goto L74;
                case -1: goto L70;
                case 0: goto L8a;
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
            boolean r2 = r1 instanceof com.ss.android.download.api.download.a
            if (r2 == 0) goto L58
            com.ss.android.download.api.download.a r1 = (com.ss.android.download.api.download.a) r1
            r1.a(r7)
            goto L3a
        L58:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L64:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadActive(r8, r2)
            goto L3a
        L70:
            r1.onDownloadFailed(r8)
            goto L3a
        L74:
            int r2 = r7.getId()
            int r2 = com.ss.android.downloadlib.addownload.j.a(r2, r0)
            r1.onDownloadPaused(r8, r2)
            goto L3a
        L80:
            if (r10 == 0) goto L86
            r1.onInstalled(r8)
            goto L3a
        L86:
            r1.onDownloadFinished(r8)
            goto L3a
        L8a:
            com.ss.android.downloadlib.addownload.b.e r2 = r6.f21456a
            com.ss.android.download.api.download.DownloadModel r2 = r2.f21217b
            boolean r2 = com.ss.android.downloadlib.g.m.a(r2)
            if (r2 == 0) goto L9b
            r2 = -3
            r8.status = r2
            r1.onInstalled(r8)
            goto L3a
        L9b:
            r1.onIdle()
            goto L3a
        L9f:
            return
        La0:
            java.util.Iterator r7 = r9.iterator()
        La4:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto Lb4
            java.lang.Object r8 = r7.next()
            com.ss.android.download.api.download.DownloadStatusChangeListener r8 = (com.ss.android.download.api.download.DownloadStatusChangeListener) r8
            r8.onIdle()
            goto La4
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.addownload.h.a(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.download.api.model.DownloadShortInfo, java.util.List, boolean):void");
    }

    @NonNull
    public static List<DownloadStatusChangeListener> a(Map<Integer, Object> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Object obj : map.values()) {
                if (obj instanceof DownloadStatusChangeListener) {
                    arrayList.add((DownloadStatusChangeListener) obj);
                } else {
                    if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) softReference.get());
                        }
                    }
                    if (obj instanceof WeakReference) {
                        WeakReference weakReference = (WeakReference) obj;
                        if (weakReference.get() instanceof DownloadStatusChangeListener) {
                            arrayList.add((DownloadStatusChangeListener) weakReference.get());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private HttpHeader a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new HttpHeader("clickid", new JSONObject(str).optString("clickid"));
        } catch (JSONException e10) {
            k.u().a(e10, "parseLogExtra Error");
            return null;
        }
    }
}
