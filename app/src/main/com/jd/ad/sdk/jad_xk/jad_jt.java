package com.jd.ad.sdk.jad_xk;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_jt {
    public static com.jd.ad.sdk.jad_zm.jad_fs jad_an() {
        com.jd.ad.sdk.jad_zm.jad_fs jad_fsVar = new com.jd.ad.sdk.jad_zm.jad_fs();
        jad_fsVar.jad_bo("User-Agent", com.jd.ad.sdk.jad_qd.jad_er.jad_cp());
        jad_fsVar.jad_bo("Content-Type", "application/stream");
        return jad_fsVar;
    }

    public static byte[] jad_an(ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<jad_dq> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            JSONObject jad_an = it.next().jad_an();
            jad_an.put("rts", String.valueOf(System.currentTimeMillis()));
            jSONArray.put(jad_an);
        }
        jSONObject.put("param", jSONArray);
        Logger.d("XlogReport  data: " + jSONObject);
        String ja2 = ANEProxy.ja(jSONObject.toString().replace("\\n", " ").replace("\\t", " ").replace("\\r", " "));
        if (TextUtils.isEmpty(ja2)) {
            return null;
        }
        return ja2.getBytes(StandardCharsets.UTF_8);
    }
}
