package b5;

import java.nio.Buffer;

@g
@a5.c
/* loaded from: classes2.dex */
public final class o {
    public static void a(Buffer buffer) {
        buffer.clear();
    }

    public static void b(Buffer buffer) {
        buffer.flip();
    }

    public static void c(Buffer buffer, int i10) {
        buffer.limit(i10);
    }

    public static void d(Buffer buffer, int i10) {
        buffer.position(i10);
    }
}
