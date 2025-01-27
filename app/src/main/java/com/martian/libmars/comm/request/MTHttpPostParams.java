package com.martian.libmars.comm.request;

import com.martian.libcomm.http.requests.HttpPostParams;
import com.martian.libcomm.http.requests.c;
import com.martian.libcomm.http.requests.d.a;
import com.martian.libmars.d.h;

/* loaded from: classes.dex */
public abstract class MTHttpPostParams extends HttpPostParams {
    public static long diffServerTime;

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

    @a
    private long t;

    @a
    private String token;

    @a
    private Long uid;

    @a
    private final Integer version_code;

    @a
    private final String version_name;

    public MTHttpPostParams(c provider) {
        super(provider);
        this.appid = h.F().f().f9879a;
        this.device_id = h.F().t();
        this.model = h.F().S();
        this.brand = h.F().j();
        this.osversion = h.F().e();
        this.t = System.currentTimeMillis() + diffServerTime;
        this.version_code = Integer.valueOf(h.F().w0());
        this.version_name = h.F().x0();
        this.package_name = h.F().getPackageName();
        this.channel = h.F().m();
        this.ostype = 0;
        this.optype = Integer.valueOf(h.F().X());
    }

    private void setAppid(String appid) {
        this.appid = appid;
    }

    private void setT(long t) {
        this.t = t;
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
        return this.t;
    }

    public String getToken() {
        return this.token;
    }

    public Long getUid() {
        return this.uid;
    }

    public void initTime() {
        this.t = System.currentTimeMillis() + diffServerTime;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setOaid(String oaid) {
        this.oaid = oaid;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
