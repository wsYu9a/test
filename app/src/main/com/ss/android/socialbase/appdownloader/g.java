package com.ss.android.socialbase.appdownloader;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: classes4.dex */
public final class g {

    public static class a {

        /* renamed from: a */
        private String f21926a;

        /* renamed from: b */
        private String f21927b;

        /* renamed from: c */
        private Drawable f21928c;

        /* renamed from: d */
        private String f21929d;

        /* renamed from: e */
        private String f21930e;

        /* renamed from: f */
        private int f21931f;

        /* renamed from: g */
        private boolean f21932g;

        public a(String str, String str2, Drawable drawable, String str3, String str4, int i10, boolean z10) {
            b(str2);
            a(drawable);
            a(str);
            c(str3);
            d(str4);
            a(i10);
            a(z10);
        }

        public Drawable a() {
            return this.f21928c;
        }

        public boolean b() {
            return this.f21932g;
        }

        public String c() {
            return this.f21926a;
        }

        public String d() {
            return this.f21927b;
        }

        public String e() {
            return this.f21929d;
        }

        public int f() {
            return this.f21931f;
        }

        public String g() {
            return this.f21930e;
        }

        public String toString() {
            return "{\n  pkg name: " + c() + "\n  app icon: " + a() + "\n  app name: " + d() + "\n  app path: " + e() + "\n  app v name: " + g() + "\n  app v code: " + f() + "\n  is system: " + b() + p3.f.f29748d;
        }

        public void a(Drawable drawable) {
            this.f21928c = drawable;
        }

        public void b(String str) {
            this.f21927b = str;
        }

        public void c(String str) {
            this.f21929d = str;
        }

        public void d(String str) {
            this.f21930e = str;
        }

        public void a(boolean z10) {
            this.f21932g = z10;
        }

        public void a(String str) {
            this.f21926a = str;
        }

        public void a(int i10) {
            this.f21931f = i10;
        }
    }

    public static int a(String str) {
        if (c(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = DownloadComponentManager.getAppContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static a b(String str) {
        try {
            PackageManager packageManager = DownloadComponentManager.getAppContext().getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return a(packageManager, packageManager.getPackageInfo(str, 0));
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    private static boolean c(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!Character.isWhitespace(str.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    private static a a(PackageManager packageManager, PackageInfo packageInfo) {
        String str;
        Drawable drawable = null;
        if (packageInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        String str2 = packageInfo.packageName;
        if (applicationInfo != null && applicationInfo.loadLabel(packageManager) != null) {
            str = applicationInfo.loadLabel(packageManager).toString();
        } else {
            str = "";
        }
        String str3 = str;
        try {
            drawable = applicationInfo.loadIcon(packageManager);
        } catch (Exception unused) {
        }
        return new a(str2, str3, drawable, applicationInfo.sourceDir, packageInfo.versionName, packageInfo.versionCode, (applicationInfo.flags & 1) != 0);
    }
}
