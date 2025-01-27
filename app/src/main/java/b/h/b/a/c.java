package b.h.b.a;

import android.content.Context;
import b.h.b.a.d;
import h.a.a.a;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    public static c f5046a;

    /* renamed from: b */
    public HashMap<String, a.f> f5047b;

    public c() {
        this.f5047b = null;
        this.f5047b = new HashMap<>();
    }

    public static c a() {
        if (f5046a == null) {
            synchronized (c.class) {
                if (f5046a == null) {
                    f5046a = new c();
                }
            }
        }
        return f5046a;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String b(Context context, String str) {
        String c2;
        String str2;
        synchronized (this) {
            c2 = a.b.c(context, str, this.f5047b);
            if (c2.equals("") || c2 == "") {
                d dVar = d.b.f5054a;
                String a2 = dVar.a(context, str);
                long currentTimeMillis = System.currentTimeMillis() + a.b.h(str);
                a.f fVar = null;
                if (!a2.equals("") && a2 != "") {
                    if (this.f5047b.containsKey(str)) {
                        fVar = this.f5047b.get(str);
                        fVar.f35299a = a2;
                        fVar.f35300b = currentTimeMillis;
                    } else {
                        fVar = new a.f(a2, currentTimeMillis);
                        this.f5047b.put(str, fVar);
                    }
                }
                char c3 = 65535;
                switch (str.hashCode()) {
                    case 2015626:
                        if (str.equals("APID")) {
                            c3 = 5;
                            break;
                        }
                        break;
                    case 2020431:
                        if (str.equals("AUID")) {
                            c3 = 4;
                            break;
                        }
                        break;
                    case 2109804:
                        if (str.equals("DUID")) {
                            c3 = 3;
                            break;
                        }
                        break;
                    case 2199177:
                        if (str.equals("GUID")) {
                            c3 = 0;
                            break;
                        }
                        break;
                    case 2437505:
                        if (str.equals("OUID")) {
                            c3 = 2;
                            break;
                        }
                        break;
                    case 572132464:
                        if (str.equals("OUID_STATUS")) {
                            c3 = 1;
                            break;
                        }
                        break;
                }
                if (c3 == 0) {
                    a.b.e(context, fVar, "GUID");
                    c(context, "APID");
                    c(context, "OUID");
                    c(context, "AUID");
                    str2 = "OUID_STATUS";
                } else if (c3 == 1) {
                    c(context, "GUID");
                    c(context, "APID");
                    c(context, "OUID");
                    str2 = "AUID";
                } else if (c3 == 2) {
                    c(context, "GUID");
                    c(context, "APID");
                    c(context, "OUID_STATUS");
                    str2 = "AUID";
                } else if (c3 == 3) {
                    a.b.e(context, fVar, "DUID");
                    c(context, "GUID");
                    c(context, "APID");
                    c(context, "OUID");
                    c(context, "OUID_STATUS");
                    str2 = "AUID";
                } else if (c3 == 4) {
                    a.b.e(context, fVar, "AUID");
                    c(context, "GUID");
                    c(context, "APID");
                    c(context, "OUID");
                    str2 = "OUID_STATUS";
                } else if (c3 != 5) {
                    dVar.b(context);
                    c2 = a2;
                } else {
                    a.b.e(context, fVar, "APID");
                    c(context, "GUID");
                    c(context, "AUID");
                    c(context, "OUID");
                    str2 = "OUID_STATUS";
                }
                c(context, str2);
                dVar.b(context);
                c2 = a2;
            }
        }
        return c2;
    }

    public void c(Context context, String str) {
        if (this.f5047b.containsKey(str)) {
            a.f fVar = this.f5047b.get(str);
            if (fVar.a(str)) {
                return;
            }
            String a2 = d.b.f5054a.a(context, str);
            long currentTimeMillis = System.currentTimeMillis();
            long h2 = a.b.h(str);
            if (a2.equals("") || a2 == "") {
                return;
            }
            fVar.f35299a = a2;
            fVar.f35300b = currentTimeMillis + h2;
            a.b.e(context, fVar, str);
            return;
        }
        if (str.equals("OUID") || str.equals("OUID_STATUS") || str == "OUID" || str == "OUID_STATUS") {
            String a3 = d.b.f5054a.a(context, str);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (a3.equals("") || a3 == "") {
                return;
            }
            this.f5047b.put(str, new a.f(a3, currentTimeMillis2 + 7200000));
        }
    }
}
