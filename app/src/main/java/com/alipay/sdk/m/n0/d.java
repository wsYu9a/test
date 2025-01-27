package com.alipay.sdk.m.n0;

import a3.b;
import a3.c;
import a3.f;
import android.content.Context;
import android.text.TextUtils;
import c3.a;
import com.google.common.primitives.SignedBytes;
import com.sigmob.sdk.archives.tar.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class d {

    /* renamed from: j */
    public static d f6560j;

    /* renamed from: a */
    public Context f6562a;

    /* renamed from: c */
    public e3.d f6564c;

    /* renamed from: d */
    public String f6565d;

    /* renamed from: e */
    public String f6566e;

    /* renamed from: f */
    public a f6567f;

    /* renamed from: g */
    public a f6568g;

    /* renamed from: i */
    public static final Object f6559i = new Object();

    /* renamed from: k */
    public static final String f6561k = ".UTSystemConfig" + File.separator + "Global";

    /* renamed from: b */
    public String f6563b = null;

    /* renamed from: h */
    public Pattern f6569h = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public d(Context context) {
        this.f6562a = null;
        this.f6564c = null;
        this.f6565d = "xx_utdid_key";
        this.f6566e = "xx_utdid_domain";
        this.f6567f = null;
        this.f6568g = null;
        this.f6562a = context;
        this.f6568g = new a(context, f6561k, "Alvin2", false, true);
        this.f6567f = new a(context, ".DataStorage", "ContextData", false, true);
        this.f6564c = new e3.d();
        this.f6565d = String.format("K_%d", Integer.valueOf(f.a(this.f6565d)));
        this.f6566e = String.format("D_%d", Integer.valueOf(f.a(this.f6566e)));
    }

    public static d a(Context context) {
        if (context != null && f6560j == null) {
            synchronized (f6559i) {
                try {
                    if (f6560j == null) {
                        d dVar = new d(context);
                        f6560j = dVar;
                        dVar.i();
                    }
                } finally {
                }
            }
        }
        return f6560j;
    }

    public static String c(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, SignedBytes.f10194a, b5.a.A, -95, -126, -82, -64, 113, 116, -16, -103, e.F, -30, 9, -39, 33, -80, -68, -78, -117, e.J, b5.a.H, -122, SignedBytes.f10194a, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(a3.e.b(bArr2), mac.getAlgorithm()));
        return b.e(mac.doFinal(bArr), 2);
    }

    public synchronized String b() {
        String g10 = g();
        this.f6563b = g10;
        if (!TextUtils.isEmpty(g10)) {
            return this.f6563b;
        }
        try {
            byte[] j10 = j();
            if (j10 != null) {
                String e10 = b.e(j10, 2);
                this.f6563b = e10;
                f(e10);
                String b10 = this.f6564c.b(j10);
                if (b10 != null) {
                    h(b10);
                }
                return this.f6563b;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public final boolean d(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f6569h.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    public synchronized String e() {
        String str = this.f6563b;
        if (str != null) {
            return str;
        }
        return b();
    }

    public final void f(String str) {
        a aVar;
        if (d(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (aVar = this.f6568g) == null) {
                return;
            }
            aVar.b("UTDID2", str);
            this.f6568g.c();
        }
    }

    public synchronized String g() {
        String k10 = k();
        if (d(k10)) {
            h(this.f6564c.a(k10));
            this.f6563b = k10;
            return k10;
        }
        String a10 = this.f6567f.a(this.f6565d);
        if (!f.b(a10)) {
            String a11 = new e3.e().a(a10);
            if (!d(a11)) {
                a11 = this.f6564c.c(a10);
            }
            if (d(a11) && !f.b(a11)) {
                this.f6563b = a11;
                f(a11);
                return this.f6563b;
            }
        }
        return null;
    }

    public final void h(String str) {
        a aVar;
        if (str == null || (aVar = this.f6567f) == null || str.equals(aVar.a(this.f6565d))) {
            return;
        }
        this.f6567f.b(this.f6565d, str);
        this.f6567f.c();
    }

    public final void i() {
        boolean z10;
        a aVar = this.f6568g;
        if (aVar != null) {
            if (f.b(aVar.a("UTDID2"))) {
                String a10 = this.f6568g.a("UTDID");
                if (!f.b(a10)) {
                    f(a10);
                }
            }
            boolean z11 = true;
            if (f.b(this.f6568g.a("DID"))) {
                z10 = false;
            } else {
                this.f6568g.e("DID");
                z10 = true;
            }
            if (!f.b(this.f6568g.a("EI"))) {
                this.f6568g.e("EI");
                z10 = true;
            }
            if (f.b(this.f6568g.a("SI"))) {
                z11 = z10;
            } else {
                this.f6568g.e("SI");
            }
            if (z11) {
                this.f6568g.c();
            }
        }
    }

    public final byte[] j() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nextInt = new Random().nextInt();
        byte[] a10 = c.a(currentTimeMillis);
        byte[] a11 = c.a(nextInt);
        byteArrayOutputStream.write(a10, 0, 4);
        byteArrayOutputStream.write(a11, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = a3.d.b(this.f6562a);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(c.a(f.a(str)), 0, 4);
        byteArrayOutputStream.write(c.a(f.a(c(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    public final String k() {
        a aVar = this.f6568g;
        if (aVar == null) {
            return null;
        }
        String a10 = aVar.a("UTDID2");
        if (f.b(a10) || this.f6564c.a(a10) == null) {
            return null;
        }
        return a10;
    }
}
