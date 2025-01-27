package com.jd.ad.sdk.jad_ny;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public final class jad_jw implements com.jd.ad.sdk.jad_ny.jad_bo {
    public final jad_hu<jad_an, Object> jad_an = new jad_hu<>();
    public final jad_bo jad_bo = new jad_bo();
    public final Map<Class<?>, NavigableMap<Integer, Integer>> jad_cp = new HashMap();
    public final Map<Class<?>, com.jd.ad.sdk.jad_ny.jad_an<?>> jad_dq = new HashMap();
    public final int jad_er;
    public int jad_fs;

    public static final class jad_an implements jad_mz {
        public final jad_bo jad_an;
        public int jad_bo;
        public Class<?> jad_cp;

        public jad_an(jad_bo jad_boVar) {
            this.jad_an = jad_boVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof jad_an)) {
                return false;
            }
            jad_an jad_anVar = (jad_an) obj;
            return this.jad_bo == jad_anVar.jad_bo && this.jad_cp == jad_anVar.jad_cp;
        }

        public int hashCode() {
            int i10 = this.jad_bo * 31;
            Class<?> cls = this.jad_cp;
            return i10 + (cls != null ? cls.hashCode() : 0);
        }

        @Override // com.jd.ad.sdk.jad_ny.jad_mz
        public void jad_an() {
            jad_bo jad_boVar = this.jad_an;
            if (jad_boVar.jad_an.size() < 20) {
                jad_boVar.jad_an.offer(this);
            }
        }

        public String toString() {
            StringBuilder jad_an = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Key{size=");
            jad_an.append(this.jad_bo);
            jad_an.append("array=");
            jad_an.append(this.jad_cp);
            jad_an.append('}');
            return jad_an.toString();
        }
    }

    public static final class jad_bo extends jad_dq<jad_an> {
        @Override // com.jd.ad.sdk.jad_ny.jad_dq
        public jad_an jad_an() {
            return new jad_an(this);
        }

        public jad_an jad_an(int i10, Class<?> cls) {
            jad_an jad_bo = jad_bo();
            jad_bo.jad_bo = i10;
            jad_bo.jad_cp = cls;
            return jad_bo;
        }
    }

    public jad_jw(int i10) {
        this.jad_er = i10;
    }

    public final <T> com.jd.ad.sdk.jad_ny.jad_an<T> jad_an(Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_anVar = (com.jd.ad.sdk.jad_ny.jad_an) this.jad_dq.get(cls);
        if (jad_anVar == null) {
            if (cls.equals(int[].class)) {
                jad_anVar = new jad_iv();
            } else {
                if (!cls.equals(byte[].class)) {
                    StringBuilder jad_an2 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("No array pool found for: ");
                    jad_an2.append(cls.getSimpleName());
                    throw new IllegalArgumentException(jad_an2.toString());
                }
                jad_anVar = new jad_jt();
            }
            this.jad_dq.put(cls, jad_anVar);
        }
        return jad_anVar;
    }

    public final NavigableMap<Integer, Integer> jad_bo(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.jad_cp.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.jad_cp.put(cls, treeMap);
        return treeMap;
    }

    public final void jad_cp(int i10, Class<?> cls) {
        NavigableMap<Integer, Integer> jad_bo2 = jad_bo(cls);
        Integer num = jad_bo2.get(Integer.valueOf(i10));
        if (num == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + i10 + ", this: " + this);
        }
        int intValue = num.intValue();
        Integer valueOf = Integer.valueOf(i10);
        if (intValue == 1) {
            jad_bo2.remove(valueOf);
        } else {
            jad_bo2.put(valueOf, Integer.valueOf(num.intValue() - 1));
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an() {
        jad_bo(0);
    }

    public final void jad_bo(int i10) {
        while (this.jad_fs > i10) {
            Object jad_an2 = this.jad_an.jad_an();
            com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_an2);
            com.jd.ad.sdk.jad_ny.jad_an jad_an3 = jad_an((Class) jad_an2.getClass());
            this.jad_fs -= jad_an3.jad_bo() * jad_an3.jad_an(jad_an2);
            jad_cp(jad_an3.jad_an(jad_an2), jad_an2.getClass());
            if (Log.isLoggable(jad_an3.jad_an(), 2)) {
                String jad_an4 = jad_an3.jad_an();
                StringBuilder jad_an5 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("evicted: ");
                jad_an5.append(jad_an3.jad_an(jad_an2));
                Logger.v(jad_an4, jad_an5.toString());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_an(int i10, Class<T> cls) {
        jad_an jad_anVar;
        int i11;
        try {
            Integer ceilingKey = jad_bo((Class<?>) cls).ceilingKey(Integer.valueOf(i10));
            if (ceilingKey == null || ((i11 = this.jad_fs) != 0 && this.jad_er / i11 < 2 && ceilingKey.intValue() > i10 * 8)) {
                jad_an jad_bo2 = this.jad_bo.jad_bo();
                jad_bo2.jad_bo = i10;
                jad_bo2.jad_cp = cls;
                jad_anVar = jad_bo2;
            }
            jad_anVar = this.jad_bo.jad_an(ceilingKey.intValue(), cls);
        } catch (Throwable th2) {
            throw th2;
        }
        return (T) jad_an(jad_anVar, cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> T jad_bo(int i10, Class<T> cls) {
        jad_an jad_bo2;
        jad_bo2 = this.jad_bo.jad_bo();
        jad_bo2.jad_bo = i10;
        jad_bo2.jad_cp = cls;
        return (T) jad_an(jad_bo2, cls);
    }

    public final <T> T jad_an(jad_an jad_anVar, Class<T> cls) {
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_an2 = jad_an((Class) cls);
        T t10 = (T) this.jad_an.jad_an(jad_anVar);
        if (t10 != null) {
            this.jad_fs -= jad_an2.jad_bo() * jad_an2.jad_an(t10);
            jad_cp(jad_an2.jad_an(t10), cls);
        }
        if (t10 != null) {
            return t10;
        }
        if (Log.isLoggable(jad_an2.jad_an(), 2)) {
            String jad_an3 = jad_an2.jad_an();
            StringBuilder jad_an4 = com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Allocated ");
            jad_an4.append(jad_anVar.jad_bo);
            jad_an4.append(" bytes");
            Logger.v(jad_an3, jad_an4.toString());
        }
        return jad_an2.newArray(jad_anVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized <T> void jad_an(T t10) {
        Class<?> cls = t10.getClass();
        com.jd.ad.sdk.jad_ny.jad_an<T> jad_an2 = jad_an((Class) cls);
        int jad_an3 = jad_an2.jad_an(t10);
        int jad_bo2 = jad_an2.jad_bo() * jad_an3;
        if (jad_bo2 <= this.jad_er / 2) {
            jad_an jad_an4 = this.jad_bo.jad_an(jad_an3, cls);
            this.jad_an.jad_an(jad_an4, t10);
            NavigableMap<Integer, Integer> jad_bo3 = jad_bo(cls);
            Integer num = jad_bo3.get(Integer.valueOf(jad_an4.jad_bo));
            Integer valueOf = Integer.valueOf(jad_an4.jad_bo);
            int i10 = 1;
            if (num != null) {
                i10 = 1 + num.intValue();
            }
            jad_bo3.put(valueOf, Integer.valueOf(i10));
            this.jad_fs += jad_bo2;
            jad_bo(this.jad_er);
        }
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_bo
    public synchronized void jad_an(int i10) {
        try {
            if (i10 >= 40) {
                synchronized (this) {
                    jad_bo(0);
                }
            } else if (i10 >= 20 || i10 == 15) {
                jad_bo(this.jad_er / 2);
            }
        } finally {
        }
    }
}
