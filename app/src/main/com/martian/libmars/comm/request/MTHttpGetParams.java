package com.martian.libmars.comm.request;

import com.martian.libcomm.http.requests.HttpGetParams;
import com.martian.libmars.common.ConfigSingleton;
import u8.c;
import v8.a;

/* loaded from: classes3.dex */
public abstract class MTHttpGetParams extends HttpGetParams {
    public static long diffServerTime;

    @a
    private String android_id;

    @a
    private String appid;

    @a
    private String brand;

    @a
    private final String channel;

    @a
    private String device_id;

    @a
    private String imei;

    @a
    private String model;

    @a
    private String oaid;

    @a
    private Integer optype;

    @a
    private final Integer ostype;

    @a
    private String osversion;

    @a
    private final String package_name;

    /* renamed from: t */
    @a
    private long f12076t;

    @a
    private String token;

    @a
    private Long uid;

    @a
    private final Integer version_code;

    @a
    private final String version_name;

    public MTHttpGetParams(c cVar) {
        super(cVar);
        this.appid = ConfigSingleton.D().l().f26178a;
        this.device_id = ConfigSingleton.D().y();
        this.f12076t = System.currentTimeMillis() + diffServerTime;
        this.version_code = Integer.valueOf(ConfigSingleton.D().o0());
        this.version_name = ConfigSingleton.D().p0();
        this.package_name = ConfigSingleton.D().getPackageName();
        this.channel = ConfigSingleton.D().r();
        this.ostype = 0;
        if (ConfigSingleton.D().y0() || !ConfigSingleton.D().V0()) {
            return;
        }
        this.model = ConfigSingleton.D().K();
        this.brand = ConfigSingleton.D().o();
        this.osversion = ConfigSingleton.D().k();
        this.optype = Integer.valueOf(ConfigSingleton.D().P());
    }

    private void setT(long j10) {
        this.f12076t = j10;
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
        return this.f12076t;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUid() {
        return this.uid;
    }

    public void initTime() {
        this.f12076t = System.currentTimeMillis() + diffServerTime;
    }

    public void setAndroid_id(String str) {
        this.android_id = str;
    }

    public void setAppid(String str) {
        this.appid = str;
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
