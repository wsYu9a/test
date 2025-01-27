package cn.vlion.ad.inland.base.javabean;

import cn.vlion.ad.inland.base.util.handle.VlionBaseParameterReplace;

/* loaded from: classes.dex */
public class VlionADClickType {
    private String isCanOpenDp;
    private boolean isDefaultAdStrategy = true;
    private String page;
    private String pagePos;
    private String target;
    private String triggerParam;
    private String triggerType;
    private VlionBaseParameterReplace vlionBaseParameterReplace;

    public VlionADClickType(String str, String str2, String str3, String str4, String str5) {
        this.triggerType = str;
        this.triggerParam = str2;
        this.page = str3;
        this.pagePos = str4;
        this.target = str5;
    }

    public String getIsCanOpenDp() {
        return this.isCanOpenDp;
    }

    public String getPage() {
        return this.page;
    }

    public String getPagePos() {
        return this.pagePos;
    }

    public String getTarget() {
        return this.target;
    }

    public String getTriggerParam() {
        return this.triggerParam;
    }

    public String getTriggerType() {
        return this.triggerType;
    }

    public VlionBaseParameterReplace getVlionBaseParameterReplace() {
        return this.vlionBaseParameterReplace;
    }

    public boolean isDefaultAdStrategy() {
        return this.isDefaultAdStrategy;
    }

    public void setDefaultAdStrategy(boolean z10) {
        this.isDefaultAdStrategy = z10;
    }

    public void setIsCanOpenDp(String str) {
        this.isCanOpenDp = str;
    }

    public void setTarget(String str) {
        this.target = str;
    }

    public void setTriggerParam(String str) {
        this.triggerParam = str;
    }

    public void setVlionBaseParameterReplace(VlionBaseParameterReplace vlionBaseParameterReplace) {
        this.vlionBaseParameterReplace = vlionBaseParameterReplace;
    }
}
