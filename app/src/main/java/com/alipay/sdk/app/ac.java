package com.alipay.sdk.app;

import com.qq.e.comm.constants.ErrorCode;
import com.vivo.google.android.exoplayer3.DefaultLoadControl;

/* loaded from: classes.dex */
public enum ac {
    SUCCEEDED(ErrorCode.PrivateError.LOAD_TIME_OUT, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, "参数错误"),
    PAY_WAITTING(DefaultLoadControl.DEFAULT_MAX_BUFFER_MS, "支付结果确认中");


    /* renamed from: g, reason: collision with root package name */
    private int f5302g;

    /* renamed from: h, reason: collision with root package name */
    private String f5303h;

    ac(int i2, String str) {
        this.f5302g = i2;
        this.f5303h = str;
    }

    public static ac a(int i2) {
        return i2 != 4001 ? i2 != 8000 ? i2 != 9000 ? i2 != 6001 ? i2 != 6002 ? FAILED : NETWORK_ERROR : CANCELED : SUCCEEDED : PAY_WAITTING : PARAMS_ERROR;
    }

    private void a(String str) {
        this.f5303h = str;
    }

    private void b(int i2) {
        this.f5302g = i2;
    }

    public final int a() {
        return this.f5302g;
    }

    public final String b() {
        return this.f5303h;
    }
}
