package l3;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import n3.b;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a */
    public com.alipay.sdk.m.r.a f27885a;

    /* renamed from: b */
    public String f27886b;

    /* renamed from: c */
    public String[] f27887c;

    public a(String str) {
        this.f27886b = str;
    }

    public static List<a> b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] d10 = d(jSONObject.optString("name", ""));
        for (int i10 = 0; i10 < d10.length; i10++) {
            com.alipay.sdk.m.r.a a10 = com.alipay.sdk.m.r.a.a(d10[i10]);
            if (a10 != com.alipay.sdk.m.r.a.None) {
                a aVar = new a(d10[i10], a10);
                aVar.f27887c = f(d10[i10]);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void c(a aVar) {
        String[] g10 = aVar.g();
        if (g10.length == 3 && TextUtils.equals("tid", g10[0])) {
            o3.a a10 = o3.a.a(b.e().c());
            if (TextUtils.isEmpty(g10[1]) || TextUtils.isEmpty(g10[2])) {
                return;
            }
            a10.c(g10[1], g10[2]);
        }
    }

    public static String[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(";");
    }

    public static String[] f(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public com.alipay.sdk.m.r.a a() {
        return this.f27885a;
    }

    public String e() {
        return this.f27886b;
    }

    public String[] g() {
        return this.f27887c;
    }

    public a(String str, com.alipay.sdk.m.r.a aVar) {
        this.f27886b = str;
        this.f27885a = aVar;
    }
}
