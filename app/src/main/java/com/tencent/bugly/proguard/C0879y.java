package com.tencent.bugly.proguard;

import com.kwad.sdk.core.scene.URLPackage;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.mm.opensdk.constants.ConstantsAPI;

/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes4.dex */
public final class C0879y extends AbstractC0868m implements Cloneable {

    /* renamed from: a */
    static final /* synthetic */ boolean f22894a = true;

    /* renamed from: b */
    public String f22895b;

    /* renamed from: c */
    public byte f22896c;

    /* renamed from: d */
    public int f22897d;

    /* renamed from: e */
    public String f22898e;

    /* renamed from: f */
    public int f22899f;

    /* renamed from: g */
    public String f22900g;

    /* renamed from: h */
    public long f22901h;

    /* renamed from: i */
    public String f22902i;

    /* renamed from: j */
    public String f22903j;

    /* renamed from: k */
    public String f22904k;

    /* renamed from: l */
    public String f22905l;

    public C0879y() {
        this.f22895b = "";
        this.f22896c = (byte) 0;
        this.f22897d = 0;
        this.f22898e = "";
        this.f22899f = 0;
        this.f22900g = "";
        this.f22901h = 0L;
        this.f22902i = "";
        this.f22903j = "";
        this.f22904k = "";
        this.f22905l = "";
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0867l c0867l) {
        c0867l.a(this.f22895b, 0);
        c0867l.a(this.f22896c, 1);
        c0867l.a(this.f22897d, 2);
        String str = this.f22898e;
        if (str != null) {
            c0867l.a(str, 3);
        }
        c0867l.a(this.f22899f, 4);
        String str2 = this.f22900g;
        if (str2 != null) {
            c0867l.a(str2, 5);
        }
        c0867l.a(this.f22901h, 6);
        String str3 = this.f22902i;
        if (str3 != null) {
            c0867l.a(str3, 7);
        }
        String str4 = this.f22903j;
        if (str4 != null) {
            c0867l.a(str4, 8);
        }
        String str5 = this.f22904k;
        if (str5 != null) {
            c0867l.a(str5, 9);
        }
        String str6 = this.f22905l;
        if (str6 != null) {
            c0867l.a(str6, 10);
        }
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f22894a) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C0879y c0879y = (C0879y) obj;
        return C0869n.a(this.f22895b, c0879y.f22895b) && C0869n.a(this.f22896c, c0879y.f22896c) && C0869n.a(this.f22897d, c0879y.f22897d) && C0869n.a(this.f22898e, c0879y.f22898e) && C0869n.a(this.f22899f, c0879y.f22899f) && C0869n.a(this.f22900g, c0879y.f22900g) && C0869n.a(this.f22901h, c0879y.f22901h) && C0869n.a(this.f22902i, c0879y.f22902i) && C0869n.a(this.f22903j, c0879y.f22903j) && C0869n.a(this.f22904k, c0879y.f22904k) && C0869n.a(this.f22905l, c0879y.f22905l);
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public C0879y(String str, byte b10, int i10, String str2, int i11, String str3, long j10, String str4, String str5, String str6, String str7) {
        this.f22895b = str;
        this.f22896c = b10;
        this.f22897d = i10;
        this.f22898e = str2;
        this.f22899f = i11;
        this.f22900g = str3;
        this.f22901h = j10;
        this.f22902i = str4;
        this.f22903j = str5;
        this.f22904k = str6;
        this.f22905l = str7;
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(C0866k c0866k) {
        this.f22895b = c0866k.a(0, true);
        this.f22896c = c0866k.a(this.f22896c, 1, true);
        this.f22897d = c0866k.a(this.f22897d, 2, true);
        this.f22898e = c0866k.a(3, false);
        this.f22899f = c0866k.a(this.f22899f, 4, false);
        this.f22900g = c0866k.a(5, false);
        this.f22901h = c0866k.a(this.f22901h, 6, false);
        this.f22902i = c0866k.a(7, false);
        this.f22903j = c0866k.a(8, false);
        this.f22904k = c0866k.a(9, false);
        this.f22905l = c0866k.a(10, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC0868m
    public void a(StringBuilder sb2, int i10) {
        C0864i c0864i = new C0864i(sb2, i10);
        c0864i.a(this.f22895b, "appId");
        c0864i.a(this.f22896c, ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY);
        c0864i.a(this.f22897d, "versionCode");
        c0864i.a(this.f22898e, "versionName");
        c0864i.a(this.f22899f, "buildNo");
        c0864i.a(this.f22900g, DBDefinition.ICON_URL);
        c0864i.a(this.f22901h, "apkId");
        c0864i.a(this.f22902i, URLPackage.KEY_CHANNEL_ID);
        c0864i.a(this.f22903j, "md5");
        c0864i.a(this.f22904k, "sdkVer");
        c0864i.a(this.f22905l, "bundleId");
    }
}
