package mj;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import bh.b;
import com.kuaishou.weapon.p0.bi;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a */
    public static final List<String> f28714a;

    /* renamed from: b */
    public static final Set<String> f28715b;

    static {
        ArrayList arrayList = new ArrayList(5);
        f28714a = arrayList;
        HashSet hashSet = new HashSet(1);
        f28715b = hashSet;
        arrayList.add("com.tencent.mm");
        arrayList.add(p3.k.f29761b);
        arrayList.add("com.xunmeng.pinduoduo");
        arrayList.add("com.taobao.taobao");
        arrayList.add("com.baidu.searchbox");
        arrayList.add("com.tencent.mobileqq");
        arrayList.add("com.tencent.mtt");
        arrayList.add("com.ss.android.ugc.aweme");
        arrayList.add("com.snda.wifilocating");
        arrayList.add("com.autonavi.minimap");
        arrayList.add("com.smile.gifmaker");
        arrayList.add("com.tencent.qqlive");
        arrayList.add("com.sankuai.meituan");
        arrayList.add("com.jingdong.app.mall");
        arrayList.add("com.qiyi.video");
        arrayList.add("com.bytedance.ad.deliver");
        arrayList.add("com.bytedance.ad.videotool");
        arrayList.add("com.ss.android.lark");
        arrayList.add("com.taou.maimai");
        arrayList.add("com.kwad.demo");
        arrayList.add("com.union_test.toutiao");
        arrayList.add("com.qq.e.union.demo");
        hashSet.add("android.permission.QUERY_ALL_PACKAGES");
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [java.util.HashSet, java.util.Set<java.lang.String>] */
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (f28715b.contains(str)) {
                    arrayList.add(str);
                }
            }
            arrayList2.addAll(f28715b);
            arrayList2.removeAll(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = ((String) it.next()).split("\\.");
                jSONObject.put(split[split.length - 1], 1);
            }
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                String[] split2 = ((String) it2.next()).split("\\.");
                jSONObject.put(split2[split2.length - 1], 0);
            }
        } catch (PackageManager.NameNotFoundException e10) {
            e = e10;
            e.printStackTrace();
            return jSONObject;
        } catch (JSONException e11) {
            e = e11;
            e.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public static boolean b() {
        String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i10 = 0; i10 < 8; i10++) {
            if (new File(strArr[i10]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static String c(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        int parseInt = Integer.parseInt(property2);
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        return property + ":" + parseInt;
    }

    public static boolean d() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            String str = "";
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp()) {
                    str = networkInterface.getName();
                }
                b.a.f1608a.f("try", "IFACE NAME: " + str);
                if (str.contains("tun") || str.contains("ppp") || str.contains("pptp")) {
                    return true;
                }
            }
            return false;
        } catch (SocketException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:(2:11|12)|(2:13|14)|(21:19|20|21|22|(4:26|(2:30|31)|33|31)|34|35|36|37|(1:39)(1:70)|40|41|42|43|(6:45|46|(1:48)(2:53|(2:54|(2:56|(1:64)(2:61|62))(1:66)))|49|50|51)|67|46|(0)(0)|49|50|51)|77|20|21|22|(5:24|26|(2:30|31)|33|31)|34|35|36|37|(0)(0)|40|41|42|43|(0)|67|46|(0)(0)|49|50|51) */
    /* JADX WARN: Can't wrap try/catch for region: R(26:11|12|13|14|(21:19|20|21|22|(4:26|(2:30|31)|33|31)|34|35|36|37|(1:39)(1:70)|40|41|42|43|(6:45|46|(1:48)(2:53|(2:54|(2:56|(1:64)(2:61|62))(1:66)))|49|50|51)|67|46|(0)(0)|49|50|51)|77|20|21|22|(5:24|26|(2:30|31)|33|31)|34|35|36|37|(0)(0)|40|41|42|43|(0)|67|46|(0)(0)|49|50|51) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00db, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e0, code lost:
    
        if (yk.b.a() != false) goto L252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00e2, code lost:
    
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017c A[Catch: all -> 0x0048, Exception -> 0x0072, TryCatch #2 {, blocks: (B:4:0x0003, B:88:0x0015, B:90:0x002b, B:92:0x0031, B:12:0x0051, B:14:0x0056, B:16:0x0069, B:20:0x0076, B:22:0x00ae, B:24:0x00b8, B:26:0x00c0, B:31:0x00d7, B:36:0x00e7, B:37:0x00ec, B:70:0x00f2, B:40:0x0103, B:42:0x0145, B:46:0x0152, B:49:0x019b, B:53:0x017c, B:54:0x0180, B:56:0x0186, B:59:0x0194, B:74:0x00dc, B:76:0x00e2, B:81:0x01c3, B:83:0x01c9), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00f2 A[Catch: all -> 0x0048, Exception -> 0x0072, TryCatch #2 {, blocks: (B:4:0x0003, B:88:0x0015, B:90:0x002b, B:92:0x0031, B:12:0x0051, B:14:0x0056, B:16:0x0069, B:20:0x0076, B:22:0x00ae, B:24:0x00b8, B:26:0x00c0, B:31:0x00d7, B:36:0x00e7, B:37:0x00ec, B:70:0x00f2, B:40:0x0103, B:42:0x0145, B:46:0x0152, B:49:0x019b, B:53:0x017c, B:54:0x0180, B:56:0x0186, B:59:0x0194, B:74:0x00dc, B:76:0x00e2, B:81:0x01c3, B:83:0x01c9), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x004f A[DONT_GENERATE] */
    @android.annotation.SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized org.json.JSONObject e(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 465
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mj.k.e(android.content.Context):org.json.JSONObject");
    }

    public static boolean f() {
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"which", bi.f10829y});
        } catch (Throwable unused) {
            process = null;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            process.destroy();
            return readLine != null;
        } catch (Throwable unused2) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static boolean g(Context context) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        boolean z10 = intent.resolveActivity(context.getPackageManager()) != null;
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.toLowerCase().contains("vbox") && !str.toLowerCase().contains("test-keys")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.SERIAL.equalsIgnoreCase("android") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT) && !((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName().toLowerCase().equals("android") && z10)) {
                return false;
            }
        }
        return true;
    }
}
