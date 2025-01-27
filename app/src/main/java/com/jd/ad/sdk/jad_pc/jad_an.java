package com.jd.ad.sdk.jad_pc;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class jad_an {
    public String jad_an;
    public float jad_cp;
    public float jad_dq;
    public float jad_er;
    public float jad_fs;
    public float jad_hu;
    public float jad_iv;
    public float jad_jt;
    public float jad_jw;
    public int jad_kx;
    public int jad_ly;
    public String jad_na;
    public int jad_ob;
    public int jad_pc;
    public String jad_qd;
    public int jad_re;
    public String jad_sf;
    public String jad_tg;
    public String jad_bo = "0";
    public int jad_mz = 3;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("crt", this.jad_an);
            jSONObject.putOpt("fbdr", this.jad_na);
            jSONObject.putOpt("enpe", this.jad_bo);
            jSONObject.putOpt("ssvl", Float.valueOf(this.jad_cp));
            jSONObject.putOpt("slng", Float.valueOf(this.jad_dq));
            jSONObject.putOpt("savl", Float.valueOf(this.jad_er));
            jSONObject.putOpt("stvl", Float.valueOf(this.jad_fs));
            jSONObject.putOpt("fsvl", Float.valueOf(this.jad_jt));
            jSONObject.putOpt("favl", Float.valueOf(this.jad_hu));
            jSONObject.putOpt("ftvl", Float.valueOf(this.jad_iv));
            jSONObject.putOpt("sang", Float.valueOf(this.jad_jw));
            jSONObject.putOpt("pcit", Integer.valueOf(this.jad_kx));
            jSONObject.putOpt("pcdc", Integer.valueOf(this.jad_ly));
            jSONObject.putOpt("pdut", Integer.valueOf(this.jad_mz));
            jSONObject.putOpt("fpif", Integer.valueOf(this.jad_pc));
            jSONObject.putOpt("fikc", this.jad_qd);
            jSONObject.putOpt("opro", Integer.valueOf(this.jad_ob));
            jSONObject.putOpt("vcdc", Integer.valueOf(this.jad_re));
            jSONObject.putOpt("fbvl", this.jad_sf);
            jSONObject.putOpt("ftsv", this.jad_tg);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ABConfig{crt=");
        jad_an.append(this.jad_an);
        jad_an.append(", fbdr=");
        jad_an.append(this.jad_na);
        jad_an.append(", enpe=");
        jad_an.append(this.jad_bo);
        jad_an.append(", ssvl=");
        jad_an.append(this.jad_cp);
        jad_an.append(", slng=");
        jad_an.append(this.jad_dq);
        jad_an.append(", savl=");
        jad_an.append(this.jad_er);
        jad_an.append(", stvl=");
        jad_an.append(this.jad_fs);
        jad_an.append(", fsvl=");
        jad_an.append(this.jad_jt);
        jad_an.append(", favl=");
        jad_an.append(this.jad_hu);
        jad_an.append(", ftvl=");
        jad_an.append(this.jad_iv);
        jad_an.append(", sang=");
        jad_an.append(this.jad_jw);
        jad_an.append(", pcit=");
        jad_an.append(this.jad_kx);
        jad_an.append(", pcdc=");
        jad_an.append(this.jad_ly);
        jad_an.append(", pdut=");
        jad_an.append(this.jad_mz);
        jad_an.append(", fpif=");
        jad_an.append(this.jad_pc);
        jad_an.append(", fikc=");
        jad_an.append(this.jad_qd);
        jad_an.append(", opro=");
        jad_an.append(this.jad_ob);
        jad_an.append(", vcdc=");
        jad_an.append(this.jad_re);
        jad_an.append(", vlft=");
        jad_an.append(this.jad_sf);
        jad_an.append(", ftsv=");
        jad_an.append(this.jad_tg);
        jad_an.append('}');
        return jad_an.toString();
    }
}
