package ba;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class j {

    @Target({ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        String name() default "";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String name() default "";
    }

    public static boolean a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(str);
    }

    public static boolean b(String str, Context context, String str2) {
        return context.getSharedPreferences(str, 0).contains(str2);
    }

    public static Map<String, ?> c(String str, Context context) {
        return context.getSharedPreferences(str, 0).getAll();
    }

    public static boolean d(Context context, String str, boolean z10) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return defaultSharedPreferences.getBoolean(str, z10);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(str).apply();
            return z10;
        }
    }

    public static boolean e(String str, Context context, String str2, boolean z10) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            return sharedPreferences.getBoolean(str2, z10);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(str2).apply();
            return z10;
        }
    }

    public static int f(Context context, String str, int i10) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return defaultSharedPreferences.getInt(str, i10);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(str).apply();
            return i10;
        }
    }

    public static int g(String str, Context context, String str2, int i10) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            return sharedPreferences.getInt(str2, i10);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(str2).apply();
            return i10;
        }
    }

    public static long h(Context context, String str, long j10) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return defaultSharedPreferences.getLong(str, j10);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(str).apply();
            return j10;
        }
    }

    public static long i(String str, Context context, String str2, long j10) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            return sharedPreferences.getLong(str2, j10);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(str2).apply();
            return j10;
        }
    }

    public static String j(Context context, String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            return defaultSharedPreferences.getString(str, null);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(str).apply();
            return null;
        }
    }

    public static String k(String str, Context context, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            return sharedPreferences.getString(str2, null);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(str2).apply();
            return null;
        }
    }

    public static boolean l(Context context, Object obj) {
        Class<?> cls = obj.getClass();
        Annotation annotation = cls.getAnnotation(b.class);
        String name = annotation instanceof b ? ((b) annotation).name() : null;
        if (TextUtils.isEmpty(name)) {
            name = cls.getName();
        }
        Map<String, ?> c10 = c(name, context);
        if (c10 == null || c10.size() == 0) {
            return false;
        }
        Iterator<Field> it = i.a(cls).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            a aVar = (a) next.getAnnotation(a.class);
            if (aVar != null) {
                String name2 = aVar.name();
                if (l.q(name2)) {
                    name2 = next.getName();
                }
                Object obj2 = c10.get(name2);
                if (obj2 == null) {
                    continue;
                } else {
                    next.setAccessible(true);
                    Class<?> type = next.getType();
                    if (obj2.getClass().equals(type) || type == Character.class || type == Character.TYPE) {
                        if (type == Integer.class) {
                            try {
                                next.set(obj, obj2);
                            } catch (IllegalAccessException e10) {
                                e10.printStackTrace();
                            }
                        } else if (type == Long.class) {
                            next.set(obj, obj2);
                        } else if (type == String.class) {
                            next.set(obj, obj2);
                        } else if (type == Date.class) {
                            next.set(obj, new Date(((Long) obj2).longValue()));
                        } else {
                            if (type != Character.class && type != Character.TYPE) {
                                if (type != Boolean.class) {
                                    throw new RuntimeException("Unprocessed field type: " + type.getName());
                                }
                                next.set(obj, obj2);
                            }
                            next.set(obj, Character.valueOf((char) ((Integer) obj2).intValue()));
                        }
                        e10.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    public static void m(Context context, String str, int i10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str, i10);
        edit.apply();
    }

    public static void n(Context context, String str, long j10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong(str, j10);
        edit.apply();
    }

    public static void o(Context context, String str, String str2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void p(Context context, String str, boolean z10) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean(str, z10);
        edit.apply();
    }

    public static void q(String str, Context context, String str2, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i10);
        edit.apply();
    }

    public static void r(String str, Context context, String str2, long j10) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putLong(str2, j10);
        edit.apply();
    }

    public static void s(String str, Context context, String str2, String str3) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void t(String str, Context context, String str2, boolean z10) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z10);
        edit.apply();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void u(android.content.Context r7, java.lang.Object r8) {
        /*
            java.lang.Class r0 = r8.getClass()
            java.lang.Class<ba.j$b> r1 = ba.j.b.class
            java.lang.annotation.Annotation r1 = r0.getAnnotation(r1)
            boolean r2 = r1 instanceof ba.j.b
            r3 = 0
            if (r2 == 0) goto L16
            ba.j$b r1 = (ba.j.b) r1
            java.lang.String r1 = r1.name()
            goto L17
        L16:
            r1 = r3
        L17:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L21
            java.lang.String r1 = r0.getName()
        L21:
            java.util.ArrayList r0 = ba.i.a(r0)
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Ld6
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            r4 = 1
            r2.setAccessible(r4)
            java.lang.Class<ba.j$a> r4 = ba.j.a.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            ba.j$a r4 = (ba.j.a) r4
            if (r4 != 0) goto L44
            goto L29
        L44:
            java.lang.String r4 = r4.name()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L52
            java.lang.String r4 = r2.getName()
        L52:
            java.lang.Object r5 = r2.get(r8)     // Catch: java.lang.IllegalAccessException -> L57 java.lang.IllegalArgumentException -> L5c
            goto L61
        L57:
            r5 = move-exception
            r5.printStackTrace()
            goto L60
        L5c:
            r5 = move-exception
            r5.printStackTrace()
        L60:
            r5 = r3
        L61:
            if (r5 != 0) goto L64
            goto L29
        L64:
            java.lang.Class r2 = r2.getType()
            java.lang.Class<java.lang.Integer> r6 = java.lang.Integer.class
            if (r2 == r6) goto Lcb
            java.lang.Class r6 = java.lang.Integer.TYPE
            if (r2 != r6) goto L71
            goto Lcb
        L71:
            java.lang.Class<java.lang.Long> r6 = java.lang.Long.class
            if (r2 == r6) goto Lc0
            java.lang.Class r6 = java.lang.Long.TYPE
            if (r2 != r6) goto L7a
            goto Lc0
        L7a:
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            if (r2 != r6) goto L84
            java.lang.String r5 = (java.lang.String) r5
            s(r1, r7, r4, r5)
            goto L29
        L84:
            java.lang.Class<java.util.Date> r6 = java.util.Date.class
            if (r2 != r6) goto L92
            java.util.Date r5 = (java.util.Date) r5
            long r5 = r5.getTime()
            r(r1, r7, r4, r5)
            goto L29
        L92:
            java.lang.Class<java.lang.Character> r6 = java.lang.Character.class
            if (r2 == r6) goto Lb5
            java.lang.Class r6 = java.lang.Character.TYPE
            if (r2 != r6) goto L9b
            goto Lb5
        L9b:
            java.lang.Class<java.lang.Boolean> r6 = java.lang.Boolean.class
            if (r2 == r6) goto Laa
            java.lang.Class r6 = java.lang.Boolean.TYPE
            if (r2 != r6) goto La4
            goto Laa
        La4:
            java.lang.UnknownError r7 = new java.lang.UnknownError
            r7.<init>()
            throw r7
        Laa:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r2 = r5.booleanValue()
            t(r1, r7, r4, r2)
            goto L29
        Lb5:
            java.lang.Character r5 = (java.lang.Character) r5
            char r2 = r5.charValue()
            q(r1, r7, r4, r2)
            goto L29
        Lc0:
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            r(r1, r7, r4, r5)
            goto L29
        Lcb:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r2 = r5.intValue()
            q(r1, r7, r4, r2)
            goto L29
        Ld6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ba.j.u(android.content.Context, java.lang.Object):void");
    }
}
