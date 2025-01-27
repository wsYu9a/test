package com.alimm.tanx.core.ad.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.NotConfused;
import java.util.List;

/* loaded from: classes.dex */
public class BizInfo extends BaseBean implements NotConfused {

    @JSONField(name = "cache_creative_id")
    private String cacheCreativeId;

    @JSONField(name = "cache_keys")
    private List<String> cacheKeys;

    public String getCacheCreativeId() {
        return this.cacheCreativeId;
    }

    public List<String> getCacheKeys() {
        return this.cacheKeys;
    }

    public void setCacheCreativeId(String str) {
        this.cacheCreativeId = str;
    }

    public void setCacheKeys(List<String> list) {
        this.cacheKeys = list;
    }
}
