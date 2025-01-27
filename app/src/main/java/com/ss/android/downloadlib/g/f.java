package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.g;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {
    public static void a(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            c(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo);
            if (a10 == null) {
                return;
            }
            jSONObject.put("is_update_download", a10.V() ? 1 : 2);
            a(a10, jSONObject);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.a.b a10;
        if (jSONObject == null || (a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo)) == null) {
            return;
        }
        try {
            c(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - a10.T()));
            jSONObject.putOpt("click_download_size", Long.valueOf(a10.U()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            a10.A();
            com.ss.android.downloadlib.addownload.b.i.a().a(a10);
            jSONObject.put("click_pause_times", a10.z());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? l5.c.f27899e : curBytes / totalBytes);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadInfo.getRealStatus());
            long currentTimeMillis = System.currentTimeMillis();
            long H = a10.H();
            if (H > 0) {
                jSONObject.put("time_from_start_download", currentTimeMillis - H);
            }
            long B = a10.B();
            if (B > 0) {
                jSONObject.put("time_from_download_resume", currentTimeMillis - B);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(a10.E()));
            jSONObject.putOpt("fail_msg", a10.F());
            jSONObject.put("download_failed_times", a10.x());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void c(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_TOTAL_BYTES, Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_CHUNK_COUNT, Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_QUALITY, downloadInfo.getNetworkQuality());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt(MonitorConstants.EXTRA_DOWNLOAD_STATUS, Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.a.b a10 = com.ss.android.downloadlib.addownload.b.f.a().a(downloadInfo.getId());
                if (a10 != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(a10.T()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(a10.U()));
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.e.d.a() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(DownloadUtils.isNetworkConnected(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(DownloadUtils.isWifi(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
    }

    public static void a(com.ss.android.downloadad.api.a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null || bVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", bVar.X() ? 1 : 0);
            jSONObject.put("origin_mime_type", bVar.W());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, int i10) {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = DownloadSetting.obtain(i10).optJSONArray("ah_report_config");
        if (optJSONArray != null) {
            for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                try {
                    String string = optJSONArray.getString(i11);
                    g.a a10 = com.ss.android.socialbase.appdownloader.f.a.a(string);
                    if (a10 != null) {
                        jSONObject.put(string.replaceAll("\\.", hf.e.f26694a), a10.f() + hf.e.f26694a + a10.g());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.b.a(DownloadComponentManager.getAppContext()) ? 1 : 2);
        } catch (Throwable unused) {
        }
    }

    public static JSONObject a(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, m.a(aVar.f(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void a(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.f.d.a());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.f.d.c());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.f.d.d());
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.a(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.e() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.f.d.b());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.b(com.ss.android.downloadlib.addownload.k.a()) ? 1 : 2));
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.f.d.f() ? 1 : 2));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static JSONObject b(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.a.a aVar) {
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j().replaceAll("\\.", hf.e.f26694a) + " versionCode", Integer.valueOf(m.b(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j())));
        m.a(jSONObject, com.ss.android.socialbase.appdownloader.f.e.j().replaceAll("\\.", hf.e.f26694a) + " versionName", m.c(com.ss.android.downloadlib.addownload.k.a(), com.ss.android.socialbase.appdownloader.f.e.j()));
        return jSONObject;
    }
}
