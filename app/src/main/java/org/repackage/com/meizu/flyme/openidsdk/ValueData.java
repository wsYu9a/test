package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes4.dex */
class ValueData {

    /* renamed from: a */
    public String f29375a;

    /* renamed from: b */
    public int f29376b;

    /* renamed from: c */
    public long f29377c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i10) {
        this.f29375a = str;
        this.f29376b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f29375a + "', code=" + this.f29376b + ", expired=" + this.f29377c + '}';
    }
}
