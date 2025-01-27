package com.kwad.sdk.core.a.kwai;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* loaded from: classes2.dex */
public final class dg {
    @InvokeBy(invokerClass = ev.class, methodId = "registerHolder")
    public static void vO() {
        ev.vP().put(com.kwad.sdk.crash.online.monitor.block.c.class, new bd());
        ev.vP().put(com.kwad.sdk.crash.online.monitor.kwai.a.class, new bb());
        ev.vP().put(AnrReason.class, new ap());
        ev.vP().put(BlockEvent.class, new bc());
        ev.vP().put(com.kwad.sdk.crash.online.monitor.kwai.b.class, new cz());
        ev.vP().put(com.kwad.sdk.crash.online.monitor.kwai.c.class, new fk());
        ev.vP().put(com.kwad.sdk.crash.a.class, new cc());
        ev.vP().put(BlockEvent.a.class, new iw());
    }
}
