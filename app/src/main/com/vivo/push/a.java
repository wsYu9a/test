package com.vivo.push;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    private Bundle f24902a;

    /* renamed from: b */
    private String f24903b;

    /* renamed from: c */
    private String f24904c;

    public a(String str, String str2, Bundle bundle) {
        this.f24903b = str;
        this.f24904c = str2;
        this.f24902a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.vivo.push.a a(android.content.Intent r6) {
        /*
            r0 = 0
            java.lang.String r1 = "BundleWapper"
            if (r6 != 0) goto Lb
            java.lang.String r6 = "create error : intent is null"
            com.vivo.push.util.p.a(r1, r6)
            return r0
        Lb:
            android.os.Bundle r2 = r6.getExtras()
            if (r2 == 0) goto L1e
            java.lang.String r3 = "client_pkgname"
            java.lang.String r3 = r2.getString(r3)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L1e
            goto L1f
        L1e:
            r3 = r0
        L1f:
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 == 0) goto L2a
            java.lang.String r4 = "create warning: pkgName is null"
            com.vivo.push.util.p.b(r1, r4)
        L2a:
            java.lang.String r4 = r6.getPackage()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L4f
            android.content.ComponentName r4 = r6.getComponent()
            if (r4 != 0) goto L3b
            goto L43
        L3b:
            android.content.ComponentName r6 = r6.getComponent()
            java.lang.String r0 = r6.getPackageName()
        L43:
            boolean r6 = android.text.TextUtils.isEmpty(r0)
            if (r6 == 0) goto L4e
            java.lang.String r6 = "create warning: targetPkgName is null"
            com.vivo.push.util.p.b(r1, r6)
        L4e:
            r4 = r0
        L4f:
            com.vivo.push.a r6 = new com.vivo.push.a
            r6.<init>(r3, r4, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.a.a(android.content.Intent):com.vivo.push.a");
    }

    public final int b(String str, int i10) {
        Bundle bundle = this.f24902a;
        return bundle == null ? i10 : bundle.getInt(str, i10);
    }

    public final ArrayList<String> c(String str) {
        Bundle bundle = this.f24902a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    public final Serializable d(String str) {
        Bundle bundle = this.f24902a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    public final boolean e(String str) {
        Bundle bundle = this.f24902a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    public final byte[] b(String str) {
        Bundle bundle = this.f24902a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    public final long b(String str, long j10) {
        Bundle bundle = this.f24902a;
        return bundle == null ? j10 : bundle.getLong(str, j10);
    }

    public final Bundle b() {
        return this.f24902a;
    }

    public final void a(String str, int i10) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putInt(str, i10);
    }

    public final void a(String str, long j10) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putLong(str, j10);
    }

    public final void a(String str, String str2) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putString(str, str2);
    }

    public final void a(String str, byte[] bArr) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putByteArray(str, bArr);
    }

    public final void a(String str, Serializable serializable) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putSerializable(str, serializable);
    }

    public final void a(String str, boolean z10) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putBoolean(str, z10);
    }

    public final void a(String str, ArrayList<String> arrayList) {
        if (this.f24902a == null) {
            this.f24902a = new Bundle();
        }
        this.f24902a.putStringArrayList(str, arrayList);
    }

    public final String a(String str) {
        Bundle bundle = this.f24902a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    public final String a() {
        return this.f24903b;
    }
}
