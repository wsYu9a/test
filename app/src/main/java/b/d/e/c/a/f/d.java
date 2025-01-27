package b.d.e.c.a.f;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.baidu.mobads.sdk.internal.bj;
import com.martian.ttbook.b.a.k.l;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private String f4594a;

    /* renamed from: b */
    private String f4595b;

    /* renamed from: c */
    private String f4596c;

    /* renamed from: d */
    private String f4597d;

    /* renamed from: e */
    private String f4598e;

    /* renamed from: f */
    private String f4599f;

    /* renamed from: g */
    private int f4600g;

    /* renamed from: h */
    private String f4601h;

    /* renamed from: i */
    private int f4602i;

    /* renamed from: j */
    private String f4603j;
    private int k;
    private String l;
    private String m;
    private String n;
    private a o = com.martian.ttbook.b.a.g.a.f().d();

    private String a() {
        String str = Build.VERSION.RELEASE;
        if (str.length() == 1) {
            str = str + ".0.0";
        }
        if (str.length() != 3) {
            return str;
        }
        return str + ".0";
    }

    private boolean c(String str) {
        return str == null || str.isEmpty();
    }

    private boolean d(String str, String str2) {
        return str == null || str.isEmpty() || str.equals(EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public static String e(Context context) {
        int i2 = context.getResources().getConfiguration().orientation;
        return i2 == 2 ? "L" : i2 == 1 ? "P" : "U";
    }

    private String f(Context context) {
        return System.getProperty("http.agent");
    }

    private boolean g(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public JSONObject b(Context context) {
        this.f4594a = this.o.c();
        this.f4599f = this.o.e();
        String g2 = this.o.g();
        this.f4595b = g2;
        if (TextUtils.isEmpty(g2)) {
            this.f4595b = l.h(context);
        }
        this.f4596c = this.o.a();
        this.m = this.o.k();
        this.f4601h = a();
        this.f4602i = g(context) ? 2 : 1;
        this.f4603j = f(context);
        this.f4600g = 1;
        this.k = e(context).equals("L") ? 2 : e(context).equals("P") ? 1 : 0;
        this.l = Build.BRAND;
        this.f4597d = Build.MODEL;
        this.f4598e = Build.MANUFACTURER;
        this.n = this.o.i();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", c(this.f4594a) ? this.f4596c : this.f4594a);
            jSONObject.put("oaid", c(this.n) ? com.martian.ttbook.b.a.g.c.f14945b : this.n);
            jSONObject.put("mac", this.f4595b);
            jSONObject.put("androidId", this.f4596c);
            jSONObject.put("osVersion", this.f4601h);
            jSONObject.put("deviceType", this.f4602i);
            jSONObject.put("screenWidth", context.getResources().getDisplayMetrics().widthPixels);
            jSONObject.put("screenHeight", context.getResources().getDisplayMetrics().heightPixels);
            jSONObject.put("ua", this.f4603j);
            jSONObject.put("ppi", context.getResources().getDisplayMetrics().densityDpi);
            jSONObject.put("serialNo", d(this.m, EnvironmentCompat.MEDIA_UNKNOWN) ? this.f4596c : this.m);
            jSONObject.put("osType", this.f4600g);
            jSONObject.put("screenOrientation", this.k);
            jSONObject.put(bj.f5605j, this.l);
            jSONObject.put(bj.f5604i, this.f4597d);
            jSONObject.put("vendor", this.f4598e);
            jSONObject.put("imsi", this.f4599f);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "JuHeApiDevice{imei='" + this.f4594a + "', mac='" + this.f4595b + "', androidId='" + this.f4596c + "', model='" + this.f4597d + "', vendor='" + this.f4598e + "', osType=" + this.f4600g + ", osVersion='" + this.f4601h + "', deviceType=" + this.f4602i + ", ua='" + this.f4603j + "', screenOrientation=" + this.k + ", brand='" + this.l + "', serialNo='" + this.m + "'}";
    }
}
