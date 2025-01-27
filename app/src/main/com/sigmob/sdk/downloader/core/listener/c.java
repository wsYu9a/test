package com.sigmob.sdk.downloader.core.listener;

import com.sigmob.sdk.downloader.core.listener.assist.a;

/* loaded from: classes4.dex */
public abstract class c extends com.sigmob.sdk.downloader.core.listener.a {

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f19345a;

        static {
            int[] iArr = new int[com.sigmob.sdk.downloader.core.cause.a.values().length];
            f19345a = iArr;
            try {
                iArr[com.sigmob.sdk.downloader.core.cause.a.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19345a[com.sigmob.sdk.downloader.core.cause.a.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19345a[com.sigmob.sdk.downloader.core.cause.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19345a[com.sigmob.sdk.downloader.core.cause.a.PRE_ALLOCATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f19345a[com.sigmob.sdk.downloader.core.cause.a.FILE_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f19345a[com.sigmob.sdk.downloader.core.cause.a.SAME_TASK_BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0590a
    public void a(com.sigmob.sdk.downloader.f fVar, com.sigmob.sdk.downloader.core.cause.a aVar, Exception exc, a.b bVar) {
        switch (a.f19345a[aVar.ordinal()]) {
            case 1:
                c(fVar);
                break;
            case 2:
                b(fVar);
                break;
            case 3:
            case 4:
                a(fVar, exc);
                break;
            case 5:
            case 6:
                e(fVar);
                break;
            default:
                com.sigmob.sdk.downloader.core.c.c("DownloadListener3", "Don't support " + aVar);
                break;
        }
    }

    public abstract void a(com.sigmob.sdk.downloader.f fVar, Exception exc);

    public abstract void b(com.sigmob.sdk.downloader.f fVar);

    public abstract void c(com.sigmob.sdk.downloader.f fVar);

    public abstract void d(com.sigmob.sdk.downloader.f fVar);

    public abstract void e(com.sigmob.sdk.downloader.f fVar);

    @Override // com.sigmob.sdk.downloader.core.listener.assist.a.InterfaceC0590a
    public final void a(com.sigmob.sdk.downloader.f fVar, a.b bVar) {
        d(fVar);
    }
}
