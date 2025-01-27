package com.google.gason.internal.bind;

import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.ObjectConstructor;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class CollectionTypeAdapterFactory implements TypeAdapter.Factory {
    private final ConstructorConstructor constructorConstructor;

    private final class Adapter<E> extends TypeAdapter<Collection<E>> {
        private final ObjectConstructor<? extends Collection<E>> constructor;
        private final TypeAdapter<E> elementTypeAdapter;
        final CollectionTypeAdapterFactory this$0;

        public Adapter(CollectionTypeAdapterFactory collectionTypeAdapterFactory, MiniGson miniGson, Type type, TypeAdapter<E> typeAdapter, ObjectConstructor<? extends Collection<E>> objectConstructor) {
            this.this$0 = collectionTypeAdapterFactory;
            this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper(miniGson, typeAdapter, type);
            this.constructor = objectConstructor;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Collection<E> read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            Collection<E> construct = this.constructor.construct();
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                construct.add(this.elementTypeAdapter.read(jsonReader));
            }
            jsonReader.endArray();
            return construct;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Collection<E> collection) throws IOException {
            if (collection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.elementTypeAdapter.write(jsonWriter, (JsonWriter) it.next());
            }
            jsonWriter.endArray();
        }
    }

    public CollectionTypeAdapterFactory(ConstructorConstructor constructorConstructor) {
        this.constructorConstructor = constructorConstructor;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type collectionElementType = C$Gson$Types.getCollectionElementType(type, rawType);
        return new Adapter(this, miniGson, collectionElementType, miniGson.getAdapter(TypeToken.get(collectionElementType)), this.constructorConstructor.getConstructor(typeToken));
    }
}
