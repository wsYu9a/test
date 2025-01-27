package com.wbl.ad.yzz.gson.t.l;

import com.wbl.ad.yzz.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public final class c extends b {

    /* renamed from: d */
    public static Class f32379d;

    /* renamed from: b */
    public final Object f32380b = c();

    /* renamed from: c */
    public final Field f32381c = b();

    public static Object c() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            f32379d = cls;
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return declaredField.get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.wbl.ad.yzz.gson.t.l.b
    public void a(AccessibleObject accessibleObject) {
        if (b(accessibleObject)) {
            return;
        }
        try {
            accessibleObject.setAccessible(true);
        } catch (SecurityException e2) {
            throw new JsonIOException("Gson couldn't modify fields for " + accessibleObject + "\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.", e2);
        }
    }

    public boolean b(AccessibleObject accessibleObject) {
        if (this.f32380b != null && this.f32381c != null) {
            try {
                long longValue = ((Long) f32379d.getMethod("objectFieldOffset", Field.class).invoke(this.f32380b, this.f32381c)).longValue();
                f32379d.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE).invoke(this.f32380b, accessibleObject, Long.valueOf(longValue), Boolean.TRUE);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Field b() {
        try {
            return AccessibleObject.class.getDeclaredField("override");
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }
}
