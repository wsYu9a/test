package com.sntech.ads;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;

@Keep
/* loaded from: classes4.dex */
public class AdCode {

    /* renamed from: id */
    @SerializedName("id")
    private String f20931id;

    @SerializedName("level")
    private int level;

    @SerializedName("platform")
    private String platform;

    @SerializedName("price")
    private double price;

    public AdCode(String str, String str2, double d10) {
        this.f20931id = str;
        this.platform = str2;
        this.price = d10;
    }

    @Keep
    public String getId() {
        return this.f20931id;
    }

    @Keep
    public int getLevel() {
        return this.level;
    }

    @Keep
    public String getPlatform() {
        return this.platform;
    }

    @Keep
    public double getPrice() {
        return this.price;
    }

    @Keep
    public void setLevel(int i10) {
        this.level = i10;
    }
}
