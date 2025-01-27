package b.d.c.c;

import b.d.c.b.k;
import b.d.c.b.m;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c<Input, Data> extends g<Input, k> implements b<Data> {
    protected abstract k doInBackground(Input input);

    public final k executeBlocking(Input... inputs) {
        onPreExecute();
        k doInBackground = doInBackground((Object[]) inputs);
        onPostExecute(doInBackground);
        return doInBackground;
    }

    @Override // b.d.c.c.b
    public void onLoading(boolean loading) {
        showLoading(loading);
    }

    @Override // b.d.c.c.b
    public boolean onPreDataReceived(Data data) {
        return true;
    }

    public void onUDDataReceived(List<Data> dataList) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.c.c.g
    public k doInBackground(Input... params) {
        k doInBackground = doInBackground((c<Input, Data>) ((params == null || params.length == 0) ? null : params[0]));
        if (!(doInBackground instanceof m)) {
            if (!(doInBackground instanceof b.d.c.b.b)) {
                return doInBackground;
            }
            Object c2 = ((b.d.c.b.b) doInBackground).c();
            return (c2 == null || !onPreDataReceived(c2)) ? new b.d.c.b.c(-1, "网络异常") : doInBackground;
        }
        m mVar = (m) doInBackground;
        if (mVar.k()) {
            return doInBackground;
        }
        Object i2 = mVar.i();
        return (i2 == null || !onPreDataReceived(i2)) ? new b.d.c.b.c(-1, "网络异常") : doInBackground;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.d.c.c.g
    public void onPostExecute(k result) {
        if (result instanceof m) {
            m mVar = (m) result;
            if (mVar.k()) {
                onResultError(mVar.g());
            } else {
                onUDDataReceived(mVar.h());
            }
        } else if (result instanceof b.d.c.b.c) {
            onResultError((b.d.c.b.c) result);
        } else {
            if (!(result instanceof b.d.c.b.b)) {
                throw new UnknownError("Result class must be ErrorResult or DataResult");
            }
            onDataReceived(((b.d.c.b.b) result).c());
        }
        super.onPostExecute((c<Input, Data>) result);
    }
}
