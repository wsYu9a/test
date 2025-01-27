package cn.vlion.ad.inland.base.javabean;

/* loaded from: classes.dex */
public class VlionADNetBodyParameter {
    private String api_status;
    private String api_type;
    private int bodysize;
    private String error_msg;
    private long latency;
    private long reqtime;
    private int status;
    private String url;

    public VlionADNetBodyParameter(String str, long j10, int i10, int i11, long j11, String str2, boolean z10, String str3) {
        this.url = str;
        this.reqtime = j10;
        this.bodysize = i10;
        this.status = i11;
        this.latency = j11;
        this.api_type = str2;
        this.api_status = z10 ? "1" : "0";
        this.error_msg = str3;
    }

    public String getApi_status() {
        return this.api_status;
    }

    public String getApi_type() {
        return this.api_type;
    }

    public int getBodysize() {
        return this.bodysize;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public long getLatency() {
        return this.latency;
    }

    public long getReqtime() {
        return this.reqtime;
    }

    public int getStatus() {
        return this.status;
    }

    public String getUrl() {
        return this.url;
    }

    public void setStatus(int i10) {
        this.status = i10;
    }
}
