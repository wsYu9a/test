package com.martian.mibook.data;

import com.martian.libsupport.k;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.account.MiUserManager;

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
        return k.p(this.content) ? MiUserManager.u() : this.content;
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
        return k.p(this.title) ? s2.m() : this.title;
    }

    public String getUrl() {
        return k.p(this.url) ? (this.shareType.intValue() == 1 || this.shareType.intValue() == 2) ? MiConfigSingleton.V3().W3().getInviteShareLink() : MiConfigSingleton.V3().W3().getPhoneInviteShareLink() : this.url;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeLeft(Integer codeLeft) {
        this.codeLeft = codeLeft;
    }

    public void setCodeTextColor(String codeTextColor) {
        this.codeTextColor = codeTextColor;
    }

    public void setCodeTextSize(Integer codeTextSize) {
        this.codeTextSize = codeTextSize;
    }

    public void setCodeTop(Integer codeTop) {
        this.codeTop = codeTop;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setQrcodeHeight(Integer qrcodeHeight) {
        this.qrcodeHeight = qrcodeHeight;
    }

    public void setQrcodeLeft(Integer qrcodeLeft) {
        this.qrcodeLeft = qrcodeLeft;
    }

    public void setQrcodeTop(Integer qrcodeTop) {
        this.qrcodeTop = qrcodeTop;
    }

    public void setQrcodeWidth(Integer qrcodeWidth) {
        this.qrcodeWidth = qrcodeWidth;
    }

    public void setShareType(Integer shareType) {
        this.shareType = shareType;
    }

    public void setStag(String stag) {
        this.stag = stag;
    }

    public void setStyle(Integer style) {
        this.style = style;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
