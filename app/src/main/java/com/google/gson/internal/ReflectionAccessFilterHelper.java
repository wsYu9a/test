package com.google.gson.internal;

import com.google.gson.ReflectionAccessFilter;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ReflectionAccessFilterHelper {

    public static abstract class AccessChecker {
        public static final AccessChecker INSTANCE;

        /* renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1 */
        public class AnonymousClass1 extends AccessChecker {
            final /* synthetic */ Method val$canAccessMethod;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Method method) {
                super();
                r1 = method;
            }

            @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) r1.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e10) {
                    throw new RuntimeException("Failed invoking canAccess", e10);
                }
            }
        }

        /* renamed from: com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2 */
        public class AnonymousClass2 extends AccessChecker {
            @Override // com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker
            public boolean canAccess(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.internal.JavaVersion.isJava9OrLater()
                if (r0 == 0) goto L1c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L1c
                java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
                r4 = 0
                r2[r4] = r3     // Catch: java.lang.NoSuchMethodException -> L1c
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L1c
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$1     // Catch: java.lang.NoSuchMethodException -> L1c
                r1.<init>()     // Catch: java.lang.NoSuchMethodException -> L1c
                goto L1d
            L1c:
                r1 = 0
            L1d:
                if (r1 != 0) goto L24
                com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2 r1 = new com.google.gson.internal.ReflectionAccessFilterHelper$AccessChecker$2
                r1.<init>()
            L24:
                com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.INSTANCE = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.ReflectionAccessFilterHelper.AccessChecker.<clinit>():void");
        }

        private AccessChecker() {
        }

        public abstract boolean canAccess(AccessibleObject accessibleObject, Object obj);

        public /* synthetic */ AccessChecker(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private ReflectionAccessFilterHelper() {
    }

    public static boolean canAccess(AccessibleObject accessibleObject, Object obj) {
        return AccessChecker.INSTANCE.canAccess(accessibleObject, obj);
    }

    public static ReflectionAccessFilter.FilterResult getFilterResult(List<ReflectionAccessFilter> list, Class<?> cls) {
        Iterator<ReflectionAccessFilter> it = list.iterator();
        while (it.hasNext()) {
            ReflectionAccessFilter.FilterResult check = it.next().check(cls);
            if (check != ReflectionAccessFilter.FilterResult.INDECISIVE) {
                return check;
            }
        }
        return ReflectionAccessFilter.FilterResult.ALLOW;
    }

    public static boolean isAndroidType(Class<?> cls) {
        return isAndroidType(cls.getName());
    }

    public static boolean isAnyPlatformType(Class<?> cls) {
        String name = cls.getName();
        return isAndroidType(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static boolean isJavaType(Class<?> cls) {
        return isJavaType(cls.getName());
    }

    private static boolean isAndroidType(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || isJavaType(str);
    }

    private static boolean isJavaType(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }
}
