package y8;

import android.os.AsyncTask;
import ba.o;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public abstract class f<Input, Result> {
    protected b<Input, Result> task;

    public class a extends b<Input, Result> {
        public a() {
            super();
        }

        @Override // android.os.AsyncTask
        /* renamed from: b */
        public void onProgressUpdate(Integer... numArr) {
            f.this.onProgressUpdate(numArr);
        }

        @Override // android.os.AsyncTask
        public Result doInBackground(Input... inputArr) {
            return (Result) f.this.doInBackground(inputArr);
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Result result) {
            f.this.onCancelled(result);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Result result) {
            f.this.onPostExecute(result);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            f.this.onPreExecute();
        }
    }

    public static abstract class b<Input, Result> extends AsyncTask<Input, Integer, Result> {
        public /* synthetic */ b(g gVar) {
            this();
        }

        public void a(Integer... numArr) {
            publishProgress(numArr);
        }

        public b() {
        }
    }

    public void cancel(boolean z10) {
        b<Input, Result> bVar = this.task;
        if (bVar != null) {
            bVar.cancel(z10);
        }
    }

    public final b<Input, Result> d() {
        a aVar = new a();
        this.task = aVar;
        return aVar;
    }

    public abstract Result doInBackground(Input... inputArr);

    public final void e(Input... inputArr) {
        d().executeOnExecutor(o.f1504f, inputArr);
    }

    public void executeParallel(Input... inputArr) {
        try {
            e(inputArr);
        } catch (RejectedExecutionException unused) {
        }
    }

    public void executeSerial(Input... inputArr) {
        try {
            d().executeOnExecutor(o.f1505g, inputArr);
        } catch (RejectedExecutionException unused) {
        }
    }

    public boolean isCancelled() {
        b<Input, Result> bVar = this.task;
        if (bVar != null) {
            return bVar.isCancelled();
        }
        return false;
    }

    public void onPostExecute(Result result) {
        showLoading(false);
        this.task = null;
    }

    public void onPreExecute() {
        showLoading(true);
    }

    public void publishProgress(Integer... numArr) {
        b<Input, Result> bVar = this.task;
        if (bVar != null) {
            bVar.a(numArr);
        }
    }

    public abstract void showLoading(boolean z10);

    public void onCancelled(Result result) {
    }

    public void onProgressUpdate(Integer... numArr) {
    }
}
