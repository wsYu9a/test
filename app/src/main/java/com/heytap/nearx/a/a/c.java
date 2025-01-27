package com.heytap.nearx.a.a;

import com.heytap.nearx.a.a.b;
import com.heytap.nearx.a.a.b.a;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/* loaded from: classes.dex */
final class c<M extends b<M, B>, B extends b.a<M, B>> implements Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    private final byte[] f9022a;

    /* renamed from: b */
    private final Class<M> f9023b;

    public c(byte[] bArr, Class<M> cls) {
        this.f9022a = bArr;
        this.f9023b = cls;
    }

    Object readResolve() throws ObjectStreamException {
        try {
            return e.b((Class) this.f9023b).a(this.f9022a);
        } catch (IOException e2) {
            throw new StreamCorruptedException(e2.getMessage());
        }
    }
}
