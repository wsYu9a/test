package com.google.gason;

/* loaded from: classes7.dex */
final class SyntheticFieldExclusionStrategy implements ExclusionStrategy {
    private final boolean skipSyntheticFields;

    SyntheticFieldExclusionStrategy(boolean z) {
        this.skipSyntheticFields = z;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return this.skipSyntheticFields && fieldAttributes.isSynthetic();
    }
}
