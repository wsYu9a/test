package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.i */
/* loaded from: classes4.dex */
public final class C0905i {

    /* renamed from: a */
    private StringBuilder f25077a;

    /* renamed from: b */
    private int f25078b;

    public C0905i(StringBuilder sb, int i2) {
        this.f25078b = 0;
        this.f25077a = sb;
        this.f25078b = i2;
    }

    private void a(String str) {
        for (int i2 = 0; i2 < this.f25078b; i2++) {
            this.f25077a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f25077a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public C0905i a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public C0905i a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append((int) b2);
        sb.append('\n');
        return this;
    }

    public C0905i a(char c2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(c2);
        sb.append('\n');
        return this;
    }

    public C0905i a(short s, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public C0905i a(int i2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(i2);
        sb.append('\n');
        return this;
    }

    public C0905i a(long j2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(j2);
        sb.append('\n');
        return this;
    }

    public C0905i a(float f2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(f2);
        sb.append('\n');
        return this;
    }

    public C0905i a(double d2, String str) {
        a(str);
        StringBuilder sb = this.f25077a;
        sb.append(d2);
        sb.append('\n');
        return this;
    }

    public C0905i a(String str, String str2) {
        a(str2);
        if (str == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
        } else {
            StringBuilder sb2 = this.f25077a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    public C0905i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(bArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(bArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (byte b2 : bArr) {
            c0905i.a(b2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0905i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(sArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(sArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (short s : sArr) {
            c0905i.a(s, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0905i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(iArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(iArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (int i2 : iArr) {
            c0905i.a(i2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0905i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(jArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(jArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (long j2 : jArr) {
            c0905i.a(j2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0905i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(fArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(fArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (float f2 : fArr) {
            c0905i.a(f2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public C0905i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(dArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(dArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (double d2 : dArr) {
            c0905i.a(d2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    public <K, V> C0905i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(map.size());
            sb2.append(", {}");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(map.size());
        sb3.append(", {");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        C0905i c0905i2 = new C0905i(this.f25077a, this.f25078b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            c0905i.a('(', (String) null);
            c0905i2.a((C0905i) entry.getKey(), (String) null);
            c0905i2.a((C0905i) entry.getValue(), (String) null);
            c0905i.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    public <T> C0905i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f25077a;
            sb2.append(tArr.length);
            sb2.append(", []");
            sb2.append('\n');
            return this;
        }
        StringBuilder sb3 = this.f25077a;
        sb3.append(tArr.length);
        sb3.append(", [");
        sb3.append('\n');
        C0905i c0905i = new C0905i(this.f25077a, this.f25078b + 1);
        for (T t : tArr) {
            c0905i.a((C0905i) t, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> C0905i a(Collection<T> collection, String str) {
        if (collection == null) {
            a(str);
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\t');
            return this;
        }
        return a(collection.toArray(), str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> C0905i a(T t, String str) {
        if (t == 0) {
            StringBuilder sb = this.f25077a;
            sb.append("null");
            sb.append('\n');
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((Collection) t, str);
        } else if (t instanceof AbstractC0909m) {
            a((AbstractC0909m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((C0905i) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
        } else {
            throw new C0906j("write object error: unsupport type.");
        }
        return this;
    }

    public C0905i a(AbstractC0909m abstractC0909m, String str) {
        a('{', str);
        if (abstractC0909m == null) {
            StringBuilder sb = this.f25077a;
            sb.append('\t');
            sb.append("null");
        } else {
            abstractC0909m.a(this.f25077a, this.f25078b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
