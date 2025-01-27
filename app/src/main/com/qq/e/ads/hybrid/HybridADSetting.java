package com.qq.e.ads.hybrid;

/* loaded from: classes3.dex */
public class HybridADSetting {
    public static final int TYPE_REWARD_VIDEO = 1;

    /* renamed from: f, reason: collision with root package name */
    private String f16436f;

    /* renamed from: g, reason: collision with root package name */
    private String f16437g;

    /* renamed from: h, reason: collision with root package name */
    private String f16438h;

    /* renamed from: a, reason: collision with root package name */
    private int f16431a = 1;

    /* renamed from: b, reason: collision with root package name */
    private int f16432b = 44;

    /* renamed from: c, reason: collision with root package name */
    private int f16433c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f16434d = -14013133;

    /* renamed from: e, reason: collision with root package name */
    private int f16435e = 16;

    /* renamed from: i, reason: collision with root package name */
    private int f16439i = -1776153;

    /* renamed from: j, reason: collision with root package name */
    private int f16440j = 16;

    public HybridADSetting backButtonImage(String str) {
        this.f16437g = str;
        return this;
    }

    public HybridADSetting backSeparatorLength(int i10) {
        this.f16440j = i10;
        return this;
    }

    public HybridADSetting closeButtonImage(String str) {
        this.f16438h = str;
        return this;
    }

    public String getBackButtonImage() {
        return this.f16437g;
    }

    public int getBackSeparatorLength() {
        return this.f16440j;
    }

    public String getCloseButtonImage() {
        return this.f16438h;
    }

    public int getSeparatorColor() {
        return this.f16439i;
    }

    public String getTitle() {
        return this.f16436f;
    }

    public int getTitleBarColor() {
        return this.f16433c;
    }

    public int getTitleBarHeight() {
        return this.f16432b;
    }

    public int getTitleColor() {
        return this.f16434d;
    }

    public int getTitleSize() {
        return this.f16435e;
    }

    public int getType() {
        return this.f16431a;
    }

    public HybridADSetting separatorColor(int i10) {
        this.f16439i = i10;
        return this;
    }

    public HybridADSetting title(String str) {
        this.f16436f = str;
        return this;
    }

    public HybridADSetting titleBarColor(int i10) {
        this.f16433c = i10;
        return this;
    }

    public HybridADSetting titleBarHeight(int i10) {
        this.f16432b = i10;
        return this;
    }

    public HybridADSetting titleColor(int i10) {
        this.f16434d = i10;
        return this;
    }

    public HybridADSetting titleSize(int i10) {
        this.f16435e = i10;
        return this;
    }

    public HybridADSetting type(int i10) {
        this.f16431a = i10;
        return this;
    }
}
