package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {
    public static j j(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
        if (str.equals("v1")) {
            return new pa(context, obtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new t(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new nt(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new lg(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new y(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new k(context, obtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new i(context, obtain, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new p(context, obtain, com.ss.android.socialbase.appdownloader.i.j(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.g.pa().g(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean j(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        if (context == null || str == null) {
            return false;
        }
        j jVar = null;
        String zx = com.ss.android.socialbase.appdownloader.i.zx();
        if (TextUtils.isEmpty(zx) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.gv.q.i() && str.equals("v1")) {
            jVar = new pa(context, downloadSetting, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.i() && str.equals("v2")) {
            jVar = new t(context, downloadSetting, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.i() && str.equals("v3")) {
            jVar = new nt(context, downloadSetting, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.g() && str.equals("o1")) {
            jVar = new lg(context, downloadSetting, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.g() && str.equals("o2")) {
            jVar = new y(context, downloadSetting, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.g() && str.equals("o3")) {
            jVar = new k(context, downloadSetting, zx, zx, zx);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.i() && str.equals("custom")) {
            jVar = new i(context, downloadSetting, zx, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.gv.q.i() && str.equals("vbi")) {
            jVar = new p(context, downloadSetting, zx);
        }
        return jVar != null && jVar.j();
    }
}
