package cn.vlion.ad.inland.base.util.init;

/* loaded from: classes.dex */
public abstract class VlionPrivateController {
    public String getImei() {
        return "";
    }

    public VlionLocation getLocation() {
        return new VlionLocation(-1.0d, -1.0d, -1.0d);
    }

    public String getMac() {
        return "";
    }

    public abstract String getOaid();

    public boolean isCanReadAppList() {
        return true;
    }

    public abstract boolean isCanUseGaid();

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMacAddress() {
        return true;
    }

    public boolean isCanUsePhoneState() {
        return true;
    }
}
