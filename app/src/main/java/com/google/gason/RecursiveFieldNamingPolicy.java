package com.google.gason;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
abstract class RecursiveFieldNamingPolicy implements FieldNamingStrategy2 {
    RecursiveFieldNamingPolicy() {
    }

    @Override // com.google.gason.FieldNamingStrategy2
    public final String translateName(FieldAttributes fieldAttributes) {
        return translateName(fieldAttributes.getName(), fieldAttributes.getDeclaredType(), fieldAttributes.getAnnotations());
    }

    protected abstract String translateName(String str, Type type, Collection<Annotation> collection);
}
