package com.wbl.ad.yzz.gson;

import com.wbl.ad.yzz.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;

/* loaded from: classes5.dex */
public final class n extends k {

    /* renamed from: b */
    public static final Class<?>[] f32264b = {Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};

    /* renamed from: a */
    public Object f32265a;

    public n(Boolean bool) {
        b(bool);
    }

    public static boolean a(Object obj) {
        if (obj instanceof String) {
            return true;
        }
        Class<?> cls = obj.getClass();
        for (Class<?> cls2 : f32264b) {
            if (cls2.isAssignableFrom(cls)) {
                return true;
            }
        }
        return false;
    }

    public void b(Object obj) {
        if (obj instanceof Character) {
            this.f32265a = String.valueOf(((Character) obj).charValue());
        } else {
            com.wbl.ad.yzz.gson.t.a.a((obj instanceof Number) || a(obj));
            this.f32265a = obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (this.f32265a == null) {
            return nVar.f32265a == null;
        }
        if (a(this) && a(nVar)) {
            return m().longValue() == nVar.m().longValue();
        }
        Object obj2 = this.f32265a;
        if (!(obj2 instanceof Number) || !(nVar.f32265a instanceof Number)) {
            return obj2.equals(nVar.f32265a);
        }
        double doubleValue = m().doubleValue();
        double doubleValue2 = nVar.m().doubleValue();
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public boolean h() {
        return o() ? i().booleanValue() : Boolean.parseBoolean(n());
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.f32265a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = m().longValue();
        } else {
            Object obj = this.f32265a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(m().doubleValue());
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public Boolean i() {
        return (Boolean) this.f32265a;
    }

    public double j() {
        return p() ? m().doubleValue() : Double.parseDouble(n());
    }

    public int k() {
        return p() ? m().intValue() : Integer.parseInt(n());
    }

    public long l() {
        return p() ? m().longValue() : Long.parseLong(n());
    }

    public Number m() {
        Object obj = this.f32265a;
        return obj instanceof String ? new LazilyParsedNumber((String) this.f32265a) : (Number) obj;
    }

    public String n() {
        return p() ? m().toString() : o() ? i().toString() : (String) this.f32265a;
    }

    public boolean o() {
        return this.f32265a instanceof Boolean;
    }

    public boolean p() {
        return this.f32265a instanceof Number;
    }

    public boolean q() {
        return this.f32265a instanceof String;
    }

    public n(Number number) {
        b(number);
    }

    public n(String str) {
        b(str);
    }

    public static boolean a(n nVar) {
        Object obj = nVar.f32265a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }
}
