package com.opos.mobad.model.a.a;

import android.content.Context;
import android.content.pm.Signature;
import com.opos.cmn.i.k;
import com.opos.mobad.b.a.ad;
import com.opos.mobad.b.a.e;
import com.opos.mobad.b.a.z;
import com.opos.mobad.model.b.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class b implements com.opos.mobad.model.a.b {

    /* renamed from: a */
    private List<e> f21474a;

    /* renamed from: b */
    private Context f21475b;

    /* renamed from: com.opos.mobad.model.a.a.b$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.f21474a = bVar.a(bVar.f21475b);
        }
    }

    public b(Context context) {
        if (context == null) {
            return;
        }
        this.f21475b = context.getApplicationContext();
        if (com.opos.mobad.cmn.a.f20047a.booleanValue()) {
            com.opos.cmn.an.i.e.a(new Runnable() { // from class: com.opos.mobad.model.a.a.b.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    bVar.f21474a = bVar.a(bVar.f21475b);
                }
            });
        }
    }

    private z.b a(int i2) {
        z.b bVar = z.b.UNKNOWN;
        switch (i2) {
            case 1:
                return z.b.BANNER;
            case 2:
                return z.b.POP_WINDOW;
            case 3:
            case 6:
                return z.b.SPLASH_SCREEN;
            case 4:
                return z.b.RAW;
            case 5:
                return z.b.REWARD_VIDEO;
            default:
                return bVar;
        }
    }

    private List<e> a() {
        List<e> list = this.f21474a;
        if (list == null || list.size() <= 0) {
            this.f21474a = a(this.f21475b);
        }
        return this.f21474a;
    }

    public List<e> a(Context context) {
        Signature[] a2;
        String str;
        if (context == null || (a2 = k.a(context)) == null || a2.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(a2.length);
        for (Signature signature : a2) {
            try {
                str = k.a("sha1", signature);
            } catch (Exception unused) {
                str = "";
            }
            com.opos.cmn.an.f.a.a("", "md5Sign=,sha1Sign=" + str + ",sha256Sign=");
            arrayList.add(new e("", str, ""));
        }
        return arrayList;
    }

    private ad b(int i2) {
        return i2 == 3 ? ad.SPLASH : i2 == 6 ? ad.HOT_SPLASH : ad.UNKNOWN;
    }

    @Override // com.opos.mobad.model.a.b
    public d a(byte[] bArr) throws IOException {
        com.opos.mobad.b.a.d a2 = com.opos.mobad.b.a.d.f19667c.a(bArr);
        if (a2 == null) {
            return null;
        }
        com.opos.cmn.an.f.a.a("", "parseResponse = ", a2);
        return new d(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x009a  */
    @Override // com.opos.mobad.model.a.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(com.opos.mobad.model.b.c r13) {
        /*
            r12 = this;
            com.opos.mobad.b.a.g r0 = com.opos.mobad.service.h.a.e()
            com.opos.mobad.b.a.ab r1 = com.opos.mobad.service.h.a.d()
            com.opos.mobad.b.a.aa$a r2 = new com.opos.mobad.b.a.aa$a
            r2.<init>()
            int r3 = r13.f()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.opos.mobad.b.a.aa$a r2 = r2.a(r3)
            int r3 = r13.g()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.opos.mobad.b.a.aa$a r2 = r2.b(r3)
            com.opos.mobad.b.a.aa r2 = r2.b()
            com.opos.mobad.b.a.z$a r3 = new com.opos.mobad.b.a.z$a
            r3.<init>()
            java.lang.String r4 = r13.d()
            com.opos.mobad.b.a.z$a r3 = r3.a(r4)
            int r4 = r13.e()
            com.opos.mobad.b.a.z$b r4 = r12.a(r4)
            com.opos.mobad.b.a.z$a r3 = r3.a(r4)
            com.opos.mobad.b.a.z$a r2 = r3.a(r2)
            int r3 = r13.e()
            com.opos.mobad.b.a.ad r3 = r12.b(r3)
            com.opos.mobad.b.a.z$a r2 = r2.a(r3)
            int r3 = r13.h()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            com.opos.mobad.b.a.z$a r2 = r2.a(r3)
            com.opos.mobad.b.a.z r2 = r2.b()
            android.content.Context r3 = r12.f21475b
            com.opos.mobad.b.a.m r3 = com.opos.mobad.service.h.a.a(r3)
            android.content.Context r4 = r12.f21475b
            com.opos.mobad.b.a.w r4 = com.opos.mobad.service.h.a.b(r4)
            com.opos.mobad.b.a.u r5 = com.opos.mobad.service.h.a.a()
            com.opos.mobad.b.a.ah r6 = com.opos.mobad.service.h.a.b()
            com.opos.mobad.b.a.c$a r7 = new com.opos.mobad.b.a.c$a
            r7.<init>()
            int r8 = r13.b()
            r9 = 2
            r10 = 1
            if (r8 != r10) goto L89
            com.opos.mobad.b.a.ac r8 = com.opos.mobad.b.a.ac.MODE_ONE
        L85:
            r7.a(r8)
            goto L92
        L89:
            int r8 = r13.b()
            if (r8 != r9) goto L92
            com.opos.mobad.b.a.ac r8 = com.opos.mobad.b.a.ac.MODE_TWO
            goto L85
        L92:
            java.lang.Boolean r8 = com.opos.mobad.cmn.a.f20047a
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto Lac
            java.util.List r8 = r12.a()
            if (r8 == 0) goto La9
            int r11 = r8.size()
            if (r11 <= 0) goto La9
            r7.a(r8)
        La9:
            com.opos.mobad.b.a.c$c r8 = com.opos.mobad.b.a.c.EnumC0425c.SDK
            goto Lae
        Lac:
            com.opos.mobad.b.a.c$c r8 = com.opos.mobad.b.a.c.EnumC0425c.QG
        Lae:
            r7.a(r8)
            int r8 = r13.c()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            com.opos.mobad.b.a.c$a r7 = r7.a(r8)
            com.opos.mobad.b.a.c$a r0 = r7.a(r0)
            com.opos.mobad.b.a.c$a r0 = r0.a(r1)
            com.opos.mobad.b.a.c$a r0 = r0.a(r2)
            com.opos.mobad.b.a.c$a r0 = r0.a(r3)
            com.opos.mobad.service.f.a r1 = com.opos.mobad.service.f.a.a()
            java.lang.String r1 = r1.r()
            com.opos.mobad.b.a.c$a r0 = r0.a(r1)
            com.opos.mobad.b.a.c$a r0 = r0.a(r4)
            com.opos.mobad.b.a.c$a r0 = r0.a(r5)
            com.opos.mobad.b.a.c$a r0 = r0.a(r6)
            com.opos.mobad.service.e.a r1 = com.opos.mobad.service.e.a.a()
            boolean r1 = r1.j()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.opos.mobad.b.a.c$a r0 = r0.a(r1)
            java.lang.String r1 = r13.a()
            com.opos.mobad.b.a.c$a r0 = r0.b(r1)
            com.opos.mobad.service.e.a r1 = com.opos.mobad.service.e.a.a()
            boolean r1 = r1.d()
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            com.opos.mobad.b.a.c$a r0 = r0.b(r1)
            com.opos.mobad.service.f.a r1 = com.opos.mobad.service.f.a.a()
            java.lang.String r1 = r1.u()
            com.opos.mobad.b.a.c$a r0 = r0.c(r1)
            com.opos.mobad.service.a.e r1 = com.opos.mobad.service.f.b()
            long r1 = r1.g()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            com.opos.mobad.b.a.c$a r0 = r0.a(r1)
            java.lang.String r13 = r13.i()
            com.opos.mobad.b.a.c$a r13 = r0.d(r13)
            com.opos.mobad.b.a.c r13 = r13.b()
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r1 = 0
            java.lang.String r2 = "FetchAdRequest = "
            r0[r1] = r2
            r0[r10] = r13
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r1, r0)
            com.heytap.nearx.a.a.e<com.opos.mobad.b.a.c> r0 = com.opos.mobad.b.a.c.f19646c
            byte[] r13 = r0.b(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.model.a.a.b.a(com.opos.mobad.model.b.c):byte[]");
    }
}
