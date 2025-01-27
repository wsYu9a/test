package com.google.gason.internal;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import com.google.gason.InstanceCreator;
import com.google.gason.reflect.TypeToken;
import com.tencent.a.C0521;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/* loaded from: classes7.dex */
public final class ConstructorConstructor {
    private final ParameterizedTypeHandlerMap<InstanceCreator<?>> instanceCreators;

    /* renamed from: com.google.gason.internal.ConstructorConstructor$1 */
    class AnonymousClass1<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;
        final InstanceCreator val$creator;
        final Type val$type;

        AnonymousClass1(ConstructorConstructor constructorConstructor, InstanceCreator instanceCreator, Type type) {
            this.this$0 = constructorConstructor;
            this.val$creator = instanceCreator;
            this.val$type = type;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) this.val$creator.createInstance(this.val$type);
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$2 */
    class AnonymousClass2<T> implements ObjectConstructor<T> {

        /* renamed from: short */
        private static final short[] f70short;
        final ConstructorConstructor this$0;
        final Constructor val$constructor;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(16238)}[0]).intValue() ^ 16240];
            sArr[0] = 1382;
            sArr[1] = 1329;
            sArr[2] = 1327;
            sArr[3] = 1330;
            sArr[4] = 1326;
            sArr[5] = 1382;
            sArr[6] = 1320;
            sArr[7] = 1321;
            sArr[8] = 1382;
            sArr[9] = 1319;
            sArr[10] = 1332;
            sArr[11] = 1313;
            sArr[12] = 1333;
            sArr[13] = 1497;
            sArr[14] = 1534;
            sArr[15] = 1526;
            sArr[16] = 1523;
            sArr[17] = 1530;
            sArr[18] = 1531;
            sArr[19] = 1471;
            sArr[20] = 1515;
            sArr[21] = 1520;
            sArr[22] = 1471;
            sArr[23] = 1526;
            sArr[24] = 1521;
            sArr[25] = 1513;
            sArr[26] = 1520;
            sArr[27] = 1524;
            sArr[28] = 1530;
            sArr[29] = 1471;
            f70short = sArr;
        }

        AnonymousClass2(ConstructorConstructor constructorConstructor, Constructor constructor) {
            this.this$0 = constructorConstructor;
            this.val$constructor = constructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            String m17 = C0005.m17(f70short, 1747719 ^ C0008.m27((Object) "۠ۡۨ"), 56502 ^ C0008.m27((Object) "ۦۡ"), C0008.m27((Object) "ۥۧ۠") ^ 1751864);
            String m3 = C0001.m3(f70short, 1752584 ^ C0008.m27((Object) "ۥۣۣ"), 1747885 ^ C0008.m27((Object) "ۣ۠ۧ"), C0008.m27((Object) "ۤۨۦ") ^ 1752957);
            try {
                return (T) this.val$constructor.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException(m3 + this.val$constructor + m17, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException(m3 + this.val$constructor + m17, e4.getTargetException());
            }
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$3 */
    class AnonymousClass3<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;

        AnonymousClass3(ConstructorConstructor constructorConstructor) {
            this.this$0 = constructorConstructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$4 */
    class AnonymousClass4<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;

        AnonymousClass4(ConstructorConstructor constructorConstructor) {
            this.this$0 = constructorConstructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$5 */
    class AnonymousClass5<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;

        AnonymousClass5(ConstructorConstructor constructorConstructor) {
            this.this$0 = constructorConstructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedList();
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$6 */
    class AnonymousClass6<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;

        AnonymousClass6(ConstructorConstructor constructorConstructor) {
            this.this$0 = constructorConstructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$7 */
    class AnonymousClass7<T> implements ObjectConstructor<T> {
        final ConstructorConstructor this$0;

        AnonymousClass7(ConstructorConstructor constructorConstructor) {
            this.this$0 = constructorConstructor;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* renamed from: com.google.gason.internal.ConstructorConstructor$8 */
    class AnonymousClass8<T> implements ObjectConstructor<T> {

        /* renamed from: short */
        private static final short[] f71short;
        final ConstructorConstructor this$0;
        private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
        final Class val$rawType;
        final Type val$type;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(3899682)}[0]).intValue() ^ 3899734];
            sArr[0] = 2214;
            sArr[1] = 2205;
            sArr[2] = 2194;
            sArr[3] = 2193;
            sArr[4] = 2207;
            sArr[5] = 2198;
            sArr[6] = 2259;
            sArr[7] = 2183;
            sArr[8] = 2204;
            sArr[9] = 2259;
            sArr[10] = 2202;
            sArr[11] = 2205;
            sArr[12] = 2181;
            sArr[13] = 2204;
            sArr[14] = 2200;
            sArr[15] = 2198;
            sArr[16] = 2259;
            sArr[17] = 2205;
            sArr[18] = 2204;
            sArr[19] = 2270;
            sArr[20] = 2194;
            sArr[21] = 2177;
            sArr[22] = 2196;
            sArr[23] = 2176;
            sArr[24] = 2259;
            sArr[25] = 2192;
            sArr[26] = 2204;
            sArr[27] = 2205;
            sArr[28] = 2176;
            sArr[29] = 2183;
            sArr[30] = 2177;
            sArr[31] = 2182;
            sArr[32] = 2192;
            sArr[33] = 2183;
            sArr[34] = 2204;
            sArr[35] = 2177;
            sArr[36] = 2259;
            sArr[37] = 2197;
            sArr[38] = 2204;
            sArr[39] = 2177;
            sArr[40] = 2259;
            sArr[41] = 1602;
            sArr[42] = 1612;
            sArr[43] = 922;
            sArr[44] = 941;
            sArr[45] = 943;
            sArr[46] = 929;
            sArr[47] = 955;
            sArr[48] = 956;
            sArr[49] = 941;
            sArr[50] = 954;
            sArr[51] = 1000;
            sArr[52] = 937;
            sArr[53] = 934;
            sArr[54] = 1000;
            sArr[55] = 897;
            sArr[56] = 934;
            sArr[57] = 955;
            sArr[58] = 956;
            sArr[59] = 937;
            sArr[60] = 934;
            sArr[61] = 939;
            sArr[62] = 941;
            sArr[63] = 907;
            sArr[64] = 954;
            sArr[65] = 941;
            sArr[66] = 937;
            sArr[67] = 956;
            sArr[68] = 935;
            sArr[69] = 954;
            sArr[70] = 1000;
            sArr[71] = 959;
            sArr[72] = 929;
            sArr[73] = 956;
            sArr[74] = 928;
            sArr[75] = 1000;
            sArr[76] = 911;
            sArr[77] = 955;
            sArr[78] = 935;
            sArr[79] = 934;
            sArr[80] = 1000;
            sArr[81] = 942;
            sArr[82] = 935;
            sArr[83] = 954;
            sArr[84] = 1000;
            sArr[85] = 956;
            sArr[86] = 928;
            sArr[87] = 929;
            sArr[88] = 955;
            sArr[89] = 1000;
            sArr[90] = 956;
            sArr[91] = 945;
            sArr[92] = 952;
            sArr[93] = 941;
            sArr[94] = 1000;
            sArr[95] = 933;
            sArr[96] = 937;
            sArr[97] = 945;
            sArr[98] = 1000;
            sArr[99] = 942;
            sArr[100] = 929;
            sArr[101] = 944;
            sArr[102] = 1000;
            sArr[103] = 956;
            sArr[104] = 928;
            sArr[105] = 929;
            sArr[106] = 955;
            sArr[107] = 1000;
            sArr[108] = 952;
            sArr[109] = 954;
            sArr[110] = 935;
            sArr[111] = 938;
            sArr[112] = 932;
            sArr[113] = 941;
            sArr[114] = 933;
            sArr[115] = 998;
            f71short = sArr;
        }

        AnonymousClass8(ConstructorConstructor constructorConstructor, Class cls, Type type) {
            this.this$0 = constructorConstructor;
            this.val$rawType = cls;
            this.val$type = type;
        }

        @Override // com.google.gason.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.unsafeAllocator.newInstance(this.val$rawType);
            } catch (Exception e2) {
                throw new RuntimeException(C0521.m71(f71short, 1747899 ^ C0008.m27((Object) "۠ۧۢ"), 1752745 ^ C0008.m27((Object) "ۥۧۢ"), C0008.m27((Object) "ۡۢ") ^ 54482) + this.val$type + C0006.m19(f71short, 1755616 ^ C0008.m27((Object) "ۨۧۨ"), 1749826 ^ C0008.m27((Object) "ۢۧۥ"), C0008.m27((Object) "ۣۢ۠") ^ 1750227) + C0004.m13(f71short, 1750825 ^ C0008.m27((Object) "ۣۧۦ"), 1746832 ^ C0008.m27((Object) "۟ۦ۠"), C0008.m27((Object) "ۦ۠") ^ 57202), e2);
            }
        }
    }

    public ConstructorConstructor() {
        this(new ParameterizedTypeHandlerMap());
    }

    public ConstructorConstructor(ParameterizedTypeHandlerMap<InstanceCreator<?>> parameterizedTypeHandlerMap) {
        this.instanceCreators = parameterizedTypeHandlerMap;
    }

    private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new ObjectConstructor<T>(this, declaredConstructor) { // from class: com.google.gason.internal.ConstructorConstructor.2

                /* renamed from: short */
                private static final short[] f70short;
                final ConstructorConstructor this$0;
                final Constructor val$constructor;

                static {
                    short[] sArr = new short[((Integer) new Object[]{new Integer(16238)}[0]).intValue() ^ 16240];
                    sArr[0] = 1382;
                    sArr[1] = 1329;
                    sArr[2] = 1327;
                    sArr[3] = 1330;
                    sArr[4] = 1326;
                    sArr[5] = 1382;
                    sArr[6] = 1320;
                    sArr[7] = 1321;
                    sArr[8] = 1382;
                    sArr[9] = 1319;
                    sArr[10] = 1332;
                    sArr[11] = 1313;
                    sArr[12] = 1333;
                    sArr[13] = 1497;
                    sArr[14] = 1534;
                    sArr[15] = 1526;
                    sArr[16] = 1523;
                    sArr[17] = 1530;
                    sArr[18] = 1531;
                    sArr[19] = 1471;
                    sArr[20] = 1515;
                    sArr[21] = 1520;
                    sArr[22] = 1471;
                    sArr[23] = 1526;
                    sArr[24] = 1521;
                    sArr[25] = 1513;
                    sArr[26] = 1520;
                    sArr[27] = 1524;
                    sArr[28] = 1530;
                    sArr[29] = 1471;
                    f70short = sArr;
                }

                AnonymousClass2(ConstructorConstructor this, Constructor declaredConstructor2) {
                    this.this$0 = this;
                    this.val$constructor = declaredConstructor2;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    String m17 = C0005.m17(f70short, 1747719 ^ C0008.m27((Object) "۠ۡۨ"), 56502 ^ C0008.m27((Object) "ۦۡ"), C0008.m27((Object) "ۥۧ۠") ^ 1751864);
                    String m3 = C0001.m3(f70short, 1752584 ^ C0008.m27((Object) "ۥۣۣ"), 1747885 ^ C0008.m27((Object) "ۣ۠ۧ"), C0008.m27((Object) "ۤۨۦ") ^ 1752957);
                    try {
                        return (T) this.val$constructor.newInstance(null);
                    } catch (IllegalAccessException e2) {
                        throw new AssertionError(e2);
                    } catch (InstantiationException e3) {
                        throw new RuntimeException(m3 + this.val$constructor + m17, e3);
                    } catch (InvocationTargetException e4) {
                        throw new RuntimeException(m3 + this.val$constructor + m17, e4.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException e2) {
            return null;
        }
    }

    private <T> ObjectConstructor<T> newDefaultImplementationConstructor(Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) { // from class: com.google.gason.internal.ConstructorConstructor.3
                final ConstructorConstructor this$0;

                AnonymousClass3(ConstructorConstructor this) {
                    this.this$0 = this;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeSet();
                }
            } : Set.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) { // from class: com.google.gason.internal.ConstructorConstructor.4
                final ConstructorConstructor this$0;

                AnonymousClass4(ConstructorConstructor this) {
                    this.this$0 = this;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new ObjectConstructor<T>(this) { // from class: com.google.gason.internal.ConstructorConstructor.5
                final ConstructorConstructor this$0;

                AnonymousClass5(ConstructorConstructor this) {
                    this.this$0 = this;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedList();
                }
            } : new ObjectConstructor<T>(this) { // from class: com.google.gason.internal.ConstructorConstructor.6
                final ConstructorConstructor this$0;

                AnonymousClass6(ConstructorConstructor this) {
                    this.this$0 = this;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>(this) { // from class: com.google.gason.internal.ConstructorConstructor.7
                final ConstructorConstructor this$0;

                AnonymousClass7(ConstructorConstructor this) {
                    this.this$0 = this;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Type type, Class<? super T> cls) {
        return new ObjectConstructor<T>(this, cls, type) { // from class: com.google.gason.internal.ConstructorConstructor.8

            /* renamed from: short */
            private static final short[] f71short;
            final ConstructorConstructor this$0;
            private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
            final Class val$rawType;
            final Type val$type;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(3899682)}[0]).intValue() ^ 3899734];
                sArr[0] = 2214;
                sArr[1] = 2205;
                sArr[2] = 2194;
                sArr[3] = 2193;
                sArr[4] = 2207;
                sArr[5] = 2198;
                sArr[6] = 2259;
                sArr[7] = 2183;
                sArr[8] = 2204;
                sArr[9] = 2259;
                sArr[10] = 2202;
                sArr[11] = 2205;
                sArr[12] = 2181;
                sArr[13] = 2204;
                sArr[14] = 2200;
                sArr[15] = 2198;
                sArr[16] = 2259;
                sArr[17] = 2205;
                sArr[18] = 2204;
                sArr[19] = 2270;
                sArr[20] = 2194;
                sArr[21] = 2177;
                sArr[22] = 2196;
                sArr[23] = 2176;
                sArr[24] = 2259;
                sArr[25] = 2192;
                sArr[26] = 2204;
                sArr[27] = 2205;
                sArr[28] = 2176;
                sArr[29] = 2183;
                sArr[30] = 2177;
                sArr[31] = 2182;
                sArr[32] = 2192;
                sArr[33] = 2183;
                sArr[34] = 2204;
                sArr[35] = 2177;
                sArr[36] = 2259;
                sArr[37] = 2197;
                sArr[38] = 2204;
                sArr[39] = 2177;
                sArr[40] = 2259;
                sArr[41] = 1602;
                sArr[42] = 1612;
                sArr[43] = 922;
                sArr[44] = 941;
                sArr[45] = 943;
                sArr[46] = 929;
                sArr[47] = 955;
                sArr[48] = 956;
                sArr[49] = 941;
                sArr[50] = 954;
                sArr[51] = 1000;
                sArr[52] = 937;
                sArr[53] = 934;
                sArr[54] = 1000;
                sArr[55] = 897;
                sArr[56] = 934;
                sArr[57] = 955;
                sArr[58] = 956;
                sArr[59] = 937;
                sArr[60] = 934;
                sArr[61] = 939;
                sArr[62] = 941;
                sArr[63] = 907;
                sArr[64] = 954;
                sArr[65] = 941;
                sArr[66] = 937;
                sArr[67] = 956;
                sArr[68] = 935;
                sArr[69] = 954;
                sArr[70] = 1000;
                sArr[71] = 959;
                sArr[72] = 929;
                sArr[73] = 956;
                sArr[74] = 928;
                sArr[75] = 1000;
                sArr[76] = 911;
                sArr[77] = 955;
                sArr[78] = 935;
                sArr[79] = 934;
                sArr[80] = 1000;
                sArr[81] = 942;
                sArr[82] = 935;
                sArr[83] = 954;
                sArr[84] = 1000;
                sArr[85] = 956;
                sArr[86] = 928;
                sArr[87] = 929;
                sArr[88] = 955;
                sArr[89] = 1000;
                sArr[90] = 956;
                sArr[91] = 945;
                sArr[92] = 952;
                sArr[93] = 941;
                sArr[94] = 1000;
                sArr[95] = 933;
                sArr[96] = 937;
                sArr[97] = 945;
                sArr[98] = 1000;
                sArr[99] = 942;
                sArr[100] = 929;
                sArr[101] = 944;
                sArr[102] = 1000;
                sArr[103] = 956;
                sArr[104] = 928;
                sArr[105] = 929;
                sArr[106] = 955;
                sArr[107] = 1000;
                sArr[108] = 952;
                sArr[109] = 954;
                sArr[110] = 935;
                sArr[111] = 938;
                sArr[112] = 932;
                sArr[113] = 941;
                sArr[114] = 933;
                sArr[115] = 998;
                f71short = sArr;
            }

            AnonymousClass8(ConstructorConstructor this, Class cls2, Type type2) {
                this.this$0 = this;
                this.val$rawType = cls2;
                this.val$type = type2;
            }

            @Override // com.google.gason.internal.ObjectConstructor
            public T construct() {
                try {
                    return (T) this.unsafeAllocator.newInstance(this.val$rawType);
                } catch (Exception e2) {
                    throw new RuntimeException(C0521.m71(f71short, 1747899 ^ C0008.m27((Object) "۠ۧۢ"), 1752745 ^ C0008.m27((Object) "ۥۧۢ"), C0008.m27((Object) "ۡۢ") ^ 54482) + this.val$type + C0006.m19(f71short, 1755616 ^ C0008.m27((Object) "ۨۧۨ"), 1749826 ^ C0008.m27((Object) "ۢۧۥ"), C0008.m27((Object) "ۣۢ۠") ^ 1750227) + C0004.m13(f71short, 1750825 ^ C0008.m27((Object) "ۣۧۦ"), 1746832 ^ C0008.m27((Object) "۟ۦ۠"), C0008.m27((Object) "ۦ۠") ^ 57202), e2);
                }
            }
        };
    }

    public <T> ObjectConstructor<T> getConstructor(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> handlerFor = this.instanceCreators.getHandlerFor(type, false);
        if (handlerFor != null) {
            return new ObjectConstructor<T>(this, handlerFor, type) { // from class: com.google.gason.internal.ConstructorConstructor.1
                final ConstructorConstructor this$0;
                final InstanceCreator val$creator;
                final Type val$type;

                AnonymousClass1(ConstructorConstructor this, InstanceCreator handlerFor2, Type type2) {
                    this.this$0 = this;
                    this.val$creator = handlerFor2;
                    this.val$type = type2;
                }

                @Override // com.google.gason.internal.ObjectConstructor
                public T construct() {
                    return (T) this.val$creator.createInstance(this.val$type);
                }
            };
        }
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(rawType);
        return newDefaultImplementationConstructor == null ? newUnsafeAllocator(type2, rawType) : newDefaultImplementationConstructor;
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
