package com.martian.libsupport.permission;

import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private String f10643a;

    /* renamed from: b, reason: collision with root package name */
    private String f10644b;

    /* renamed from: c, reason: collision with root package name */
    private String f10645c;

    public e(@Nullable String permission, @Nullable String title, @Nullable String desc) {
        this.f10643a = permission;
        this.f10644b = title;
        this.f10645c = desc;
    }

    public String a() {
        return this.f10645c;
    }

    public String b() {
        return this.f10643a;
    }

    public String c() {
        return this.f10644b;
    }

    public void d(String desc) {
        this.f10645c = desc;
    }

    public void e(String permission) {
        this.f10643a = permission;
    }

    public void f(String title) {
        this.f10644b = title;
    }
}
