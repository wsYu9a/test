package x2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;
import p3.d;
import p3.k;
import x2.a;

/* loaded from: classes.dex */
public class b {
    public static final String A = "SSLDenied";
    public static final String A0 = "out_trade_no";
    public static final String B = "H5PayDataAnalysisError";
    public static final String B0 = "trade_no";
    public static final String C = "H5AuthDataAnalysisError";
    public static final String C0 = "biz_content";
    public static final String D = "PublicKeyUnmatch";
    public static final String D0 = "app_id";
    public static final String E = "ClientBindFailed";
    public static final String F = "TriDesEncryptError";
    public static final String G = "TriDesDecryptError";
    public static final String H = "ClientBindException";
    public static final String I = "SaveTradeTokenError";
    public static final String J = "ClientBindServiceFailed";
    public static final String K = "TryStartServiceEx";
    public static final String L = "BindWaitTimeoutEx";
    public static final String M = "CheckClientExistEx";
    public static final String N = "CheckClientSignEx";
    public static final String O = "GetInstalledAppEx";
    public static final String P = "ParserTidClientKeyEx";
    public static final String Q = "PgApiInvoke";
    public static final String R = "PgBindStarting";
    public static final String S = "PgBinded";
    public static final String T = "PgBindEnd";
    public static final String U = "PgBindPay";
    public static final String V = "PgReturn";
    public static final String W = "PgReturnV";
    public static final String X = "PgWltVer";
    public static final String Y = "PgOpenStarting";
    public static final String Z = "ErrIntentEx";

    /* renamed from: a0 */
    public static final String f31777a0 = "ErrActNull";

    /* renamed from: b0 */
    public static final String f31778b0 = "ErrActEx";

    /* renamed from: c0 */
    public static final String f31779c0 = "ErrActNull2";

    /* renamed from: d0 */
    public static final String f31780d0 = "ErrActEx2";

    /* renamed from: e0 */
    public static final String f31781e0 = "ErrActNotCreated";

    /* renamed from: f0 */
    public static final String f31782f0 = "GetInstalledAppEx";

    /* renamed from: g0 */
    public static final String f31783g0 = "StartLaunchAppTransEx";

    /* renamed from: h0 */
    public static final String f31784h0 = "CheckLaunchAppExistEx";

    /* renamed from: i0 */
    public static final String f31785i0 = "LogBindCalledH5";

    /* renamed from: j0 */
    public static final String f31786j0 = "LogCalledH5";

    /* renamed from: k */
    public static final String f31787k = "net";

    /* renamed from: k0 */
    public static final String f31788k0 = "LogHkLoginByIntent";

    /* renamed from: l */
    public static final String f31789l = "biz";

    /* renamed from: l0 */
    public static final String f31790l0 = "SchemePayWrongHashEx";

    /* renamed from: m */
    public static final String f31791m = "cp";

    /* renamed from: m0 */
    public static final String f31792m0 = "LogAppFetchConfigTimeout";

    /* renamed from: n */
    public static final String f31793n = "auth";

    /* renamed from: n0 */
    public static final String f31794n0 = "H5CbUrlEmpty";

    /* renamed from: o */
    public static final String f31795o = "third";

    /* renamed from: o0 */
    public static final String f31796o0 = "H5CbEx";

    /* renamed from: p */
    public static final String f31797p = "wlt";

    /* renamed from: p0 */
    public static final String f31798p0 = "StartActivityEx";

    /* renamed from: q */
    public static final String f31799q = "FormatResultEx";

    /* renamed from: q0 */
    public static final String f31800q0 = "JSONEx";

    /* renamed from: r */
    public static final String f31801r = "GetApdidEx";

    /* renamed from: r0 */
    public static final String f31802r0 = "ParseBundleSerializableError";

    /* renamed from: s */
    public static final String f31803s = "GetApdidNull";

    /* renamed from: s0 */
    public static final String f31804s0 = "ParseSchemeQueryError";

    /* renamed from: t */
    public static final String f31805t = "GetApdidTimeout";

    /* renamed from: t0 */
    public static final String f31806t0 = "TbChk";

    /* renamed from: u */
    public static final String f31807u = "GetUtdidEx";

    /* renamed from: u0 */
    public static final String f31808u0 = "TbStart";

    /* renamed from: v */
    public static final String f31809v = "GetPackageInfoEx";

    /* renamed from: v0 */
    public static final String f31810v0 = "TbCancel";

    /* renamed from: w */
    public static final String f31811w = "NotIncludeSignatures";

    /* renamed from: w0 */
    public static final String f31812w0 = "TbUnknown";

    /* renamed from: x */
    public static final String f31813x = "GetPublicKeyFromSignEx";

    /* renamed from: x0 */
    public static final String f31814x0 = "TbOk";

    /* renamed from: y */
    public static final String f31815y = "webError";

    /* renamed from: y0 */
    public static final String f31816y0 = "TbActFail";

    /* renamed from: z */
    public static final String f31817z = "SSLError";

    /* renamed from: z0 */
    public static final String f31818z0 = "partner";

    /* renamed from: a */
    public String f31819a;

    /* renamed from: b */
    public String f31820b;

    /* renamed from: c */
    public String f31821c;

    /* renamed from: d */
    public String f31822d;

    /* renamed from: e */
    public String f31823e;

    /* renamed from: f */
    public String f31824f;

    /* renamed from: g */
    public String f31825g;

    /* renamed from: h */
    public String f31826h = "";

    /* renamed from: i */
    public String f31827i = "";

    /* renamed from: j */
    public String f31828j;

