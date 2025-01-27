package okio;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lokio/Sink;", "Lokio/GzipSink;", "gzip", "(Lokio/Sink;)Lokio/GzipSink;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-GzipSinkExtensions")
/* renamed from: okio.-GzipSinkExtensions */
/* loaded from: classes5.dex */
public final class GzipSinkExtensions {
    @d
    public static final GzipSink gzip(@d Sink gzip) {
        Intrinsics.checkParameterIsNotNull(gzip, "$this$gzip");
        return new GzipSink(gzip);
    }
}
