package com.vivo.google.android.exoplayer3.upstream;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.m5;
import com.vivo.google.android.exoplayer3.q5;
import com.vivo.google.android.exoplayer3.s6;
import com.vivo.google.android.exoplayer3.v6;
import com.vivo.google.android.exoplayer3.x5;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class DefaultBandwidthMeter implements m5, x5<Object> {
    public static final int BYTES_TRANSFERRED_FOR_ESTIMATE = 524288;
    public static final int DEFAULT_MAX_WEIGHT = 2000;
    public static final int ELAPSED_MILLIS_FOR_ESTIMATE = 2000;
    public long bitrateEstimate;
    public final Handler eventHandler;
    public final m5.a eventListener;
    public long sampleBytesTransferred;
    public long sampleStartTimeMs;
    public final s6 slidingPercentile;
    public int streamCount;
    public long totalBytesTransferred;
    public long totalElapsedTimeMs;

    public class a extends v6 {

        /* renamed from: a */
        public final /* synthetic */ int f28142a;

        /* renamed from: b */
        public final /* synthetic */ long f28143b;

        /* renamed from: c */
        public final /* synthetic */ long f28144c;

        public a(int i2, long j2, long j3) {
            this.f28142a = i2;
            this.f28143b = j2;
            this.f28144c = j3;
        }

        @Override // com.vivo.google.android.exoplayer3.v6
        public void a() {
            DefaultBandwidthMeter.this.eventListener.a(this.f28142a, this.f28143b, this.f28144c);
        }
    }

    public DefaultBandwidthMeter() {
        this(null, null);
    }

    public DefaultBandwidthMeter(Handler handler, m5.a aVar) {
        this(handler, aVar, 2000);
    }

    public DefaultBandwidthMeter(Handler handler, m5.a aVar, int i2) {
        this.eventHandler = handler;
        this.eventListener = aVar;
        this.slidingPercentile = new s6(i2);
        this.bitrateEstimate = -1L;
    }

    private void notifyBandwidthSample(int i2, long j2, long j3) {
        Handler handler = this.eventHandler;
        if (handler == null || this.eventListener == null) {
            return;
        }
        handler.post(new a(i2, j2, j3));
    }

    @Override // com.vivo.google.android.exoplayer3.m5
    public synchronized long getBitrateEstimate() {
        return this.bitrateEstimate;
    }

    @Override // com.vivo.google.android.exoplayer3.x5
    public synchronized void onBytesTransferred(Object obj, int i2) {
        this.sampleBytesTransferred += i2;
    }

    @Override // com.vivo.google.android.exoplayer3.x5
    public synchronized void onTransferEnd(Object obj) {
        s6.c cVar;
        float f2;
        int i2 = 0;
        g1.b(this.streamCount > 0);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = (int) (elapsedRealtime - this.sampleStartTimeMs);
        long j2 = i3;
        this.totalElapsedTimeMs += j2;
        long j3 = this.totalBytesTransferred;
        long j4 = this.sampleBytesTransferred;
        this.totalBytesTransferred = j3 + j4;
        if (i3 > 0) {
            float f3 = (8000 * j4) / j2;
            s6 s6Var = this.slidingPercentile;
            int sqrt = (int) Math.sqrt(j4);
            if (s6Var.f28067d != 1) {
                Collections.sort(s6Var.f28065b, s6.f28062h);
                s6Var.f28067d = 1;
            }
            int i4 = s6Var.f28070g;
            if (i4 > 0) {
                s6.c[] cVarArr = s6Var.f28066c;
                int i5 = i4 - 1;
                s6Var.f28070g = i5;
                cVar = cVarArr[i5];
            } else {
                cVar = new s6.c();
            }
            int i6 = s6Var.f28068e;
            s6Var.f28068e = i6 + 1;
            cVar.f28071a = i6;
            cVar.f28072b = sqrt;
            cVar.f28073c = f3;
            s6Var.f28065b.add(cVar);
            s6Var.f28069f += sqrt;
            while (true) {
                int i7 = s6Var.f28069f;
                int i8 = s6Var.f28064a;
                if (i7 <= i8) {
                    break;
                }
                int i9 = i7 - i8;
                s6.c cVar2 = s6Var.f28065b.get(0);
                int i10 = cVar2.f28072b;
                if (i10 <= i9) {
                    s6Var.f28069f -= i10;
                    s6Var.f28065b.remove(0);
                    int i11 = s6Var.f28070g;
                    if (i11 < 5) {
                        s6.c[] cVarArr2 = s6Var.f28066c;
                        s6Var.f28070g = i11 + 1;
                        cVarArr2[i11] = cVar2;
                    }
                } else {
                    cVar2.f28072b = i10 - i9;
                    s6Var.f28069f -= i9;
                }
            }
            if (this.totalElapsedTimeMs >= 2000 || this.totalBytesTransferred >= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) {
                s6 s6Var2 = this.slidingPercentile;
                if (s6Var2.f28067d != 0) {
                    Collections.sort(s6Var2.f28065b, s6.f28063i);
                    s6Var2.f28067d = 0;
                }
                float f4 = 0.5f * s6Var2.f28069f;
                int i12 = 0;
                while (true) {
                    if (i2 < s6Var2.f28065b.size()) {
                        s6.c cVar3 = s6Var2.f28065b.get(i2);
                        i12 += cVar3.f28072b;
                        if (i12 >= f4) {
                            f2 = cVar3.f28073c;
                            break;
                        }
                        i2++;
                    } else if (s6Var2.f28065b.isEmpty()) {
                        f2 = Float.NaN;
                    } else {
                        ArrayList<s6.c> arrayList = s6Var2.f28065b;
                        f2 = arrayList.get(arrayList.size() - 1).f28073c;
                    }
                }
                this.bitrateEstimate = Float.isNaN(f2) ? -1L : (long) f2;
            }
        }
        notifyBandwidthSample(i3, this.sampleBytesTransferred, this.bitrateEstimate);
        int i13 = this.streamCount - 1;
        this.streamCount = i13;
        if (i13 > 0) {
            this.sampleStartTimeMs = elapsedRealtime;
        }
        this.sampleBytesTransferred = 0L;
    }

    @Override // com.vivo.google.android.exoplayer3.x5
    public synchronized void onTransferStart(Object obj, q5 q5Var) {
        if (this.streamCount == 0) {
            this.sampleStartTimeMs = SystemClock.elapsedRealtime();
        }
        this.streamCount++;
    }
}
