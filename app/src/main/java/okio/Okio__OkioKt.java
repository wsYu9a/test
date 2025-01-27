package okio;

import androidx.exifinterface.media.ExifInterface;
import com.sigmob.sdk.downloader.core.breakpoint.e;
import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/io/Closeable;", "Lokio/Closeable;", e.f19025e, "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "okio/Okio")
/* loaded from: classes4.dex */
final /* synthetic */ class Okio__OkioKt {
    @k
    @JvmName(name = "blackhole")
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    @k
    public static final BufferedSource buffer(@k Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new buffer(source);
    }

    public static final <T extends Closeable, R> R use(T t10, @k Function1<? super T, ? extends R> block) {
        R r10;
        Intrinsics.checkNotNullParameter(block, "block");
        Throwable th2 = null;
        try {
            r10 = block.invoke(t10);
        } catch (Throwable th3) {
            th2 = th3;
            r10 = null;
        }
        if (t10 != null) {
            try {
                t10.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    ExceptionsKt.addSuppressed(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        Intrinsics.checkNotNull(r10);
        return r10;
    }

    @k
    public static final BufferedSink buffer(@k Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new buffer(sink);
    }
}
