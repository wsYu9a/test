package com.ss.android.downloadlib.g;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {
    @Nullable
    public static JSONObject a() {
        return com.ss.android.downloadlib.addownload.k.j().optJSONObject("ad");
    }

    @NonNull
    public static DownloadSetting b(DownloadModel downloadModel) {
        return DownloadSetting.obtain(a(downloadModel));
    }

    public static int c(@NonNull DownloadModel downloadModel) {
        return a(b(downloadModel));
    }

    public static boolean d(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean e(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean f(int i10) {
        return DownloadSetting.obtain(i10).optInt("clean_space_switch", 0) == 1;
    }

    public static boolean g(int i10) {
        return DownloadSetting.obtain(i10).optInt("clean_app_cache_dir", 0) == 1;
    }

    public static JSONObject a(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? m.a(com.ss.android.downloadlib.addownload.k.j(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static boolean b(com.ss.android.downloadad.api.a.a aVar) {
        return a(aVar).optInt("pause_reserve_on_wifi", 0) == 1 && aVar.q();
    }

    public static long d() {
        long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("start_install_interval");
        if (optLong == 0) {
            return 300000L;
        }
        return optLong;
    }

    public static long e() {
        long optLong = com.ss.android.downloadlib.addownload.k.j().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static int f(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).optInt("app_install_keep_receiver_time_s", 60);
    }

    public static long g(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).optLong("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }

    public static boolean c(com.ss.android.downloadad.api.a.a aVar) {
        return a(aVar).optInt("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && aVar.q();
    }

    public static boolean d(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_broadcast", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).optInt("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean e(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_polling_thread", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).optInt("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static long b(int i10) {
        return DownloadSetting.obtain(i10).optLong("storage_min_size", 0L);
    }

    @NonNull
    public static DownloadSetting a(com.ss.android.downloadad.api.a.a aVar) {
        if (aVar == null) {
            return DownloadSetting.obtainGlobal();
        }
        if (aVar.s() != 0) {
            return DownloadSetting.obtain(aVar.s());
        }
        if (aVar.c()) {
            return DownloadSetting.obtain(a());
        }
        if (aVar.r() != null) {
            return DownloadSetting.obtain(aVar.r());
        }
        return DownloadSetting.obtainGlobal();
    }

    public static boolean b(DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static long c(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean b() {
        return DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static boolean c() {
        return com.ss.android.downloadlib.addownload.k.j().optInt("is_enable_start_install_again") == 1;
    }

    public static int b(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).optInt("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean c(com.ss.android.downloadad.api.a.b bVar) {
        return com.ss.android.downloadlib.addownload.k.j().optInt("market_install_finish_opt_switch", 0) == 1 || a((com.ss.android.downloadad.api.a.a) bVar).optInt("market_install_finish_opt_switch", 0) == 1;
    }

    public static int a(@NonNull DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    public static double a(int i10) {
        return DownloadSetting.obtain(i10).optDouble("clean_min_install_size", l5.c.f27899e);
    }

    public static int a(com.ss.android.downloadad.api.a.b bVar) {
        return a((com.ss.android.downloadad.api.a.a) bVar).optInt("ttdownloader_app_install_detect_count", 15);
    }
}
