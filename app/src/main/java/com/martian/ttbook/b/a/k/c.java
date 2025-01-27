package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.io.File;
import java.util.UUID;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private File f15044a;

    /* renamed from: b */
    private PackageInfo f15045b;

    /* renamed from: c */
    private Context f15046c;

    static {
        new c();
    }

    private c() {
        UUID.randomUUID().toString();
    }

    private c(Context context) {
        UUID.randomUUID().toString();
        this.f15046c = context;
    }

    public static c a(Context context, String str) {
        c cVar = new c(context);
        cVar.f15044a = new File(str);
        cVar.f15045b = d.c(context, str);
        return cVar;
    }

    public boolean b() {
        File file = this.f15044a;
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    public Bitmap c() {
        try {
            if (this.f15046c != null && g() && b()) {
                String absolutePath = this.f15044a.getAbsolutePath();
                PackageManager packageManager = this.f15046c.getPackageManager();
                ApplicationInfo applicationInfo = this.f15045b.applicationInfo;
                if (applicationInfo != null) {
                    applicationInfo.sourceDir = absolutePath;
                    applicationInfo.publicSourceDir = absolutePath;
                    Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                    if (Build.VERSION.SDK_INT >= 26 && !(applicationIcon instanceof BitmapDrawable)) {
                        if (applicationIcon instanceof AdaptiveIconDrawable) {
                            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{((AdaptiveIconDrawable) applicationIcon).getBackground(), ((AdaptiveIconDrawable) applicationIcon).getForeground()});
                            Bitmap createBitmap = Bitmap.createBitmap(layerDrawable.getIntrinsicWidth(), layerDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            layerDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                            layerDrawable.draw(canvas);
                            return createBitmap;
                        }
                    }
                    return ((BitmapDrawable) applicationIcon).getBitmap();
                }
            }
            throw new PackageManager.NameNotFoundException("app name(" + d() + ") not found");
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new PackageManager.NameNotFoundException("app name2(" + d() + ") not found");
        }
    }

    public String d() {
        return b() ? this.f15044a.getAbsolutePath() : "";
    }

    public String e() {
        ApplicationInfo applicationInfo;
        try {
            if (this.f15046c != null && g() && b() && (applicationInfo = this.f15045b.applicationInfo) != null) {
                applicationInfo.sourceDir = this.f15044a.getAbsolutePath();
                applicationInfo.publicSourceDir = this.f15044a.getAbsolutePath();
                return (String) this.f15045b.applicationInfo.loadLabel(this.f15046c.getPackageManager());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        throw new PackageManager.NameNotFoundException("app name(" + d() + ") not found");
    }

    public String f() {
        if (g() && b()) {
            return this.f15045b.packageName;
        }
        throw new PackageManager.NameNotFoundException("app name(" + d() + ") not found");
    }

    public boolean g() {
        return this.f15045b != null;
    }

    public boolean h() {
        if (this.f15046c == null) {
            return false;
        }
        try {
            return d.d(this.f15046c, f());
        } catch (Exception unused) {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ApkFileLoader {");
        sb.append("existApkFile = ");
        sb.append(b());
        sb.append(",");
        sb.append("apkFilePath = ");
        sb.append(d());
        sb.append(",");
        try {
            sb.append("getAppName = ");
            sb.append(e());
            sb.append(",");
            sb.append("getApkIcon = ");
            sb.append(c());
            sb.append(",");
            sb.append("getPackageName = ");
            sb.append(f());
            sb.append(",");
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
        sb.append("isInstalled = ");
        sb.append(h());
        sb.append(" }");
        return sb.toString();
    }
}
