package com.vivo.advv.vaf.virtualview.loader;

import com.vivo.advv.vaf.framework.VafContext;
import com.vivo.advv.vaf.virtualview.util.VVLog;
import com.vivo.advv.virtualview.common.Common;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class BinaryLoader {
    private static final String TAG = "BinaryLoader_TMTEST";

    @Deprecated
    private int[] mDepPageIds;
    private ExprCodeLoader mExprCodeLoader;
    private StringLoader mStringLoader;
    private UiCodeLoader mUiCodeLoader;

    public void destroy() {
        this.mStringLoader = null;
        this.mExprCodeLoader = null;
        this.mUiCodeLoader = null;
    }

    public int loadFromBuffer(byte[] bArr) {
        return loadFromBuffer(bArr, false);
    }

    public int loadFromFile(String str) {
        int i2 = -1;
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            i2 = loadFromBuffer(bArr);
            fileInputStream.close();
            return i2;
        } catch (FileNotFoundException e2) {
            VVLog.e(TAG, "error:" + e2);
            e2.printStackTrace();
            return i2;
        } catch (IOException e3) {
            VVLog.e(TAG, "error:" + e3);
            e3.printStackTrace();
            return i2;
        }
    }

    public void setExprCodeManager(ExprCodeLoader exprCodeLoader) {
        this.mExprCodeLoader = exprCodeLoader;
    }

    public void setPageContext(VafContext vafContext) {
        this.mStringLoader = vafContext.getStringLoader();
    }

    public void setUiCodeManager(UiCodeLoader uiCodeLoader) {
        this.mUiCodeLoader = uiCodeLoader;
    }

    public int loadFromBuffer(byte[] bArr, boolean z) {
        if (bArr != null) {
            this.mDepPageIds = null;
            if (bArr.length > 27) {
                if (Arrays.equals(Common.TAG.getBytes(), Arrays.copyOfRange(bArr, 0, 5))) {
                    CodeReader codeReader = new CodeReader();
                    codeReader.setCode(bArr);
                    codeReader.seekBy(5);
                    short readShort = codeReader.readShort();
                    short readShort2 = codeReader.readShort();
                    short readShort3 = codeReader.readShort();
                    codeReader.setPatchVersion(readShort3);
                    if (1 == readShort && readShort2 == 0) {
                        int readInt = codeReader.readInt();
                        codeReader.seekBy(4);
                        int readInt2 = codeReader.readInt();
                        codeReader.seekBy(4);
                        int readInt3 = codeReader.readInt();
                        codeReader.seekBy(4);
                        codeReader.readInt();
                        codeReader.seekBy(4);
                        short readShort4 = codeReader.readShort();
                        int readShort5 = codeReader.readShort();
                        if (readShort5 > 0) {
                            this.mDepPageIds = new int[readShort5];
                            for (int i2 = 0; i2 < readShort5; i2++) {
                                this.mDepPageIds[i2] = codeReader.readShort();
                            }
                        }
                        if (codeReader.seek(readInt)) {
                            boolean loadFromBuffer = !z ? this.mUiCodeLoader.loadFromBuffer(codeReader, readShort4, readShort3) : this.mUiCodeLoader.forceLoadFromBuffer(codeReader, readShort4, readShort3);
                            if (codeReader.getPos() == readInt2) {
                                StringLoader stringLoader = this.mStringLoader;
                                if (stringLoader != null) {
                                    loadFromBuffer = stringLoader.loadFromBuffer(codeReader, readShort4);
                                } else {
                                    VVLog.e(TAG, "mStringManager is null");
                                }
                            }
                            if (codeReader.getPos() == readInt3) {
                                ExprCodeLoader exprCodeLoader = this.mExprCodeLoader;
                                if (exprCodeLoader != null) {
                                    loadFromBuffer = exprCodeLoader.loadFromBuffer(codeReader, readShort4);
                                } else {
                                    VVLog.e(TAG, "mExprCodeStore is null");
                                }
                            }
                            codeReader.getPos();
                            if (loadFromBuffer) {
                                return readShort4;
                            }
                        }
                    } else {
                        VVLog.e(TAG, "version dismatch");
                    }
                } else {
                    VVLog.e(TAG, "loadFromBuffer failed tag is invalidate.");
                }
            } else {
                VVLog.e(TAG, "file len invalidate:" + bArr.length);
            }
        } else {
            VVLog.e(TAG, "buf is null");
        }
        return -1;
    }
}
