package com.aggmoread.sdk.z.d.a.a.d.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes.dex */
public class f {

    /* renamed from: a */
    private String f5951a;

    /* renamed from: b */
    private List<String> f5952b = new ArrayList();

    private f(String str) {
        this.f5951a = str;
    }

    private String a() {
        if (this.f5952b.size() == 1) {
            return this.f5952b.get(0);
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f5952b.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(it.next());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public static f b(String str) {
        return new f(str);
    }

    public void c() {
        if (this.f5952b.size() > 0) {
            boolean z10 = this.f5952b.size() > 1;
            com.aggmoread.sdk.z.d.a.a.e.e.b("AMHTTAG", this.f5951a + ", batchReport " + z10);
            new k().a(a(), z10);
        }
    }

    public void a(k kVar) {
        if (kVar != null) {
            a(com.aggmoread.sdk.z.d.a.a.b.c(kVar.f6030a.f6092a));
        }
    }

    public void b() {
        this.f5952b.clear();
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5952b.add(str);
    }
}
