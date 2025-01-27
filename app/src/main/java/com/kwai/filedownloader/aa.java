package com.kwai.filedownloader;

import com.kwai.filedownloader.a;
import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.message.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class aa implements e.b {
    private static boolean a(List<a.InterfaceC0236a> list, MessageSnapshot messageSnapshot) {
        if (list.size() > 1 && messageSnapshot.Gq() == -3) {
            Iterator<a.InterfaceC0236a> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().Gz().c(messageSnapshot)) {
                    return true;
                }
            }
        }
        Iterator<a.InterfaceC0236a> it2 = list.iterator();
        while (it2.hasNext()) {
            if (it2.next().Gz().b(messageSnapshot)) {
                return true;
            }
        }
        if (-4 == messageSnapshot.Gq()) {
            Iterator<a.InterfaceC0236a> it3 = list.iterator();
            while (it3.hasNext()) {
                if (it3.next().Gz().d(messageSnapshot)) {
                    return true;
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0).Gz().a(messageSnapshot);
        }
        return false;
    }

    @Override // com.kwai.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        synchronized (Integer.toString(messageSnapshot.getId()).intern()) {
            List<a.InterfaceC0236a> cy = h.GW().cy(messageSnapshot.getId());
            if (cy.size() > 0) {
                a Gy = cy.get(0).Gy();
                if (com.kwai.filedownloader.e.d.aJq) {
                    com.kwai.filedownloader.e.d.g(this, "~~~callback %s old[%s] new[%s] %d", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(Gy.Gq()), Byte.valueOf(messageSnapshot.Gq()), Integer.valueOf(cy.size()));
                }
                if (!a(cy, messageSnapshot)) {
                    StringBuilder sb = new StringBuilder("The event isn't consumed, id:" + messageSnapshot.getId() + " status:" + ((int) messageSnapshot.Gq()) + " task-count:" + cy.size());
                    for (a.InterfaceC0236a interfaceC0236a : cy) {
                        sb.append(" | ");
                        sb.append((int) interfaceC0236a.Gy().Gq());
                    }
                    com.kwai.filedownloader.e.d.f(this, sb.toString(), new Object[0]);
                }
            } else {
                com.kwai.filedownloader.e.d.f(this, "Receive the event %d, but there isn't any running task in the upper layer", Byte.valueOf(messageSnapshot.Gq()));
            }
        }
    }
}
