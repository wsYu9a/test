package com.alimm.tanx.core.view.player.cache.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.alimm.tanx.core.view.player.cache.videocache.log.Logger;
import com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ProxyCacheUtils {
    static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final Logger LOG = LoggerFactory.getLogger("ProxyCacheUtils");
    static final int MAX_ARRAY_PREVIEW = 16;

    public static void assertBuffer(byte[] bArr, long j10, int i10) {
        Preconditions.checkNotNull(bArr, "Buffer must be not null!");
        boolean z10 = false;
        Preconditions.checkArgument(j10 >= 0, "Data offset must be positive!");
        if (i10 >= 0 && i10 <= bArr.length) {
            z10 = true;
        }
        Preconditions.checkArgument(z10, "Length must be in range [0..buffer.length]");
    }

    private static String bytesToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b10 : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b10)));
        }
        return stringBuffer.toString();
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                LOG.error("Error closing resource", e10);
            }
        }
    }

    public static String computeMD5(String str) {
        try {
            return bytesToHexString(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Error decoding url", e10);
        }
    }

    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Error encoding url", e10);
        }
    }

    public static String getSupposablyMime(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    public static String preview(byte[] bArr, int i10) {
        int min = Math.min(16, Math.max(i10, 0));
        String arrays = Arrays.toString(Arrays.copyOfRange(bArr, 0, min));
        if (min >= i10) {
            return arrays;
        }
        return arrays.substring(0, arrays.length() - 1) + ", ...]";
    }
}
