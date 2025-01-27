package okio;

import com.tencent.open.SocialConstants;
import f.b.a.d;
import f.b.a.e;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b+\u0010,J-\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005H\u0082\b¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\t\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0011\u001a\u00020\u000e8G@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0011\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u00020\u00028G@\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b\t\u0010\rR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010\u001f\u001a\u0004\b!\u0010\r\"\u0004\b\"\u0010\u000bR\u001c\u0010$\u001a\u00020#8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\"\u0010(\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001e¨\u0006-"}, d2 = {"Lokio/Pipe;", "", "Lokio/Sink;", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "block", "forward", "(Lokio/Sink;Lkotlin/jvm/functions/Function1;)V", "sink", "fold", "(Lokio/Sink;)V", "-deprecated_sink", "()Lokio/Sink;", "Lokio/Source;", "-deprecated_source", "()Lokio/Source;", SocialConstants.PARAM_SOURCE, "Lokio/Buffer;", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "Lokio/Source;", "", "sourceClosed", "Z", "getSourceClosed$okio", "()Z", "setSourceClosed$okio", "(Z)V", "Lokio/Sink;", "foldedSink", "getFoldedSink$okio", "setFoldedSink$okio", "", "maxBufferSize", "J", "getMaxBufferSize$okio", "()J", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "<init>", "(J)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class Pipe {

    @d
    private final Buffer buffer = new Buffer();

    @e
    private Sink foldedSink;
    private final long maxBufferSize;

    @d
    private final Sink sink;
    private boolean sinkClosed;

    @d
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j2) {
        this.maxBufferSize = j2;
        if (j2 >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer()) {
                        if (Pipe.this.getSinkClosed()) {
                            return;
                        }
                        Sink foldedSink = Pipe.this.getFoldedSink();
                        if (foldedSink == null) {
                            if (Pipe.this.getSourceClosed() && Pipe.this.getBuffer().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            Pipe.this.setSinkClosed$okio(true);
                            Buffer buffer = Pipe.this.getBuffer();
                            if (buffer == null) {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                            }
                            buffer.notifyAll();
                            foldedSink = null;
                        }
                        Unit unit = Unit.INSTANCE;
                        if (foldedSink != null) {
                            Pipe pipe = Pipe.this;
                            Timeout timeout = foldedSink.getTimeout();
                            Timeout timeout2 = pipe.sink().getTimeout();
                            long timeoutNanos = timeout.getTimeoutNanos();
                            long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            timeout.timeout(minTimeout, timeUnit);
                            if (!timeout.getHasDeadline()) {
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink.close();
                                    timeout.timeout(timeoutNanos, timeUnit);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                        return;
                                    }
                                    return;
                                } catch (Throwable th) {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.getHasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                    throw th;
                                }
                            }
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink.close();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            } catch (Throwable th2) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                                throw th2;
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink;
                    synchronized (Pipe.this.getBuffer()) {
                        if (!(!Pipe.this.getSinkClosed())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        foldedSink = Pipe.this.getFoldedSink();
                        if (foldedSink == null) {
                            if (Pipe.this.getSourceClosed() && Pipe.this.getBuffer().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink = null;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (foldedSink != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink.getTimeout();
                        Timeout timeout2 = pipe.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (!timeout.getHasDeadline()) {
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink.flush();
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink.flush();
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }

                @Override // okio.Sink
                @d
                /* renamed from: timeout, reason: from getter */
                public Timeout getTimeout() {
                    return this.timeout;
                }

                @Override // okio.Sink
                public void write(@d Buffer source, long byteCount) {
                    Sink sink;
                    Intrinsics.checkParameterIsNotNull(source, "source");
                    synchronized (Pipe.this.getBuffer()) {
                        if (!(!Pipe.this.getSinkClosed())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        while (true) {
                            if (byteCount <= 0) {
                                sink = null;
                                break;
                            }
                            sink = Pipe.this.getFoldedSink();
                            if (sink != null) {
                                break;
                            }
                            if (Pipe.this.getSourceClosed()) {
                                throw new IOException("source is closed");
                            }
                            long maxBufferSize = Pipe.this.getMaxBufferSize() - Pipe.this.getBuffer().size();
                            if (maxBufferSize == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.getBuffer());
                            } else {
                                long min = Math.min(maxBufferSize, byteCount);
                                Pipe.this.getBuffer().write(source, min);
                                byteCount -= min;
                                Buffer buffer = Pipe.this.getBuffer();
                                if (buffer == null) {
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                                }
                                buffer.notifyAll();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    if (sink != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = sink.getTimeout();
                        Timeout timeout2 = pipe.sink().getTimeout();
                        long timeoutNanos = timeout.getTimeoutNanos();
                        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        timeout.timeout(minTimeout, timeUnit);
                        if (!timeout.getHasDeadline()) {
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                sink.write(source, byteCount);
                                timeout.timeout(timeoutNanos, timeUnit);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.getHasDeadline()) {
                                    timeout.clearDeadline();
                                }
                                throw th;
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.getHasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            sink.write(source, byteCount);
                            timeout.timeout(timeoutNanos, timeUnit);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        } catch (Throwable th2) {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.getHasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                            throw th2;
                        }
                    }
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer()) {
                        Pipe.this.setSourceClosed$okio(true);
                        Buffer buffer = Pipe.this.getBuffer();
                        if (buffer == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer.notifyAll();
                        Unit unit = Unit.INSTANCE;
                    }
                }

                @Override // okio.Source
                public long read(@d Buffer sink, long byteCount) {
                    Intrinsics.checkParameterIsNotNull(sink, "sink");
                    synchronized (Pipe.this.getBuffer()) {
                        if (!(!Pipe.this.getSourceClosed())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        while (Pipe.this.getBuffer().size() == 0) {
                            if (Pipe.this.getSinkClosed()) {
                                return -1L;
                            }
                            this.timeout.waitUntilNotified(Pipe.this.getBuffer());
                        }
                        long read = Pipe.this.getBuffer().read(sink, byteCount);
                        Buffer buffer = Pipe.this.getBuffer();
                        if (buffer == null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer.notifyAll();
                        return read;
                    }
                }

                @Override // okio.Source
                @d
                /* renamed from: timeout, reason: from getter */
                public Timeout getTimeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + j2).toString());
        }
    }

    public final void forward(@d Sink sink, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink.getTimeout();
        Timeout timeout2 = sink().getTimeout();
        long timeoutNanos = timeout.getTimeoutNanos();
        long minTimeout = Timeout.INSTANCE.minTimeout(timeout2.getTimeoutNanos(), timeout.getTimeoutNanos());
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        timeout.timeout(minTimeout, timeUnit);
        if (!timeout.getHasDeadline()) {
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                function1.invoke(sink);
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, timeUnit);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                return;
            } catch (Throwable th) {
                InlineMarker.finallyStart(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.getHasDeadline()) {
                    timeout.clearDeadline();
                }
                InlineMarker.finallyEnd(1);
                throw th;
            }
        }
        long deadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.getHasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            function1.invoke(sink);
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, timeUnit);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(deadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th2) {
            InlineMarker.finallyStart(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.getHasDeadline()) {
                timeout.deadlineNanoTime(deadlineNanoTime);
            }
            InlineMarker.finallyEnd(1);
            throw th2;
        }
    }

    @d
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sink", imports = {}))
    @JvmName(name = "-deprecated_sink")
    /* renamed from: -deprecated_sink, reason: from getter */
    public final Sink getSink() {
        return this.sink;
    }

    @d
    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = SocialConstants.PARAM_SOURCE, imports = {}))
    @JvmName(name = "-deprecated_source")
    /* renamed from: -deprecated_source, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    public final void fold(@d Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        Intrinsics.checkParameterIsNotNull(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z = this.sinkClosed;
                buffer = new Buffer();
                Buffer buffer2 = this.buffer;
                buffer.write(buffer2, buffer2.size());
                Buffer buffer3 = this.buffer;
                if (buffer3 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                }
                buffer3.notifyAll();
                Unit unit = Unit.INSTANCE;
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    Buffer buffer4 = this.buffer;
                    if (buffer4 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer4.notifyAll();
                    Unit unit2 = Unit.INSTANCE;
                    throw th;
                }
            }
        }
    }

    @d
    /* renamed from: getBuffer$okio, reason: from getter */
    public final Buffer getBuffer() {
        return this.buffer;
    }

    @e
    /* renamed from: getFoldedSink$okio, reason: from getter */
    public final Sink getFoldedSink() {
        return this.foldedSink;
    }

    /* renamed from: getMaxBufferSize$okio, reason: from getter */
    public final long getMaxBufferSize() {
        return this.maxBufferSize;
    }

    /* renamed from: getSinkClosed$okio, reason: from getter */
    public final boolean getSinkClosed() {
        return this.sinkClosed;
    }

    /* renamed from: getSourceClosed$okio, reason: from getter */
    public final boolean getSourceClosed() {
        return this.sourceClosed;
    }

    public final void setFoldedSink$okio(@e Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @d
    @JvmName(name = "sink")
    public final Sink sink() {
        return this.sink;
    }

    @d
    @JvmName(name = SocialConstants.PARAM_SOURCE)
    public final Source source() {
        return this.source;
    }
}
