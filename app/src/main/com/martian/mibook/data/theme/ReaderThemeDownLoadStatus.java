package com.martian.mibook.data.theme;

import com.martian.ads.ad.AdConfig;
import kotlin.Metadata;
import xi.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/martian/mibook/data/theme/ReaderThemeDownLoadStatus;", "", "Companion", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ReaderThemeDownLoadStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DOWNLOAD = 1;
    public static final int FAILED = 3;
    public static final int IDLE = 0;
    public static final int UNZIP = 2;
    public static final int WAIT_DOWNLOAD = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/martian/mibook/data/theme/ReaderThemeDownLoadStatus$Companion;", "", "()V", AdConfig.Type.DOWNLOAD, "", "FAILED", "IDLE", "UNZIP", "WAIT_DOWNLOAD", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DOWNLOAD = 1;
        public static final int FAILED = 3;
        public static final int IDLE = 0;
        public static final int UNZIP = 2;
        public static final int WAIT_DOWNLOAD = 4;

        private Companion() {
        }
    }
}
