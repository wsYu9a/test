package nj;

import android.os.AsyncTask;
import android.os.RemoteException;
import jh.c;

/* loaded from: classes4.dex */
public final class a extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    public jh.a f28932a;

    /* renamed from: b */
    public w0.a f28933b;

    public a(jh.a aVar, w0.a aVar2) {
        this.f28932a = aVar;
        this.f28933b = aVar2;
    }

    @Override // android.os.AsyncTask
    public final Boolean doInBackground(Void[] voidArr) {
        boolean n10;
        w0.a aVar;
        if (this.f28932a == null) {
            return Boolean.FALSE;
        }
        int i10 = 0;
        while (true) {
            try {
                n10 = this.f28932a.n();
            } catch (RemoteException | InterruptedException e10) {
                c.b("MsaAsyncTask", "doInBackground", e10);
            }
            if (n10) {
                break;
            }
            Thread.sleep(10L);
            i10++;
            if (i10 >= 30) {
                break;
            }
        }
        if (n10 && (aVar = this.f28933b) != null) {
            aVar.l();
        }
        return Boolean.valueOf(n10);
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
    }
}
