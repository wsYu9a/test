package com.vivo.mobilead.i;

import android.text.TextUtils;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.z0;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f extends k {

    /* renamed from: e */
    protected HashMap<String, String> f28892e;

    /* renamed from: f */
    private com.vivo.mobilead.j.b f28893f;

    /* renamed from: g */
    private String f28894g;

    public f(int i2, String str, HashMap<String, String> hashMap, d dVar, com.vivo.mobilead.j.b bVar) {
        super(i2, str, dVar);
        this.f28892e = hashMap;
        this.f28893f = bVar;
        b(true);
        if (this.f28892e == null) {
            this.f28892e = new HashMap<>();
        }
        u.a(this.f28892e);
    }

    @Override // com.vivo.mobilead.i.k
    public Object a(e eVar) throws c {
        try {
            try {
                byte[] bArr = new byte[0];
                try {
                    bArr = g.a(eVar.f28890a);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    String a2 = g.a(new String(bArr, g.a(eVar.f28891b, "utf-8")));
                    JSONObject jSONObject = new JSONObject(a2);
                    x0.a("EntityRequest", "server result: " + a2);
                    com.vivo.mobilead.j.b bVar = this.f28893f;
                    if (bVar != null) {
                        return bVar.a(jSONObject);
                    }
                    return null;
                } catch (JSONException e3) {
                    x0.b("EntityRequest", "decrypt entity response JSONException, ", e3);
                    throw new c(402120, "数据解析出错，建议重试");
                } catch (Exception e4) {
                    x0.b("EntityRequest", "decrypt entity response Exception, ", e4);
                    throw new c(402121, "数据解析异常，建议重试");
                }
            } catch (UnsupportedEncodingException e5) {
                x0.b("EntityRequest", "parse entityRequest network response", e5);
                throw new c(402121, "数据解析异常，建议重试");
            }
        } catch (JSONException e6) {
            x0.b("EntityRequest", "parse entityRequest network response", e6);
            throw new c(402121, "数据解析异常，建议重试");
        }
    }

    @Override // com.vivo.mobilead.i.k
    public Map<String, String> b() {
        return this.f28892e;
    }

    @Override // com.vivo.mobilead.i.k
    public String d() {
        boolean z;
        String str;
        if (TextUtils.isEmpty(this.f28894g)) {
            z0 d2 = z0.d();
            String d3 = super.d();
            boolean z2 = true;
            if (a() == 1) {
                String a2 = u.a(d3, this.f28892e);
                if (f()) {
                    try {
                        str = d2.a(a2, d2.a());
                    } catch (Throwable th) {
                        VOpenLog.w("EntityRequest", "EntityRequest" + th.getMessage());
                        str = "";
                        z = false;
                    }
                } else {
                    str = "";
                }
                z = true;
                String a3 = (f() && z) ? g.a(str, "s", g.a(a2, false, str, false)) : g.a(a2, "s", g.a(a2, true, "", false));
                x0.a("EntityRequest", "processUrl:" + a3);
                this.f28894g = a3;
            } else {
                this.f28894g = d3;
                if (f()) {
                    try {
                        Map<String, String> a4 = d2.a(u.a(this.f28892e, u.a()), d2.a());
                        if (a4 != null && a4.size() > 0) {
                            this.f28892e.putAll(a4);
                        }
                    } catch (Throwable th2) {
                        com.vivo.mobilead.manager.c.d().a(th2);
                        VOpenLog.w("EntityRequest", "EntityRequest" + th2.getMessage());
                        z2 = false;
                    }
                }
                g.a(this.f28894g, this.f28892e);
                if (f() && z2) {
                    for (String str2 : u.a()) {
                        this.f28892e.remove(str2);
                    }
                }
                z = z2;
            }
            a(z);
        }
        return this.f28894g;
    }
}
