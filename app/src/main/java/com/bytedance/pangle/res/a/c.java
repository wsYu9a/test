package com.bytedance.pangle.res.a;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c {
    public final int a(File file, boolean z10, StringBuilder sb2) {
        String byteArrayOutputStream;
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/ZeusResMapping");
                if (entry == null) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 200;
                }
                if (z10) {
                    File file2 = new File(file.getParentFile(), "resMappingBak");
                    if (!file2.exists()) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "resMappingBakFile is not exists. " + file2.getAbsolutePath());
                        sb2.append("resMappingBakFile is not exists. ");
                        sb2.append(file2.getAbsolutePath());
                        com.bytedance.pangle.util.g.a(zipFile2);
                        return 300;
                    }
                    FileInputStream fileInputStream = new FileInputStream(file2);
                    FileChannel channel = fileInputStream.getChannel();
                    byteArrayOutputStream = Charset.defaultCharset().newDecoder().decode(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()).asReadOnlyBuffer()).toString();
                    channel.close();
                    fileInputStream.close();
                } else {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    InputStream inputStream = zipFile2.getInputStream(entry);
                    if (inputStream != null) {
                        ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                        WritableByteChannel newChannel2 = Channels.newChannel(byteArrayOutputStream2);
                        com.bytedance.pangle.util.h.a(newChannel, newChannel2);
                        newChannel.close();
                        newChannel2.close();
                    }
                    byteArrayOutputStream = byteArrayOutputStream2.toString();
                }
                if (TextUtils.isEmpty(byteArrayOutputStream)) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "zeusResMappingContent empty, useBakFile:".concat(String.valueOf(z10)));
                    sb2.append("zeusResMappingContent isEmpty. useBakFile:");
                    sb2.append(z10);
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 300;
                }
                JSONObject jSONObject = new JSONObject(byteArrayOutputStream);
                JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream);
                JSONArray jSONArray = (JSONArray) jSONObject.get("fileNames");
                HashSet hashSet = new HashSet();
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    hashSet.add((String) jSONArray.get(i10));
                }
                int[] iArr = {0};
                a(file, (HashSet<String>) hashSet, new h() { // from class: com.bytedance.pangle.res.a.c.1

                    /* renamed from: a */
                    final /* synthetic */ JSONObject f7778a;

                    /* renamed from: b */
                    final /* synthetic */ JSONObject f7779b;

                    /* renamed from: c */
                    final /* synthetic */ int[] f7780c;

                    /* renamed from: d */
                    final /* synthetic */ HashSet f7781d;

                    public AnonymousClass1(JSONObject jSONObject3, JSONObject jSONObject4, int[] iArr2, HashSet hashSet2) {
                        jSONObject3 = jSONObject3;
                        jSONObject4 = jSONObject4;
                        iArr = iArr2;
                        hashSet = hashSet2;
                    }

                    @Override // com.bytedance.pangle.res.a.h
                    public final int a(int i11) {
                        String str = "0x" + Integer.toHexString(i11);
                        String str2 = (String) jSONObject3.opt(str);
                        if (str2 == null) {
                            return i11;
                        }
                        int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                        if (identifier == 0) {
                            identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll(hf.e.f26694a, p1.b.f29697h), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
                        }
                        if (identifier == 0) {
                            ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                            return i11;
                        }
                        String str3 = "0x" + Integer.toHexString(identifier);
                        if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                            jSONObject4.remove(str);
                        }
                        try {
                            jSONObject4.put(str3, str2);
                        } catch (Throwable th2) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th2);
                        }
                        if (identifier != i11) {
                            int[] iArr2 = iArr;
                            iArr2[0] = iArr2[0] + 1;
                        }
                        return identifier;
                    }

                    @Override // com.bytedance.pangle.res.a.h
                    public final boolean a(String str) {
                        return hashSet.contains(str);
                    }
                });
                ZeusLogger.d(ZeusLogger.TAG_INSTALL, "modifyRes count = " + iArr2[0]);
                if (com.bytedance.pangle.util.h.a(jSONObject2.toString(), new File(file.getParentFile(), "resMappingBak"), sb2)) {
                    com.bytedance.pangle.util.g.a(zipFile2);
                    return 100;
                }
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "writeText failed." + sb2.toString());
                sb2.append("writeText failed.");
                com.bytedance.pangle.util.g.a(zipFile2);
                return 300;
            } catch (Throwable th2) {
                th = th2;
                zipFile = zipFile2;
                try {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "modifyRes failed. catch: " + th.getMessage(), th);
                    sb2.append("modifyRes failed. catch: ");
                    sb2.append(th.getMessage());
                    return 300;
                } finally {
                    if (zipFile != null) {
                        com.bytedance.pangle.util.g.a(zipFile);
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: com.bytedance.pangle.res.a.c$1 */
    public class AnonymousClass1 implements h {

        /* renamed from: a */
        final /* synthetic */ JSONObject f7778a;

        /* renamed from: b */
        final /* synthetic */ JSONObject f7779b;

        /* renamed from: c */
        final /* synthetic */ int[] f7780c;

        /* renamed from: d */
        final /* synthetic */ HashSet f7781d;

        public AnonymousClass1(JSONObject jSONObject3, JSONObject jSONObject4, int[] iArr2, HashSet hashSet2) {
            jSONObject3 = jSONObject3;
            jSONObject4 = jSONObject4;
            iArr = iArr2;
            hashSet = hashSet2;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final int a(int i11) {
            String str = "0x" + Integer.toHexString(i11);
            String str2 = (String) jSONObject3.opt(str);
            if (str2 == null) {
                return i11;
            }
            int identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1], str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
            if (identifier == 0) {
                identifier = Zeus.getAppApplication().getResources().getIdentifier(str2.split(" ")[1].replaceAll(hf.e.f26694a, p1.b.f29697h), str2.split(" ")[0], Zeus.getAppApplication().getPackageName());
            }
            if (identifier == 0) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, "getIdentifier failed. resName is ".concat(str2));
                return i11;
            }
            String str3 = "0x" + Integer.toHexString(identifier);
            if (TextUtils.equals(jSONObject4.optString(str), str2)) {
                jSONObject4.remove(str);
            }
            try {
                jSONObject4.put(str3, str2);
            } catch (Throwable th2) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "update resMappingBak failed.", th2);
            }
            if (identifier != i11) {
                int[] iArr2 = iArr;
                iArr2[0] = iArr2[0] + 1;
            }
            return identifier;
        }

        @Override // com.bytedance.pangle.res.a.h
        public final boolean a(String str) {
            return hashSet.contains(str);
        }
    }

    private static void a(File file, HashSet<String> hashSet, h hVar) {
        int i10;
        MappedByteBuffer a10 = a(file);
        int capacity = a10.capacity();
        if (capacity >= 22) {
            int i11 = capacity - 22;
            int min = Math.min(i11, 65535);
            for (int i12 = 0; i12 < min; i12++) {
                i10 = i11 - i12;
                if (a10.getInt(i10) == 101010256 && a10.getShort(i10 + 20) == i12) {
                    break;
                }
            }
        }
        i10 = -1;
        if (i10 != -1) {
            int i13 = a10.getInt(i10 + 12);
            int i14 = a10.getInt(i10 + 16);
            int i15 = i13 + i14;
            while (i14 < i15) {
                if (a10.getInt(i14) == 33639248) {
                    int i16 = a10.getShort(i14 + 28);
                    short s10 = a10.getShort(i14 + 30);
                    byte[] bArr = new byte[i16];
                    for (int i17 = 0; i17 < i16; i17++) {
                        bArr[i17] = a10.get(i14 + 46 + i17);
                    }
                    String str = new String(bArr);
                    int i18 = a10.getInt(i14 + 20);
                    int i19 = a10.getInt(i14 + 24);
                    if (hashSet.contains(str)) {
                        if (i18 == i19) {
                            com.bytedance.pangle.util.e<Integer, byte[]> a11 = a(a10, a10.getInt(i14 + 42), str);
                            try {
                                byte[] bArr2 = a11.f7854b;
                                if (!TextUtils.isEmpty(str) && hVar.a(str)) {
                                    if (str.equals("AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, "AndroidManifest.xml")) {
                                        k.a(bArr2, hVar);
                                    } else if (str.equals("resources.arsc")) {
                                        new a(bArr2, hVar).a();
                                    }
                                }
                                for (int i20 = 0; i20 < a11.f7854b.length; i20++) {
                                    a10.put(a11.f7853a.intValue() + i20, a11.f7854b[i20]);
                                }
                            } catch (Throwable th2) {
                                throw new RuntimeException(th2);
                            }
                        } else {
                            throw new Throwable(str + " is compressed.");
                        }
                    }
                    i14 += i16 + 46 + s10;
                } else {
                    throw new RuntimeException("Expected: 0x02014b50, got: " + a10.getInt(i14));
                }
            }
            return;
        }
        throw new Throwable("endOfCentralPosition == -1");
    }

    private static com.bytedance.pangle.util.e<Integer, byte[]> a(MappedByteBuffer mappedByteBuffer, int i10, String str) {
        if (mappedByteBuffer.getInt(i10) == 67324752) {
            int i11 = mappedByteBuffer.getInt(i10 + 18);
            int i12 = mappedByteBuffer.getInt(i10 + 22);
            if (i11 == i12) {
                byte[] bArr = new byte[i12];
                int i13 = i10 + 30 + mappedByteBuffer.getShort(i10 + 26) + mappedByteBuffer.getShort(i10 + 28);
                for (int i14 = 0; i14 < i12; i14++) {
                    bArr[i14] = mappedByteBuffer.get(i13 + i14);
                }
                return new com.bytedance.pangle.util.e<>(Integer.valueOf(i13), bArr);
            }
            throw new RuntimeException(str + " is compressed. compressSize:" + i11 + " size:" + i12);
        }
        throw new RuntimeException("Expected: 0x04034b50, got: " + mappedByteBuffer.getInt(i10) + " FileName:" + str);
    }

    private static MappedByteBuffer a(File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            ZeusLogger.d("temp-pxr", "mappedByteBuffer " + file.canWrite());
            if (!file.canWrite()) {
                file.setWritable(true);
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            try {
                FileChannel channel = randomAccessFile2.getChannel();
                long size = channel.size();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, size);
                byte[] bArr = new byte[4194304];
                long j10 = size / PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED;
                int i10 = (int) (size % PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED);
                for (int i11 = 0; i11 < j10; i11++) {
                    map.get(bArr);
                }
                if (i10 > 0) {
                    map.get(new byte[i10]);
                }
                map.order(ByteOrder.LITTLE_ENDIAN);
                randomAccessFile2.close();
                return map;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
