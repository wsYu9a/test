package com.google.gason;

import com.google.gason.internal.C$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes7.dex */
final class CamelCaseSeparatorNamingPolicy extends RecursiveFieldNamingPolicy {
    private final String separatorString;

    public CamelCaseSeparatorNamingPolicy(String str) {
        C$Gson$Preconditions.checkNotNull(str);
        C$Gson$Preconditions.checkArgument(!"".equals(str));
        this.separatorString = str;
    }

    @Override // com.google.gason.RecursiveFieldNamingPolicy
    protected String translateName(String str, Type type, Collection<Annotation> collection) {
        Integer num = new Integer(6785310);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 6785311) + i2) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(this.separatorString);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
