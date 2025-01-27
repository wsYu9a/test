package com.google.gason.internal.bind;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* loaded from: classes7.dex */
final class Reflection {
    Reflection() {
    }

    public static Type getRuntimeTypeIfMoreSpecific(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }
}
