package com.sigmob.sdk.videoAd;

import com.czhj.sdk.common.track.AdTracker;
import com.czhj.sdk.common.utils.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class f extends AdTracker implements Comparable<f>, Serializable {
    private static final long serialVersionUID = 0;

    /* renamed from: a */
    public final float f20421a;

    public f(String str, float f10) {
        super(AdTracker.MessageType.QUARTILE_EVENT, null, str, null);
        Preconditions.NoThrow.checkArgument(f10 >= 0.0f);
        this.f20421a = f10;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        return Double.compare(a(), fVar.a());
    }

    public String toString() {
        return String.format(Locale.US, "%2f: %s", Float.valueOf(this.f20421a), getUrl());
    }

    public static List<f> a(List<f> list, String str, long j10, long j11) {
        if (j11 <= 0 || j10 < 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        f fVar = new f(str, j10 / j11);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            f fVar2 = list.get(i10);
            if (fVar2.compareTo(fVar) > 0) {
                break;
            }
            if (!fVar2.isTracked()) {
                arrayList.add(fVar2);
            }
        }
        return arrayList;
    }

    public final float a() {
        return this.f20421a;
    }
}
