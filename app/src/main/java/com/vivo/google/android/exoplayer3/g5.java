package com.vivo.google.android.exoplayer3;

/* loaded from: classes4.dex */
public final class g5 extends f5 {

    /* renamed from: a */
    public final int f27442a;

    /* renamed from: b */
    public final Object f27443b;

    public g5(s3 s3Var, int i2) {
        this(s3Var, i2, 0, null);
    }

    public g5(s3 s3Var, int i2, int i3, Object obj) {
        super(s3Var, i2);
        this.f27442a = i3;
        this.f27443b = obj;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int getSelectedIndex() {
        return 0;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public Object getSelectionData() {
        return this.f27443b;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public int getSelectionReason() {
        return this.f27442a;
    }

    @Override // com.vivo.google.android.exoplayer3.trackselection.TrackSelection
    public void updateSelectedTrack(long j2) {
    }
}
