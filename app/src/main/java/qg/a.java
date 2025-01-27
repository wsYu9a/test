package qg;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final HashMap<String, HandlerThread> f30075a = new HashMap<>();

    public static HandlerThread a(String str) {
        HandlerThread handlerThread;
        HashMap<String, HandlerThread> hashMap = f30075a;
        synchronized (hashMap) {
            try {
                handlerThread = hashMap.get(str);
                if (handlerThread != null && handlerThread.getLooper() == null) {
                    hashMap.remove(str);
                    handlerThread = null;
                }
                if (handlerThread == null) {
                    handlerThread = new HandlerThread(str);
                    handlerThread.start();
                    hashMap.put(str, handlerThread);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handlerThread;
    }

    public static Looper b() {
        return a("tanx_exposer_sdk").getLooper();
    }
}
