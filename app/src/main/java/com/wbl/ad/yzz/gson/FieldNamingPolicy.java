package com.wbl.ad.yzz.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* loaded from: classes5.dex */
public enum FieldNamingPolicy implements d {
    IDENTITY { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.1
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.2
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.3
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(FieldNamingPolicy.a(field.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.4
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.5
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.wbl.ad.yzz.gson.FieldNamingPolicy.6
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$1 */
    public enum AnonymousClass1 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return field.getName();
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$2 */
    public enum AnonymousClass2 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName());
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$3 */
    public enum AnonymousClass3 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(FieldNamingPolicy.a(field.getName(), " "));
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$4 */
    public enum AnonymousClass4 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$5 */
    public enum AnonymousClass5 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    }

    /* renamed from: com.wbl.ad.yzz.gson.FieldNamingPolicy$6 */
    public enum AnonymousClass6 extends FieldNamingPolicy {
        @Override // com.wbl.ad.yzz.gson.FieldNamingPolicy, com.wbl.ad.yzz.gson.d
        public String translateName(Field field) {
            return FieldNamingPolicy.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    @Override // com.wbl.ad.yzz.gson.d
    public abstract /* synthetic */ String translateName(Field field);

    /* synthetic */ FieldNamingPolicy(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i2 < length - 1 && !Character.isLetter(charAt)) {
            sb.append(charAt);
            i2++;
            charAt = str.charAt(i2);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        sb.append(a(Character.toUpperCase(charAt), str, i2 + 1));
        return sb.toString();
    }

    public static String a(char c2, String str, int i2) {
        if (i2 < str.length()) {
            return c2 + str.substring(i2);
        }
        return String.valueOf(c2);
    }
}
