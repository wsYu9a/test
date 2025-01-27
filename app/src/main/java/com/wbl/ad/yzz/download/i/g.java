package com.wbl.ad.yzz.download.i;

import com.cdo.oaps.ad.Launcher;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0003\u0005\u000e\u000fJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/wbl/ad/yzz/download/i/g;", "", "", "key", "Lcom/wbl/ad/yzz/download/i/g$b;", "a", "(Ljava/lang/String;)Lcom/wbl/ad/yzz/download/i/g$b;", "Lcom/wbl/ad/yzz/download/i/g$c;", "writer", "", "(Ljava/lang/String;Lcom/wbl/ad/yzz/download/i/g$c;)V", "", Launcher.Method.DELETE_CALLBACK, "(Ljava/lang/String;)Z", "b", "c", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface g {

    public interface a {
        @f.b.a.e
        g a();
    }

    public interface b {
        @f.b.a.e
        InputStream a(int i2);

        void a();

        @f.b.a.e
        InputStream b();

        @f.b.a.e
        File c();
    }

    public interface c {
        boolean a(@f.b.a.e OutputStream[] outputStreamArr);
    }

    @f.b.a.e
    b a(@f.b.a.d String key);

    void a(@f.b.a.d String key, @f.b.a.d c writer);

    boolean delete(@f.b.a.e String str);
}
