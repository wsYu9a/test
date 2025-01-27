package okio;

import com.baidu.mobads.sdk.internal.bq;
import f.b.a.d;
import f.b.a.e;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\t0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokio/SocketAsyncTimeout;", "Lokio/AsyncTimeout;", "Ljava/io/IOException;", "cause", "newTimeoutException", "(Ljava/io/IOException;)Ljava/io/IOException;", "", "timedOut", "()V", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", bq.f5638a, "Ljava/util/logging/Logger;", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "<init>", "(Ljava/net/Socket;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes5.dex */
final class SocketAsyncTimeout extends AsyncTimeout {
    private final Logger logger;
    private final Socket socket;

    public SocketAsyncTimeout(@d Socket socket) {
        Intrinsics.checkParameterIsNotNull(socket, "socket");
        this.socket = socket;
        this.logger = Logger.getLogger("okio.Okio");
    }

    @Override // okio.AsyncTimeout
    @d
    protected IOException newTimeoutException(@e IOException cause) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (cause != null) {
            socketTimeoutException.initCause(cause);
        }
        return socketTimeoutException;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        try {
            this.socket.close();
        } catch (AssertionError e2) {
            if (!Okio.isAndroidGetsocknameError(e2)) {
                throw e2;
            }
            this.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e2);
        } catch (Exception e3) {
            this.logger.log(Level.WARNING, "Failed to close timed out socket " + this.socket, (Throwable) e3);
        }
    }
}
