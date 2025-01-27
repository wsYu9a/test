package com.alipay.sdk.m.j;

import androidx.media3.common.PlaybackException;

/* loaded from: classes.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(PlaybackException.ERROR_CODE_DRM_PROVISIONING_FAILED, "网络连接异常"),
    ACTIVITY_NOT_START_EXIT(PlaybackException.ERROR_CODE_DRM_DEVICE_REVOKED, "支付未完成"),
    PARAMS_ERROR(4001, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");


    /* renamed from: a, reason: collision with root package name */
    public int f6557a;

    /* renamed from: b, reason: collision with root package name */
    public String f6558b;

    c(int i10, String str) {
        this.f6557a = i10;
        this.f6558b = str;
    }

    public void a(int i10) {
        this.f6557a = i10;
    }

    public int b() {
        return this.f6557a;
    }

    public static c b(int i10) {
        return i10 != 4001 ? i10 != 5000 ? i10 != 8000 ? i10 != 9000 ? i10 != 6001 ? i10 != 6002 ? FAILED : NETWORK_ERROR : CANCELED : SUCCEEDED : PAY_WAITTING : DOUBLE_REQUEST : PARAMS_ERROR;
    }

    public void a(String str) {
        this.f6558b = str;
    }

    public String a() {
        return this.f6558b;
    }
}
