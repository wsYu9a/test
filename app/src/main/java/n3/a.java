package n3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.czhj.sdk.common.Constants;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p3.d;
import p3.k;

/* loaded from: classes.dex */
public class a {
    public static final String A = "act_info";
    public static final String B = "UTF-8";
    public static final String C = "new_external_info==";

    /* renamed from: m */
    public static final String f28747m = "\"&";

    /* renamed from: n */
    public static final String f28748n = "&";

    /* renamed from: o */
    public static final String f28749o = "bizcontext=\"";

    /* renamed from: p */
    public static final String f28750p = "bizcontext=";

    /* renamed from: q */
    public static final String f28751q = "\"";

    /* renamed from: r */
    public static final String f28752r = "appkey";

    /* renamed from: s */
    public static final String f28753s = "ty";

    /* renamed from: t */
    public static final String f28754t = "sv";

    /* renamed from: u */
    public static final String f28755u = "an";

    /* renamed from: v */
    public static final String f28756v = "setting";

    /* renamed from: w */
    public static final String f28757w = "av";

    /* renamed from: x */
    public static final String f28758x = "sdk_start_time";

    /* renamed from: y */
    public static final String f28759y = "extInfo";

    /* renamed from: z */
    public static final String f28760z = "ap_link_token";

    /* renamed from: a */
    public String f28761a;

    /* renamed from: b */
    public String f28762b;

    /* renamed from: c */
    public Context f28763c;

    /* renamed from: d */
    public final String f28764d;

    /* renamed from: e */
    public final long f28765e;

    /* renamed from: f */
    public final int f28766f;

    /* renamed from: g */
    public final String f28767g;

    /* renamed from: h */
    public boolean f28768h = false;

    /* renamed from: i */
    public boolean f28769i = false;

    /* renamed from: j */
    public boolean f28770j = false;

    /* renamed from: k */
    public final ActivityInfo f28771k;

    /* renamed from: l */
    public final x2.b f28772l;

    /* renamed from: n3.a$a */
    public static final class C0746a {

        /* renamed from: a */
        public static final HashMap<UUID, a> f28773a = new HashMap<>();

        /* renamed from: b */
        public static final HashMap<String, a> f28774b = new HashMap<>();

        /* renamed from: c */
        public static final String f28775c = "i_uuid_b_c";

        public static a a(Intent intent) {
            if (intent == null) {
                return null;
            }
            Serializable serializableExtra = intent.getSerializableExtra(f28775c);
            if (serializableExtra instanceof UUID) {
                return f28773a.remove((UUID) serializableExtra);
            }
            return null;
        }

        public static a b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return f28774b.remove(str);
        }

        public static void c(a aVar, Intent intent) {
            if (aVar == null || intent == null) {
                return;
            }
            UUID randomUUID = UUID.randomUUID();
            f28773a.put(randomUUID, aVar);
            intent.putExtra(f28775c, randomUUID);
        }

