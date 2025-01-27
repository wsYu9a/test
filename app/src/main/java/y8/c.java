package y8;

import android.os.AsyncTask;
import x8.k;
import z8.e;

/* loaded from: classes3.dex */
public class c extends AsyncTask<String, Integer, k> {

    /* renamed from: c */
    public static final int f33067c = -1;

    /* renamed from: a */
    public final String f33068a;

    /* renamed from: b */
    public final e.b f33069b;

    public c(String str, e.b bVar) {
        this.f33068a = str;
        this.f33069b = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public x8.k doInBackground(java.lang.String... r11) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.c.doInBackground(java.lang.String[]):x8.k");
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(k kVar) {
        super.onPostExecute(kVar);
        if (kVar instanceof x8.c) {
            this.f33069b.c((x8.c) kVar);
        } else if (kVar instanceof x8.b) {
            this.f33069b.b(((Integer) ((x8.b) kVar).c()).intValue());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        super.onProgressUpdate(numArr);
        int intValue = numArr[0].intValue();
        int intValue2 = numArr[1].intValue();
        if (intValue == 0) {
            this.f33069b.onStart();
        } else if (intValue > 0) {
            this.f33069b.a(intValue, intValue2);
        }
    }

    @Override // android.os.AsyncTask
    public void onCancelled() {
        super.onCancelled();
        this.f33069b.onCancel();
    }
}
