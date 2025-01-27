package k5;

import java.nio.Buffer;

@p
@a5.c
/* loaded from: classes2.dex */
public final class s {
    public static void a(Buffer buffer) {
        buffer.clear();
    }

    public static void b(Buffer buffer) {
        buffer.flip();
    }

    public static void c(Buffer buffer, int i10) {
        buffer.limit(i10);
    }

    public static void d(Buffer buffer) {
        buffer.mark();
    }

    public static void e(Buffer buffer, int i10) {
        buffer.position(i10);
    }

    public static void f(Buffer buffer) {
        buffer.reset();
    }
}
