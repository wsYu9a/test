package com.google.gason;

import com.google.gason.annotations.Expose;

/* loaded from: classes7.dex */
final class ExposeAnnotationSerializationExclusionStrategy implements ExclusionStrategy {
    ExposeAnnotationSerializationExclusionStrategy() {
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (((Expose) fieldAttributes.getAnnotation(Expose.class)) == null) {
            return true;
        }
        return !r0.serialize();
    }
}
