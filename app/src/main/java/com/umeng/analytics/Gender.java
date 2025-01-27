package com.umeng.analytics;

import java.util.Locale;

/* loaded from: classes4.dex */
public class Gender extends Enum<Gender> {
    public static final Gender Female;
    public static final Gender Male;
    public static final Gender Unknown;

    /* renamed from: a */
    private static final /* synthetic */ Gender[] f25578a;
    public int value;

    /* renamed from: com.umeng.analytics.Gender$1 */
    enum AnonymousClass1 extends Gender {
        AnonymousClass1(String str, int i2, int i3) {
            super(str, i2, i3);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$2 */
    enum AnonymousClass2 extends Gender {
        AnonymousClass2(String str, int i2, int i3) {
            super(str, i2, i3);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$3 */
    enum AnonymousClass3 extends Gender {
        AnonymousClass3(String str, int i2, int i3) {
            super(str, i2, i3);
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
        }
    }

    /* renamed from: com.umeng.analytics.Gender$4 */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f25579a;

        static {
            int[] iArr = new int[Gender.values().length];
            f25579a = iArr;
            try {
                iArr[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25579a[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25579a[Gender.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new Gender("Male", 0, 1) { // from class: com.umeng.analytics.Gender.1
            AnonymousClass1(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Male:%d", Integer.valueOf(this.value));
            }
        };
        Male = anonymousClass1;
        AnonymousClass2 anonymousClass2 = new Gender("Female", 1, 2) { // from class: com.umeng.analytics.Gender.2
            AnonymousClass2(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Female:%d", Integer.valueOf(this.value));
            }
        };
        Female = anonymousClass2;
        AnonymousClass3 anonymousClass3 = new Gender("Unknown", 2, 0) { // from class: com.umeng.analytics.Gender.3
            AnonymousClass3(String str, int i2, int i3) {
                super(str, i2, i3);
            }

            @Override // java.lang.Enum
            public String toString() {
                return String.format(Locale.US, "Unknown:%d", Integer.valueOf(this.value));
            }
        };
        Unknown = anonymousClass3;
        f25578a = new Gender[]{anonymousClass1, anonymousClass2, anonymousClass3};
    }

    /* synthetic */ Gender(String str, int i2, int i3, AnonymousClass1 anonymousClass1) {
        this(str, i2, i3);
    }

    public static Gender getGender(int i2) {
        return i2 != 1 ? i2 != 2 ? Unknown : Female : Male;
    }

    public static com.umeng.commonsdk.statistics.proto.Gender transGender(Gender gender) {
        int i2 = AnonymousClass4.f25579a[gender.ordinal()];
        return i2 != 1 ? i2 != 2 ? com.umeng.commonsdk.statistics.proto.Gender.UNKNOWN : com.umeng.commonsdk.statistics.proto.Gender.FEMALE : com.umeng.commonsdk.statistics.proto.Gender.MALE;
    }

    public static Gender valueOf(String str) {
        return (Gender) Enum.valueOf(Gender.class, str);
    }

    public static Gender[] values() {
        return (Gender[]) f25578a.clone();
    }

    public int value() {
        return this.value;
    }

    private Gender(String str, int i2, int i3) {
        super(str, i2);
        this.value = i3;
    }
}
