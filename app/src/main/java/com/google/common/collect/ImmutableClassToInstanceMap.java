package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"B"})
@e5.m
@a5.c
/* loaded from: classes2.dex */
public final class ImmutableClassToInstanceMap<B> extends j<Class<? extends B>, B> implements e5.h<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    public static final class b<B> {

        /* renamed from: a */
        public final ImmutableMap.b<Class<? extends B>, B> f9442a = ImmutableMap.builder();

        public static <B, T extends B> T b(Class<T> cls, B b10) {
            return (T) n5.h.f(cls).cast(b10);
        }

        public ImmutableClassToInstanceMap<B> a() {
            ImmutableMap<Class<? extends B>, B> d10 = this.f9442a.d();
            return d10.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<>(d10);
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> c(Class<T> cls, T t10) {
            this.f9442a.i(cls, t10);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> d(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.f9442a.i(key, b(key, entry.getValue()));
            }
            return this;
        }
    }

    public /* synthetic */ ImmutableClassToInstanceMap(ImmutableMap immutableMap, a aVar) {
        this(immutableMap);
    }

    public static <B> b<B> builder() {
        return new b<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof ImmutableClassToInstanceMap ? (ImmutableClassToInstanceMap) map : new b().d(map).a();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    @Override // e5.h
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(b5.u.E(cls));
    }

    @Override // e5.h
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t10) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t10));
    }

    @Override // com.google.common.collect.j, e5.l0
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
