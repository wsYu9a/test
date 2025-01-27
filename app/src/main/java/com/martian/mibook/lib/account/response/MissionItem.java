package com.martian.mibook.lib.account.response;

import com.martian.libsupport.k;
import com.martian.mibook.lib.account.R;

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
        return k.p(this.buttonText) ? "立即前往" : this.buttonText;
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
        return k.p(this.desc) ? this.title : this.desc;
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
        int i2 = this.iconRes;
        return i2 > 0 ? i2 : R.drawable.icon_ads_bae;
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

    public void setAuthShow(Boolean authShow) {
        this.authShow = authShow;
    }

    public void setBonusCount(Integer bonusCount) {
        this.bonusCount = bonusCount;
    }

    public void setBonusString(String bonusString) {
        this.bonusStr = bonusString;
    }

    public void setBookCoins(Integer bookCoins) {
        this.bookCoins = bookCoins;
    }

    public void setBubbleCoins(Integer bubbleCoins) {
        this.bubbleCoins = bubbleCoins;
    }

    public void setBubbleCount(Integer bubbleCount) {
        this.bubbleCount = bubbleCount;
    }

    public MissionItem setBubbleTitle(String bubbleTitle) {
        this.bubbleTitle = bubbleTitle;
        return this;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setClickTimes(Integer clickTimes) {
        this.clickTimes = clickTimes;
    }

    public void setClickType(Integer clickType) {
        this.clickType = clickType;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDiractForward(boolean diractForward) {
        this.diractForward = diractForward;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public void setFoldable(Boolean foldable) {
        this.foldable = foldable;
    }

    public void setHide(Boolean hide) {
        this.hide = hide;
    }

    public void setHintOpened(Boolean hintOpened) {
        this.isHintOpened = hintOpened;
    }

    public MissionItem setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setIsHintOpened(Boolean isHintOpened) {
        this.isHintOpened = isHintOpened;
    }

    public MissionItem setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
        return this;
    }

    public void setMiniProgramId(String miniProgramId) {
        this.miniProgramId = miniProgramId;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public void setNightIcon(String nightIcon) {
        this.nightIcon = nightIcon;
    }

    public void setNightIconRes(int nightIconRes) {
        this.nightIconRes = nightIconRes;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public void setRuntimes(Integer runtimes) {
        this.runtimes = runtimes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public MissionItem setUrl(String url) {
        this.url = url;
        return this;
    }

    public void setWxAppid(String wxAppid) {
        this.wxAppid = wxAppid;
    }

    public MissionItem(int type, String title, int clickType, int clickTimes, boolean authShow, int priority, String buttonText) {
        this.diractForward = true;
        this.hide = Boolean.FALSE;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.clickType = Integer.valueOf(clickType);
        this.clickTimes = Integer.valueOf(clickTimes);
        this.authShow = Boolean.valueOf(authShow);
        this.priority = Integer.valueOf(priority);
        this.buttonText = buttonText;
    }

    public MissionItem(int type, String title, String desc, String buttonText, boolean foldable, int iconRes, int nightIconRes, boolean finished, int coins, int money, boolean authShow, boolean diractForward) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.foldable = Boolean.valueOf(foldable);
        this.iconRes = iconRes;
        this.nightIconRes = nightIconRes;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(finished);
        this.coins = Integer.valueOf(coins);
        this.money = Integer.valueOf(money);
        this.authShow = Boolean.valueOf(authShow);
        this.diractForward = diractForward;
    }

    public MissionItem(int type, String title, String desc, String buttonText, boolean foldable, int iconRes, boolean finished, int coins, int money, boolean authShow, boolean diractForward) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.foldable = Boolean.valueOf(foldable);
        this.iconRes = iconRes;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(finished);
        this.coins = Integer.valueOf(coins);
        this.money = Integer.valueOf(money);
        this.authShow = Boolean.valueOf(authShow);
        this.diractForward = diractForward;
    }

    public MissionItem(int type, String title, String desc, String buttonText, boolean foldable, int iconRes, boolean finished, int coins, int money, boolean authShow, String icon, String url) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.foldable = Boolean.valueOf(foldable);
        this.iconRes = iconRes;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(finished);
        this.coins = Integer.valueOf(coins);
        this.money = Integer.valueOf(money);
        this.authShow = Boolean.valueOf(authShow);
        this.icon = icon;
        this.url = url;
    }

    public MissionItem(int type, String title, String desc, String buttonText, boolean foldable, int iconRes, boolean finished, int coins, int money, boolean authShow, String icon, String wxAppid, String miniProgramId, String jumpUrl, String bonusString) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.foldable = Boolean.valueOf(foldable);
        this.iconRes = iconRes;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(finished);
        this.coins = Integer.valueOf(coins);
        this.money = Integer.valueOf(money);
        this.authShow = Boolean.valueOf(authShow);
        this.icon = icon;
        this.wxAppid = wxAppid;
        this.miniProgramId = miniProgramId;
        this.jumpUrl = jumpUrl;
        this.bonusStr = bonusString;
    }

    public MissionItem(int type, String title, String desc, String buttonText, boolean foldable, int iconRes, boolean finished, int coins, int money, int bookCoins, boolean authShow, boolean diractForward) {
        this.diractForward = true;
        Boolean bool = Boolean.FALSE;
        this.hide = bool;
        this.exposed = false;
        this.type = Integer.valueOf(type);
        this.title = title;
        this.desc = desc;
        this.buttonText = buttonText;
        this.foldable = Boolean.valueOf(foldable);
        this.iconRes = iconRes;
        this.isHintOpened = bool;
        this.finished = Boolean.valueOf(finished);
        this.coins = Integer.valueOf(coins);
        this.money = Integer.valueOf(money);
        this.bookCoins = Integer.valueOf(bookCoins);
        this.authShow = Boolean.valueOf(authShow);
        this.diractForward = diractForward;
    }
}
