package ij;

import java.util.Locale;
import java.util.Map;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public interface f {
    <R extends a> R adjustInto(R r10, long j10);

    i getBaseUnit();

    String getDisplayName(Locale locale);

    long getFrom(b bVar);

    i getRangeUnit();

    boolean isDateBased();

    boolean isSupportedBy(b bVar);

    boolean isTimeBased();

    ValueRange range();

    ValueRange rangeRefinedBy(b bVar);

    b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle);
}
