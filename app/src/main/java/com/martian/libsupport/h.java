package com.martian.libsupport;

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

/* loaded from: classes.dex */
public class h {

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

    public static boolean a(Context ctx, String name) {
        return PreferenceManager.getDefaultSharedPreferences(ctx).contains(name);
    }

    public static boolean b(String prefName, Context ctx, String name) {
        return ctx.getSharedPreferences(prefName, 0).contains(name);
    }

    public static Map<String, ?> c(String prefName, Context ctx) {
        return ctx.getSharedPreferences(prefName, 0).getAll();
    }

    public static boolean d(Context ctx, String name, boolean def) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        try {
            return defaultSharedPreferences.getBoolean(name, def);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static boolean e(String prefName, Context ctx, String name, boolean def) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(prefName, 0);
        try {
            return sharedPreferences.getBoolean(name, def);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static int f(Context ctx, String name, int def) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        try {
            return defaultSharedPreferences.getInt(name, def);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static int g(String prefName, Context ctx, String name, int def) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(prefName, 0);
        try {
            return sharedPreferences.getInt(name, def);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static long h(Context ctx, String name, long def) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        try {
            return defaultSharedPreferences.getLong(name, def);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static long i(String prefName, Context ctx, String name, long def) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(prefName, 0);
        try {
            return sharedPreferences.getLong(name, def);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(name).apply();
            return def;
        }
    }

    public static String j(Context ctx, String name) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        try {
            return defaultSharedPreferences.getString(name, null);
        } catch (Exception unused) {
            defaultSharedPreferences.edit().remove(name).apply();
            return null;
        }
    }

    public static String k(String prefName, Context ctx, String name) {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(prefName, 0);
        try {
            return sharedPreferences.getString(name, null);
        } catch (Exception unused) {
            sharedPreferences.edit().remove(name).apply();
            return null;
        }
    }

    public static boolean l(Context context, Object data) {
        Class<?> cls = data.getClass();
        Annotation annotation = cls.getAnnotation(b.class);
        String name = annotation instanceof b ? ((b) annotation).name() : null;
        if (TextUtils.isEmpty(name)) {
            name = cls.getName();
        }
        Map<String, ?> c2 = c(name, context);
        if (c2 == null || c2.size() == 0) {
            return false;
        }
        Iterator<Field> it = g.a(cls).iterator();
        while (it.hasNext()) {
            Field next = it.next();
            a aVar = (a) next.getAnnotation(a.class);
            if (aVar != null) {
                String name2 = aVar.name();
                if (k.p(name2)) {
                    name2 = next.getName();
                }
                Object obj = c2.get(name2);
                if (obj == null) {
                    continue;
                } else {
                    next.setAccessible(true);
                    Class<?> type = next.getType();
                    if (obj.getClass().equals(type) || type == Character.class || type == Character.TYPE) {
                        if (type == Integer.class) {
                            try {
                                next.set(data, obj);
                            } catch (IllegalAccessException e2) {
                                e2.printStackTrace();
                            }
                        } else if (type == Long.class) {
                            next.set(data, obj);
                        } else if (type == String.class) {
                            next.set(data, obj);
                        } else if (type == Date.class) {
                            next.set(data, new Date(((Long) obj).longValue()));
                        } else {
                            if (type != Character.class && type != Character.TYPE) {
                                if (type != Boolean.class) {
                                    throw new RuntimeException("Unprocessed field type: " + type.getName());
                                }
                                next.set(data, obj);
                            }
                            next.set(data, Character.valueOf((char) ((Integer) obj).intValue()));
                        }
                        e2.printStackTrace();
                    }
                }
            }
        }
        return true;
    }

    public static void m(Context ctx, String name, int i2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putInt(name, i2);
        edit.apply();
    }

    public static void n(Context ctx, String name, long i2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putLong(name, i2);
        edit.apply();
    }

    public static void o(Context ctx, String name, String str) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putString(name, str);
        edit.apply();
    }

    public static void p(Context ctx, String name, boolean b2) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(ctx).edit();
        edit.putBoolean(name, b2);
        edit.apply();
    }

    public static void q(String prefName, Context ctx, String name, int i2) {
        SharedPreferences.Editor edit = ctx.getSharedPreferences(prefName, 0).edit();
        edit.putInt(name, i2);
        edit.apply();
    }

    public static void r(String prefName, Context ctx, String name, long i2) {
        SharedPreferences.Editor edit = ctx.getSharedPreferences(prefName, 0).edit();
        edit.putLong(name, i2);
        edit.apply();
    }

    public static void s(String prefName, Context ctx, String name, String str) {
        SharedPreferences.Editor edit = ctx.getSharedPreferences(prefName, 0).edit();
        edit.putString(name, str);
        edit.apply();
    }

    public static void t(String prefName, Context ctx, String name, boolean b2) {
        SharedPreferences.Editor edit = ctx.getSharedPreferences(prefName, 0).edit();
        edit.putBoolean(name, b2);
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
            java.lang.Class<com.martian.libsupport.h$b> r1 = com.martian.libsupport.h.b.class
            java.lang.annotation.Annotation r1 = r0.getAnnotation(r1)
            boolean r2 = r1 instanceof com.martian.libsupport.h.b
            r3 = 0
            if (r2 == 0) goto L16
            com.martian.libsupport.h$b r1 = (com.martian.libsupport.h.b) r1
            java.lang.String r1 = r1.name()
            goto L17
        L16:
            r1 = r3
        L17:
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L21
            java.lang.String r1 = r0.getName()
        L21:
            java.util.ArrayList r0 = com.martian.libsupport.g.a(r0)
            java.util.Iterator r0 = r0.iterator()
        L29:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Ld6
            java.lang.Object r2 = r0.next()
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            r4 = 1
            r2.setAccessible(r4)
            java.lang.Class<com.martian.libsupport.h$a> r4 = com.martian.libsupport.h.a.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            com.martian.libsupport.h$a r4 = (com.martian.libsupport.h.a) r4
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
        throw new UnsupportedOperationException("Method not decompiled: com.martian.libsupport.h.u(android.content.Context, java.lang.Object):void");
    }
}
