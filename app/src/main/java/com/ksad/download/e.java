package com.ksad.download;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.kwad.sdk.api.core.fragment.FileProvider;
import com.kwad.sdk.core.download.DownloadParams;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e {
    public static PendingIntent a(File file, int i2, boolean z) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(3);
        Context context = c.M().getContext();
        Uri a2 = a(context, file);
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, a2, 3);
        }
        if (z) {
            c.M();
            if (c.P()) {
                intent = a(intent);
            }
        }
        return PendingIntent.getActivity(context, i2, intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }

    private static Intent a(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        return intent2;
    }

    private static Uri a(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    public static PendingIntent e(String str, int i2) {
        Context context = c.M().getContext();
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, launchIntentForPackage, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }

    public static PendingIntent l(DownloadTask downloadTask) {
        File file = new File(downloadTask.getTargetFilePath());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        intent.addFlags(3);
        Context context = c.M().getContext();
        Uri a2 = a(context, file);
        intent.setDataAndType(a2, AdBaseConstants.MIME_APK);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, a2, 3);
        }
        c.M();
        if (c.P() && (downloadTask.getTag() instanceof DownloadParams) && ((DownloadParams) downloadTask.getTag()).requestInstallPermission) {
            intent = a(intent);
        }
        return PendingIntent.getActivity(context, downloadTask.getId(), intent, Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728);
    }
}
