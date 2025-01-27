package com.vivo.advv.vaf.virtualview.loader;

import com.vivo.advv.vaf.virtualview.util.VVLog;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class UiCodeLoader {
    private static final String TAG = "UiCodeLoader_TMTEST";
    private ConcurrentHashMap<String, Integer> mTypeToPos = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CodeReader> mTypeToCodeReader = new ConcurrentHashMap<>();

    private boolean loadFromBufferInternally(CodeReader codeReader, short s, String str) {
        this.mTypeToCodeReader.put(str, codeReader);
        codeReader.seekBy(s);
        short readShort = codeReader.readShort();
        this.mTypeToPos.put(str, Integer.valueOf(codeReader.getPos()));
        if (codeReader.seekBy(readShort)) {
            return true;
        }
        VVLog.e(TAG, "seekBy error:" + ((int) readShort));
        return false;
    }

    public void clear() {
        this.mTypeToPos.clear();
        this.mTypeToCodeReader.clear();
    }

    public void destroy() {
    }

    public boolean forceLoadFromBuffer(CodeReader codeReader, int i2, int i3) {
        codeReader.readInt();
        short readShort = codeReader.readShort();
        return loadFromBufferInternally(codeReader, readShort, new String(codeReader.getCode(), codeReader.getPos(), readShort, Charset.forName("UTF-8")));
    }

    public CodeReader getCode(String str) {
        if (!this.mTypeToCodeReader.containsKey(str) || !this.mTypeToPos.containsKey(str)) {
            return null;
        }
        CodeReader codeReader = this.mTypeToCodeReader.get(str);
        codeReader.seek(this.mTypeToPos.get(str).intValue());
        return codeReader;
    }

    public boolean loadFromBuffer(CodeReader codeReader, int i2, int i3) {
        codeReader.readInt();
        short readShort = codeReader.readShort();
        String str = new String(codeReader.getCode(), codeReader.getPos(), readShort, Charset.forName("UTF-8"));
        CodeReader codeReader2 = this.mTypeToCodeReader.get(str);
        if (codeReader2 == null || i3 > codeReader2.getPatchVersion()) {
            return loadFromBufferInternally(codeReader, readShort, str);
        }
        VVLog.w(TAG, "load view name " + str + " should not override from " + i3 + " to " + i3);
        return false;
    }
}
