package com.ss.android.downloadlib.i;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.pa;
import com.ss.android.downloadlib.addownload.zx.k;
import com.ss.android.downloadlib.lg.nt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g implements com.ss.android.socialbase.appdownloader.i.lg, IDownloadCacheSyncStatusListener {

    /* renamed from: com.ss.android.downloadlib.i.g$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DownloadInfo downloadInfo;
            int spIntVal;
            com.ss.android.downloadlib.addownload.zx.gv.j().zx();
            for (com.ss.android.downloadad.api.j.zx zxVar : com.ss.android.downloadlib.addownload.zx.gv.j().i().values()) {
                int v = zxVar.v();
                if (v != 0) {
                    DownloadSetting obtain = DownloadSetting.obtain(v);
                    if (obtain.optInt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v)) != null) {
                        if (nt.zx(zxVar) && !nt.i(zxVar.q())) {
                            int spIntVal2 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                            if (spIntVal2 < obtain.optInt("noti_open_restart_times", 1)) {
                                y.j().q(zxVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, String.valueOf(spIntVal2 + 1));
                            }
                        } else if (downloadInfo.getRealStatus() == -2) {
                            int spIntVal3 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                            if (spIntVal3 < obtain.optInt("noti_continue_restart_times", 1)) {
                                y.j().j(zxVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, String.valueOf(spIntVal3 + 1));
                            }
                        } else if (downloadInfo.getRealStatus() == -3 && DownloadUtils.isFileDownloaded(downloadInfo) && !nt.zx(zxVar) && (spIntVal = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < obtain.optInt("noti_install_restart_times", 1)) {
                            y.j().i(zxVar);
                            downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, String.valueOf(spIntVal + 1));
                        }
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.i.lg
    public void j(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        j(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.ss.android.socialbase.appdownloader.i.lg
    public void j(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onStart() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onSuccess() {
        com.ss.android.downloadlib.g.j().j(new Runnable() { // from class: com.ss.android.downloadlib.i.g.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.zx.gv.j().zx();
                for (com.ss.android.downloadad.api.j.zx zxVar : com.ss.android.downloadlib.addownload.zx.gv.j().i().values()) {
                    int v = zxVar.v();
                    if (v != 0) {
                        DownloadSetting obtain = DownloadSetting.obtain(v);
                        if (obtain.optInt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(pa.getContext()).getDownloadInfo(v)) != null) {
                            if (nt.zx(zxVar) && !nt.i(zxVar.q())) {
                                int spIntVal2 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                                if (spIntVal2 < obtain.optInt("noti_open_restart_times", 1)) {
                                    y.j().q(zxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                                if (spIntVal3 < obtain.optInt("noti_continue_restart_times", 1)) {
                                    y.j().j(zxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && DownloadUtils.isFileDownloaded(downloadInfo) && !nt.zx(zxVar) && (spIntVal = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < obtain.optInt("noti_install_restart_times", 1)) {
                                y.j().i(zxVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @WorkerThread
    public void j(DownloadInfo downloadInfo, int i2, boolean z) {
        com.ss.android.downloadlib.addownload.zx.gv.j().zx();
        com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
        if (j2 == null) {
            return;
        }
        try {
            if (z) {
                j2.i(downloadInfo.getFailedResumeCount());
            } else if (j2.lt() == -1) {
                return;
            } else {
                j2.i(-1);
            }
            k.j().j(j2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getDownloadTime());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, i2);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i3 = 1;
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, downloadInfo.getChunkCount());
            if (!z) {
                i3 = 2;
            }
            jSONObject.put("launch_resumed", i3);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.g.j.j().j("embeded_ad", "download_uncompleted", jSONObject, j2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
