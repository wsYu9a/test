package okio;

import f.b.a.d;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0006\u001a\u000f\u0010\t\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lokio/Source;", "Lokio/BufferedSource;", "buffer", "(Lokio/Source;)Lokio/BufferedSource;", "Lokio/Sink;", "Lokio/BufferedSink;", "(Lokio/Sink;)Lokio/BufferedSink;", "blackhole", "()Lokio/Sink;", "blackholeSink", "okio"}, k = 5, mv = {1, 4, 0}, xs = "okio/Okio")
/* loaded from: classes5.dex */
final /* synthetic */ class Okio__OkioKt {
    @d
    @JvmName(name = "blackhole")
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @d
    public static final BufferedSource buffer(@d Source buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$buffer");
        return new buffer(buffer);
    }

    @d
    public static final BufferedSink buffer(@d Sink buffer) {
        Intrinsics.checkParameterIsNotNull(buffer, "$this$buffer");
        return new buffer(buffer);
    }
}