        public static void d(a aVar, String str) {
            if (aVar == null || TextUtils.isEmpty(str)) {
                return;
            }
            f28774b.put(str, aVar);
        }
    }

    public a(Context context, String str, String str2) {
        String str3;
        this.f28761a = "";
        this.f28762b = "";
        this.f28763c = null;
        boolean isEmpty = TextUtils.isEmpty(str2);
        this.f28772l = new x2.b(context, isEmpty);
        String j10 = j(str, this.f28762b);
        this.f28764d = j10;
        this.f28765e = SystemClock.elapsedRealtime();
        this.f28766f = k.Z();
        ActivityInfo d10 = k.d(context);
        this.f28771k = d10;
        this.f28767g = str2;
        if (!isEmpty) {
            x2.a.d(this, x2.b.f31789l, "eptyp", str2 + "|" + j10);
            if (d10 != null) {
                str3 = d10.name + "|" + d10.launchMode;
            } else {
                str3 = "null";
            }
            x2.a.d(this, x2.b.f31789l, "actInfo", str3);
            x2.a.d(this, x2.b.f31789l, NotificationCompat.CATEGORY_SYSTEM, k.k(this));
            x2.a.d(this, x2.b.f31789l, "sdkv", "35f627f-clean");
        }
        try {
            this.f28763c = context.getApplicationContext();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f28761a = packageInfo.versionName;
            this.f28762b = packageInfo.packageName;
        } catch (Exception e10) {
            d.e(e10);
        }
        if (!isEmpty) {
            x2.a.c(this, x2.b.f31789l, "u" + k.Z());
            x2.a.d(this, x2.b.f31789l, x2.b.Q, "" + SystemClock.elapsedRealtime());
            x2.a.b(context, this, str, this.f28764d);
        }
        if (isEmpty || !b3.a.J().z()) {
            return;
        }
        b3.a.J().g(this, this.f28763c, true, 2);
    }

    public static HashMap<String, String> f(a aVar) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (aVar != null) {
            hashMap.put("sdk_ver", "15.8.30");
            hashMap.put("app_name", aVar.f28762b);
            hashMap.put(Constants.TOKEN, aVar.f28764d);
            hashMap.put("call_type", aVar.f28767g);
            hashMap.put("ts_api_invoke", String.valueOf(aVar.f28765e));
            p3.a.d(aVar, hashMap);
        }
        return hashMap;
    }

    public static String j(String str, String str2) {
        try {
            Locale locale = Locale.getDefault();
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return String.format("EP%s%s_%s", "1", k.b0(String.format(locale, "%s%s%d%s", str, str2, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString())), Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable unused) {
            return "-";
        }
    }

    public static a w() {
        return null;
    }

    public Context a() {
        return this.f28763c;
    }

    public String b(String str) {
        return TextUtils.isEmpty(str) ? str : str.startsWith(C) ? p(str) : u(str) ? n(str) : r(str);
    }

    public final String c(String str, String str2) {
        return str + e(new JSONObject()) + str2;
    }

    public final String d(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        for (int i10 = 0; i10 < split.length; i10++) {
            if (!TextUtils.isEmpty(split[i10]) && split[i10].startsWith(str3)) {
                return split[i10];
            }
        }
        return null;
    }

    public String e(JSONObject jSONObject) {
        String str;
        try {
            if (!jSONObject.has("appkey")) {
                jSONObject.put("appkey", z2.a.f33596g);
            }
            if (!jSONObject.has(f28753s)) {
                jSONObject.put(f28753s, "and_lite");
            }
            if (!jSONObject.has(f28754t)) {
                jSONObject.put(f28754t, "h.a.3.8.30");
            }
            if (!jSONObject.has(f28755u)) {
                jSONObject.put(f28755u, this.f28762b);
            }
            if (!jSONObject.has(f28757w)) {
                jSONObject.put(f28757w, this.f28761a);
            }
            if (!jSONObject.has(f28758x)) {
                jSONObject.put(f28758x, System.currentTimeMillis());
            }
            if (!jSONObject.has(f28759y)) {
                jSONObject.put(f28759y, v());
            }
            if (!jSONObject.has(A)) {
                if (this.f28771k != null) {
                    str = this.f28771k.name + "|" + this.f28771k.launchMode;
                } else {
                    str = "null";
                }
                jSONObject.put(A, str);
            }
            return jSONObject.toString();
        } catch (Throwable th2) {
            x2.a.f(this, x2.b.f31789l, "fmt3", th2, String.valueOf(jSONObject));
            d.e(th2);
            return jSONObject != null ? jSONObject.toString() : "{}";
        }
    }

    public void g(boolean z10) {
        this.f28769i = z10;
    }

    public String h() {
        return this.f28762b;
    }

    public final String i(String str) throws JSONException {
        return e(new JSONObject(str));
    }

    public final String k(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject;
        String substring = str.substring(str2.length());
        boolean z10 = false;
        String substring2 = substring.substring(0, substring.length() - str3.length());
        if (substring2.length() >= 2 && substring2.startsWith("\"") && substring2.endsWith("\"")) {
            jSONObject = new JSONObject(substring2.substring(1, substring2.length() - 1));
            z10 = true;
        } else {
            jSONObject = new JSONObject(substring2);
        }
        String e10 = e(jSONObject);
        if (z10) {
            e10 = "\"" + e10 + "\"";
        }
        return str2 + e10 + str3;
    }

    public void l(boolean z10) {
        this.f28768h = z10;
    }

    public String m() {
        return this.f28761a;
    }

    public final String n(String str) {
        try {
            String d10 = d(str, "&", f28750p);
            if (TextUtils.isEmpty(d10)) {
                str = str + "&" + c(f28750p, "");
            } else {
                int indexOf = str.indexOf(d10);
                str = str.substring(0, indexOf) + k(d10, f28750p, "") + str.substring(indexOf + d10.length());
            }
        } catch (Throwable th2) {
            x2.a.f(this, x2.b.f31789l, "fmt1", th2, str);
        }
        return str;
    }

    public void o(boolean z10) {
        this.f28770j = z10;
    }

    public final String p(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str.substring(19));
            jSONObject.put("bizcontext", i(jSONObject.optString("bizcontext")));
            return C + jSONObject.toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public boolean q() {
        return this.f28769i;
    }

    public final String r(String str) {
        try {
            String d10 = d(str, f28747m, f28749o);
            if (TextUtils.isEmpty(d10)) {
                return str + "&" + c(f28749o, "\"");
            }
            if (!d10.endsWith("\"")) {
                d10 = d10 + "\"";
            }
            int indexOf = str.indexOf(d10);
            return str.substring(0, indexOf) + k(d10, f28749o, "\"") + str.substring(indexOf + d10.length());
        } catch (Throwable th2) {
            x2.a.f(this, x2.b.f31789l, "fmt2", th2, str);
            return str;
        }
    }

    public boolean s() {
        return this.f28768h;
    }

    public boolean t() {
        return this.f28770j;
    }

    public final boolean u(String str) {
        return !str.contains(f28747m);
    }

    public final JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f28760z, this.f28764d);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
