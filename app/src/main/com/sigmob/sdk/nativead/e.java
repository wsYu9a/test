package com.sigmob.sdk.nativead;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class e implements com.sigmob.sdk.base.common.s {

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ HashMap f19950a;

        public a(HashMap hashMap) {
            this.f19950a = hashMap;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setOptions(this.f19950a);
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean b(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, int i10, int i11) {
        return false;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, boolean z10, int i10) {
        return false;
    }

    public final void a(BaseAdUnit baseAdUnit, String str, String str2, HashMap<String, String> hashMap) {
        com.sigmob.sdk.base.common.b0.a(str, str2, baseAdUnit, new a(hashMap));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, String str, int i10) {
        char c10;
        e eVar;
        String str2;
        HashMap<String, String> hashMap;
        String str3;
        String str4;
        String str5;
        String str6;
        HashMap<String, String> hashMap2;
        String str7;
        String valueOf;
        String str8;
        String str9;
        e eVar2 = this;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals("play_quarter")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1152604194:
                    if (str.equals("ad_hide")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1152277095:
                    if (str.equals("ad_show")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17653f)) {
                        c10 = '\f';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c10 = '\n';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17654g)) {
                        c10 = '\r';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -236894925:
                    if (str.equals("play_three_quarters")) {
                        c10 = '\t';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c10 = 11;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 109757538:
                    if (str.equals("start")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 471706373:
                    if (str.equals("play_two_quarters")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
        } catch (Throwable unused) {
        }
        try {
            try {
                switch (c10) {
                    case 0:
                        eVar = eVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "start");
                        str2 = "start";
                        eVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 1:
                        eVar = eVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_show");
                        str2 = "ad_show";
                        eVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 2:
                        eVar = eVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_hide");
                        str2 = "ad_hide";
                        eVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 3:
                        SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                        if (macroCommon instanceof SigMacroCommon) {
                            macroCommon.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.f.b(baseAdUnit, "video_link", true);
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        str3 = "video_link";
                        str4 = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        break;
                    case 4:
                        SigMacroCommon macroCommon2 = baseAdUnit.getMacroCommon();
                        if (macroCommon2 instanceof SigMacroCommon) {
                            macroCommon2.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon2.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon2.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon2.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon2.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon2.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon2.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "video_restart");
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        str3 = "video_restart";
                        str4 = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        break;
                    case 5:
                        SigMacroCommon macroCommon3 = baseAdUnit.getMacroCommon();
                        if (macroCommon3 instanceof SigMacroCommon) {
                            macroCommon3.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon3.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon3.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon3.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon3.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon3.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon3.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "video_start");
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap3.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap3.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap3.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap3.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap3.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap3.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap3.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        str4 = null;
                        str3 = "video_start";
                        hashMap = hashMap3;
                        a(baseAdUnit, str3, str4, hashMap);
                        break;
                    case 6:
                        SigMacroCommon macroCommon4 = baseAdUnit.getMacroCommon();
                        if (macroCommon4 instanceof SigMacroCommon) {
                            macroCommon4.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon4.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon4.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon4.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon4.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon4.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon4.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.f.b(baseAdUnit, "video_pause", true);
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        str4 = null;
                        str3 = "video_pause";
                        a(baseAdUnit, str3, str4, hashMap);
                        break;
                    case 7:
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_quarter");
                        str5 = "play";
                        str6 = "0.25";
                        hashMap2 = null;
                        eVar2 = this;
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                        break;
                    case '\b':
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_two_quarters");
                        str5 = "play";
                        str6 = "0.50";
                        hashMap2 = null;
                        eVar2 = this;
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                        break;
                    case '\t':
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_three_quarters");
                        str5 = "play";
                        str6 = "0.75";
                        hashMap2 = null;
                        eVar2 = this;
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                        break;
                    case '\n':
                        SigMacroCommon macroCommon5 = baseAdUnit.getMacroCommon();
                        if (macroCommon5 instanceof SigMacroCommon) {
                            macroCommon5.addMarcoKey(SigMacroCommon._VIDEOTIME_, String.valueOf(baseAdUnit.getVideoCommon().video_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._BEGINTIME_, String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._ENDTIME_, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                            macroCommon5.addMarcoKey(SigMacroCommon._PLAYFIRSTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_first));
                            macroCommon5.addMarcoKey(SigMacroCommon._PLAYLASTFRAME_, String.valueOf(baseAdUnit.getVideoCommon().is_last));
                            macroCommon5.addMarcoKey(SigMacroCommon._SCENE_, String.valueOf(baseAdUnit.getVideoCommon().scene));
                            macroCommon5.addMarcoKey(SigMacroCommon._TYPE_, String.valueOf(baseAdUnit.getVideoCommon().type));
                            macroCommon5.addMarcoKey(SigMacroCommon._BEHAVIOR_, String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                            macroCommon5.addMarcoKey(SigMacroCommon._STATUS_, String.valueOf(baseAdUnit.getVideoCommon().status));
                        }
                        com.sigmob.sdk.base.network.f.b(baseAdUnit, "complete", true);
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        hashMap.put("status", String.valueOf(baseAdUnit.getVideoCommon().status));
                        str3 = "complete";
                        str4 = null;
                        a(baseAdUnit, str3, str4, hashMap);
                        break;
                    case 11:
                        String str10 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                        SigMacroCommon macroCommon6 = baseAdUnit.getMacroCommon();
                        if (macroCommon6 instanceof SigMacroCommon) {
                            macroCommon6.addMarcoKey("_SLD_", baseAdUnit.getClickCommon().sld);
                            macroCommon6.addMarcoKey("_AX_", baseAdUnit.getClickCommon().adarea_x);
                            macroCommon6.addMarcoKey("_AY_", baseAdUnit.getClickCommon().adarea_y);
                            macroCommon6.addMarcoKey("_AW_", baseAdUnit.getClickCommon().adarea_w);
                            macroCommon6.addMarcoKey("_AH_", baseAdUnit.getClickCommon().adarea_h);
                            if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                                macroCommon6.updateClickMarco("-999", "-999", "-999", "-999");
                                macroCommon6.addMarcoKey("_TURNX_", baseAdUnit.getClickCommon().turn_x);
                                macroCommon6.addMarcoKey("_TURNY_", baseAdUnit.getClickCommon().turn_y);
                                macroCommon6.addMarcoKey("_TURNZ_", baseAdUnit.getClickCommon().turn_z);
                                macroCommon6.addMarcoKey("_TURNTIME_", baseAdUnit.getClickCommon().turn_time);
                                str8 = "_CPTIDS_";
                                str9 = String.valueOf(baseAdUnit.getClickCommon().widget_id);
                            } else if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                                macroCommon6.updateClickMarco("-999", "-999", "-999", "-999");
                                macroCommon6.addMarcoKey("_CPTIDS_", String.valueOf(baseAdUnit.getClickCommon().widget_id));
                                macroCommon6.addMarcoKey("_XMAXACC_", baseAdUnit.getClickCommon().x_max_acc);
                                macroCommon6.addMarcoKey("_YMAXACC_", baseAdUnit.getClickCommon().y_max_acc);
                                str8 = "_ZMAXACC_";
                                str9 = baseAdUnit.getClickCommon().z_max_acc;
                            } else {
                                macroCommon6.updateClickMarco(baseAdUnit.getClickCommon().down, baseAdUnit.getClickCommon().up);
                                macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                                macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                                macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                                macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str10);
                            }
                            macroCommon6.addMarcoKey(str8, str9);
                            macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                            macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str10);
                        }
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
                        hashMap2 = new HashMap<>();
                        hashMap2.put(ExposeManager.UtArgsNames.templateId, baseAdUnit.getClickCommon().template_id);
                        hashMap2.put("sld", baseAdUnit.getClickCommon().sld);
                        hashMap2.put("adarea_x", baseAdUnit.getClickCommon().adarea_x);
                        hashMap2.put("adarea_y", baseAdUnit.getClickCommon().adarea_y);
                        hashMap2.put("adarea_w", baseAdUnit.getClickCommon().adarea_w);
                        hashMap2.put("adarea_h", baseAdUnit.getClickCommon().adarea_h);
                        if (!"5".equals(baseAdUnit.getClickCommon().sld)) {
                            if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                                hashMap2.put("x_max_acc", baseAdUnit.getClickCommon().x_max_acc);
                                hashMap2.put("y_max_acc", baseAdUnit.getClickCommon().y_max_acc);
                                hashMap2.put("z_max_acc", baseAdUnit.getClickCommon().z_max_acc);
                                str7 = "cpt_id";
                                valueOf = String.valueOf(baseAdUnit.getClickCommon().widget_id);
                            }
                            hashMap2.put("click_area", baseAdUnit.getClickCommon().click_area);
                            hashMap2.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                            hashMap2.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                            hashMap2.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                            hashMap2.put("is_final_click", str10);
                            hashMap2.put("coordinate", macroCommon6.getCoordinate());
                            str5 = baseAdUnit.getClickCommon().click_scene;
                            str6 = "click";
                            eVar2.a(baseAdUnit, str5, str6, hashMap2);
                            break;
                        } else {
                            hashMap2.put("turn_x", baseAdUnit.getClickCommon().turn_x);
                            hashMap2.put("turn_y", baseAdUnit.getClickCommon().turn_y);
                            hashMap2.put("turn_z", baseAdUnit.getClickCommon().turn_z);
                            hashMap2.put("cpt_id", String.valueOf(baseAdUnit.getClickCommon().widget_id));
                            str7 = "turn_time";
                            valueOf = baseAdUnit.getClickCommon().turn_time;
                        }
                        hashMap2.put(str7, valueOf);
                        hashMap2.put("click_area", baseAdUnit.getClickCommon().click_area);
                        hashMap2.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                        hashMap2.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        hashMap2.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                        hashMap2.put("is_final_click", str10);
                        hashMap2.put("coordinate", macroCommon6.getCoordinate());
                        str5 = baseAdUnit.getClickCommon().click_scene;
                        str6 = "click";
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                    case '\f':
                        str5 = PointCategory.FOURELEMENTS;
                        str6 = "show";
                        hashMap2 = null;
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                        break;
                    case '\r':
                        str5 = PointCategory.FOURELEMENTS;
                        str6 = "close";
                        hashMap2 = null;
                        eVar2.a(baseAdUnit, str5, str6, hashMap2);
                        break;
                }
                return true;
            } catch (Throwable unused2) {
                return true;
            }
        } catch (Throwable unused3) {
            return true;
        }
    }
}
