package com.vivo.google.android.exoplayer3.trackselection;

import com.vivo.google.android.exoplayer3.g;
import com.vivo.google.android.exoplayer3.i5;
import com.vivo.google.android.exoplayer3.source.TrackGroupArray;

/* loaded from: classes4.dex */
public abstract class TrackSelector {
    public InvalidationListener listener;

    public interface InvalidationListener {
        void onTrackSelectionsInvalidated();
    }

    public final void init(InvalidationListener invalidationListener) {
        this.listener = invalidationListener;
    }

    public final void invalidate() {
        InvalidationListener invalidationListener = this.listener;
        if (invalidationListener != null) {
            invalidationListener.onTrackSelectionsInvalidated();
        }
    }

    public abstract void onSelectionActivated(Object obj);

    public abstract i5 selectTracks(g[] gVarArr, TrackGroupArray trackGroupArray);
}
