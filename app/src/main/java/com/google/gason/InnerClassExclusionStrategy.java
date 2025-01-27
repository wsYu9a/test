package com.google.gason;

/* loaded from: classes7.dex */
final class InnerClassExclusionStrategy implements ExclusionStrategy {
    InnerClassExclusionStrategy() {
    }

    private boolean isInnerClass(Class<?> cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class<?> cls) {
        return ((((Integer) new Object[]{new Integer(5157494)}[0]).intValue() ^ 5157502) & cls.getModifiers()) != 0;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return isInnerClass(cls);
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return isInnerClass(fieldAttributes.getDeclaredClass());
    }
}
