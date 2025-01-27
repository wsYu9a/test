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
import com.baidu.mobads.sdk.internal.bu;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.tencent.bugly.proguard.C0912p;
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
        } catch (Exception e2) {
            if (!X.b(e2)) {
                e2.printStackTrace();
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
        SharedPreferences sharedPreferences = e.f24621b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        }
    }

    public static void b(String str, boolean z) {
        SharedPreferences sharedPreferences = e.f24621b.D;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z).apply();
        }
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static BitmapDrawable a(Bitmap bitmap, int i2, int i3, float f2) {
        DisplayMetrics displayMetrics = e.f24621b.E;
        int i4 = (int) (displayMetrics.widthPixels * displayMetrics.heightPixels * 0.8f);
        if (bitmap == null || i2 * i3 > i4) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i2, i3);
        RectF rectF = new RectF(rect);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(rectF, f2, f2, paint);
        canvas.drawRect(0.0f, f2, i2, i3, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
        return new BitmapDrawable(createBitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: Exception -> 0x0108, TryCatch #0 {Exception -> 0x0108, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x0048, B:22:0x0050, B:24:0x0059, B:25:0x006a, B:38:0x00db, B:40:0x00e3, B:42:0x00f3, B:46:0x00ff, B:49:0x00de, B:54:0x00b6, B:56:0x00c1, B:58:0x009a, B:61:0x0063, B:65:0x003c), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00f3 A[Catch: Exception -> 0x0108, TryCatch #0 {Exception -> 0x0108, blocks: (B:11:0x0014, B:15:0x001f, B:17:0x002e, B:20:0x0048, B:22:0x0050, B:24:0x0059, B:25:0x006a, B:38:0x00db, B:40:0x00e3, B:42:0x00f3, B:46:0x00ff, B:49:0x00de, B:54:0x00b6, B:56:0x00c1, B:58:0x009a, B:61:0x0063, B:65:0x003c), top: B:9:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r18, int r19, java.lang.Object... r20) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.global.a.a(android.content.Context, int, java.lang.Object[]):android.graphics.Bitmap");
    }

    public static boolean a(Context context, File file, String str) {
        if (file != null) {
            try {
                if (file.exists() && file.getName().endsWith(".apk")) {
                    String a2 = ca.a(file, bu.f5659a);
                    if (!TextUtils.isEmpty(str) && !TextUtils.equals(str.toUpperCase(), a2)) {
                        X.c("md5 error [file md5: %s] [target md5: %s]", a2, str);
                        return false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("chmod 777 ");
                    sb.append(file.getAbsolutePath());
                    Runtime.getRuntime().exec(sb.toString());
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (Build.VERSION.SDK_INT >= 24) {
                        intent.addFlags(1);
                        Class.forName("androidx.core.content.FileProvider");
                        Class[] clsArr = {Context.class, String.class, File.class};
                        Object[] objArr = new Object[3];
                        objArr[0] = context;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(com.tencent.bugly.crashreport.common.info.a.a(context).f24754g);
                        sb2.append(".fileProvider");
                        objArr[1] = sb2.toString();
                        objArr[2] = file;
                        Uri uri = (Uri) ca.a("androidx.core.content.FileProvider", "getUriForFile", null, clsArr, objArr);
                        if (uri == null) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("file location is ");
                            sb3.append(file.toString());
                            X.b(sb3.toString(), new Object[0]);
                            X.b("install failed, contentUri is null!", new Object[0]);
                            return false;
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("contentUri is ");
                        sb4.append(uri);
                        X.a(sb4.toString(), new Object[0]);
                        intent.setDataAndType(uri, AdBaseConstants.MIME_APK);
                    } else {
                        intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
                    }
                    intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    context.startActivity(intent);
                    return true;
                }
            } catch (Exception e2) {
                if (!X.a(e2)) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }

    public static boolean a(File file, String str, String str2) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String a2 = ca.a(file, str2);
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str.toUpperCase(), a2)) {
                        return true;
                    }
                    X.c("checkFileUniqueId failed [file  uniqueId %s] [target uniqueId %s]", a2, str);
                    return false;
                }
            } catch (Exception unused) {
                X.b("checkFileUniqueId exception", new Object[0]);
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006d A[Catch: IOException -> 0x0069, TRY_LEAVE, TryCatch #0 {IOException -> 0x0069, blocks: (B:57:0x0065, B:50:0x006d), top: B:56:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
            if (r3 == 0) goto L75
            r1 = 0
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r2 == 0) goto L75
            boolean r2 = r3.isDirectory()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            if (r2 == 0) goto L12
            goto L75
        L12:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L45
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r3.<init>(r4, r0)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3d
            r4 = 1048576(0x100000, float:1.469368E-39)
            byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
        L20:
            int r1 = r2.read(r4)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            if (r1 <= 0) goto L2a
            r3.write(r4, r0, r1)     // Catch: java.lang.Throwable -> L37 java.lang.Exception -> L39
            goto L20
        L2a:
            r0 = 1
            r2.close()     // Catch: java.io.IOException -> L32
            r3.close()     // Catch: java.io.IOException -> L32
            goto L5c
        L32:
            r3 = move-exception
            r3.printStackTrace()
            goto L5c
        L37:
            r4 = move-exception
            goto L5f
        L39:
            r4 = move-exception
            goto L40
        L3b:
            r3 = move-exception
            goto L61
        L3d:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L40:
            r1 = r2
            goto L48
        L42:
            r3 = move-exception
            r4 = r1
            goto L63
        L45:
            r3 = move-exception
            r4 = r3
            r3 = r1
        L48:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L53
            r1.close()     // Catch: java.io.IOException -> L51
            goto L53
        L51:
            r3 = move-exception
            goto L59
        L53:
            if (r3 == 0) goto L5c
            r3.close()     // Catch: java.io.IOException -> L51
            goto L5c
        L59:
            r3.printStackTrace()
        L5c:
            return r0
        L5d:
            r4 = move-exception
            r2 = r1
        L5f:
            r1 = r3
            r3 = r4
        L61:
            r4 = r1
            r1 = r2
        L63:
            if (r1 == 0) goto L6b
            r1.close()     // Catch: java.io.IOException -> L69
            goto L6b
        L69:
            r4 = move-exception
            goto L71
        L6b:
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L69
            goto L74
        L71:
            r4.printStackTrace()
        L74:
            throw r3
        L75:
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

    public static synchronized <T extends Parcelable> boolean a(String str, T t) {
        synchronized (a.class) {
            boolean z = false;
            if (t == null) {
                return false;
            }
            byte[] a2 = ca.a(t);
            if (a2 != null) {
                if (C0912p.f25111a.a(1002, str, a2)) {
                    z = true;
                }
            }
            return z;
        }
    }

    public static synchronized <T extends Parcelable> T a(String str, Parcelable.Creator<T> creator) {
        synchronized (a.class) {
            Map<String, byte[]> c2 = C0912p.f25111a.c();
            if (c2 == null) {
                return null;
            }
            byte[] bArr = c2.get(str);
            if (bArr != null && bArr.length > 0) {
                return (T) ca.a(bArr, creator);
            }
            return null;
        }
    }

    public static synchronized boolean a(String str) {
        boolean a2;
        synchronized (a.class) {
            a2 = C0912p.f25111a.a(str);
        }
        return a2;
    }

    public static String a(String str, String str2) {
        SharedPreferences sharedPreferences = e.f24621b.D;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public static boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences = e.f24621b.D;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
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
        } catch (Exception e2) {
            X.b(a.class, "getManifestMetaDataValue exception:" + e2.getMessage(), new Object[0]);
            return null;
        }
    }
}
