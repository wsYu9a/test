package com.opos.mobad.d.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* loaded from: classes4.dex */
public class b {
    public static void a(Context context, File file) {
        if (context == null || !com.opos.cmn.an.d.b.a.a(file)) {
            return;
        }
        context.startActivity(b(context, file));
    }

    public static void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(context, new File(str));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("InstallUtils", "", (Throwable) e2);
        }
    }

    private static Intent b(Context context, File file) {
        Uri uriForFile;
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT < 24) {
            uriForFile = Uri.fromFile(file);
        } else {
            uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".MobFileProvider", file);
            intent.setFlags(1);
        }
        context.grantUriPermission(context.getPackageName(), uriForFile, 1);
        intent.setDataAndType(uriForFile, AdBaseConstants.MIME_APK);
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return intent;
    }

    public static Intent b(Context context, String str) {
        return b(context, new File(str));
    }
}
