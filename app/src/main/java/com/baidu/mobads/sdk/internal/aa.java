package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ z f5494a;

    aa(z zVar) {
        this.f5494a = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5494a.a("加载dex超过5秒");
    }
}
