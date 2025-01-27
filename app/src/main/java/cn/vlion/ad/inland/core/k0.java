package cn.vlion.ad.inland.core;

import cn.vlion.ad.inland.ad.adapter.VlionCustomAdapter;
import cn.vlion.ad.inland.ba.VlionBaAdapter;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.cs.VlionCsAdapter;
import cn.vlion.ad.inland.gd.VlionGdAdapter;
import cn.vlion.ad.inland.jd.VlionJDAdapter;
import cn.vlion.ad.inland.kd.VlionKDAdapter;
import cn.vlion.ad.inland.ku.VlionKuAdapter;
import cn.vlion.ad.inland.ta.VlionTaAdapter;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a */
    public static boolean f3685a = false;

    /* renamed from: b */
    public static boolean f3686b = false;

    /* renamed from: c */
    public static boolean f3687c = false;

    /* renamed from: d */
    public static boolean f3688d = false;

    /* renamed from: e */
    public static boolean f3689e = false;

    /* renamed from: f */
    public static boolean f3690f = false;

    /* renamed from: g */
    public static boolean f3691g = false;

    /* renamed from: h */
    public static boolean f3692h = false;

    /* renamed from: i */
    public static String f3693i = "";

    public static void a() {
        try {
            new VlionCustomAdapter();
            f3693i += VlionCustomAdapter.class.getName() + ",";
            f3685a = true;
            LogVlion.e("VlionSourceCheckState vlion check:");
        } catch (Exception e10) {
            f3685a = false;
            StringBuilder a10 = f.a("VlionSourceCheckState vlion Exception:");
            a10.append(e10.getMessage());
            LogVlion.e(a10.toString());
        } catch (Throwable th2) {
            f3685a = false;
            StringBuilder a11 = f.a("VlionSourceCheckState vlion Throwable--------");
            a11.append(th2.getMessage());
            LogVlion.e(a11.toString());
        }
        try {
            new VlionJDAdapter();
            f3693i += VlionJDAdapter.class.getName() + ",";
            f3686b = true;
            LogVlion.e("VlionSourceCheckState vlionj check:");
        } catch (Exception e11) {
            f3686b = false;
            StringBuilder a12 = f.a("VlionSourceCheckState vlionj Exception:");
            a12.append(e11.getMessage());
            LogVlion.e(a12.toString());
        } catch (Throwable th3) {
            f3686b = false;
            StringBuilder a13 = f.a("VlionSourceCheckState vlionj Throwable--------");
            a13.append(th3.getMessage());
            LogVlion.e(a13.toString());
        }
        try {
            new VlionBaAdapter();
            f3693i += VlionBaAdapter.class.getName() + ",";
            f3687c = true;
            LogVlion.e("VlionSourceCheckState VlionBaAdapter check:");
        } catch (Exception e12) {
            f3687c = false;
            StringBuilder a14 = f.a("VlionSourceCheckState VlionBaAdapter Exception:");
            a14.append(e12.getMessage());
            LogVlion.e(a14.toString());
        } catch (Throwable th4) {
            f3687c = false;
            StringBuilder a15 = f.a("VlionSourceCheckState VlionBaAdapter Throwable--------");
            a15.append(th4.getMessage());
            LogVlion.e(a15.toString());
        }
        try {
            new VlionGdAdapter();
            f3693i += VlionGdAdapter.class.getName() + ",";
            f3689e = true;
        } catch (Exception e13) {
            f3689e = false;
            StringBuilder a16 = f.a("VlionSourceCheckState vlionGd Exception:");
            a16.append(e13.getMessage());
            LogVlion.e(a16.toString());
        } catch (Throwable th5) {
            f3689e = false;
            StringBuilder a17 = f.a("VlionSourceCheckState vlionGd Throwable--------");
            a17.append(th5.getMessage());
            LogVlion.e(a17.toString());
        }
        try {
            new VlionTaAdapter();
            f3693i += VlionTaAdapter.class.getName() + ",";
            f3691g = true;
            LogVlion.e("VlionSourceCheckState VlionTaAdapter check:");
        } catch (Exception e14) {
            f3691g = false;
            StringBuilder a18 = f.a("VlionSourceCheckState VlionTaAdapter Exception:");
            a18.append(e14.getMessage());
            LogVlion.e(a18.toString());
        } catch (Throwable th6) {
            f3691g = false;
            StringBuilder a19 = f.a("VlionSourceCheckState VlionTaAdapter Throwable--------");
            a19.append(th6.getMessage());
            LogVlion.e(a19.toString());
        }
        try {
            new VlionCsAdapter();
            f3693i += VlionCsAdapter.class.getName() + ",";
            f3688d = true;
            LogVlion.e("VlionSourceCheckState VlionCsAdapter check:");
        } catch (Exception e15) {
            f3688d = false;
            StringBuilder a20 = f.a("VlionSourceCheckState VlionCsAdapter Exception:");
            a20.append(e15.getMessage());
            LogVlion.e(a20.toString());
        } catch (Throwable th7) {
            f3688d = false;
            StringBuilder a21 = f.a("VlionSourceCheckState VlionCsAdapter Throwable--------");
            a21.append(th7.getMessage());
            LogVlion.e(a21.toString());
        }
        try {
            new VlionKuAdapter();
            f3693i += VlionKuAdapter.class.getName() + ",";
            f3690f = true;
            LogVlion.e("VlionSourceCheckState VlionKuAdapter check:");
        } catch (Exception e16) {
            f3690f = false;
            StringBuilder a22 = f.a("VlionSourceCheckState VlionKuAdapter Exception:");
            a22.append(e16.getMessage());
            LogVlion.e(a22.toString());
        } catch (Throwable th8) {
            f3690f = false;
            StringBuilder a23 = f.a("VlionSourceCheckState VlionKuAdapter Throwable--------");
            a23.append(th8.getMessage());
            LogVlion.e(a23.toString());
        }
        try {
            new VlionKDAdapter();
            f3693i += VlionKDAdapter.class.getName() + ",";
            f3692h = true;
            LogVlion.e("VlionSourceCheckState VlionKDAdapter check:");
        } catch (Exception e17) {
            f3692h = false;
            StringBuilder a24 = f.a("VlionSourceCheckState VlionKDAdapter Exception:");
            a24.append(e17.getMessage());
            LogVlion.e(a24.toString());
        } catch (Throwable th9) {
            f3692h = false;
            StringBuilder a25 = f.a("VlionSourceCheckState VlionKDAdapter Throwable--------");
            a25.append(th9.getMessage());
            LogVlion.e(a25.toString());
        }
    }

    public static boolean b() {
        return f3687c;
    }

    public static boolean c() {
        return f3688d;
    }

    public static boolean d() {
        return f3689e;
    }

    public static boolean e() {
        return f3691g;
    }

    public static boolean f() {
        return f3692h;
    }

    public static boolean g() {
        return f3686b;
    }

    public static boolean h() {
        return f3690f;
    }

    public static boolean i() {
        return f3685a;
    }

    public static String j() {
        return f3693i;
    }
}
