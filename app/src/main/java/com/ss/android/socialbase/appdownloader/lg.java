package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: classes4.dex */
public final class lg {

    public static class j {

        /* renamed from: g */
        private String f24476g;
        private int gv;

        /* renamed from: i */
        private Drawable f24477i;

        /* renamed from: j */
        private String f24478j;
        private boolean lg;
        private String q;
        private String zx;

        public j(String str, String str2, Drawable drawable, String str3, String str4, int i2, boolean z) {
            zx(str2);
            j(drawable);
            j(str);
            i(str3);
            g(str4);
            j(i2);
            j(z);
        }

        public String g() {
            return this.zx;
        }

        public int gv() {
            return this.gv;
        }

        public String i() {
            return this.f24478j;
        }

        public Drawable j() {
            return this.f24477i;
        }

        public String lg() {
            return this.q;
        }

        public String q() {
            return this.f24476g;
        }

        public String toString() {
            return "{\n  pkg name: " + i() + "\n  app icon: " + j() + "\n  app name: " + g() + "\n  app path: " + q() + "\n  app v name: " + lg() + "\n  app v code: " + gv() + "\n  is system: " + zx() + "}";
        }

        public boolean zx() {
            return this.lg;
        }

        public void g(String str) {
            this.q = str;
        }

        public void i(String str) {
            this.f24476g = str;
        }

        public void j(Drawable drawable) {
            this.f24477i = drawable;
        }

        public void zx(String str) {
            this.zx = str;
        }

        public void j(boolean z) {
            this.lg = z;
        }

        public void j(String str) {
            this.f24478j = str;
        }

        public void j(int i2) {
            this.gv = i2;
        }
    }

    private static boolean i(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isWhitespace(str.charAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int j(String str) {
        if (i(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static j zx(String str) {
        try {
            PackageManager packageManager = DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return j(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static j j(PackageManager packageManager, PackageInfo packageInfo) {
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str = packageInfo.packageName;
        String charSequence = (applicationInfo == null || applicationInfo.loadLabel(packageManager) == null) ? "" : applicationInfo.loadLabel(packageManager).toString();
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new j(str, charSequence, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
