package com.kwad.sdk.core.download.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.IProgressRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;

/* loaded from: classes2.dex */
public final class c {
    private IProgressRemoteView afx;

    private c(IProgressRemoteView iProgressRemoteView) {
        this.afx = iProgressRemoteView;
    }

    @Nullable
    public static c a(Context context, int i2, boolean z) {
        c cVar;
        try {
            cVar = ((e) ServiceProvider.get(e.class)).getApiVersionCode() >= 3031000 ? new c(RemoteViewBuilder.createProgressView(context, i2, z)) : new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            cVar = null;
        }
        if (cVar != null) {
            return cVar;
        }
        try {
            return new c(RemoteViewBuilder.createProgressView(context));
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th2);
            return cVar;
        }
    }

    final RemoteViews build() {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            return iProgressRemoteView.build();
        }
        return null;
    }

    public final void setControlBtnPaused(boolean z) {
        try {
            IProgressRemoteView iProgressRemoteView = this.afx;
            if (iProgressRemoteView != null) {
                iProgressRemoteView.setControlBtnPaused(z);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setIcon(bitmap);
        }
    }

    public final void setName(String str) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setName(str);
        }
    }

    public final void setPercentNum(String str) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setPercentNum(str);
        }
    }

    public final void setProgress(int i2, int i3, boolean z) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setProgress(100, i3, false);
        }
    }

    public final void setSize(String str) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        IProgressRemoteView iProgressRemoteView = this.afx;
        if (iProgressRemoteView != null) {
            iProgressRemoteView.setStatus(str);
        }
    }
}
