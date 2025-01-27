package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* loaded from: classes4.dex */
public class ah implements z {

    /* renamed from: a */
    private boolean f25645a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.f25645a) {
                OpenIDSDK.a(context);
                this.f25645a = true;
            }
            if (OpenIDSDK.a()) {
                return OpenIDSDK.c(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
