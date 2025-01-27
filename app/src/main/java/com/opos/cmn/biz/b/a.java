package com.opos.cmn.biz.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.opos.cmn.biz.a.c;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static final String f16623a = "a";

    public static final boolean a(Context context, String str) {
        String str2;
        String str3;
        if (context == null) {
            str2 = f16623a;
            str3 = "executeBrowser with null context";
        } else {
            if (!TextUtils.isEmpty(str)) {
                String b2 = c.b(context);
                com.opos.cmn.an.f.a.b(f16623a, "getBrowserName=" + b2);
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        intent.setClassName(b2, "com.android.browser.BrowserActivity");
                        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                        context.startActivity(intent);
                        return true;
                    } catch (Exception e2) {
                        Log.e(f16623a, "executeBrowserWeb fail", e2);
                    }
                }
                return false;
            }
            str2 = f16623a;
            str3 = "executeBrowserWeb with null url";
        }
        com.opos.cmn.an.f.a.b(str2, str3);
        return false;
    }
}
