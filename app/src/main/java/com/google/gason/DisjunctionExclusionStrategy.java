package com.google.gason;

import com.google.gason.internal.C$Gson$Preconditions;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes7.dex */
final class DisjunctionExclusionStrategy implements ExclusionStrategy {
    private final Collection<ExclusionStrategy> strategies;

    DisjunctionExclusionStrategy(Collection<ExclusionStrategy> collection) {
        this.strategies = (Collection) C$Gson$Preconditions.checkNotNull(collection);
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        Iterator<ExclusionStrategy> it = this.strategies.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        Iterator<ExclusionStrategy> it = this.strategies.iterator();
        while (it.hasNext()) {
            if (it.next().shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }
}
