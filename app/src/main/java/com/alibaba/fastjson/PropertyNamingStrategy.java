package com.alibaba.fastjson;

import b5.a;

/* loaded from: classes.dex */
public enum PropertyNamingStrategy {
    CamelCase,
    PascalCase,
    SnakeCase,
    KebabCase;

    /* renamed from: com.alibaba.fastjson.PropertyNamingStrategy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy;

        static {
            int[] iArr = new int[PropertyNamingStrategy.values().length];
            $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy = iArr;
            try {
                iArr[PropertyNamingStrategy.SnakeCase.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.KebabCase.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.PascalCase.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[PropertyNamingStrategy.CamelCase.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public String translate(String str) {
        int i10 = AnonymousClass1.$SwitchMap$com$alibaba$fastjson$PropertyNamingStrategy[ordinal()];
        int i11 = 0;
        if (i10 == 1) {
            StringBuilder sb2 = new StringBuilder();
            while (i11 < str.length()) {
                char charAt = str.charAt(i11);
                if (charAt < 'A' || charAt > 'Z') {
                    sb2.append(charAt);
                } else {
                    char c10 = (char) (charAt + a.O);
                    if (i11 > 0) {
                        sb2.append('_');
                    }
                    sb2.append(c10);
                }
                i11++;
            }
            return sb2.toString();
        }
        if (i10 == 2) {
            StringBuilder sb3 = new StringBuilder();
            while (i11 < str.length()) {
                char charAt2 = str.charAt(i11);
                if (charAt2 < 'A' || charAt2 > 'Z') {
                    sb3.append(charAt2);
                } else {
                    char c11 = (char) (charAt2 + a.O);
                    if (i11 > 0) {
                        sb3.append('-');
                    }
                    sb3.append(c11);
                }
                i11++;
            }
            return sb3.toString();
        }
        if (i10 == 3) {
            char charAt3 = str.charAt(0);
            if (charAt3 < 'a' || charAt3 > 'z') {
                return str;
            }
            char[] charArray = str.toCharArray();
            charArray[0] = (char) (charArray[0] - ' ');
            return new String(charArray);
        }
        if (i10 != 4) {
            return str;
        }
        char charAt4 = str.charAt(0);
        if (charAt4 < 'A' || charAt4 > 'Z') {
            return str;
        }
        char[] charArray2 = str.toCharArray();
        charArray2[0] = (char) (charArray2[0] + a.O);
        return new String(charArray2);
    }
}
