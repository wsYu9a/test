package g5;

import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import g5.f;
import java.util.concurrent.Executor;

@e
/* loaded from: classes2.dex */
public class b extends f {
    public b(String str, Executor executor) {
        super(str, executor, d.c(), f.a.f26138a);
    }

    public b(Executor executor, l lVar) {
        super(DownloadSettingKeys.BugFix.DEFAULT, executor, d.c(), lVar);
    }

    public b(Executor executor) {
        super(DownloadSettingKeys.BugFix.DEFAULT, executor, d.c(), f.a.f26138a);
    }
}
