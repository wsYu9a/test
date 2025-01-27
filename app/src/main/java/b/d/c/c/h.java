package b.d.c.c;

import android.os.AsyncTask;
import b.d.c.b.k;
import com.martian.libcomm.utils.e;

/* loaded from: classes2.dex */
public class h extends AsyncTask<String, Integer, k> {

    /* renamed from: a */
    private static final int f4478a = -1;

    /* renamed from: b */
    private final String f4479b;

    /* renamed from: c */
    private final e.c f4480c;

    public h(String filepath, e.c listener) {
        this.f4479b = filepath;
        this.f4480c = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b.d.c.b.k doInBackground(java.lang.String... r11) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.c.c.h.doInBackground(java.lang.String[]):b.d.c.b.k");
    }

    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(k result) {
        super.onPostExecute(result);
        if (result instanceof b.d.c.b.c) {
            this.f4480c.a((b.d.c.b.c) result);
        } else if (result instanceof b.d.c.b.b) {
            this.f4480c.c(((Integer) ((b.d.c.b.b) result).c()).intValue());
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int intValue = values[0].intValue();
        int intValue2 = values[1].intValue();
        if (intValue == 0) {
            this.f4480c.onStart();
        } else if (intValue > 0) {
            this.f4480c.b(intValue, intValue2);
        }
    }
}
