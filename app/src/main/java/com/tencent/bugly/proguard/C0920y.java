package com.tencent.bugly.proguard;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes4.dex */
public final class C0920y extends AbstractC0909m implements Cloneable {

    /* renamed from: a */
    static final /* synthetic */ boolean f25182a = true;

    /* renamed from: b */
    public String f25183b;

    /* renamed from: c */
    public byte f25184c;

    /* renamed from: d */
    public int f25185d;

    /* renamed from: e */
    public String f25186e;

    /* renamed from: f */
    public int f25187f;

    /* renamed from: g */
    public String f25188g;

    /* renamed from: h */
    public long f25189h;

    /* renamed from: i */
    public String f25190i;

    /* renamed from: j */
    public String f25191j;
    public String k;
    public String l;

    public C0920y() {
        this.f25183b = "";
        this.f25184c = (byte) 0;
        this.f25185d = 0;
        this.f25186e = "";
        this.f25187f = 0;
        this.f25188g = "";
        this.f25189h = 0L;
        this.f25190i = "";
        this.f25191j = "";
        this.k = "";
        this.l = "";
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0908l c0908l) {
        c0908l.a(this.f25183b, 0);
        c0908l.a(this.f25184c, 1);
        c0908l.a(this.f25185d, 2);
        String str = this.f25186e;
        if (str != null) {
            c0908l.a(str, 3);
        }
        c0908l.a(this.f25187f, 4);
        String str2 = this.f25188g;
        if (str2 != null) {
            c0908l.a(str2, 5);
        }
        c0908l.a(this.f25189h, 6);
        String str3 = this.f25190i;
        if (str3 != null) {
            c0908l.a(str3, 7);
        }
        String str4 = this.f25191j;
        if (str4 != null) {
            c0908l.a(str4, 8);
        }
        String str5 = this.k;
        if (str5 != null) {
            c0908l.a(str5, 9);
        }
        String str6 = this.l;
        if (str6 != null) {
            c0908l.a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f25182a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0920y c0920y = (C0920y) obj;
        return C0910n.a(this.f25183b, c0920y.f25183b) && C0910n.a(this.f25184c, c0920y.f25184c) && C0910n.a(this.f25185d, c0920y.f25185d) && C0910n.a(this.f25186e, c0920y.f25186e) && C0910n.a(this.f25187f, c0920y.f25187f) && C0910n.a(this.f25188g, c0920y.f25188g) && C0910n.a(this.f25189h, c0920y.f25189h) && C0910n.a(this.f25190i, c0920y.f25190i) && C0910n.a(this.f25191j, c0920y.f25191j) && C0910n.a(this.k, c0920y.k) && C0910n.a(this.l, c0920y.l);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public C0920y(String str, byte b2, int i2, String str2, int i3, String str3, long j2, String str4, String str5, String str6, String str7) {
        this.f25183b = "";
        this.f25184c = (byte) 0;
        this.f25185d = 0;
        this.f25186e = "";
        this.f25187f = 0;
        this.f25188g = "";
        this.f25189h = 0L;
        this.f25190i = "";
        this.f25191j = "";
        this.k = "";
        this.l = "";
        this.f25183b = str;
        this.f25184c = b2;
        this.f25185d = i2;
        this.f25186e = str2;
        this.f25187f = i3;
        this.f25188g = str3;
        this.f25189h = j2;
        this.f25190i = str4;
        this.f25191j = str5;
        this.k = str6;
        this.l = str7;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(C0907k c0907k) {
        this.f25183b = c0907k.a(0, true);
        this.f25184c = c0907k.a(this.f25184c, 1, true);
        this.f25185d = c0907k.a(this.f25185d, 2, true);
        this.f25186e = c0907k.a(3, false);
        this.f25187f = c0907k.a(this.f25187f, 4, false);
        this.f25188g = c0907k.a(5, false);
        this.f25189h = c0907k.a(this.f25189h, 6, false);
        this.f25190i = c0907k.a(7, false);
        this.f25191j = c0907k.a(8, false);
        this.k = c0907k.a(9, false);
        this.l = c0907k.a(10, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0909m
    public void a(StringBuilder sb, int i2) {
        C0905i c0905i = new C0905i(sb, i2);
        c0905i.a(this.f25183b, "appId");
        c0905i.a(this.f25184c, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        c0905i.a(this.f25185d, "versionCode");
        c0905i.a(this.f25186e, "versionName");
        c0905i.a(this.f25187f, "buildNo");
        c0905i.a(this.f25188g, DBDefinition.ICON_URL);
        c0905i.a(this.f25189h, "apkId");
        c0905i.a(this.f25190i, "channelId");
        c0905i.a(this.f25191j, "md5");
        c0905i.a(this.k, "sdkVer");
        c0905i.a(this.l, "bundleId");
    }
}
