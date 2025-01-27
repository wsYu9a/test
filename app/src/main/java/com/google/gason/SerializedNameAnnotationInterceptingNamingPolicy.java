package com.google.gason;

import com.google.gason.annotations.SerializedName;

/* loaded from: classes7.dex */
final class SerializedNameAnnotationInterceptingNamingPolicy implements FieldNamingStrategy2 {
    private final FieldNamingStrategy2 delegate;

    SerializedNameAnnotationInterceptingNamingPolicy(FieldNamingStrategy2 fieldNamingStrategy2) {
        this.delegate = fieldNamingStrategy2;
    }

    @Override // com.google.gason.FieldNamingStrategy2
    public String translateName(FieldAttributes fieldAttributes) {
        SerializedName serializedName = (SerializedName) fieldAttributes.getAnnotation(SerializedName.class);
        return serializedName == null ? this.delegate.translateName(fieldAttributes) : serializedName.value();
    }
}
