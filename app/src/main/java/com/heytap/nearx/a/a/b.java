package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import okio.Buffer;
import okio.ByteString;

/* loaded from: classes.dex */
public abstract class b<M extends b<M, B>, B extends a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    transient int f9016a = 0;

    /* renamed from: b */
    protected transient int f9017b = 0;

    /* renamed from: c */
    private final transient e<M> f9018c;

    /* renamed from: d */
    private final transient ByteString f9019d;

    public static abstract class a<T extends b<T, B>, B extends a<T, B>> {

        /* renamed from: a */
        Buffer f9020a;

        /* renamed from: b */
        g f9021b;

        protected a() {
        }

        public final a<T, B> a(int i2, com.heytap.nearx.a.a.a aVar, Object obj) {
            if (this.f9021b == null) {
                Buffer buffer = new Buffer();
                this.f9020a = buffer;
                this.f9021b = new g(buffer);
            }
            try {
                aVar.a().a(this.f9021b, i2, obj);
                return this;
            } catch (IOException unused) {
                throw new AssertionError();
            }
        }

        public final a<T, B> a(ByteString byteString) {
            if (byteString.size() > 0) {
                if (this.f9021b == null) {
                    Buffer buffer = new Buffer();
                    this.f9020a = buffer;
                    this.f9021b = new g(buffer);
                }
                try {
                    this.f9021b.a(byteString);
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return this;
        }

        public final ByteString a() {
            Buffer buffer = this.f9020a;
            return buffer != null ? buffer.clone().readByteString() : ByteString.EMPTY;
        }
    }

    protected b(e<M> eVar, ByteString byteString) {
        if (eVar == null) {
            throw new NullPointerException("adapter == null");
        }
        if (byteString == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.f9018c = eVar;
        this.f9019d = byteString;
    }

    public final ByteString a() {
        ByteString byteString = this.f9019d;
        return byteString != null ? byteString : ByteString.EMPTY;
    }

    public final byte[] b() {
        return this.f9018c.b((e<M>) this);
    }

    public String toString() {
        return this.f9018c.c(this);
    }

    protected final Object writeReplace() throws ObjectStreamException {
        return new c(b(), getClass());
    }
}
