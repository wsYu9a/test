package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.kuaishou.weapon.p0.receiver.WeaponRECE;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class WeaponHI {
    public static boolean as = false;
    public static String cookieData = "";
    public static String encryENV = "";
    public static String hostVersionName = "";
    public static int ii = 0;
    public static List<Integer> isList = null;
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
    static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ boolean f9044a;

        AnonymousClass1(boolean z) {
            z = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Context context = WeaponHI.mContext;
            if (context != null) {
                h a2 = h.a(context, "re_po_rt");
                boolean z = z;
                if (!z) {
                    a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                    return;
                }
                if (a2.e("a1_p_s_p_s_c_b")) {
                    return;
                }
                a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                try {
                    if (a2.c(de.bi, 1) == 1) {
                        da.a(WeaponHI.mContext).a(103);
                        db.a(WeaponHI.mContext).a(103);
                        cz.a(WeaponHI.mContext).a(103, 0);
                        cx.a(WeaponHI.mContext).a(103);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$2 */
    static class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                IWeaponInitParams iWeaponInitParams = IWeaponInitParams.this;
                WeaponHI.mParams = iWeaponInitParams;
                WeaponHI.sKSAppkey = iWeaponInitParams.getAppKey();
                WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                WeaponHI.sKSSdkver = "5.0.9";
                WeaponHI.hostVersionName = bg.q(WeaponHI.mContext);
                WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                WeaponHI.cookieData = bg.B(WeaponHI.mContext);
                try {
                    h a2 = h.a(WeaponHI.mContext, "re_po_rt");
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("k", cl.m());
                    jSONObject.put("d", cl.b(WeaponHI.mContext));
                    jSONObject.put("a", bg.q(WeaponHI.mContext));
                    jSONObject.put("p", bg.s(WeaponHI.mContext));
                    jSONObject.put("s", "5.0.9");
                    jSONObject.put("n", TextUtils.isEmpty(a2.a(de.f9285g)) ? 1 : 0);
                    WeaponHI.encryENV = new bm(WeaponHI.mContext).c(jSONObject.toString());
                    String a3 = a2.a(de.s);
                    if (!TextUtils.isEmpty(a3)) {
                        WeaponHI.isList = Arrays.asList(a3.split("\\|"));
                        WeaponHI.ii = a2.c(de.t, 5);
                    }
                } catch (Throwable unused) {
                }
                WeaponHI.init(WeaponHI.sKSAppkey, WeaponHI.sKSSecKey, IWeaponInitParams.this.getPrivacySwitch());
            } catch (Throwable unused2) {
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.WeaponHI$3 */
    static class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                q a2 = q.a(WeaponHI.mContext);
                if (a2 == null) {
                    return;
                }
                a2.a();
            } catch (Exception unused) {
            }
        }
    }

    public static void iD() {
        try {
            iP(mContext);
            WeaponRECE weaponRECE = new WeaponRECE();
            Context context = mContext;
            Application application = context instanceof Application ? (Application) context : null;
            if (application != null) {
                IntentFilter intentFilter = new IntentFilter(bp.f9128f);
                intentFilter.addDataScheme("env");
                application.registerReceiver(weaponRECE, intentFilter);
            }
        } catch (Throwable unused) {
        }
        try {
            da.a(mContext).a(100);
            cw.a(mContext).a(100);
            db.a(mContext).a(100);
            cz.a(mContext).a(100, 0);
            cx.a(mContext).a(100);
            cy.a(mContext).a();
            dc.a(mContext).a();
        } catch (Exception unused2) {
        }
    }

    public static void iP(Context context) {
        try {
            long b2 = de.a(context).b();
            long currentTimeMillis = (System.currentTimeMillis() - b2) - (h.a(context, "re_po_rt").c(de.f9286h, 12) * 3600000);
            if (b2 < 1 || currentTimeMillis > 0) {
                n.a().a(new cv(context));
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
                    AnonymousClass2() {
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            IWeaponInitParams iWeaponInitParams2 = IWeaponInitParams.this;
                            WeaponHI.mParams = iWeaponInitParams2;
                            WeaponHI.sKSAppkey = iWeaponInitParams2.getAppKey();
                            WeaponHI.sKSSecKey = IWeaponInitParams.this.getSecKey();
                            WeaponHI.sKSSdkver = "5.0.9";
                            WeaponHI.hostVersionName = bg.q(WeaponHI.mContext);
                            WeaponHI.sKDeviceId = IWeaponInitParams.this.getDeviceId();
                            WeaponHI.skProductName = IWeaponInitParams.this.getProductName();
                            WeaponHI.sUserId = IWeaponInitParams.this.getUserId();
                            WeaponHI.sChannel = IWeaponInitParams.this.getChannel();
                            WeaponHI.as = IWeaponInitParams.this.getAPPLISTSwitch();
                            WeaponHI.cookieData = bg.B(WeaponHI.mContext);
                            try {
                                h a2 = h.a(WeaponHI.mContext, "re_po_rt");
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("k", cl.m());
                                jSONObject.put("d", cl.b(WeaponHI.mContext));
                                jSONObject.put("a", bg.q(WeaponHI.mContext));
                                jSONObject.put("p", bg.s(WeaponHI.mContext));
                                jSONObject.put("s", "5.0.9");
                                jSONObject.put("n", TextUtils.isEmpty(a2.a(de.f9285g)) ? 1 : 0);
                                WeaponHI.encryENV = new bm(WeaponHI.mContext).c(jSONObject.toString());
                                String a3 = a2.a(de.s);
                                if (!TextUtils.isEmpty(a3)) {
                                    WeaponHI.isList = Arrays.asList(a3.split("\\|"));
                                    WeaponHI.ii = a2.c(de.t, 5);
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

    public static void init(String str, String str2, boolean z) {
        try {
            h.a(mContext, "re_po_rt").a("a1_p_s_p_s", Boolean.valueOf(z));
            n.a();
            bs.a(mContext);
            br.a(mContext);
        } catch (Exception unused) {
        }
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.3
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    q a2 = q.a(WeaponHI.mContext);
                    if (a2 == null) {
                        return;
                    }
                    a2.a();
                } catch (Exception unused2) {
                }
            }
        });
    }

    public static void setPS(boolean z) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.WeaponHI.1

                /* renamed from: a */
                final /* synthetic */ boolean f9044a;

                AnonymousClass1(boolean z2) {
                    z = z2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Context context = WeaponHI.mContext;
                    if (context != null) {
                        h a2 = h.a(context, "re_po_rt");
                        boolean z2 = z;
                        if (!z2) {
                            a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z2));
                            return;
                        }
                        if (a2.e("a1_p_s_p_s_c_b")) {
                            return;
                        }
                        a2.a("a1_p_s_p_s_c_b", Boolean.valueOf(z));
                        try {
                            if (a2.c(de.bi, 1) == 1) {
                                da.a(WeaponHI.mContext).a(103);
                                db.a(WeaponHI.mContext).a(103);
                                cz.a(WeaponHI.mContext).a(103, 0);
                                cx.a(WeaponHI.mContext).a(103);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            });
        } catch (Exception unused) {
        }
    }
}
