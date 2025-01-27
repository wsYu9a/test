package org.repackage.com.meizu.flyme.openidsdk;

/* loaded from: classes5.dex */
class ValueData {

    /* renamed from: a */
    public String f35565a;

    /* renamed from: b */
    public int f35566b;

    /* renamed from: c */
    public long f35567c = System.currentTimeMillis() + 86400000;

    public ValueData(String str, int i2) {
        this.f35565a = str;
        this.f35566b = i2;
    }

    public String toString() {
        return "ValueData{value='" + this.f35565a + "', code=" + this.f35566b + ", expired=" + this.f35567c + '}';
    }
}
