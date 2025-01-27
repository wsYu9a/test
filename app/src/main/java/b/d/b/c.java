package b.d.b;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.alipay.sdk.app.PayTask;
import com.martian.alipay.dao.AlipayOrderDao;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a */
    private static final String f4385a = "c";

    /* renamed from: b */
    public static final int f4386b = 1;

    static class a extends Handler {

        /* renamed from: a */
        final /* synthetic */ InterfaceC0013c f4387a;

        /* renamed from: b */
        final /* synthetic */ b.d.b.b f4388b;

        a(final InterfaceC0013c val$alipayProduct, final b.d.b.b val$onPaymentResult) {
            this.f4387a = val$alipayProduct;
            this.f4388b = val$onPaymentResult;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                e eVar = (e) msg.obj;
                this.f4387a.b(eVar.f4406d);
                String d2 = eVar.d();
                if (d2 == null) {
                    this.f4387a.d(eVar.f4405c);
                    return;
                }
                if (d2.equals("4000")) {
                    this.f4387a.d(eVar.f4405c + d2);
                    new AlipayOrderDao().updatePaymentFail(this.f4388b.f4379a);
                    return;
                }
                if (d2.equals("6001")) {
                    this.f4387a.e(eVar.f4405c + d2);
                    new AlipayOrderDao().updatePaymentFail(this.f4388b.f4379a);
                    return;
                }
                if (d2.equals("6002")) {
                    this.f4387a.d(eVar.f4405c + d2);
                    new AlipayOrderDao().updatePaymentFail(this.f4388b.f4379a);
                    return;
                }
                if (d2.equals("0")) {
                    this.f4387a.d(eVar.f4405c + d2);
                    new AlipayOrderDao().updatePaymentFail(this.f4388b.f4379a);
                    return;
                }
                if (d2.equals("9000")) {
                    this.f4387a.onSuccess();
                    new AlipayOrderDao().updatePaymentSuccess(this.f4388b.f4379a);
                } else if (d2.equals("8000")) {
                    this.f4387a.onSuccess();
                    new AlipayOrderDao().updatePaymentSuccess(this.f4388b.f4379a);
                }
            }
        }
    }

    static class b extends Thread {

        /* renamed from: a */
        final /* synthetic */ b.d.b.b f4389a;

        /* renamed from: b */
        final /* synthetic */ Activity f4390b;

        /* renamed from: c */
        final /* synthetic */ Handler f4391c;

        /* renamed from: d */
        final /* synthetic */ InterfaceC0013c f4392d;

        b(final b.d.b.b val$onPaymentResult, final Activity val$handler, final Handler val$activity, final InterfaceC0013c val$alipayProduct) {
            this.f4389a = val$onPaymentResult;
            this.f4390b = val$handler;
            this.f4391c = val$activity;
            this.f4392d = val$alipayProduct;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AlipayOrderDao alipayOrderDao = new AlipayOrderDao();
            b.d.b.b bVar = this.f4389a;
            alipayOrderDao.insert(bVar.f4379a, bVar.f4382d);
            String pay = new PayTask(this.f4390b).pay(this.f4389a.b());
            e eVar = new e(pay);
            Message message = new Message();
            message.what = 1;
            message.obj = eVar;
            this.f4391c.sendMessage(message);
            InterfaceC0013c interfaceC0013c = this.f4392d;
            b.d.b.b bVar2 = this.f4389a;
            interfaceC0013c.a(bVar2.f4379a, bVar2.f4382d);
            Log.i(c.f4385a, pay);
        }
    }

    /* renamed from: b.d.b.c$c */
    public interface InterfaceC0013c {
        void a(String out_trade_no, String fee_value);

        void b(String rawResult);

        void c(String message);

        void d(String message);

        void e(String message);

        void onSuccess();
    }

    public static void b(final Activity activity, final b.d.b.b alipayProduct, final InterfaceC0013c onPaymentResult) {
        new b(alipayProduct, activity, new a(onPaymentResult, alipayProduct), onPaymentResult).start();
    }
}
