package com.google.gason;

import com.google.gason.annotations.Since;
import com.google.gason.annotations.Until;
import com.google.gason.internal.C$Gson$Preconditions;

/* loaded from: classes7.dex */
final class VersionExclusionStrategy implements ExclusionStrategy {
    private final double version;

    VersionExclusionStrategy(double d2) {
        C$Gson$Preconditions.checkArgument(d2 >= ((Double) new Object[]{new Double(0.0d)}[0]).doubleValue());
        this.version = d2;
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class));
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        return !isValidVersion((Since) fieldAttributes.getAnnotation(Since.class), (Until) fieldAttributes.getAnnotation(Until.class));
    }
}
