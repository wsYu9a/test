package com.wbl.ad.yzz.gson.t;

import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class c implements r, Cloneable {

    /* renamed from: g */
    public static final c f32279g = new c();

    /* renamed from: d */
    public boolean f32283d;

    /* renamed from: a */
    public double f32280a = -1.0d;

    /* renamed from: b */
    public int f32281b = 136;

    /* renamed from: c */
    public boolean f32282c = true;

    /* renamed from: e */
    public List<com.wbl.ad.yzz.gson.b> f32284e = Collections.emptyList();

    /* renamed from: f */
    public List<com.wbl.ad.yzz.gson.b> f32285f = Collections.emptyList();

    /* renamed from: a */
    public c clone() {
        try {
            return (c) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean b(Class<?> cls, boolean z) {
        Iterator<com.wbl.ad.yzz.gson.b> it = (z ? this.f32284e : this.f32285f).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final boolean c(Class<?> cls) {
        return cls.isMemberClass() && !d(cls);
    }

    public final boolean d(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    public class a<T> extends q<T> {

        /* renamed from: a */
        public q<T> f32286a;

        /* renamed from: b */
        public final /* synthetic */ boolean f32287b;

        /* renamed from: c */
        public final /* synthetic */ boolean f32288c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.gson.e f32289d;

        /* renamed from: e */
        public final /* synthetic */ com.wbl.ad.yzz.gson.u.a f32290e;

        public a(boolean z, boolean z2, com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a aVar) {
            this.f32287b = z;
            this.f32288c = z2;
            this.f32289d = eVar;
            this.f32290e = aVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (!this.f32287b) {
                return b().a(aVar);
            }
            aVar.z();
            return null;
        }

        public final q<T> b() {
            q<T> qVar = this.f32286a;
            if (qVar != null) {
                return qVar;
            }
            q<T> a2 = this.f32289d.a(c.this, this.f32290e);
            this.f32286a = a2;
            return a2;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
            if (this.f32288c) {
                bVar.k();
            } else {
                b().a(bVar, t);
            }
        }
    }

    @Override // com.wbl.ad.yzz.gson.r
    public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        boolean a3 = a(a2);
        boolean z = a3 || b(a2, true);
        boolean z2 = a3 || b(a2, false);
        if (z || z2) {
            return new a(z2, z, eVar, aVar);
        }
        return null;
    }

    public final boolean b(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public boolean a(Field field, boolean z) {
        com.wbl.ad.yzz.gson.s.a aVar;
        if ((this.f32281b & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f32280a != -1.0d && !a((com.wbl.ad.yzz.gson.s.d) field.getAnnotation(com.wbl.ad.yzz.gson.s.d.class), (com.wbl.ad.yzz.gson.s.e) field.getAnnotation(com.wbl.ad.yzz.gson.s.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f32283d && ((aVar = (com.wbl.ad.yzz.gson.s.a) field.getAnnotation(com.wbl.ad.yzz.gson.s.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f32282c && c(field.getType())) || b(field.getType())) {
            return true;
        }
        List<com.wbl.ad.yzz.gson.b> list = z ? this.f32284e : this.f32285f;
        if (list.isEmpty()) {
            return false;
        }
        com.wbl.ad.yzz.gson.c cVar = new com.wbl.ad.yzz.gson.c(field);
        Iterator<com.wbl.ad.yzz.gson.b> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(cVar)) {
                return true;
            }
        }
        return false;
    }

    public final boolean a(Class<?> cls) {
        if (this.f32280a == -1.0d || a((com.wbl.ad.yzz.gson.s.d) cls.getAnnotation(com.wbl.ad.yzz.gson.s.d.class), (com.wbl.ad.yzz.gson.s.e) cls.getAnnotation(com.wbl.ad.yzz.gson.s.e.class))) {
            return (!this.f32282c && c(cls)) || b(cls);
        }
        return true;
    }

    public boolean a(Class<?> cls, boolean z) {
        return a(cls) || b(cls, z);
    }

    public final boolean a(com.wbl.ad.yzz.gson.s.d dVar, com.wbl.ad.yzz.gson.s.e eVar) {
        return a(dVar) && a(eVar);
    }

    public final boolean a(com.wbl.ad.yzz.gson.s.d dVar) {
        return dVar == null || dVar.value() <= this.f32280a;
    }

    public final boolean a(com.wbl.ad.yzz.gson.s.e eVar) {
        return eVar == null || eVar.value() > this.f32280a;
    }
}
