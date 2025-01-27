package ij;

import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public interface b {
    int get(f fVar);

    long getLong(f fVar);

    boolean isSupported(f fVar);

    <R> R query(h<R> hVar);

    ValueRange range(f fVar);
}
