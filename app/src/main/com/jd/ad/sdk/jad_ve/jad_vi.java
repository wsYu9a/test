package com.jd.ad.sdk.jad_ve;

import android.graphics.Color;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.jd.ad.sdk.jad_wf.jad_cp;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import n3.a;

/* loaded from: classes2.dex */
public class jad_vi {
    public static final jad_cp.jad_an jad_an = jad_cp.jad_an.jad_an("nm", "ind", "refId", a.f28753s, "parent", "sw", "sh", "sc", MediationConstant.ADN_KS, "tt", "masksProperties", "shapes", bt.aO, "ef", "sr", "st", IAdInterListener.AdReqParam.WIDTH, "h", "ip", "op", "tm", "cl", "hd");
    public static final jad_cp.jad_an jad_bo = jad_cp.jad_an.jad_an("d", "a");
    public static final jad_cp.jad_an jad_cp = jad_cp.jad_an.jad_an(a.f28753s, "nm");

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length];
            jad_an = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:302:0x03a8. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    public static com.jd.ad.sdk.jad_tc.jad_er jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        ArrayList arrayList;
        int i10;
        String str;
        String str2;
        String str3;
        char c10;
        char c11;
        String str4;
        String str5;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar4;
        char c12;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jad_cpVar.jad_cp();
        boolean z10 = false;
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        boolean z11 = true;
        long j10 = -1;
        float f10 = 0.0f;
        int i11 = 0;
        String str6 = null;
        com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar = null;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        float f11 = 1.0f;
        float f12 = 0.0f;
        int i15 = 0;
        int i16 = 0;
        com.jd.ad.sdk.jad_ra.jad_jw jad_jwVar = null;
        com.jd.ad.sdk.jad_ra.jad_kx jad_kxVar = null;
        int i17 = 1;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar5 = null;
        boolean z12 = false;
        com.jd.ad.sdk.jad_sb.jad_an jad_anVar = null;
        jad_jw jad_jwVar2 = null;
        float f13 = 0.0f;
        long j11 = 0;
        String str7 = "UNSET";
        String str8 = null;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    str7 = jad_cpVar.jad_ly();
                    z11 = true;
                    z10 = false;
                    break;
                case 1:
                    j11 = jad_cpVar.jad_jw();
                    z11 = true;
                    z10 = false;
                    break;
                case 2:
                    str6 = jad_cpVar.jad_ly();
                    z11 = true;
                    z10 = false;
                    break;
                case 3:
                    str2 = str8;
                    int jad_jw = jad_cpVar.jad_jw();
                    i11 = 7;
                    if (jad_jw < 6) {
                        i11 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(7)[jad_jw];
                    }
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
                case 4:
                    str2 = str8;
                    j10 = jad_cpVar.jad_jw();
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
                case 5:
                    i12 = (int) (com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    z11 = true;
                    z10 = false;
                    break;
                case 6:
                    i13 = (int) (com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    z11 = true;
                    z10 = false;
                    break;
                case 7:
                    i14 = Color.parseColor(jad_cpVar.jad_ly());
                    z11 = true;
                    z10 = false;
                    break;
                case 8:
                    jad_lyVar = jad_cp.jad_an(jad_cpVar, jad_jtVar);
                    z11 = true;
                    z10 = false;
                    break;
                case 9:
                    str2 = str8;
                    int jad_jw2 = jad_cpVar.jad_jw();
                    if (jad_jw2 >= com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length) {
                        jad_jtVar.jad_an("Unsupported matte type: " + jad_jw2);
                    } else {
                        i17 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6)[jad_jw2];
                        int i18 = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(i17)];
                        if (i18 != 1) {
                            str3 = i18 == 2 ? "Unsupported matte type: Luma Inverted" : "Unsupported matte type: Luma";
                            jad_jtVar.jad_ob++;
                        }
                        jad_jtVar.jad_an(str3);
                        jad_jtVar.jad_ob++;
                    }
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
                case 10:
                    str2 = str8;
                    com.jd.ad.sdk.jad_ra.jad_hu jad_huVar = null;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        com.jd.ad.sdk.jad_ra.jad_hu jad_huVar2 = jad_huVar;
                        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar = jad_huVar2;
                        int i19 = 0;
                        boolean z13 = false;
                        while (jad_cpVar.jad_jt()) {
                            String jad_kx = jad_cpVar.jad_kx();
                            jad_kx.getClass();
                            switch (jad_kx.hashCode()) {
                                case 111:
                                    if (jad_kx.equals("o")) {
                                        c10 = 0;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3588:
                                    if (jad_kx.equals("pt")) {
                                        c10 = 1;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 104433:
                                    if (jad_kx.equals("inv")) {
                                        c10 = 2;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                case 3357091:
                                    if (jad_kx.equals("mode")) {
                                        c10 = 3;
                                        break;
                                    }
                                    c10 = 65535;
                                    break;
                                default:
                                    c10 = 65535;
                                    break;
                            }
                            switch (c10) {
                                case 0:
                                    jad_dqVar = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                                    break;
                                case 1:
                                    jad_huVar2 = new com.jd.ad.sdk.jad_ra.jad_hu(jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), jad_gr.jad_an, false));
                                    jad_dqVar = jad_dqVar;
                                    break;
                                case 2:
                                    z13 = jad_cpVar.jad_hu();
                                    break;
                                case 3:
                                    String jad_ly = jad_cpVar.jad_ly();
                                    jad_ly.getClass();
                                    switch (jad_ly.hashCode()) {
                                        case 97:
                                            if (jad_ly.equals("a")) {
                                                c11 = 0;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 105:
                                            if (jad_ly.equals("i")) {
                                                c11 = 1;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case 110:
                                            if (jad_ly.equals("n")) {
                                                c11 = 2;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        case TTDownloadField.CALL_DOWNLOAD_MODEL_SHOULD_DOWNLOAD_WITH_PATCH_APPLY /* 115 */:
                                            if (jad_ly.equals("s")) {
                                                c11 = 3;
                                                break;
                                            }
                                            c11 = 65535;
                                            break;
                                        default:
                                            c11 = 65535;
                                            break;
                                    }
                                    switch (c11) {
                                        case 0:
                                            i19 = 1;
                                            break;
                                        case 1:
                                            jad_jtVar.jad_an("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                                            i19 = 3;
                                            break;
                                        case 2:
                                            i19 = 4;
                                            break;
                                        case 3:
                                            i19 = 2;
                                            break;
                                        default:
                                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Unknown mask mode " + jad_kx + ". Defaulting to Add.");
                                            i19 = 1;
                                            break;
                                    }
                                    break;
                                default:
                                    jad_cpVar.jad_ob();
                                    break;
                            }
                        }
                        jad_cpVar.jad_er();
                        arrayList2.add(new com.jd.ad.sdk.jad_sb.jad_jt(i19, jad_huVar2, jad_dqVar, z13));
                        jad_huVar = null;
                    }
                    jad_jtVar.jad_ob += arrayList2.size();
                    jad_cpVar.jad_dq();
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
                case 11:
                    str2 = str8;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_sb.jad_cp jad_an2 = jad_hu.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_an2 != null) {
                            arrayList3.add(jad_an2);
                        }
                    }
                    jad_cpVar.jad_dq();
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
                case 12:
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        int jad_an3 = jad_cpVar.jad_an(jad_bo);
                        if (jad_an3 == 0) {
                            jad_jwVar = new com.jd.ad.sdk.jad_ra.jad_jw(jad_dq.jad_an(jad_cpVar, jad_jtVar, jad_iv.jad_an));
                        } else if (jad_an3 != 1) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            if (jad_cpVar.jad_jt()) {
                                jad_cp.jad_an jad_anVar2 = jad_bo.jad_an;
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_ra.jad_kx jad_kxVar2 = null;
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(jad_bo.jad_an) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_cp();
                                        com.jd.ad.sdk.jad_ra.jad_an jad_anVar3 = null;
                                        com.jd.ad.sdk.jad_ra.jad_an jad_anVar4 = null;
                                        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar6 = null;
                                        com.jd.ad.sdk.jad_ra.jad_bo jad_boVar7 = null;
                                        while (jad_cpVar.jad_jt()) {
                                            int jad_an4 = jad_cpVar.jad_an(jad_bo.jad_bo);
                                            if (jad_an4 == 0) {
                                                jad_anVar3 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            } else if (jad_an4 != 1) {
                                                if (jad_an4 != 2) {
                                                    str5 = str8;
                                                    if (jad_an4 != 3) {
                                                        jad_cpVar.jad_na();
                                                        jad_cpVar.jad_ob();
                                                    } else {
                                                        jad_boVar7 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                                    }
                                                } else {
                                                    str5 = str8;
                                                    jad_boVar6 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                                }
                                                str8 = str5;
                                            } else {
                                                jad_anVar4 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                            }
                                        }
                                        jad_cpVar.jad_er();
                                        jad_kxVar2 = new com.jd.ad.sdk.jad_ra.jad_kx(jad_anVar3, jad_anVar4, jad_boVar6, jad_boVar7);
                                        str8 = str8;
                                    }
                                }
                                str4 = str8;
                                jad_cpVar.jad_er();
                                if (jad_kxVar2 == null) {
                                    jad_kxVar2 = new com.jd.ad.sdk.jad_ra.jad_kx(null, null, null, null);
                                }
                                jad_kxVar = jad_kxVar2;
                            } else {
                                str4 = str8;
                            }
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_ob();
                            }
                            jad_cpVar.jad_dq();
                            str8 = str4;
                        }
                    }
                    jad_cpVar.jad_er();
                    z11 = true;
                    z10 = false;
                    break;
                case 13:
                    jad_cpVar.jad_bo();
                    ArrayList arrayList4 = new ArrayList();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        while (jad_cpVar.jad_jt()) {
                            int jad_an5 = jad_cpVar.jad_an(jad_cp);
                            if (jad_an5 == 0) {
                                int jad_jw3 = jad_cpVar.jad_jw();
                                if (jad_jw3 == 29) {
                                    jad_cp.jad_an jad_anVar5 = jad_er.jad_an;
                                    jad_anVar = null;
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_er.jad_an) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                com.jd.ad.sdk.jad_sb.jad_an jad_anVar6 = null;
                                                while (true) {
                                                    boolean z14 = false;
                                                    while (jad_cpVar.jad_jt()) {
                                                        int jad_an6 = jad_cpVar.jad_an(jad_er.jad_bo);
                                                        if (jad_an6 != 0) {
                                                            if (jad_an6 != z11) {
                                                                jad_cpVar.jad_na();
                                                                jad_cpVar.jad_ob();
                                                            } else if (z14) {
                                                                jad_anVar6 = new com.jd.ad.sdk.jad_sb.jad_an(jad_dq.jad_an(jad_cpVar, jad_jtVar, z11));
                                                            } else {
                                                                jad_cpVar.jad_ob();
                                                            }
                                                        } else if (jad_cpVar.jad_jw() == 0) {
                                                            z14 = true;
                                                        }
                                                    }
                                                    jad_cpVar.jad_er();
                                                    if (jad_anVar6 != null) {
                                                        jad_anVar = jad_anVar6;
                                                    }
                                                }
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                } else if (jad_jw3 == 25) {
                                    jad_kx jad_kxVar3 = new jad_kx();
                                    while (jad_cpVar.jad_jt()) {
                                        if (jad_cpVar.jad_an(jad_kx.jad_fs) != 0) {
                                            jad_cpVar.jad_na();
                                            jad_cpVar.jad_ob();
                                        } else {
                                            jad_cpVar.jad_bo();
                                            while (jad_cpVar.jad_jt()) {
                                                jad_cpVar.jad_cp();
                                                String str9 = "";
                                                while (jad_cpVar.jad_jt()) {
                                                    int jad_an7 = jad_cpVar.jad_an(jad_kx.jad_jt);
                                                    if (jad_an7 != 0) {
                                                        if (jad_an7 == z11) {
                                                            str9.getClass();
                                                            switch (str9.hashCode()) {
                                                                case 353103893:
                                                                    if (str9.equals("Distance")) {
                                                                        c12 = 0;
                                                                        break;
                                                                    }
                                                                    c12 = 65535;
                                                                    break;
                                                                case 397447147:
                                                                    if (str9.equals("Opacity")) {
                                                                        c12 = 1;
                                                                        break;
                                                                    }
                                                                    c12 = 65535;
                                                                    break;
                                                                case 1041377119:
                                                                    if (str9.equals("Direction")) {
                                                                        c12 = 2;
                                                                        break;
                                                                    }
                                                                    c12 = 65535;
                                                                    break;
                                                                case 1379387491:
                                                                    if (str9.equals("Shadow Color")) {
                                                                        c12 = 3;
                                                                        break;
                                                                    }
                                                                    c12 = 65535;
                                                                    break;
                                                                case 1383710113:
                                                                    if (str9.equals("Softness")) {
                                                                        c12 = 4;
                                                                        break;
                                                                    }
                                                                    c12 = 65535;
                                                                    break;
                                                                default:
                                                                    c12 = 65535;
                                                                    break;
                                                            }
                                                            switch (c12) {
                                                                case 0:
                                                                    jad_kxVar3.jad_dq = jad_dq.jad_an(jad_cpVar, jad_jtVar, z11);
                                                                    break;
                                                                case 1:
                                                                    jad_kxVar3.jad_bo = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                                                                    break;
                                                                case 2:
                                                                    jad_kxVar3.jad_cp = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                                                                    break;
                                                                case 3:
                                                                    jad_kxVar3.jad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                                                                    break;
                                                                case 4:
                                                                    jad_kxVar3.jad_er = jad_dq.jad_an(jad_cpVar, jad_jtVar, z11);
                                                                    break;
                                                            }
                                                        } else {
                                                            jad_cpVar.jad_na();
                                                        }
                                                        jad_cpVar.jad_ob();
                                                    } else {
                                                        str9 = jad_cpVar.jad_ly();
                                                    }
                                                }
                                                jad_cpVar.jad_er();
                                            }
                                            jad_cpVar.jad_dq();
                                        }
                                    }
                                    com.jd.ad.sdk.jad_ra.jad_an jad_anVar7 = jad_kxVar3.jad_an;
                                    if (jad_anVar7 == null || (jad_boVar = jad_kxVar3.jad_bo) == null || (jad_boVar2 = jad_kxVar3.jad_cp) == null || (jad_boVar3 = jad_kxVar3.jad_dq) == null || (jad_boVar4 = jad_kxVar3.jad_er) == null) {
                                        z11 = true;
                                        z10 = false;
                                        jad_jwVar2 = null;
                                    } else {
                                        jad_jwVar2 = new jad_jw(jad_anVar7, jad_boVar, jad_boVar2, jad_boVar3, jad_boVar4);
                                    }
                                }
                            } else if (jad_an5 != z11) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                arrayList4.add(jad_cpVar.jad_ly());
                            }
                            z11 = true;
                            z10 = false;
                        }
                        jad_cpVar.jad_er();
                        z11 = true;
                        z10 = false;
                    }
                    jad_cpVar.jad_dq();
                    jad_jtVar.jad_an("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    z11 = true;
                    z10 = false;
                    break;
                case 14:
                    f11 = (float) jad_cpVar.jad_iv();
                    break;
                case 15:
                    f12 = (float) jad_cpVar.jad_iv();
                    break;
                case 16:
                    i15 = (int) (com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 17:
                    i16 = (int) (com.jd.ad.sdk.jad_xg.jad_hu.jad_an() * jad_cpVar.jad_jw());
                    break;
                case 18:
                    f10 = (float) jad_cpVar.jad_iv();
                    break;
                case 19:
                    f13 = (float) jad_cpVar.jad_iv();
                    break;
                case 20:
                    jad_boVar5 = jad_dq.jad_an(jad_cpVar, jad_jtVar, z10);
                    break;
                case 21:
                    str8 = jad_cpVar.jad_ly();
                    break;
                case 22:
                    z12 = jad_cpVar.jad_hu();
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    str2 = str8;
                    str8 = str2;
                    z11 = true;
                    z10 = false;
                    break;
            }
        }
        String str10 = str8;
        jad_cpVar.jad_er();
        ArrayList arrayList5 = new ArrayList();
        if (f10 > 0.0f) {
            arrayList = arrayList2;
            i10 = i11;
            str = str10;
            arrayList5.add(new com.jd.ad.sdk.jad_yh.jad_an(jad_jtVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f10)));
        } else {
            arrayList = arrayList2;
            i10 = i11;
            str = str10;
        }
        if (f13 <= 0.0f) {
            f13 = jad_jtVar.jad_ly;
        }
        arrayList5.add(new com.jd.ad.sdk.jad_yh.jad_an(jad_jtVar, valueOf, valueOf, null, f10, Float.valueOf(f13)));
        arrayList5.add(new com.jd.ad.sdk.jad_yh.jad_an(jad_jtVar, valueOf2, valueOf2, null, f13, Float.valueOf(Float.MAX_VALUE)));
        if (str7.endsWith(".ai") || "ai".equals(str)) {
            jad_jtVar.jad_an("Convert your Illustrator layers to shape layers.");
        }
        return new com.jd.ad.sdk.jad_tc.jad_er(arrayList3, jad_jtVar, str7, j11, i10, j10, str6, arrayList, jad_lyVar, i12, i13, i14, f11, f12, i15, i16, jad_jwVar, jad_kxVar, arrayList5, i17, jad_boVar5, z12, jad_anVar, jad_jwVar2);
    }
}
