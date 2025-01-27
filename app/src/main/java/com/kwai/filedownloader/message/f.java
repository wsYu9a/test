package com.kwai.filedownloader.message;

import com.kwai.filedownloader.download.d;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.a;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
import java.io.File;

/* loaded from: classes2.dex */
public class f {
    public static MessageSnapshot a(byte b2, com.kwai.filedownloader.c.c cVar, d.a aVar) {
        MessageSnapshot c0244d;
        int id = cVar.getId();
        if (b2 == -4) {
            throw new IllegalStateException(com.kwai.filedownloader.e.f.j("please use #catchWarn instead %d", Integer.valueOf(id)));
        }
        if (b2 == -3) {
            return cVar.Gw() ? new d.b(id, false, cVar.getTotal()) : new h.b(id, false, (int) cVar.getTotal());
        }
        if (b2 == -1) {
            c0244d = cVar.Gw() ? new d.C0244d(id, cVar.IB(), aVar.getException()) : new h.d(id, (int) cVar.IB(), aVar.getException());
        } else {
            if (b2 == 1) {
                return cVar.Gw() ? new d.f(id, cVar.IB(), cVar.getTotal()) : new h.f(id, (int) cVar.IB(), (int) cVar.getTotal());
            }
            if (b2 == 2) {
                String filename = cVar.Gm() ? cVar.getFilename() : null;
                return cVar.Gw() ? new d.c(id, aVar.Ig(), cVar.getTotal(), cVar.IC(), filename) : new h.c(id, aVar.Ig(), (int) cVar.getTotal(), cVar.IC(), filename);
            }
            if (b2 == 3) {
                return cVar.Gw() ? new d.g(id, cVar.IB()) : new h.g(id, (int) cVar.IB());
            }
            if (b2 != 5) {
                if (b2 == 6) {
                    return new MessageSnapshot.b(id);
                }
                String j2 = com.kwai.filedownloader.e.f.j("it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                com.kwai.filedownloader.e.d.h(f.class, "it can't takes a snapshot for the task(%s) when its status is %d,", cVar, Byte.valueOf(b2));
                IllegalStateException illegalStateException = aVar.getException() != null ? new IllegalStateException(j2, aVar.getException()) : new IllegalStateException(j2);
                return cVar.Gw() ? new d.C0244d(id, cVar.IB(), illegalStateException) : new h.d(id, (int) cVar.IB(), illegalStateException);
            }
            c0244d = cVar.Gw() ? new d.h(id, cVar.IB(), aVar.getException(), aVar.Gu()) : new h.C0245h(id, (int) cVar.IB(), aVar.getException(), aVar.Gu());
        }
        return c0244d;
    }

    public static MessageSnapshot a(int i2, long j2, long j3, boolean z) {
        return j3 > 2147483647L ? z ? new d.i(i2, j2, j3) : new d.j(i2, j2, j3) : z ? new h.i(i2, (int) j2, (int) j3) : new h.j(i2, (int) j2, (int) j3);
    }

    public static MessageSnapshot a(int i2, long j2, Throwable th) {
        return j2 > 2147483647L ? new d.C0244d(i2, j2, th) : new h.d(i2, (int) j2, th);
    }

    public static MessageSnapshot a(int i2, File file, boolean z) {
        long length = file.length();
        return length > 2147483647L ? z ? new d.a(i2, true, length) : new d.b(i2, true, length) : z ? new h.a(i2, true, (int) length) : new h.b(i2, true, (int) length);
    }

    public static MessageSnapshot e(com.kwai.filedownloader.a aVar) {
        return aVar.Gw() ? new d.e(aVar.getId(), aVar.Go(), aVar.Gp()) : new h.e(aVar.getId(), aVar.getSmallFileSoFarBytes(), aVar.getSmallFileTotalBytes());
    }

    public static MessageSnapshot t(MessageSnapshot messageSnapshot) {
        if (messageSnapshot.Gq() == -3) {
            return new a.C0243a(messageSnapshot);
        }
        throw new IllegalStateException(com.kwai.filedownloader.e.f.j("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq())));
    }
}
