package com.google.gson.internal;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {

    /* renamed from: a */
    private static final double f8005a = -1.0d;

    /* renamed from: b */
    public static final Excluder f8006b = new Excluder();

    /* renamed from: f */
    private boolean f8010f;

    /* renamed from: c */
    private double f8007c = f8005a;

    /* renamed from: d */
    private int f8008d = 136;

    /* renamed from: e */
    private boolean f8009e = true;

    /* renamed from: g */
    private List<ExclusionStrategy> f8011g = Collections.emptyList();

    /* renamed from: h */
    private List<ExclusionStrategy> f8012h = Collections.emptyList();

    class a<T> extends TypeAdapter<T> {

        /* renamed from: a */
        private TypeAdapter<T> f8013a;

        /* renamed from: b */
        final /* synthetic */ boolean f8014b;

        /* renamed from: c */
        final /* synthetic */ boolean f8015c;

        /* renamed from: d */
        final /* synthetic */ Gson f8016d;

        /* renamed from: e */
        final /* synthetic */ com.google.gson.b.a f8017e;

        a(boolean z, boolean z2, Gson gson, com.google.gson.b.a aVar) {
            this.f8014b = z;
            this.f8015c = z2;
            this.f8016d = gson;
            this.f8017e = aVar;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.f8013a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            TypeAdapter<T> delegateAdapter = this.f8016d.getDelegateAdapter(Excluder.this, this.f8017e);
            this.f8013a = delegateAdapter;
            return delegateAdapter;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(com.google.gson.stream.a aVar) throws IOException {
            if (!this.f8014b) {
                return delegate().read2(aVar);
            }
            aVar.M();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(com.google.gson.stream.c cVar, T t) throws IOException {
            if (this.f8015c) {
                cVar.m();
            } else {
                delegate().write(cVar, t);
            }
        }
    }

    private boolean f(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean g(Class<?> cls) {
        return cls.isMemberClass() && !h(cls);
    }

    private boolean h(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean i(com.google.gson.a.d dVar) {
        return dVar == null || dVar.value() <= this.f8007c;
    }

    private boolean j(com.google.gson.a.e eVar) {
        return eVar == null || eVar.value() > this.f8007c;
    }

    private boolean k(com.google.gson.a.d dVar, com.google.gson.a.e eVar) {
        return i(dVar) && j(eVar);
    }

    /* renamed from: a */
    public Excluder clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public Excluder b() {
        Excluder clone = clone();
        clone.f8009e = false;
        return clone;
    }

    public boolean c(Class<?> cls, boolean z) {
        if (this.f8007c != f8005a && !k((com.google.gson.a.d) cls.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) cls.getAnnotation(com.google.gson.a.e.class))) {
            return true;
        }
        if ((!this.f8009e && g(cls)) || f(cls)) {
            return true;
        }
        Iterator<ExclusionStrategy> it = (z ? this.f8011g : this.f8012h).iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Class<? super T> d2 = aVar.d();
        boolean c2 = c(d2, true);
        boolean c3 = c(d2, false);
        if (c2 || c3) {
            return new a(c3, c2, gson, aVar);
        }
        return null;
    }

    public boolean d(Field field, boolean z) {
        com.google.gson.a.a aVar;
        if ((this.f8008d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.f8007c != f8005a && !k((com.google.gson.a.d) field.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e) field.getAnnotation(com.google.gson.a.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f8010f && ((aVar = (com.google.gson.a.a) field.getAnnotation(com.google.gson.a.a.class)) == null || (!z ? aVar.deserialize() : aVar.serialize()))) {
            return true;
        }
        if ((!this.f8009e && g(field.getType())) || f(field.getType())) {
            return true;
        }
        List<ExclusionStrategy> list = z ? this.f8011g : this.f8012h;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator<ExclusionStrategy> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public Excluder e() {
        Excluder clone = clone();
        clone.f8010f = true;
        return clone;
    }

    public Excluder l(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder clone = clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.f8011g);
            clone.f8011g = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.f8012h);
            clone.f8012h = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return clone;
    }

    public Excluder m(int... iArr) {
        Excluder clone = clone();
        clone.f8008d = 0;
        for (int i2 : iArr) {
            clone.f8008d = i2 | clone.f8008d;
        }
        return clone;
    }

    public Excluder n(double d2) {
        Excluder clone = clone();
        clone.f8007c = d2;
        return clone;
    }
}
