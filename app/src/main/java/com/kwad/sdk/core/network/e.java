package com.kwad.sdk.core.network;

import androidx.media3.session.SessionCommand;

/* loaded from: classes3.dex */
public final class e {
    public final int errorCode;
    public final String msg;
    public static e azv = new e(-1, "请求超时事件");
    public static e azw = new e(-2, "请求异常");
    public static e azx = new e(-1000, "该业务组件未加载");
    public static e azy = new e(40001, "网络错误");
    public static e azz = new e(40002, "数据解析错误");
    public static e azA = new e(40003, "数据为空");
    public static e azB = new e(40004, "视频资源缓存失败");
    public static e azC = new e(40005, "网络超时");
    public static e azD = new e(40007, "图片下载失败");
    public static e azE = new e(40008, "广告场景不匹配");
    public static e azF = new e(40009, "广告加载异常");
    public static e azG = new e(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, "activity场景不匹配");
    public static e azH = new e(40011, "sdk初始化失败");
    public static e azI = new e(40012, "权限未开启");
    public static e azJ = new e(40013, "SDK未调用start方法");
    public static e azK = new e(100006, "更多视频请前往快手App查看");
    public static e azL = new e(100007, "复制链接失败，请稍后重试");
    public static e azM = new e(100008, "内容有点敏感，不可以发送哦");
    public static e azN = new e(130001, "数据不存在");
    public static e azO = new e(0, "网络超时");

    private e(int i10, String str) {
        this.errorCode = i10;
        this.msg = str;
    }
}
