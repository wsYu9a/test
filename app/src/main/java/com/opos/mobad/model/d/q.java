package com.opos.mobad.model.d;

import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class q {

    /* renamed from: a */
    private p f21636a = new p();

    /* renamed from: b */
    private Map<String, r> f21637b = new ConcurrentHashMap();

    private q a(int i2, y yVar) {
        if (yVar != null) {
            this.f21636a.a(yVar.aU, String.valueOf(i2));
        }
        return this;
    }

    public q a(y yVar) {
        return a(9, yVar);
    }

    public q a(y yVar, x xVar) {
        if (yVar != null) {
            this.f21637b.put(yVar.aU, new r(yVar, xVar));
        }
        return this;
    }

    public void a(String str, int i2) {
        Map<String, r> map = this.f21637b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (r rVar : this.f21637b.values()) {
            if (rVar != null) {
                rVar.a(str, i2);
            }
        }
    }

    public q b(y yVar) {
        return a(2, yVar);
    }

    public q c(y yVar) {
        return a(11, yVar);
    }

    public q d(y yVar) {
        return a(3, yVar);
    }

    public q e(y yVar) {
        return a(4, yVar);
    }

    public q f(y yVar) {
        return a(6, yVar);
    }

    public q g(y yVar) {
        return a(7, yVar);
    }

    protected String g() {
        String valueOf;
        for (String str : this.f21637b.keySet()) {
            String a2 = this.f21637b.get(str).a();
            if (TextUtils.isEmpty(a2)) {
                this.f21636a.a(str, String.valueOf(0));
            } else {
                try {
                    valueOf = URLEncoder.encode("0-" + a2);
                } catch (Exception unused) {
                    valueOf = String.valueOf(0);
                }
                this.f21636a.a(str, valueOf);
            }
        }
        String a3 = this.f21636a.a();
        if (TextUtils.isEmpty(a3)) {
            return a3;
        }
        try {
            return URLEncoder.encode(a3);
        } catch (Exception unused2) {
            return "";
        }
    }

    public q h(y yVar) {
        return a(10, yVar);
    }

    public q i(y yVar) {
        a(yVar, (x) null);
        return this;
    }
}
