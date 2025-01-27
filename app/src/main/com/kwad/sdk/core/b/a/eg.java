package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.crash.message.BackTraceElement;
import com.kwad.sdk.crash.message.Backtrace;
import com.kwad.sdk.crash.message.JavaBackTraceElement;
import com.kwad.sdk.crash.message.NativeBackTraceElement;
import com.kwad.sdk.crash.model.message.AnrReason;
import com.kwad.sdk.crash.online.monitor.block.BlockEvent;

/* loaded from: classes3.dex */
public final class eg {
    @InvokeBy(invokerClass = gc.class, methodId = "registerHolder")
    public static void Fe() {
        gc.Ff().put(Backtrace.class, new bs());
        gc.Ff().put(BlockEvent.a.class, new ku());
        gc.Ff().put(com.kwad.sdk.crash.online.monitor.a.a.class, new bw());
        gc.Ff().put(com.kwad.sdk.crash.online.monitor.a.c.class, new gw());
        gc.Ff().put(com.kwad.sdk.crash.online.monitor.a.b.class, new dx());
        gc.Ff().put(NativeBackTraceElement.class, new hd());
        gc.Ff().put(BackTraceElement.class, new br());
        gc.Ff().put(com.kwad.sdk.crash.online.monitor.block.d.class, new by());
        gc.Ff().put(AnrReason.class, new be());
        gc.Ff().put(com.kwad.sdk.crash.a.class, new cy());
        gc.Ff().put(com.kwad.sdk.crash.model.b.class, new dt());
        gc.Ff().put(JavaBackTraceElement.class, new ga());
        gc.Ff().put(BlockEvent.class, new bx());
    }
}
