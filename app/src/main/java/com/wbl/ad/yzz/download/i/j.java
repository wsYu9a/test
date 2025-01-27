package com.wbl.ad.yzz.download.i;

import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.Launcher;
import com.wbl.ad.yzz.download.i.g;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0005B\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/wbl/ad/yzz/download/i/j;", "Lcom/wbl/ad/yzz/download/i/g;", "", "key", "Lcom/wbl/ad/yzz/download/i/g$b;", "a", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/download/i/g$b;", "Lcom/wbl/ad/yzz/download/i/g$c;", "writer", "", "(Ljava/lang/String;Lcom/wbl/ad/yzz/download/i/g$c;)V", "", Launcher.Method.DELETE_CALLBACK, "(Ljava/lang/String;)Z", "Lcom/wbl/ad/yzz/download/i/e;", "Lcom/wbl/ad/yzz/download/i/e;", "mWrapper", "Ljava/io/File;", "directory", "", "maxSize", "", "valueCount", "<init>", "(Ljava/io/File;JI)V", "c", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class j implements g {

    /* renamed from: b */
    public static volatile g f32097b;

    /* renamed from: c, reason: from kotlin metadata */
    @f.b.a.d
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    public final e mWrapper;

    /* renamed from: com.wbl.ad.yzz.download.i.j$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final g a(File file, long j2, int i2) {
            return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13914, this, file, Long.valueOf(j2), Integer.valueOf(i2));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j(@f.b.a.d File directory, long j2, int i2) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.mWrapper = new e(directory, j2, i2);
    }

    public static final /* synthetic */ g a() {
        return (g) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13913, null, null);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public g.b a(String key) {
        return (g.b) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-13915, this, key);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public void a(String key, g.c writer) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-13910, this, key, writer);
    }

    @Override // com.wbl.ad.yzz.download.i.g
    public boolean delete(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-13909, this, str);
    }
}