    public b(Context context, boolean z10) {
        context = context != null ? context.getApplicationContext() : context;
        this.f31819a = k();
        this.f31821c = c(context);
        this.f31822d = b(z10 ? 0L : a.e.a(context));
        this.f31823e = a();
        this.f31824f = l(context);
        this.f31825g = "-";
        this.f31828j = "-";
    }

    public static String a() {
        return String.format("%s,%s,-,-,-", p(o3.a.a(n3.b.e().c()).i()), p(n3.b.e().d()));
    }

    public static String b(long j10) {
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,%s,-", p("15.8.30"), p("h.a.3.8.30"), "~" + j10);
    }

    public static String c(Context context) {
        String packageName;
        String str = "-";
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                packageName = applicationContext.getPackageName();
                try {
                    PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(packageName, 64);
                    str = packageInfo.versionName + "|" + d(packageInfo);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
            }
            return String.format("%s,%s,-,-,-", p(packageName), p(str));
        }
        packageName = "-";
        return String.format("%s,%s,-,-,-", p(packageName), p(str));
    }

    public static String d(PackageInfo packageInfo) {
        Signature[] signatureArr;
        String str;
        String n10;
        if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length == 0) {
            return "0";
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                try {
                    n10 = k.n(null, signature.toByteArray());
                } catch (Throwable unused) {
                }
                if (!TextUtils.isEmpty(n10)) {
                    str = k.b0(n10).substring(0, 8);
                    sb2.append("-");
                    sb2.append(str);
                }
                str = "?";
                sb2.append("-");
                sb2.append(str);
            }
            return sb2.toString();
        } catch (Throwable unused2) {
            return "?";
        }
    }

    public static String f(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(th2.getClass().getName());
            stringBuffer.append(":");
            stringBuffer.append(th2.getMessage());
            stringBuffer.append(" 》 ");
            StackTraceElement[] stackTrace = th2.getStackTrace();
            if (stackTrace != null) {
                int i10 = 0;
                for (StackTraceElement stackTraceElement : stackTrace) {
                    stringBuffer.append(stackTraceElement.toString());
                    stringBuffer.append(" 》 ");
                    i10++;
                    if (i10 > 5) {
                        break;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String k() {
        return String.format("%s,%s", u(), new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()));
    }

    public static String l(Context context) {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", p(c.f(context)), "android", p(Build.VERSION.RELEASE), p(Build.MODEL), "-", "0", p(c.g(context).b()), "gw", p(com.alipay.sdk.m.w.b.c(null, context)));
    }

    public static String m(String str) {
        String str2;
        String str3;
        if (str == null) {
            str = "";
        }
        String[] split = str.split("&");
        String str4 = null;
        if (split != null) {
            str2 = null;
            str3 = null;
            for (String str5 : split) {
                String[] split2 = str5.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase(f31818z0)) {
                        str4 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(A0)) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(B0)) {
                        str3 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(C0)) {
                        try {
                            JSONObject jSONObject = new JSONObject(k.V(n3.a.w(), split2[1]));
                            if (TextUtils.isEmpty(str2)) {
                                str2 = jSONObject.getString(A0);
                            }
                        } catch (Throwable unused) {
                        }
                    } else if (split2[0].equalsIgnoreCase("app_id") && TextUtils.isEmpty(str4)) {
                        str4 = split2[1];
                    }
                }
            }
        } else {
            str2 = null;
            str3 = null;
        }
        return String.format("%s,%s,-,%s,-,-,-", p(str3), p(str2), p(str4));
    }

    public static String o() {
        return new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(new Date());
    }

    public static String p(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("^", "~").replace("#", "＃");
    }

    public static String r(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static String u() {
        try {
            return UUID.randomUUID().toString();
        } catch (Throwable unused) {
            return "12345678uuid";
        }
    }

    public String e(String str) {
        String m10 = m(str);
        this.f31820b = m10;
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", this.f31819a, m10, this.f31821c, this.f31822d, this.f31823e, this.f31824f, this.f31825g, r(this.f31826h), r(this.f31827i), this.f31828j);
    }

    public void g(String str, String str2) {
        q("", str, str2);
    }

    public void h(String str, String str2, String str3) {
        q("", str, str2 + "|" + str3);
    }

    public void i(String str, String str2, Throwable th2) {
        s(str, str2, f(th2));
    }

    public void j(String str, String str2, Throwable th2, String str3) {
        s(str, str2, str3 + ": " + f(th2));
    }

    public void n(String str, String str2, String str3) {
        s(str, str2, str3);
    }

    public final synchronized void q(String str, String str2, String str3) {
        try {
            d.i(z2.a.A, String.format("event %s %s %s", str, str2, str3));
            String str4 = "";
            if (!TextUtils.isEmpty(this.f31826h)) {
                str4 = "^";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(String.format("%s,%s,%s,-,-,-,-,-,-,-,-,-,-,%s", TextUtils.isEmpty(str) ? "-" : p(str), p(str2), p(str3), p(o())));
            this.f31826h += sb2.toString();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void s(String str, String str2, String str3) {
        try {
            d.h(z2.a.A, String.format("err %s %s %s", str, str2, str3));
            String str4 = "";
            if (!TextUtils.isEmpty(this.f31827i)) {
                str4 = "^";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(String.format("%s,%s,%s,%s", str, str2, TextUtils.isEmpty(str3) ? "-" : p(str3), p(o())));
            this.f31827i += sb2.toString();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final boolean t() {
        return TextUtils.isEmpty(this.f31827i);
    }
}
