package com.alimm.tanx.core.log;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import java.io.File;

/* loaded from: classes.dex */
public class UploadLogRequestBean extends RequestBaseBean {
    private Long config_id;
    public AdDeviceBean device;
    public String ext = "";

    @JSONField(serialize = false)
    public File logFile;
    public String md5_app_key;
    public String req_Id;
    public AdUserBean user;
    private Long version;

    public static class AdDeviceBean extends RequestBaseBean.AdDeviceBean {
        public Integer os;
    }

    public static class AdUserBean extends BaseBean {
        public String app_key;
    }
}
