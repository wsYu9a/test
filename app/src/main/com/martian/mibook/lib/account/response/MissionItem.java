package com.martian.mibook.lib.account.response;

import ba.l;
import com.martian.apptask.R;

/* loaded from: classes3.dex */
public class MissionItem {
    public Boolean authShow;
    public Integer bonusCount;
    public String bonusStr;
    public Integer bookCoins;
    private Integer bubbleCoins;
    private Integer bubbleCount;
    private String bubbleTitle;
    public String buttonText;
    public Integer clickTimes;
    public Integer clickType;
    public Integer coins;
    public String deeplink;
    public String desc;
    public boolean diractForward;
    public Integer duration;
    private boolean exposed;
    public Boolean finished;
    public Boolean foldable;
    public Boolean hide;
    public String icon;
    public int iconRes;
    public String intro;
    public Boolean isHintOpened;
    public String jumpUrl;
    public String miniProgramId;
    public Integer money;
    public String nightIcon;
    public int nightIconRes;
    public transient Object origin;
    public Integer priority;
    private String recommend;
    public Integer runtimes;
    public String title;
    public Integer type;
    public String url;
    private String wxAppid;

    public MissionItem() {
        this.diractForward = true;
        this.hide = Boolean.FALSE;
        this.exposed = false;
    }

    public boolean getAuthShow() {
        Boolean bool = this.authShow;
        return bool != null && bool.booleanValue();
    }

    public Integer getBonusCount() {
        return this.bonusCount;
    }

    public String getBonusString() {
        return this.bonusStr;
    }

