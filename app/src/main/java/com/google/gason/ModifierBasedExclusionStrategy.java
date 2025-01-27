package com.google.gason;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes7.dex */
final class ModifierBasedExclusionStrategy implements ExclusionStrategy {
    private final Collection<Integer> modifiers;

    public ModifierBasedExclusionStrategy(int... iArr) {
        Integer num = new Integer(9558289);
        this.modifiers = new HashSet();
        if (iArr != null) {
            int length = iArr.length;
            for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 9558288) + i2) {
                this.modifiers.add(Integer.valueOf(iArr[i2]));
            }
        }
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    @Override // com.google.gason.ExclusionStrategy
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        Iterator<Integer> it = this.modifiers.iterator();
        while (it.hasNext()) {
            if (fieldAttributes.hasModifier(it.next().intValue())) {
                return true;
            }
        }
        return false;
    }
}
