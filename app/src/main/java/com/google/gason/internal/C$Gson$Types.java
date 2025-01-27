package com.google.gason.internal;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import com.google.gason.C0107;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0521;
import com.tencent.a.model.C0519;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* renamed from: com.google.gason.internal.$Gson$Types */
/* loaded from: classes7.dex */
public final class C$Gson$Types {
    static final Type[] EMPTY_TYPE_ARRAY;

    /* renamed from: short */
    private static final short[] f66short;

    /* renamed from: com.google.gason.internal.$Gson$Types$GenericArrayTypeImpl */
    private static final class GenericArrayTypeImpl implements GenericArrayType, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: short */
        private static final short[] f67short;
        private final Type componentType;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(3926247)}[0]).intValue() ^ 3926245];
            sArr[0] = 3020;
            sArr[1] = 3018;
            f67short = sArr;
        }

        public GenericArrayTypeImpl(Type type) {
            this.componentType = C$Gson$Types.canonicalize(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && C$Gson$Types.equals(this, (GenericArrayType) obj);
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return C$Gson$Types.typeToString(this.componentType) + C0004.m13(f67short, 1747655 ^ C0008.m27((Object) "۠۟ۦ"), 56572 ^ C0008.m27((Object) "ۨۦ"), C0008.m27((Object) "ۡۥۢ") ^ 1746089);
        }
    }

    /* renamed from: com.google.gason.internal.$Gson$Types$ParameterizedTypeImpl */
    private static final class ParameterizedTypeImpl implements ParameterizedType, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: short */
        private static final short[] f68short;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5994971)}[0]).intValue() ^ 5994975];
            sArr[0] = 2361;
            sArr[1] = 1206;
            sArr[2] = 1210;
            sArr[3] = 3120;
            f68short = sArr;
        }

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Integer num = new Integer(3632589);
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                C$Gson$Preconditions.checkArgument(type != null || cls.getEnclosingClass() == null);
                C$Gson$Preconditions.checkArgument(type != null ? cls.getEnclosingClass() != null : true);
            }
            this.ownerType = type == null ? null : C$Gson$Types.canonicalize(type);
            this.rawType = C$Gson$Types.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i2 = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i2 >= typeArr2.length) {
                    return;
                }
                C$Gson$Preconditions.checkNotNull(typeArr2[i2]);
                C$Gson$Types.checkNotPrimitive(this.typeArguments[i2]);
                Type[] typeArr3 = this.typeArguments;
                typeArr3[i2] = C$Gson$Types.canonicalize(typeArr3[i2]);
                i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 3632588) + i2;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && C$Gson$Types.equals(this, (ParameterizedType) obj);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ C$Gson$Types.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            Object[] objArr = {new Integer(76477), new Integer(5214609)};
            int length = this.typeArguments.length;
            int intValue = 5214608 ^ ((Integer) objArr[1]).intValue();
            StringBuilder sb = new StringBuilder((((Integer) objArr[0]).intValue() ^ 76451) * (length + intValue));
            sb.append(C$Gson$Types.typeToString(this.rawType));
            if (this.typeArguments.length != 0) {
                sb.append(C0519.m65(f68short, 1753479 ^ C0008.m27((Object) "ۦۡۢ"), 1753574 ^ C0008.m27((Object) "ۦۤۥ"), C0008.m27((Object) "ۣۣ") ^ 54629));
                sb.append(C$Gson$Types.typeToString(this.typeArguments[0]));
                for (int i2 = intValue; i2 < this.typeArguments.length; i2++) {
                    sb.append(C0521.m71(f68short, 1752670 ^ C0008.m27((Object) "ۥۦ۠"), 1747836 ^ C0008.m27((Object) "۠ۥۣ"), C0008.m27((Object) "ۤۦۢ") ^ 1752634));
                    sb.append(C$Gson$Types.typeToString(this.typeArguments[i2]));
                }
                sb.append(C0001.m3(f68short, 1749600 ^ C0008.m27((Object) "ۢ۠ۡ"), 1754506 ^ C0008.m27((Object) "ۣۧۧ"), C0008.m27((Object) "ۢ۠۟") ^ 1752687));
            }
            return sb.toString();
        }
    }

    /* renamed from: com.google.gason.internal.$Gson$Types$WildcardTypeImpl */
    private static final class WildcardTypeImpl implements WildcardType, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: short */
        private static final short[] f69short;
        private final Type lowerBound;
        private final Type upperBound;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(2839709)}[0]).intValue() ^ 2839694];
            sArr[0] = 3323;
            sArr[1] = 3300;
            sArr[2] = 3255;
            sArr[3] = 3249;
            sArr[4] = 3252;
            sArr[5] = 3233;
            sArr[6] = 3254;
            sArr[7] = 3300;
            sArr[8] = 2402;
            sArr[9] = 2359;
            sArr[10] = 2344;
            sArr[11] = 2413;
            sArr[12] = 2416;
            sArr[13] = 2428;
            sArr[14] = 2413;
            sArr[15] = 2406;
            sArr[16] = 2412;
            sArr[17] = 2427;
            sArr[18] = 2344;
            f69short = sArr;
        }

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Type canonicalize;
            C$Gson$Preconditions.checkArgument(typeArr2.length <= 1);
            C$Gson$Preconditions.checkArgument(typeArr.length == 1);
            if (typeArr2.length == 1) {
                C$Gson$Preconditions.checkNotNull(typeArr2[0]);
                C$Gson$Types.checkNotPrimitive(typeArr2[0]);
                C$Gson$Preconditions.checkArgument(typeArr[0] == Object.class);
                this.lowerBound = C$Gson$Types.canonicalize(typeArr2[0]);
                canonicalize = Object.class;
            } else {
                C$Gson$Preconditions.checkNotNull(typeArr[0]);
                C$Gson$Types.checkNotPrimitive(typeArr[0]);
                this.lowerBound = null;
                canonicalize = C$Gson$Types.canonicalize(typeArr[0]);
            }
            this.upperBound = canonicalize;
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && C$Gson$Types.equals(this, (WildcardType) obj);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            Integer num = new Integer(4868918);
            Type type = this.lowerBound;
            if (type == null) {
                return C$Gson$Types.EMPTY_TYPE_ARRAY;
            }
            Type[] typeArr = new Type[((Integer) new Object[]{num}[0]).intValue() ^ 4868919];
            typeArr[0] = type;
            return typeArr;
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            Type[] typeArr = new Type[((Integer) new Object[]{new Integer(146802)}[0]).intValue() ^ 146803];
            typeArr[0] = this.upperBound;
            return typeArr;
        }

        public int hashCode() {
            Object[] objArr = {new Integer(441704), new Integer(454638)};
            Type type = this.lowerBound;
            return ((((Integer) objArr[0]).intValue() ^ 441719) + this.upperBound.hashCode()) ^ (type != null ? (((Integer) objArr[1]).intValue() ^ 454641) + type.hashCode() : 1);
        }

        public String toString() {
            StringBuilder sb;
            Type type;
            if (this.lowerBound != null) {
                sb = new StringBuilder();
                sb.append(C0008.m24(f69short, C0008.m27((Object) "ۢ۠۠") ^ 1749602, 1755499 ^ C0008.m27((Object) "ۨۤ۟"), C0008.m27((Object) "۟ۦۤ") ^ 1747737));
                type = this.lowerBound;
            } else {
                if (this.upperBound == Object.class) {
                    return C0008.m24(f69short, C0008.m27((Object) "ۢ۠ۨ") ^ 1749602, 1752484 ^ C0008.m27((Object) "ۥ۠۠"), C0008.m27((Object) "ۦۦ۠") ^ 1756029);
                }
                sb = new StringBuilder();
                sb.append(C0107.m50(f69short, 1755520 ^ C0008.m27((Object) "ۨۥۦ"), 56302 ^ C0008.m27((Object) "ۣ۟"), C0008.m27((Object) "ۣ۠ۨ") ^ 1745619));
                type = this.upperBound;
            }
            sb.append(C$Gson$Types.typeToString(type));
            return sb.toString();
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(7788882)}[0]).intValue() ^ 7788802];
        sArr[0] = 1264;
        sArr[1] = 1259;
        sArr[2] = 1266;
        sArr[3] = 1266;
        sArr[4] = 1188;
        sArr[5] = 1177;
        sArr[6] = 1169;
        sArr[7] = 1156;
        sArr[8] = 1154;
        sArr[9] = 1173;
        sArr[10] = 1156;
        sArr[11] = 1157;
        sArr[12] = 1217;
        sArr[13] = 1152;
        sArr[14] = 1217;
        sArr[15] = 1186;
        sArr[16] = 1165;
        sArr[17] = 1152;
        sArr[18] = 1170;
        sArr[19] = 1170;
        sArr[20] = 1229;
        sArr[21] = 1217;
        sArr[22] = 1201;
        sArr[23] = 1152;
        sArr[24] = 1171;
        sArr[25] = 1152;
        sArr[26] = 1164;
        sArr[27] = 1156;
        sArr[28] = 1173;
        sArr[29] = 1156;
        sArr[30] = 1171;
        sArr[31] = 1160;
        sArr[32] = 1179;
        sArr[33] = 1156;
        sArr[34] = 1157;
        sArr[35] = 1205;
        sArr[36] = 1176;
        sArr[37] = 1169;
        sArr[38] = 1156;
        sArr[39] = 1229;
        sArr[40] = 1217;
        sArr[41] = 1166;
        sArr[42] = 1171;
        sArr[43] = 1217;
        sArr[44] = 1190;
        sArr[45] = 1156;
        sArr[46] = 1167;
        sArr[47] = 1156;
        sArr[48] = 1171;
        sArr[49] = 1160;
        sArr[50] = 1154;
        sArr[51] = 1184;
        sArr[52] = 1171;
        sArr[53] = 1171;
        sArr[54] = 1152;
        sArr[55] = 1176;
        sArr[56] = 1205;
        sArr[57] = 1176;
        sArr[58] = 1169;
        sArr[59] = 1156;
        sArr[60] = 1229;
        sArr[61] = 1217;
        sArr[62] = 1155;
        sArr[63] = 1172;
        sArr[64] = 1173;
        sArr[65] = 1217;
        sArr[66] = 1245;
        sArr[67] = 1300;
        sArr[68] = 1290;
        sArr[69] = 1347;
        sArr[70] = 1369;
        sArr[71] = 1290;
        sArr[72] = 1349;
        sArr[73] = 1356;
        sArr[74] = 1290;
        sArr[75] = 1374;
        sArr[76] = 1363;
        sArr[77] = 1370;
        sArr[78] = 1359;
        sArr[79] = 1290;
        f66short = sArr;
        EMPTY_TYPE_ARRAY = new Type[0];
    }

    private C$Gson$Types() {
    }

    public static GenericArrayType arrayOf(Type type) {
        return new GenericArrayTypeImpl(type);
    }

    public static Type canonicalize(Type type) {
        Type wildcardTypeImpl;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (!cls.isArray()) {
                return cls;
            }
            wildcardTypeImpl = new GenericArrayTypeImpl(canonicalize(cls.getComponentType()));
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            wildcardTypeImpl = new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            wildcardTypeImpl = new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return type;
            }
            WildcardType wildcardType = (WildcardType) type;
            wildcardTypeImpl = new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return wildcardTypeImpl;
    }

    public static void checkNotPrimitive(Type type) {
        C$Gson$Preconditions.checkArgument(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }

    private static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean equals(Type type, Type type2) {
        if (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                if (!equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                    return false;
                }
            } else {
                if (type instanceof GenericArrayType) {
                    if (type2 instanceof GenericArrayType) {
                        return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
                    }
                    return false;
                }
                if (type instanceof WildcardType) {
                    if (!(type2 instanceof WildcardType)) {
                        return false;
                    }
                    WildcardType wildcardType = (WildcardType) type;
                    WildcardType wildcardType2 = (WildcardType) type2;
                    if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                        return false;
                    }
                } else {
                    if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                        return false;
                    }
                    TypeVariable typeVariable = (TypeVariable) type;
                    TypeVariable typeVariable2 = (TypeVariable) type2;
                    if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static Type getArrayComponentType(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    public static Type getCollectionElementType(Type type, Class<?> cls) {
        Type supertype = getSupertype(type, cls, Collection.class);
        if (supertype instanceof WildcardType) {
            supertype = ((WildcardType) supertype).getUpperBounds()[0];
        }
        return supertype instanceof ParameterizedType ? ((ParameterizedType) supertype).getActualTypeArguments()[0] : Object.class;
    }

    static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        Class<?> cls3;
        Type genericSuperclass;
        Integer num = new Integer(8705298);
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 8705299) + i2) {
                Class<?> cls4 = interfaces[i2];
                if (cls4 == cls2) {
                    return cls.getGenericInterfaces()[i2];
                }
                if (cls2.isAssignableFrom(cls4)) {
                    genericSuperclass = cls.getGenericInterfaces()[i2];
                    cls3 = interfaces[i2];
                    break;
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    cls3 = superclass;
                    genericSuperclass = cls.getGenericSuperclass();
                    return getGenericSupertype(genericSuperclass, cls3, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type[] getMapKeyAndValueTypes(Type type, Class<?> cls) {
        Object[] objArr = {new Integer(5279035), new Integer(6832659)};
        int intValue = 5279034 ^ ((Integer) objArr[0]).intValue();
        int intValue2 = 6832657 ^ ((Integer) objArr[1]).intValue();
        if (type == Properties.class) {
            Type[] typeArr = new Type[intValue2];
            typeArr[0] = String.class;
            typeArr[intValue] = String.class;
            return typeArr;
        }
        Type supertype = getSupertype(type, cls, Map.class);
        if (supertype instanceof ParameterizedType) {
            return ((ParameterizedType) supertype).getActualTypeArguments();
        }
        Type[] typeArr2 = new Type[intValue2];
        typeArr2[0] = Object.class;
        typeArr2[intValue] = Object.class;
        return typeArr2;
    }

    public static Class<?> getRawType(Type type) {
        String name;
        Type rawType;
        if (type instanceof Class) {
            rawType = type;
        } else {
            if (!(type instanceof ParameterizedType)) {
                if (type instanceof GenericArrayType) {
                    return Array.newInstance(getRawType(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
                }
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    return getRawType(((WildcardType) type).getUpperBounds()[0]);
                }
                if (type == null) {
                    name = C0001.m3(f66short, 1754508 ^ C0008.m27((Object) "ۣۧۨ"), 1753416 ^ C0008.m27((Object) "ۦ۟ۥ"), C0008.m27((Object) "ۣ۟ۢ") ^ 1745888);
                } else {
                    name = type.getClass().getName();
                }
                throw new IllegalArgumentException(C0105.m44(f66short, 1751567 ^ C0008.m27((Object) "ۤۡۨ"), 1754554 ^ C0008.m27((Object) "ۣۧۡ"), C0008.m27((Object) "ۢۧۦ") ^ 1750944) + type + C0008.m24(f66short, 1750720 ^ C0008.m27((Object) "ۣۣۣ"), 1751493 ^ C0008.m27((Object) "ۣۤ۟"), C0008.m27((Object) "ۤۧ۟") ^ 1752982) + name);
            }
            rawType = ((ParameterizedType) type).getRawType();
            C$Gson$Preconditions.checkArgument(rawType instanceof Class);
        }
        return (Class) rawType;
    }

    static Type getSupertype(Type type, Class<?> cls, Class<?> cls2) {
        C$Gson$Preconditions.checkArgument(cls2.isAssignableFrom(cls));
        return resolve(type, cls, getGenericSupertype(type, cls, cls2));
    }

    public static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    private static int indexOf(Object[] objArr, Object obj) {
        Integer num = new Integer(5623379);
        for (int i2 = 0; i2 < objArr.length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5623378) + i2) {
            if (obj.equals(objArr[i2])) {
                return i2;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean isArray(Type type) {
        return (type instanceof GenericArrayType) || ((type instanceof Class) && ((Class) type).isArray());
    }

    public static ParameterizedType newParameterizedTypeWithOwner(Type type, Type type2, Type... typeArr) {
        return new ParameterizedTypeImpl(type, type2, typeArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        return r13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.reflect.Type resolve(java.lang.reflect.Type r11, java.lang.Class<?> r12, java.lang.reflect.Type r13) {
        /*
            r2 = 1
            r3 = 0
            java.lang.Integer r7 = new java.lang.Integer
            r0 = 8639588(0x83d464, float:1.2106641E-38)
            r7.<init>(r0)
            r0 = r13
        Lb:
            boolean r1 = r0 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L1b
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            java.lang.reflect.Type r13 = resolveTypeVariable(r11, r12, r0)
            if (r13 != r0) goto L19
        L17:
            r0 = r13
        L18:
            return r0
        L19:
            r0 = r13
            goto Lb
        L1b:
            boolean r1 = r0 instanceof java.lang.Class
            if (r1 == 0) goto L37
            r1 = r0
            java.lang.Class r1 = (java.lang.Class) r1
            boolean r4 = r1.isArray()
            if (r4 == 0) goto L37
            java.lang.Class r2 = r1.getComponentType()
            java.lang.reflect.Type r0 = resolve(r11, r12, r2)
            if (r2 == r0) goto Ld1
        L32:
            java.lang.reflect.GenericArrayType r0 = arrayOf(r0)
            goto L18
        L37:
            boolean r1 = r0 instanceof java.lang.reflect.GenericArrayType
            if (r1 == 0) goto L49
            java.lang.reflect.GenericArrayType r0 = (java.lang.reflect.GenericArrayType) r0
            java.lang.reflect.Type r2 = r0.getGenericComponentType()
            java.lang.reflect.Type r1 = resolve(r11, r12, r2)
            if (r2 == r1) goto L18
            r0 = r1
            goto L32
        L49:
            boolean r1 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r1 == 0) goto L9d
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type r1 = r0.getOwnerType()
            java.lang.reflect.Type r8 = resolve(r11, r12, r1)
            if (r8 == r1) goto L8f
            r1 = r2
        L5a:
            java.lang.reflect.Type[] r4 = r0.getActualTypeArguments()
            int r9 = r4.length
            r6 = r3
        L60:
            if (r6 >= r9) goto L91
            r5 = r4[r6]
            java.lang.reflect.Type r5 = resolve(r11, r12, r5)
            r10 = r4[r6]
            if (r5 == r10) goto L78
            if (r1 != 0) goto L76
            java.lang.Object r1 = r4.clone()
            java.lang.reflect.Type[] r1 = (java.lang.reflect.Type[]) r1
            r4 = r1
            r1 = r2
        L76:
            r4[r6] = r5
        L78:
            r5 = r4
            r4 = r1
            java.lang.Object[] r1 = new java.lang.Object[r2]
            r1[r3] = r7
            r1 = r1[r3]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            r10 = 8639589(0x83d465, float:1.2106643E-38)
            r1 = r1 ^ r10
            int r1 = r1 + r6
            r6 = r1
            r1 = r4
            r4 = r5
            goto L60
        L8f:
            r1 = r3
            goto L5a
        L91:
            if (r1 == 0) goto L18
            java.lang.reflect.Type r0 = r0.getRawType()
            java.lang.reflect.ParameterizedType r0 = newParameterizedTypeWithOwner(r8, r0, r4)
            goto L18
        L9d:
            boolean r1 = r0 instanceof java.lang.reflect.WildcardType
            if (r1 == 0) goto L18
            java.lang.reflect.WildcardType r0 = (java.lang.reflect.WildcardType) r0
            java.lang.reflect.Type[] r1 = r0.getLowerBounds()
            java.lang.reflect.Type[] r4 = r0.getUpperBounds()
            int r5 = r1.length
            if (r5 != r2) goto Lbe
            r2 = r1[r3]
            java.lang.reflect.Type r2 = resolve(r11, r12, r2)
            r1 = r1[r3]
            if (r2 == r1) goto L18
            java.lang.reflect.WildcardType r0 = supertypeOf(r2)
            goto L18
        Lbe:
            int r1 = r4.length
            if (r1 != r2) goto L18
            r1 = r4[r3]
            java.lang.reflect.Type r1 = resolve(r11, r12, r1)
            r2 = r4[r3]
            if (r1 == r2) goto L18
            java.lang.reflect.WildcardType r0 = subtypeOf(r1)
            goto L18
        Ld1:
            r13 = r1
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.internal.C$Gson$Types.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type):java.lang.reflect.Type");
    }

    static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    public static WildcardType subtypeOf(Type type) {
        Integer num = new Integer(1452179);
        Type[] typeArr = EMPTY_TYPE_ARRAY;
        Type[] typeArr2 = new Type[((Integer) new Object[]{num}[0]).intValue() ^ 1452178];
        typeArr2[0] = type;
        return new WildcardTypeImpl(typeArr2, typeArr);
    }

    public static WildcardType supertypeOf(Type type) {
        int intValue = ((Integer) new Object[]{new Integer(6321466)}[0]).intValue() ^ 6321467;
        Type[] typeArr = new Type[intValue];
        typeArr[0] = Object.class;
        Type[] typeArr2 = new Type[intValue];
        typeArr2[0] = type;
        return new WildcardTypeImpl(typeArr, typeArr2);
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }
}
