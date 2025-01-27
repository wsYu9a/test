package ya;

import android.os.AsyncTask;
import com.martian.mibook.data.FileInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class d0 {

    /* renamed from: a */
    public List<za.b> f33135a;

    /* renamed from: b */
    public List<za.e> f33136b;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(ArrayList<FileInfo> arrayList);
    }

    public void a(String str, b bVar, String[] strArr) {
        c();
        za.e eVar = new za.e(strArr, bVar);
        eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str, "");
        if (this.f33136b == null) {
            this.f33136b = new ArrayList();
        }
        this.f33136b.add(eVar);
    }

    public void b(String str, ArrayList<FileInfo> arrayList, int i10, String[] strArr, a aVar) {
        d();
        za.b bVar = new za.b(arrayList, strArr, i10, aVar);
        bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, str, "");
        if (this.f33135a == null) {
            this.f33135a = new ArrayList();
        }
        this.f33135a.add(bVar);
    }

    public void c() {
        List<za.e> list = this.f33136b;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<za.e> it = this.f33136b.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
            it.remove();
        }
    }

    public void d() {
        List<za.b> list = this.f33135a;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<za.b> it = this.f33135a.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
            it.remove();
        }
    }
}
