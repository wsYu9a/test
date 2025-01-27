package com.jd.ad.sdk.bl.dynamicrender;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.jd.ad.sdk.jad_hu.jad_cp;
import com.jd.ad.sdk.jad_qd.jad_jt;
import com.jd.ad.sdk.logger.Logger;
import com.sigmob.sdk.base.k;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DynamicRenderTemplateHelper {
    public static com.jd.ad.sdk.jad_hu.jad_bo jad_dq;
    public final String jad_an;
    public final List<jad_cp> jad_bo;
    public String jad_cp;

    public class jad_an implements Runnable {
        public final /* synthetic */ jad_cp jad_an;

        public jad_an(DynamicRenderTemplateHelper dynamicRenderTemplateHelper, jad_cp jad_cpVar) {
            this.jad_an = jad_cpVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                DynamicRenderTemplateHelper.jad_dq.jad_an(this.jad_an);
                return;
            }
            jad_cp jad_cpVar = this.jad_an;
            List<String> list = com.jd.ad.sdk.jad_tg.jad_an.jad_an;
            if (jad_cpVar == null) {
                return;
            }
            try {
                ContentResolver jad_an = com.jd.ad.sdk.jad_tg.jad_an.jad_an();
                if (jad_an == null) {
                    return;
                }
                Uri parse = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "db_dynamic_render/" + k.f18185q);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", Integer.valueOf(jad_cpVar.jad_an));
                contentValues.put("templateID", Integer.valueOf(jad_cpVar.jad_cp));
                contentValues.put("templateUpdateTimeStamp", jad_cpVar.jad_dq);
                contentValues.put("templateJSON", jad_cpVar.jad_er);
                contentValues.put("timeStampInterval", jad_cpVar.jad_fs);
                contentValues.put("appIdPid", jad_cpVar.jad_bo);
                jad_an.update(parse, contentValues, null, null);
            } catch (Exception e10) {
                Logger.w("Exception while multi process update template: ", e10.getMessage());
            }
        }
    }

    public DynamicRenderTemplateHelper(Context context, String str) {
        this.jad_an = str;
        if (!jad_jt.jad_dq(context)) {
            this.jad_bo = com.jd.ad.sdk.jad_tg.jad_an.jad_cp(str);
            return;
        }
        if (jad_dq == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_an2 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(context, "jaddb.db", 2);
            jad_dq = jad_an2;
            jad_an2.jad_cp();
        }
        this.jad_bo = jad_dq.jad_an(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void jad_an(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper.jad_an(java.lang.String):void");
    }

    public JSONArray jad_bo() {
        if (this.jad_bo == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (jad_cp jad_cpVar : this.jad_bo) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ExposeManager.UtArgsNames.templateId, jad_cpVar.jad_cp);
            jSONObject.put("template_update_timestamp", jad_cpVar.jad_dq);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    public static boolean jad_an() {
        com.jd.ad.sdk.jad_pc.jad_an jad_an2 = com.jd.ad.sdk.jad_re.jad_an.jad_an();
        return jad_an2 != null && "1".equals(jad_an2.jad_na);
    }
}
