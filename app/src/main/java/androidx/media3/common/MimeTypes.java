package androidx.media3.common;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import b5.a;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class MimeTypes {
    public static final String APPLICATION_AIT = "application/vnd.dvb.ait";

    @UnstableApi
    public static final String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final String APPLICATION_CEA608 = "application/cea-608";
    public static final String APPLICATION_CEA708 = "application/cea-708";
    public static final String APPLICATION_DVBSUBS = "application/dvbsubs";

    @UnstableApi
    public static final String APPLICATION_EMSG = "application/x-emsg";

    @UnstableApi
    public static final String APPLICATION_EXIF = "application/x-exif";

    @UnstableApi
    public static final String APPLICATION_ICY = "application/x-icy";
    public static final String APPLICATION_ID3 = "application/id3";
    public static final String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final String APPLICATION_MATROSKA = "application/x-matroska";
    public static final String APPLICATION_MP4 = "application/mp4";
    public static final String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final String APPLICATION_MPD = "application/dash+xml";
    public static final String APPLICATION_PGS = "application/pgs";

    @Deprecated
    public static final String APPLICATION_RAWCC = "application/x-rawcc";
    public static final String APPLICATION_RTSP = "application/x-rtsp";

    @UnstableApi
    public static final String APPLICATION_SCTE35 = "application/x-scte35";
    public static final String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final String APPLICATION_SUBRIP = "application/x-subrip";
    public static final String APPLICATION_TTML = "application/ttml+xml";
    public static final String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final String APPLICATION_VOBSUB = "application/vobsub";
    public static final String APPLICATION_WEBM = "application/webm";
    public static final String AUDIO_AAC = "audio/mp4a-latm";
    public static final String AUDIO_AC3 = "audio/ac3";
    public static final String AUDIO_AC4 = "audio/ac4";
    public static final String AUDIO_ALAC = "audio/alac";
    public static final String AUDIO_ALAW = "audio/g711-alaw";
    public static final String AUDIO_AMR = "audio/amr";
    public static final String AUDIO_AMR_NB = "audio/3gpp";
    public static final String AUDIO_AMR_WB = "audio/amr-wb";
    public static final String AUDIO_DTS = "audio/vnd.dts";
    public static final String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final String AUDIO_DTS_HD = "audio/vnd.dts.hd";

    @UnstableApi
    public static final String AUDIO_DTS_X = "audio/vnd.dts.uhd;profile=p2";

    @UnstableApi
    public static final String AUDIO_EXOPLAYER_MIDI = "audio/x-exoplayer-midi";
    public static final String AUDIO_E_AC3 = "audio/eac3";
    public static final String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final String AUDIO_FLAC = "audio/flac";

    @UnstableApi
    public static final String AUDIO_MATROSKA = "audio/x-matroska";
    public static final String AUDIO_MIDI = "audio/midi";
    public static final String AUDIO_MLAW = "audio/g711-mlaw";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEGH_MHA1 = "audio/mha1";
    public static final String AUDIO_MPEGH_MHM1 = "audio/mhm1";
    public static final String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final String AUDIO_MSGSM = "audio/gsm";
    public static final String AUDIO_OGG = "audio/ogg";
    public static final String AUDIO_OPUS = "audio/opus";
    public static final String AUDIO_RAW = "audio/raw";
    public static final String AUDIO_TRUEHD = "audio/true-hd";

    @UnstableApi
    public static final String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final String AUDIO_VORBIS = "audio/vorbis";
    public static final String AUDIO_WAV = "audio/wav";
    public static final String AUDIO_WEBM = "audio/webm";

    @UnstableApi
    public static final String BASE_TYPE_APPLICATION = "application";

    @UnstableApi
    public static final String BASE_TYPE_AUDIO = "audio";

    @UnstableApi
    public static final String BASE_TYPE_IMAGE = "image";

    @UnstableApi
    public static final String BASE_TYPE_TEXT = "text";

    @UnstableApi
    public static final String BASE_TYPE_VIDEO = "video";

    @UnstableApi
    public static final String CODEC_E_AC3_JOC = "ec+3";
    public static final String IMAGE_HEIC = "image/heic";
    public static final String IMAGE_HEIF = "image/heif";
    public static final String IMAGE_JPEG = "image/jpeg";
    public static final String IMAGE_PNG = "image/png";
    public static final String IMAGE_WEBP = "image/webp";

    @UnstableApi
    public static final String TEXT_EXOPLAYER_CUES = "text/x-exoplayer-cues";
    public static final String TEXT_SSA = "text/x-ssa";

    @UnstableApi
    public static final String TEXT_UNKNOWN = "text/x-unknown";
    public static final String TEXT_VTT = "text/vtt";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_AVI = "video/x-msvideo";
    public static final String VIDEO_DIVX = "video/divx";
    public static final String VIDEO_DOLBY_VISION = "video/dolby-vision";

    @UnstableApi
    public static final String VIDEO_FLV = "video/x-flv";
    public static final String VIDEO_H263 = "video/3gpp";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";

    @UnstableApi
    public static final String VIDEO_MATROSKA = "video/x-matroska";
    public static final String VIDEO_MJPEG = "video/mjpeg";
    public static final String VIDEO_MP2T = "video/mp2t";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_MP42 = "video/mp42";
    public static final String VIDEO_MP43 = "video/mp43";
    public static final String VIDEO_MP4V = "video/mp4v-es";
    public static final String VIDEO_MPEG = "video/mpeg";
    public static final String VIDEO_MPEG2 = "video/mpeg2";
    public static final String VIDEO_OGG = "video/ogg";
    public static final String VIDEO_PS = "video/mp2p";

    @UnstableApi
    public static final String VIDEO_RAW = "video/raw";

    @UnstableApi
    public static final String VIDEO_UNKNOWN = "video/x-unknown";
    public static final String VIDEO_VC1 = "video/wvc1";

    @UnstableApi
    public static final String VIDEO_VP8 = "video/x-vnd.on2.vp8";

    @UnstableApi
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final String VIDEO_WEBM = "video/webm";
    private static final ArrayList<CustomMimeType> customMimeTypes = new ArrayList<>();
    private static final Pattern MP4A_RFC_6381_CODEC_PATTERN = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;

        public CustomMimeType(String str, String str2, int i10) {
            this.mimeType = str;
            this.codecPrefix = str2;
            this.trackType = i10;
        }
    }

    @VisibleForTesting
    public static final class Mp4aObjectType {
        public final int audioObjectTypeIndication;
        public final int objectTypeIndication;

        public Mp4aObjectType(int i10, int i11) {
            this.objectTypeIndication = i10;
            this.audioObjectTypeIndication = i11;
        }

        public int getEncoding() {
            int i10 = this.audioObjectTypeIndication;
            if (i10 == 2) {
                return 10;
            }
            if (i10 == 5) {
                return 11;
            }
            if (i10 == 29) {
                return 12;
            }
            if (i10 == 42) {
                return 16;
            }
            if (i10 != 22) {
                return i10 != 23 ? 0 : 15;
            }
            return 1073741824;
        }
    }

    private MimeTypes() {
    }

    @UnstableApi
    public static boolean allSamplesAreSyncSamples(@Nullable String str, @Nullable String str2) {
        Mp4aObjectType objectTypeFromMp4aRFC6381CodecString;
        int encoding;
        if (str == null) {
            return false;
        }
        switch (str) {
            case "audio/mp4a-latm":
                if (str2 != null && (objectTypeFromMp4aRFC6381CodecString = getObjectTypeFromMp4aRFC6381CodecString(str2)) != null && (encoding = objectTypeFromMp4aRFC6381CodecString.getEncoding()) != 0 && encoding != 16) {
                }
                break;
        }
        return false;
    }

    @UnstableApi
    public static boolean containsCodecsCorrespondingToMimeType(@Nullable String str, String str2) {
        return getCodecsCorrespondingToMimeType(str, str2) != null;
    }

    @Nullable
    @UnstableApi
    public static String getAudioMediaMimeType(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isAudio(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    @Nullable
    @UnstableApi
    public static String getCodecsCorrespondingToMimeType(@Nullable String str, @Nullable String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        String[] splitCodecs = Util.splitCodecs(str);
        StringBuilder sb2 = new StringBuilder();
        for (String str3 : splitCodecs) {
            if (str2.equals(getMediaMimeType(str3))) {
                if (sb2.length() > 0) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
        }
        if (sb2.length() > 0) {
            return sb2.toString();
        }
        return null;
    }

    @Nullable
    private static String getCustomMimeTypeForCodec(String str) {
        int size = customMimeTypes.size();
        for (int i10 = 0; i10 < size; i10++) {
            CustomMimeType customMimeType = customMimeTypes.get(i10);
            if (str.startsWith(customMimeType.codecPrefix)) {
                return customMimeType.mimeType;
            }
        }
        return null;
    }

    @UnstableApi
    public static int getEncoding(String str, @Nullable String str2) {
        Mp4aObjectType objectTypeFromMp4aRFC6381CodecString;
        str.hashCode();
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (str2 == null || (objectTypeFromMp4aRFC6381CodecString = getObjectTypeFromMp4aRFC6381CodecString(str2)) == null) {
                    return 0;
                }
                return objectTypeFromMp4aRFC6381CodecString.getEncoding();
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    @Nullable
    @UnstableApi
    public static String getMediaMimeType(@Nullable String str) {
        Mp4aObjectType objectTypeFromMp4aRFC6381CodecString;
        String str2 = null;
        if (str == null) {
            return null;
        }
        String g10 = a.g(str.trim());
        if (g10.startsWith("avc1") || g10.startsWith("avc3")) {
            return VIDEO_H264;
        }
        if (g10.startsWith("hev1") || g10.startsWith("hvc1")) {
            return VIDEO_H265;
        }
        if (g10.startsWith("dvav") || g10.startsWith("dva1") || g10.startsWith("dvhe") || g10.startsWith("dvh1")) {
            return VIDEO_DOLBY_VISION;
        }
        if (g10.startsWith("av01")) {
            return VIDEO_AV1;
        }
        if (g10.startsWith("vp9") || g10.startsWith("vp09")) {
            return VIDEO_VP9;
        }
        if (g10.startsWith("vp8") || g10.startsWith("vp08")) {
            return VIDEO_VP8;
        }
        if (!g10.startsWith("mp4a")) {
            return g10.startsWith("mha1") ? AUDIO_MPEGH_MHA1 : g10.startsWith("mhm1") ? AUDIO_MPEGH_MHM1 : (g10.startsWith("ac-3") || g10.startsWith("dac3")) ? AUDIO_AC3 : (g10.startsWith("ec-3") || g10.startsWith("dec3")) ? AUDIO_E_AC3 : g10.startsWith(CODEC_E_AC3_JOC) ? AUDIO_E_AC3_JOC : (g10.startsWith("ac-4") || g10.startsWith("dac4")) ? AUDIO_AC4 : g10.startsWith("dtsc") ? AUDIO_DTS : g10.startsWith("dtse") ? AUDIO_DTS_EXPRESS : (g10.startsWith("dtsh") || g10.startsWith("dtsl")) ? AUDIO_DTS_HD : g10.startsWith("dtsx") ? AUDIO_DTS_X : g10.startsWith("opus") ? AUDIO_OPUS : g10.startsWith("vorbis") ? AUDIO_VORBIS : g10.startsWith("flac") ? AUDIO_FLAC : g10.startsWith("stpp") ? APPLICATION_TTML : g10.startsWith("wvtt") ? TEXT_VTT : g10.contains("cea708") ? APPLICATION_CEA708 : (g10.contains("eia608") || g10.contains("cea608")) ? APPLICATION_CEA608 : getCustomMimeTypeForCodec(g10);
        }
        if (g10.startsWith("mp4a.") && (objectTypeFromMp4aRFC6381CodecString = getObjectTypeFromMp4aRFC6381CodecString(g10)) != null) {
            str2 = getMimeTypeFromMp4ObjectType(objectTypeFromMp4aRFC6381CodecString.objectTypeIndication);
        }
        return str2 == null ? AUDIO_AAC : str2;
    }

    @Nullable
    @UnstableApi
    public static String getMimeTypeFromMp4ObjectType(int i10) {
        if (i10 == 32) {
            return VIDEO_MP4V;
        }
        if (i10 == 33) {
            return VIDEO_H264;
        }
        if (i10 == 35) {
            return VIDEO_H265;
        }
        if (i10 == 64) {
            return AUDIO_AAC;
        }
        if (i10 == 163) {
            return VIDEO_VC1;
        }
        if (i10 == 177) {
            return VIDEO_VP9;
        }
        if (i10 == 165) {
            return AUDIO_AC3;
        }
        if (i10 == 166) {
            return AUDIO_E_AC3;
        }
        switch (i10) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return AUDIO_AAC;
            case 105:
            case 107:
                return AUDIO_MPEG;
            case 106:
                return VIDEO_MPEG;
            default:
                switch (i10) {
                    case 169:
                    case 172:
                        return AUDIO_DTS;
                    case 170:
                    case 171:
                        return AUDIO_DTS_HD;
                    case 173:
                        return AUDIO_OPUS;
                    case 174:
                        return AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    @Nullable
    @VisibleForTesting
    public static Mp4aObjectType getObjectTypeFromMp4aRFC6381CodecString(String str) {
        Matcher matcher = MP4A_RFC_6381_CODEC_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String str2 = (String) Assertions.checkNotNull(matcher.group(1));
        String group = matcher.group(2);
        try {
            return new Mp4aObjectType(Integer.parseInt(str2, 16), group != null ? Integer.parseInt(group) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    @UnstableApi
    public static String getTextMediaMimeType(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isText(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    @Nullable
    @UnstableApi
    private static String getTopLevelType(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }

    @UnstableApi
    public static int getTrackType(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (isAudio(str)) {
            return 1;
        }
        if (isVideo(str)) {
            return 2;
        }
        if (isText(str)) {
            return 3;
        }
        if (isImage(str)) {
            return 4;
        }
        if (APPLICATION_ID3.equals(str) || APPLICATION_EMSG.equals(str) || APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        return getTrackTypeForCustomMimeType(str);
    }

    private static int getTrackTypeForCustomMimeType(String str) {
        int size = customMimeTypes.size();
        for (int i10 = 0; i10 < size; i10++) {
            CustomMimeType customMimeType = customMimeTypes.get(i10);
            if (str.equals(customMimeType.mimeType)) {
                return customMimeType.trackType;
            }
        }
        return -1;
    }

    @UnstableApi
    public static int getTrackTypeOfCodec(String str) {
        return getTrackType(getMediaMimeType(str));
    }

    @Nullable
    @UnstableApi
    public static String getVideoMediaMimeType(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (String str2 : Util.splitCodecs(str)) {
            String mediaMimeType = getMediaMimeType(str2);
            if (mediaMimeType != null && isVideo(mediaMimeType)) {
                return mediaMimeType;
            }
        }
        return null;
    }

    @UnstableApi
    public static boolean isAudio(@Nullable String str) {
        return "audio".equals(getTopLevelType(str));
    }

    @UnstableApi
    public static boolean isImage(@Nullable String str) {
        return "image".equals(getTopLevelType(str));
    }

    @UnstableApi
    public static boolean isMatroska(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith(VIDEO_WEBM) || str.startsWith(AUDIO_WEBM) || str.startsWith(APPLICATION_WEBM) || str.startsWith(VIDEO_MATROSKA) || str.startsWith(AUDIO_MATROSKA) || str.startsWith(APPLICATION_MATROSKA);
    }

    @UnstableApi
    public static boolean isText(@Nullable String str) {
        return "text".equals(getTopLevelType(str)) || APPLICATION_CEA608.equals(str) || APPLICATION_CEA708.equals(str) || APPLICATION_MP4CEA608.equals(str) || APPLICATION_SUBRIP.equals(str) || APPLICATION_TTML.equals(str) || APPLICATION_TX3G.equals(str) || APPLICATION_MP4VTT.equals(str) || APPLICATION_RAWCC.equals(str) || APPLICATION_VOBSUB.equals(str) || APPLICATION_PGS.equals(str) || APPLICATION_DVBSUBS.equals(str);
    }

    @UnstableApi
    public static boolean isVideo(@Nullable String str) {
        return "video".equals(getTopLevelType(str));
    }

    @UnstableApi
    public static String normalizeMimeType(String str) {
        str.hashCode();
        switch (str) {
            case "audio/x-flac":
                return AUDIO_FLAC;
            case "audio/x-wav":
                return AUDIO_WAV;
            case "audio/mp3":
                return AUDIO_MPEG;
            default:
                return str;
        }
    }

    @UnstableApi
    public static void registerCustomMimeType(String str, String str2, int i10) {
        CustomMimeType customMimeType = new CustomMimeType(str, str2, i10);
        int size = customMimeTypes.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            ArrayList<CustomMimeType> arrayList = customMimeTypes;
            if (str.equals(arrayList.get(i11).mimeType)) {
                arrayList.remove(i11);
                break;
            }
            i11++;
        }
        customMimeTypes.add(customMimeType);
    }
}
