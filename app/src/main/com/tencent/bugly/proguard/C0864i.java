package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes4.dex */
public final class C0864i {

    /* renamed from: a */
    private StringBuilder f22749a;

    /* renamed from: b */
    private int f22750b;

    public C0864i(StringBuilder sb2, int i10) {
        this.f22749a = sb2;
        this.f22750b = i10;
    }

    private void a(String str) {
        for (int i10 = 0; i10 < this.f22750b; i10++) {
            this.f22749a.append('\t');
        }
        if (str != null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append(str);
            sb2.append(": ");
        }
    }

    public C0864i a(boolean z10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(z10 ? 'T' : 'F');
        sb2.append('\n');
        return this;
    }

    public C0864i a(byte b10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append((int) b10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(char c10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(c10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(short s10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append((int) s10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(int i10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(i10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(long j10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(j10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(float f10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(f10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(double d10, String str) {
        a(str);
        StringBuilder sb2 = this.f22749a;
        sb2.append(d10);
        sb2.append('\n');
        return this;
    }

    public C0864i a(String str, String str2) {
        a(str2);
        if (str == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
        } else {
            StringBuilder sb3 = this.f22749a;
            sb3.append(str);
            sb3.append('\n');
        }
        return this;
    }

    public C0864i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(bArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(bArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (byte b10 : bArr) {
            c0864i.a(b10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0864i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(sArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(sArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (short s10 : sArr) {
            c0864i.a(s10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0864i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(iArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(iArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (int i10 : iArr) {
            c0864i.a(i10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0864i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(jArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(jArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (long j10 : jArr) {
            c0864i.a(j10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0864i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(fArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(fArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (float f10 : fArr) {
            c0864i.a(f10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0864i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(dArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(dArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (double d10 : dArr) {
            c0864i.a(d10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public <K, V> C0864i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(map.size());
            sb3.append(", {}");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(map.size());
        sb4.append(", {");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        C0864i c0864i2 = new C0864i(this.f22749a, this.f22750b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            c0864i.a('(', (String) null);
            c0864i2.a((C0864i) entry.getKey(), (String) null);
            c0864i2.a((C0864i) entry.getValue(), (String) null);
            c0864i.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    public <T> C0864i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb3 = this.f22749a;
            sb3.append(tArr.length);
            sb3.append(", []");
            sb3.append('\n');
            return this;
        }
        StringBuilder sb4 = this.f22749a;
        sb4.append(tArr.length);
        sb4.append(", [");
        sb4.append('\n');
        C0864i c0864i = new C0864i(this.f22749a, this.f22750b + 1);
        for (T t10 : tArr) {
            c0864i.a((C0864i) t10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> C0864i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\t');
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> C0864i a(T t10, String str) {
        if (t10 == 0) {
            StringBuilder sb2 = this.f22749a;
            sb2.append("null");
            sb2.append('\n');
        } else if (t10 instanceof Byte) {
            a(((Byte) t10).byteValue(), str);
        } else if (t10 instanceof Boolean) {
            a(((Boolean) t10).booleanValue(), str);
        } else if (t10 instanceof Short) {
            a(((Short) t10).shortValue(), str);
        } else if (t10 instanceof Integer) {
            a(((Integer) t10).intValue(), str);
        } else if (t10 instanceof Long) {
            a(((Long) t10).longValue(), str);
        } else if (t10 instanceof Float) {
            a(((Float) t10).floatValue(), str);
        } else if (t10 instanceof Double) {
            a(((Double) t10).doubleValue(), str);
        } else if (t10 instanceof String) {
            a((String) t10, str);
        } else if (t10 instanceof Map) {
            a((Map) t10, str);
        } else if (t10 instanceof List) {
            a((Collection) t10, str);
        } else if (t10 instanceof AbstractC0868m) {
            a((AbstractC0868m) t10, str);
        } else if (t10 instanceof byte[]) {
            a((byte[]) t10, str);
        } else if (t10 instanceof boolean[]) {
            a((C0864i) t10, str);
        } else if (t10 instanceof short[]) {
            a((short[]) t10, str);
        } else if (t10 instanceof int[]) {
            a((int[]) t10, str);
        } else if (t10 instanceof long[]) {
            a((long[]) t10, str);
        } else if (t10 instanceof float[]) {
            a((float[]) t10, str);
        } else if (t10 instanceof double[]) {
            a((double[]) t10, str);
        } else if (t10.getClass().isArray()) {
            a((Object[]) t10, str);
        } else {
            throw new C0865j("write object error: unsupport type.");
        }
        return this;
    }

    public C0864i a(AbstractC0868m abstractC0868m, String str) {
        a('{', str);
        if (abstractC0868m == null) {
            StringBuilder sb2 = this.f22749a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            abstractC0868m.a(this.f22749a, this.f22750b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
