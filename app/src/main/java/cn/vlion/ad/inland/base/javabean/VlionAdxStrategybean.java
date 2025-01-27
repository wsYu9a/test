package cn.vlion.ad.inland.base.javabean;

/* loaded from: classes.dex */
public class VlionAdxStrategybean {
    private String logDate;
    private String packageName;

    public VlionAdxStrategybean(String str, String str2) {
        this.packageName = str;
        this.logDate = str2;
    }

    public String getLogDate() {
        return this.logDate;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setLogDate(String str) {
        this.logDate = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }
}
