package com.vivo.secboxsdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes4.dex */
public class SecBoxCipherException extends Exception {
    public static final int SBC_ERROR_AES_DECRYPT_FAIL = -8;
    public static final int SBC_ERROR_AES_ENCRYPT_FAIL = -7;
    public static final int SBC_ERROR_BASE64_DECODE_FAILD = -17;
    public static final int SBC_ERROR_CHECK_SUM_FAIL = -15;
    public static final int SBC_ERROR_CRYPTO_BODY = -23;
    public static final int SBC_ERROR_CRYPTO_ENTRY_PARSE_FAILED = -22;
    public static final int SBC_ERROR_CRYPTO_HEADER = -20;
    public static final int SBC_ERROR_CRYPTO_HEADER_FORMAT_PARSE_FAILED = -16;
    public static final int SBC_ERROR_FREE_MEMORY_FAIL = -6;
    public static final int SBC_ERROR_HASH_NOT_MATCH = -11;
    public static final int SBC_ERROR_INPUT_INVALID = -19;
    public static final int SBC_ERROR_INPUT_PARAMETER_LEN = -2;
    public static final int SBC_ERROR_INPUT_PARAMETER_NULL = -1;
    public static final int SBC_ERROR_KEY_VERSION_NOT_MATCH = -14;
    public static final int SBC_ERROR_MELLOC_MEMORY_FAIL = -5;
    public static final int SBC_ERROR_OK = 0;
    public static final int SBC_ERROR_OUTPUT_PARAMETER_LEN = -4;
    public static final int SBC_ERROR_OUTPUT_PARAMETER_NULL = -3;
    public static final int SBC_ERROR_PROTOCOL_IV_IS_NULL = -24;
    public static final int SBC_ERROR_PROTOCOL_KEY_CIPHER_IS_NULL = -25;
    public static final int SBC_ERROR_RSA_DECRYPT_FAIL = -10;
    public static final int SBC_ERROR_RSA_ENCRYPT_FAIL = -9;
    public static final int SBC_ERROR_TIMEOUT_EXCEPTION = -18;
    public static final int SBC_ERROR_UNKNOWN = -1000;
    public static final int SBC_ERROR_UNKNOWN_ENCRYPT_TYPE = -12;
    public static final int SBC_ERROR_UNKNOWN_OPERATE_TYPE = -13;
    public static final int SBC_ERROR_UNSUPPORTED_ENCODING_EXCEPTION = -26;
    public static final int SBC_ERROR_UNSUPPORTED_PROTOCOL_VERSION = -21;
    private int mErrorCode;

    public SecBoxCipherException(int i2) {
        this("", i2);
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printStream);
    }

    public void setErrorCode(int i2) {
        this.mErrorCode = i2;
    }

    public SecBoxCipherException(String str, int i2) {
        this(str, null, i2);
    }

    public SecBoxCipherException(Throwable th, int i2) {
        this("", th, i2);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("ErrorCode = " + getErrorCode());
        super.printStackTrace(printWriter);
    }

    public SecBoxCipherException(String str, Throwable th, int i2) {
        super("err=" + i2 + ". " + str, th);
        this.mErrorCode = i2;
    }

    public SecBoxCipherException(Exception exc) {
        this(exc.getMessage(), exc, -1000);
    }
}
