package com.shu.priory.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bm;
import com.shu.priory.config.AdKeys;
import com.shu.priory.utils.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class i {

    /* renamed from: a */
    protected Context f16922a;

    /* renamed from: b */
    private byte[] f16923b;

    /* renamed from: c */
    private final a f16924c;

    /* renamed from: d */
    private final f f16925d = new f() { // from class: com.shu.priory.d.i.1
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.d.f
        public void a(Throwable th2) {
        }

        @Override // com.shu.priory.d.f
        public void a(byte[] bArr) {
            try {
                byte[] b10 = com.shu.priory.d.a.b(bArr, i.this.f16923b);
                if (b10 != null) {
                    i.this.a(new JSONObject(new String(b10)));
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
    };

    /* renamed from: com.shu.priory.d.i$1 */
    public class AnonymousClass1 implements f {
        public AnonymousClass1() {
        }

        @Override // com.shu.priory.d.f
        public void a(Throwable th2) {
        }

        @Override // com.shu.priory.d.f
        public void a(byte[] bArr) {
            try {
                byte[] b10 = com.shu.priory.d.a.b(bArr, i.this.f16923b);
                if (b10 != null) {
                    i.this.a(new JSONObject(new String(b10)));
                }
            } catch (Throwable th2) {
                a(th2);
            }
        }
    }

    public interface a {
        void a(List<String> list, String str);
    }

    public i(Context context, a aVar) {
        this.f16922a = context;
        this.f16924c = aVar;
    }

    private void b() {
        try {
            if (d() && a(this.f16922a)) {
                e eVar = new e();
                eVar.a(1);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.umeng.analytics.pro.f.T, 2);
                jSONObject.put("pkg", this.f16922a.getPackageName());
                jSONObject.put("os_ver", Build.VERSION.SDK_INT);
                jSONObject.put(bm.f6904i, Build.MODEL);
                jSONObject.put(bm.f6905j, Build.BRAND);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("name", e());
                jSONObject.put("imei", com.shu.priory.param.c.c(this.f16922a));
                jSONObject.put(AdKeys.OAID, l.a().a(this.f16922a));
                byte[] encoded = com.shu.priory.d.a.a().getEncoded();
                this.f16923b = encoded;
                eVar.a("https://log.8zhuayu.cc/yf", null, c.a(encoded, jSONObject.toString().getBytes(), 2));
                eVar.a(this.f16925d);
            }
        } catch (Throwable unused) {
        }
    }

    private String c() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private boolean d() {
        SharedPreferences a10 = com.shu.priory.utils.e.a(this.f16922a);
        if (a10 != null) {
            return System.currentTimeMillis() - a10.getLong("yf_last_check_time", 0L) > a10.getLong("yf_update_interval", 3600000L);
        }
        return true;
    }

    private String e() {
        try {
            PackageManager packageManager = this.f16922a.getPackageManager();
            return packageManager.getPackageInfo(this.f16922a.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public void a() {
        if (b(this.f16922a)) {
            b();
        }
    }

    private boolean b(Context context) {
        try {
            if (com.shu.priory.param.c.a() == 2) {
                return true;
            }
            PackageManager packageManager = context.getPackageManager();
            if (System.currentTimeMillis() - packageManager.getPackageInfo(this.f16922a.getPackageName(), 0).firstInstallTime <= 1209600000 || packageManager.getPackageInfo("com.tencent.mm", 0) == null) {
                return false;
            }
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                return registerReceiver.getIntExtra("plugged", 0) == 0;
            }
            return true;
        } catch (Throwable unused) {
        }
        return false;
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0018, code lost:
    
        if (r4.f16922a.getPackageManager().getPackageInfo(r0, 1) != null) goto L63;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(org.json.JSONObject r5) {
        /*
            r4 = this;
            java.lang.String r0 = "w"
            java.lang.String r0 = r5.optString(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L1e
            android.content.Context r1 = r4.f16922a     // Catch: java.lang.Exception -> L1b
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L1b
            android.content.pm.PackageInfo r0 = r1.getPackageInfo(r0, r3)     // Catch: java.lang.Exception -> L1b
            if (r0 == 0) goto L1c
            goto L1e
        L1b:
        L1c:
            r0 = 0
            goto L1f
        L1e:
            r0 = 1
        L1f:
            java.lang.String r1 = "b"
            java.lang.String r5 = r5.optString(r1)
            if (r0 == 0) goto L3b
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L3b
            android.content.Context r1 = r4.f16922a     // Catch: java.lang.Exception -> L3b
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L3b
            android.content.pm.PackageInfo r5 = r1.getPackageInfo(r5, r3)     // Catch: java.lang.Exception -> L3b
            if (r5 != 0) goto L3a
            r2 = 1
        L3a:
            r0 = r2
        L3b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.d.i.b(org.json.JSONObject):boolean");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:0|1|2|3|4|5|6|(6:11|12|13|14|15|16)|20|21|22|23|24|25|(2:26|(1:28)(1:29))|30|(1:32)|34|12|13|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        r0 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        if (r0 != null) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0096, code lost:
    
        a(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0093, code lost:
    
        r0.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0087, code lost:
    
        r2 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r6, java.util.List<java.lang.String> r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L8e
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L8e
            java.net.URLConnection r6 = r1.openConnection()     // Catch: java.lang.Throwable -> L8e
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch: java.lang.Throwable -> L8e
            r1 = 20000(0x4e20, float:2.8026E-41)
            r6.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L8a
            r6.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "GET"
            r6.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "Accept"
        */
        //  java.lang.String r2 = "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*"
        /*
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "Accept-Language"
            java.lang.String r2 = "zh-CN"
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "Charset"
            java.lang.String r2 = "UTF-8"
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L8a
            java.lang.String r1 = "Connection"
            java.lang.String r2 = "Keep-Alive"
            r6.setRequestProperty(r1, r2)     // Catch: java.lang.Throwable -> L8a
            int r1 = r6.getResponseCode()     // Catch: java.lang.Throwable -> L8a
            android.content.Context r2 = r5.f16922a     // Catch: java.lang.Throwable -> L8a
            com.shu.priory.d.h r2 = com.shu.priory.d.h.a(r2)     // Catch: java.lang.Throwable -> L8a
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = r2.a()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r4 = r5.c()     // Catch: java.lang.Throwable -> L8a
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L8a
            r2 = 206(0xce, float:2.89E-43)
            if (r1 == r2) goto L57
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L55
            goto L57
        L55:
            r2 = r0
            goto L7d
        L57:
            java.io.InputStream r1 = r6.getInputStream()     // Catch: java.lang.Throwable -> L8a
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L87
            java.lang.String r4 = "rwd"
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L87
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L72
        L66:
            int r3 = r1.read(r0)     // Catch: java.lang.Throwable -> L72
            r4 = -1
            if (r3 == r4) goto L75
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L72
            goto L66
        L72:
        L73:
            r0 = r6
            goto L91
        L75:
            com.shu.priory.d.i$a r0 = r5.f16924c     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L7c
            r0.a(r7, r8)     // Catch: java.lang.Throwable -> L72
        L7c:
            r0 = r1
        L7d:
            r6.disconnect()     // Catch: java.lang.Throwable -> L80
        L80:
            a(r0)
        L83:
            a(r2)
            goto L9a
        L87:
            r2 = r0
            goto L73
        L8a:
            r1 = r0
            r2 = r1
            goto L73
        L8e:
            r1 = r0
            r2 = r1
        L91:
            if (r0 == 0) goto L96
            r0.disconnect()     // Catch: java.lang.Throwable -> L96
        L96:
            a(r1)
            goto L83
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shu.priory.d.i.a(java.lang.String, java.util.List, java.lang.String):void");
    }

    public void a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        int optInt = jSONObject.optInt("itvl", 60);
        int i10 = optInt >= 0 ? optInt : 60;
        SharedPreferences a10 = com.shu.priory.utils.e.a(this.f16922a);
        SharedPreferences.Editor edit = a10.edit();
        if (a10.getLong("yf_update_interval", 0L) != i10) {
            edit.putLong("yf_update_interval", i10 * 60000);
        }
        edit.putLong("yf_last_check_time", System.currentTimeMillis());
        edit.apply();
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        String optString2 = jSONObject.optString("dst");
        if (TextUtils.isEmpty(optString2) || (optJSONArray = jSONObject.optJSONArray("cond")) == null || optJSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
            if (optJSONObject != null && b(optJSONObject)) {
                String optString3 = optJSONObject.optString("adu");
                if (!TextUtils.isEmpty(optString3)) {
                    arrayList.add(optString3);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        a(optString, arrayList, optString2);
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        return (com.shu.priory.utils.i.a(context, com.kuaishou.weapon.p0.g.f11100a) || com.shu.priory.utils.i.a(context, com.kuaishou.weapon.p0.g.f11101b)) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable();
    }
}
