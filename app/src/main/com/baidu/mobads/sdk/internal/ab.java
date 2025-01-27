package com.baidu.mobads.sdk.internal;

/* loaded from: classes2.dex */
class ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ aa f6702a;

    public ab(aa aaVar) {
        this.f6702a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6702a.a("加载dex超过5秒");
    }
}
