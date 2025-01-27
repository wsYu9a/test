package m8;

import android.app.Activity;
import com.martian.appwall.request.auth.MartianStartCurrentSubTaskParams;
import com.martian.appwall.response.MartianStartSubTask;
import com.martian.rpauth.MartianIUserManager;

/* loaded from: classes3.dex */
public abstract class d extends a<MartianStartCurrentSubTaskParams, MartianStartSubTask> {
    public d(Activity activity) {
        super(activity, MartianIUserManager.b(), MartianStartCurrentSubTaskParams.class, MartianStartSubTask.class);
    }

    @Override // y8.b, y8.a
    /* renamed from: s */
    public boolean onPreDataReceived(MartianStartSubTask martianStartSubTask) {
        if (martianStartSubTask == null) {
            return false;
        }
        return super.onPreDataReceived(martianStartSubTask);
    }
}
