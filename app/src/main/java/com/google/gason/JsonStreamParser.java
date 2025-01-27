package com.google.gason;

import android.support.v4.view.C0008;
import com.google.gason.internal.Streams;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.MalformedJsonException;
import com.tencent.as.C0523;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes7.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {

    /* renamed from: short */
    private static final short[] f63short;
    private final Object lock;
    private final JsonReader parser;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9101179)}[0]).intValue() ^ 9101145];
        sArr[0] = 2912;
        sArr[1] = 2887;
        sArr[2] = 2895;
        sArr[3] = 2890;
        sArr[4] = 2883;
        sArr[5] = 2882;
        sArr[6] = 2822;
        sArr[7] = 2902;
        sArr[8] = 2887;
        sArr[9] = 2900;
        sArr[10] = 2901;
        sArr[11] = 2895;
        sArr[12] = 2888;
        sArr[13] = 2881;
        sArr[14] = 2822;
        sArr[15] = 2924;
        sArr[16] = 2933;
        sArr[17] = 2921;
        sArr[18] = 2920;
        sArr[19] = 2822;
        sArr[20] = 2901;
        sArr[21] = 2889;
        sArr[22] = 2899;
        sArr[23] = 2900;
        sArr[24] = 2885;
        sArr[25] = 2883;
        sArr[26] = 2822;
        sArr[27] = 2898;
        sArr[28] = 2889;
        sArr[29] = 2822;
        sArr[30] = 2924;
        sArr[31] = 2901;
        sArr[32] = 2889;
        sArr[33] = 2888;
        f63short = sArr;
    }

    public JsonStreamParser(Reader reader) {
        JsonReader jsonReader = new JsonReader(reader);
        this.parser = jsonReader;
        jsonReader.setLenient(true);
        this.lock = new Object();
    }

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    z = this.parser.peek() != JsonToken.END_DOCUMENT;
                } catch (MalformedJsonException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        String m77 = C0523.m77(f63short, 1755368 ^ C0008.m27((Object) "ۨ۠۠"), 56267 ^ C0008.m27((Object) "۟ۨ"), C0008.m27((Object) "ۤۤۦ") ^ 1749312);
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e2) {
            if (e2.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e2;
        } catch (OutOfMemoryError e3) {
            throw new JsonParseException(m77, e3);
        } catch (StackOverflowError e4) {
            throw new JsonParseException(m77, e4);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
