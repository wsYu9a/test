package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.e */
/* loaded from: classes4.dex */
public class C0860e extends C0859d {

    /* renamed from: i */
    static HashMap<String, byte[]> f22725i;

    /* renamed from: j */
    static HashMap<String, HashMap<String, byte[]>> f22726j;

    /* renamed from: k */
    protected C0862g f22727k;

    /* renamed from: l */
    private int f22728l;

    public C0860e() {
        C0862g c0862g = new C0862g();
        this.f22727k = c0862g;
        this.f22728l = 0;
        c0862g.f22739d = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C0859d, com.tencent.bugly.proguard.C0858c
    public <T> void a(String str, T t10) {
        if (!str.startsWith(p1.b.f29697h)) {
            super.a(str, (String) t10);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public byte[] b() {
        C0862g c0862g = this.f22727k;
        if (c0862g.f22739d != 2) {
            if (c0862g.f22743h == null) {
                c0862g.f22743h = "";
            }
            if (c0862g.f22744i == null) {
                c0862g.f22744i = "";
            }
        } else {
            if (c0862g.f22743h.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f22727k.f22744i.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        C0867l c0867l = new C0867l(0);
        c0867l.a(this.f22713d);
        if (this.f22727k.f22739d == 2) {
            c0867l.a((Map) this.f22710a, 0);
        } else {
            c0867l.a((Map) this.f22716f, 0);
        }
        this.f22727k.f22745j = C0869n.a(c0867l.a());
        C0867l c0867l2 = new C0867l(0);
        c0867l2.a(this.f22713d);
        a(c0867l2);
        byte[] a10 = C0869n.a(c0867l2.a());
        int length = a10.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a10).flip();
        return allocate.array();
    }

    public void c(String str) {
        this.f22727k.f22743h = str;
    }

    @Override // com.tencent.bugly.proguard.C0859d
    public void a() {
        super.a();
        this.f22727k.f22739d = (short) 3;
    }

    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C0866k c0866k = new C0866k(bArr, 4);
                c0866k.a(this.f22713d);
                a(c0866k);
                C0862g c0862g = this.f22727k;
                if (c0862g.f22739d == 3) {
                    C0866k c0866k2 = new C0866k(c0862g.f22745j);
                    c0866k2.a(this.f22713d);
                    if (f22725i == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f22725i = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.f22716f = c0866k2.a((Map) f22725i, 0, false);
                    return;
                }
                C0866k c0866k3 = new C0866k(c0862g.f22745j);
                c0866k3.a(this.f22713d);
                if (f22726j == null) {
                    f22726j = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f22726j.put("", hashMap2);
                }
                this.f22710a = c0866k3.a((Map) f22726j, 0, false);
                this.f22711b = new HashMap<>();
                return;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void b(String str) {
        this.f22727k.f22744i = str;
    }

    public void a(int i10) {
        this.f22727k.f22742g = i10;
    }

    public void a(C0867l c0867l) {
        this.f22727k.a(c0867l);
    }

    public void a(C0866k c0866k) {
        this.f22727k.a(c0866k);
    }
}
