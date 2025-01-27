package m8;

import android.app.Activity;
import com.martian.appwall.request.auth.MartianFinishNextSubTaskParams;
import com.martian.appwall.response.MartianFinishSubTask;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes3.dex */
public abstract class c extends a<MartianFinishNextSubTaskParams, MartianFinishSubTask> {
    public c(Activity activity) {
        super(activity, MartianIUserManager.b(), MartianFinishNextSubTaskParams.class, MartianFinishSubTask.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: s */
    public boolean onPreDataReceived(MartianFinishSubTask martianFinishSubTask) {
        if (martianFinishSubTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianFinishSubTask);
    }
}
