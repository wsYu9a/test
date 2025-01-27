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
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class y {
    public static boolean j(int i2) {
        return i2 == 0 || i2 == 1;
    }

    public static boolean j(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean zx(int i2) {
        return i2 == 2 || i2 == 1;
    }

    public static boolean zx(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean j(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int j(@NonNull com.ss.android.downloadlib.addownload.zx.q qVar, boolean z, com.ss.android.socialbase.appdownloader.gv gvVar) {
        int i2;
        if (gvVar == null || TextUtils.isEmpty(gvVar.j()) || gvVar.getContext() == null) {
            return 0;
        }
        try {
            i2 = j(gvVar, gvVar.j());
        } catch (Throwable th) {
            pa.v().j(th, "redirectSavePathIfPossible");
            i2 = 4;
        }
        gvVar.j(i2);
        if (i2 == 0) {
            gvVar.j(new com.ss.android.downloadlib.i.j());
        }
        if (!gvVar.cm()) {
            gvVar.j(new com.ss.android.downloadlib.i.zx());
        }
        int j2 = com.ss.android.socialbase.appdownloader.g.pa().j(gvVar);
        com.ss.android.downloadad.api.j.zx j3 = j(qVar, j2);
        com.ss.android.downloadlib.addownload.zx.gv.j().j(j3);
        j3.lg(j2);
        j3.y(System.currentTimeMillis());
        j3.k(0L);
        DownloadSetting obtain = DownloadSetting.obtain(gvVar.yq());
        if (!j(gvVar, obtain, j2) && qVar.zx.isShowToast()) {
            String startToast = qVar.zx.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = obtain.optString("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            pa.i().j(2, gvVar.getContext(), qVar.zx, startToast, null, 0);
        }
        return j2;
    }

    private static com.ss.android.downloadad.api.j.zx j(com.ss.android.downloadlib.addownload.zx.q qVar, int i2) {
        com.ss.android.downloadad.api.j.zx zxVar = new com.ss.android.downloadad.api.j.zx(qVar.zx, qVar.f24239i, qVar.f24238g, i2);
        boolean z = true;
        if (DownloadSetting.obtain(i2).optInt("download_event_opt", 1) > 1) {
            try {
                String packageName = qVar.zx.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (pa.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    zxVar.y(z);
                }
            } catch (Throwable unused) {
            }
        }
        return zxVar;
    }

    private static boolean j(com.ss.android.socialbase.appdownloader.gv gvVar, @NonNull DownloadSetting downloadSetting, int i2) {
        String optString;
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            JSONObject jSONObject = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                    if (optJSONObject != null && ((optString = optJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.gv.j.j(optJSONObject))) {
                        optString.hashCode();
                        switch (optString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.zx.j(optJSONObject, downloadSetting).zx != 0) {
                                    break;
                                } else {
                                    break;
                                }
                            case "plan_c":
                                jSONObject = optJSONObject;
                                continue;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.zx.zx(optJSONObject, downloadSetting).zx != 0) {
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    i3++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1) {
                    return com.ss.android.socialbase.appdownloader.zx.j(DownloadComponentManager.getAppContext(), (Intent) null, jSONObject, i2, new com.ss.android.socialbase.appdownloader.j());
                }
            }
        }
        return false;
    }

    public static String j(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private static int j(com.ss.android.socialbase.appdownloader.gv gvVar, String str) {
        DownloadSetting obtain = DownloadSetting.obtain(gvVar.yq());
        JSONObject optJSONObject = obtain.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        if (optJSONObject == null || TextUtils.isEmpty(optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME))) {
            return -1;
        }
        String zx = gvVar.zx();
        String qt = gvVar.qt();
        if (TextUtils.isEmpty(qt)) {
            qt = com.ss.android.socialbase.appdownloader.i.j(str, zx, gvVar.nt(), true);
        }
        if (qt.length() > 255) {
            qt = qt.substring(qt.length() - 255);
        }
        if (TextUtils.isEmpty(zx)) {
            zx = qt;
        }
        String i2 = gvVar.i();
        if (TextUtils.isEmpty(i2)) {
            i2 = com.ss.android.socialbase.appdownloader.i.zx();
        }
        String str2 = i2 + File.separator + com.ss.android.socialbase.appdownloader.i.j(zx, obtain);
        DownloadInfo j2 = com.ss.android.socialbase.appdownloader.g.pa().j(gvVar.getContext(), str);
        if (j2 != null && j2.isSavePathRedirected()) {
            gvVar.i(j2.getSavePath());
            try {
                gvVar.j(new JSONObject(j2.getDownloadSettingString()));
                return 0;
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (j2 != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.g.pa().j(qt, gvVar.nt()))) {
            return j2 != null ? 8 : 9;
        }
        int j3 = com.ss.android.socialbase.appdownloader.zx.j(obtain);
        if (j3 != 0) {
            return j3;
        }
        gvVar.i(str2);
        return j3;
    }
}
