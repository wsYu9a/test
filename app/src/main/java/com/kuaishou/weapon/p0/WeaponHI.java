package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";

    /* renamed from: ii */
    public static int f10723ii = 0;
    public static List<Integer> isList = null;
    public static boolean isLoad = true;
    public static Context mContext = null;
    public static IWeaponInitParams mParams = null;
    public static String sChannel = "";
    public static String sKDeviceId = "";
    public static String sKSAppkey = "";
    public static String sKSSdkver = "";
    public static String sKSSecKey = "";
    public static String sUserId = "";
    public static String skProductName = "";

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f10724a;

        public AnonymousClass1(boolean z10) {
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = WeaponHI.mContext;
            if (context != null) {
                h a10 = h.a(context, "re_po_rt");
                boolean z10 = z10;
                if (!z10) {
                    a10.a("a1_p_s_p_s_c_b", Boolean.valueOf(z10));
                    return;
                }
                if (a10.e("a1_p_s_p_s_c_b")) {
                    return;
                }
                a10.a("a1_p_s_p_s_c_b", Boolean.valueOf(z10));
                try {
                    if (a10.c(df.bq, 1) == 1) {
                        dd.a(WeaponHI.mContext).a(103);
                        db.a(WeaponHI.mContext).a(103, 0);
                        cy.a(WeaponHI.mContext).a(103);
                        dc.a(WeaponHI.mContext).a(103);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$2 */
    public static class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                IWeaponInitParams iWeaponInitParams = IWeaponInitParams.this;
                WeaponHI.mParams = iWeaponInitParams;
                WeaponHI.sKSAppkey = iWeaponInitParams.getAppKey();
                WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                WeaponHI.sKSSdkver = "5.3.6";
                WeaponHI.hostVersionName = bh.q(WeaponHI.mContext);
                WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                WeaponHI.isLoad = IWeaponInitParams.this.isLoadSo();
                WeaponHI.cookieData = bh.y(WeaponHI.mContext);
                try {
                    h a10 = h.a(WeaponHI.mContext, "re_po_rt");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("k", cm.m());
                    jSONObject.put("d", cm.b(WeaponHI.mContext));
                    jSONObject.put("a", bh.q(WeaponHI.mContext));
                    jSONObject.put("p", bh.s(WeaponHI.mContext));
                    jSONObject.put("s", "5.3.6");
                    jSONObject.put("n", TextUtils.isEmpty(a10.a(df.f11053g)) ? 1 : 0);
                    WeaponHI.encryENV = new bn(WeaponHI.mContext).c(jSONObject.toString());
                    String a11 = a10.a(df.f11067u);
                    if (!TextUtils.isEmpty(a11)) {
                        WeaponHI.isList = Arrays.asList(a11.split("\\|"));
                        WeaponHI.f10723ii = a10.c(df.f11068v, 5);
                    }
                } catch (Throwable unused) {
                }
                WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$3 */
    public static class AnonymousClass3 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            try {
                q a10 = q.a(WeaponHI.mContext);
                if (a10 == null) {
                    return;
                }
                a10.a();
            } catch (Exception unused) {
            }
        }
    }

    public static void iD() {
        try {
            iP(mContext);
        } catch (Throwable unused) {
        }
        try {
            db.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            dd.a(mContext).a(100);
            cz.a(mContext).a(100);
            de.a(mContext).a(100);
            da.a(mContext).a();
            cy.a(mContext).a(100);
            dc.a(mContext).a(100);
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long b10 = df.a(context).b();
            long currentTimeMillis = (System.currentTimeMillis() - b10) - (h.a(context, "re_po_rt").c(df.f11054h, 12) * 3600000);
            if (b10 < 1 || currentTimeMillis > 0) {
                n.a().a(new cw(context));
            }
        } catch (Throwable unused) {
        }
    }

    public static void init(Context context, IWeaponInitParams iWeaponInitParams) {
        try {
            Context applicationContext = context.getApplicationContext();
            mContext = applicationContext;
            if (applicationContext instanceof Application) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.2
                    public AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = IWeaponInitParams.this;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.3.6";
                            WeaponHI.hostVersionName = bh.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.isLoad = IWeaponInitParams.this.isLoadSo();
                            WeaponHI.cookieData = bh.y(WeaponHI.mContext);
                            try {
                                h a10 = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cm.m());
                                jSONObject.put("d", cm.b(WeaponHI.mContext));
                                jSONObject.put("a", bh.q(WeaponHI.mContext));
                                jSONObject.put("p", bh.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.3.6");
                                jSONObject.put("n", TextUtils.isEmpty(a10.a(df.f11053g)) ? 1 : 0);
                                WeaponHI.encryENV = new bn(WeaponHI.mContext).c(jSONObject.toString());
                                String a11 = a10.a(df.f11067u);
                                if (!TextUtils.isEmpty(a11)) {
                                    WeaponHI.isList = Arrays.asList(a11.split("\\|"));
                                    WeaponHI.f10723ii = a10.c(df.f11068v, 5);
                                }
                            } catch (Throwable unused) {
                            }
                            WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
                        } catch (Throwable unused2) {
                        }
                    }
                });
            } else {
                Log.e("Risk", "context  is not application！！！");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setPS(boolean z10) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1

                /* renamed from: a */
                final /* synthetic */ boolean f10724a;

                public AnonymousClass1(boolean z102) {
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h a10 = h.a(context, "re_po_rt");
                        boolean z102 = z10;
                        if (!z102) {
                            a10.a("a1_p_s_p_s_c_b", Boolean.valueOf(z102));
                            return;
                        }
                        if (a10.e("a1_p_s_p_s_c_b")) {
                            return;
                        }
                        a10.a("a1_p_s_p_s_c_b", Boolean.valueOf(z10));
                        try {
                            if (a10.c(df.bq, 1) == 1) {
                                dd.a(WeaponHI.mContext).a(103);
                                db.a(WeaponHI.mContext).a(103, 0);
                                cy.a(WeaponHI.mContext).a(103);
                                dc.a(WeaponHI.mContext).a(103);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    public static void init(String str, String str2, boolean z10) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z10));
            n.a();
            bt.a(mContext);
            bs.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q a10 = q.a(WeaponHI.mContext);
                    if (a10 == null) {
                        return;
                    }
                    a10.a();
                } catch (Exception unused2) {
                }
            }
        });
    }
}
