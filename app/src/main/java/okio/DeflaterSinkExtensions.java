package okio;

import f.b.a.d;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lokio/Sink;", "Ljava/util/zip/Deflater;", "deflater", "Lokio/DeflaterSink;", "deflate", "(Lokio/Sink;Ljava/util/zip/Deflater;)Lokio/DeflaterSink;", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-DeflaterSinkExtensions")
/* renamed from: okio.-DeflaterSinkExtensions */
/* loaded from: classes5.dex */
public final class DeflaterSinkExtensions {
    @d
    public static final DeflaterSink deflate(@d Sink deflate, @d Deflater deflater) {
        Intrinsics.checkParameterIsNotNull(deflate, "$this$deflate");
        Intrinsics.checkParameterIsNotNull(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }

    public static /* synthetic */ DeflaterSink deflate$default(Sink deflate, Deflater deflater, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkParameterIsNotNull(deflate, "$this$deflate");
        Intrinsics.checkParameterIsNotNull(deflater, "deflater");
        return new DeflaterSink(deflate, deflater);
    }
}
