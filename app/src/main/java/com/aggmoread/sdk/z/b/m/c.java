package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import java.io.File;
import java.util.UUID;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a */
    private File f4697a;

    /* renamed from: b */
    private PackageInfo f4698b;

    /* renamed from: c */
    private Context f4699c;

    static {
        new c();
    }

    private c() {
        UUID.randomUUID().toString();
    }

    public static c a(Context context, String str) {
        c cVar = new c(context);
        cVar.f4697a = new File(str);
        cVar.f4698b = d.b(context, str);
        return cVar;
    }

    public Bitmap b() {
        Drawable background;
        Drawable foreground;
        try {
            if (this.f4699c != null && f() && a()) {
                String absolutePath = this.f4697a.getAbsolutePath();
                PackageManager packageManager = this.f4699c.getPackageManager();
                ApplicationInfo applicationInfo = this.f4698b.applicationInfo;
                if (applicationInfo != null) {
                    applicationInfo.sourceDir = absolutePath;
                    applicationInfo.publicSourceDir = absolutePath;
                    Drawable applicationIcon = packageManager.getApplicationIcon(applicationInfo);
                    if (Build.VERSION.SDK_INT >= 26 && !(applicationIcon instanceof BitmapDrawable)) {
                        if (f1.a.a(applicationIcon)) {
                            background = f1.b.a(applicationIcon).getBackground();
                            foreground = f1.b.a(applicationIcon).getForeground();
                            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{background, foreground});
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
            throw new PackageManager.NameNotFoundException("app name(" + c() + ") not found");
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new PackageManager.NameNotFoundException("app name2(" + c() + ") not found");
        }
    }

    public String c() {
        return a() ? this.f4697a.getAbsolutePath() : "";
    }

    public String d() {
        ApplicationInfo applicationInfo;
        try {
            if (this.f4699c != null && f() && a() && (applicationInfo = this.f4698b.applicationInfo) != null) {
                applicationInfo.sourceDir = this.f4697a.getAbsolutePath();
                applicationInfo.publicSourceDir = this.f4697a.getAbsolutePath();
                return (String) this.f4698b.applicationInfo.loadLabel(this.f4699c.getPackageManager());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        throw new PackageManager.NameNotFoundException("app name(" + c() + ") not found");
    }

    public String e() {
        if (f() && a()) {
            return this.f4698b.packageName;
        }
        throw new PackageManager.NameNotFoundException("app name(" + c() + ") not found");
    }

    public boolean f() {
        return this.f4698b != null;
    }

    public boolean g() {
        if (this.f4699c == null) {
            return false;
        }
        try {
            return d.c(this.f4699c, e());
        } catch (Exception unused) {
            return false;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ApkFileLoader {");
        sb2.append("existApkFile = ");
        sb2.append(a());
        sb2.append(",");
        sb2.append("apkFilePath = ");
        sb2.append(c());
        sb2.append(",");
        try {
            sb2.append("getAppName = ");
            sb2.append(d());
            sb2.append(",");
            sb2.append("getApkIcon = ");
            sb2.append(b());
            sb2.append(",");
            sb2.append("getPackageName = ");
            sb2.append(e());
            sb2.append(",");
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
        }
        sb2.append("isInstalled = ");
        sb2.append(g());
        sb2.append(" }");
        return sb2.toString();
    }

    private c(Context context) {
        UUID.randomUUID().toString();
        this.f4699c = context;
    }

    public boolean a() {
        File file = this.f4697a;
        if (file != null) {
            return file.exists();
        }
        return false;
    }
}
