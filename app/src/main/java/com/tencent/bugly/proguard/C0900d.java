package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes4.dex */
public class C0900d extends C0899c {

    /* renamed from: f */
    protected HashMap<String, byte[]> f25049f = null;

    /* renamed from: g */
    private HashMap<String, Object> f25050g = new HashMap<>();

    /* renamed from: h */
    C0907k f25051h = new C0907k();

    private void c(String str, Object obj) {
        this.f25050g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.C0899c
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public <T> T b(String str, T t) throws C0898b {
        HashMap<String, byte[]> hashMap = this.f25049f;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f25050g.containsKey(str)) {
                return (T) this.f25050g.get(str);
            }
            try {
                T t2 = (T) a(this.f25049f.get(str), t);
                if (t2 != null) {
                    c(str, t2);
                }
                return t2;
            } catch (Exception e2) {
                throw new C0898b(e2);
            }
        }
        if (!this.f25043a.containsKey(str)) {
            return null;
        }
        if (this.f25050g.containsKey(str)) {
            return (T) this.f25050g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f25043a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f25051h.a(bArr);
            this.f25051h.a(this.f25046d);
            T t3 = (T) this.f25051h.a((C0907k) t, 0, true);
            c(str, t3);
            return t3;
        } catch (Exception e3) {
            throw new C0898b(e3);
        }
    }

    public void a() {
        this.f25049f = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C0899c
    public <T> void a(String str, T t) {
        if (this.f25049f == null) {
            super.a(str, (String) t);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t != null) {
            if (!(t instanceof Set)) {
                C0908l c0908l = new C0908l();
                c0908l.a(this.f25046d);
                c0908l.a(t, 0);
                this.f25049f.put(str, C0910n.a(c0908l.a()));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private Object a(byte[] bArr, Object obj) {
        this.f25051h.a(bArr);
        this.f25051h.a(this.f25046d);
        return this.f25051h.a((C0907k) obj, 0, true);
    }
}
