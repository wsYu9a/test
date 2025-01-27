package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes4.dex */
public class C0859d extends C0858c {

    /* renamed from: f */
    protected HashMap<String, byte[]> f22716f = null;

    /* renamed from: g */
    private HashMap<String, Object> f22717g = new HashMap<>();

    /* renamed from: h */
    C0866k f22718h = new C0866k();

    private void c(String str, Object obj) {
        this.f22717g.put(str, obj);
    }

    @Override // com.tencent.bugly.proguard.C0858c
    public /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public <T> T b(String str, T t10) throws C0857b {
        HashMap<String, byte[]> hashMap = this.f22716f;
        if (hashMap != null) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            if (this.f22717g.containsKey(str)) {
                return (T) this.f22717g.get(str);
            }
            try {
                T t11 = (T) a(this.f22716f.get(str), t10);
                if (t11 != null) {
                    c(str, t11);
                }
                return t11;
            } catch (Exception e10) {
                throw new C0857b(e10);
            }
        }
        if (!this.f22710a.containsKey(str)) {
            return null;
        }
        if (this.f22717g.containsKey(str)) {
            return (T) this.f22717g.get(str);
        }
        byte[] bArr = new byte[0];
        Iterator<Map.Entry<String, byte[]>> it = this.f22710a.get(str).entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            next.getKey();
            bArr = next.getValue();
        }
        try {
            this.f22718h.a(bArr);
            this.f22718h.a(this.f22713d);
            T t12 = (T) this.f22718h.a((C0866k) t10, 0, true);
            c(str, t12);
            return t12;
        } catch (Exception e11) {
            throw new C0857b(e11);
        }
    }

    public void a() {
        this.f22716f = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C0858c
    public <T> void a(String str, T t10) {
        if (this.f22716f == null) {
            super.a(str, (String) t10);
            return;
        }
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t10 != null) {
            if (!(t10 instanceof Set)) {
                C0867l c0867l = new C0867l();
                c0867l.a(this.f22713d);
                c0867l.a(t10, 0);
                this.f22716f.put(str, C0869n.a(c0867l.a()));
                return;
            }
            throw new IllegalArgumentException("can not support Set");
        }
        throw new IllegalArgumentException("put value can not is null");
    }

    private Object a(byte[] bArr, Object obj) {
        this.f22718h.a(bArr);
        this.f22718h.a(this.f22713d);
        return this.f22718h.a((C0866k) obj, 0, true);
    }
}
