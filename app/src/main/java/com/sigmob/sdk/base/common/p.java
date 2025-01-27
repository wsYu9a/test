package com.sigmob.sdk.base.common;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.network.Networking;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.Md5Util;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import com.sigmob.sdk.base.mta.PointEntitySigmobError;
import com.sigmob.windad.WindAds;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes4.dex */
public class p {

    /* renamed from: a */
    public static Map<String, String> f18001a = new Hashtable();

    /* renamed from: b */
    public static Set<h> f18002b = new CopyOnWriteArraySet();

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18003a;

        /* renamed from: b */
        public final /* synthetic */ File f18004b;

        public a(String str, File file) {
            this.f18003a = str;
            this.f18004b = file;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(this.f18003a);
                HashMap hashMap = new HashMap();
                hashMap.put("apkfile", this.f18004b.getAbsolutePath());
                hashMap.put("apkurl", this.f18003a);
                pointEntitySigmob.setOptions(hashMap);
            }
        }
    }

    public class b implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18005a;

        /* renamed from: b */
        public final /* synthetic */ File f18006b;

        public b(String str, File file) {
            this.f18005a = str;
            this.f18006b = file;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                PointEntitySigmob pointEntitySigmob = (PointEntitySigmob) obj;
                pointEntitySigmob.setFinal_url(this.f18005a);
                HashMap hashMap = new HashMap();
                hashMap.put("apkfile", this.f18006b.getAbsolutePath());
                hashMap.put("apkurl", this.f18005a);
                pointEntitySigmob.setOptions(hashMap);
            }
        }
    }

    public class c implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18007a;

        public c(String str) {
            this.f18007a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(this.f18007a);
            }
        }
    }

    public class d implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18008a;

        public d(String str) {
            this.f18008a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(this.f18008a);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f18009a;

        /* renamed from: b */
        public final /* synthetic */ File f18010b;

        /* renamed from: c */
        public final /* synthetic */ BaseAdUnit f18011c;

        public e(Context context, File file, BaseAdUnit baseAdUnit) {
            this.f18009a = context;
            this.f18010b = file;
            this.f18011c = baseAdUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            p.a(this.f18009a, this.f18010b.getAbsolutePath(), this.f18011c);
        }
    }

    public class f implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18012a;

        public f(String str) {
            this.f18012a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setFinal_url(this.f18012a);
            }
        }
    }

    public class g implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ String f18013a;

        public g(String str) {
            this.f18013a = str;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmobError) {
                ((PointEntitySigmobError) obj).setFinal_url(this.f18013a);
            }
        }
    }

    public static class h {

        /* renamed from: a */
        public String f18014a;

        /* renamed from: b */
        public String f18015b;

        /* renamed from: c */
        public long f18016c;

        public h(String str, String str2, long j10) {
            this.f18014a = str;
            this.f18015b = str2;
            this.f18016c = j10;
        }

        public long a() {
            return this.f18016c;
        }

        public String b() {
            return this.f18015b;
        }

        public String c() {
            return this.f18014a;
        }
    }

    public static void a(Context context, BaseAdUnit baseAdUnit, String str, File file) {
        if (baseAdUnit.isRecord()) {
            b0.a("download_start", "1", baseAdUnit, new a(str, file));
        }
        HashMap hashMap = new HashMap();
        hashMap.put(p3.i.f29758c, "1");
        hashMap.put("downloadId", baseAdUnit.getDownloadId());
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
    }

    public static HashMap<String, Object> b() {
        Cursor cursor;
        try {
            DownloadManager a10 = a();
            if (a10 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterByStatus(3);
                cursor = a10.query(query);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        cursor.close();
                        return null;
                    }
                    HashMap<String, Object> hashMap = new HashMap<>();
                    do {
                        Long valueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndexOrThrow("_id")));
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(string, valueOf);
                        }
                    } while (cursor.moveToNext());
                    cursor.close();
                    return hashMap;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        SigmobLog.e(th.getMessage());
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return null;
    }

    public static void c(long j10, String str) {
        for (h hVar : f18002b) {
            if (hVar.f18016c == j10 || hVar.f18014a.equalsIgnoreCase(str)) {
                f18002b.remove(hVar);
                return;
            }
        }
    }

    public static boolean a(long j10, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        f18002b.add(new h(str, null, j10));
        return true;
    }

    public static Long b(long j10, String str) {
        for (h hVar : f18002b) {
            if (hVar.f18016c == j10 || hVar.f18014a.equalsIgnoreCase(str)) {
                return Long.valueOf(hVar.f18016c);
            }
        }
        return null;
    }

    public static void a(String str, String str2, BaseAdUnit baseAdUnit) {
        StringBuilder sb2;
        Context d10 = com.sigmob.sdk.a.d();
        try {
            String str3 = TextUtils.isEmpty(str) ? Md5Util.md5(baseAdUnit.getLanding_page()) + ".apk" : str;
            File file = new File(com.sigmob.sdk.base.utils.d.a(d10), str3);
            Long b10 = b(-1L, file.getAbsolutePath());
            if (b10 != null && b10.longValue() > 0) {
                try {
                    g0.makeText(d10, "正在下载", 1).show();
                    if (baseAdUnit.getDownloadId() == null) {
                        baseAdUnit.setDownloadId(b10);
                        File file2 = new File(com.sigmob.sdk.base.utils.d.f(), b10 + ".log");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        FileUtil.writeToCache(baseAdUnit, file2.getAbsolutePath());
                        a(d10, baseAdUnit, str2, file);
                        return;
                    }
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            HashMap<String, Object> b11 = b();
            if (b11 != null) {
                for (String str4 : b11.keySet()) {
                    if (!TextUtils.isEmpty(str4) && str4.equals(file.getAbsolutePath())) {
                        try {
                            g0.makeText(d10, "正在下载", 1).show();
                        } catch (Throwable unused2) {
                        }
                        try {
                            Object obj = b11.get(str4);
                            if (obj instanceof Long) {
                                baseAdUnit.setDownloadId((Long) obj);
                                File file3 = new File(com.sigmob.sdk.base.utils.d.f(), b10 + ".log");
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                FileUtil.writeToCache(baseAdUnit, file3.getAbsolutePath());
                                a(d10, baseAdUnit, str2, file);
                                return;
                            }
                            return;
                        } catch (Throwable unused3) {
                            return;
                        }
                    }
                }
            }
            boolean containsKey = f18001a.containsKey(baseAdUnit.getUuid());
            if (file.exists() && !containsKey && !a(d10, file.getAbsolutePath())) {
                SigmobLog.i("cacheFile deleteFile:" + FileUtil.deleteFile(file.getAbsolutePath()));
            }
            SigmobLog.i(str3 + " exists:" + file.exists() + " containsKey:" + containsKey);
            if (file.exists()) {
                if (containsKey) {
                    a(d10, file.getAbsolutePath(), baseAdUnit);
                    return;
                }
                long lastModified = file.lastModified();
                if (com.sigmob.sdk.base.l.w().l() == 0) {
                    boolean deleteFile = FileUtil.deleteFile(file.getAbsolutePath());
                    sb2 = new StringBuilder();
                    sb2.append("default deleteFile:");
                    sb2.append(deleteFile);
                } else {
                    if (System.currentTimeMillis() - lastModified <= r13 * 1000) {
                        a(d10, file.getAbsolutePath(), baseAdUnit);
                        return;
                    }
                    boolean deleteFile2 = FileUtil.deleteFile(file.getAbsolutePath());
                    sb2 = new StringBuilder();
                    sb2.append("timeOut deleteFile:");
                    sb2.append(deleteFile2);
                }
                SigmobLog.i(sb2.toString());
            }
            f18001a.put(baseAdUnit.getUuid(), str3);
            String appName = baseAdUnit.getAppName();
            if (TextUtils.isEmpty(appName)) {
                appName = file.getName();
            }
            long a10 = a(str2, file.getAbsolutePath(), appName);
            if (a10 >= 0) {
                try {
                    g0.makeText(d10, "已开始下载，可在通知栏尝试取消", 1).show();
                } catch (Throwable th2) {
                    SigmobLog.e(th2.getMessage());
                }
                a(a10, file.getAbsolutePath());
                File file4 = new File(com.sigmob.sdk.base.utils.d.f(), a10 + ".log");
                baseAdUnit.setDownloadId(Long.valueOf(a10));
                FileUtil.writeToCache(baseAdUnit, file4.getAbsolutePath());
                a(d10, baseAdUnit, str2, file);
            } else {
                if (baseAdUnit.isRecord()) {
                    b0.a("download_start", "0", baseAdUnit, new b(str2, file));
                    b0.a(PointCategory.DOWNLOAD_FAILED, (int) a10, "下载失败,错误码 " + a10, baseAdUnit);
                }
                g0.makeText(d10, "下载失败,错误码 " + a10, 0).show();
                HashMap hashMap = new HashMap();
                hashMap.put(p3.i.f29758c, "0");
                hashMap.put("downloadId", -1);
                BaseBroadcastReceiver.a(d10, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            }
            if (baseAdUnit.isRecord()) {
                com.sigmob.sdk.base.network.f.a(baseAdUnit, "download_start");
            }
        } catch (Throwable th3) {
            SigmobLog.e(th3.getMessage());
            if (baseAdUnit.isRecord()) {
                b0.a("download_start", "0", baseAdUnit, new c(str2));
                b0.a("download_start", 0, th3.getMessage(), baseAdUnit, new d(str2));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(p3.i.f29758c, "0");
            hashMap2.put("downloadId", -1);
            BaseBroadcastReceiver.a(d10, baseAdUnit.getUuid(), hashMap2, IntentActions.ACTION_INTERSTITIAL_DOWNLOAD_START);
            try {
                g0.makeText(d10, "请先给予应用权限", 1).show();
            } catch (Throwable unused4) {
            }
        }
    }

    public static boolean b(File file) {
        return (file == null || !file.exists() || ClientMetadata.getPackageInfoWithUri(com.sigmob.sdk.a.d(), file.getAbsolutePath()) == null) ? false : true;
    }

    public static long a(String str, String str2, String str3) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    String trim = str.trim();
                    if (TextUtils.isEmpty(Uri.parse(trim).getScheme())) {
                        trim = "http://" + trim;
                    }
                    if (!trim.startsWith("http")) {
                        return -2L;
                    }
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(trim));
                    File file = new File(str2);
                    request.setTitle(str3);
                    request.setAllowedNetworkTypes(3);
                    request.setAllowedOverRoaming(true);
                    request.setVisibleInDownloadsUi(true);
                    request.setNotificationVisibility(1);
                    File parentFile = file.getParentFile();
                    if (parentFile.exists()) {
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            if (!parentFile.mkdirs()) {
                                return -3L;
                            }
                        }
                    } else if (!parentFile.mkdirs()) {
                        return -4L;
                    }
                    request.addRequestHeader("User-Agent", Networking.getUserAgent());
                    request.setDestinationUri(Uri.fromFile(file));
                    return a().enqueue(request);
                }
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
            }
        }
        return -1L;
    }

    public static void a(String str, BaseAdUnit baseAdUnit) {
        String str2;
        Context d10 = com.sigmob.sdk.a.d();
        try {
            b0.a(PointCategory.APK_CLICK, "download", baseAdUnit);
            SigmobLog.i("download apk:" + str);
            com.sigmob.sdk.base.common.h.a(baseAdUnit);
            String apkMd5 = baseAdUnit.getApkMd5();
            if (TextUtils.isEmpty(apkMd5)) {
                str2 = Md5Util.md5(str) + ".apk";
            } else {
                str2 = apkMd5 + ".apk";
                File file = new File(com.sigmob.sdk.base.utils.d.a(d10.getApplicationContext()), str2);
                boolean exists = file.exists();
                boolean d11 = baseAdUnit.getApkDownloadType() != 0 ? com.sigmob.sdk.downloader.l.d(str, com.sigmob.sdk.base.utils.d.a(d10.getApplicationContext()).getAbsolutePath(), str2) : true;
                if (exists && d11 && baseAdUnit.canUseDownloadApk() && b(file)) {
                    baseAdUnit.setApkName(str2);
                    if (baseAdUnit.getDownloadId() == null) {
                        b0.b(PointCategory.EXIT_APK_INSTALL, "", baseAdUnit);
                    }
                    WindAds.sharedAds().getHandler().post(new e(d10, file, baseAdUnit));
                    return;
                }
            }
            baseAdUnit.setApkName(str2);
            baseAdUnit.setDownloadUrl(str);
            int apkDownloadType = baseAdUnit.getApkDownloadType();
            if (apkDownloadType == 0) {
                a(str2, str, baseAdUnit);
                return;
            }
            if (apkDownloadType == 1) {
                n.a(str, baseAdUnit, false);
                return;
            }
            if (apkDownloadType == 2) {
                n.a(str, baseAdUnit, true);
                return;
            }
            SigmobLog.e("not support Download Type: " + apkDownloadType);
            throw new Exception("not support Download Type: " + apkDownloadType);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            if (baseAdUnit.isRecord()) {
                b0.a("download_start", "0", baseAdUnit, new f(str));
                b0.a("download_start", 0, th2.getMessage(), baseAdUnit, new g(str));
            }
            try {
                g0.makeText(d10, "下载失败", 1).show();
            } catch (Throwable th3) {
                SigmobLog.e(th3.getMessage());
            }
        }
    }

    public static long[] a(Context context, Long l10) {
        long[] jArr = {-1, -1, 0};
        if (l10 == null || l10.longValue() < 0) {
            return jArr;
        }
        Cursor cursor = null;
        try {
            cursor = ((DownloadManager) context.getSystemService("download")).query(new DownloadManager.Query().setFilterById(l10.longValue()));
            if (cursor != null && cursor.moveToFirst()) {
                jArr[0] = cursor.getInt(cursor.getColumnIndexOrThrow("bytes_so_far"));
                jArr[1] = cursor.getInt(cursor.getColumnIndexOrThrow("total_size"));
                jArr[2] = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
            }
            return jArr;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public static Map<String, Object> a(long j10) {
        Cursor cursor;
        try {
            DownloadManager a10 = a();
            if (a10 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(j10);
                Uri uriForDownloadedFile = a10.getUriForDownloadedFile(j10);
                cursor = a10.query(query);
                try {
                    if (!cursor.moveToFirst()) {
                        cursor.close();
                        cursor.close();
                        return null;
                    }
                    int i10 = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                    int i11 = cursor.getInt(cursor.getColumnIndexOrThrow(MediationConstant.KEY_REASON));
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("local_uri"));
                    HashMap hashMap = new HashMap();
                    hashMap.put(TTDownloadField.TT_FILE_NAME, string);
                    hashMap.put("status", Integer.valueOf(i10));
                    hashMap.put("uri", uriForDownloadedFile);
                    hashMap.put(MediationConstant.KEY_REASON, Integer.valueOf(i11));
                    cursor.close();
                    return hashMap;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        SigmobLog.e(th.getMessage());
                        return null;
                    } finally {
                        if (cursor != null) {
                            cursor.close();
                        }
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
        return null;
    }

    public static DownloadManager a() {
        Context d10 = com.sigmob.sdk.a.d();
        if (d10 != null) {
            return (DownloadManager) d10.getSystemService("download");
        }
        return null;
    }

    public static String a(File file) {
        String name = file.getName();
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(name.substring(name.lastIndexOf(p1.b.f29697h) + 1, name.length()).toLowerCase());
    }

    public static String a(List<String> list, String str) {
        String str2;
        String str3;
        StringBuilder sb2;
        if (!list.contains(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(p1.b.f29697h);
        if (lastIndexOf != -1) {
            str2 = str.substring(0, lastIndexOf);
            str3 = str.substring(lastIndexOf);
        } else {
            str2 = "";
            str3 = "";
        }
        int lastIndexOf2 = str2.lastIndexOf("(");
        if (lastIndexOf2 == -1) {
            sb2 = new StringBuilder();
        } else {
            int indexOf = str2.indexOf(")", lastIndexOf2);
            if (indexOf == -1) {
                sb2 = new StringBuilder();
            } else if (indexOf < str2.length() - 1) {
                sb2 = new StringBuilder();
            } else {
                try {
                    return a(list, str2.substring(0, lastIndexOf2) + "(" + Integer.valueOf(Integer.parseInt(str2.substring(lastIndexOf2 + 1, indexOf)) + 1) + ")" + str3);
                } catch (Throwable unused) {
                    sb2 = new StringBuilder();
                }
            }
        }
        sb2.append(str2);
        sb2.append("(1)");
        sb2.append(str3);
        return a(list, sb2.toString());
    }

    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 1) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context, String str, BaseAdUnit baseAdUnit) {
        PackageInfo packageInfoWithUri;
        File file = new File(str);
        SigmobLog.i("installAPK:" + file.getAbsolutePath() + ":" + file.exists());
        Intent intent = new Intent();
        intent.addFlags(268468224);
        intent.setAction("android.intent.action.VIEW");
        try {
            g0.makeText(context, "开始安装", 1).show();
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        if (Build.VERSION.SDK_INT < 24 || context.getApplicationInfo().targetSdkVersion < 24) {
            intent.setDataAndType(Uri.fromFile(file), a(file));
            packageInfoWithUri = ClientMetadata.getPackageInfoWithUri(context, str);
        } else {
            try {
                Uri uriForFile = FileProvider.getUriForFile(com.sigmob.sdk.a.d(), com.sigmob.sdk.a.d().getPackageName() + ".sigprovider", file);
                if (uriForFile != null) {
                    intent.addFlags(1);
                    intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
                }
                packageInfoWithUri = ClientMetadata.getPackageInfoWithUri(context, str);
            } catch (Exception e10) {
                SigmobLog.e(e10.getMessage());
                b0.a(PointCategory.APP_INSTALL_START, 0, e10.getMessage(), baseAdUnit, (b0.g) null);
                packageInfoWithUri = null;
            }
        }
        if (packageInfoWithUri != null) {
            File file2 = new File(com.sigmob.sdk.base.utils.d.f(), packageInfoWithUri.packageName + ".log");
            try {
                FileUtil.writeToCache(baseAdUnit, file2.getAbsolutePath());
                context.startActivity(intent);
                com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.I);
                HashMap hashMap = new HashMap();
                hashMap.put(p3.i.f29758c, "1");
                BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
                if (baseAdUnit.isRecord()) {
                    b0.a(baseAdUnit, PointCategory.APP_INSTALL_START, packageInfoWithUri, "1");
                    return;
                }
                return;
            } catch (Throwable th3) {
                if (file2.exists()) {
                    file2.delete();
                }
                b0.a(PointCategory.APP_INSTALL_START, 0, th3.getMessage(), baseAdUnit, (b0.g) null);
                SigmobLog.e("install apk fail", th3);
            }
        }
        FileUtil.deleteFile(str);
        com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.I);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(p3.i.f29758c, "0");
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap2, IntentActions.ACTION_INTERSTITIAL_INSTALL_START);
        if (baseAdUnit.isRecord()) {
            b0.a(baseAdUnit, PointCategory.APP_INSTALL_START, packageInfoWithUri, "0");
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Cursor cursor = null;
        try {
            DownloadManager a10 = a();
            if (a10 != null) {
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterByStatus(3);
                Cursor query2 = a10.query(query);
                if (!query2.moveToFirst()) {
                    query2.close();
                    query2.close();
                    return false;
                }
                new ArrayList();
                do {
                    String string = query2.getString(query2.getColumnIndexOrThrow("uri"));
                    if (!TextUtils.isEmpty(string) && str.equalsIgnoreCase(string)) {
                        query2.close();
                        return true;
                    }
                } while (query2.moveToNext());
                query2.close();
                return false;
            }
        } catch (Throwable th2) {
            try {
                SigmobLog.e(th2.getMessage());
            } finally {
                if (0 != 0) {
                    cursor.close();
                }
            }
        }
        return false;
    }
}
