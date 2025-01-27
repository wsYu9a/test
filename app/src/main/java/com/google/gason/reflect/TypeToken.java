package com.google.gason.reflect;

import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.C$Gson$Types;
import com.google.gason.internal.C0104;
import com.tencent.a.C0522;
import com.tencent.a.utils.C0520;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class TypeToken<T> {

    /* renamed from: short */
    private static final short[] f97short;
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4499441)}[0]).intValue() ^ 4499367];
        sArr[0] = 923;
        sArr[1] = 928;
        sArr[2] = 939;
        sArr[3] = 950;
        sArr[4] = 958;
        sArr[5] = 939;
        sArr[6] = 941;
        sArr[7] = 954;
        sArr[8] = 939;
        sArr[9] = 938;
        sArr[10] = 1006;
        sArr[11] = 954;
        sArr[12] = 951;
        sArr[13] = 958;
        sArr[14] = 939;
        sArr[15] = 992;
        sArr[16] = 1006;
        sArr[17] = 907;
        sArr[18] = 950;
        sArr[19] = 958;
        sArr[20] = 939;
        sArr[21] = 941;
        sArr[22] = 954;
        sArr[23] = 939;
        sArr[24] = 938;
        sArr[25] = 1006;
        sArr[26] = 929;
        sArr[27] = 928;
        sArr[28] = 939;
        sArr[29] = 1006;
        sArr[30] = 929;
        sArr[31] = 936;
        sArr[32] = 1012;
        sArr[33] = 1006;
        sArr[34] = 1022;
        sArr[35] = 1010;
        sArr[36] = 2237;
        sArr[37] = 2218;
        sArr[38] = 2219;
        sArr[39] = 2303;
        sArr[40] = 2232;
        sArr[41] = 2224;
        sArr[42] = 2219;
        sArr[43] = 2277;
        sArr[44] = 2303;
        sArr[45] = 560;
        sArr[46] = 572;
        sArr[47] = 634;
        sArr[48] = 627;
        sArr[49] = 622;
        sArr[50] = 572;
        sArr[51] = 616;
        sArr[52] = 613;
        sArr[53] = 620;
        sArr[54] = 633;
        sArr[55] = 572;
        sArr[56] = 616;
        sArr[57] = 627;
        sArr[58] = 631;
        sArr[59] = 633;
        sArr[60] = 626;
        sArr[61] = 550;
        sArr[62] = 572;
        sArr[63] = 2093;
        sArr[64] = 2057;
        sArr[65] = 2067;
        sArr[66] = 2067;
        sArr[67] = 2057;
        sArr[68] = 2062;
        sArr[69] = 2055;
        sArr[70] = 2112;
        sArr[71] = 2068;
        sArr[72] = 2073;
        sArr[73] = 2064;
        sArr[74] = 2053;
        sArr[75] = 2112;
        sArr[76] = 2064;
        sArr[77] = 2049;
        sArr[78] = 2066;
        sArr[79] = 2049;
        sArr[80] = 2061;
        sArr[81] = 2053;
        sArr[82] = 2068;
        sArr[83] = 2053;
        sArr[84] = 2066;
        sArr[85] = 2126;
        f97short = sArr;
    }

    protected TypeToken() {
        Type superclassTypeParameter = getSuperclassTypeParameter(getClass());
        this.type = superclassTypeParameter;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(superclassTypeParameter);
        this.hashCode = superclassTypeParameter.hashCode();
    }

    TypeToken(Type type) {
        Type canonicalize = C$Gson$Types.canonicalize((Type) C$Gson$Preconditions.checkNotNull(type));
        this.type = canonicalize;
        this.rawType = (Class<? super T>) C$Gson$Types.getRawType(canonicalize);
        this.hashCode = canonicalize.hashCode();
    }

    private static AssertionError buildUnexpectedTypeError(Type type, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder(C0104.m40(f97short, 1751530 ^ C0008.m27((Object) "ۤ۠ۦ"), 1748610 ^ C0008.m27((Object) "ۡ۠۟"), C0008.m27((Object) "ۥۤۧ") ^ 1752550));
        for (Class<?> cls : clsArr) {
            sb.append(cls.getName());
            sb.append(C0005.m17(f97short, 1746786 ^ C0008.m27((Object) "۟ۡۢ"), 1747651 ^ C0008.m27((Object) "۠۟۠"), C0008.m27((Object) "ۨۨ۠") ^ 1755698));
        }
        sb.append(C0104.m40(f97short, 56410 ^ C0008.m27((Object) "ۤۢ"), 1752655 ^ C0008.m27((Object) "ۥۥۦ"), C0008.m27((Object) "ۢۡۥ") ^ 1751641));
        sb.append(type.getClass().getName());
        sb.append(C0522.m72(f97short, 1755629 ^ C0008.m27((Object) "ۨۧ۟"), 1754579 ^ C0008.m27((Object) "ۧۥ۟"), C0008.m27((Object) "ۡۡۤ") ^ 1748184));
        sb.append(type.toString());
        sb.append('.');
        return new AssertionError(sb.toString());
    }

    public static <T> TypeToken<T> get(Class<T> cls) {
        return new TypeToken<>(cls);
    }

    public static TypeToken<?> get(Type type) {
        return new TypeToken<>(type);
    }

    static Type getSuperclassTypeParameter(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof Class)) {
            return C$Gson$Types.canonicalize(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
        }
        throw new RuntimeException(C0520.m66(f97short, 1755383 ^ C0008.m27((Object) "ۨ۟۟"), 1749630 ^ C0008.m27((Object) "ۢ۠ۧ"), C0008.m27((Object) "ۨۨ۠") ^ 1753472));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Class] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.reflect.Type] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        if (!(genericComponentType instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType) type).getGenericComponentType();
        } else if (type instanceof Class) {
            type = (Class) type;
            while (type.isArray()) {
                type = type.getComponentType();
            }
        }
        return isAssignableFrom(type, (ParameterizedType) genericComponentType, new HashMap());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
    
        if (typeEquals(r10, r11, r12) == false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isAssignableFrom(java.lang.reflect.Type r10, java.lang.reflect.ParameterizedType r11, java.util.Map<java.lang.String, java.lang.reflect.Type> r12) {
        /*
            r3 = 1
            r2 = 0
            r0 = 2
            java.lang.Object[] r4 = new java.lang.Object[r0]
            java.lang.Integer r0 = new java.lang.Integer
            r1 = 3566466(0x366b82, float:4.997683E-39)
            r0.<init>(r1)
            r4[r2] = r0
            java.lang.Integer r0 = new java.lang.Integer
            r1 = 8661867(0x842b6b, float:1.2137861E-38)
            r0.<init>(r1)
            r4[r3] = r0
            if (r10 != 0) goto L1c
        L1b:
            return r2
        L1c:
            boolean r0 = r11.equals(r10)
            if (r0 == 0) goto L24
        L22:
            r2 = r3
            goto L1b
        L24:
            java.lang.Class r5 = com.google.gason.internal.C$Gson$Types.getRawType(r10)
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L51
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
        L2e:
            if (r10 == 0) goto L6f
            java.lang.reflect.Type[] r6 = r10.getActualTypeArguments()
            java.lang.reflect.TypeVariable[] r7 = r5.getTypeParameters()
            r1 = r2
        L39:
            int r0 = r6.length
            if (r1 >= r0) goto L69
            r0 = r6[r1]
            r8 = r7[r1]
        L40:
            boolean r9 = r0 instanceof java.lang.reflect.TypeVariable
            if (r9 == 0) goto L53
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = r12.get(r0)
            java.lang.reflect.Type r0 = (java.lang.reflect.Type) r0
            goto L40
        L51:
            r10 = 0
            goto L2e
        L53:
            java.lang.String r8 = r8.getName()
            r12.put(r8, r0)
            r0 = r4[r2]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r8 = 3566467(0x366b83, float:4.997685E-39)
            r0 = r0 ^ r8
            int r0 = r0 + r1
            r1 = r0
            goto L39
        L69:
            boolean r0 = typeEquals(r10, r11, r12)
            if (r0 != 0) goto L22
        L6f:
            java.lang.reflect.Type[] r1 = r5.getGenericInterfaces()
            int r6 = r1.length
        L74:
            if (r2 >= r6) goto L91
            r0 = r1[r2]
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>(r12)
            boolean r0 = isAssignableFrom(r0, r11, r7)
            if (r0 != 0) goto L22
            r0 = r4[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r7 = 8661866(0x842b6a, float:1.213786E-38)
            r0 = r0 ^ r7
            int r2 = r2 + r0
            goto L74
        L91:
            java.lang.reflect.Type r0 = r5.getGenericSuperclass()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>(r12)
            boolean r2 = isAssignableFrom(r0, r11, r1)
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.reflect.TypeToken.isAssignableFrom(java.lang.reflect.Type, java.lang.reflect.ParameterizedType, java.util.Map):boolean");
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        return type2.equals(type) || ((type instanceof TypeVariable) && type2.equals(map.get(((TypeVariable) type).getName())));
    }

    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        Integer num = new Integer(2823227);
        if (!parameterizedType.getRawType().equals(parameterizedType2.getRawType())) {
            return false;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        for (int i2 = 0; i2 < actualTypeArguments.length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2823226) + i2) {
            if (!matches(actualTypeArguments[i2], actualTypeArguments2[i2], map)) {
                return false;
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof TypeToken) && C$Gson$Types.equals(this.type, ((TypeToken) obj).type);
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isAssignableFrom(typeToken.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> cls) {
        return isAssignableFrom((Type) cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        Object[] objArr = {new Integer(5459098), new Integer(1071082), new Integer(5481742)};
        boolean intValue = ((Integer) objArr[2]).intValue() ^ 5481743;
        if (type != null) {
            if (this.type.equals(type)) {
                return intValue;
            }
            Type type2 = this.type;
            if (type2 instanceof Class) {
                return this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type));
            }
            if (type2 instanceof ParameterizedType) {
                return isAssignableFrom(type, (ParameterizedType) type2, new HashMap());
            }
            if (!(type2 instanceof GenericArrayType)) {
                Class[] clsArr = new Class[((Integer) objArr[0]).intValue() ^ 5459097];
                clsArr[0] = Class.class;
                clsArr[intValue ? 1 : 0] = ParameterizedType.class;
                clsArr[((Integer) objArr[1]).intValue() ^ 1071080] = GenericArrayType.class;
                throw buildUnexpectedTypeError(type2, clsArr);
            }
            if (this.rawType.isAssignableFrom(C$Gson$Types.getRawType(type)) && isAssignableFrom(type, (GenericArrayType) this.type)) {
                return intValue;
            }
        }
        return false;
    }

    public final String toString() {
        return C$Gson$Types.typeToString(this.type);
    }
}
