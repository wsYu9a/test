package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.e */
/* loaded from: classes4.dex */
public class C0901e extends C0900d {

    /* renamed from: i */
    static HashMap<String, byte[]> f25058i;

    /* renamed from: j */
    static HashMap<String, HashMap<String, byte[]>> f25059j;
    protected C0903g k;
    private int l;

    public C0901e() {
        C0903g c0903g = new C0903g();
        this.k = c0903g;
        this.l = 0;
        c0903g.f25070d = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C0900d, com.tencent.bugly.proguard.C0899c
    public <T> void a(String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, (String) t);
            return;
        }
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public byte[] b() {
        C0903g c0903g = this.k;
        if (c0903g.f25070d != 2) {
            if (c0903g.f25074h == null) {
                c0903g.f25074h = "";
            }
            if (c0903g.f25075i == null) {
                c0903g.f25075i = "";
            }
        } else {
            if (c0903g.f25074h.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.k.f25075i.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        }
        C0908l c0908l = new C0908l(0);
        c0908l.a(this.f25046d);
        if (this.k.f25070d == 2) {
            c0908l.a((Map) this.f25043a, 0);
        } else {
            c0908l.a((Map) this.f25049f, 0);
        }
        this.k.f25076j = C0910n.a(c0908l.a());
        C0908l c0908l2 = new C0908l(0);
        c0908l2.a(this.f25046d);
        a(c0908l2);
        byte[] a2 = C0910n.a(c0908l2.a());
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    public void c(String str) {
        this.k.f25074h = str;
    }

    @Override // com.tencent.bugly.proguard.C0900d
    public void a() {
        super.a();
        this.k.f25070d = (short) 3;
    }

    public void a(byte[] bArr) {
        if (bArr.length >= 4) {
            try {
                C0907k c0907k = new C0907k(bArr, 4);
                c0907k.a(this.f25046d);
                a(c0907k);
                C0903g c0903g = this.k;
                if (c0903g.f25070d == 3) {
                    C0907k c0907k2 = new C0907k(c0903g.f25076j);
                    c0907k2.a(this.f25046d);
                    if (f25058i == null) {
                        HashMap<String, byte[]> hashMap = new HashMap<>();
                        f25058i = hashMap;
                        hashMap.put("", new byte[0]);
                    }
                    this.f25049f = c0907k2.a((Map) f25058i, 0, false);
                    return;
                }
                C0907k c0907k3 = new C0907k(c0903g.f25076j);
                c0907k3.a(this.f25046d);
                if (f25059j == null) {
                    f25059j = new HashMap<>();
                    HashMap<String, byte[]> hashMap2 = new HashMap<>();
                    hashMap2.put("", new byte[0]);
                    f25059j.put("", hashMap2);
                }
                this.f25043a = c0907k3.a((Map) f25059j, 0, false);
                this.f25044b = new HashMap<>();
                return;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new IllegalArgumentException("decode package must include size head");
    }

    public void b(String str) {
        this.k.f25075i = str;
    }

    public void a(int i2) {
        this.k.f25073g = i2;
    }

    public void a(C0908l c0908l) {
        this.k.a(c0908l);
    }

    public void a(C0907k c0907k) {
        this.k.a(c0907k);
    }
}
