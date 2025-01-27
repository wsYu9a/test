package com.jd.ad.sdk.jad_ob;

import android.app.Application;
import android.util.Log;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.multi.BuildConfig;
import com.umeng.analytics.pro.bt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_cp {
    public static void jad_an(jad_ly.jad_an jad_anVar, String str) {
        byte[] bArr;
        String jad_an = com.jd.ad.sdk.jad_fq.jad_fs.jad_an("aHR0cHM6Ly9qYW5hcGkuamQuY29tL2Fuc2RrL3YxL2luaXREYXRh");
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_er.jad_cp());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        jad_fsVar.jad_bo("Encryption", "AES");
        jad_ly.jad_bo jad_an2 = com.jd.ad.sdk.jad_zm.jad_bo.jad_an();
        jad_an2.jad_er = jad_an;
        jad_an2.jad_bo = jad_fsVar;
        Application jad_an3 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aId", JADYunSdk.getAppId());
            jSONObject.put("pId", com.jd.ad.sdk.jad_qd.jad_jt.jad_an(jad_an3));
            jSONObject.put("cat", jad_an.jad_an());
            jSONObject.put(bt.aO, System.currentTimeMillis());
            jSONObject.put("rid", str);
            jSONObject.put("oid", com.jd.ad.sdk.jad_qd.jad_jt.jad_bo());
            jSONObject.put("di", com.jd.ad.sdk.jad_qd.jad_jt.jad_an());
            jSONObject.put("plat", "android");
            jSONObject.put("osv", com.jd.ad.sdk.jad_qd.jad_er.jad_bo());
            jSONObject.put("sdkv", BuildConfig.VERSION_NAME);
        } catch (JSONException e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_JSON_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 2, jad_anVar2.jad_an, jad_anVar2.jad_an(e10.getMessage()), 0);
        }
        Logger.d("AN API Request: " + jSONObject);
        try {
            bArr = com.jd.ad.sdk.jad_fq.jad_an.jad_bo(jSONObject.toString());
        } catch (Exception e11) {
            Logger.d(Log.getStackTraceString(e11));
            bArr = new byte[0];
        }
        jad_an2.jad_fs = new com.jd.ad.sdk.jad_zm.jad_er(bArr);
        jad_an2.jad_hu = true;
        jad_an2.jad_jt = jad_anVar;
        jad_an2.jad_an(com.jd.ad.sdk.jad_ep.jad_bo.jad_cp);
    }
}
