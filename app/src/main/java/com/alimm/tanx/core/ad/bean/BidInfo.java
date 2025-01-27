package com.alimm.tanx.core.ad.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.ad.listener.bean.IClickBean;
import com.alimm.tanx.core.ad.listener.bean.IMaterialBean;
import com.alimm.tanx.core.ad.listener.bean.IMonitorBean;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.utils.MD5Utils;
import com.umeng.analytics.pro.f;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class BidInfo extends BaseBean implements IBidInfo {

    @JSONField(name = "ad_source")
    private String adSource;

    @JSONField(name = "adv_logo")
    private String advLogo;

    @JSONField(name = "bid_price")
    private long bidPrice;

    @JSONField(name = "biz_info")
    private BizInfo bizInfo;

    @JSONField(name = "click_through_url")
    private String clickThroughUrl;

    @JSONField(name = "click_tracking_url")
    private List<String> clickTrackUrl;

    @JSONField(name = ExposeManager.UtArgsNames.creativeId)
    private String creativeId;

    @JSONField(name = "materials")
    private CreativeItem creativeItem;

    @JSONField(name = "creative_type")
    private int creativeType;

    @JSONField(name = "deeplink_url")
    private String deepLinkUrl;

    @JSONField(name = "event_track")
    private List<NewTrackItem> eventTrack;

    /* renamed from: id */
    @JSONField(name = "id")
    private int f6312id;

    @JSONField(name = "impression_tracking_url")
    private List<String> impTrackUrl;

    @JSONField(name = ExposeManager.UtArgsNames.interactType)
    private Integer[] interactType;

    @JSONField(name = "open_type")
    private int openType;

    @JSONField(serialize = false)
    private String rawJsonStr;

    @JSONField(name = f.f23909q)
    private long releaseEndTime;

    @JSONField(name = "begin_time")
    private long releaseStartTime;

    @JSONField(name = "session_id")
    private String sessionId;

    @JSONField(name = "sub_materials")
    private String subMaterials;

    @JSONField(name = "template_conf")
    private TemplateConfig templateConf;

    @JSONField(name = "template_height")
    private String templateHeight;

    @JSONField(name = ExposeManager.UtArgsNames.templateId)
    private String templateId;

    @JSONField(name = "template_width")
    private String templateWidth;

    @JSONField(name = "winnotice_url")
    private String winNoticeUrl;
    private final tanxc_do clickBean = new tanxc_do();
    private final tanxc_if monitorBean = new tanxc_if();

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getAdSource() {
        return this.adSource;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getAdvLogo() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getAdvLogo();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getBidPrice() {
        return this.bidPrice;
    }

    public BizInfo getBizInfo() {
        return this.bizInfo;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCacheCreativeId() {
        BizInfo bizInfo = this.bizInfo;
        if (bizInfo != null) {
            return bizInfo.getCacheCreativeId();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IClickBean getClickBean() {
        return this.clickBean;
    }

    public String getClickThroughUrl() {
        return this.clickThroughUrl;
    }

    public List<String> getClickTrackUrl() {
        return this.clickTrackUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeId() {
        return this.creativeId;
    }

    public CreativeItem getCreativeItem() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeMd5() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageMd5();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeName() {
        CreativeItem creativeItem = this.creativeItem;
        return (creativeItem == null || TextUtils.isEmpty(creativeItem.getImageUrl())) ? "" : MD5Utils.getMD5String(this.creativeItem.getImageUrl());
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativePath() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getImageUrl();
        }
        return null;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getCreativeType() {
        return this.creativeType;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeVideoName() {
        CreativeItem creativeItem = this.creativeItem;
        return (creativeItem == null || TextUtils.isEmpty(creativeItem.getVideo())) ? "" : MD5Utils.getMD5String(this.creativeItem.getVideo());
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getCreativeVideoPath() {
        CreativeItem creativeItem = this.creativeItem;
        if (creativeItem != null) {
            return creativeItem.getVideo();
        }
        return null;
    }

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public List<NewTrackItem> getEventTrack() {
        return this.eventTrack;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getId() {
        return this.f6312id;
    }

    public List<String> getImpTrackUrl() {
        return this.impTrackUrl;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public Integer[] getInteractType() {
        return this.interactType;
    }

    public boolean getInteractType2FeedSlide() {
        return getInteractType(3);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getInteractType2Int() {
        Integer[] numArr = this.interactType;
        if (numArr == null || numArr.length <= 0) {
            return -1;
        }
        return numArr[0].intValue();
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public boolean getInteractType2Shake() {
        return getInteractType(1);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IMaterialBean getMaterialBean() {
        return this.creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public IMonitorBean getMonitorBean() {
        return this.monitorBean;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public int getOpenType() {
        return this.openType;
    }

    public String getRawJsonStr() {
        return this.rawJsonStr;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseEndTime() {
        return this.releaseEndTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public long getReleaseStartTime() {
        return this.releaseStartTime;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getSessionId() {
        return this.sessionId;
    }

    public String getSubMaterials() {
        return this.subMaterials;
    }

    public TemplateConfig getTemplateConf() {
        return this.templateConf;
    }

    public String getTemplateHeight() {
        return this.templateHeight;
    }

    public int getTemplateHeight2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.templateHeight);
        } catch (Exception unused) {
            i10 = 9;
        }
        if (i10 <= 0) {
            return 9;
        }
        return i10;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public String getTemplateId() {
        return this.templateId;
    }

    public String getTemplateWidth() {
        return this.templateWidth;
    }

    public int getTemplateWidth2Int() {
        int i10;
        try {
            i10 = Integer.parseInt(this.templateWidth);
        } catch (Exception unused) {
            i10 = 16;
        }
        if (i10 <= 0) {
            return 16;
        }
        return i10;
    }

    public String getWinNoticeUrl() {
        return this.winNoticeUrl;
    }

    public BidInfo removeSensitiveData() {
        BidInfo bidInfo = new BidInfo();
        bidInfo.setId(getId());
        bidInfo.setCreativeId(getCreativeId());
        bidInfo.setBidPrice(getBidPrice());
        bidInfo.setInteractType(getInteractType());
        bidInfo.setTemplateId(getTemplateId());
        bidInfo.setCreativeItem(getCreativeItem());
        bidInfo.setClickThroughUrl(getClickThroughUrl());
        bidInfo.setOpenType(getOpenType());
        bidInfo.setClickTrackUrl(getClickTrackUrl());
        bidInfo.setWinNoticeUrl(getWinNoticeUrl());
        bidInfo.setEventTrack(getEventTrack());
        bidInfo.setReleaseStartTime(getReleaseStartTime());
        bidInfo.setReleaseEndTime(getReleaseEndTime());
        bidInfo.setAdSource(getAdSource());
        bidInfo.setDeepLinkUrl(getDeepLinkUrl());
        bidInfo.setAdvLogo(getAdvLogo());
        bidInfo.setSubMaterials(getSubMaterials());
        bidInfo.setTemplateConf(getTemplateConf());
        bidInfo.setSessionId(getSessionId());
        bidInfo.setTemplateWidth(getTemplateWidth());
        bidInfo.setTemplateHeight(getTemplateHeight());
        bidInfo.setCreativeType(getCreativeType());
        bidInfo.setRawJsonStr(getRawJsonStr());
        return bidInfo;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public void setAdvLogo(String str) {
        this.advLogo = str;
    }

    public void setBidPrice(long j10) {
        this.bidPrice = j10;
    }

    public void setBizInfo(BizInfo bizInfo) {
        this.bizInfo = bizInfo;
    }

    public void setClickThroughUrl(String str) {
        this.clickThroughUrl = str;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(str);
        }
    }

    public void setClickTrackUrl(List<String> list) {
        this.clickTrackUrl = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_if(list);
        }
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setCreativeItem(CreativeItem creativeItem) {
        this.creativeItem = creativeItem;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public void setCreativePath(String str) {
        this.creativeItem.setImageUrl(str);
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public void setCreativeType(int i10) {
        this.creativeType = i10;
    }

    @Override // com.alimm.tanx.core.ad.listener.bean.IBidInfo
    public void setCreativeVideoPath(String str) {
        this.creativeItem.setVideo(str);
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_if(str);
        }
    }

    public void setEventTrack(List<NewTrackItem> list) {
        this.eventTrack = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_for(list);
        }
    }

    public void setId(int i10) {
        this.f6312id = i10;
    }

    public void setImpTrackUrl(List<String> list) {
        this.impTrackUrl = list;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(list);
        }
    }

    public void setInteractType(Integer[] numArr) {
        this.interactType = numArr;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(numArr);
        }
    }

    public void setOpenType(int i10) {
        this.openType = i10;
        tanxc_do tanxc_doVar = this.clickBean;
        if (tanxc_doVar != null) {
            tanxc_doVar.tanxc_do(i10);
        }
    }

    public void setRawJsonStr(String str) {
        this.rawJsonStr = str;
    }

    public void setReleaseEndTime(long j10) {
        this.releaseEndTime = j10;
    }

    public void setReleaseStartTime(long j10) {
        this.releaseStartTime = j10;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSubMaterials(String str) {
        this.subMaterials = str;
    }

    public void setTemplateConf(TemplateConfig templateConfig) {
        this.templateConf = templateConfig;
    }

    public void setTemplateHeight(String str) {
        this.templateHeight = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTemplateWidth(String str) {
        this.templateWidth = str;
    }

    public void setWinNoticeUrl(String str) {
        this.winNoticeUrl = str;
        tanxc_if tanxc_ifVar = this.monitorBean;
        if (tanxc_ifVar != null) {
            tanxc_ifVar.tanxc_do(str);
        }
    }

    public String toString() {
        return "BidInfo{id=" + this.f6312id + ", creativeId='" + this.creativeId + "', bidPrice=" + this.bidPrice + ", creativeType=" + this.creativeType + ", interactType=" + Arrays.toString(this.interactType) + ", templateId='" + this.templateId + "', creativeItem=" + this.creativeItem + ", clickThroughUrl='" + this.clickThroughUrl + "', openType=" + this.openType + ", impTrackUrl=" + this.impTrackUrl + ", clickTrackUrl=" + this.clickTrackUrl + ", winNoticeUrl='" + this.winNoticeUrl + "', eventTrack=" + this.eventTrack + ", releaseStartTime=" + this.releaseStartTime + ", releaseEndTime=" + this.releaseEndTime + ", adSource='" + this.adSource + "', deepLinkUrl='" + this.deepLinkUrl + "', advLogo='" + this.advLogo + "', subMaterials='" + this.subMaterials + "', templateConf=" + this.templateConf + ", sessionId='" + this.sessionId + "', templateWidth='" + this.templateWidth + "', templateHeight='" + this.templateHeight + "', bizInfo=" + this.bizInfo + ", rawJsonStr='" + this.rawJsonStr + "', clickBean=" + this.clickBean + ", monitorBean=" + this.monitorBean + "} " + super.toString();
    }

    public boolean getInteractType(int i10) {
        return getInteractType() != null && getInteractType().length > 0 && Arrays.binarySearch(getInteractType(), Integer.valueOf(i10)) >= 0;
    }
}
