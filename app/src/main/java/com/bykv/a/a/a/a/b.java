package com.bykv.a.a.a.a;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import l5.c;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    public static final ValueSet f7416a = a(0).b();

    /* renamed from: b */
    public static final Bridge f7417b = new a();

    /* renamed from: c */
    private final SparseArray<Object> f7418c;

    /* renamed from: d */
    private ValueSet f7419d;

    public static final class a implements Bridge {
        private a() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i10, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) new Integer(0);
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) new Long(0L);
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) new Double(c.f27899e);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) new Float(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return b.f7416a;
        }

        public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* renamed from: com.bykv.a.a.a.a.b$b */
    public static final class C0224b implements ValueSet {

        /* renamed from: a */
        private final SparseArray<Object> f7420a;

        /* renamed from: b */
        private ValueSet f7421b;

        /* renamed from: c */
        private int f7422c;

        public /* synthetic */ C0224b(SparseArray sparseArray, ValueSet valueSet, AnonymousClass1 anonymousClass1) {
            this(sparseArray, valueSet);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i10, Class<T> cls) {
            Object obj = this.f7420a.get(i10);
            if (obj == null) {
                ValueSet valueSet = this.f7421b;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i10, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i10) {
            return booleanValue(i10, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i10) {
            ValueSet valueSet;
            int indexOfKey = this.f7420a.indexOfKey(i10);
            return (indexOfKey >= 0 || (valueSet = this.f7421b) == null) ? indexOfKey >= 0 : valueSet.containsKey(i10);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i10) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj == null && (valueSet = this.f7421b) != null) {
                return valueSet.doubleValue(i10);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Double ? ((Double) obj).doubleValue() : c.f27899e;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i10) {
            return floatValue(i10, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i10) {
            return intValue(i10, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f7420a.size();
            HashSet hashSet = new HashSet();
            for (int i10 = 0; i10 < size; i10++) {
                hashSet.add(Integer.valueOf(this.f7420a.keyAt(i10)));
            }
            ValueSet valueSet = this.f7421b;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.f7422c = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10) {
            return longValue(i10, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i10, Class<T> cls) {
            Object obj = this.f7420a.get(i10);
            if (obj == null) {
                ValueSet valueSet = this.f7421b;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i10, cls);
                }
                return null;
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) obj;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.f7422c < 0) {
                keys();
            }
            return this.f7422c;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10) {
            return stringValue(i10, null);
        }

        private C0224b(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.f7422c = -1;
            this.f7420a = sparseArray;
            this.f7421b = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i10, boolean z10) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj == null && (valueSet = this.f7421b) != null) {
                return valueSet.booleanValue(i10, z10);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i10, float f10) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj == null && (valueSet = this.f7421b) != null) {
                return valueSet.floatValue(i10, f10);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i10, int i11) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj == null && (valueSet = this.f7421b) != null) {
                return valueSet.intValue(i10, i11);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i11;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i10, long j10) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj == null && (valueSet = this.f7421b) != null) {
                return valueSet.longValue(i10, j10);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j10;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i10, String str) {
            ValueSet valueSet;
            Object obj = this.f7420a.get(i10);
            if (obj != null || (valueSet = this.f7421b) == null) {
                return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
            }
            return valueSet.stringValue(i10, str);
        }
    }

    private b(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.f7418c = sparseArray;
        this.f7419d = valueSet;
    }

    public static final b a() {
        return new b(new SparseArray());
    }

    public ValueSet b() {
        return new C0224b(this.f7418c, this.f7419d);
    }

    public static final b a(int i10) {
        return new b(new SparseArray(i10));
    }

    public static final b a(ValueSet valueSet) {
        return new b(new SparseArray(), valueSet);
    }

    private b(SparseArray<Object> sparseArray) {
        this.f7418c = sparseArray;
    }

    public b a(int i10, Object obj) {
        this.f7418c.put(i10, obj);
        return this;
    }

    public b a(int i10, String str) {
        this.f7418c.put(i10, str);
        return this;
    }

    public b a(int i10, int i11) {
        this.f7418c.put(i10, Integer.valueOf(i11));
        return this;
    }

    public b a(int i10, double d10) {
        this.f7418c.put(i10, Double.valueOf(d10));
        return this;
    }

    public b a(int i10, boolean z10) {
        this.f7418c.put(i10, Boolean.valueOf(z10));
        return this;
    }

    public b a(int i10, long j10) {
        this.f7418c.put(i10, Long.valueOf(j10));
        return this;
    }

    public b a(int i10, float f10) {
        this.f7418c.put(i10, Float.valueOf(f10));
        return this;
    }
}
