package com.alimm.tanx.core.ad.bean;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class MediaRenderingMode extends BaseBean {

    @JSONField(name = "ad_color")
    private String adColor;

    @JSONField(name = "ad_size")
    private String adSize;

    @JSONField(name = "adv_color")
    private String advColor;

    @JSONField(name = "adv_size")
    private String advSize;

    @JSONField(name = "bg_color")
    private String bgColor;

    @JSONField(name = "pic_radius")
    private String picRadius;

    @JSONField(serialize = false)
    private String serverTitleSize;

    @JSONField(name = "title_color")
    private String titleColor;

    @JSONField(name = "title_size")
    private String titleSize;

    public MediaRenderingMode() {
    }

    private int dp2px(Context context, float f10) {
        return (int) ((f10 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public String getAdColor() {
        return this.adColor;
    }

    public String getAdSize() {
        return this.adSize;
    }

    public int getAdSize2Int() {
        try {
            return !TextUtils.isEmpty(this.adSize) ? Integer.parseInt(this.adSize) : Integer.parseInt("5");
        } catch (Exception e10) {
            LogUtils.e(e10);
            return -1;
        }
    }

    public String getAdvColor() {
        return this.advColor;
    }

    public String getAdvSize() {
        return this.advSize;
    }

    public int getAdvSize2Int() {
        try {
            return !TextUtils.isEmpty(this.advSize) ? Integer.parseInt(this.advSize) : Integer.parseInt("5");
        } catch (Exception e10) {
            LogUtils.e(e10);
            return -1;
        }
    }

    public String getBgColor() {
        return this.bgColor;
    }

    public String getPicRadius() {
        return this.picRadius;
    }

    public int getPicRadius2Int(Context context) {
        int i10 = -1;
        try {
            i10 = Integer.parseInt("4");
            if (!TextUtils.isEmpty(this.picRadius)) {
                i10 = Integer.parseInt(this.picRadius);
            }
            return dp2px(context, i10);
        } catch (Exception e10) {
            LogUtils.e(e10);
            return i10;
        }
    }

    public String getServerTitleSize() {
        return this.serverTitleSize;
    }

    public String getTitleColor() {
        return this.titleColor;
    }

    public String getTitleSize() {
        return this.titleSize;
    }

    public int getTitleSize2Int() {
        try {
            return !TextUtils.isEmpty(this.titleSize) ? Integer.parseInt(this.titleSize) : Integer.parseInt("8");
        } catch (Exception e10) {
            LogUtils.e(e10);
            return -1;
        }
    }

    public void setAdColor(String str) {
        this.adColor = str;
    }

    public void setAdSize(String str) {
        this.adSize = str;
    }

    public void setAdvColor(String str) {
        this.advColor = str;
    }

    public void setAdvSize(String str) {
        this.advSize = str;
    }

    public void setBgColor(String str) {
        this.bgColor = str;
    }

    public void setPicRadius(String str) {
        this.picRadius = str;
    }

    public void setServerTitleSize(String str) {
        this.serverTitleSize = str;
    }

    public void setTitleColor(String str) {
        this.titleColor = str;
    }

    public void setTitleSize(String str) {
        this.titleSize = str;
    }

    public String toString() {
        return "MediaRenderingMode{titleSize='" + this.titleSize + "', serverTitleSize='" + this.serverTitleSize + "', titleColor='" + this.titleColor + "', adSize='" + this.adSize + "', adColor='" + this.adColor + "', advSize='" + this.advSize + "', advColor='" + this.advColor + "', bgColor='" + this.bgColor + "', picRadius='" + this.picRadius + "'} " + super.toString();
    }

    public MediaRenderingMode(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.titleSize = str;
        this.titleColor = str2;
        this.adSize = str3;
        this.adColor = str4;
        this.advSize = str5;
        this.advColor = str6;
        this.bgColor = str7;
        this.picRadius = str8;
    }
}
