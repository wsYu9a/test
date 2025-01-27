package b.d.c.c;

import android.content.Context;
import b.d.c.b.i;
import b.d.c.b.j;
import com.martian.libcomm.http.requests.b;
import com.martian.libsupport.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class e<Params extends com.martian.libcomm.http.requests.b, E, Data extends b.d.c.b.i<E>, Parser extends j> extends d<Params, Data, Parser> implements a<Data> {

    /* renamed from: f */
    private final com.martian.libsupport.j<E> f4472f;

    /* renamed from: g */
    private final int f4473g;

    /* renamed from: h */
    private String f4474h;

    /* renamed from: i */
    private final ArrayList<String> f4475i;

    public e(Class<Params> paramsClass, Context ctx, Parser parser, Hashtable<String, String> properties, String charset, com.martian.libsupport.j<E> elemDao, int maxSize) {
        super(paramsClass, ctx, parser, properties, charset);
        this.f4475i = new ArrayList<>();
        this.f4472f = elemDao;
        this.f4473g = maxSize;
    }

    private Data u() {
        Data v = v();
        v.b(w(this.f4473g));
        return v;
    }

    private List<E> w(int size) {
        ArrayList arrayList = new ArrayList();
        this.f4472f.load(arrayList, 0, size, this.f4474h, this.f4475i);
        return arrayList;
    }

    private void z(Data data) {
        if (data.a() != null) {
            this.f4472f.insertOrUpdate((Collection) data.a());
        }
        data.b(w(this.f4473g));
    }

    public void n(String selectArg) {
        this.f4475i.add(selectArg);
    }

    public void o(List<String> selectArgs) {
        this.f4475i.addAll(selectArgs);
    }

    public void p(String s) {
        if (k.p(this.f4474h)) {
            this.f4474h = s;
            return;
        }
        this.f4474h += " AND " + s;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.c.c.c, b.d.c.c.g
    /* renamed from: q */
    public b.d.c.b.k doInBackground(com.martian.libcomm.http.requests.b... params) {
        b.d.c.b.k doInBackground = super.doInBackground((Object[]) params);
        if (doInBackground instanceof b.d.c.b.c) {
            return new b.d.c.b.a(u(), (b.d.c.b.c) doInBackground);
        }
        if (!(doInBackground instanceof b.d.c.b.b)) {
            throw new UnknownError("Result class must be ErrorResult or DataResult");
        }
        b.d.c.b.b bVar = (b.d.c.b.b) doInBackground;
        x((b.d.c.b.i) bVar.c());
        z((b.d.c.b.i) bVar.c());
        return doInBackground;
    }

    public List<String> r() {
        return this.f4475i;
    }

    @Override // b.d.c.c.a
    /* renamed from: s */
    public abstract void a(Data data);

    @Override // b.d.c.c.a
    /* renamed from: t */
    public abstract void e(Data data, b.d.c.b.c errorResult);

    protected abstract Data v();

    protected abstract void x(Data data);

    public void y(String selection) {
        this.f4474h = selection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.c.c.c, b.d.c.c.g
    public void onPostExecute(b.d.c.b.k result) {
        super.onPostExecute(result);
        if (result instanceof b.d.c.b.a) {
            b.d.c.b.a aVar = (b.d.c.b.a) result;
            e((b.d.c.b.i) aVar.c(), aVar.e());
        } else {
            if (!(result instanceof b.d.c.b.b)) {
                throw new UnknownError("Result class must be ErrorResult or DataResult");
            }
            a((b.d.c.b.i) ((b.d.c.b.b) result).c());
        }
    }

    public e(Class<Params> paramsClass, Context ctx, Parser parser, String charset, com.martian.libsupport.j<E> elemDao, int maxSize) {
        super(paramsClass, ctx, parser, charset);
        this.f4475i = new ArrayList<>();
        this.f4472f = elemDao;
        this.f4473g = maxSize;
    }

    public e(Class<Params> paramsClass, Context ctx, Parser parser, com.martian.libsupport.j<E> elemDao, int maxSize) {
        super(paramsClass, ctx, parser);
        this.f4475i = new ArrayList<>();
        this.f4472f = elemDao;
        this.f4473g = maxSize;
    }
}
