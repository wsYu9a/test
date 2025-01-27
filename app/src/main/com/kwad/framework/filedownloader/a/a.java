package com.kwad.framework.filedownloader.a;

import com.kwad.framework.filedownloader.f.c;
import com.sigmob.sdk.downloader.core.download.g;

/* loaded from: classes3.dex */
public final class a implements c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int P(long j10) {
        if (j10 < 1048576) {
            return 1;
        }
        if (j10 < g.f19255e) {
            return 2;
        }
        if (j10 < g.f19256f) {
            return 3;
        }
        return j10 < g.f19257g ? 4 : 5;
    }
}
