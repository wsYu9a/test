package com.jd.ad.sdk.jad_fs;

import android.app.Application;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_an {
    public final List<jad_dq> jad_an = new ArrayList();
    public jad_dq jad_bo;
    public jad_dq jad_cp;

    public final String jad_an(List<jad_dq> list, int i10) {
        if (i10 < 1 || list.size() < i10) {
            return "";
        }
        int floor = (int) Math.floor(list.size() / i10);
        if (floor > 9) {
            floor = 9;
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 < floor) {
            i11++;
            arrayList.add(list.get((i10 * i11) - 1));
        }
        long j10 = ((jad_dq) arrayList.get(0)).jad_an;
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            jad_dq jad_dqVar = (jad_dq) it.next();
            sb2.append("|");
            sb2.append(jad_dqVar.jad_bo);
            sb2.append(",");
            sb2.append(jad_dqVar.jad_cp);
            sb2.append(",");
            sb2.append(jad_dqVar.jad_an - j10);
            j10 = jad_dqVar.jad_an;
        }
        return sb2.toString();
    }

    public final String jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            Application jad_an = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            jSONObject.putOpt("jbr", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_ly()));
            jSONObject.putOpt("sof", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_bo(jad_an)));
            jSONObject.putOpt("sl", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_an(jad_an)));
            jSONObject.putOpt("em", -1);
            jSONObject.putOpt("af", Integer.valueOf(com.jd.ad.sdk.jad_qd.jad_an.jad_jw()));
            jSONObject.putOpt("hoo", com.jd.ad.sdk.jad_qd.jad_an.jad_mz());
            jSONObject.putOpt("open", com.jd.ad.sdk.jad_qd.jad_an.jad_na());
            jSONObject.putOpt("dbg", com.jd.ad.sdk.jad_qd.jad_an.jad_kx());
            jSONObject.putOpt("clo", "NA");
            jSONObject.putOpt("pac", com.jd.ad.sdk.jad_qd.jad_an.jad_an());
            jSONObject.putOpt("soa", com.jd.ad.sdk.jad_qd.jad_an.jad_jt());
            Logger.d("Cheat AC Params: " + jSONObject);
        } catch (JSONException e10) {
            Logger.d("getCheatParams Exception: " + e10);
        }
        return jSONObject.toString();
    }
}
