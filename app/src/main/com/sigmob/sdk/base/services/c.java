package com.sigmob.sdk.base.services;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.g0;
import com.sigmob.sdk.base.common.p;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.windad.WindAdError;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c extends BroadcastReceiver {
    public DownloadManager a(Context context) {
        return (DownloadManager) context.getSystemService("download");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
        BaseAdUnit baseAdUnit = null;
        p.c(longExtra, null);
        File file = new File(com.sigmob.sdk.base.utils.d.f(), longExtra + ".log");
        Object readFromCache = FileUtil.readFromCache(file.getAbsolutePath());
        if (readFromCache != null && (readFromCache instanceof BaseAdUnit)) {
            baseAdUnit = (BaseAdUnit) readFromCache;
            BaseAdUnit f10 = com.sigmob.sdk.base.common.h.f(baseAdUnit.getUuid());
            if (f10 != null) {
                baseAdUnit = f10;
            }
        }
        FileUtil.deleteFile(file.getAbsolutePath());
        String action = intent.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DOWNLOAD_COMPLETE") && baseAdUnit != null) {
            a(context, longExtra, baseAdUnit);
        }
    }

    public final void a(Context context, long j10, BaseAdUnit baseAdUnit) {
        if (baseAdUnit != null) {
            Map<String, Object> a10 = p.a(j10);
            com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.H);
            String str = "download info is null";
            if (a10 != null) {
                String str2 = (String) a10.get(TTDownloadField.TT_FILE_NAME);
                Integer num = (Integer) a10.get("status");
                int intValue = num.intValue();
                Integer num2 = (Integer) a10.get(MediationConstant.KEY_REASON);
                num2.intValue();
                Uri uri = (Uri) a10.get("uri");
                if (str2 != null && intValue == 8) {
                    try {
                        baseAdUnit.enableUseDownloadApk(true);
                        String realFilePath = FileUtil.getRealFilePath(context, uri);
                        b0.a(baseAdUnit, PointCategory.DOWNLOAD_END, ClientMetadata.getPackageInfoWithUri(context, realFilePath), "1");
                        HashMap hashMap = new HashMap();
                        hashMap.put(p3.i.f29758c, "1");
                        hashMap.put("downloadId", Long.valueOf(j10));
                        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
                        p.a(context, realFilePath, baseAdUnit);
                        return;
                    } catch (Throwable th2) {
                        SigmobLog.e(th2.getMessage());
                        b0.a(PointCategory.APP_INSTALL_START, WindAdError.ERROR_SIGMOB_INSTALL_FAIL.getErrorCode(), th2.getMessage(), baseAdUnit);
                        b0.b(PointCategory.APP_INSTALL_START, "0", baseAdUnit);
                        return;
                    }
                }
                try {
                    str = String.format("status %d, reason %d", num, num2);
                    SigmobLog.i("handleDownloadComplete:fail:" + FileUtil.deleteFile(FileUtil.getRealFilePath(context, uri)));
                } catch (Throwable th3) {
                    SigmobLog.e(th3.getMessage());
                }
            }
            try {
                g0.makeText(context, "下载失败", 0).show();
            } catch (Throwable th4) {
                SigmobLog.e(th4.getMessage());
            }
            b0.a(PointCategory.DOWNLOAD_FAILED, 2, str, baseAdUnit);
            b0.b(PointCategory.DOWNLOAD_END, "0", baseAdUnit);
            HashMap hashMap2 = new HashMap();
            hashMap2.put(p3.i.f29758c, "0");
            hashMap2.put("downloadId", Long.valueOf(j10));
            BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_END);
        }
    }
}
