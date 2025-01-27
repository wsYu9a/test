package com.alimm.tanx.core.ad.interaction;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxTestLog;

/* loaded from: classes.dex */
public class tanxc_for {
    private long tanxc_do;

    public static class tanxc_do {
        private static final tanxc_for tanxc_do = new tanxc_for((byte) 0);
    }

    public /* synthetic */ tanxc_for(byte b10) {
        this();
    }

    private boolean tanxc_if(Context context, String str, String str2, String str3) {
        LogUtils.d("DeepLinkManager", "start..");
        if (TextUtils.isEmpty(str)) {
            LogUtils.d("DeepLinkManager", "forwardToActivity deepLinkUrl is null or empty.");
            return false;
        }
        try {
            LogUtils.d("DeepLinkManager", "start parseUri");
            Intent parseUri = Intent.parseUri(str, 1);
            if (parseUri == null) {
                tanxc_do("intent == null", str3, str2, str);
            }
            if (parseUri != null) {
                parseUri.setFlags(805339136);
            }
            LogUtils.d("DeepLinkManager", "start startActivity");
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 30 || context.getApplicationContext().getApplicationInfo().targetSdkVersion < 30) {
                boolean z10 = context.getPackageManager().resolveActivity(parseUri, 0) != null;
                if (!z10) {
                    tanxc_do("2appInstalled为false-sdk_version:" + i10 + ",targetSdkVersion" + context.getApplicationContext().getApplicationInfo().targetSdkVersion, str3, str2, str);
                }
                return OrangeManager.getInstance().getCommonSwitch("resolveActivitySwitch") ? parseUri != null && z10 && tanxc_do(context, parseUri, str3, str2, str) : parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
            }
            LogUtils.d("DeepLinkManager", "设备和targetSdkVersion均>=30");
            if (ContextCompat.checkSelfPermission(context, "android.permission.QUERY_ALL_PACKAGES") != 0) {
                LogUtils.d("DeepLinkManager", "没有权限:QUERY_ALL_PACKAGES");
                return parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
            }
            LogUtils.d("DeepLinkManager", "有权限:QUERY_ALL_PACKAGES");
            boolean z11 = context.getPackageManager().resolveActivity(parseUri, 0) != null;
            if (!z11) {
                tanxc_do("1appInstalled为false-sdk_version:" + i10 + ",targetSdkVersion" + context.getApplicationContext().getApplicationInfo().targetSdkVersion, str3, str2, str);
            }
            return OrangeManager.getInstance().getCommonSwitch("resolveActivitySwitch30") ? parseUri != null && z11 && tanxc_do(context, parseUri, str3, str2, str) : parseUri != null && tanxc_do(context, parseUri, str3, str2, str);
        } catch (Exception e10) {
            LogUtils.e("DeepLinkManager", e10);
            tanxc_do(LogUtils.getStackTraceMessage(e10), str3, str2, str);
            return false;
        }
    }

    public boolean tanxc_do(Context context, String str) {
        return tanxc_do(context, str, "", "");
    }

    private tanxc_for() {
    }

    public boolean tanxc_do(Context context, String str, String str2, String str3) {
        boolean tanxc_if = tanxc_if(context, str, str2, str3);
        if (tanxc_if) {
            this.tanxc_do = System.currentTimeMillis();
            TanxTestLog.sendLog("deepLink", str);
        } else {
            this.tanxc_do = -1L;
        }
        LogUtils.v("DeepLinkManager", "forwardToDeepLink: forwardSucceed = " + tanxc_if);
        return tanxc_if;
    }

    private void tanxc_do(String str, String str2, String str3, String str4) {
        TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeepLinkManager", str, "forwardToActivityTask", str2, str3, str4, "DeepLinkManager");
    }

    private boolean tanxc_do(Context context, Intent intent, String str, String str2, String str3) {
        LogUtils.d("DeepLinkManager", "startActivity...");
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e10) {
            LogUtils.e("DeepLinkManager", e10);
            e10.printStackTrace();
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "DeepLinkManager", LogUtils.getStackTraceMessage(e10), "startActivityTask", str, str2, str3, "DeepLinkManager");
            LogUtils.d("DeepLinkManager", "startActivity failed.");
            return false;
        }
    }
}
