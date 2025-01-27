package com.google.gson;

/* loaded from: classes2.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10.toString());
        }
    };

    /* renamed from: com.google.gson.LongSerializationPolicy$1 */
    public enum AnonymousClass1 extends LongSerializationPolicy {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10);
        }
    }

    /* renamed from: com.google.gson.LongSerializationPolicy$2 */
    public enum AnonymousClass2 extends LongSerializationPolicy {
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l10) {
            return l10 == null ? JsonNull.INSTANCE : new JsonPrimitive(l10.toString());
        }
    }

    public abstract JsonElement serialize(Long l10);

    /* synthetic */ LongSerializationPolicy(AnonymousClass1 anonymousClass1) {
        this();
    }
}
