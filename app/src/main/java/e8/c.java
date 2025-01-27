package e8;

import android.text.TextUtils;
import androidx.core.provider.FontsContractCompat;
import java.util.Map;
import p3.f;
import p3.i;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a */
    public String f25775a;

    /* renamed from: b */
    public String f25776b;

    /* renamed from: c */
    public String f25777c;

    /* renamed from: d */
    public String f25778d;

    /* renamed from: e */
    public String f25779e;

    /* renamed from: f */
    public String f25780f;

    public c(Map<String, String> map, boolean z10) {
        if (map == null) {
            return;
        }
        for (String str : map.keySet()) {
            if (TextUtils.equals(str, i.f29756a)) {
                this.f25775a = map.get(str);
            } else if (TextUtils.equals(str, i.f29758c)) {
                this.f25776b = map.get(str);
            } else if (TextUtils.equals(str, i.f29757b)) {
                this.f25777c = map.get(str);
            }
        }
        String str2 = this.f25776b;
        if (str2 == null) {
            return;
        }
        for (String str3 : str2.split("&")) {
            if (str3.startsWith("alipay_open_id")) {
                this.f25780f = h(g("alipay_open_id=", str3), z10);
            } else if (str3.startsWith("auth_code")) {
                this.f25779e = h(g("auth_code=", str3), z10);
            } else if (str3.startsWith(FontsContractCompat.Columns.RESULT_CODE)) {
                this.f25778d = h(g("result_code=", str3), z10);
            }
        }
    }

    public String a() {
        return this.f25780f;
    }

    public String b() {
        return this.f25779e;
    }

    public String c() {
        return this.f25777c;
    }

    public String d() {
        return this.f25776b;
    }

    public String e() {
        return this.f25778d;
    }

    public String f() {
        return this.f25775a;
    }

    public final String g(String str, String str2) {
        return str2.substring(str.length(), str2.length());
    }

    public final String h(String str, boolean z10) {
        if (!z10 || TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("\"")) {
            str = str.replaceFirst("\"", "");
        }
        return str.endsWith("\"") ? str.substring(0, str.length() - 1) : str;
    }

    public String toString() {
        return "authCode={" + this.f25779e + "}; resultStatus={" + this.f25775a + "}; memo={" + this.f25777c + "}; result={" + this.f25776b + f.f29748d;
    }
}
