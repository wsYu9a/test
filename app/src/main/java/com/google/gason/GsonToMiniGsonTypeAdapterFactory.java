package com.google.gason;

import com.google.gason.internal.ParameterizedTypeHandlerMap;
import com.google.gason.internal.Streams;
import com.google.gason.internal.bind.MiniGson;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
final class GsonToMiniGsonTypeAdapterFactory implements TypeAdapter.Factory {
    private final JsonDeserializationContext deserializationContext;
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private final JsonSerializationContext serializationContext;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;

    /* renamed from: com.google.gason.GsonToMiniGsonTypeAdapterFactory$1 */
    class AnonymousClass1 implements JsonDeserializationContext {
        final GsonToMiniGsonTypeAdapterFactory this$0;
        final Gson val$gson;

        AnonymousClass1(GsonToMiniGsonTypeAdapterFactory gsonToMiniGsonTypeAdapterFactory, Gson gson) {
            this.this$0 = gsonToMiniGsonTypeAdapterFactory;
            this.val$gson = gson;
        }

        @Override // com.google.gason.JsonDeserializationContext
        public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
            return (T) this.val$gson.fromJson(jsonElement, type);
        }
    }

    /* renamed from: com.google.gason.GsonToMiniGsonTypeAdapterFactory$2 */
    class AnonymousClass2 implements JsonSerializationContext {
        final GsonToMiniGsonTypeAdapterFactory this$0;
        final Gson val$gson;

        AnonymousClass2(GsonToMiniGsonTypeAdapterFactory gsonToMiniGsonTypeAdapterFactory, Gson gson) {
            this.this$0 = gsonToMiniGsonTypeAdapterFactory;
            this.val$gson = gson;
        }

        @Override // com.google.gason.JsonSerializationContext
        public JsonElement serialize(Object obj) {
            return this.val$gson.toJsonTree(obj);
        }

        @Override // com.google.gason.JsonSerializationContext
        public JsonElement serialize(Object obj, Type type) {
            return this.val$gson.toJsonTree(obj, type);
        }
    }

    /* renamed from: com.google.gason.GsonToMiniGsonTypeAdapterFactory$3 */
    class AnonymousClass3<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;
        final GsonToMiniGsonTypeAdapterFactory this$0;
        final MiniGson val$context;
        final JsonDeserializer val$deserializer;
        final JsonSerializer val$serializer;
        final Type val$type;
        final TypeToken val$typeToken;

        AnonymousClass3(GsonToMiniGsonTypeAdapterFactory gsonToMiniGsonTypeAdapterFactory, JsonDeserializer jsonDeserializer, Type type, JsonSerializer jsonSerializer, MiniGson miniGson, TypeToken typeToken) throws IOException {
            this.this$0 = gsonToMiniGsonTypeAdapterFactory;
            this.val$deserializer = jsonDeserializer;
            this.val$type = type;
            this.val$serializer = jsonSerializer;
            this.val$context = miniGson;
            this.val$typeToken = typeToken;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            TypeAdapter<T> nextAdapter = this.val$context.getNextAdapter(this.this$0, this.val$typeToken);
            this.delegate = nextAdapter;
            return nextAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (this.val$deserializer == null) {
                return delegate().read(jsonReader);
            }
            JsonElement parse = Streams.parse(jsonReader);
            if (parse.isJsonNull()) {
                return null;
            }
            return (T) this.val$deserializer.deserialize(parse, this.val$type, this.this$0.deserializationContext);
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            JsonSerializer jsonSerializer = this.val$serializer;
            if (jsonSerializer == null) {
                delegate().write(jsonWriter, (JsonWriter) t);
            } else if (t == null) {
                jsonWriter.nullValue();
            } else {
                Streams.write(jsonSerializer.serialize(t, this.val$type, this.this$0.serializationContext), jsonWriter);
            }
        }
    }

    public GsonToMiniGsonTypeAdapterFactory(Gson gson, ParameterizedTypeHandlerMap<JsonSerializer<?>> parameterizedTypeHandlerMap, ParameterizedTypeHandlerMap<JsonDeserializer<?>> parameterizedTypeHandlerMap2) {
        this.serializers = parameterizedTypeHandlerMap;
        this.deserializers = parameterizedTypeHandlerMap2;
        this.deserializationContext = new JsonDeserializationContext(this, gson) { // from class: com.google.gason.GsonToMiniGsonTypeAdapterFactory.1
            final GsonToMiniGsonTypeAdapterFactory this$0;
            final Gson val$gson;

            AnonymousClass1(GsonToMiniGsonTypeAdapterFactory this, Gson gson2) {
                this.this$0 = this;
                this.val$gson = gson2;
            }

            @Override // com.google.gason.JsonDeserializationContext
            public <T> T deserialize(JsonElement jsonElement, Type type) throws JsonParseException {
                return (T) this.val$gson.fromJson(jsonElement, type);
            }
        };
        this.serializationContext = new JsonSerializationContext(this, gson2) { // from class: com.google.gason.GsonToMiniGsonTypeAdapterFactory.2
            final GsonToMiniGsonTypeAdapterFactory this$0;
            final Gson val$gson;

            AnonymousClass2(GsonToMiniGsonTypeAdapterFactory this, Gson gson2) {
                this.this$0 = this;
                this.val$gson = gson2;
            }

            @Override // com.google.gason.JsonSerializationContext
            public JsonElement serialize(Object obj) {
                return this.val$gson.toJsonTree(obj);
            }

            @Override // com.google.gason.JsonSerializationContext
            public JsonElement serialize(Object obj, Type type) {
                return this.val$gson.toJsonTree(obj, type);
            }
        };
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        JsonSerializer<?> handlerFor = this.serializers.getHandlerFor(type, false);
        JsonDeserializer<?> handlerFor2 = this.deserializers.getHandlerFor(type, false);
        if (handlerFor == null && handlerFor2 == null) {
            return null;
        }
        return new TypeAdapter<T>(this, handlerFor2, type, handlerFor, miniGson, typeToken) { // from class: com.google.gason.GsonToMiniGsonTypeAdapterFactory.3
            private TypeAdapter<T> delegate;
            final GsonToMiniGsonTypeAdapterFactory this$0;
            final MiniGson val$context;
            final JsonDeserializer val$deserializer;
            final JsonSerializer val$serializer;
            final Type val$type;
            final TypeToken val$typeToken;

            AnonymousClass3(GsonToMiniGsonTypeAdapterFactory this, JsonDeserializer handlerFor22, Type type2, JsonSerializer handlerFor3, MiniGson miniGson2, TypeToken typeToken2) throws IOException {
                this.this$0 = this;
                this.val$deserializer = handlerFor22;
                this.val$type = type2;
                this.val$serializer = handlerFor3;
                this.val$context = miniGson2;
                this.val$typeToken = typeToken2;
            }

            private TypeAdapter<T> delegate() {
                TypeAdapter<T> typeAdapter = this.delegate;
                if (typeAdapter != null) {
                    return typeAdapter;
                }
                TypeAdapter<T> nextAdapter = this.val$context.getNextAdapter(this.this$0, this.val$typeToken);
                this.delegate = nextAdapter;
                return nextAdapter;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public T read(JsonReader jsonReader) throws IOException {
                if (this.val$deserializer == null) {
                    return delegate().read(jsonReader);
                }
                JsonElement parse = Streams.parse(jsonReader);
                if (parse.isJsonNull()) {
                    return null;
                }
                return (T) this.val$deserializer.deserialize(parse, this.val$type, this.this$0.deserializationContext);
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, T t) throws IOException {
                JsonSerializer jsonSerializer = this.val$serializer;
                if (jsonSerializer == null) {
                    delegate().write(jsonWriter, (JsonWriter) t);
                } else if (t == null) {
                    jsonWriter.nullValue();
                } else {
                    Streams.write(jsonSerializer.serialize(t, this.val$type, this.this$0.serializationContext), jsonWriter);
                }
            }
        };
    }
}
