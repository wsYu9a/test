package o5;

import com.google.common.collect.ImmutableMap;
import com.google.common.reflect.TypeToken;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.util.Map;
import javax.annotation.CheckForNull;

@d
/* loaded from: classes2.dex */
public final class e<B> extends com.google.common.collect.j<TypeToken<? extends B>, B> implements m<B> {

    /* renamed from: b */
    public final ImmutableMap<TypeToken<? extends B>, B> f29054b;

    public static final class b<B> {

        /* renamed from: a */
        public final ImmutableMap.b<TypeToken<? extends B>, B> f29055a;

        public /* synthetic */ b(a aVar) {
            this();
        }

        public e<B> a() {
            return new e<>(this.f29055a.d());
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> b(TypeToken<T> typeToken, T t10) {
            this.f29055a.i(typeToken.rejectTypeVariables(), t10);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> b<B> c(Class<T> cls, T t10) {
            this.f29055a.i(TypeToken.of((Class) cls), t10);
            return this;
        }

        public b() {
            this.f29055a = ImmutableMap.builder();
        }
    }

    public /* synthetic */ e(ImmutableMap immutableMap, a aVar) {
        this(immutableMap);
    }

    public static <B> b<B> e() {
        return new b<>();
    }

    public static <B> e<B> f() {
        return new e<>(ImmutableMap.of());
    }

    @Override // o5.m
    @CheckForNull
    public <T extends B> T b(TypeToken<T> typeToken) {
        return (T) h(typeToken.rejectTypeVariables());
    }

    @Override // o5.m
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T d(TypeToken<T> typeToken, T t10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    /* renamed from: g */
    public B put(TypeToken<? extends B> typeToken, B b10) {
        throw new UnsupportedOperationException();
    }

    @Override // o5.m
    @CheckForNull
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) h(TypeToken.of((Class) cls));
    }

    @CheckForNull
    public final <T extends B> T h(TypeToken<T> typeToken) {
        return this.f29054b.get(typeToken);
    }

    @Override // com.google.common.collect.j, java.util.Map, e5.g
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // o5.m
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        throw new UnsupportedOperationException();
    }

    public e(ImmutableMap<TypeToken<? extends B>, B> immutableMap) {
        this.f29054b = immutableMap;
    }

    @Override // com.google.common.collect.j, e5.l0
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f29054b;
    }
}
