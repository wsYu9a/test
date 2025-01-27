package com.sigmob.sdk.base.mta;

/* loaded from: classes4.dex */
public class PointEntityActive extends PointEntitySigmobSuper {

    /* renamed from: a */
    public String f18263a;

    /* renamed from: b */
    public String f18264b;

    /* renamed from: c */
    public String f18265c;

    /* renamed from: d */
    public String f18266d;

    public static PointEntityActive ActiveTracking(String str, String str2, String str3, String str4) {
        PointEntityActive pointEntityActive = new PointEntityActive();
        pointEntityActive.setAc_type(PointType.WIND_ACTIVE);
        pointEntityActive.setCategory(str);
        pointEntityActive.setActive_id(str2);
        pointEntityActive.setDuration(str3);
        pointEntityActive.setTimestamp(str4);
        pointEntityActive.commit();
        return pointEntityActive;
    }

    public String getActive_id() {
        return this.f18263a;
    }

    public String getDuration() {
        return this.f18266d;
    }

    public String getRequest_id() {
        return this.f18264b;
    }

    public String getVid() {
        return this.f18265c;
    }

    public void setActive_id(String str) {
        this.f18263a = str;
    }

    public void setDuration(String str) {
        this.f18266d = str;
    }

    public void setRequest_id(String str) {
        this.f18264b = str;
    }

    public void setVid(String str) {
        this.f18265c = str;
    }
}
