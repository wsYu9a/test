package com.vivo.mobilead.util;

import com.vivo.mobilead.model.VCustomController;
import com.vivo.mobilead.model.VLocation;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes4.dex */
public class h0 {

    /* renamed from: j */
    private static volatile h0 f30639j;

    /* renamed from: a */
    private VCustomController f30640a;

    /* renamed from: b */
    private volatile int f30641b = UnixStat.PERM_MASK;

    /* renamed from: c */
    private volatile int f30642c = 0;

    /* renamed from: d */
    private volatile int f30643d = UnixStat.PERM_MASK;

    /* renamed from: e */
    private volatile int f30644e = 0;

    /* renamed from: f */
    private volatile int f30645f = UnixStat.PERM_MASK;

    /* renamed from: g */
    private volatile int f30646g = 0;

    /* renamed from: h */
    private volatile boolean f30647h = false;

    /* renamed from: i */
    private VCustomController f30648i = new a();

    class a extends VCustomController {
        a() {
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public String getImei() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.getImei();
                }
            } catch (Exception unused) {
            }
            return super.getImei();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public VLocation getLocation() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.getLocation();
                }
            } catch (Exception unused) {
            }
            return super.getLocation();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanPersonalRecommend() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanPersonalRecommend();
                }
            } catch (Exception unused) {
            }
            return super.isCanPersonalRecommend();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseApplist() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUseApplist();
                }
            } catch (Exception unused) {
            }
            return super.isCanUseApplist();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseImsi() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUseImsi();
                }
            } catch (Exception unused) {
            }
            return super.isCanUseImsi();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseLocation() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUseLocation();
                }
            } catch (Exception unused) {
            }
            return super.isCanUseLocation();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUsePhoneState() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUsePhoneState();
                }
            } catch (Exception unused) {
            }
            return super.isCanUsePhoneState();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWifiState() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUseWifiState();
                }
            } catch (Exception unused) {
            }
            return super.isCanUseWifiState();
        }

        @Override // com.vivo.mobilead.model.VCustomController
        public boolean isCanUseWriteExternal() {
            try {
                if (h0.this.f30640a != null) {
                    return h0.this.f30640a.isCanUseWriteExternal();
                }
            } catch (Exception unused) {
            }
            return super.isCanUseWriteExternal();
        }
    }

    private h0() {
    }

    public static h0 K() {
        if (f30639j == null) {
            synchronized (h0.class) {
                if (f30639j == null) {
                    f30639j = new h0();
                }
            }
        }
        return f30639j;
    }

    private int d(int i2, int i3) {
        return (i2 >> (i3 - 1)) & 1;
    }

    public boolean A() {
        return (e(this.f30646g, 4) && e(this.f30646g, 7)) ? e(this.f30645f, 4) && e(this.f30645f, 7) : this.f30648i.isCanUsePhoneState();
    }

    public boolean B() {
        return (e(this.f30646g, 1) && e(this.f30646g, 2)) ? e(this.f30645f, 1) && e(this.f30645f, 2) : this.f30648i.isCanUseWifiState();
    }

    public boolean C() {
        return e(this.f30646g, 6) ? e(this.f30645f, 6) : this.f30648i.isCanUseWriteExternal();
    }

    public boolean D() {
        return e(this.f30644e, 3) ? e(this.f30643d, 3) : this.f30648i.isCanUseApplist();
    }

    public boolean E() {
        return e(this.f30644e, 5) ? e(this.f30643d, 5) : this.f30648i.isCanUseLocation();
    }

    public boolean F() {
        return (e(this.f30644e, 4) && e(this.f30644e, 7)) ? e(this.f30643d, 4) && e(this.f30643d, 7) : this.f30648i.isCanUsePhoneState();
    }

    public boolean G() {
        return (e(this.f30644e, 1) && e(this.f30644e, 2)) ? e(this.f30643d, 1) && e(this.f30643d, 2) : this.f30648i.isCanUseWifiState();
    }

    public boolean H() {
        return e(this.f30644e, 6) ? e(this.f30643d, 6) : this.f30648i.isCanUseWriteExternal();
    }

    public boolean I() {
        return e(this.f30642c, 3) ? e(this.f30641b, 3) : this.f30648i.isCanUseApplist();
    }

    public boolean J() {
        return e(this.f30642c, 6) ? e(this.f30641b, 6) : this.f30648i.isCanUseWriteExternal();
    }

    public void b(int i2, int i3) {
        this.f30643d = i2;
        this.f30644e = i3;
    }

    public void c(int i2, int i3) {
        this.f30641b = i2;
        this.f30642c = i3;
        com.vivo.mobilead.manager.b.l().putInt("userPrivacyConfigItem", i2);
        com.vivo.mobilead.manager.b.l().putInt("isIgnoreUserPrivacyConfig", i3);
    }

    public String d() {
        return e(this.f30646g, 4) ? e(this.f30645f, 4) ? p0.m().d() : "" : this.f30648i.isCanUsePhoneState() ? p0.m().d() : this.f30648i.getImei() == null ? "" : this.f30648i.getImei();
    }

    public String e() {
        return e(this.f30646g, 10) ? e(this.f30645f, 10) ? p0.m().i() : "" : p0.m().i();
    }

    public int f() {
        return this.f30648i.isCanPersonalRecommend() ? 1 : 0;
    }

    public String g() {
        return e(this.f30644e, 4) ? e(this.f30643d, 4) ? p0.m().d() : "" : this.f30648i.isCanUsePhoneState() ? p0.m().d() : this.f30648i.getImei() == null ? "" : this.f30648i.getImei();
    }

    public String h() {
        return e(this.f30644e, 10) ? e(this.f30643d, 10) ? p0.m().i() : "" : p0.m().i();
    }

    public VLocation i() {
        return this.f30648i.getLocation();
    }

    public String j() {
        return this.f30647h ? e(this.f30642c, 9) ? e(this.f30641b, 9) ? p0.m().a() : "" : p0.m().a() : "";
    }

    public String k() {
        return e(this.f30642c, 7) ? e(this.f30641b, 7) ? p0.m().b() : "" : this.f30648i.isCanUseImsi() ? p0.m().b() : "";
    }

    public int l() {
        if (!e(this.f30642c, 8)) {
            return p0.m().c();
        }
        if (e(this.f30641b, 8)) {
            return p0.m().c();
        }
        return 0;
    }

    public String m() {
        return e(this.f30642c, 4) ? e(this.f30641b, 4) ? p0.m().d() : "" : this.f30648i.isCanUsePhoneState() ? p0.m().d() : this.f30648i.getImei() == null ? "" : this.f30648i.getImei();
    }

    public String n() {
        return e(this.f30642c, 2) ? e(this.f30641b, 2) ? p0.m().e() : "" : this.f30648i.isCanUseWifiState() ? p0.m().e() : "";
    }

    public String o() {
        if (e(this.f30642c, 5)) {
            return e(this.f30641b, 5) ? p0.m().f() : "";
        }
        if (this.f30648i.isCanUseLocation()) {
            return p0.m().f();
        }
        VLocation location = this.f30648i.getLocation();
        if (location == null) {
            return "";
        }
        return location.getLng() + "*" + location.getLat();
    }

    public String p() {
        return e(this.f30642c, 1) ? e(this.f30641b, 1) ? p0.m().g() : "" : this.f30648i.isCanUseWifiState() ? p0.m().g() : "";
    }

    public String q() {
        return e(this.f30642c, 7) ? e(this.f30641b, 7) ? p0.m().h() : "" : this.f30648i.isCanUseImsi() ? p0.m().h() : "";
    }

    public String r() {
        return e(this.f30642c, 10) ? e(this.f30641b, 10) ? p0.m().i() : "" : p0.m().i();
    }

    public int s() {
        if (!e(this.f30642c, 10)) {
            return p0.m().j();
        }
        if (e(this.f30641b, 10)) {
            return p0.m().j();
        }
        return -1;
    }

    public String t() {
        return e(this.f30642c, 12) ? e(this.f30641b, 12) ? p0.m().k() : "" : p0.m().k();
    }

    public String u() {
        return e(this.f30642c, 11) ? e(this.f30641b, 11) ? p0.m().l() : "" : p0.m().l();
    }

    public void v() {
        m();
        p();
        n();
        k();
        q();
        o();
        j();
        r();
        t();
    }

    public boolean w() {
        return e(this.f30646g, 3) ? e(this.f30645f, 3) : this.f30648i.isCanUseApplist();
    }

    public boolean x() {
        return e(this.f30646g, 5) ? e(this.f30645f, 5) : this.f30648i.isCanUseLocation();
    }

    public boolean y() {
        return e(this.f30646g, 1) ? e(this.f30645f, 1) : this.f30648i.isCanUseWifiState();
    }

    public boolean z() {
        return e(this.f30646g, 10) ? e(this.f30645f, 10) : this.f30648i.isCanUseApplist();
    }

    public void a(VCustomController vCustomController) {
        this.f30640a = vCustomController;
        p0.m().a(com.vivo.mobilead.manager.f.j().c());
        this.f30641b = com.vivo.mobilead.manager.b.l().getInt("userPrivacyConfigItem", UnixStat.PERM_MASK);
        this.f30642c = com.vivo.mobilead.manager.b.l().getInt("isIgnoreUserPrivacyConfig", 0);
    }

    public int b() {
        int i2 = this.f30641b;
        if (!e(this.f30642c, 1)) {
            i2 = this.f30648i.isCanUseWifiState() ? i2 | 1 : i2 & 4094;
        }
        if (!e(this.f30642c, 2)) {
            i2 = this.f30648i.isCanUseWifiState() ? i2 | 2 : i2 & 4093;
        }
        if (!e(this.f30642c, 3)) {
            i2 = this.f30648i.isCanUseApplist() ? i2 | 4 : i2 & 4091;
        }
        if (!e(this.f30642c, 4)) {
            i2 = this.f30648i.isCanUsePhoneState() ? i2 | 8 : i2 & 4087;
        }
        if (!e(this.f30642c, 5)) {
            i2 = this.f30648i.isCanUseLocation() ? i2 | 16 : i2 & 4079;
        }
        if (!e(this.f30642c, 6)) {
            i2 = this.f30648i.isCanUseWriteExternal() ? i2 | 32 : i2 & 4063;
        }
        if (!e(this.f30642c, 7)) {
            i2 = this.f30648i.isCanUseImsi() ? i2 | 64 : i2 & 4031;
        }
        if (!e(this.f30642c, 8)) {
            i2 |= 128;
        }
        if (!e(this.f30642c, 9)) {
            i2 |= 256;
        }
        if (!e(this.f30642c, 10)) {
            i2 |= 512;
        }
        if (!e(this.f30642c, 11)) {
            i2 |= 1024;
        }
        return !e(this.f30642c, 12) ? i2 | 2048 : i2;
    }

    private boolean e(int i2, int i3) {
        return d(i2, i3) != 0;
    }

    public String c() {
        if (!this.f30647h) {
            return "";
        }
        if (e(this.f30646g, 9)) {
            return e(this.f30645f, 9) ? p0.m().a() : "";
        }
        return p0.m().a();
    }

    public void a(int i2, int i3) {
        this.f30645f = i2;
        this.f30646g = i3;
    }

    public boolean a() {
        return this.f30648i.isCanPersonalRecommend();
    }

    public void a(boolean z) {
        this.f30647h = z;
    }
}
