package com.tencent.bugly.beta.global;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.bugly.proguard.C0871p;
import com.tencent.bugly.proguard.X;
import com.tencent.bugly.proguard.ca;
import java.io.File;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        TelephonyManager telephonyManager;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e10) {
            if (!X.b(e10)) {
                e10.printStackTrace();
            }
        }
        if (activeNetworkInfo == null) {
            return 0;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 0 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            switch (telephonyManager.getNetworkType()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 2;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 4;
                default:
                    return 0;
            }
        }
        return 0;
    }

    public static String b(String str) {
        return new com.tencent.bugly.beta.utils.c(str).a();
    }

    public static void b(String str, String str2) {
        SharedPreferences sharedPreferences = e.f22100b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void b(String str, boolean z10) {
        SharedPreferences sharedPreferences = e.f22100b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z10).apply();
        }
    }

    public static int a(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i10, int i11, float f10) {
        DisplayMetrics displayMetrics = e.f22100b.E;
        int i12 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i10 * i11 > i12) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i10, i11);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(rectF, f10, f10, paint);
        canvas.drawRect(0.0f, f10, i10, i11, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(createBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0057 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:11:0x0015, B:15:0x0020, B:17:0x002f, B:21:0x004f, B:23:0x0057, B:25:0x0060, B:26:0x0071, B:38:0x00ca, B:40:0x00d2, B:42:0x00e2, B:46:0x00ee, B:49:0x00cd, B:53:0x00a7, B:54:0x008d, B:56:0x006a, B:60:0x0043), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:11:0x0015, B:15:0x0020, B:17:0x002f, B:21:0x004f, B:23:0x0057, B:25:0x0060, B:26:0x0071, B:38:0x00ca, B:40:0x00d2, B:42:0x00e2, B:46:0x00ee, B:49:0x00cd, B:53:0x00a7, B:54:0x008d, B:56:0x006a, B:60:0x0043), top: B:9:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    public static boolean a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(".apk")) {
                    String a10 = ca.a(file, "MD5");
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), a10)) {
                        X.c("md5 error [file md5: %s] [target md5: %s]", a10, str);
                        return false;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("chmod 777 ");
                    sb2.append(file.getAbsolutePath());
                    Runtime.getRuntime().exec(sb2.toString());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        Class.forName("androidx.core.content.FileProvider");
                        Class[] clsArr = {Context.class, String.class, File.class};
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(com.tencent.bugly.crashreport.common.info.a.a(context).f22294g);
                        sb3.append(".fileProvider");
                        Uri uri = (Uri) ca.a("androidx.core.content.FileProvider", "getUriForFile", null, clsArr, new Object[]{context, sb3.toString(), file});
                        if (uri == null) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("file location is ");
                            sb4.append(file.toString());
                            X.b(sb4.toString(), new Object[0]);
                            X.b("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("contentUri is ");
                        sb5.append(uri);
                        X.a(sb5.toString(), new Object[0]);
                        intent.setDataAndType(uri, "application/vnd.android.package-archive");
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                    }
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Exception e10) {
                if (!X.a(e10)) {
                    e10.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(File file, String str, String str2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String a10 = ca.a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), a10)) {
                        return true;
                    }
                    X.c("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", a10, str);
                    return false;
                }
            } catch (Exception unused) {
                X.b("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0074 A[Catch: IOException -> 0x0070, TRY_LEAVE, TryCatch #8 {IOException -> 0x0070, blocks: (B:58:0x006c, B:51:0x0074), top: B:57:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.io.File r3, java.io.File r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L7c
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r2 == 0) goto L7c
            boolean r2 = r3.isDirectory()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            if (r2 == 0) goto L12
            goto L7c
        L12:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L4a
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L40
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
        L20:
            int r1 = r2.read(r4)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            if (r1 <= 0) goto L2f
            r3.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2d
            goto L20
        L2a:
            r4 = move-exception
        L2b:
            r1 = r3
            goto L68
        L2d:
            r4 = move-exception
            goto L3c
        L2f:
            r2.close()     // Catch: java.io.IOException -> L36
            r3.close()     // Catch: java.io.IOException -> L36
            goto L3a
        L36:
            r3 = move-exception
            r3.printStackTrace()
        L3a:
            r0 = 1
            goto L64
        L3c:
            r1 = r2
            goto L50
        L3e:
            r3 = move-exception
            goto L43
        L40:
            r3 = move-exception
            r4 = r3
            goto L46
        L43:
            r4 = r1
            r1 = r2
            goto L6a
        L46:
            r3 = r1
            goto L3c
        L48:
            r3 = move-exception
            goto L4d
        L4a:
            r3 = move-exception
            r4 = r3
            goto L4f
        L4d:
            r4 = r1
            goto L6a
        L4f:
            r3 = r1
        L50:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L5b
            r1.close()     // Catch: java.io.IOException -> L59
            goto L5b
        L59:
            r3 = move-exception
            goto L61
        L5b:
            if (r3 == 0) goto L64
            r3.close()     // Catch: java.io.IOException -> L59
            goto L64
        L61:
            r3.printStackTrace()
        L64:
            return r0
        L65:
            r4 = move-exception
            r2 = r1
            goto L2b
        L68:
            r3 = r4
            goto L43
        L6a:
            if (r1 == 0) goto L72
            r1.close()     // Catch: java.io.IOException -> L70
            goto L72
        L70:
            r4 = move-exception
            goto L78
        L72:
            if (r4 == 0) goto L7b
            r4.close()     // Catch: java.io.IOException -> L70
            goto L7b
        L78:
            r4.printStackTrace()
        L7b:
            throw r3
        L7c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(java.io.File, java.io.File):boolean");
    }

    public static Bitmap a(Drawable drawable) {
        Bitmap createBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
            createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        } else {
            createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void a(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.delete()) {
                X.b("cannot delete file:%s", file2.getAbsolutePath());
            }
        }
    }

    public static synchronized <T extends Parcelable> boolean a(String str, T t10) {
        synchronized (a.class) {
            boolean z10 = false;
            if (t10 == null) {
                return false;
            }
            byte[] a10 = ca.a(t10);
            if (a10 != null) {
                if (C0871p.f22799a.a(1002, str, a10)) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    public static synchronized <T extends Parcelable> T a(String str, Parcelable.Creator<T> creator) {
        synchronized (a.class) {
            Map<String, byte[]> c10 = C0871p.f22799a.c();
            if (c10 == null) {
                return null;
            }
            byte[] bArr = c10.get(str);
            if (bArr != null && bArr.length > 0) {
                return (T) ca.a(bArr, creator);
            }
            return null;
        }
    }

    public static synchronized boolean a(String str) {
        boolean a10;
        synchronized (a.class) {
            a10 = C0871p.f22799a.a(str);
        }
        return a10;
    }

    public static String a(String str, String str2) {
        SharedPreferences sharedPreferences = e.f22100b.D;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static boolean a(String str, boolean z10) {
        SharedPreferences sharedPreferences = e.f22100b.D;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z10) : z10;
    }

    public static String a(Context context, String str) {
        Bundle bundle;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get(str)) == null) {
                return null;
            }
            return String.valueOf(obj);
        } catch (Exception e10) {
            X.b(a.class, "getManifestMetaDataValue exception:" + e10.getMessage(), new Object[0]);
            return null;
        }
    }
}
