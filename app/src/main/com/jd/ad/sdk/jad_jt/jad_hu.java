package com.jd.ad.sdk.jad_jt;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c7.g;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import com.martian.ads.ad.AdConfig;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bd;
import h3.e;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_hu {
    public static JSONArray jad_an(JADSlot jADSlot) {
        JSONArray jad_bo;
        JSONArray jSONArray = new JSONArray();
        Object[] objArr = new String[0];
        if (!TextUtils.isEmpty(jADSlot.getSlotID())) {
            objArr = jADSlot.getSlotID().split(",");
        }
        for (Object obj : objArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", UUIDUtils.uuid());
            jSONObject.put("tagid", obj);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.WIDTH, jADSlot.getAdImageWidth());
            jSONObject2.put("h", jADSlot.getAdImageHeight());
            jSONObject2.put(g.f1744b, 1);
            jSONObject2.put("imgnum", 1);
            jSONObject.put(AdConfig.AdType.NATIVE, jSONObject2);
            jSONObject.put("isdeeplink", true);
            jSONObject.put("secure", 1);
            if (jADSlot.getDynamicRenderTemplateHelper() != null && (jad_bo = jADSlot.getDynamicRenderTemplateHelper().jad_bo()) != null && jad_bo.length() > 0) {
                jSONObject.put("template_list", jADSlot.getDynamicRenderTemplateHelper().jad_bo());
            }
            jSONObject.put("render_form", jADSlot.isFromNativeAd() ? 1 : 0);
            jSONObject.put("display_scene", jADSlot.getDisplayScene());
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static byte[] jad_bo(@NonNull JADSlot jADSlot) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", jADSlot.getRequestId());
            jSONObject.put("version", "4.0");
            jSONObject.put(bd.f23523c, jad_an(jADSlot));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", JADYunSdk.getAppId());
            jSONObject2.put("bundle", com.jd.ad.sdk.jad_qd.jad_jt.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject2.put("sdkversion", BuildConfig.VERSION_NAME);
            jSONObject.put(PointCategory.APP, jSONObject2);
            jSONObject.put(e.f26411p, jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an()));
            jSONObject.put("anti", jad_an());
        } catch (Exception e10) {
            String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
            int i10 = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_JSON_ERROR.jad_an;
            String slotID = jADSlot != null ? jADSlot.getSlotID() : "";
            int adType = jADSlot != null ? jADSlot.getAdType() : 0;
            String jad_an = com.jd.ad.sdk.jad_wj.jad_an.GW_REQUEST_OTHER_ERROR.jad_an(e10.getMessage());
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.put(jSONObject3, ExposeManager.UtArgsNames.pid, slotID);
            JsonUtils.put(jSONObject3, "adt", Integer.valueOf(adType));
            JsonUtils.put(jSONObject3, "error", jad_an);
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(requestId, 3, i10, jSONObject3.toString(), jADSlot != null ? jADSlot.getSen() : 0);
        }
        Logger.d("Gateway API Request: " + jSONObject);
        String jSONObject4 = jSONObject.toString();
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        if (jad_an2 == null || !"1".equals(jad_an2.jad_bo)) {
            jSONObject4 = ANEProxy.jd(jSONObject.toString());
            if (TextUtils.isEmpty(jSONObject4)) {
                return null;
            }
        }
        return jSONObject4.getBytes(StandardCharsets.UTF_8);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:18:0x005f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011e A[Catch: Exception -> 0x0126, TryCatch #15 {Exception -> 0x0126, blocks: (B:33:0x0117, B:100:0x011e, B:102:0x0128, B:104:0x0130, B:105:0x0135), top: B:32:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0130 A[Catch: Exception -> 0x0126, TryCatch #15 {Exception -> 0x0126, blocks: (B:33:0x0117, B:100:0x011e, B:102:0x0128, B:104:0x0130, B:105:0x0135), top: B:32:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0135 A[Catch: Exception -> 0x0126, TRY_LEAVE, TryCatch #15 {Exception -> 0x0126, blocks: (B:33:0x0117, B:100:0x011e, B:102:0x0128, B:104:0x0130, B:105:0x0135), top: B:32:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x00ca A[Catch: Exception -> 0x00d2, TryCatch #7 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:112:0x00ca, B:114:0x00d4, B:116:0x00dc, B:117:0x00e1, B:125:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00dc A[Catch: Exception -> 0x00d2, TryCatch #7 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:112:0x00ca, B:114:0x00d4, B:116:0x00dc, B:117:0x00e1, B:125:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00e1 A[Catch: Exception -> 0x00d2, TryCatch #7 {Exception -> 0x00d2, blocks: (B:27:0x00c3, B:112:0x00ca, B:114:0x00d4, B:116:0x00dc, B:117:0x00e1, B:125:0x00eb), top: B:26:0x00c3 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0092 A[Catch: Exception -> 0x009a, TryCatch #14 {Exception -> 0x009a, blocks: (B:20:0x008b, B:129:0x0092, B:131:0x009c, B:133:0x00a4, B:134:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00a4 A[Catch: Exception -> 0x009a, TryCatch #14 {Exception -> 0x009a, blocks: (B:20:0x008b, B:129:0x0092, B:131:0x009c, B:133:0x00a4, B:134:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00a9 A[Catch: Exception -> 0x009a, TRY_LEAVE, TryCatch #14 {Exception -> 0x009a, blocks: (B:20:0x008b, B:129:0x0092, B:131:0x009c, B:133:0x00a4, B:134:0x00a9), top: B:19:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0069 A[Catch: Exception -> 0x005f, TryCatch #10 {Exception -> 0x005f, blocks: (B:12:0x0050, B:142:0x0057, B:144:0x0061, B:146:0x0069, B:147:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x006e A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #10 {Exception -> 0x005f, blocks: (B:12:0x0050, B:142:0x0057, B:144:0x0061, B:146:0x0069, B:147:0x006e), top: B:11:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0091 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x011d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0153 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x027f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0280 A[Catch: Exception -> 0x029f, TryCatch #9 {Exception -> 0x029f, blocks: (B:51:0x0279, B:60:0x0280, B:63:0x0289, B:65:0x0291, B:66:0x0296), top: B:50:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0291 A[Catch: Exception -> 0x029f, TryCatch #9 {Exception -> 0x029f, blocks: (B:51:0x0279, B:60:0x0280, B:63:0x0289, B:65:0x0291, B:66:0x0296), top: B:50:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0296 A[Catch: Exception -> 0x029f, TRY_LEAVE, TryCatch #9 {Exception -> 0x029f, blocks: (B:51:0x0279, B:60:0x0280, B:63:0x0289, B:65:0x0291, B:66:0x0296), top: B:50:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e6 A[Catch: Exception -> 0x01ee, TryCatch #0 {Exception -> 0x01ee, blocks: (B:45:0x01df, B:68:0x01e6, B:70:0x01f0, B:72:0x01f8, B:73:0x01fd, B:75:0x0205, B:76:0x020b), top: B:44:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f8 A[Catch: Exception -> 0x01ee, TryCatch #0 {Exception -> 0x01ee, blocks: (B:45:0x01df, B:68:0x01e6, B:70:0x01f0, B:72:0x01f8, B:73:0x01fd, B:75:0x0205, B:76:0x020b), top: B:44:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fd A[Catch: Exception -> 0x01ee, TryCatch #0 {Exception -> 0x01ee, blocks: (B:45:0x01df, B:68:0x01e6, B:70:0x01f0, B:72:0x01f8, B:73:0x01fd, B:75:0x0205, B:76:0x020b), top: B:44:0x01df }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0154 A[Catch: Exception -> 0x015c, TryCatch #12 {Exception -> 0x015c, blocks: (B:39:0x014d, B:86:0x0154, B:88:0x015e, B:90:0x0166, B:91:0x016b), top: B:38:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0166 A[Catch: Exception -> 0x015c, TryCatch #12 {Exception -> 0x015c, blocks: (B:39:0x014d, B:86:0x0154, B:88:0x015e, B:90:0x0166, B:91:0x016b), top: B:38:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016b A[Catch: Exception -> 0x015c, TRY_LEAVE, TryCatch #12 {Exception -> 0x015c, blocks: (B:39:0x014d, B:86:0x0154, B:88:0x015e, B:90:0x0166, B:91:0x016b), top: B:38:0x014d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String jad_an() {
        /*
            Method dump skipped, instructions count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an():java.lang.String");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:96:0x03ef
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1179)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0419 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0453 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0454 A[Catch: Exception -> 0x0465, TryCatch #14 {Exception -> 0x0465, blocks: (B:104:0x044d, B:110:0x0454, B:114:0x045f), top: B:103:0x044d }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x041a A[Catch: NumberFormatException -> 0x0422, TryCatch #19 {NumberFormatException -> 0x0422, blocks: (B:98:0x0413, B:119:0x041a, B:121:0x0424, B:123:0x042c, B:124:0x0431), top: B:97:0x0413 }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x042c A[Catch: NumberFormatException -> 0x0422, TryCatch #19 {NumberFormatException -> 0x0422, blocks: (B:98:0x0413, B:119:0x041a, B:121:0x0424, B:123:0x042c, B:124:0x0431), top: B:97:0x0413 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0431 A[Catch: NumberFormatException -> 0x0422, TRY_LEAVE, TryCatch #19 {NumberFormatException -> 0x0422, blocks: (B:98:0x0413, B:119:0x041a, B:121:0x0424, B:123:0x042c, B:124:0x0431), top: B:97:0x0413 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03e7 A[Catch: Exception -> 0x03ef, TryCatch #0 {Exception -> 0x03ef, blocks: (B:90:0x03e0, B:131:0x03e7, B:133:0x03f1, B:135:0x03f9, B:136:0x03fe), top: B:89:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03f9 A[Catch: Exception -> 0x03ef, TryCatch #0 {Exception -> 0x03ef, blocks: (B:90:0x03e0, B:131:0x03e7, B:133:0x03f1, B:135:0x03f9, B:136:0x03fe), top: B:89:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03fe A[Catch: Exception -> 0x03ef, TRY_LEAVE, TryCatch #0 {Exception -> 0x03ef, blocks: (B:90:0x03e0, B:131:0x03e7, B:133:0x03f1, B:135:0x03f9, B:136:0x03fe), top: B:89:0x03e0 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x039a A[Catch: Exception -> 0x03d8, TryCatch #20 {Exception -> 0x03d8, blocks: (B:84:0x0393, B:143:0x039a, B:146:0x03a3, B:148:0x03ad), top: B:83:0x0393 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03ad A[Catch: Exception -> 0x03d8, TRY_LEAVE, TryCatch #20 {Exception -> 0x03d8, blocks: (B:84:0x0393, B:143:0x039a, B:146:0x03a3, B:148:0x03ad), top: B:83:0x0393 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0358 A[Catch: Exception -> 0x0386, TRY_LEAVE, TryCatch #26 {Exception -> 0x0386, blocks: (B:78:0x0351, B:151:0x0358, B:157:0x0381, B:161:0x037c, B:155:0x0363), top: B:77:0x0351, inners: #23 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0326 A[Catch: Exception -> 0x032e, TryCatch #1 {Exception -> 0x032e, blocks: (B:70:0x031f, B:163:0x0326, B:165:0x0330, B:167:0x0338, B:168:0x033f), top: B:69:0x031f }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0338 A[Catch: Exception -> 0x032e, TryCatch #1 {Exception -> 0x032e, blocks: (B:70:0x031f, B:163:0x0326, B:165:0x0330, B:167:0x0338, B:168:0x033f), top: B:69:0x031f }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033f A[Catch: Exception -> 0x032e, TRY_LEAVE, TryCatch #1 {Exception -> 0x032e, blocks: (B:70:0x031f, B:163:0x0326, B:165:0x0330, B:167:0x0338, B:168:0x033f), top: B:69:0x031f }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02e5 A[Catch: Exception -> 0x02e3, TryCatch #15 {Exception -> 0x02e3, blocks: (B:65:0x02db, B:175:0x02e5, B:177:0x02ed), top: B:64:0x02db }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02c3 A[Catch: Exception -> 0x02c1, TryCatch #30 {Exception -> 0x02c1, blocks: (B:60:0x02b9, B:203:0x02c3, B:205:0x02cb, B:206:0x02d2), top: B:59:0x02b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0282 A[Catch: Exception -> 0x02b3, TryCatch #5 {Exception -> 0x02b3, blocks: (B:52:0x0279, B:213:0x0282, B:215:0x028a, B:217:0x0291), top: B:51:0x0279 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x025d A[Catch: Exception -> 0x025b, TryCatch #11 {Exception -> 0x025b, blocks: (B:47:0x0253, B:226:0x025d, B:228:0x0265, B:229:0x026a), top: B:46:0x0253 }] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x023d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0209 A[Catch: Exception -> 0x0222, TryCatch #16 {Exception -> 0x0222, blocks: (B:38:0x0202, B:242:0x0209, B:244:0x0213, B:246:0x021b, B:247:0x0224), top: B:37:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x021b A[Catch: Exception -> 0x0222, TryCatch #16 {Exception -> 0x0222, blocks: (B:38:0x0202, B:242:0x0209, B:244:0x0213, B:246:0x021b, B:247:0x0224), top: B:37:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0224 A[Catch: Exception -> 0x0222, TRY_LEAVE, TryCatch #16 {Exception -> 0x0222, blocks: (B:38:0x0202, B:242:0x0209, B:244:0x0213, B:246:0x021b, B:247:0x0224), top: B:37:0x0202 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x01e6 A[Catch: Exception -> 0x01fa, TryCatch #24 {Exception -> 0x01fa, blocks: (B:32:0x01dd, B:254:0x01e6, B:257:0x01f1), top: B:31:0x01dd }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0208 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0325 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0357 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0399 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x03e6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject jad_an(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 1156
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jt.jad_hu.jad_an(android.content.Context):org.json.JSONObject");
    }

    public static String jad_an(com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar, String str) {
        if (jad_cpVar == null) {
            return "";
        }
        com.jd.ad.sdk.jad_yl.jad_an jad_an = com.jd.ad.sdk.jad_ob.jad_jt.jad_an(str);
        if (jad_an != null && jad_an.jad_cp == 4) {
            String str2 = jad_cpVar.jad_an.jad_bo;
            Logger.w("The url is currently in a non-online environment ", new Object[0]);
            return str2;
        }
        Logger.i("The url is currently in a online environment ", new Object[0]);
        return jad_cpVar.jad_an.jad_an;
    }
}
