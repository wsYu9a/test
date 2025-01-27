package com.wbl.ad.yzz.gson;

import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class q<T> {
    public final q<T> a() {
        return new a();
    }

    public abstract T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException;

    public abstract void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException;

    public class a extends q<T> {
        public a() {
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, T t) throws IOException {
            if (t == null) {
                bVar.k();
            } else {
                q.this.a(bVar, t);
            }
        }

        @Override // com.wbl.ad.yzz.gson.q
        public T a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            return (T) q.this.a(aVar);
        }
    }

    public final k a(T t) {
        try {
            com.wbl.ad.yzz.gson.t.k.f fVar = new com.wbl.ad.yzz.gson.t.k.f();
            a(fVar, t);
            return fVar.n();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }
}
