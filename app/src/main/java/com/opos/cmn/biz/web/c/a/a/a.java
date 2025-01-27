package com.opos.cmn.biz.web.c.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public final class a {
    public static int a() {
        return 201;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.opos.cmn.an.h.c.a.d(context) ? com.opos.cmn.an.h.c.a.h(context) : "nonet";
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("JSUtils", "", e2);
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    intent.setDataAndType(Uri.parse(str), AdBaseConstants.MIME_APK);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("JSUtils", "", e2);
            }
        }
        return false;
    }
}
