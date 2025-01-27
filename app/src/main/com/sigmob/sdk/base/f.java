package com.sigmob.sdk.base;

import android.content.SharedPreferences;
import com.czhj.sdk.common.Constants;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmobPrivacy;
import com.sigmob.sdk.base.mta.PointType;
import com.sigmob.windad.consent.WindAdConsentInformation;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: h */
    public static f f18120h;

    /* renamed from: b */
    public int f18122b;

    /* renamed from: d */
    public int f18124d;

    /* renamed from: e */
    public boolean f18125e;

    /* renamed from: f */
    public int f18126f;

    /* renamed from: g */
    public Boolean f18127g;

    /* renamed from: a */
    public boolean f18121a = true;

    /* renamed from: c */
    public boolean f18123c = true;

    public f() {
        try {
            this.f18122b = com.sigmob.sdk.base.utils.f.a().getInt(Constants.AGE_RESTRICTED_STATUS, 0);
        } catch (Throwable unused) {
        }
        try {
            this.f18124d = com.sigmob.sdk.base.utils.f.a().getInt(Constants.USER_AGE, 0);
        } catch (Throwable unused2) {
        }
        try {
            this.f18126f = com.sigmob.sdk.base.utils.f.a().getInt(Constants.GDPR_CONSENT_STATUS, 0);
        } catch (Throwable unused3) {
        }
        try {
            this.f18125e = com.sigmob.sdk.base.utils.f.a().getBoolean(Constants.EXT_GDPR_REGION, false);
        } catch (Throwable unused4) {
        }
    }

    public static synchronized f f() {
        f fVar;
        synchronized (f.class) {
            try {
                if (f18120h == null) {
                    synchronized (f.class) {
                        f18120h = new f();
                    }
                }
                fVar = f18120h;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    public final void a() {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setUser_consent(String.valueOf(e()));
        pointEntitySigmobPrivacy.setGdpr_region(g() ? "1" : "0");
        try {
            pointEntitySigmobPrivacy.setGdpr_dialog_region(WindAdConsentInformation.getInstance(com.sigmob.sdk.a.d()).isRequestLocationInEeaOrUnknown() ? "1" : "0");
        } catch (Throwable unused) {
        }
        pointEntitySigmobPrivacy.setSub_category(PointCategory.CONSENT);
        pointEntitySigmobPrivacy.setCategory("gdpr");
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.commit();
    }

    public boolean b() {
        return e() == 1 || !g();
    }

    public boolean c() {
        Boolean bool = this.f18127g;
        return bool == null || bool.booleanValue() != this.f18123c;
    }

    public int d() {
        return this.f18122b;
    }

    public int e() {
        return this.f18126f;
    }

    public boolean g() {
        return this.f18125e;
    }

    public int h() {
        return this.f18124d;
    }

    public boolean i() {
        return this.f18121a;
    }

    public boolean j() {
        return this.f18123c;
    }

    public void a(boolean z10, boolean z11) {
        SigmobLog.i("PrivacyManager -> setAdult " + z10);
        this.f18121a = z10;
        if (z11) {
            a(z10);
        }
    }

    public void b(int i10, boolean z10) {
        this.f18126f = i10;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.f.a().edit();
        edit.putInt(Constants.GDPR_CONSENT_STATUS, i10);
        edit.apply();
        if (z10) {
            a();
        }
    }

    public void c(int i10, boolean z10) {
        this.f18124d = i10;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.f.a().edit();
        edit.putInt(Constants.USER_AGE, this.f18124d);
        edit.apply();
        if (z10) {
            b(i10);
        }
    }

    public void a(int i10, boolean z10) {
        this.f18122b = i10;
        SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.f.a().edit();
        edit.putInt(Constants.AGE_RESTRICTED_STATUS, this.f18122b);
        edit.apply();
        if (z10) {
            a(i10);
        }
    }

    public void b(boolean z10, boolean z11) {
        if (this.f18127g == null) {
            this.f18127g = Boolean.valueOf(z10);
        }
        SigmobLog.i("PrivacyManager -> setPersonalized " + z10);
        this.f18123c = z10;
        if (z11) {
            b(z10);
        }
    }

    public void a(Boolean bool) {
        if (bool != null) {
            SharedPreferences.Editor edit = com.sigmob.sdk.base.utils.f.a().edit();
            edit.putBoolean(Constants.EXT_GDPR_REGION, bool.booleanValue());
            edit.apply();
            this.f18125e = bool.booleanValue();
        }
        if (b()) {
            a();
            b(this.f18123c);
            a(this.f18121a);
            a(this.f18122b);
            b(this.f18124d);
        }
    }

    public final void b(boolean z10) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.PERSONALIZED);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_unpersonalized(z10 ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    public final void a(boolean z10) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category(PointCategory.ADULT);
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.setIs_minor(z10 ? "0" : "1");
        pointEntitySigmobPrivacy.commit();
    }

    public final void b(int i10) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge(String.valueOf(i10));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }

    public final void a(int i10) {
        PointEntitySigmobPrivacy pointEntitySigmobPrivacy = new PointEntitySigmobPrivacy();
        pointEntitySigmobPrivacy.setAge_restricted(String.valueOf(i10));
        pointEntitySigmobPrivacy.setAc_type(PointType.GDPR_CONSENT);
        pointEntitySigmobPrivacy.setSub_category("coppa");
        pointEntitySigmobPrivacy.setCategory(PointCategory.PRIVACY);
        pointEntitySigmobPrivacy.commit();
    }
}
