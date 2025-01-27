package o5;

import b5.u;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import e5.j0;
import e5.n0;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import o5.g;

@d
/* loaded from: classes2.dex */
public final class g<B> extends com.google.common.collect.j<TypeToken<? extends B>, B> implements m<B> {

    /* renamed from: b */
    public final Map<TypeToken<? extends B>, B> f29056b = Maps.Y();

    public static final class a<K, V> extends j0<K, V> {

        /* renamed from: b */
        public final Map.Entry<K, V> f29057b;

        /* renamed from: o5.g$a$a */
        public class C0752a extends n0<Map.Entry<K, V>> {

            /* renamed from: b */
            public final /* synthetic */ Set f29058b;

            public C0752a(Set set) {
                this.f29058b = set;
            }

            @Override // e5.y, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return a.h(super.iterator());
            }

            @Override // e5.y, java.util.Collection, java.util.Set
            public Object[] toArray() {
                return standardToArray();
            }

            @Override // e5.y, java.util.Collection, java.util.Set
            public <T> T[] toArray(T[] tArr) {
                return (T[]) standardToArray(tArr);
            }

            @Override // e5.n0, e5.y, e5.l0
            public Set<Map.Entry<K, V>> delegate() {
                return this.f29058b;
            }
        }

        public a(Map.Entry<K, V> entry) {
            this.f29057b = (Map.Entry) u.E(entry);
        }

        public static /* synthetic */ a f(Map.Entry entry) {
            return new a(entry);
        }

        public static <K, V> Iterator<Map.Entry<K, V>> h(Iterator<Map.Entry<K, V>> it) {
            return Iterators.c0(it, new b5.n() { // from class: o5.f
                @Override // b5.n
                public final Object apply(Object obj) {
                    return g.a.f((Map.Entry) obj);
                }
            });
        }

        public static <K, V> Set<Map.Entry<K, V>> i(Set<Map.Entry<K, V>> set) {
            return new C0752a(set);
        }

        @Override // e5.j0, e5.l0
        /* renamed from: e */
        public Map.Entry<K, V> delegate() {
            return this.f29057b;
        }

        @Override // e5.j0, java.util.Map.Entry
        public V setValue(V v10) {
            throw new UnsupportedOperationException();
        }
    }

    @CheckForNull
    private <T extends B> T f(TypeToken<T> typeToken) {
        return this.f29056b.get(typeToken);
    }

    @Override // o5.m
    @CheckForNull
    public <T extends B> T b(TypeToken<T> typeToken) {
        return (T) f(typeToken.rejectTypeVariables());
    }

    @Override // o5.m
    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T d(TypeToken<T> typeToken, T t10) {
        return (T) g(typeToken.rejectTypeVariables(), t10);
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    /* renamed from: e */
    public B put(TypeToken<? extends B> typeToken, B b10) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.j, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return a.i(super.entrySet());
    }

    @CheckForNull
    public final <T extends B> T g(TypeToken<T> typeToken, T t10) {
        return this.f29056b.put(typeToken, t10);
    }

    @Override // o5.m
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) f(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // o5.m
    @CanIgnoreReturnValue
    @CheckForNull
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        return (T) g(TypeToken.of((Class) cls), t10);
    }

    @Override // com.google.common.collect.j, e5.l0
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f29056b;
    }
}
