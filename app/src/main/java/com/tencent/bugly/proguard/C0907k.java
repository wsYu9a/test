package com.tencent.bugly.proguard;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.k */
/* loaded from: classes4.dex */
public final class C0907k {

    /* renamed from: a */
    private ByteBuffer f25079a;

    /* renamed from: b */
    protected String f25080b = com.martian.mibook.lib.local.c.b.b.f13937d;

    /* renamed from: com.tencent.bugly.proguard.k$a */
    public static class a {

        /* renamed from: a */
        public byte f25081a;

        /* renamed from: b */
        public int f25082b;
    }

    public C0907k() {
    }

    private int b(a aVar) {
        return a(aVar, this.f25079a.duplicate());
    }

    public void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f25079a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f25079a = ByteBuffer.wrap(bArr);
    }

    private void b(int i2) {
        ByteBuffer byteBuffer = this.f25079a;
        byteBuffer.position(byteBuffer.position() + i2);
    }

    public C0907k(byte[] bArr) {
        this.f25079a = ByteBuffer.wrap(bArr);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f25081a);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.f25081a = (byte) (b2 & 15);
        int i2 = (b2 & 240) >> 4;
        aVar.f25082b = i2;
        if (i2 != 15) {
            return 1;
        }
        aVar.f25082b = byteBuffer.get();
        return 2;
    }

    public C0907k(byte[] bArr, int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f25079a = wrap;
        wrap.position(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t.getClass(), a2));
                for (int i3 = 0; i3 < a2; i3++) {
                    tArr[i3] = a((C0907k) t, 0, true);
                }
                return tArr;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public void a(a aVar) {
        a(aVar, this.f25079a);
    }

    public boolean a(int i2) {
        int i3;
        try {
            a aVar = new a();
            while (true) {
                int b2 = b(aVar);
                i3 = aVar.f25082b;
                if (i2 <= i3 || aVar.f25081a == 11) {
                    break;
                }
                b(b2);
                a(aVar.f25081a);
            }
            return i2 == i3;
        } catch (C0904h | BufferUnderflowException unused) {
            return false;
        }
    }

    public void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f25081a);
        } while (aVar.f25081a != 11);
    }

    private void a(byte b2) {
        int i2 = 0;
        switch (b2) {
            case 0:
                b(1);
                return;
            case 1:
                b(2);
                return;
            case 2:
                b(4);
                return;
            case 3:
                b(8);
                return;
            case 4:
                b(4);
                return;
            case 5:
                b(8);
                return;
            case 6:
                int i3 = this.f25079a.get();
                if (i3 < 0) {
                    i3 += 256;
                }
                b(i3);
                return;
            case 7:
                b(this.f25079a.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i2 < a2 * 2) {
                    b();
                    i2++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i2 < a3) {
                    b();
                    i2++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f25081a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new C0904h("skipField with invalid type, type value: " + ((int) b2) + ", " + ((int) aVar.f25081a));
            default:
                throw new C0904h("invalid type.");
        }
    }

    public boolean a(boolean z, int i2, boolean z2) {
        return a((byte) 0, i2, z2) != 0;
    }

    public byte a(byte b2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return b2;
        }
        a aVar = new a();
        a(aVar);
        byte b3 = aVar.f25081a;
        if (b3 == 0) {
            return this.f25079a.get();
        }
        if (b3 == 12) {
            return (byte) 0;
        }
        throw new C0904h("type mismatch.");
    }

    public short a(short s, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return s;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 0) {
            return this.f25079a.get();
        }
        if (b2 == 1) {
            return this.f25079a.getShort();
        }
        if (b2 == 12) {
            return (short) 0;
        }
        throw new C0904h("type mismatch.");
    }

    public int a(int i2, int i3, boolean z) {
        if (!a(i3)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return i2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 0) {
            return this.f25079a.get();
        }
        if (b2 == 1) {
            return this.f25079a.getShort();
        }
        if (b2 == 2) {
            return this.f25079a.getInt();
        }
        if (b2 == 12) {
            return 0;
        }
        throw new C0904h("type mismatch.");
    }

    public long a(long j2, int i2, boolean z) {
        int i3;
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return j2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 12) {
            return 0L;
        }
        if (b2 == 0) {
            i3 = this.f25079a.get();
        } else if (b2 == 1) {
            i3 = this.f25079a.getShort();
        } else {
            if (b2 != 2) {
                if (b2 == 3) {
                    return this.f25079a.getLong();
                }
                throw new C0904h("type mismatch.");
            }
            i3 = this.f25079a.getInt();
        }
        return i3;
    }

    public float a(float f2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return f2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 4) {
            return this.f25079a.getFloat();
        }
        if (b2 == 12) {
            return 0.0f;
        }
        throw new C0904h("type mismatch.");
    }

    public double a(double d2, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return d2;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 4) {
            return this.f25079a.getFloat();
        }
        if (b2 == 5) {
            return this.f25079a.getDouble();
        }
        if (b2 == 12) {
            return 0.0d;
        }
        throw new C0904h("type mismatch.");
    }

    public String a(int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 6) {
            int i3 = this.f25079a.get();
            if (i3 < 0) {
                i3 += 256;
            }
            byte[] bArr = new byte[i3];
            this.f25079a.get(bArr);
            try {
                return new String(bArr, this.f25080b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b2 == 7) {
            int i4 = this.f25079a.getInt();
            if (i4 <= 104857600 && i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                this.f25079a.get(bArr2);
                try {
                    return new String(bArr2, this.f25080b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C0904h("String too long: " + i4);
        }
        throw new C0904h("type mismatch.");
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i2, boolean z) {
        return (HashMap) a(new HashMap(), map, i2, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i2, boolean z) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i2)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f25081a == 8) {
                    int a2 = a(0, 0, true);
                    if (a2 < 0) {
                        throw new C0904h("size invalid: " + a2);
                    }
                    for (int i3 = 0; i3 < a2; i3++) {
                        map.put(a((C0907k) key, 0, true), a((C0907k) value, 1, true));
                    }
                } else {
                    throw new C0904h("type mismatch.");
                }
            } else if (z) {
                throw new C0904h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public boolean[] a(boolean[] zArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                boolean[] zArr2 = new boolean[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    zArr2[i3] = a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public byte[] a(byte[] bArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b2 = aVar.f25081a;
        if (b2 == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                byte[] bArr2 = new byte[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    bArr2[i3] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        if (b2 == 13) {
            a aVar2 = new a();
            a(aVar2);
            if (aVar2.f25081a == 0) {
                int a3 = a(0, 0, true);
                if (a3 >= 0) {
                    byte[] bArr3 = new byte[a3];
                    this.f25079a.get(bArr3);
                    return bArr3;
                }
                throw new C0904h("invalid size, tag: " + i2 + ", type: " + ((int) aVar.f25081a) + ", " + ((int) aVar2.f25081a) + ", size: " + a3);
            }
            throw new C0904h("type mismatch, tag: " + i2 + ", type: " + ((int) aVar.f25081a) + ", " + ((int) aVar2.f25081a));
        }
        throw new C0904h("type mismatch.");
    }

    public short[] a(short[] sArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                short[] sArr2 = new short[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    sArr2[i3] = a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public int[] a(int[] iArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                int[] iArr2 = new int[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    iArr2[i3] = a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public long[] a(long[] jArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                long[] jArr2 = new long[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    jArr2[i3] = a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public float[] a(float[] fArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                float[] fArr2 = new float[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    fArr2[i3] = a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public double[] a(double[] dArr, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f25081a == 9) {
            int a2 = a(0, 0, true);
            if (a2 >= 0) {
                double[] dArr2 = new double[a2];
                for (int i3 = 0; i3 < a2; i3++) {
                    dArr2[i3] = a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new C0904h("size invalid: " + a2);
        }
        throw new C0904h("type mismatch.");
    }

    public <T> T[] a(T[] tArr, int i2, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i2, z);
        }
        throw new C0904h("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i2, boolean z) {
        if (list != null && !list.isEmpty()) {
            Object[] b2 = b(list.get(0), i2, z);
            if (b2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b2) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public AbstractC0909m a(AbstractC0909m abstractC0909m, int i2, boolean z) {
        if (!a(i2)) {
            if (z) {
                throw new C0904h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC0909m abstractC0909m2 = (AbstractC0909m) abstractC0909m.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f25081a == 10) {
                abstractC0909m2.a(this);
                a();
                return abstractC0909m2;
            }
            throw new C0904h("type mismatch.");
        } catch (Exception e2) {
            throw new C0904h(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t, int i2, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i2, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i2, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i2, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i2, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0L, i2, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i2, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i2, z));
        }
        if (t instanceof String) {
            return String.valueOf(a(i2, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i2, z);
        }
        if (t instanceof List) {
            return a((List) t, i2, z);
        }
        if (t instanceof AbstractC0909m) {
            return a((AbstractC0909m) t, i2, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[]) && !(t instanceof Byte[])) {
                if (t instanceof boolean[]) {
                    return a((boolean[]) null, i2, z);
                }
                if (t instanceof short[]) {
                    return a((short[]) null, i2, z);
                }
                if (t instanceof int[]) {
                    return a((int[]) null, i2, z);
                }
                if (t instanceof long[]) {
                    return a((long[]) null, i2, z);
                }
                if (t instanceof float[]) {
                    return a((float[]) null, i2, z);
                }
                if (t instanceof double[]) {
                    return a((double[]) null, i2, z);
                }
                return a((Object[]) t, i2, z);
            }
            return a((byte[]) null, i2, z);
        }
        throw new C0904h("read object error: unsupport type.");
    }

    public int a(String str) {
        this.f25080b = str;
        return 0;
    }
}
