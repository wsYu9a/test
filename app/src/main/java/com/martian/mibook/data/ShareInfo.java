package com.martian.mibook.data;

import ba.l;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import je.i;

/* loaded from: classes3.dex */
public class ShareInfo {
    private String code;
    private Integer codeLeft;
    private String codeTextColor;
    private Integer codeTextSize;
    private Integer codeTop;
    private String content;
    private String imageUrl;
    private Integer qrcodeHeight;
    private Integer qrcodeLeft;
    private Integer qrcodeTop;
    private Integer qrcodeWidth;
    private Integer shareType;
    private String stag;
    private Integer style;
    private String title;
    private String url;

    public String getCode() {
        return this.code;
    }

    public Integer getCodeLeft() {
        return this.codeLeft;
    }

    public String getCodeTextColor() {
        String str = this.codeTextColor;
        return str == null ? "#FFFFFF" : str;
    }

    public Integer getCodeTextSize() {
        Integer num = this.codeTextSize;
        if (num == null || num.intValue() <= 0) {
            return 22;
        }
        return this.codeTextSize;
    }

    public Integer getCodeTop() {
        Integer num = this.codeTop;
        if (num == null || num.intValue() <= 0) {
            return 224;
        }
        return this.codeTop;
    }

    public String getContent() {
        return l.q(this.content) ? MiUserManager.r() : this.content;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Integer getQrcodeHeight() {
        Integer num = this.qrcodeHeight;
        if (num == null || num.intValue() <= 0) {
            return 160;
        }
        return this.qrcodeHeight;
    }

    public Integer getQrcodeLeft() {
        return this.qrcodeLeft;
    }

    public Integer getQrcodeTop() {
        Integer num = this.qrcodeTop;
        if (num == null || num.intValue() <= 0) {
            return 364;
        }
        return this.qrcodeTop;
    }

    public Integer getQrcodeWidth() {
        Integer num = this.qrcodeWidth;
        if (num == null || num.intValue() <= 0) {
            return 160;
        }
        return this.qrcodeWidth;
    }

    public Integer getShareType() {
        return this.shareType;
    }

    public String getStag() {
        String str = this.stag;
        return str == null ? "邀请好友" : str;
    }

    public Integer getStyle() {
        Integer num = this.style;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public String getTitle() {
        return l.q(this.title) ? i.l() : this.title;
    }

    public String getUrl() {
        return l.q(this.url) ? (this.shareType.intValue() == 1 || this.shareType.intValue() == 2) ? MiConfigSingleton.b2().c2().getInviteShareLink() : MiConfigSingleton.b2().c2().getPhoneInviteShareLink() : this.url;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setCodeLeft(Integer num) {
        this.codeLeft = num;
    }

    public void setCodeTextColor(String str) {
        this.codeTextColor = str;
    }

    public void setCodeTextSize(Integer num) {
        this.codeTextSize = num;
    }

    public void setCodeTop(Integer num) {
        this.codeTop = num;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setQrcodeHeight(Integer num) {
        this.qrcodeHeight = num;
    }

    public void setQrcodeLeft(Integer num) {
        this.qrcodeLeft = num;
    }

    public void setQrcodeTop(Integer num) {
        this.qrcodeTop = num;
    }

    public void setQrcodeWidth(Integer num) {
        this.qrcodeWidth = num;
    }

    public void setShareType(Integer num) {
        this.shareType = num;
    }

    public void setStag(String str) {
        this.stag = str;
    }

    public void setStyle(Integer num) {
        this.style = num;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
