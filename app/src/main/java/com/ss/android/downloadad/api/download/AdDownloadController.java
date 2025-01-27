package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class AdDownloadController implements DownloadController {
    protected int mDownloadMode;
    protected Object mExtraClickOperation;
    protected JSONObject mExtraJson;
    protected Object mExtraObject;
    protected int mInterceptFlag;
    protected boolean mIsAddToDownloadManage;
    protected boolean mIsAutoDownloadOnCardShow;
    protected boolean mIsEnableBackDialog;
    protected int mLinkMode;
    protected boolean mShouldUseNewWebView;
    protected boolean mEnableShowComplianceDialog = true;
    protected boolean mEnableNewActivity = true;
    protected boolean mEnableAH = true;
    protected boolean mEnableAM = true;
    protected boolean mEnableOppoAutoDownload = true;
    protected DownloadMarketInterceptor mDownloadMarketInterceptor = null;

    public static final class Builder {
        AdDownloadController controller = new AdDownloadController();

        public AdDownloadController build() {
            return this.controller;
        }

        @Deprecated
        public Builder setDowloadChunkCount(int i10) {
            return this;
        }

        public Builder setDownloadMode(int i10) {
            this.controller.mDownloadMode = i10;
            return this;
        }

        public Builder setEnableAH(boolean z10) {
            this.controller.mEnableAH = z10;
            return this;
        }

        public Builder setEnableAM(boolean z10) {
            this.controller.mEnableAM = z10;
            return this;
        }

        public Builder setEnableNewActivity(boolean z10) {
            this.controller.mEnableNewActivity = z10;
            return this;
        }

        public Builder setEnableOppoAutoDownload(boolean z10) {
            this.controller.mEnableOppoAutoDownload = z10;
            return this;
        }

        public Builder setEnableShowComplianceDialog(boolean z10) {
            this.controller.mEnableShowComplianceDialog = z10;
            return this;
        }

        public Builder setExtraJson(JSONObject jSONObject) {
            this.controller.mExtraJson = jSONObject;
            return this;
        }

        public Builder setExtraObject(Object obj) {
            this.controller.mExtraObject = obj;
            return this;
        }

        @Deprecated
        public Builder setExtraOperation(Object obj) {
            this.controller.mExtraClickOperation = obj;
            return this;
        }

        public Builder setInterceptFlag(int i10) {
            this.controller.mInterceptFlag = i10;
            return this;
        }

        public Builder setIsAddToDownloadManage(boolean z10) {
            this.controller.mIsAddToDownloadManage = z10;
            return this;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean z10) {
            this.controller.mIsAutoDownloadOnCardShow = z10;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean z10) {
            this.controller.mIsEnableBackDialog = z10;
            return this;
        }

        @Deprecated
        public Builder setIsEnableMultipleDownload(boolean z10) {
            return this;
        }

        public Builder setLinkMode(int i10) {
            this.controller.mLinkMode = i10;
            return this;
        }

        public Builder setShouldUseNewWebView(boolean z10) {
            this.controller.mShouldUseNewWebView = z10;
            return this;
        }
    }

    public static AdDownloadController fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            builder.setLinkMode(jSONObject.optInt(DbJsonConstants.DBJSON_KEY_LINK_MODE));
            builder.setDownloadMode(jSONObject.optInt("download_mode"));
            builder.setIsEnableBackDialog(jSONObject.optInt("enable_back_dialog") == 1);
            builder.setIsAddToDownloadManage(jSONObject.optInt("add_to_manage") == 1);
            builder.setShouldUseNewWebView(jSONObject.optInt("use_new_webview") == 1);
            builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
            builder.setEnableShowComplianceDialog(jSONObject.optInt("enable_show_compliance_dialog", 1) == 1);
            builder.setIsAutoDownloadOnCardShow(jSONObject.optInt("is_auto_download_on_card_show") == 1);
            builder.setEnableNewActivity(jSONObject.optInt("enable_new_activity", 1) == 1);
            builder.setEnableAH(jSONObject.optInt("enable_ah", 1) == 1);
            builder.setEnableAM(jSONObject.optInt("enable_am", 1) == 1);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
            builder.setEnableOppoAutoDownload(jSONObject.optInt("enable_oppo_auto_download", 1) == 1);
        } catch (Exception e10) {
            k.u().a(e10, "AdDownloadController fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    public boolean enableOppoAutoDownload() {
        return this.mEnableOppoAutoDownload;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    public DownloadMarketInterceptor getDownloadMarketInterceptor() {
        return this.mDownloadMarketInterceptor;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    public void setDownloadMarketInterceptor(DownloadMarketInterceptor downloadMarketInterceptor) {
        this.mDownloadMarketInterceptor = downloadMarketInterceptor;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i10) {
        this.mDownloadMode = i10;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z10) {
        this.mEnableNewActivity = z10;
    }

    public void setEnableOppoAutoDownload(boolean z10) {
        this.mEnableOppoAutoDownload = z10;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z10) {
        this.mEnableShowComplianceDialog = z10;
    }

    public void setExtraJson(JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setExtraObject(Object obj) {
        this.mExtraObject = obj;
    }

    public void setIsAutoDownloadOnCardShow(boolean z10) {
        this.mIsAutoDownloadOnCardShow = z10;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i10) {
        this.mLinkMode = i10;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DbJsonConstants.DBJSON_KEY_LINK_MODE, Integer.valueOf(this.mLinkMode));
            jSONObject.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));
            jSONObject.putOpt("enable_back_dialog", Integer.valueOf(this.mIsEnableBackDialog ? 1 : 0));
            jSONObject.putOpt("add_to_manage", Integer.valueOf(this.mIsAddToDownloadManage ? 1 : 0));
            jSONObject.putOpt("use_new_webview", Integer.valueOf(this.mShouldUseNewWebView ? 1 : 0));
            jSONObject.putOpt("intercept_flag", Integer.valueOf(this.mInterceptFlag));
            jSONObject.putOpt("enable_show_compliance_dialog", Integer.valueOf(this.mEnableShowComplianceDialog ? 1 : 0));
            jSONObject.putOpt("is_auto_download_on_card_show", Integer.valueOf(this.mIsAutoDownloadOnCardShow ? 1 : 0));
            jSONObject.putOpt("extra", this.mExtraJson);
            jSONObject.putOpt("enable_new_activity", Integer.valueOf(this.mEnableNewActivity ? 1 : 0));
            jSONObject.putOpt("enable_ah", Integer.valueOf(this.mEnableAH ? 1 : 0));
            jSONObject.putOpt("enable_am", Integer.valueOf(this.mEnableAM ? 1 : 0));
            jSONObject.putOpt("enable_oppo_auto_download", Integer.valueOf(this.mEnableOppoAutoDownload ? 1 : 0));
        } catch (Exception e10) {
            k.u().a(e10, "AdDownloadController toJson");
        }
        return jSONObject;
    }
}
