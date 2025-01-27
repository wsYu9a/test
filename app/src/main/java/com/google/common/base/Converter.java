package com.google.common.base;

import b5.g;
import b5.n;
import b5.q;
import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ForOverride;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public abstract class Converter<A, B> implements n<A, B> {
    private final boolean handleNullAutomatically;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient Converter<B, A> reverse;

    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> first;
        final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public A correctedDoBackward(@CheckForNull C c10) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c10));
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public C correctedDoForward(@CheckForNull A a10) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a10));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.first);
            String valueOf2 = String.valueOf(this.second);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".andThen(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final n<? super B, ? extends A> backwardFunction;
        private final n<? super A, ? extends B> forwardFunction;

        public /* synthetic */ FunctionBasedConverter(n nVar, n nVar2, a aVar) {
            this(nVar, nVar2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b10) {
            return this.backwardFunction.apply(b10);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a10) {
            return this.forwardFunction.apply(a10);
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.forwardFunction);
            String valueOf2 = String.valueOf(this.backwardFunction);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
            sb2.append("Converter.from(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private FunctionBasedConverter(n<? super A, ? extends B> nVar, n<? super B, ? extends A> nVar2) {
            this.forwardFunction = (n) u.E(nVar);
            this.backwardFunction = (n) u.E(nVar2);
        }
    }

    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) u.F(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t10) {
            return t10;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t10) {
            return t10;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public B correctedDoBackward(@CheckForNull A a10) {
            return this.original.correctedDoForward(a10);
        }

        @Override // com.google.common.base.Converter
        @CheckForNull
        public A correctedDoForward(@CheckForNull B b10) {
            return this.original.correctedDoBackward(b10);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, b5.n
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            String valueOf = String.valueOf(this.original);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
            sb2.append(valueOf);
            sb2.append(".reverse()");
            return sb2.toString();
        }
    }

    public class a implements Iterable<B> {

        /* renamed from: b */
        public final /* synthetic */ Iterable f9103b;

        /* renamed from: com.google.common.base.Converter$a$a */
        public class C0257a implements Iterator<B> {

            /* renamed from: b */
            public final Iterator<? extends A> f9105b;

            public C0257a() {
                this.f9105b = a.this.f9103b.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f9105b.hasNext();
            }

            @Override // java.util.Iterator
            @CheckForNull
            public B next() {
                return (B) Converter.this.convert(this.f9105b.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f9105b.remove();
            }
        }

        public a(Iterable iterable) {
            this.f9103b = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0257a();
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(n<? super A, ? extends B> nVar, n<? super B, ? extends A> nVar2) {
        return new FunctionBasedConverter(nVar, nVar2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public final A a(@CheckForNull B b10) {
        return (A) doBackward(q.a(b10));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // b5.n
    @CheckForNull
    @Deprecated
    @CanIgnoreReturnValue
    @InlineMe(replacement = "this.convert(a)")
    public final B apply(@CheckForNull A a10) {
        return convert(a10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public final B b(@CheckForNull A a10) {
        return (B) doForward(q.a(a10));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final B convert(@CheckForNull A a10) {
        return correctedDoForward(a10);
    }

    @CanIgnoreReturnValue
    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        u.F(iterable, "fromIterable");
        return new a(iterable);
    }

    @CheckForNull
    public A correctedDoBackward(@CheckForNull B b10) {
        if (!this.handleNullAutomatically) {
            return a(b10);
        }
        if (b10 == null) {
            return null;
        }
        return (A) u.E(doBackward(b10));
    }

    @CheckForNull
    public B correctedDoForward(@CheckForNull A a10) {
        if (!this.handleNullAutomatically) {
            return b(a10);
        }
        if (a10 == null) {
            return null;
        }
        return (B) u.E(doForward(a10));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) u.E(converter));
    }

    @ForOverride
    public abstract A doBackward(B b10);

    @ForOverride
    public abstract B doForward(A a10);

    @Override // b5.n
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @CheckReturnValue
    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    public Converter(boolean z10) {
        this.handleNullAutomatically = z10;
    }
}
