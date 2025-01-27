package com.alimm.tanx.core.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.bean.BaseBean;
import com.alimm.tanx.core.ad.bean.RequestBaseBean;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class AdRequestBean extends RequestBaseBean {
    public AdContentBean content;
    public boolean https_required;
    public List<AdImpBean> imp;
    public Boolean is_realtime_request;
    public int render_type;

    @JSONField(serialize = false)
    public TanxAdSlot tanxAdSlot;
    public AdUserBean user;
    public int version;
    public int source = 3;
    public String ext = "";

    public static class AdContentBean extends BaseBean {
        public List<String> category;
        public List<String> keywords;
        public List<String> query_term;
        public List<String> suggestion;
        public String title;
    }

    public static class AdImpBean extends BaseBean {

        /* renamed from: id */
        public String f6319id;
        public String[] native_template_id;
        public String pid;
        public int pos;
        public int slot_num;
        public List<TopCreative> top_creatives;
    }

    public static class AdUserBean extends BaseBean {
        public String media_uid;
        public Map<String, List<String>> user_tag;
    }

    public AdRequestBean build(TanxAdSlot tanxAdSlot) {
        this.tanxAdSlot = tanxAdSlot;
        return this;
    }
}
