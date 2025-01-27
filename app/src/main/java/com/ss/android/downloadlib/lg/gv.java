package com.ss.android.downloadlib.lg;

import androidx.annotation.NonNull;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.socialbase.appdownloader.lg;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class gv {
    public static void i(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, downloadInfo.getTitle());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo.getId());
                if (j2 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(j2.az()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(j2.vy()));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        int i2 = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.q.g.j() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.pa.getContext()) ? 1 : 2));
        if (!DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.pa.getContext())) {
            i2 = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i2));
    }

    public static void j(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            i(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.j.zx j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo);
            if (j2 == null) {
                return;
            }
            jSONObject.put("is_update_download", j2.ty() ? 1 : 2);
            j(j2, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void zx(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.j.zx j2;
        double d2;
        if (jSONObject == null || (j2 = com.ss.android.downloadlib.addownload.zx.gv.j().j(downloadInfo)) == null) {
            return;
        }
        try {
            i(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - j2.az()));
            jSONObject.putOpt("click_download_size", Long.valueOf(j2.vy()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            j2.bw();
            com.ss.android.downloadlib.addownload.zx.k.j().j(j2);
            jSONObject.put("click_pause_times", j2.u());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            if (curBytes < 0 || totalBytes <= 0) {
                d2 = 0.0d;
            } else {
                double d3 = curBytes;
                double d4 = totalBytes;
                Double.isNaN(d3);
                Double.isNaN(d4);
                d2 = d3 / d4;
            }
            jSONObject.put("download_percent", d2);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long me2 = j2.me();
            if (me2 > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - me2);
            }
            long gg = j2.gg();
            if (gg > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - gg);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(j2.l()));
            jSONObject.putOpt("fail_msg", j2.vs());
            jSONObject.put("download_failed_times", j2.mx());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.q.g.j() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void j(com.ss.android.downloadad.api.j.zx zxVar, JSONObject jSONObject) {
        if (jSONObject == null || zxVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", zxVar.rx() ? 1 : 0);
            jSONObject.put("origin_mime_type", zxVar.a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void j(JSONObject jSONObject, int i2) {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(i2).optJSONArray("ah_report_config");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    String string = optJSONArray.getString(i3);
                    lg.j j2 = com.ss.android.socialbase.appdownloader.gv.j.j(string);
                    if (j2 != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), j2.gv() + "_" + j2.lg());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.zx.j(DownloadComponentManager.getAppContext()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject j(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, "open_url", nt.j(jVar.gv(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void j(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.gv.g.j());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.gv.g.i());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.gv.g.g());
            int i2 = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.gv.g.j(com.ss.android.downloadlib.addownload.pa.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.gv.g.q() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.gv.g.zx());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.gv.g.zx(com.ss.android.downloadlib.addownload.pa.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.gv.g.gv()) {
                i2 = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static JSONObject zx(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.j.j jVar) {
        nt.j(jSONObject, com.ss.android.socialbase.appdownloader.gv.q.k().replaceAll("\\.", "_"), Integer.valueOf(nt.zx(com.ss.android.downloadlib.addownload.pa.getContext(), com.ss.android.socialbase.appdownloader.gv.q.k())));
        return jSONObject;
    }
}
