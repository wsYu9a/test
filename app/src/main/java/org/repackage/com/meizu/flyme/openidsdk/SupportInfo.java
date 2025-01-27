package org.repackage.com.meizu.flyme.openidsdk;

import android.text.TextUtils;

/* loaded from: classes4.dex */
class SupportInfo {

    /* renamed from: a */
    String f29373a;

    /* renamed from: b */
    Boolean f29374b;

    public void a(boolean z10) {
        this.f29374b = Boolean.valueOf(z10);
    }

    public void b(String str) {
        this.f29373a = str;
    }

    public boolean a() {
        return this.f29374b != null;
    }

    public boolean b() {
        Boolean bool = this.f29374b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f29373a, str);
    }
}
