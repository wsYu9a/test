package com.vivo.advv.vaf.virtualview.loader;

import com.vivo.advv.TextUtils;
import com.vivo.advv.expr.common.StringSupport;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.StringBase;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class StringLoader extends StringBase implements StringSupport {
    private static final String TAG = "StringLoader_TMTEST";
    private int mCurPage;
    private Map<String, Integer> mString2Index = new ConcurrentHashMap();
    private Map<Integer, String> mIndex2String = new ConcurrentHashMap();
    private Map<String, Integer> mSysString2Index = new ConcurrentHashMap();
    private Map<Integer, String> mSysIndex2String = new ConcurrentHashMap();

    public StringLoader() {
        for (int i2 = 0; i2 < StringBase.STR_ID_SYS_KEY_COUNT; i2++) {
            Map<String, Integer> map = this.mSysString2Index;
            String[] strArr = StringBase.SYS_KEYS;
            String str = strArr[i2];
            int[] iArr = StringBase.SYS_KEYS_INDEX;
            map.put(str, Integer.valueOf(iArr[i2]));
            this.mSysIndex2String.put(Integer.valueOf(iArr[i2]), strArr[i2]);
        }
    }

    public void destroy() {
        this.mString2Index.clear();
        this.mIndex2String.clear();
        this.mSysString2Index.clear();
        this.mSysIndex2String.clear();
    }

    @Override // com.vivo.advv.expr.common.StringSupport
    public String getString(int i2) {
        if (this.mSysIndex2String.containsKey(Integer.valueOf(i2))) {
            return this.mSysIndex2String.get(Integer.valueOf(i2));
        }
        if (this.mIndex2String.containsKey(Integer.valueOf(i2))) {
            return this.mIndex2String.get(Integer.valueOf(i2));
        }
        return null;
    }

    @Override // com.vivo.advv.expr.common.StringSupport
    public int getStringId(String str) {
        return getStringId(str, true);
    }

    @Override // com.vivo.advv.expr.common.StringSupport
    public boolean isSysString(int i2) {
        return this.mSysIndex2String.containsKey(Integer.valueOf(i2));
    }

    public boolean loadFromBuffer(CodeReader codeReader, int i2) {
        this.mCurPage = i2;
        int maxSize = codeReader.getMaxSize();
        int readInt = codeReader.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = codeReader.readInt();
            short readShort = codeReader.readShort();
            if (codeReader.getPos() + readShort > maxSize) {
                VVLog.e(TAG, "read string over");
                return false;
            }
            String str = new String(codeReader.getCode(), codeReader.getPos(), (int) readShort);
            this.mIndex2String.put(Integer.valueOf(readInt2), str);
            this.mString2Index.put(str, Integer.valueOf(readInt2));
            codeReader.seekBy(readShort);
        }
        return true;
    }

    public void remove(int i2) {
    }

    public void reset() {
    }

    public void setCurPage(int i2) {
        this.mCurPage = i2;
    }

    @Override // com.vivo.advv.expr.common.StringSupport
    public int getStringId(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int intValue = this.mSysString2Index.containsKey(str) ? this.mSysString2Index.get(str).intValue() : 0;
        return (intValue == 0 && this.mString2Index.containsKey(str)) ? this.mString2Index.get(str).intValue() : intValue;
    }

    @Override // com.vivo.advv.expr.common.StringSupport
    public boolean isSysString(String str) {
        return this.mSysString2Index.containsKey(str);
    }
}
