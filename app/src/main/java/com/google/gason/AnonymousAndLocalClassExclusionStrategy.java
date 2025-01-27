package com.google.gason;

/* loaded from: classes7.dex */
final class AnonymousAndLocalClassExclusionStrategy implements ExclusionStrategy {
    AnonymousAndLocalClassExclusionStrategy() {
    }

    private boolean isAnonymousOrLocal(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return isAnonymousOrLocal(cls);
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return isAnonymousOrLocal(fieldAttributes.getDeclaredClass());
    }
}
