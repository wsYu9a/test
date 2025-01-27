package qg;

import android.os.Handler;

/* loaded from: classes4.dex */
public class b {

    public static class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ Runnable f30076b;

        public a(Runnable runnable) {
            this.f30076b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f30076b.run();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void a(Runnable runnable, long j10) {
        new Handler(qg.a.b()).postDelayed(new a(runnable), j10);
    }
}
