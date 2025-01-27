package com.google.gason.internal;

import android.support.v4.graphics.C0003;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import com.google.gason.reflect.C0105;
import com.tencent.a.utils.C0520;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public abstract class UnsafeAllocator {

    /* renamed from: short */
    private static final short[] f74short;

    /* renamed from: com.google.gason.internal.UnsafeAllocator$1 */
    static class AnonymousClass1 extends UnsafeAllocator {
        final Method val$allocateInstance;
        final Object val$unsafe;

        AnonymousClass1(Method method, Object obj) throws InvocationTargetException, IllegalAccessException {
            this.val$allocateInstance = method;
            this.val$unsafe = obj;
        }

        @Override // com.google.gason.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            Integer num = new Integer(8103810);
            Method method = this.val$allocateInstance;
            Object obj = this.val$unsafe;
            Object[] objArr = new Object[((Integer) new Object[]{num}[0]).intValue() ^ 8103811];
            objArr[0] = cls;
            return (T) method.invoke(obj, objArr);
        }
    }

    /* renamed from: com.google.gason.internal.UnsafeAllocator$2 */
    static class AnonymousClass2 extends UnsafeAllocator {
        final Method val$newInstance;

        AnonymousClass2(Method method) throws InvocationTargetException, IllegalAccessException {
            this.val$newInstance = method;
        }

        @Override // com.google.gason.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            Object[] objArr = {new Integer(5027354), new Integer(2072986)};
            Method method = this.val$newInstance;
            Object[] objArr2 = new Object[((Integer) objArr[1]).intValue() ^ 2072984];
            objArr2[0] = cls;
            objArr2[((Integer) objArr[0]).intValue() ^ 5027355] = Object.class;
            return (T) method.invoke(null, objArr2);
        }
    }

    /* renamed from: com.google.gason.internal.UnsafeAllocator$3 */
    static class AnonymousClass3 extends UnsafeAllocator {
        final int val$constructorId;
        final Method val$newInstance;

        AnonymousClass3(Method method, int i2) throws InvocationTargetException, IllegalAccessException {
            this.val$newInstance = method;
            this.val$constructorId = i2;
        }

        @Override // com.google.gason.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) throws Exception {
            Object[] objArr = {new Integer(8371327), new Integer(3957417)};
            Method method = this.val$newInstance;
            Object[] objArr2 = new Object[((Integer) objArr[0]).intValue() ^ 8371325];
            objArr2[0] = cls;
            objArr2[((Integer) objArr[1]).intValue() ^ 3957416] = Integer.valueOf(this.val$constructorId);
            return (T) method.invoke(null, objArr2);
        }
    }

    /* renamed from: com.google.gason.internal.UnsafeAllocator$4 */
    static class AnonymousClass4 extends UnsafeAllocator {

        /* renamed from: short */
        private static final short[] f75short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(1377947)}[0]).intValue() ^ 1377931];
            sArr[0] = 2675;
            sArr[1] = 2641;
            sArr[2] = 2654;
            sArr[3] = 2654;
            sArr[4] = 2655;
            sArr[5] = 2628;
            sArr[6] = 2576;
            sArr[7] = 2641;
            sArr[8] = 2652;
            sArr[9] = 2652;
            sArr[10] = 2655;
            sArr[11] = 2643;
            sArr[12] = 2641;
            sArr[13] = 2628;
            sArr[14] = 2645;
            sArr[15] = 2576;
            f75short = sArr;
        }

        AnonymousClass4() {
        }

        @Override // com.google.gason.internal.UnsafeAllocator
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException(C0520.m66(f75short, 1753574 ^ C0008.m27((Object) "ۦۤۤ"), 1754551 ^ C0008.m27((Object) "ۧۤۤ"), C0008.m27((Object) "ۣۣۢ") ^ 1752148) + cls);
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5636685)}[0]).intValue() ^ 5636622];
        sArr[0] = 1767;
        sArr[1] = 1772;
        sArr[2] = 1790;
        sArr[3] = 1728;
        sArr[4] = 1767;
        sArr[5] = 1786;
        sArr[6] = 1789;
        sArr[7] = 1768;
        sArr[8] = 1767;
        sArr[9] = 1770;
        sArr[10] = 1772;
        sArr[11] = 2126;
        sArr[12] = 2120;
        sArr[13] = 2131;
        sArr[14] = 2067;
        sArr[15] = 2128;
        sArr[16] = 2132;
        sArr[17] = 2126;
        sArr[18] = 2142;
        sArr[19] = 2067;
        sArr[20] = 2152;
        sArr[21] = 2131;
        sArr[22] = 2126;
        sArr[23] = 2140;
        sArr[24] = 2139;
        sArr[25] = 2136;
        sArr[26] = 3089;
        sArr[27] = 3085;
        sArr[28] = 3072;
        sArr[29] = 3120;
        sArr[30] = 3083;
        sArr[31] = 3094;
        sArr[32] = 3076;
        sArr[33] = 3075;
        sArr[34] = 3072;
        sArr[35] = 2462;
        sArr[36] = 2451;
        sArr[37] = 2451;
        sArr[38] = 2448;
        sArr[39] = 2460;
        sArr[40] = 2462;
        sArr[41] = 2443;
        sArr[42] = 2458;
        sArr[43] = 2486;
        sArr[44] = 2449;
        sArr[45] = 2444;
        sArr[46] = 2443;
        sArr[47] = 2462;
        sArr[48] = 2449;
        sArr[49] = 2460;
        sArr[50] = 2458;
        sArr[51] = 2269;
        sArr[52] = 2271;
        sArr[53] = 2254;
        sArr[54] = 2297;
        sArr[55] = 2261;
        sArr[56] = 2260;
        sArr[57] = 2249;
        sArr[58] = 2254;
        sArr[59] = 2248;
        sArr[60] = 2255;
        sArr[61] = 2265;
        sArr[62] = 2254;
        sArr[63] = 2261;
        sArr[64] = 2248;
        sArr[65] = 2291;
        sArr[66] = 2270;
        f74short = sArr;
    }

    public static UnsafeAllocator create() {
        Object[] objArr = {new Integer(3818691), new Integer(1157590)};
        String m24 = C0008.m24(f74short, 1750719 ^ C0008.m27((Object) "ۣۥۡ"), 1746792 ^ C0008.m27((Object) "۟ۢۦ"), C0008.m27((Object) "۟ۤۦ") ^ 1745192);
        int intValue = 1157591 ^ ((Integer) objArr[1]).intValue();
        try {
            Class<?> m28 = C0008.m28(C0105.m44(f74short, 1749580 ^ C0008.m27((Object) "ۢ۟ۤ"), 1753674 ^ C0008.m27((Object) "ۦۧۦ"), C0008.m27((Object) "ۢۦۡ") ^ 1751840));
            Field declaredField = m28.getDeclaredField(C0003.m11(f74short, 1746946 ^ C0008.m27((Object) "۟ۨۡ"), 1751617 ^ C0008.m27((Object) "ۣۤۧ"), C0008.m27((Object) "ۣۤۢ") ^ 1750592));
            declaredField.setAccessible(intValue);
            Object obj = declaredField.get(null);
            String m19 = C0006.m19(f74short, C0008.m27((Object) "ۥ") ^ 1734, 56464 ^ C0008.m27((Object) "ۤۤ"), C0008.m27((Object) "ۢ۠ۡ") ^ 1751964);
            Class<?>[] clsArr = new Class[intValue];
            clsArr[0] = Class.class;
            return new UnsafeAllocator(m28.getMethod(m19, clsArr), obj) { // from class: com.google.gason.internal.UnsafeAllocator.1
                final Method val$allocateInstance;
                final Object val$unsafe;

                AnonymousClass1(Method method, Object obj2) throws InvocationTargetException, IllegalAccessException {
                    this.val$allocateInstance = method;
                    this.val$unsafe = obj2;
                }

                @Override // com.google.gason.internal.UnsafeAllocator
                public <T> T newInstance(Class<T> cls) throws Exception {
                    Integer num = new Integer(8103810);
                    Method method = this.val$allocateInstance;
                    Object obj2 = this.val$unsafe;
                    Object[] objArr2 = new Object[((Integer) new Object[]{num}[0]).intValue() ^ 8103811];
                    objArr2[0] = cls;
                    return (T) method.invoke(obj2, objArr2);
                }
            };
        } catch (Exception e2) {
            int intValue2 = 3818689 ^ ((Integer) objArr[0]).intValue();
            try {
                Class[] clsArr2 = new Class[intValue2];
                clsArr2[0] = Class.class;
                clsArr2[intValue] = Class.class;
                Method declaredMethod = ObjectInputStream.class.getDeclaredMethod(m24, clsArr2);
                declaredMethod.setAccessible(intValue);
                return new UnsafeAllocator(declaredMethod) { // from class: com.google.gason.internal.UnsafeAllocator.2
                    final Method val$newInstance;

                    AnonymousClass2(Method declaredMethod2) throws InvocationTargetException, IllegalAccessException {
                        this.val$newInstance = declaredMethod2;
                    }

                    @Override // com.google.gason.internal.UnsafeAllocator
                    public <T> T newInstance(Class<T> cls) throws Exception {
                        Object[] objArr2 = {new Integer(5027354), new Integer(2072986)};
                        Method method = this.val$newInstance;
                        Object[] objArr22 = new Object[((Integer) objArr2[1]).intValue() ^ 2072984];
                        objArr22[0] = cls;
                        objArr22[((Integer) objArr2[0]).intValue() ^ 5027355] = Object.class;
                        return (T) method.invoke(null, objArr22);
                    }
                };
            } catch (Exception e3) {
                try {
                    String m17 = C0005.m17(f74short, 1754399 ^ C0008.m27((Object) "ۧ۠ۥ"), 1753501 ^ C0008.m27((Object) "ۦۡۨ"), C0008.m27((Object) "۠ۧۧ") ^ 1745786);
                    Class[] clsArr3 = new Class[intValue];
                    clsArr3[0] = Class.class;
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod(m17, clsArr3);
                    declaredMethod2.setAccessible(intValue);
                    Object[] objArr2 = new Object[intValue];
                    objArr2[0] = Object.class;
                    int intValue3 = ((Integer) declaredMethod2.invoke(null, objArr2)).intValue();
                    Class[] clsArr4 = new Class[intValue2];
                    clsArr4[0] = Class.class;
                    clsArr4[intValue] = Integer.TYPE;
                    Method declaredMethod3 = ObjectStreamClass.class.getDeclaredMethod(m24, clsArr4);
                    declaredMethod3.setAccessible(intValue);
                    return new UnsafeAllocator(declaredMethod3, intValue3) { // from class: com.google.gason.internal.UnsafeAllocator.3
                        final int val$constructorId;
                        final Method val$newInstance;

                        AnonymousClass3(Method declaredMethod32, int intValue32) throws InvocationTargetException, IllegalAccessException {
                            this.val$newInstance = declaredMethod32;
                            this.val$constructorId = intValue32;
                        }

                        @Override // com.google.gason.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls) throws Exception {
                            Object[] objArr3 = {new Integer(8371327), new Integer(3957417)};
                            Method method = this.val$newInstance;
                            Object[] objArr22 = new Object[((Integer) objArr3[0]).intValue() ^ 8371325];
                            objArr22[0] = cls;
                            objArr22[((Integer) objArr3[1]).intValue() ^ 3957416] = Integer.valueOf(this.val$constructorId);
                            return (T) method.invoke(null, objArr22);
                        }
                    };
                } catch (Exception e4) {
                    return new UnsafeAllocator() { // from class: com.google.gason.internal.UnsafeAllocator.4

                        /* renamed from: short */
                        private static final short[] f75short;

                        static {
                            short[] sArr = new short[((Integer) new Object[]{new Integer(1377947)}[0]).intValue() ^ 1377931];
                            sArr[0] = 2675;
                            sArr[1] = 2641;
                            sArr[2] = 2654;
                            sArr[3] = 2654;
                            sArr[4] = 2655;
                            sArr[5] = 2628;
                            sArr[6] = 2576;
                            sArr[7] = 2641;
                            sArr[8] = 2652;
                            sArr[9] = 2652;
                            sArr[10] = 2655;
                            sArr[11] = 2643;
                            sArr[12] = 2641;
                            sArr[13] = 2628;
                            sArr[14] = 2645;
                            sArr[15] = 2576;
                            f75short = sArr;
                        }

                        AnonymousClass4() {
                        }

                        @Override // com.google.gason.internal.UnsafeAllocator
                        public <T> T newInstance(Class<T> cls) {
                            throw new UnsupportedOperationException(C0520.m66(f75short, 1753574 ^ C0008.m27((Object) "ۦۤۤ"), 1754551 ^ C0008.m27((Object) "ۧۤۤ"), C0008.m27((Object) "ۣۣۢ") ^ 1752148) + cls);
                        }
                    };
                }
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
