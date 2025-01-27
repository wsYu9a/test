package y8;

import java.util.List;
import x8.k;
import x8.m;

/* loaded from: classes3.dex */
public abstract class b<Input, Data> extends f<Input, k> implements a<Data> {
    public abstract k doInBackground(Input input);

    public final k executeBlocking(Input... inputArr) {
        onPreExecute();
        k doInBackground = doInBackground((Object[]) inputArr);
        onPostExecute(doInBackground);
        return doInBackground;
    }

    @Override // y8.a
    public void onLoading(boolean z10) {
        showLoading(z10);
    }

    public boolean onPreDataReceived(Data data) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y8.f
    public k doInBackground(Input... inputArr) {
        k doInBackground = doInBackground((b<Input, Data>) ((inputArr == null || inputArr.length == 0) ? null : inputArr[0]));
        if (!(doInBackground instanceof m)) {
            if (!(doInBackground instanceof x8.b)) {
                return doInBackground;
            }
            Object c10 = ((x8.b) doInBackground).c();
            return c10 == null ? new x8.c(x8.c.f31879h, "返回数据为空") : !onPreDataReceived(c10) ? new x8.c(x8.c.f31880i, "数据预处理异常") : doInBackground;
        }
        m mVar = (m) doInBackground;
        if (mVar.k()) {
            return doInBackground;
        }
        Object i10 = mVar.i();
        return i10 == null ? new m(x8.c.f31879h, "返回数据为空", mVar.h()) : !onPreDataReceived(i10) ? new m(x8.c.f31880i, "数据预处理异常", mVar.h()) : doInBackground;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y8.f
    public void onPostExecute(k kVar) {
        if (kVar instanceof m) {
            m mVar = (m) kVar;
            if (mVar.k()) {
                onResultError(mVar.g());
            } else {
                onUDDataReceived(mVar.h());
            }
        } else if (kVar instanceof x8.c) {
            onResultError((x8.c) kVar);
        } else {
            if (!(kVar instanceof x8.b)) {
                throw new UnknownError("Result class must be ErrorResult or DataResult");
            }
            onDataReceived(((x8.b) kVar).c());
        }
        super.onPostExecute((b<Input, Data>) kVar);
    }

    public void onUDDataReceived(List<Data> list) {
    }
}
