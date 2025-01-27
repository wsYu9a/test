package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: classes4.dex */
public class C0908l {

    /* renamed from: a */
    private ByteBuffer f25088a;

    /* renamed from: b */
    protected String f25089b;

    public C0908l(int i2) {
        this.f25089b = com.martian.mibook.lib.local.c.b.b.f13937d;
        this.f25088a = ByteBuffer.allocate(i2);
    }

    public ByteBuffer a() {
        return this.f25088a;
    }

    public byte[] b() {
        byte[] bArr = new byte[this.f25088a.position()];
        System.arraycopy(this.f25088a.array(), 0, bArr, 0, this.f25088a.position());
        return bArr;
    }

    public void a(int i2) {
        if (this.f25088a.remaining() < i2) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f25088a.capacity() + i2) * 2);
            allocate.put(this.f25088a.array(), 0, this.f25088a.position());
            this.f25088a = allocate;
        }
    }

    public void b(byte b2, int i2) {
        if (i2 < 15) {
            this.f25088a.put((byte) (b2 | (i2 << 4)));
        } else if (i2 < 256) {
            this.f25088a.put((byte) (b2 | 240));
            this.f25088a.put((byte) i2);
        } else {
            throw new C0906j("tag is too large: " + i2);
        }
    }

    public C0908l() {
        this(128);
    }

    public void a(boolean z, int i2) {
        a(z ? (byte) 1 : (byte) 0, i2);
    }

    public void a(byte b2, int i2) {
        a(3);
        if (b2 == 0) {
            b((byte) 12, i2);
        } else {
            b((byte) 0, i2);
            this.f25088a.put(b2);
        }
    }

    public void a(short s, int i2) {
        a(4);
        if (s >= -128 && s <= 127) {
            a((byte) s, i2);
        } else {
            b((byte) 1, i2);
            this.f25088a.putShort(s);
        }
    }

    public void a(int i2, int i3) {
        a(6);
        if (i2 >= -32768 && i2 <= 32767) {
            a((short) i2, i3);
        } else {
            b((byte) 2, i3);
            this.f25088a.putInt(i2);
        }
    }

    public void a(long j2, int i2) {
        a(10);
        if (j2 >= -2147483648L && j2 <= 2147483647L) {
            a((int) j2, i2);
        } else {
            b((byte) 3, i2);
            this.f25088a.putLong(j2);
        }
    }

    public void a(float f2, int i2) {
        a(6);
        b((byte) 4, i2);
        this.f25088a.putFloat(f2);
    }

    public void a(double d2, int i2) {
        a(10);
        b((byte) 5, i2);
        this.f25088a.putDouble(d2);
    }

    public void a(String str, int i2) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f25089b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i2);
            this.f25088a.putInt(bytes.length);
            this.f25088a.put(bytes);
        } else {
            b((byte) 6, i2);
            this.f25088a.put((byte) bytes.length);
            this.f25088a.put(bytes);
        }
    }

    public <K, V> void a(Map<K, V> map, int i2) {
        a(8);
        b((byte) 8, i2);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public void a(boolean[] zArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(zArr.length, 0);
        for (boolean z : zArr) {
            a(z, 0);
        }
    }

    public void a(byte[] bArr, int i2) {
        a(bArr.length + 8);
        b((byte) 13, i2);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f25088a.put(bArr);
    }

    public void a(short[] sArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(sArr.length, 0);
        for (short s : sArr) {
            a(s, 0);
        }
    }

    public void a(int[] iArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(iArr.length, 0);
        for (int i3 : iArr) {
            a(i3, 0);
        }
    }

    public void a(long[] jArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(jArr.length, 0);
        for (long j2 : jArr) {
            a(j2, 0);
        }
    }

    public void a(float[] fArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(fArr.length, 0);
        for (float f2 : fArr) {
            a(f2, 0);
        }
    }

    public void a(double[] dArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(dArr.length, 0);
        for (double d2 : dArr) {
            a(d2, 0);
        }
    }

    private void a(Object[] objArr, int i2) {
        a(8);
        b((byte) 9, i2);
        a(objArr.length, 0);
        for (Object obj : objArr) {
            a(obj, 0);
        }
    }

    public <T> void a(Collection<T> collection, int i2) {
        a(8);
        b((byte) 9, i2);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                a(it.next(), 0);
            }
        }
    }

    public void a(AbstractC0909m abstractC0909m, int i2) {
        a(2);
        b((byte) 10, i2);
        abstractC0909m.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public void a(Object obj, int i2) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i2);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue(), i2);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i2);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i2);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i2);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i2);
            return;
        }
        if (obj instanceof Double) {
            a(((Double) obj).doubleValue(), i2);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i2);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i2);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i2);
            return;
        }
        if (obj instanceof AbstractC0909m) {
            a((AbstractC0909m) obj, i2);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i2);
            return;
        }
        if (obj instanceof boolean[]) {
            a((boolean[]) obj, i2);
            return;
        }
        if (obj instanceof short[]) {
            a((short[]) obj, i2);
            return;
        }
        if (obj instanceof int[]) {
            a((int[]) obj, i2);
            return;
        }
        if (obj instanceof long[]) {
            a((long[]) obj, i2);
            return;
        }
        if (obj instanceof float[]) {
            a((float[]) obj, i2);
            return;
        }
        if (obj instanceof double[]) {
            a((double[]) obj, i2);
            return;
        }
        if (obj.getClass().isArray()) {
            a((Object[]) obj, i2);
        } else {
            if (obj instanceof Collection) {
                a((Collection) obj, i2);
                return;
            }
            throw new C0906j("write object error: unsupport type. " + obj.getClass());
        }
    }

    public int a(String str) {
        this.f25089b = str;
        return 0;
    }
}
