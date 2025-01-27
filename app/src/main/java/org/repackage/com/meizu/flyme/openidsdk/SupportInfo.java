package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: classes5.dex */
class SupportInfo {

    /* renamed from: a */
    String f35563a;

    /* renamed from: b */
    Boolean f35564b;

    SupportInfo() {
    }

    void a(boolean z) {
        this.f35564b = Boolean.valueOf(z);
    }

    boolean a() {
        return this.f35564b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f35563a, str);
    }

    void b(String str) {
        this.f35563a = str;
    }

    boolean b() {
        Boolean bool = this.f35564b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
