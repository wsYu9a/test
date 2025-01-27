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
public final class C0866k {

    /* renamed from: a */
    private ByteBuffer f22751a;

    /* renamed from: b */
    protected String f22752b = rb.b.f30389e;

    /* renamed from: com.tencent.bugly.proguard.k$a */
    public static class a {

        /* renamed from: a */
        public byte f22753a;

        /* renamed from: b */
        public int f22754b;
    }

    public C0866k() {
    }

    private int b(a aVar) {
        return a(aVar, this.f22751a.duplicate());
    }

    public void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f22751a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f22751a = ByteBuffer.wrap(bArr);
    }

    private void b(int i10) {
        ByteBuffer byteBuffer = this.f22751a;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    public C0866k(byte[] bArr) {
        this.f22751a = ByteBuffer.wrap(bArr);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f22753a);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b10 = byteBuffer.get();
        aVar.f22753a = (byte) (b10 & 15);
        int i10 = (b10 & 240) >> 4;
        aVar.f22754b = i10;
        if (i10 != 15) {
            return 1;
        }
        aVar.f22754b = byteBuffer.get();
        return 2;
    }

    public C0866k(byte[] bArr, int i10) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f22751a = wrap;
        wrap.position(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t10.getClass(), a10));
                for (int i11 = 0; i11 < a10; i11++) {
                    tArr[i11] = a((C0866k) t10, 0, true);
                }
                return tArr;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public void a(a aVar) {
        a(aVar, this.f22751a);
    }

    public boolean a(int i10) {
        int i11;
        try {
            a aVar = new a();
            while (true) {
                int b10 = b(aVar);
                i11 = aVar.f22754b;
                if (i10 <= i11 || aVar.f22753a == 11) {
                    break;
                }
                b(b10);
                a(aVar.f22753a);
            }
            return i10 == i11;
        } catch (C0863h | BufferUnderflowException unused) {
            return false;
        }
    }

    public void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f22753a);
        } while (aVar.f22753a != 11);
    }

    private void a(byte b10) {
        int i10 = 0;
        switch (b10) {
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
                int i11 = this.f22751a.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                b(i11);
                return;
            case 7:
                b(this.f22751a.getInt());
                return;
            case 8:
                int a10 = a(0, 0, true);
                while (i10 < a10 * 2) {
                    b();
                    i10++;
                }
                return;
            case 9:
                int a11 = a(0, 0, true);
                while (i10 < a11) {
                    b();
                    i10++;
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
                if (aVar.f22753a == 0) {
                    b(a(0, 0, true));
                    return;
                }
                throw new C0863h("skipField with invalid type, type value: " + ((int) b10) + ", " + ((int) aVar.f22753a));
            default:
                throw new C0863h("invalid type.");
        }
    }

    public boolean a(boolean z10, int i10, boolean z11) {
        return a((byte) 0, i10, z11) != 0;
    }

    public byte a(byte b10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return b10;
        }
        a aVar = new a();
        a(aVar);
        byte b11 = aVar.f22753a;
        if (b11 == 0) {
            return this.f22751a.get();
        }
        if (b11 == 12) {
            return (byte) 0;
        }
        throw new C0863h("type mismatch.");
    }

    public short a(short s10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return s10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 0) {
            return this.f22751a.get();
        }
        if (b10 == 1) {
            return this.f22751a.getShort();
        }
        if (b10 == 12) {
            return (short) 0;
        }
        throw new C0863h("type mismatch.");
    }

    public int a(int i10, int i11, boolean z10) {
        if (!a(i11)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return i10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 0) {
            return this.f22751a.get();
        }
        if (b10 == 1) {
            return this.f22751a.getShort();
        }
        if (b10 == 2) {
            return this.f22751a.getInt();
        }
        if (b10 == 12) {
            return 0;
        }
        throw new C0863h("type mismatch.");
    }

    public long a(long j10, int i10, boolean z10) {
        int i11;
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 12) {
            return 0L;
        }
        if (b10 == 0) {
            i11 = this.f22751a.get();
        } else if (b10 == 1) {
            i11 = this.f22751a.getShort();
        } else {
            if (b10 != 2) {
                if (b10 == 3) {
                    return this.f22751a.getLong();
                }
                throw new C0863h("type mismatch.");
            }
            i11 = this.f22751a.getInt();
        }
        return i11;
    }

    public float a(float f10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return f10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 4) {
            return this.f22751a.getFloat();
        }
        if (b10 == 12) {
            return 0.0f;
        }
        throw new C0863h("type mismatch.");
    }

    public double a(double d10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return d10;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 4) {
            return this.f22751a.getFloat();
        }
        if (b10 == 5) {
            return this.f22751a.getDouble();
        }
        if (b10 == 12) {
            return l5.c.f27899e;
        }
        throw new C0863h("type mismatch.");
    }

    public String a(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 6) {
            int i11 = this.f22751a.get();
            if (i11 < 0) {
                i11 += 256;
            }
            byte[] bArr = new byte[i11];
            this.f22751a.get(bArr);
            try {
                return new String(bArr, this.f22752b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b10 == 7) {
            int i12 = this.f22751a.getInt();
            if (i12 <= 104857600 && i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                this.f22751a.get(bArr2);
                try {
                    return new String(bArr2, this.f22752b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new C0863h("String too long: " + i12);
        }
        throw new C0863h("type mismatch.");
    }

    public <K, V> HashMap<K, V> a(Map<K, V> map, int i10, boolean z10) {
        return (HashMap) a(new HashMap(), map, i10, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i10, boolean z10) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i10)) {
                a aVar = new a();
                a(aVar);
                if (aVar.f22753a == 8) {
                    int a10 = a(0, 0, true);
                    if (a10 < 0) {
                        throw new C0863h("size invalid: " + a10);
                    }
                    for (int i11 = 0; i11 < a10; i11++) {
                        map.put(a((C0866k) key, 0, true), a((C0866k) value, 1, true));
                    }
                } else {
                    throw new C0863h("type mismatch.");
                }
            } else if (z10) {
                throw new C0863h("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    public boolean[] a(boolean[] zArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                boolean[] zArr2 = new boolean[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    zArr2[i11] = a(zArr2[0], 0, true);
                }
                return zArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public byte[] a(byte[] bArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f22753a;
        if (b10 == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                byte[] bArr2 = new byte[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    bArr2[i11] = a(bArr2[0], 0, true);
                }
                return bArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        if (b10 == 13) {
            a aVar2 = new a();
            a(aVar2);
            if (aVar2.f22753a == 0) {
                int a11 = a(0, 0, true);
                if (a11 >= 0) {
                    byte[] bArr3 = new byte[a11];
                    this.f22751a.get(bArr3);
                    return bArr3;
                }
                throw new C0863h("invalid size, tag: " + i10 + ", type: " + ((int) aVar.f22753a) + ", " + ((int) aVar2.f22753a) + ", size: " + a11);
            }
            throw new C0863h("type mismatch, tag: " + i10 + ", type: " + ((int) aVar.f22753a) + ", " + ((int) aVar2.f22753a));
        }
        throw new C0863h("type mismatch.");
    }

    public short[] a(short[] sArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                short[] sArr2 = new short[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    sArr2[i11] = a(sArr2[0], 0, true);
                }
                return sArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public int[] a(int[] iArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                int[] iArr2 = new int[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    iArr2[i11] = a(iArr2[0], 0, true);
                }
                return iArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public long[] a(long[] jArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                long[] jArr2 = new long[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    jArr2[i11] = a(jArr2[0], 0, true);
                }
                return jArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public float[] a(float[] fArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                float[] fArr2 = new float[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    fArr2[i11] = a(fArr2[0], 0, true);
                }
                return fArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public double[] a(double[] dArr, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f22753a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                double[] dArr2 = new double[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    dArr2[i11] = a(dArr2[0], 0, true);
                }
                return dArr2;
            }
            throw new C0863h("size invalid: " + a10);
        }
        throw new C0863h("type mismatch.");
    }

    public <T> T[] a(T[] tArr, int i10, boolean z10) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i10, z10);
        }
        throw new C0863h("unable to get type of key and value.");
    }

    public <T> List<T> a(List<T> list, int i10, boolean z10) {
        if (list != null && !list.isEmpty()) {
            Object[] b10 = b(list.get(0), i10, z10);
            if (b10 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b10) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public AbstractC0868m a(AbstractC0868m abstractC0868m, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new C0863h("require field not exist.");
            }
            return null;
        }
        try {
            AbstractC0868m abstractC0868m2 = (AbstractC0868m) abstractC0868m.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f22753a == 10) {
                abstractC0868m2.a(this);
                a();
                return abstractC0868m2;
            }
            throw new C0863h("type mismatch.");
        } catch (Exception e10) {
            throw new C0863h(e10.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> Object a(T t10, int i10, boolean z10) {
        if (t10 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t10 instanceof Boolean) {
            return Boolean.valueOf(a(false, i10, z10));
        }
        if (t10 instanceof Short) {
            return Short.valueOf(a((short) 0, i10, z10));
        }
        if (t10 instanceof Integer) {
            return Integer.valueOf(a(0, i10, z10));
        }
        if (t10 instanceof Long) {
            return Long.valueOf(a(0L, i10, z10));
        }
        if (t10 instanceof Float) {
            return Float.valueOf(a(0.0f, i10, z10));
        }
        if (t10 instanceof Double) {
            return Double.valueOf(a(l5.c.f27899e, i10, z10));
        }
        if (t10 instanceof String) {
            return String.valueOf(a(i10, z10));
        }
        if (t10 instanceof Map) {
            return a((Map) t10, i10, z10);
        }
        if (t10 instanceof List) {
            return a((List) t10, i10, z10);
        }
        if (t10 instanceof AbstractC0868m) {
            return a((AbstractC0868m) t10, i10, z10);
        }
        if (t10.getClass().isArray()) {
            if (!(t10 instanceof byte[]) && !(t10 instanceof Byte[])) {
                if (t10 instanceof boolean[]) {
                    return a((boolean[]) null, i10, z10);
                }
                if (t10 instanceof short[]) {
                    return a((short[]) null, i10, z10);
                }
                if (t10 instanceof int[]) {
                    return a((int[]) null, i10, z10);
                }
                if (t10 instanceof long[]) {
                    return a((long[]) null, i10, z10);
                }
                if (t10 instanceof float[]) {
                    return a((float[]) null, i10, z10);
                }
                if (t10 instanceof double[]) {
                    return a((double[]) null, i10, z10);
                }
                return a((Object[]) t10, i10, z10);
            }
            return a((byte[]) null, i10, z10);
        }
        throw new C0863h("read object error: unsupport type.");
    }

    public int a(String str) {
        this.f22752b = str;
        return 0;
    }
}
