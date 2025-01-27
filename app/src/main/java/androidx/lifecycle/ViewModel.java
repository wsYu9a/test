package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class ViewModel {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final Map<String, Object> f2653a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f2654b = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    @MainThread
    final void a() {
        this.f2654b = true;
        Map<String, Object> map = this.f2653a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f2653a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        d();
    }

    <T> T c(String str) {
        T t;
        Map<String, Object> map = this.f2653a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.f2653a.get(str);
        }
        return t;
    }

    protected void d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T e(String str, T t) {
        Object obj;
        synchronized (this.f2653a) {
            obj = this.f2653a.get(str);
            if (obj == 0) {
                this.f2653a.put(str, t);
            }
        }
        if (obj != 0) {
            t = obj;
        }
        if (this.f2654b) {
            b(t);
        }
        return t;
    }
}
