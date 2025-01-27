package cn.vlion.ad.inland.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.vlion.ad.inland.ad.utils.apkdownload.DownloadApkData;
import cn.vlion.ad.inland.base.event.VlionAdEventType;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.util.down.VlionAdDownStrategyUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.timer.VlionTimer;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d0 extends BroadcastReceiver {
    public static void a(String str, String str2) {
        String str3;
        try {
            if (Objects.equals(str, "android.intent.action.PACKAGE_ADDED")) {
                VlionAdDownStrategyUtils.getInstance().startEventUpload(str2);
                VlionADEventManager.submitDa(VlionServiceConfigParse.getInstance().getEventsBean().getDaInstallCb(), VlionAdEventType.VLION_EVENT_DA_INSTALL, str2);
                str3 = " VLionAddReceiver submitDa=da_install";
            } else if (Objects.equals(str, "android.intent.action.PACKAGE_REPLACED")) {
                VlionADEventManager.submitDa(VlionServiceConfigParse.getInstance().getEventsBean().getDaUpdateCb(), VlionAdEventType.VLION_EVENT_DA_UPDATE, str2);
                str3 = " VLionAddReceiver submitDa=da_update";
            } else {
                if (!Objects.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
                    return;
                }
                VlionADEventManager.submitDa(VlionServiceConfigParse.getInstance().getEventsBean().getDaUninstallCb(), VlionAdEventType.VLION_EVENT_DA_UNINSTALL, str2);
                str3 = " VLionAddReceiver submitDa=da_uninstall";
            }
            LogVlion.e(str3);
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Throwable th2;
        String schemeSpecificPart;
        if (intent == null) {
            return;
        }
        try {
            LogVlion.e("VLionAddReceiver intent.getAction() = 11 " + intent.getAction());
            if (!Objects.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED") && !Objects.equals(intent.getAction(), "android.intent.action.PACKAGE_REPLACED")) {
                if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                    try {
                        LogVlion.e(" VLionAddReceiver PACKAGE_REMOVED=");
                        schemeSpecificPart = intent.getData() != null ? intent.getData().getSchemeSpecificPart() : "";
                        LogVlion.e(" VLionAddReceiver PACKAGE_REMOVED=" + schemeSpecificPart);
                        a(intent.getAction(), schemeSpecificPart);
                        try {
                            VlionTimer.getInstance().startTimer(0L, new c0());
                            return;
                        } catch (Throwable th3) {
                            VlionSDkManager.getInstance().upLoadCatchException(th3);
                            return;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        LogVlion.e(" VLionAddReceiver PACKAGE_REMOVED=" + th2.toString());
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
                return;
            }
            try {
                long longExtra = intent.getLongExtra(DownloadConstants.EXTRA_DOWNLOAD_ID, -1L);
                int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", 0);
                String stringExtra = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
                schemeSpecificPart = intent.getData() != null ? intent.getData().getSchemeSpecificPart() : "";
                LogVlion.e("VLionAddReceiver downloadId=" + longExtra + " pkg=" + schemeSpecificPart + " EXTRA_STATUS=" + intExtra + " EXTRA_STATUS_MESSAGE=" + stringExtra);
                DownloadApkData a10 = s0.a(schemeSpecificPart);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("VLionAddReceiver downloadApkData=");
                sb2.append(a10 == null);
                LogVlion.e(sb2.toString());
                if (a10 != null) {
                    a10.submitInstallComplete();
                    if (a10.isAdClosed()) {
                        s0.a(a10.getDownloadId());
                    }
                }
                a(intent.getAction(), schemeSpecificPart);
                try {
                    VlionTimer.getInstance().startTimer(0L, new c0());
                } catch (Throwable th5) {
                    VlionSDkManager.getInstance().upLoadCatchException(th5);
                }
            } catch (Throwable th6) {
                th2 = th6;
                VlionSDkManager.getInstance().upLoadCatchException(th2);
            }
        } catch (Throwable th7) {
            VlionSDkManager.getInstance().upLoadCatchException(th7);
        }
    }
}
