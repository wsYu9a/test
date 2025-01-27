package com.google.gason.internal.bind;

import com.google.gason.ExclusionStrategy;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes7.dex */
public final class ExcludedTypeAdapterFactory implements TypeAdapter.Factory {
    private final ExclusionStrategy deserializationExclusionStrategy;
    private final ExclusionStrategy serializationExclusionStrategy;

    /* renamed from: com.google.gason.internal.bind.ExcludedTypeAdapterFactory$1 */
    class AnonymousClass1<T> extends TypeAdapter<T> {
        private TypeAdapter<T> delegate;
        final ExcludedTypeAdapterFactory this$0;
        final MiniGson val$context;
        final boolean val$skipDeserialize;
        final boolean val$skipSerialize;
        final TypeToken val$type;

        AnonymousClass1(ExcludedTypeAdapterFactory excludedTypeAdapterFactory, boolean z, boolean z2, MiniGson miniGson, TypeToken typeToken) throws IOException {
            this.this$0 = excludedTypeAdapterFactory;
            this.val$skipDeserialize = z;
            this.val$skipSerialize = z2;
            this.val$context = miniGson;
            this.val$type = typeToken;
        }

        private TypeAdapter<T> delegate() {
            TypeAdapter<T> typeAdapter = this.delegate;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            TypeAdapter<T> nextAdapter = this.val$context.getNextAdapter(this.this$0, this.val$type);
            this.delegate = nextAdapter;
            return nextAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (!this.val$skipDeserialize) {
                return delegate().read(jsonReader);
            }
            jsonReader.skipValue();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (this.val$skipSerialize) {
                jsonWriter.nullValue();
            } else {
                delegate().write(jsonWriter, (JsonWriter) t);
            }
        }
    }

    public ExcludedTypeAdapterFactory(ExclusionStrategy exclusionStrategy, ExclusionStrategy exclusionStrategy2) {
        this.serializationExclusionStrategy = exclusionStrategy;
        this.deserializationExclusionStrategy = exclusionStrategy2;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter.Factory
    public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        boolean shouldSkipClass = this.serializationExclusionStrategy.shouldSkipClass(rawType);
        boolean shouldSkipClass2 = this.deserializationExclusionStrategy.shouldSkipClass(rawType);
        if (shouldSkipClass || shouldSkipClass2) {
            return new TypeAdapter<T>(this, shouldSkipClass2, shouldSkipClass, miniGson, typeToken) { // from class: com.google.gason.internal.bind.ExcludedTypeAdapterFactory.1
                private TypeAdapter<T> delegate;
                final ExcludedTypeAdapterFactory this$0;
                final MiniGson val$context;
                final boolean val$skipDeserialize;
                final boolean val$skipSerialize;
                final TypeToken val$type;

                AnonymousClass1(ExcludedTypeAdapterFactory this, boolean shouldSkipClass22, boolean shouldSkipClass3, MiniGson miniGson2, TypeToken typeToken2) throws IOException {
                    this.this$0 = this;
                    this.val$skipDeserialize = shouldSkipClass22;
                    this.val$skipSerialize = shouldSkipClass3;
                    this.val$context = miniGson2;
                    this.val$type = typeToken2;
                }

                private TypeAdapter<T> delegate() {
                    TypeAdapter<T> typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter<T> nextAdapter = this.val$context.getNextAdapter(this.this$0, this.val$type);
                    this.delegate = nextAdapter;
                    return nextAdapter;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public T read(JsonReader jsonReader) throws IOException {
                    if (!this.val$skipDeserialize) {
                        return delegate().read(jsonReader);
                    }
                    jsonReader.skipValue();
                    return null;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public void write(JsonWriter jsonWriter, T t) throws IOException {
                    if (this.val$skipSerialize) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, (JsonWriter) t);
                    }
                }
            };
        }
        return null;
    }
}
