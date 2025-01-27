package com.kwad.framework.filedownloader.message;

import com.kwad.framework.filedownloader.download.d;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.a;
import com.kwad.framework.filedownloader.message.d;
import com.kwad.framework.filedownloader.message.h;
import java.io.File;

/* loaded from: classes3.dex */
public class f {
    public static MessageSnapshot a(int i10, File file, boolean z10) {
        long length = file.length();
        return length > 2147483647L ? z10 ? new d.a(i10, true, length) : new d.b(i10, true, length) : z10 ? new h.a(i10, true, (int) length) : new h.b(i10, true, (int) length);
    }

    public static MessageSnapshot e(com.kwad.framework.filedownloader.a aVar) {
        return aVar.vj() ? new d.e(aVar.getId(), aVar.vb(), aVar.vc()) : new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.vd() == -3) {
            return new a.C0469a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.vd())));
    }

    public static MessageSnapshot a(int i10, long j10, long j11, boolean z10) {
        if (j11 > 2147483647L) {
            if (z10) {
                return new d.i(i10, j10, j11);
            }
            return new d.j(i10, j10, j11);
        }
        if (z10) {
            return new h.i(i10, (int) j10, (int) j11);
        }
        return new h.j(i10, (int) j10, (int) j11);
    }

    public static MessageSnapshot a(int i10, long j10, Throwable th2) {
        if (j10 > 2147483647L) {
            return new d.C0470d(i10, j10, th2);
        }
        return new h.d(i10, (int) j10, th2);
    }

    public static MessageSnapshot a(byte b10, com.kwad.framework.filedownloader.d.c cVar, d.a aVar) {
        MessageSnapshot dVar;
        MessageSnapshot cVar2;
        IllegalStateException illegalStateException;
        int id2 = cVar.getId();
        if (b10 == -4) {
            throw new IllegalStateException(com.kwad.framework.filedownloader.f.f.b("please use #catchWarn instead %d", Integer.valueOf(id2)));
        }
        if (b10 == -3) {
            if (cVar.vj()) {
                return new d.b(id2, false, cVar.getTotal());
            }
            return new h.b(id2, false, (int) cVar.getTotal());
        }
        if (b10 != -1) {
            if (b10 == 1) {
                if (cVar.vj()) {
                    return new d.f(id2, cVar.xt(), cVar.getTotal());
                }
                return new h.f(id2, (int) cVar.xt(), (int) cVar.getTotal());
            }
            if (b10 == 2) {
                String filename = cVar.uZ() ? cVar.getFilename() : null;
                if (cVar.vj()) {
                    cVar2 = new d.c(id2, aVar.wY(), cVar.getTotal(), cVar.xu(), filename);
                } else {
                    cVar2 = new h.c(id2, aVar.wY(), (int) cVar.getTotal(), cVar.xu(), filename);
                }
                return cVar2;
            }
            if (b10 == 3) {
                if (cVar.vj()) {
                    return new d.g(id2, cVar.xt());
                }
                return new h.g(id2, (int) cVar.xt());
            }
            if (b10 != 5) {
                if (b10 != 6) {
                    String b11 = com.kwad.framework.filedownloader.f.f.b("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b10));
                    com.kwad.framework.filedownloader.f.d.d(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b10));
                    if (aVar.getException() != null) {
                        illegalStateException = new IllegalStateException(b11, aVar.getException());
                    } else {
                        illegalStateException = new IllegalStateException(b11);
                    }
                    if (cVar.vj()) {
                        return new d.C0470d(id2, cVar.xt(), illegalStateException);
                    }
                    return new h.d(id2, (int) cVar.xt(), illegalStateException);
                }
                return new MessageSnapshot.b(id2);
            }
            if (cVar.vj()) {
                dVar = new d.h(id2, cVar.xt(), aVar.getException(), aVar.vh());
            } else {
                dVar = new h.C0471h(id2, (int) cVar.xt(), aVar.getException(), aVar.vh());
            }
        } else if (cVar.vj()) {
            dVar = new d.C0470d(id2, cVar.xt(), aVar.getException());
        } else {
            dVar = new h.d(id2, (int) cVar.xt(), aVar.getException());
        }
        return dVar;
    }
}
