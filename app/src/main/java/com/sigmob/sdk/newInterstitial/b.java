package com.sigmob.sdk.newInterstitial;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.czhj.sdk.common.ClientMetadata;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.s;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class b implements s {

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ HashMap f20193a;

        public a(HashMap hashMap) {
            this.f20193a = hashMap;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setOptions(this.f20193a);
            }
        }
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit) {
        return true;
    }

    @Override // com.sigmob.sdk.base.common.s
    public boolean b(BaseAdUnit baseAdUnit) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_close");
        a(baseAdUnit, "ad_close", null, null);
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
        b0.a(str, str2, baseAdUnit, new a(hashMap));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sigmob.sdk.base.common.s
    public boolean a(BaseAdUnit baseAdUnit, String str, int i10) {
        char c10;
        b bVar;
        String str2;
        HashMap<String, String> hashMap;
        String str3;
        String str4;
        String valueOf;
        String str5;
        String str6;
        String str7;
        String str8;
        HashMap<String, String> hashMap2;
        b bVar2 = this;
        try {
            switch (str.hashCode()) {
                case -2050793311:
                    if (str.equals("play_quarter")) {
                        c10 = 11;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1903355519:
                    if (str.equals("show_skip")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1618089666:
                    if (str.equals("video_link")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1361632588:
                    if (str.equals("charge")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1170756021:
                    if (str.equals("video_restart")) {
                        c10 = '\b';
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
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17653f)) {
                        c10 = 16;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        c10 = 14;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17654g)) {
                        c10 = 17;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -236894925:
                    if (str.equals("play_three_quarters")) {
                        c10 = '\r';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c10 = 15;
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
                        c10 = '\f';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 844450526:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17673z)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1110780470:
                    if (str.equals("show_close")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1382290738:
                    if (str.equals("video_pause")) {
                        c10 = '\n';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 1385608094:
                    if (str.equals("video_start")) {
                        c10 = '\t';
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
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "start");
                        str2 = "start";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 1:
                        bVar = bVar2;
                        str2 = PointCategory.VCLOSE;
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 2:
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "ad_hide");
                        str2 = "ad_hide";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 3:
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "charge");
                        str2 = "charge";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 4:
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "show_skip");
                        str2 = "show_skip";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 5:
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "skip");
                        str2 = "skip";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 6:
                        bVar = bVar2;
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "show_close");
                        str2 = "show_close";
                        bVar.a(baseAdUnit, str2, null, null);
                        break;
                    case 7:
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
                        str6 = null;
                        a(baseAdUnit, str3, str6, hashMap);
                        break;
                    case '\b':
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
                        str6 = null;
                        a(baseAdUnit, str3, str6, hashMap);
                        break;
                    case '\t':
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
                        str4 = "video_start";
                        com.sigmob.sdk.base.network.f.b(baseAdUnit, str4, false);
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        valueOf = String.valueOf(baseAdUnit.getVideoCommon().status);
                        str5 = "status";
                        hashMap.put(str5, valueOf);
                        str6 = null;
                        str3 = str4;
                        a(baseAdUnit, str3, str6, hashMap);
                        break;
                    case '\n':
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
                        str4 = "video_pause";
                        com.sigmob.sdk.base.network.f.b(baseAdUnit, str4, true);
                        hashMap = new HashMap<>();
                        hashMap.put("video_time", String.valueOf(baseAdUnit.getVideoCommon().video_time));
                        hashMap.put("begin_time", String.valueOf(baseAdUnit.getVideoCommon().begin_time));
                        hashMap.put(com.umeng.analytics.pro.f.f23909q, String.valueOf(baseAdUnit.getVideoCommon().end_time));
                        hashMap.put("is_first", String.valueOf(baseAdUnit.getVideoCommon().is_first));
                        hashMap.put(com.umeng.ccg.a.f24233j, String.valueOf(baseAdUnit.getVideoCommon().scene));
                        hashMap.put("type", String.valueOf(baseAdUnit.getVideoCommon().type));
                        hashMap.put("is_auto_play", String.valueOf(baseAdUnit.getVideoCommon().is_auto_play));
                        valueOf = String.valueOf(baseAdUnit.getVideoCommon().status);
                        str5 = "status";
                        hashMap.put(str5, valueOf);
                        str6 = null;
                        str3 = str4;
                        a(baseAdUnit, str3, str6, hashMap);
                        break;
                    case 11:
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_quarter");
                        str7 = "play";
                        str8 = "0.25";
                        hashMap2 = null;
                        bVar2 = this;
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
                        break;
                    case '\f':
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_two_quarters");
                        str7 = "play";
                        str8 = "0.50";
                        hashMap2 = null;
                        bVar2 = this;
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
                        break;
                    case '\r':
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "play_three_quarters");
                        str7 = "play";
                        str8 = "0.75";
                        hashMap2 = null;
                        bVar2 = this;
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
                        break;
                    case 14:
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
                        str6 = null;
                        a(baseAdUnit, str3, str6, hashMap);
                        break;
                    case 15:
                        String str9 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                        SigMacroCommon macroCommon6 = baseAdUnit.getMacroCommon();
                        if (macroCommon6 instanceof SigMacroCommon) {
                            macroCommon6.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                            macroCommon6.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                            macroCommon6.addMarcoKey(SigMacroCommon._FINALCLICK_, str9);
                        }
                        com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
                        hashMap2 = new HashMap<>();
                        hashMap2.put("click_area", baseAdUnit.getClickCommon().click_area);
                        hashMap2.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                        hashMap2.put(ExposeManager.UtArgsNames.templateId, String.valueOf(baseAdUnit.getTemplateId()));
                        hashMap2.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        hashMap2.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                        hashMap2.put("is_final_click", str9);
                        hashMap2.put("coordinate", macroCommon6.getCoordinate());
                        str7 = baseAdUnit.getClickCommon().click_scene;
                        str8 = "click";
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
                        break;
                    case 16:
                        str7 = PointCategory.FOURELEMENTS;
                        str8 = "show";
                        hashMap2 = null;
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
                        break;
                    case 17:
                        str7 = PointCategory.FOURELEMENTS;
                        str8 = "close";
                        hashMap2 = null;
                        bVar2.a(baseAdUnit, str7, str8, hashMap2);
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
