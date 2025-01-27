package com.google.gason;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
final class LowerCaseNamingPolicy extends RecursiveFieldNamingPolicy {
    LowerCaseNamingPolicy() {
    }

    @Override // com.google.gason.RecursiveFieldNamingPolicy
    protected String translateName(String str, Type type, Collection<Annotation> collection) {
        return str.toLowerCase();
    }
}
