package com.google.gason;

import com.google.gason.internal.C$Gson$Preconditions;

/* loaded from: classes7.dex */
final class FieldNamingStrategy2Adapter implements FieldNamingStrategy2 {
    private final FieldNamingStrategy adaptee;

    FieldNamingStrategy2Adapter(FieldNamingStrategy fieldNamingStrategy) {
        this.adaptee = (FieldNamingStrategy) C$Gson$Preconditions.checkNotNull(fieldNamingStrategy);
    }

    @Override // com.google.gason.FieldNamingStrategy2
    public String translateName(FieldAttributes fieldAttributes) {
        return this.adaptee.translateName(fieldAttributes.getFieldObject());
    }
}