    public Integer getBookCoins() {
        Integer num = this.bookCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getBubbleCoins() {
        Integer num = this.bubbleCoins;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public Integer getBubbleCount() {
        return this.bubbleCount;
    }

    public String getBubbleTitle() {
        return this.bubbleTitle;
    }

    public String getButtonText() {
        return l.q(this.buttonText) ? "立即前往" : this.buttonText;
    }

    public int getClickTimes() {
        Integer num = this.clickTimes;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getClickType() {
        Integer num = this.clickType;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int getCoins() {
        Integer num = this.coins;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getDescOrTitle() {
        return l.q(this.desc) ? this.title : this.desc;
    }

    public int getDuration() {
        Integer num = this.duration;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public boolean getFinished() {
        Boolean bool = this.finished;
        return bool != null && bool.booleanValue();
    }

    public boolean getFoldAble() {
        Boolean bool = this.foldable;
        return bool == null || bool.booleanValue();
    }

    public Boolean getFoldable() {
        return this.foldable;
    }

    public Boolean getHide() {
        Boolean bool = this.hide;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public Boolean getHintOpened() {
        return this.isHintOpened;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getIconRes() {
        int i10 = this.iconRes;
        return i10 > 0 ? i10 : R.drawable.icon_ads_bae;
    }

    public String getIntro() {
        return this.intro;
    }

    public boolean getIsHintOpened() {
        Boolean bool = this.isHintOpened;
        return bool != null && bool.booleanValue();
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getMiniProgramId() {
        return this.miniProgramId;
    }

    public int getMoney() {
        Integer num = this.money;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getNightIcon() {
        return this.nightIcon;
    }

    public int getNightIconRes() {
        return this.nightIconRes;
    }

    public Object getOrigin() {
        return this.origin;
    }

    public int getPriority() {
        Integer num = this.priority;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getRecommend() {
        return this.recommend;
    }

    public int getRunTimes() {
        Integer num = this.runtimes;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public Integer getRuntimes() {
        return this.runtimes;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        Integer num = this.type;
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public String getUrl() {
        return this.url;
    }

    public String getWxAppid() {
        return this.wxAppid;
    }

    public boolean isDiractForward() {
        return this.diractForward;
    }

    public boolean isExposed() {
        return this.exposed;
    }

    public void setAuthShow(Boolean bool) {
        this.authShow = bool;
    }

    public void setBonusCount(Integer num) {
        this.bonusCount = num;
    }

    public void setBonusString(String str) {
        this.bonusStr = str;
    }

    public void setBookCoins(Integer num) {
        this.bookCoins = num;
    }

    public void setBubbleCoins(Integer num) {
        this.bubbleCoins = num;
    }

    public void setBubbleCount(Integer num) {
        this.bubbleCount = num;
    }

    public MissionItem setBubbleTitle(String str) {
        this.bubbleTitle = str;
        return this;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setClickTimes(Integer num) {
        this.clickTimes = num;
    }

    public void setClickType(Integer num) {
        this.clickType = num;
    }

    public void setCoins(Integer num) {
        this.coins = num;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDiractForward(boolean z10) {
        this.diractForward = z10;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setExposed(boolean z10) {
        this.exposed = z10;
    }

    public void setFinished(Boolean bool) {
        this.finished = bool;
    }

    public void setFoldable(Boolean bool) {
        this.foldable = bool;
    }

    public void setHide(Boolean bool) {
        this.hide = bool;
    }

    public void setHintOpened(Boolean bool) {
        this.isHintOpened = bool;
    }

    public MissionItem setIcon(String str) {
        this.icon = str;
        return this;
    }

    public void setIconRes(int i10) {
        this.iconRes = i10;
    }

    public void setIntro(String str) {
        this.intro = str;
    }

    public void setIsHintOpened(Boolean bool) {
        this.isHintOpened = bool;
    }

    public MissionItem setJumpUrl(String str) {
        this.jumpUrl = str;
        return this;
    }

    public void setMiniProgramId(String str) {
        this.miniProgramId = str;
    }

    public void setMoney(Integer num) {
        this.money = num;
    }

    public void setNightIcon(String str) {
        this.nightIcon = str;
    }

    public void setNightIconRes(int i10) {
        this.nightIconRes = i10;
    }

    public void setOrigin(Object obj) {
        this.origin = obj;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public void setRecommend(String str) {
        this.recommend = str;
    }

    public void setRuntimes(Integer num) {
        this.runtimes = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }

    public MissionItem setUrl(String str) {
        this.url = str;
        return this;
    }

    public void setWxAppid(String str) {
        this.wxAppid = str;
    }

    public MissionItem(int i10, String str, int i11, int i12, boolean z10, int i13, String str2) {
        this.diractForward = true;
        this.hide = Boolean.FALSE;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.clickType = Integer.valueOf(i11);
        this.clickTimes = Integer.valueOf(i12);
        this.authShow = Boolean.valueOf(z10);
        this.priority = Integer.valueOf(i13);
        this.buttonText = str2;
    }

    public MissionItem(int i10, String str, String str2, String str3, boolean z10, int i11, int i12, boolean z11, int i13, int i14, boolean z12, boolean z13) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.desc = str2;
        this.buttonText = str3;
        this.foldable = Boolean.valueOf(z10);
        this.iconRes = i11;
        this.nightIconRes = i12;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(z11);
        this.coins = Integer.valueOf(i13);
        this.money = Integer.valueOf(i14);
        this.authShow = Boolean.valueOf(z12);
        this.diractForward = z13;
    }

    public MissionItem(int i10, String str, String str2, String str3, boolean z10, int i11, boolean z11, int i12, int i13, boolean z12, boolean z13) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.desc = str2;
        this.buttonText = str3;
        this.foldable = Boolean.valueOf(z10);
        this.iconRes = i11;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(z11);
        this.coins = Integer.valueOf(i12);
        this.money = Integer.valueOf(i13);
        this.authShow = Boolean.valueOf(z12);
        this.diractForward = z13;
    }

    public MissionItem(int i10, String str, String str2, String str3, boolean z10, int i11, boolean z11, int i12, int i13, boolean z12, String str4, String str5) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.desc = str2;
        this.buttonText = str3;
        this.foldable = Boolean.valueOf(z10);
        this.iconRes = i11;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(z11);
        this.coins = Integer.valueOf(i12);
        this.money = Integer.valueOf(i13);
        this.authShow = Boolean.valueOf(z12);
        this.icon = str4;
        this.url = str5;
    }

    public MissionItem(int i10, String str, String str2, String str3, boolean z10, int i11, boolean z11, int i12, int i13, boolean z12, String str4, String str5, String str6, String str7, String str8) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.desc = str2;
        this.buttonText = str3;
        this.foldable = Boolean.valueOf(z10);
        this.iconRes = i11;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(z11);
        this.coins = Integer.valueOf(i12);
        this.money = Integer.valueOf(i13);
        this.authShow = Boolean.valueOf(z12);
        this.icon = str4;
        this.wxAppid = str5;
        this.miniProgramId = str6;
        this.jumpUrl = str7;
        this.bonusStr = str8;
    }

    public MissionItem(int i10, String str, String str2, String str3, boolean z10, int i11, boolean z11, int i12, int i13, int i14, boolean z12, boolean z13) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(i10);
        this.title = str;
        this.desc = str2;
        this.buttonText = str3;
        this.foldable = Boolean.valueOf(z10);
        this.iconRes = i11;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(z11);
        this.coins = Integer.valueOf(i12);
        this.money = Integer.valueOf(i13);
        this.bookCoins = Integer.valueOf(i14);
        this.authShow = Boolean.valueOf(z12);
        this.diractForward = z13;
    }
}
