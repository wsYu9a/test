package com.google.common.hash;

import i5.h;
import i5.u;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@a5.a
@h
/* loaded from: classes2.dex */
public final class Funnels {

    public enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, u uVar) {
            uVar.a(bArr);
        }
    }

    public enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, u uVar) {
            uVar.putInt(num.intValue());
        }
    }

    public enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Long l10, u uVar) {
            uVar.putLong(l10.longValue());
        }
    }

    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) b5.u.E(funnel);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.elementFunnel);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
            sb2.append("Funnels.sequentialFunnel(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Iterable<? extends E> iterable, u uVar) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                this.elementFunnel.funnel(it.next(), uVar);
            }
        }
    }

    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        public static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            public SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.f(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset charset) {
            this.charset = (Charset) b5.u.E(charset);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            String name = this.charset.name();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 22);
            sb2.append("Funnels.stringFunnel(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, u uVar) {
            uVar.g(charSequence, this.charset);
        }
    }

    public enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, u uVar) {
            uVar.d(charSequence);
        }
    }

    public static class a extends OutputStream {

        /* renamed from: b */
        public final u f10049b;

        public a(u uVar) {
            this.f10049b = (u) b5.u.E(uVar);
        }

        public String toString() {
            String valueOf = String.valueOf(this.f10049b);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 24);
            sb2.append("Funnels.asOutputStream(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // java.io.OutputStream
        public void write(int i10) {
            this.f10049b.c((byte) i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f10049b.a(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) {
            this.f10049b.e(bArr, i10, i11);
        }
    }

    public static OutputStream a(u uVar) {
        return new a(uVar);
    }

    public static Funnel<byte[]> b() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<Integer> c() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> d() {
        return LongFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> e(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    public static Funnel<CharSequence> f(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    public static Funnel<CharSequence> g() {
        return UnencodedCharsFunnel.INSTANCE;
    }
}
