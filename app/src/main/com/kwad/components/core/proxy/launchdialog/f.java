package com.kwad.components.core.proxy.launchdialog;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes3.dex */
public interface f {

    public static class a implements f {
        private long TG = 1000;

        public a(long j10) {
        }

        public final boolean F(long j10) {
            return this.TG > 0 && System.currentTimeMillis() - j10 >= this.TG;
        }

        public final String toString() {
            return "DurationMoreThanItem{mDuration=" + this.TG + '}';
        }
    }

    public static class b implements f {
        private Lifecycle.Event TA;

        public b(Lifecycle.Event event) {
            this.TA = event;
        }

        public final boolean b(Lifecycle.Event event) {
            return this.TA.equals(event);
        }

        public final String toString() {
            return "PageEventItem{mEvent=" + this.TA + '}';
        }
    }
}
