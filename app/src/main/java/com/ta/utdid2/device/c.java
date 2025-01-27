package com.ta.utdid2.device;

import android.content.Context;
import android.provider.Settings;
import b.i.a.a.a.g;
import b.i.a.a.a.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private static c f24555b;

    /* renamed from: d */
    private Context f24557d;

    /* renamed from: f */
    private e f24559f;

    /* renamed from: g */
    private String f24560g;

    /* renamed from: h */
    private String f24561h;

    /* renamed from: i */
    private b.i.a.b.a.c f24562i;

    /* renamed from: j */
    private b.i.a.b.a.c f24563j;

    /* renamed from: a */
    private static final Object f24554a = new Object();

    /* renamed from: c */
    private static final String f24556c = ".UTSystemConfig" + File.separator + "Global";

    /* renamed from: e */
    private String f24558e = null;
    private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public c(Context context) {
        this.f24557d = null;
        this.f24559f = null;
        this.f24560g = "xx_utdid_key";
        this.f24561h = "xx_utdid_domain";
        this.f24562i = null;
        this.f24563j = null;
        this.f24557d = context;
        this.f24563j = new b.i.a.b.a.c(context, f24556c, "Alvin2", false, true);
        this.f24562i = new b.i.a.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f24559f = new e();
        this.f24560g = String.format("K_%d", Integer.valueOf(i.a(this.f24560g)));
        this.f24561h = String.format("D_%d", Integer.valueOf(i.a(this.f24561h)));
    }

    public static c a(Context context) {
        if (context != null && f24555b == null) {
            synchronized (f24554a) {
                if (f24555b == null) {
                    c cVar = new c(context);
                    f24555b = cVar;
                    cVar.e();
                }
            }
        }
        return f24555b;
    }

    private final byte[] b() throws Exception {
        String sb;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a2 = b.i.a.a.a.e.a(currentTimeMillis);
        byte[] a3 = b.i.a.a.a.e.a(nextInt);
        byteArrayOutputStream.write(a2, 0, 4);
        byteArrayOutputStream.write(a3, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            sb = g.a(this.f24557d);
        } catch (Exception unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(new Random().nextInt());
            sb = sb2.toString();
        }
        byteArrayOutputStream.write(b.i.a.a.a.e.a(i.a(sb)), 0, 4);
        byteArrayOutputStream.write(b.i.a.a.a.e.a(i.a(c(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private static String c(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return b.i.a.a.a.b.f(mac.doFinal(bArr), 2);
    }

    private boolean d(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.k.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private void e() {
        b.i.a.b.a.c cVar = this.f24563j;
        if (cVar != null) {
            if (i.b(cVar.h("UTDID2"))) {
                String h2 = this.f24563j.h("UTDID");
                if (!i.b(h2)) {
                    f(h2);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!i.b(this.f24563j.h("DID"))) {
                this.f24563j.j("DID");
                z = true;
            }
            if (!i.b(this.f24563j.h("EI"))) {
                this.f24563j.j("EI");
                z = true;
            }
            if (i.b(this.f24563j.h("SI"))) {
                z2 = z;
            } else {
                this.f24563j.j("SI");
            }
            if (z2) {
                this.f24563j.g();
            }
        }
    }

    private void f(String str) {
        b.i.a.b.a.c cVar;
        if (d(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (cVar = this.f24563j) == null) {
                return;
            }
            cVar.i("UTDID2", str);
            this.f24563j.g();
        }
    }

    private String g() {
        b.i.a.b.a.c cVar = this.f24563j;
        if (cVar == null) {
            return null;
        }
        String h2 = cVar.h("UTDID2");
        if (i.b(h2) || this.f24559f.a(h2) == null) {
            return null;
        }
        return h2;
    }

    private void h(String str) {
        b.i.a.b.a.c cVar;
        if (str == null || (cVar = this.f24562i) == null || str.equals(cVar.h(this.f24560g))) {
            return;
        }
        this.f24562i.i(this.f24560g, str);
        this.f24562i.g();
    }

    private void k(String str) {
        if (this.f24557d.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && d(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.f24557d.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (d(str2)) {
                    return;
                }
                try {
                    Settings.System.putString(this.f24557d.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private void l(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.f24557d.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str2 = null;
        }
        if (str.equals(str2)) {
            return;
        }
        try {
            Settings.System.putString(this.f24557d.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception unused2) {
        }
    }

    private void m(String str) {
        if (this.f24557d.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") != 0 || str == null) {
            return;
        }
        l(str);
    }

    public synchronized String i() {
        String str = this.f24558e;
        if (str != null) {
            return str;
        }
        return j();
    }

    public synchronized String j() {
        String str;
        String str2 = "";
        try {
            str2 = Settings.System.getString(this.f24557d.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (d(str2)) {
            return str2;
        }
        f fVar = new f();
        boolean z = false;
        try {
            str = Settings.System.getString(this.f24557d.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            str = null;
        }
        if (i.b(str)) {
            z = true;
        } else {
            String b2 = fVar.b(str);
            if (d(b2)) {
                k(b2);
                return b2;
            }
            String a2 = fVar.a(str);
            if (d(a2)) {
                String a3 = this.f24559f.a(a2);
                if (!i.b(a3)) {
                    m(a3);
                    try {
                        str = Settings.System.getString(this.f24557d.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String b3 = this.f24559f.b(str);
            if (d(b3)) {
                this.f24558e = b3;
                f(b3);
                h(str);
                k(this.f24558e);
                return this.f24558e;
            }
        }
        String g2 = g();
        if (d(g2)) {
            String a4 = this.f24559f.a(g2);
            if (z) {
                m(a4);
            }
            k(g2);
            h(a4);
            this.f24558e = g2;
            return g2;
        }
        String h2 = this.f24562i.h(this.f24560g);
        if (!i.b(h2)) {
            String a5 = fVar.a(h2);
            if (!d(a5)) {
                a5 = this.f24559f.b(h2);
            }
            if (d(a5)) {
                String a6 = this.f24559f.a(a5);
                if (!i.b(a5)) {
                    this.f24558e = a5;
                    if (z) {
                        m(a6);
                    }
                    f(this.f24558e);
                    return this.f24558e;
                }
            }
        }
        try {
            byte[] b4 = b();
            if (b4 != null) {
                String f2 = b.i.a.a.a.b.f(b4, 2);
                this.f24558e = f2;
                f(f2);
                String c2 = this.f24559f.c(b4);
                if (c2 != null) {
                    if (z) {
                        m(c2);
                    }
                    h(c2);
                }
                return this.f24558e;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }
}
