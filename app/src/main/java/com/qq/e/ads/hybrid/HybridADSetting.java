package com.qq.e.ads.hybrid;

/* loaded from: classes4.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f */
    private String f23925f;

    /* renamed from: g */
    private String f23926g;

    /* renamed from: h */
    private String f23927h;

    /* renamed from: a */
    private int f23920a = 1;

    /* renamed from: b */
    private int f23921b = 44;

    /* renamed from: c */
    private int f23922c = -1;

    /* renamed from: d */
    private int f23923d = -14013133;

    /* renamed from: e */
    private int f23924e = 16;

    /* renamed from: i */
    private int f23928i = -1776153;

    /* renamed from: j */
    private int f23929j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f23926g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i2) {
        this.f23929j = i2;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f23927h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f23926g;
    }

    public int getBackSeparatorLength() {
        return this.f23929j;
    }

    public String getCloseButtonImage() {
        return this.f23927h;
    }

    public int getSeparatorColor() {
        return this.f23928i;
    }

    public String getTitle() {
        return this.f23925f;
    }

    public int getTitleBarColor() {
        return this.f23922c;
    }

    public int getTitleBarHeight() {
        return this.f23921b;
    }

    public int getTitleColor() {
        return this.f23923d;
    }

    public int getTitleSize() {
        return this.f23924e;
    }

    public int getType() {
        return this.f23920a;
    }

    public HybridADSetting separatorColor(int i2) {
        this.f23928i = i2;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f23925f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i2) {
        this.f23922c = i2;
        return this;
    }

    public HybridADSetting titleBarHeight(int i2) {
        this.f23921b = i2;
        return this;
    }

    public HybridADSetting titleColor(int i2) {
        this.f23923d = i2;
        return this;
    }

    public HybridADSetting titleSize(int i2) {
        this.f23924e = i2;
        return this;
    }

    public HybridADSetting type(int i2) {
        this.f23920a = i2;
        return this;
    }
}
