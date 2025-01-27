package e8;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.app.PayTask;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a */
    public static final String f25766a = "b";

    /* renamed from: b */
    public static final int f25767b = 1;

    /* renamed from: c */
    public static final int f25768c = 2;

    public class a extends Handler {

        /* renamed from: a */
        public final WeakReference<c> f25769a;

        /* renamed from: b */
        public final /* synthetic */ c f25770b;

        public a(c cVar) {
            this.f25770b = cVar;
            this.f25769a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar = this.f25769a.get();
            if (cVar == null) {
                return;
            }
            int i10 = message.what;
            if (i10 == 1) {
                d dVar = new d((Map) message.obj);
                dVar.b();
                if (TextUtils.equals(dVar.c(), "9000")) {
                    cVar.onSuccess();
                    return;
                } else {
                    cVar.onFailure(dVar.a());
                    return;
                }
            }
            if (i10 != 2) {
                return;
            }
            e8.c cVar2 = new e8.c((Map) message.obj, true);
            if (TextUtils.equals(cVar2.f(), "9000") && TextUtils.equals(cVar2.e(), "200")) {
                cVar.e();
            } else {
                cVar.a(cVar2.c());
            }
        }
    }

    /* renamed from: e8.b$b */
    public class C0691b extends Thread {

        /* renamed from: b */
        public final /* synthetic */ e8.a f25771b;

        /* renamed from: c */
        public final /* synthetic */ Activity f25772c;

        /* renamed from: d */
        public final /* synthetic */ Handler f25773d;

        /* renamed from: e */
        public final /* synthetic */ c f25774e;

        public C0691b(e8.a aVar, Activity activity, Handler handler, c cVar) {
            this.f25771b = aVar;
            this.f25772c = activity;
            this.f25773d = handler;
            this.f25774e = cVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Map<String, String> payV2 = new PayTask(this.f25772c).payV2(this.f25771b.b(), true);
            Message message = new Message();
            message.what = 1;
            message.obj = payV2;
            this.f25773d.sendMessage(message);
            c cVar = this.f25774e;
            e8.a aVar = this.f25771b;
            cVar.b(aVar.f25760a, aVar.f25763d);
            Log.i(b.f25766a, payV2.toString());
        }
    }

    public interface c {
        void a(String str);

        void b(String str, String str2);

        void c(String str);

        void d(String str);

        void e();

        void f(String str);

        void onFailure(String str);

        void onSuccess();
    }

    public static void b(Activity activity, e8.a aVar, c cVar) {
        new C0691b(aVar, activity, new a(cVar), cVar).start();
    }
}
