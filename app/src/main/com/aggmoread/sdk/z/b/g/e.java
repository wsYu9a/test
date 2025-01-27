package com.aggmoread.sdk.z.b.g;

import androidx.media3.session.SessionCommand;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f4493c = new e(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, "容器已销毁！");

    /* renamed from: d, reason: collision with root package name */
    public static final e f4494d = new e(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, "未指定广告容器！");

    /* renamed from: e, reason: collision with root package name */
    public static final e f4495e = new e(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, "图片加载失败！");

    /* renamed from: f, reason: collision with root package name */
    public static final e f4496f = new e(50007, "图片加载失败！");

    /* renamed from: g, reason: collision with root package name */
    public static final e f4497g = new e(50008, "activity is null！");

    /* renamed from: h, reason: collision with root package name */
    public static final e f4498h = new e(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, "广告未初始化！");

    /* renamed from: a, reason: collision with root package name */
    private int f4499a;

    /* renamed from: b, reason: collision with root package name */
    private String f4500b;

    public e(int i10, String str) {
        this.f4499a = i10;
        this.f4500b = str;
    }

    public int a() {
        return this.f4499a;
    }

    public String b() {
        return this.f4500b;
    }

    public String toString() {
        return "JuHeApiError{errorCode=" + this.f4499a + ", errorMessage='" + this.f4500b + "'}";
    }
}
