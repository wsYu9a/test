package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.internal.C$Gson$Types;
import com.wbl.ad.yzz.gson.q;
import com.wbl.ad.yzz.gson.r;
import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes5.dex */
public final class b implements r {

    /* renamed from: a */
    public final com.wbl.ad.yzz.gson.t.b f32306a;

    public b(com.wbl.ad.yzz.gson.t.b bVar) {
        this.f32306a = bVar;
    }

    @Override // com.wbl.ad.yzz.gson.r
    public <T> q<T> a(com.wbl.ad.yzz.gson.e eVar, com.wbl.ad.yzz.gson.u.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = C$Gson$Types.a(type, (Class<?>) a2);
        return new a(eVar, a3, eVar.a((com.wbl.ad.yzz.gson.u.a) com.wbl.ad.yzz.gson.u.a.a(a3)), this.f32306a.a(aVar));
    }

    public static final class a<E> extends q<Collection<E>> {

        /* renamed from: a */
        public final q<E> f32307a;

        /* renamed from: b */
        public final com.wbl.ad.yzz.gson.t.f<? extends Collection<E>> f32308b;

        public a(com.wbl.ad.yzz.gson.e eVar, Type type, q<E> qVar, com.wbl.ad.yzz.gson.t.f<? extends Collection<E>> fVar) {
            this.f32307a = new m(eVar, qVar, type);
            this.f32308b = fVar;
        }

        @Override // com.wbl.ad.yzz.gson.q
        /* renamed from: b */
        public Collection<E> a(com.wbl.ad.yzz.gson.v.a aVar) throws IOException {
            if (aVar.t() == JsonToken.NULL) {
                aVar.q();
                return null;
            }
            Collection<E> a2 = this.f32308b.a();
            aVar.a();
            while (aVar.i()) {
                a2.add(this.f32307a.a(aVar));
            }
            aVar.f();
            return a2;
        }

        @Override // com.wbl.ad.yzz.gson.q
        public void a(com.wbl.ad.yzz.gson.v.b bVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                bVar.k();
                return;
            }
            bVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f32307a.a(bVar, it.next());
            }
            bVar.e();
        }
    }
}
