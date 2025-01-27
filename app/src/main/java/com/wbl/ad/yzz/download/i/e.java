package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.Launcher;
import com.wbl.ad.yzz.download.i.g;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010!\u001a\u00020\u0011¢\u0006\u0004\b\"\u0010#J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0005\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/wbl/ad/yzz/download/i/e;", "Lcom/wbl/ad/yzz/download/i/g;", "", "key", "Lcom/wbl/ad/yzz/download/i/g$b;", "a", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/download/i/g$b;", "Lcom/wbl/ad/yzz/download/i/g$c;", "writer", "", "(Ljava/lang/String;Lcom/wbl/ad/yzz/download/i/g$c;)V", "", Launcher.Method.DELETE_CALLBACK, "(Ljava/lang/String;)Z", "Lcom/wbl/ad/yzz/download/i/f;", "b", "()Lcom/wbl/ad/yzz/download/i/f;", "", "()I", "", "c", "J", "maxSize", "Ljava/io/File;", "Ljava/io/File;", "directory", "Ljava/lang/String;", "tag", com.kwad.sdk.ranger.e.TAG, "Lcom/wbl/ad/yzz/download/i/f;", "diskLruCache", "d", "I", "valueCount", "<init>", "(Ljava/io/File;JI)V", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class e implements g {

    /* renamed from: a, reason: from kotlin metadata */
    public final String tag;

    /* renamed from: b, reason: from kotlin metadata */
    public final File directory;

    /* renamed from: c, reason: from kotlin metadata */
    public final long maxSize;

    /* renamed from: d, reason: from kotlin metadata */
    public final int valueCount;

    /* renamed from: e */
    public f diskLruCache;

    public e(@f.b.a.d File directory, long j2, int i2) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.tag = "DiskCheW";
        this.directory = directory;
        this.maxSize = j2;
        if (i2 < 1) {
            this.valueCount = 1;
        } else {
            this.valueCount = i2;
        }
    }

    public final int a() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-13831, this, null);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public g.b a(String key) {
        return (g.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13826, this, key);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public void a(String key, g.c writer) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13825, this, key, writer);
    }

    public final f b() {
        return (f) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13828, this, null);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public boolean delete(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13827, this, str);
    }
}
