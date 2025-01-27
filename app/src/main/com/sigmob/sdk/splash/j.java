package com.sigmob.sdk.splash;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.common.s;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.SigMacroCommon;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.mta.PointEntitySigmob;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class j implements s {

    public class a implements b0.g {

        /* renamed from: a */
        public final /* synthetic */ HashMap f20386a;

        public a(HashMap hashMap) {
            this.f20386a = hashMap;
        }

        @Override // com.sigmob.sdk.base.common.b0.g
        public void a(Object obj) {
            if (obj instanceof PointEntitySigmob) {
                ((PointEntitySigmob) obj).setOptions(this.f20386a);
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
        String str2;
        char c10;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        try {
            str2 = "skip";
            switch (str.hashCode()) {
                case -981662273:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17653f)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -381416586:
                    if (str.equals(com.sigmob.sdk.base.common.a.f17654g)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3532159:
                    if (str.equals("skip")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 94750088:
                    if (str.equals("click")) {
                        c10 = 2;
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
                default:
                    c10 = 65535;
                    break;
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
        if (c10 == 0) {
            com.sigmob.sdk.base.network.f.a(baseAdUnit, "start");
            str2 = "start";
        } else {
            if (c10 != 1) {
                if (c10 != 2) {
                    if (c10 == 3) {
                        str7 = "show";
                    } else if (c10 == 4) {
                        str7 = "close";
                    }
                    a(baseAdUnit, PointCategory.FOURELEMENTS, str7, null);
                } else {
                    String str8 = baseAdUnit.getClickCommon().is_final_click ? "1" : "0";
                    SigMacroCommon macroCommon = baseAdUnit.getMacroCommon();
                    if (macroCommon instanceof SigMacroCommon) {
                        macroCommon.addMarcoKey("_SLD_", baseAdUnit.getClickCommon().sld);
                        macroCommon.addMarcoKey("_AX_", baseAdUnit.getClickCommon().adarea_x);
                        macroCommon.addMarcoKey("_AY_", baseAdUnit.getClickCommon().adarea_y);
                        macroCommon.addMarcoKey("_AW_", baseAdUnit.getClickCommon().adarea_w);
                        macroCommon.addMarcoKey("_AH_", baseAdUnit.getClickCommon().adarea_h);
                        if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                            macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                            macroCommon.addMarcoKey("_TURNX_", baseAdUnit.getClickCommon().turn_x);
                            macroCommon.addMarcoKey("_TURNY_", baseAdUnit.getClickCommon().turn_y);
                            macroCommon.addMarcoKey("_TURNZ_", baseAdUnit.getClickCommon().turn_z);
                            str5 = "_TURNTIME_";
                            str6 = baseAdUnit.getClickCommon().turn_time;
                        } else if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                            macroCommon.updateClickMarco("-999", "-999", "-999", "-999");
                            macroCommon.addMarcoKey("_XMAXACC_", baseAdUnit.getClickCommon().x_max_acc);
                            macroCommon.addMarcoKey("_YMAXACC_", baseAdUnit.getClickCommon().y_max_acc);
                            str5 = "_ZMAXACC_";
                            str6 = baseAdUnit.getClickCommon().z_max_acc;
                        } else {
                            macroCommon.updateClickMarco(baseAdUnit.getClickCommon().down, baseAdUnit.getClickCommon().up);
                            macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                            macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                            macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                            macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str8);
                        }
                        macroCommon.addMarcoKey(str5, str6);
                        macroCommon.addMarcoKey(SigMacroCommon._TEMPLATE_, String.valueOf(baseAdUnit.getTemplateId()));
                        macroCommon.addMarcoKey(SigMacroCommon._CLICKAREA_, String.valueOf(baseAdUnit.getClickCommon().click_area));
                        macroCommon.addMarcoKey(SigMacroCommon._CLICKSCENE_, String.valueOf(baseAdUnit.getClickCommon().click_scene));
                        macroCommon.addMarcoKey(SigMacroCommon._FINALCLICK_, str8);
                    }
                    com.sigmob.sdk.base.network.f.a(baseAdUnit, "click");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put(ExposeManager.UtArgsNames.templateId, baseAdUnit.getClickCommon().template_id);
                    hashMap.put("sld", baseAdUnit.getClickCommon().sld);
                    hashMap.put("adarea_x", baseAdUnit.getClickCommon().adarea_x);
                    hashMap.put("adarea_y", baseAdUnit.getClickCommon().adarea_y);
                    hashMap.put("adarea_w", baseAdUnit.getClickCommon().adarea_w);
                    hashMap.put("adarea_h", baseAdUnit.getClickCommon().adarea_h);
                    if ("5".equals(baseAdUnit.getClickCommon().sld)) {
                        hashMap.put("turn_x", baseAdUnit.getClickCommon().turn_x);
                        hashMap.put("turn_y", baseAdUnit.getClickCommon().turn_y);
                        hashMap.put("turn_z", baseAdUnit.getClickCommon().turn_z);
                        str3 = "turn_time";
                        str4 = baseAdUnit.getClickCommon().turn_time;
                    } else {
                        if ("2".equals(baseAdUnit.getClickCommon().sld)) {
                            hashMap.put("x_max_acc", baseAdUnit.getClickCommon().x_max_acc);
                            hashMap.put("y_max_acc", baseAdUnit.getClickCommon().y_max_acc);
                            str3 = "z_max_acc";
                            str4 = baseAdUnit.getClickCommon().z_max_acc;
                        }
                        hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                        hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                        hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                        hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                        hashMap.put("is_final_click", str8);
                        hashMap.put("coordinate", macroCommon.getCoordinate());
                        a(baseAdUnit, baseAdUnit.getClickCommon().click_scene, "click", hashMap);
                    }
                    hashMap.put(str3, str4);
                    hashMap.put("click_area", baseAdUnit.getClickCommon().click_area);
                    hashMap.put("click_scene", baseAdUnit.getClickCommon().click_scene);
                    hashMap.put("cwidth", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealWidthDip()));
                    hashMap.put("cheight", String.valueOf(ClientMetadata.getInstance().getDeviceScreenRealHeightDip()));
                    hashMap.put("is_final_click", str8);
                    hashMap.put("coordinate", macroCommon.getCoordinate());
                    a(baseAdUnit, baseAdUnit.getClickCommon().click_scene, "click", hashMap);
                }
                return true;
            }
            com.sigmob.sdk.base.network.f.a(baseAdUnit, "skip");
        }
        a(baseAdUnit, str2, null, null);
        return true;
    }
}
