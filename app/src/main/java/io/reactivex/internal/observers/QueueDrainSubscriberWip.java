package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class QueueDrainSubscriberWip extends QueueDrainSubscriberPad0 {
    final AtomicInteger wip = new AtomicInteger();
}
