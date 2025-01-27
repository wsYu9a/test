package com.umeng.analytics.pro;

import com.qq.e.comm.constants.ErrorCode;

/* loaded from: classes4.dex */
public enum bz {
    UnKnownCode(5000),
    Timeout(5001),
    NetworkUnavailable(5002),
    SSLException(ErrorCode.VIDEO_PLAY_ERROR),
    IOException(ErrorCode.NO_AD_FILL),
    UnKnownHostException(ErrorCode.TRAFFIC_CONTROL_DAY),
    HttpError(ErrorCode.PACKAGE_NAME_ERROR),
    EmptyResponse(ErrorCode.RESOURCE_LOAD_ERROR),
    ErrorResponse(ErrorCode.IMAGE_LOAD_ERROR),
    ErrorMakeRequestBody(ErrorCode.TRAFFIC_CONTROL_HOUR);


    /* renamed from: k */
    private final int f23712k;

    bz(int i10) {
        this.f23712k = i10;
    }

    private String b() {
        return "错误码：" + this.f23712k + " 错误信息：";
    }

    public String a() {
        if (this == UnKnownCode) {
            return b() + "--未知错误--";
        }
        if (this == Timeout) {
            return b() + "--连接超时--";
        }
        if (this == NetworkUnavailable) {
            return b() + "--网络不可用--";
        }
        if (this == SSLException) {
            return b() + "--SSL证书认证失败--";
        }
        if (this == IOException) {
            return b() + "--IO异常--";
        }
        if (this == HttpError) {
            return b() + "--服务端返回HTTP错误--";
        }
        if (this == EmptyResponse) {
            return b() + "--服务端返回数据为空--";
        }
        if (this == ErrorResponse) {
            return b() + "--服务端返回错误数据--";
        }
        if (this != ErrorMakeRequestBody) {
            return "unknown";
        }
        return b() + "--请求报文构建错误--";
    }
}
