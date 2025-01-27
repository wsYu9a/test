package com.martian.mibook.mvvm.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import xi.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/martian/mibook/mvvm/utils/ClickUtils;", "", "()V", "Companion", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClickUtils {

    /* renamed from: Companion, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);
    private static final long DEFAULT_CLICK_INTERVAL = 800;
    private static long lastClickTime;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/martian/mibook/mvvm/utils/ClickUtils$Companion;", "", "()V", "DEFAULT_CLICK_INTERVAL", "", "lastClickTime", "isClickable", "", "clickInterval", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ boolean isClickable$default(Companion companion, long j10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                j10 = ClickUtils.DEFAULT_CLICK_INTERVAL;
            }
            return companion.isClickable(j10);
        }

        @JvmStatic
        public final boolean isClickable(long clickInterval) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z10 = currentTimeMillis - ClickUtils.lastClickTime >= clickInterval;
            if (z10) {
                ClickUtils.lastClickTime = currentTimeMillis;
            }
            return z10;
        }

        private Companion() {
        }
    }

    private ClickUtils() {
    }

    @JvmStatic
    public static final boolean isClickable(long j10) {
        return INSTANCE.isClickable(j10);
    }
}
