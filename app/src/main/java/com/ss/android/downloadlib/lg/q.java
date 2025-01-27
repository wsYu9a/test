package com.ss.android.downloadlib.lg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.mobilesecuritysdk.constant.a;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class q {
    public static boolean g(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean gv(int i2) {
        return DownloadSetting.obtain(i2).optInt("clean_space_switch", 0) == 1;
    }

    public static int i(@NonNull DownloadModel downloadModel) {
        return j(zx(downloadModel));
    }

    @Nullable
    public static JSONObject j() {
        return com.ss.android.downloadlib.addownload.pa.k().optJSONObject("ad");
    }

    public static boolean lg(int i2) {
        return DownloadSetting.obtain(i2).optInt("clean_app_cache_dir", 0) == 1;
    }

    public static boolean q(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_space_before_download_switch", 0L) == 1;
    }

    @NonNull
    public static DownloadSetting zx(DownloadModel downloadModel) {
        return DownloadSetting.obtain(j(downloadModel));
    }

    public static long g() {
        long optLong = com.ss.android.downloadlib.addownload.pa.k().optLong("start_install_interval");
        return optLong == 0 ? a.k : optLong;
    }

    public static JSONObject j(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? j() : downloadModel.getDownloadSettings();
    }

    public static long q() {
        long optLong = com.ss.android.downloadlib.addownload.pa.k().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static boolean zx(com.ss.android.downloadad.api.j.j jVar) {
        return j(jVar).optInt("pause_reserve_on_wifi", 0) == 1 && jVar.ei();
    }

    public static long i(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean i() {
        return com.ss.android.downloadlib.addownload.pa.k().optInt("is_enable_start_install_again") == 1;
    }

    public static long zx(int i2) {
        return DownloadSetting.obtain(i2).optLong("storage_min_size", 0L);
    }

    @NonNull
    public static DownloadSetting j(com.ss.android.downloadad.api.j.j jVar) {
        if (jVar == null) {
            return DownloadSetting.obtainGlobal();
        }
        if (jVar.v() != 0) {
            return DownloadSetting.obtain(jVar.v());
        }
        if (jVar.i()) {
            return DownloadSetting.obtain(j());
        }
        if (jVar.e() != null) {
            return DownloadSetting.obtain(jVar.e());
        }
        return DownloadSetting.obtainGlobal();
    }

    public static boolean zx(DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean zx() {
        return DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static int j(@NonNull DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    public static double j(int i2) {
        return DownloadSetting.obtain(i2).optDouble("clean_min_install_size", 0.0d);
    }
}
