package cn.vlion.ad.inland.base.javabean;

/* loaded from: classes.dex */
public class VlionDAClkBodyParameter {
    private String StrStr;
    private String adgroupid;
    private String clk_type;
    private String clk_url;
    private String drop_rate;
    private String exp_type;
    private String status;

    public VlionDAClkBodyParameter(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.clk_url = str;
        this.clk_type = str2;
        this.drop_rate = str3;
        this.status = str4;
        this.StrStr = str5;
        this.exp_type = str6;
        this.adgroupid = str7;
    }

    public String getAdgroupid() {
        return this.adgroupid;
    }

    public String getClk_type() {
        return this.clk_type;
    }

    public String getClk_url() {
        return this.clk_url;
    }

    public String getDrop_rate() {
        return this.drop_rate;
    }

    public String getExp_type() {
        return this.exp_type;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStrStr() {
        return this.StrStr;
    }

    public void setAdgroupid(String str) {
        this.adgroupid = str;
    }

    public void setClk_type(String str) {
        this.clk_type = str;
    }

    public void setClk_url(String str) {
        this.clk_url = str;
    }

    public void setDrop_rate(String str) {
        this.drop_rate = str;
    }

    public void setExp_type(String str) {
        this.exp_type = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setStrStr(String str) {
        this.StrStr = str;
    }
}
