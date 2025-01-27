package cn.vlion.ad.inland.base.util.init;

/* loaded from: classes.dex */
public class VlionSdkConfig {
    private String appKey;
    private boolean enableLog;
    private String mAppId;
    private VlionPrivateController vlionPrivateController;
    private int wxSdkInt;
    private String wxSdkVersionName;

    public static class Builder {
        private String appId;
        private String appKey;
        private boolean enableLog;
        private VlionPrivateController privateController;
        private int wxSdkInt;
        private String wxSdkVersionName;

        public VlionSdkConfig build() {
            return new VlionSdkConfig(this);
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setEnableLog(boolean z10) {
            this.enableLog = z10;
            return this;
        }

        public Builder setPrivateController(VlionPrivateController vlionPrivateController) {
            this.privateController = vlionPrivateController;
            return this;
        }

        public Builder setWxSdkInt(int i10) {
            this.wxSdkInt = i10;
            return this;
        }

        public Builder setWxSdkVersionName(String str) {
            this.wxSdkVersionName = str;
            return this;
        }
    }

    private VlionSdkConfig(Builder builder) {
        if (builder != null) {
            this.mAppId = builder.appId;
            this.enableLog = builder.enableLog;
            this.vlionPrivateController = builder.privateController;
            this.appKey = builder.appKey;
            this.wxSdkInt = builder.wxSdkInt;
            this.wxSdkVersionName = builder.wxSdkVersionName;
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public VlionPrivateController getPrivateController() {
        return this.vlionPrivateController;
    }

    public int getWxSdkInt() {
        return this.wxSdkInt;
    }

    public String getWxSdkVersionName() {
        return this.wxSdkVersionName;
    }

    public boolean isEnableLog() {
        return this.enableLog;
    }

    public /* synthetic */ VlionSdkConfig(Builder builder, a aVar) {
        this(builder);
    }
}
