package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.FileProvider;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class aq {
    @SuppressLint({"UnspecifiedImmutableFlag"})
    public static PendingIntent a(Context context, int i10, @NonNull Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(context, i10, intent, 201326592) : PendingIntent.getBroadcast(context, i10, intent, 134217728);
    }

    @SuppressLint({"UnspecifiedImmutableFlag"})
    private static PendingIntent b(Context context, int i10, @NonNull Intent intent) {
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getActivity(context, i10, intent, 201326592) : PendingIntent.getActivity(context, i10, intent, 134217728);
    }

    private static Uri c(Context context, File file) {
        if (Build.VERSION.SDK_INT < 24) {
            return Uri.fromFile(file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".adFileProvider", file);
    }

    @Nullable
    public static PendingIntent e(Context context, String str, int i10) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        return b(context, i10, launchIntentForPackage);
    }

    private static Intent j(Intent intent) {
        Intent intent2 = new Intent("intent.action.requestInstallPermission");
        intent2.putExtra("fromNotification", true);
        intent2.putExtra("pendingIntent", intent);
        intent2.addFlags(268435456);
        return intent2;
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static PendingIntent a(Context context, File file, int i10, boolean z10) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435459);
        Uri c10 = c(context, file);
        intent.setDataAndType(c10, "application/vnd.android.package-archive");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, c10, 3);
        }
        if (z10) {
            com.kwad.sdk.c.yU();
            if (com.kwad.sdk.c.yX()) {
                intent = j(intent);
            }
        }
        return b(context, i10, intent);
    }
}
