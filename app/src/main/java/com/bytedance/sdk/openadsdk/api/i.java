package com.bytedance.sdk.openadsdk.api;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: j */
    private final SparseArray<Object> f6369j;

    private static final class j implements ValueSet {

        /* renamed from: j */
        private final SparseArray<Object> f6370j;

        /* synthetic */ j(SparseArray sparseArray, AnonymousClass1 anonymousClass1) {
            this(sparseArray);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i2, Class<T> cls) {
            Object obj = this.f6370j.get(i2);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2) {
            return booleanValue(i2, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i2) {
            return this.f6370j.indexOfKey(i2) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i2) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2) {
            return floatValue(i2, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2) {
            return intValue(i2, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f6370j.size();
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < size; i2++) {
                hashSet.add(Integer.valueOf(i2));
            }
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2) {
            return longValue(i2, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i2, Class<T> cls) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) this.f6370j.get(i2);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            SparseArray<Object> sparseArray = this.f6370j;
            if (sparseArray == null) {
                return 0;
            }
            return sparseArray.size();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2) {
            return stringValue(i2, null);
        }

        private j(SparseArray<Object> sparseArray) {
            this.f6370j = sparseArray;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i2, boolean z) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i2, float f2) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i2, int i3) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i3;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i2, long j2) {
            Object obj = this.f6370j.get(i2);
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i2, String str) {
            Object obj = this.f6370j.get(i2);
            return (obj instanceof ValueSet.ValueGetter ? ((ValueSet.ValueGetter) obj).get() : obj) instanceof String ? obj.toString() : str;
        }
    }

    private i(SparseArray<Object> sparseArray) {
        this.f6369j = sparseArray;
    }

    public static final i j() {
        return new i(new SparseArray());
    }

    public ValueSet zx() {
        return new j(this.f6369j);
    }

    public i j(int i2, Object obj) {
        this.f6369j.put(i2, obj);
        return this;
    }

    public i j(int i2, String str) {
        this.f6369j.put(i2, str);
        return this;
    }

    public i j(int i2, boolean z) {
        this.f6369j.put(i2, Boolean.valueOf(z));
        return this;
    }
}
