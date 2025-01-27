package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.internal.d;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapterFactory {

    /* renamed from: a */
    private final com.google.gson.internal.b f8082a;

    private static final class a<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a */
        private final TypeAdapter<E> f8083a;

        /* renamed from: b */
        private final d<? extends Collection<E>> f8084b;

        public a(Gson gson, Type type, TypeAdapter<E> typeAdapter, d<? extends Collection<E>> dVar) {
            this.f8083a = new c(gson, typeAdapter, type);
            this.f8084b = dVar;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: a */
        public Collection<E> read2(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.C() == JsonToken.NULL) {
                aVar.y();
                return null;
            }
            Collection<E> a2 = this.f8084b.a();
            aVar.f();
            while (aVar.p()) {
                a2.add(this.f8083a.read2(aVar));
            }
            aVar.k();
            return a2;
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: b */
        public void write(com.google.gson.stream.c cVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                cVar.m();
                return;
            }
            cVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f8083a.write(cVar, it.next());
            }
            cVar.f();
        }
    }

    public CollectionTypeAdapterFactory(com.google.gson.internal.b bVar) {
        this.f8082a = bVar;
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, com.google.gson.b.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> d2 = aVar.d();
        if (!Collection.class.isAssignableFrom(d2)) {
            return null;
        }
        Type j2 = C$Gson$Types.j(type, d2);
        return new a(gson, j2, gson.getAdapter(com.google.gson.b.a.c(j2)), this.f8082a.a(aVar));
    }
}
