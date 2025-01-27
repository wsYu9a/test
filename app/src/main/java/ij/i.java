package ij;

import org.threeten.bp.Duration;

/* loaded from: classes4.dex */
public interface i {
    <R extends a> R addTo(R r10, long j10);

    long between(a aVar, a aVar2);

    Duration getDuration();

    boolean isDateBased();

    boolean isDurationEstimated();

    boolean isSupportedBy(a aVar);

    boolean isTimeBased();

    String toString();
}
