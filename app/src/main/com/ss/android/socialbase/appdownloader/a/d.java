package com.ss.android.socialbase.appdownloader.a;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {
    public static a a(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
        if (str.equals(r3.c.f30241d)) {
            return new j(context, obtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals(r3.c.f30242e)) {
            return new k(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new g(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new h(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new i(context, obtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new c(context, obtain, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new m(context, obtain, com.ss.android.socialbase.appdownloader.c.a(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.d.j().d(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean a(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        a mVar;
        if (context == null || str == null) {
            return false;
        }
        String b10 = com.ss.android.socialbase.appdownloader.c.b();
        if (TextUtils.isEmpty(b10) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals(r3.c.f30241d)) {
            mVar = new j(context, downloadSetting, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals(r3.c.f30242e)) {
            mVar = new k(context, downloadSetting, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("v3")) {
            mVar = new l(context, downloadSetting, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o1")) {
            mVar = new g(context, downloadSetting, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o2")) {
            mVar = new h(context, downloadSetting, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.e() && str.equals("o3")) {
            mVar = new i(context, downloadSetting, b10, b10, b10);
        } else if (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("custom")) {
            mVar = new c(context, downloadSetting, b10, jSONObject);
        } else {
            mVar = (com.ss.android.socialbase.appdownloader.f.e.d() && str.equals("vbi")) ? new m(context, downloadSetting, b10) : null;
        }
        return mVar != null && mVar.a();
    }
}
