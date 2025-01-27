package com.martian.mibook.lib.account.request.auth;

import com.martian.libcomm.http.requests.d.a;

/* loaded from: classes3.dex */
public class RtParams extends TYAuthParams {

    /* renamed from: c */
    @a
    private String f13924c;

    @a
    private String ccid;

    @a
    private Integer ci;

    @a
    private Integer cs;

    /* renamed from: d */
    @a
    private Integer f13925d;

    @a
    private String s;

    @a
    private Integer seq;

    @a
    private Integer v;

    @Override // com.martian.mibook.lib.account.request.auth.TYAuthParams
    public String getAuthMethod() {
        return "v3/rt.do";
    }

    public String getC() {
        return this.f13924c;
    }

    public int getCS() {
        Integer num = this.cs;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getCcid() {
        return this.ccid;
    }

    public int getCi() {
        Integer num = this.ci;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getCs() {
        return this.cs;
    }

    public int getD() {
        Integer num = this.f13925d;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getS() {
        return this.s;
    }

    public Integer getSeq() {
        return this.seq;
    }

    public Integer getV() {
        return this.v;
    }

    public void setC(String c2) {
        this.f13924c = c2;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public void setD(Integer d2) {
        this.f13925d = d2;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
