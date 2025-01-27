package te;

import android.graphics.Bitmap;
import hf.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes3.dex */
public interface a {
    boolean a(String str, InputStream inputStream, c.a aVar) throws IOException;

    void clear();

    void close();

    File get(String str);

    File getDirectory();

    boolean remove(String str);

    boolean save(String str, Bitmap bitmap) throws IOException;
}
