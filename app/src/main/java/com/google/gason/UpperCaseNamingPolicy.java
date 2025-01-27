package com.google.gason;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
final class UpperCaseNamingPolicy extends RecursiveFieldNamingPolicy {
    UpperCaseNamingPolicy() {
    }

    @Override // com.google.gason.RecursiveFieldNamingPolicy
    protected String translateName(String str, Type type, Collection<Annotation> collection) {
        return str.toUpperCase();
    }
}
