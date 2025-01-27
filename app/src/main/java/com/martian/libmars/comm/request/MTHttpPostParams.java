package com.martian.libmars.comm.request;

import com.martian.libcomm.http.requests.HttpPostParams;
import com.martian.libmars.common.ConfigSingleton;
import u8.c;
import v8.a;

/* loaded from: classes3.dex */
public abstract class MTHttpPostParams extends HttpPostParams {
    public static long diffServerTime;

    @a
    private String android_id;

    @a
    private String appid;

    @a
    private final String brand;

    @a
    private final String channel;

    @a
    private String device_id;

    @a
    private String imei;

    @a
    private final String model;

    @a
    private String oaid;

    @a
    private final Integer optype;

    @a
    private final Integer ostype;

    @a
    private final String osversion;

    @a
    private final String package_name;

    /* renamed from: t */
    @a
    private long f12077t;

    @a
    private String token;

    @a
    private Long uid;

    @a
    private final Integer version_code;

    @a
    private final String version_name;

    public MTHttpPostParams(c cVar) {
        super(cVar);
        this.appid = ConfigSingleton.D().l().f26178a;
        this.device_id = ConfigSingleton.D().y();
        this.model = ConfigSingleton.D().K();
        this.brand = ConfigSingleton.D().o();
        this.osversion = ConfigSingleton.D().k();
        this.f12077t = System.currentTimeMillis() + diffServerTime;
        this.version_code = Integer.valueOf(ConfigSingleton.D().o0());
        this.version_name = ConfigSingleton.D().p0();
        this.package_name = ConfigSingleton.D().getPackageName();
        this.channel = ConfigSingleton.D().r();
        this.ostype = 0;
        this.optype = Integer.valueOf(ConfigSingleton.D().P());
    }

    private void setAppid(String str) {
        this.appid = str;
    }

    private void setT(long j10) {
        this.f12077t = j10;
    }

    public String getAndroid_id() {
        return this.android_id;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getDevice_id() {
        return this.device_id;
    }

    public String getOaid() {
        return this.oaid;
    }

    public long getT() {
        return this.f12077t;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUid() {
        return this.uid;
    }

    public void initTime() {
        this.f12077t = System.currentTimeMillis() + diffServerTime;
    }

    public void setAndroid_id(String str) {
        this.android_id = str;
    }

    public void setDevice_id(String str) {
        this.device_id = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public void setUid(Long l10) {
        this.uid = l10;
    }
}
