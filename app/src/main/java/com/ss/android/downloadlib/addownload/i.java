package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i {
    public static boolean a(int i10) {
        return i10 == 0 || i10 == 1;
    }

    public static boolean b(int i10) {
        return i10 == 2 || i10 == 1;
    }

    public static String c(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String d(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean a(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean b(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean a(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, boolean z10, com.ss.android.socialbase.appdownloader.f fVar) {
        int i10;
        if (fVar == null || TextUtils.isEmpty(fVar.c()) || fVar.b() == null) {
            return 0;
        }
        try {
            i10 = a(fVar, fVar.c());
        } catch (Throwable th2) {
            k.u().a(th2, "redirectSavePathIfPossible");
            i10 = 4;
        }
        fVar.a(i10);
        if (i10 == 0) {
            fVar.a(new com.ss.android.downloadlib.c.a());
        }
        if (!fVar.ac()) {
            fVar.a(new com.ss.android.downloadlib.c.b());
        }
        int a10 = com.ss.android.socialbase.appdownloader.d.j().a(fVar);
        com.ss.android.downloadad.api.a.b a11 = a(eVar, a10);
        com.ss.android.downloadlib.addownload.b.f.a().a(a11);
        a11.g(a10);
        a11.h(System.currentTimeMillis());
        a11.i(0L);
        DownloadSetting obtain = DownloadSetting.obtain(fVar.ag());
        if (!a(fVar, obtain, a10) && eVar.f21217b.isShowToast()) {
            String startToast = eVar.f21217b.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = obtain.optString("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z10 ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            k.d().a(2, fVar.b(), eVar.f21217b, startToast, null, 0);
        }
        return a10;
    }

    private static com.ss.android.downloadad.api.a.b a(com.ss.android.downloadlib.addownload.b.e eVar, int i10) {
        com.ss.android.downloadad.api.a.b bVar = new com.ss.android.downloadad.api.a.b(eVar.f21217b, eVar.f21218c, eVar.f21219d, i10);
        boolean z10 = true;
        if (DownloadSetting.obtain(i10).optInt("download_event_opt", 1) > 1) {
            try {
                String packageName = eVar.f21217b.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (k.a().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z10 = false;
                    }
                    bVar.h(z10);
                }
            } catch (Throwable unused) {
            }
        }
        return bVar;
    }

    private static boolean a(com.ss.android.socialbase.appdownloader.f fVar, @NonNull DownloadSetting downloadSetting, int i10) {
        String optString;
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            JSONObject jSONObject = null;
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject))) {
                    optString.hashCode();
                    switch (optString) {
                        case "plan_a":
                        case "plan_b":
                        case "plan_e":
                        case "plan_f":
                            if (com.ss.android.socialbase.appdownloader.b.a(optJSONObject, downloadSetting).f21741b == 0) {
                                break;
                            } else {
                                break;
                            }
                        case "plan_c":
                            jSONObject = optJSONObject;
                            break;
                        case "plan_g":
                            if (com.ss.android.socialbase.appdownloader.b.b(optJSONObject, downloadSetting).f21741b == 0) {
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            if (jSONObject != null && jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1) {
                return com.ss.android.socialbase.appdownloader.b.a(DownloadComponentManager.getAppContext(), (Intent) null, jSONObject, i10, new com.ss.android.socialbase.appdownloader.a());
            }
        }
        return false;
    }

    public static String a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    private static int a(com.ss.android.socialbase.appdownloader.f fVar, String str) {
        DownloadSetting obtain = DownloadSetting.obtain(fVar.ag());
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        String d10 = fVar.d();
        String N = fVar.N();
        if (TextUtils.isEmpty(N)) {
            N = com.ss.android.socialbase.appdownloader.c.a(str, d10, fVar.n(), true);
        }
        if (N.length() > 255) {
            N = N.substring(N.length() - 255);
        }
        if (TextUtils.isEmpty(d10)) {
            d10 = N;
        }
        String e10 = fVar.e();
        if (TextUtils.isEmpty(e10)) {
            e10 = com.ss.android.socialbase.appdownloader.c.b();
        }
        String str2 = e10 + File.separator + com.ss.android.socialbase.appdownloader.c.a(d10, obtain);
        DownloadInfo a10 = com.ss.android.socialbase.appdownloader.d.j().a(fVar.b(), str);
        if (a10 != null && a10.isSavePathRedirected()) {
            fVar.c(a10.getSavePath());
            try {
                fVar.a(new JSONObject(a10.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (a10 != null || !"application/vnd.android.package-archive".equalsIgnoreCase(com.ss.android.socialbase.appdownloader.d.j().a(N, fVar.n()))) {
            return a10 != null ? 8 : 9;
        }
        int a11 = com.ss.android.socialbase.appdownloader.b.a(obtain);
        if (a11 == 0) {
            fVar.c(str2);
        }
        return a11;
    }
}
