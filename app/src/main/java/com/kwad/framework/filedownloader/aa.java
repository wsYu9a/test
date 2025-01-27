package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.a;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0462a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.vd() == -3) {
            Iterator<a.InterfaceC0462a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().vm().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0462a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().vm().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.vd()) {
            Iterator<a.InterfaceC0462a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().vm().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).vm().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            try {
                List<a.InterfaceC0462a> bb2 = h.vJ().bb(messageSnapshot.getId());
                if (bb2.size() > 0) {
                    a vl = bb2.get(0).vl();
                    if (com.kwad.framework.filedownloader.f.d.alt) {
                        com.kwad.framework.filedownloader.f.d.c(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(vl.vd()), Byte.valueOf(messageSnapshot.vd()), Integer.valueOf(bb2.size()));
                    }
                    if (!a(bb2, messageSnapshot)) {
                        StringBuilder sb2 = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.vd()) + " task-count:" + bb2.size());
                        for (a.InterfaceC0462a interfaceC0462a : bb2) {
                            sb2.append(" | ");
                            sb2.append((int) interfaceC0462a.vl().vd());
                        }
                        com.kwad.framework.filedownloader.f.d.b(this, sb2.toString(), new Object[0]);
                    }
                } else {
                    com.kwad.framework.filedownloader.f.d.b(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.vd()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
