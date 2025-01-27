package p3;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import b3.a;
import com.alipay.sdk.app.EnvUtils;
import com.kwad.components.offline.api.IOfflineCompo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    public static final String f29760a = "com.alipay.android.app";

    /* renamed from: b */
    public static final String f29761b = "com.eg.android.AlipayGphone";

    /* renamed from: c */
    public static final String f29762c = "hk.alipay.wallet";

    /* renamed from: d */
    public static final String f29763d = "hk.alipay.walletRC";

    /* renamed from: e */
    public static final String f29764e = "com.eg.android.AlipayGphoneRC";

    /* renamed from: f */
    public static final int f29765f = 99;

    /* renamed from: h */
    public static final int f29767h = 125;

    /* renamed from: i */
    public static final int f29768i = 460;

    /* renamed from: g */
    public static final String[] f29766g = {"10.1.5.1013151", "10.1.5.1013148"};

    /* renamed from: j */
    public static final char[] f29769j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '+', '/'};

    public static class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Activity f29770b;

        public a(Activity activity) {
            this.f29770b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29770b.finish();
        }
    }

    public static class b implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Runnable f29771b;

        /* renamed from: c */
        public final /* synthetic */ ConditionVariable f29772c;

        public b(Runnable runnable, ConditionVariable conditionVariable) {
            this.f29771b = runnable;
            this.f29772c = conditionVariable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f29771b.run();
            } finally {
                this.f29772c.open();
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public final PackageInfo f29773a;

        /* renamed from: b */
        public final int f29774b;

        /* renamed from: c */
        public final String f29775c;

        public c(PackageInfo packageInfo, int i10, String str) {
            this.f29773a = packageInfo;
            this.f29774b = i10;
            this.f29775c = str;
        }

        public boolean a() {
            return this.f29773a.versionCode < this.f29774b;
        }

        public boolean b(n3.a aVar) {
            Signature[] signatureArr = this.f29773a.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                return false;
            }
            for (Signature signature : signatureArr) {
                String n10 = k.n(aVar, signature.toByteArray());
                if (n10 != null && !TextUtils.equals(n10, this.f29775c)) {
                    x2.a.i(aVar, x2.b.f31789l, x2.b.D, String.format("Got %s, expected %s", n10, this.f29775c));
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean A(n3.a aVar, String str) {
        try {
            String host = new URL(str).getHost();
            if (host.endsWith(z2.a.B)) {
                return true;
            }
            return host.endsWith(z2.a.C);
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, "ckUrlErr", th2);
            return false;
        }
    }

    public static boolean B(n3.a aVar, String str, Activity activity) {
        int parseInt;
        String substring;
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (activity == null) {
            return false;
        }
        if (str.toLowerCase().startsWith(z2.a.f33603n.toLowerCase()) || str.toLowerCase().startsWith(z2.a.f33604o.toLowerCase())) {
            try {
                c t10 = t(aVar, activity, v2.a.f31216d);
                if (t10 != null && !t10.a() && !t10.b(aVar)) {
                    if (str.startsWith("intent://platformapi/startapp")) {
                        str = str.replaceFirst("intent://platformapi/startapp\\?", z2.a.f33603n);
                    }
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                }
            } catch (Throwable unused) {
            }
            return true;
        }
        if (TextUtils.equals(str, z2.a.f33606q) || TextUtils.equals(str, h("http", z2.a.f33608s))) {
            v2.b.c(v2.b.a());
            activity.finish();
            return true;
        }
        if (!str.startsWith(z2.a.f33605p)) {
            return false;
        }
        try {
            String substring2 = str.substring(str.indexOf(z2.a.f33605p) + 24);
            parseInt = Integer.parseInt(substring2.substring(substring2.lastIndexOf(z2.a.f33609t) + 10));
        } catch (Exception unused2) {
            v2.b.c(v2.b.h());
        }
        if (parseInt != com.alipay.sdk.m.j.c.SUCCEEDED.b() && parseInt != com.alipay.sdk.m.j.c.PAY_WAITTING.b()) {
            com.alipay.sdk.m.j.c b10 = com.alipay.sdk.m.j.c.b(com.alipay.sdk.m.j.c.FAILED.b());
            v2.b.c(v2.b.b(b10.b(), b10.a(), ""));
            activity.runOnUiThread(new a(activity));
            return true;
        }
        if (z2.a.f33613x) {
            StringBuilder sb2 = new StringBuilder();
            String decode = URLDecoder.decode(str);
            String decode2 = URLDecoder.decode(decode);
            String str2 = decode2.substring(decode2.indexOf(z2.a.f33605p) + 24, decode2.lastIndexOf(z2.a.f33609t)).split(z2.a.f33611v)[0];
            int indexOf = decode.indexOf(z2.a.f33611v) + 12;
            sb2.append(str2);
            sb2.append(z2.a.f33611v);
            sb2.append(decode.substring(indexOf, decode.indexOf("&", indexOf)));
            sb2.append(decode.substring(decode.indexOf("&", indexOf)));
            substring = sb2.toString();
        } else {
            String decode3 = URLDecoder.decode(str);
            substring = decode3.substring(decode3.indexOf(z2.a.f33605p) + 24, decode3.lastIndexOf(z2.a.f33609t));
        }
        com.alipay.sdk.m.j.c b11 = com.alipay.sdk.m.j.c.b(parseInt);
        v2.b.c(v2.b.b(b11.b(), b11.a(), substring));
        activity.runOnUiThread(new a(activity));
        return true;
    }

    public static int C(int i10) {
        return i10 / 100000;
    }

    public static String D() {
        if (EnvUtils.d()) {
            return TextUtils.equals("hk.alipay.wallet", v2.a.f31216d.get(0).f1164a) ? f29763d : f29764e;
        }
        try {
            return v2.a.f31216d.get(0).f1164a;
        } catch (Throwable unused) {
            return f29761b;
        }
    }

    public static String E(Context context) {
        return "-1;-1";
    }

    public static String F(String str, String str2) {
        String string = Settings.Secure.getString(((Application) n3.b.e().c()).getContentResolver(), str);
        return string != null ? string : str2;
    }

    public static String G(n3.a aVar, Context context) {
        return m(aVar, context, context.getPackageName());
    }

    public static Map<String, String> H(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            if (-1 != indexOf) {
                hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
            }
        }
        return hashMap;
    }

    public static Map<String, String> I(n3.a aVar, String str) {
        HashMap hashMap = new HashMap(4);
        int indexOf = str.indexOf(63);
        if (indexOf != -1 && indexOf < str.length() - 1) {
            for (String str2 : str.substring(indexOf + 1).split("&")) {
                int indexOf2 = str2.indexOf(61, 1);
                if (indexOf2 != -1 && indexOf2 < str2.length() - 1) {
                    hashMap.put(str2.substring(0, indexOf2), V(aVar, str2.substring(indexOf2 + 1)));
                }
            }
        }
        return hashMap;
    }

    public static boolean J(n3.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f28767g)) {
            return false;
        }
        return aVar.f28767g.toLowerCase().contains(x2.b.f31793n);
    }

    public static int K() {
        try {
            String lowerCase = Build.BRAND.toLowerCase();
            String lowerCase2 = Build.MANUFACTURER.toLowerCase();
            if (x("huawei", lowerCase, lowerCase2)) {
                return 1;
            }
            if (x("oppo", lowerCase, lowerCase2)) {
                return 2;
            }
            if (x(ke.e.f27807e, lowerCase, lowerCase2)) {
                return 4;
            }
            if (x("lenovo", lowerCase, lowerCase2)) {
                return 8;
            }
            if (x("xiaomi", lowerCase, lowerCase2)) {
                return 16;
            }
            return x("oneplus", lowerCase, lowerCase2) ? 32 : 0;
        } catch (Exception unused) {
            return 61440;
        }
    }

    public static String L(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String M(String str) {
        return (EnvUtils.d() && TextUtils.equals(str, f29764e)) ? "com.eg.android.AlipayGphoneRC.IAlixPay" : "com.eg.android.AlipayGphone.IAlixPay";
    }

    public static String N(n3.a aVar, String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(null, str);
        } catch (Exception e10) {
            x2.a.i(aVar, x2.b.f31789l, "rflex", e10.getClass().getSimpleName());
            return null;
        }
    }

    public static int O(String str) {
        for (int i10 = 0; i10 < 64; i10++) {
            if (str.equals(String.valueOf(f29769j[i10]))) {
                return i10;
            }
        }
        return 0;
    }

    public static DisplayMetrics P(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String Q() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/version"), 256);
            try {
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                Matcher matcher = Pattern.compile("\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)").matcher(readLine);
                if (!matcher.matches() || matcher.groupCount() < 4) {
                    return "Unavailable";
                }
                return matcher.group(1) + "\n" + matcher.group(2) + " " + matcher.group(3) + "\n" + matcher.group(4);
            } catch (Throwable th2) {
                bufferedReader.close();
                throw th2;
            }
        } catch (IOException unused) {
            return "Unavailable";
        }
    }

    public static boolean R(n3.a aVar, String str) {
        try {
            int S = S(str);
            x2.a.d(aVar, x2.b.f31789l, "bindExt", "" + S);
            return b3.a.J().w() && (S & 2) == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int S(String str) {
        try {
            String r10 = b3.a.J().r();
            if (TextUtils.isEmpty(r10)) {
                return 0;
            }
            return (F(r10, "").contains(str) ? 2 : 0) | 1;
        } catch (Throwable unused) {
            return 61440;
        }
    }

    public static String T() {
        String Q = Q();
        int indexOf = Q.indexOf("-");
        if (indexOf != -1) {
            Q = Q.substring(0, indexOf);
        }
        int indexOf2 = Q.indexOf("\n");
        if (indexOf2 != -1) {
            Q = Q.substring(0, indexOf2);
        }
        return "Linux " + Q;
    }

    public static String U(Context context) {
        String b10 = j.b(context);
        return b10.substring(0, b10.indexOf("://"));
    }

    public static String V(n3.a aVar, String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e10) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.B, e10);
            return "";
        }
    }

    public static String W() {
        return "Android " + Build.VERSION.RELEASE;
    }

    public static String X(Context context) {
        DisplayMetrics P = P(context);
        return P.widthPixels + m5.h.f28447r + P.heightPixels;
    }

    public static boolean Y(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipaydev|alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static int Z() {
        try {
            return Process.myUid();
        } catch (Throwable th2) {
            d.e(th2);
            return IOfflineCompo.Priority.HIGHEST;
        }
    }

    public static int a() {
        String d10 = n3.b.e().d();
        if (TextUtils.isEmpty(d10)) {
            return -1;
        }
        String replaceAll = d10.replaceAll("=", "");
        if (replaceAll.length() >= 5) {
            replaceAll = replaceAll.substring(0, 5);
        }
        int b10 = (int) (b(replaceAll) % 10000);
        return b10 < 0 ? b10 * (-1) : b10;
    }

    public static String a0(Context context) {
        return " (" + W() + ";" + T() + ";" + L(context) + ";;" + X(context) + ")(sdk android)";
    }

    public static long b(String str) {
        return c(str, 6);
    }

    public static String b0(String str) {
        return j(str, true);
    }

    public static long c(String str, int i10) {
        int pow = (int) Math.pow(2.0d, i10);
        int length = str.length();
        long j10 = 0;
        int i11 = length;
        for (int i12 = 0; i12 < length; i12++) {
            j10 += Integer.parseInt(String.valueOf(O(str.substring(i12, r5)))) * ((long) Math.pow(pow, i11 - 1));
            i11--;
        }
        return j10;
    }

    public static JSONObject c0(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return new JSONObject();
        }
    }

    public static ActivityInfo d(Context context) {
        try {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                    if (TextUtils.equals(activityInfo.name, activity.getClass().getName())) {
                        return activityInfo;
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            d.e(th2);
            return null;
        }
    }

    public static boolean d0() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static PackageInfo e(Context context, String str) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    public static boolean e0(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f29760a, 128) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static <T> T f(WeakReference<T> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public static String f0(String str) {
        try {
            Uri parse = Uri.parse(str);
            return String.format("%s%s", parse.getAuthority(), parse.getPath());
        } catch (Throwable th2) {
            d.e(th2);
            return "-";
        }
    }

    public static String g(int i10) {
        Random random = new Random();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 65.0d)));
            } else if (nextInt == 1) {
                sb2.append(String.valueOf((char) Math.round((Math.random() * 25.0d) + 97.0d)));
            } else if (nextInt == 2) {
                sb2.append(String.valueOf(new Random().nextInt(10)));
            }
        }
        return sb2.toString();
    }

    public static String h(String str, String str2) {
        return str + str2;
    }

    public static String i(String str, String str2, String str3) {
        try {
            int indexOf = str3.indexOf(str) + str.length();
            if (indexOf <= str.length()) {
                return "";
            }
            int indexOf2 = !TextUtils.isEmpty(str2) ? str3.indexOf(str2, indexOf) : 0;
            return indexOf2 < 1 ? str3.substring(indexOf) : str3.substring(indexOf, indexOf2);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String j(String str, boolean z10) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            if (!z10 || digest.length <= 16) {
                return o(digest);
            }
            byte[] bArr = new byte[16];
            System.arraycopy(digest, 0, bArr, 0, 16);
            return o(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    public static String k(n3.a aVar) {
        return N(aVar, "ro.build.fingerprint");
    }

    public static String l(n3.a aVar, Context context) {
        try {
            String b10 = g.b(aVar, context, "alipay_cashier_ap_fi", "");
            if (!TextUtils.isEmpty(b10)) {
                return b10;
            }
            try {
                g.e(aVar, context, "alipay_cashier_ap_fi", r2.a.c("FU", System.currentTimeMillis(), new r2.d(), (short) 0, new r2.f()).a());
                String b11 = g.b(aVar, context, "alipay_cashier_ap_fi", "");
                if (!TextUtils.isEmpty(b11)) {
                    return b11;
                }
                x2.a.i(aVar, x2.b.f31789l, "e_regen_empty", "");
                return "";
            } catch (Exception e10) {
                x2.a.i(aVar, x2.b.f31789l, "e_gen", e10.getClass().getSimpleName());
                return "";
            }
        } catch (Exception e11) {
            x2.a.e(aVar, x2.b.f31789l, "e_gen_err", e11);
            return "";
        }
    }

    public static String m(n3.a aVar, Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 128).versionName;
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.f31809v, th2);
            return "";
        }
    }

    public static String n(n3.a aVar, byte[] bArr) {
        BigInteger modulus;
        try {
            PublicKey publicKey = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey();
            if (!(publicKey instanceof RSAPublicKey) || (modulus = ((RSAPublicKey) publicKey).getModulus()) == null) {
                return null;
            }
            return modulus.toString(16);
        } catch (Exception e10) {
            x2.a.e(aVar, x2.b.f31793n, x2.b.f31813x, e10);
            return null;
        }
    }

    public static String o(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(Character.forDigit((b10 & 240) >> 4, 16));
            sb2.append(Character.forDigit(b10 & 15, 16));
        }
        return sb2.toString();
    }

    public static Map<String, String> p(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                hashMap.put(next, jSONObject.optString(next));
            } catch (Throwable th2) {
                d.e(th2);
            }
        }
        return hashMap;
    }

    public static JSONObject q(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        if (intent == null) {
            return jSONObject;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                try {
                    jSONObject.put(str, String.valueOf(extras.get(str)));
                } catch (Throwable unused) {
                }
            }
        }
        return jSONObject;
    }

    public static c r(PackageInfo packageInfo, int i10, String str) {
        if (packageInfo == null) {
            return null;
        }
        return new c(packageInfo, i10, str);
    }

    public static c s(n3.a aVar, Context context, String str, int i10, String str2) {
        PackageInfo packageInfo;
        if (EnvUtils.d()) {
            if (f29761b.equals(str)) {
                str = f29764e;
            } else if ("hk.alipay.wallet".equals(str)) {
                str = f29763d;
            }
        }
        try {
            packageInfo = e(context, str);
        } catch (Throwable th2) {
            x2.a.i(aVar, x2.b.f31793n, x2.b.f31809v, th2.getMessage());
            packageInfo = null;
        }
        if (z(aVar, packageInfo)) {
            return r(packageInfo, i10, str2);
        }
        return null;
    }

    public static c t(n3.a aVar, Context context, List<a.b> list) {
        c s10;
        if (list == null) {
            return null;
        }
        for (a.b bVar : list) {
            if (bVar != null && (s10 = s(aVar, context, bVar.f1164a, bVar.f1165b, bVar.f1166c)) != null && !s10.b(aVar) && !s10.a()) {
                return s10;
            }
        }
        return null;
    }

    public static void u(String str, String str2, Context context, n3.a aVar) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || J(aVar) || !b3.a.J().C()) {
            return;
        }
        try {
            Intent intent = new Intent(z2.b.f33627l);
            intent.putExtra("bizType", str);
            intent.putExtra("exName", str2);
            intent.setPackage(context.getPackageName());
            context.sendBroadcast(intent);
            x2.a.d(aVar, x2.b.f31789l, "AppNotify", str + "|" + str2);
        } catch (Exception unused) {
        }
    }

    public static boolean v(long j10, Runnable runnable, String str) {
        if (runnable == null) {
            return false;
        }
        ConditionVariable conditionVariable = new ConditionVariable();
        Thread thread = new Thread(new b(runnable, conditionVariable));
        if (!TextUtils.isEmpty(str)) {
            thread.setName(str);
        }
        thread.start();
        if (j10 > 0) {
            return conditionVariable.block(j10);
        }
        conditionVariable.block();
        return true;
    }

    public static boolean w(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        try {
            String str = packageInfo.versionName;
            String[] strArr = f29766g;
            if (!TextUtils.equals(str, strArr[0])) {
                if (!TextUtils.equals(str, strArr[1])) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean x(Object obj, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return obj == null;
        }
        for (Object obj2 : objArr) {
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return true;
            }
        }
        return false;
    }

    public static boolean y(n3.a aVar, Context context, List<a.b> list, boolean z10) {
        try {
            for (a.b bVar : list) {
                if (bVar != null) {
                    String str = bVar.f1164a;
                    if (EnvUtils.d()) {
                        if (f29761b.equals(str)) {
                            str = f29764e;
                        } else if ("hk.alipay.wallet".equals(str)) {
                            str = f29763d;
                        }
                    }
                    try {
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                        if (packageInfo != null) {
                            if (!z10) {
                                return true;
                            }
                            x2.a.d(aVar, x2.b.f31789l, x2.b.X, packageInfo.packageName + "|" + packageInfo.versionName);
                            return true;
                        }
                        continue;
                    } catch (PackageManager.NameNotFoundException unused) {
                        continue;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.f31784h0, th2);
            return false;
        }
    }

    public static boolean z(n3.a aVar, PackageInfo packageInfo) {
        String str = "";
        boolean z10 = false;
        if (packageInfo == null) {
            str = "info == null";
        } else {
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                str = "info.signatures == null";
            } else if (signatureArr.length <= 0) {
                str = "info.signatures.length <= 0";
            } else {
                z10 = true;
            }
        }
        if (!z10) {
            x2.a.i(aVar, x2.b.f31793n, x2.b.f31811w, str);
        }
        return z10;
    }
}
