package com.wbl.ad.yzz.gson;

/* loaded from: classes5.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.wbl.ad.yzz.gson.LongSerializationPolicy.1
        @Override // com.wbl.ad.yzz.gson.LongSerializationPolicy
        public k serialize(Long l) {
            return new n(l);
        }
    },
    STRING { // from class: com.wbl.ad.yzz.gson.LongSerializationPolicy.2
        @Override // com.wbl.ad.yzz.gson.LongSerializationPolicy
        public k serialize(Long l) {
            return new n(String.valueOf(l));
        }
    };

    /* renamed from: com.wbl.ad.yzz.gson.LongSerializationPolicy$1 */
    public enum AnonymousClass1 extends LongSerializationPolicy {
        @Override // com.wbl.ad.yzz.gson.LongSerializationPolicy
        public k serialize(Long l) {
            return new n(l);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.LongSerializationPolicy$2 */
    public enum AnonymousClass2 extends LongSerializationPolicy {
        @Override // com.wbl.ad.yzz.gson.LongSerializationPolicy
        public k serialize(Long l) {
            return new n(String.valueOf(l));
        }
    }

    public abstract k serialize(Long l);

    /* synthetic */ LongSerializationPolicy(AnonymousClass1 anonymousClass1) {
        this();
    }
}
