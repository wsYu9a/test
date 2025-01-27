package j3;

import android.content.Context;
import f3.a;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e extends h3.e {
    @Override // h3.e
    public h3.b b(n3.a aVar, Context context, String str) throws Throwable {
        p3.d.i(z2.a.A, "mdap post");
        byte[] a10 = d3.b.a(str.getBytes(Charset.forName("UTF-8")));
        HashMap hashMap = new HashMap();
        hashMap.put("utdId", n3.b.e().d());
        hashMap.put("logHeader", "RAW");
        hashMap.put("bizCode", p3.d.f29725b);
        hashMap.put("productId", "alipaysdk_android");
        hashMap.put(m5.c.f28293b0, "Gzip");
        hashMap.put("productVersion", "15.8.30");
        a.b a11 = f3.a.a(context, new a.C0696a(z2.a.f33594e, hashMap, a10));
        p3.d.i(z2.a.A, "mdap got " + a11);
        if (a11 == null) {
            throw new RuntimeException("Response is null");
        }
        boolean l10 = h3.e.l(a11);
        try {
            byte[] bArr = a11.f25969c;
            if (l10) {
                bArr = d3.b.b(bArr);
            }
            return new h3.b("", new String(bArr, Charset.forName("UTF-8")));
        } catch (Exception e10) {
            p3.d.e(e10);
            return null;
        }
    }

    @Override // h3.e
    public Map<String, String> i(boolean z10, String str) {
        return new HashMap();
    }

    @Override // h3.e
    public JSONObject j() {
        return null;
    }

    @Override // h3.e
    public boolean o() {
        return false;
    }

    @Override // h3.e
    public String g(n3.a aVar, String str, JSONObject jSONObject) {
        return str;
    }
}
