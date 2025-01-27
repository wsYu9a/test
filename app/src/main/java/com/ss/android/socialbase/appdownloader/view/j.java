package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.q.g;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: classes4.dex */
public class j extends Fragment {
    public static Intent g() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Intent gv() {
        Context q = q();
        if (q == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = q.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i2 = q.getApplicationInfo().uid;
        intent.putExtra("uid", i2);
        intent.putExtra("app_uid", i2);
        return intent;
    }

    private Context q() {
        Context appContext = DownloadComponentManager.getAppContext();
        return (appContext != null || getActivity() == null || getActivity().isFinishing()) ? appContext : getActivity().getApplicationContext();
    }

    public Intent i() {
        Context q = q();
        if (q == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + q.getPackageName()));
    }

    public void j() {
        try {
            try {
                try {
                    startActivityForResult(gv(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(zx(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(g(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(i(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (g.j()) {
            g.j(true);
        } else {
            g.j(false);
        }
    }

    public Intent zx() {
        Context q = q();
        if (q == null) {
            return null;
        }
        String packageName = q.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(DownloadConstants.LOWER_OPPO)) {
                Intent intent = new Intent();
                intent.putExtra(DBDefinition.PACKAGE_NAME, packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra(DBDefinition.PACKAGE_NAME, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + q.getPackageName()));
    }
}
