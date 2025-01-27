package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.umeng.commonsdk.stateless.b;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.tools.zip.UnixStat;

/* loaded from: classes.dex */
public class ExifInterface {
    private static final int A = 12;
    private static final HashMap<Integer, Integer> A0;
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    private static final short B = 85;
    static final Charset B0;
    private static final String C = "PENTAX";
    static final byte[] C0;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    private static final int D = 6;
    static final byte D0 = -1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static SimpleDateFormat E = null;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    static final short F = 18761;
    private static final byte F0 = -64;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    static final short G = 19789;
    private static final byte G0 = -63;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte H = 42;
    private static final byte H0 = -62;
    private static final int I = 8;
    private static final byte I0 = -61;
    private static final int J = 1;
    private static final byte J0 = -59;
    private static final int K = 2;
    private static final byte K0 = -58;
    private static final int L = 3;
    private static final byte L0 = -57;
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    private static final int M = 4;
    private static final byte M0 = -55;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final int N = 5;
    private static final byte N0 = -54;
    private static final int O = 6;
    private static final byte O0 = -53;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int P = 7;
    private static final byte P0 = -51;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int Q = 8;
    private static final byte Q0 = -50;
    private static final int R = 9;
    private static final byte R0 = -49;
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final int S = 10;
    private static final byte S0 = -38;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final int T = 11;
    static final byte T0 = -31;
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";

    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    private static final int U = 12;
    private static final byte U0 = -2;
    private static final int V = 13;
    static final byte V0 = -39;
    private static final int W0 = 0;

    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;

    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    private static final int X0 = 1;
    private static final int Y0 = 2;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final ExifTag[] Z;
    private static final int Z0 = 3;

    /* renamed from: a, reason: collision with root package name */
    private static final String f2300a = "ExifInterface";
    private static final ExifTag[] a0;
    private static final int a1 = 4;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f2301b = false;
    private static final ExifTag[] b0;
    private static final int b1 = 5;

    /* renamed from: c, reason: collision with root package name */
    private static final String f2302c = "ExifIFDPointer";
    private static final ExifTag[] c0;
    private static final int c1 = 6;

    /* renamed from: d, reason: collision with root package name */
    private static final String f2303d = "GPSInfoIFDPointer";
    private static final ExifTag[] d0;
    private static final int d1 = 7;

    /* renamed from: e, reason: collision with root package name */
    private static final String f2304e = "InteroperabilityIFDPointer";
    private static final ExifTag e0;
    private static final int e1 = 8;

    /* renamed from: f, reason: collision with root package name */
    private static final String f2305f = "SubIFDPointer";
    private static final ExifTag[] f0;
    private static final int f1 = 9;

    /* renamed from: g, reason: collision with root package name */
    private static final String f2306g = "CameraSettingsIFDPointer";
    private static final ExifTag[] g0;
    private static final int g1 = 10;

    /* renamed from: h, reason: collision with root package name */
    private static final String f2307h = "ImageProcessingIFDPointer";
    private static final ExifTag[] h0;
    private static final int h1 = 11;

    /* renamed from: i, reason: collision with root package name */
    private static final String f2308i = "HasThumbnail";
    private static final ExifTag[] i0;
    private static final Pattern i1;

    /* renamed from: j, reason: collision with root package name */
    private static final String f2309j = "ThumbnailOffset";
    static final int j0 = 0;
    private static final Pattern j1;
    private static final String k = "ThumbnailLength";
    private static final int k0 = 1;
    private static final String l = "ThumbnailData";
    private static final int l0 = 2;
    private static final int m = 512;
    private static final int m0 = 3;
    static final int n0 = 4;
    static final int o0 = 5;
    private static final int p = 5000;
    private static final int p0 = 6;
    private static final int q0 = 7;
    private static final String r = "FUJIFILMCCD-RAW";
    private static final int r0 = 8;
    private static final int s = 84;
    private static final int s0 = 9;
    private static final int t = 160;
    static final ExifTag[][] t0;
    private static final int u = 4;
    private static final ExifTag[] u0;
    private static final short v = 20306;
    private static final ExifTag v0;
    private static final short w = 21330;
    private static final ExifTag w0;
    private static final HashMap<Integer, ExifTag>[] x0;
    private static final HashMap<String, ExifTag>[] y0;
    private static final int z = 8;
    private static final HashSet<String> z0;
    private boolean A1;
    private final String k1;
    private final AssetManager.AssetInputStream l1;
    private int m1;
    private final HashMap<String, ExifAttribute>[] n1;
    private Set<Integer> o1;
    private ByteOrder p1;
    private boolean q1;
    private int r1;
    private int s1;
    private byte[] t1;
    private int u1;
    private int v1;
    private int w1;
    private int x1;
    private int y1;
    private int z1;
    private static final List<Integer> n = Arrays.asList(1, 6, 3, 8);
    private static final List<Integer> o = Arrays.asList(2, 7, 4, 5);
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    private static final byte E0 = -40;
    static final byte[] q = {-1, E0, -1};
    private static final byte[] x = {79, 76, 89, 77, 80, 0};
    private static final byte[] y = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    static final String[] W = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final OutputStream f2316a;

        /* renamed from: b, reason: collision with root package name */
        private ByteOrder f2317b;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.f2316a = outputStream;
            this.f2317b = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.f2317b = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f2316a.write(bArr);
        }

        public void writeByte(int i2) throws IOException {
            this.f2316a.write(i2);
        }

        public void writeInt(int i2) throws IOException {
            ByteOrder byteOrder = this.f2317b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f2316a.write((i2 >>> 0) & 255);
                this.f2316a.write((i2 >>> 8) & 255);
                this.f2316a.write((i2 >>> 16) & 255);
                this.f2316a.write((i2 >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f2316a.write((i2 >>> 24) & 255);
                this.f2316a.write((i2 >>> 16) & 255);
                this.f2316a.write((i2 >>> 8) & 255);
                this.f2316a.write((i2 >>> 0) & 255);
            }
        }

        public void writeShort(short s) throws IOException {
            ByteOrder byteOrder = this.f2317b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.f2316a.write((s >>> 0) & 255);
                this.f2316a.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.f2316a.write((s >>> 8) & 255);
                this.f2316a.write((s >>> 0) & 255);
            }
        }

        public void writeUnsignedInt(long j2) throws IOException {
            writeInt((int) j2);
        }

        public void writeUnsignedShort(int i2) throws IOException {
            writeShort((short) i2);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            this.f2316a.write(bArr, i2, i3);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface IfdType {
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d2) {
            this((long) (d2 * 10000.0d), 10000L);
        }

        public double calculate() {
            double d2 = this.numerator;
            double d3 = this.denominator;
            Double.isNaN(d2);
            Double.isNaN(d3);
            return d2 / d3;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        Rational(long j2, long j3) {
            if (j3 == 0) {
                this.numerator = 0L;
                this.denominator = 1L;
            } else {
                this.numerator = j2;
                this.denominator = j3;
            }
        }
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, b.f26259a, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(f2305f, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(f2302c, 34665, 4), new ExifTag(f2303d, 34853, 4), new ExifTag(TAG_RW2_SENSOR_TOP_BORDER, 4, 4), new ExifTag(TAG_RW2_SENSOR_LEFT_BORDER, 5, 4), new ExifTag(TAG_RW2_SENSOR_BOTTOM_BORDER, 6, 4), new ExifTag(TAG_RW2_SENSOR_RIGHT_BORDER, 7, 4), new ExifTag(TAG_RW2_ISO, 23, 3), new ExifTag(TAG_RW2_JPG_FROM_RAW, 46, 7)};
        Z = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag(TAG_EXPOSURE_TIME, 33434, 5), new ExifTag(TAG_F_NUMBER, 33437, 5), new ExifTag(TAG_EXPOSURE_PROGRAM, 34850, 3), new ExifTag(TAG_SPECTRAL_SENSITIVITY, 34852, 2), new ExifTag(TAG_PHOTOGRAPHIC_SENSITIVITY, 34855, 3), new ExifTag(TAG_OECF, 34856, 7), new ExifTag(TAG_EXIF_VERSION, 36864, 2), new ExifTag(TAG_DATETIME_ORIGINAL, 36867, 2), new ExifTag(TAG_DATETIME_DIGITIZED, 36868, 2), new ExifTag(TAG_COMPONENTS_CONFIGURATION, 37121, 7), new ExifTag(TAG_COMPRESSED_BITS_PER_PIXEL, 37122, 5), new ExifTag(TAG_SHUTTER_SPEED_VALUE, 37377, 10), new ExifTag(TAG_APERTURE_VALUE, 37378, 5), new ExifTag(TAG_BRIGHTNESS_VALUE, 37379, 10), new ExifTag(TAG_EXPOSURE_BIAS_VALUE, 37380, 10), new ExifTag(TAG_MAX_APERTURE_VALUE, 37381, 5), new ExifTag(TAG_SUBJECT_DISTANCE, 37382, 5), new ExifTag(TAG_METERING_MODE, 37383, 3), new ExifTag(TAG_LIGHT_SOURCE, 37384, 3), new ExifTag(TAG_FLASH, 37385, 3), new ExifTag(TAG_FOCAL_LENGTH, 37386, 5), new ExifTag(TAG_SUBJECT_AREA, 37396, 3), new ExifTag(TAG_MAKER_NOTE, 37500, 7), new ExifTag(TAG_USER_COMMENT, 37510, 7), new ExifTag(TAG_SUBSEC_TIME, 37520, 2), new ExifTag(TAG_SUBSEC_TIME_ORIGINAL, 37521, 2), new ExifTag(TAG_SUBSEC_TIME_DIGITIZED, 37522, 2), new ExifTag(TAG_FLASHPIX_VERSION, UnixStat.LINK_FLAG, 7), new ExifTag(TAG_COLOR_SPACE, 40961, 3), new ExifTag(TAG_PIXEL_X_DIMENSION, 40962, 3, 4), new ExifTag(TAG_PIXEL_Y_DIMENSION, 40963, 3, 4), new ExifTag(TAG_RELATED_SOUND_FILE, 40964, 2), new ExifTag(f2304e, 40965, 4), new ExifTag(TAG_FLASH_ENERGY, 41483, 5), new ExifTag(TAG_SPATIAL_FREQUENCY_RESPONSE, 41484, 7), new ExifTag(TAG_FOCAL_PLANE_X_RESOLUTION, 41486, 5), new ExifTag(TAG_FOCAL_PLANE_Y_RESOLUTION, 41487, 5), new ExifTag(TAG_FOCAL_PLANE_RESOLUTION_UNIT, 41488, 3), new ExifTag(TAG_SUBJECT_LOCATION, 41492, 3), new ExifTag(TAG_EXPOSURE_INDEX, 41493, 5), new ExifTag(TAG_SENSING_METHOD, 41495, 3), new ExifTag(TAG_FILE_SOURCE, 41728, 7), new ExifTag(TAG_SCENE_TYPE, 41729, 7), new ExifTag(TAG_CFA_PATTERN, 41730, 7), new ExifTag(TAG_CUSTOM_RENDERED, 41985, 3), new ExifTag(TAG_EXPOSURE_MODE, 41986, 3), new ExifTag(TAG_WHITE_BALANCE, 41987, 3), new ExifTag(TAG_DIGITAL_ZOOM_RATIO, 41988, 5), new ExifTag(TAG_FOCAL_LENGTH_IN_35MM_FILM, 41989, 3), new ExifTag(TAG_SCENE_CAPTURE_TYPE, 41990, 3), new ExifTag(TAG_GAIN_CONTROL, 41991, 3), new ExifTag(TAG_CONTRAST, 41992, 3), new ExifTag(TAG_SATURATION, 41993, 3), new ExifTag(TAG_SHARPNESS, 41994, 3), new ExifTag(TAG_DEVICE_SETTING_DESCRIPTION, 41995, 7), new ExifTag(TAG_SUBJECT_DISTANCE_RANGE, 41996, 3), new ExifTag(TAG_IMAGE_UNIQUE_ID, 42016, 2), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        a0 = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag(TAG_GPS_VERSION_ID, 0, 1), new ExifTag(TAG_GPS_LATITUDE_REF, 1, 2), new ExifTag(TAG_GPS_LATITUDE, 2, 5), new ExifTag(TAG_GPS_LONGITUDE_REF, 3, 2), new ExifTag(TAG_GPS_LONGITUDE, 4, 5), new ExifTag(TAG_GPS_ALTITUDE_REF, 5, 1), new ExifTag(TAG_GPS_ALTITUDE, 6, 5), new ExifTag(TAG_GPS_TIMESTAMP, 7, 5), new ExifTag(TAG_GPS_SATELLITES, 8, 2), new ExifTag(TAG_GPS_STATUS, 9, 2), new ExifTag(TAG_GPS_MEASURE_MODE, 10, 2), new ExifTag(TAG_GPS_DOP, 11, 5), new ExifTag(TAG_GPS_SPEED_REF, 12, 2), new ExifTag(TAG_GPS_SPEED, 13, 5), new ExifTag(TAG_GPS_TRACK_REF, 14, 2), new ExifTag(TAG_GPS_TRACK, 15, 5), new ExifTag(TAG_GPS_IMG_DIRECTION_REF, 16, 2), new ExifTag(TAG_GPS_IMG_DIRECTION, 17, 5), new ExifTag(TAG_GPS_MAP_DATUM, 18, 2), new ExifTag(TAG_GPS_DEST_LATITUDE_REF, 19, 2), new ExifTag(TAG_GPS_DEST_LATITUDE, 20, 5), new ExifTag(TAG_GPS_DEST_LONGITUDE_REF, 21, 2), new ExifTag(TAG_GPS_DEST_LONGITUDE, 22, 5), new ExifTag(TAG_GPS_DEST_BEARING_REF, 23, 2), new ExifTag(TAG_GPS_DEST_BEARING, 24, 5), new ExifTag(TAG_GPS_DEST_DISTANCE_REF, 25, 2), new ExifTag(TAG_GPS_DEST_DISTANCE, 26, 5), new ExifTag(TAG_GPS_PROCESSING_METHOD, 27, 7), new ExifTag(TAG_GPS_AREA_INFORMATION, 28, 7), new ExifTag(TAG_GPS_DATESTAMP, 29, 2), new ExifTag(TAG_GPS_DIFFERENTIAL, 30, 3)};
        b0 = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag(TAG_INTEROPERABILITY_INDEX, 1, 2)};
        c0 = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag(TAG_NEW_SUBFILE_TYPE, 254, 4), new ExifTag(TAG_SUBFILE_TYPE, 255, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_WIDTH, 256, 3, 4), new ExifTag(TAG_THUMBNAIL_IMAGE_LENGTH, 257, 3, 4), new ExifTag(TAG_BITS_PER_SAMPLE, 258, 3), new ExifTag(TAG_COMPRESSION, 259, 3), new ExifTag(TAG_PHOTOMETRIC_INTERPRETATION, 262, 3), new ExifTag(TAG_IMAGE_DESCRIPTION, 270, 2), new ExifTag(TAG_MAKE, 271, 2), new ExifTag(TAG_MODEL, 272, 2), new ExifTag(TAG_STRIP_OFFSETS, b.f26259a, 3, 4), new ExifTag(TAG_ORIENTATION, 274, 3), new ExifTag(TAG_SAMPLES_PER_PIXEL, 277, 3), new ExifTag(TAG_ROWS_PER_STRIP, 278, 3, 4), new ExifTag(TAG_STRIP_BYTE_COUNTS, 279, 3, 4), new ExifTag(TAG_X_RESOLUTION, 282, 5), new ExifTag(TAG_Y_RESOLUTION, 283, 5), new ExifTag(TAG_PLANAR_CONFIGURATION, 284, 3), new ExifTag(TAG_RESOLUTION_UNIT, 296, 3), new ExifTag(TAG_TRANSFER_FUNCTION, 301, 3), new ExifTag(TAG_SOFTWARE, 305, 2), new ExifTag(TAG_DATETIME, TinkerReport.KEY_LOADED_MISSING_PATCH_INFO, 2), new ExifTag(TAG_ARTIST, 315, 2), new ExifTag(TAG_WHITE_POINT, 318, 5), new ExifTag(TAG_PRIMARY_CHROMATICITIES, 319, 5), new ExifTag(f2305f, 330, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4), new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4), new ExifTag(TAG_Y_CB_CR_COEFFICIENTS, 529, 5), new ExifTag(TAG_Y_CB_CR_SUB_SAMPLING, 530, 3), new ExifTag(TAG_Y_CB_CR_POSITIONING, 531, 3), new ExifTag(TAG_REFERENCE_BLACK_WHITE, 532, 5), new ExifTag(TAG_COPYRIGHT, 33432, 2), new ExifTag(f2302c, 34665, 4), new ExifTag(f2303d, 34853, 4), new ExifTag(TAG_DNG_VERSION, 50706, 1), new ExifTag(TAG_DEFAULT_CROP_SIZE, 50720, 3, 4)};
        d0 = exifTagArr5;
        e0 = new ExifTag(TAG_STRIP_OFFSETS, b.f26259a, 3);
        ExifTag[] exifTagArr6 = {new ExifTag(TAG_ORF_THUMBNAIL_IMAGE, 256, 7), new ExifTag(f2306g, 8224, 4), new ExifTag(f2307h, 8256, 4)};
        f0 = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag(TAG_ORF_PREVIEW_IMAGE_START, 257, 4), new ExifTag(TAG_ORF_PREVIEW_IMAGE_LENGTH, 258, 4)};
        g0 = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag(TAG_ORF_ASPECT_FRAME, 4371, 3)};
        h0 = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag(TAG_COLOR_SPACE, 55, 3)};
        i0 = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        t0 = exifTagArr10;
        u0 = new ExifTag[]{new ExifTag(f2305f, 330, 4), new ExifTag(f2302c, 34665, 4), new ExifTag(f2303d, 34853, 4), new ExifTag(f2304e, 40965, 4), new ExifTag(f2306g, 8224, 1), new ExifTag(f2307h, 8256, 1)};
        v0 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT, 513, 4);
        w0 = new ExifTag(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, 514, 4);
        x0 = new HashMap[exifTagArr10.length];
        y0 = new HashMap[exifTagArr10.length];
        z0 = new HashSet<>(Arrays.asList(TAG_F_NUMBER, TAG_DIGITAL_ZOOM_RATIO, TAG_EXPOSURE_TIME, TAG_SUBJECT_DISTANCE, TAG_GPS_TIMESTAMP));
        A0 = new HashMap<>();
        Charset forName = Charset.forName("US-ASCII");
        B0 = forName;
        C0 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        E = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i2 = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = t0;
            if (i2 >= exifTagArr11.length) {
                HashMap<Integer, Integer> hashMap = A0;
                ExifTag[] exifTagArr12 = u0;
                hashMap.put(Integer.valueOf(exifTagArr12[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr12[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr12[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr12[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr12[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr12[5].number), 8);
                i1 = Pattern.compile(".*[1-9].*");
                j1 = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
                return;
            }
            x0[i2] = new HashMap<>();
            y0[i2] = new HashMap<>();
            for (ExifTag exifTag : exifTagArr11[i2]) {
                x0[i2].put(Integer.valueOf(exifTag.number), exifTag);
                y0[i2].put(exifTag.name, exifTag);
            }
            i2++;
        }
    }

    public ExifInterface(@NonNull String str) throws IOException {
        FileInputStream fileInputStream;
        ExifTag[][] exifTagArr = t0;
        this.n1 = new HashMap[exifTagArr.length];
        this.o1 = new HashSet(exifTagArr.length);
        this.p1 = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new IllegalArgumentException("filename cannot be null");
        }
        FileInputStream fileInputStream2 = null;
        this.l1 = null;
        this.k1 = str;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            w(fileInputStream);
            b(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            b(fileInputStream2);
            throw th;
        }
    }

    private void A(byte[] bArr, int i2) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        x(byteOrderedDataInputStream, bArr.length);
        B(byteOrderedDataInputStream, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r25, int r26) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 808
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.B(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int):void");
    }

    private void C(String str) {
        for (int i2 = 0; i2 < t0.length; i2++) {
            this.n1[i2].remove(str);
        }
    }

    private void D(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.n1[i2].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute3 = this.n1[i2].get(TAG_IMAGE_WIDTH);
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.n1[i2].get(TAG_JPEG_INTERCHANGE_FORMAT)) != null) {
            h(byteOrderedDataInputStream, exifAttribute.getIntValue(this.p1), i2);
        }
    }

    private void E(InputStream inputStream, OutputStream outputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-1);
        if (dataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        byteOrderedDataOutputStream.writeByte(-40);
        byteOrderedDataOutputStream.writeByte(-1);
        byteOrderedDataOutputStream.writeByte(-31);
        K(byteOrderedDataOutputStream, 6);
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte readByte = dataInputStream.readByte();
            if (readByte == -39 || readByte == -38) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                f(dataInputStream, byteOrderedDataOutputStream);
                return;
            }
            if (readByte != -31) {
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                int readUnsignedShort = dataInputStream.readUnsignedShort();
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                int i2 = readUnsignedShort - 2;
                if (i2 < 0) {
                    throw new IOException("Invalid length");
                }
                while (i2 > 0) {
                    int read = dataInputStream.read(bArr, 0, Math.min(i2, 4096));
                    if (read >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, read);
                        i2 -= read;
                    }
                }
            } else {
                int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                if (readUnsignedShort2 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (readUnsignedShort2 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, C0)) {
                        int i3 = readUnsignedShort2 - 6;
                        if (dataInputStream.skipBytes(i3) != i3) {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(readByte);
                byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                if (readUnsignedShort2 >= 6) {
                    readUnsignedShort2 -= 6;
                    byteOrderedDataOutputStream.write(bArr2);
                }
                while (readUnsignedShort2 > 0) {
                    int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                    if (read2 >= 0) {
                        byteOrderedDataOutputStream.write(bArr, 0, read2);
                        readUnsignedShort2 -= read2;
                    }
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private void F(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.n1[4];
        ExifAttribute exifAttribute = hashMap.get(TAG_COMPRESSION);
        if (exifAttribute == null) {
            this.u1 = 6;
            o(byteOrderedDataInputStream, hashMap);
            return;
        }
        int intValue = exifAttribute.getIntValue(this.p1);
        this.u1 = intValue;
        if (intValue != 1) {
            if (intValue == 6) {
                o(byteOrderedDataInputStream, hashMap);
                return;
            } else if (intValue != 7) {
                return;
            }
        }
        if (u(hashMap)) {
            p(byteOrderedDataInputStream, hashMap);
        }
    }

    private void G(int i2, int i3) throws IOException {
        if (this.n1[i2].isEmpty() || this.n1[i3].isEmpty()) {
            return;
        }
        ExifAttribute exifAttribute = this.n1[i2].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = this.n1[i2].get(TAG_IMAGE_WIDTH);
        ExifAttribute exifAttribute3 = this.n1[i3].get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute4 = this.n1[i3].get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.p1);
        int intValue2 = exifAttribute2.getIntValue(this.p1);
        int intValue3 = exifAttribute3.getIntValue(this.p1);
        int intValue4 = exifAttribute4.getIntValue(this.p1);
        if (intValue >= intValue3 || intValue2 >= intValue4) {
            return;
        }
        HashMap<String, ExifAttribute>[] hashMapArr = this.n1;
        HashMap<String, ExifAttribute> hashMap = hashMapArr[i2];
        hashMapArr[i2] = hashMapArr[i3];
        hashMapArr[i3] = hashMap;
    }

    private boolean H(String str, ExifAttribute exifAttribute) {
        boolean z2 = false;
        for (int i2 = 0; i2 < t0.length; i2++) {
            if (this.n1[i2].containsKey(str)) {
                this.n1[i2].put(str, exifAttribute);
                z2 = true;
            }
        }
        return z2;
    }

    private void I(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ExifAttribute createUShort;
        ExifAttribute createUShort2;
        ExifAttribute exifAttribute = this.n1[i2].get(TAG_DEFAULT_CROP_SIZE);
        ExifAttribute exifAttribute2 = this.n1[i2].get(TAG_RW2_SENSOR_TOP_BORDER);
        ExifAttribute exifAttribute3 = this.n1[i2].get(TAG_RW2_SENSOR_LEFT_BORDER);
        ExifAttribute exifAttribute4 = this.n1[i2].get(TAG_RW2_SENSOR_BOTTOM_BORDER);
        ExifAttribute exifAttribute5 = this.n1[i2].get(TAG_RW2_SENSOR_RIGHT_BORDER);
        if (exifAttribute == null) {
            if (exifAttribute2 == null || exifAttribute3 == null || exifAttribute4 == null || exifAttribute5 == null) {
                D(byteOrderedDataInputStream, i2);
                return;
            }
            int intValue = exifAttribute2.getIntValue(this.p1);
            int intValue2 = exifAttribute4.getIntValue(this.p1);
            int intValue3 = exifAttribute5.getIntValue(this.p1);
            int intValue4 = exifAttribute3.getIntValue(this.p1);
            if (intValue2 <= intValue || intValue3 <= intValue4) {
                return;
            }
            ExifAttribute createUShort3 = ExifAttribute.createUShort(intValue2 - intValue, this.p1);
            ExifAttribute createUShort4 = ExifAttribute.createUShort(intValue3 - intValue4, this.p1);
            this.n1[i2].put(TAG_IMAGE_LENGTH, createUShort3);
            this.n1[i2].put(TAG_IMAGE_WIDTH, createUShort4);
            return;
        }
        if (exifAttribute.format == 5) {
            Rational[] rationalArr = (Rational[]) exifAttribute.a(this.p1);
            if (rationalArr == null || rationalArr.length != 2) {
                Log.w(f2300a, "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                return;
            }
            createUShort = ExifAttribute.createURational(rationalArr[0], this.p1);
            createUShort2 = ExifAttribute.createURational(rationalArr[1], this.p1);
        } else {
            int[] iArr = (int[]) exifAttribute.a(this.p1);
            if (iArr == null || iArr.length != 2) {
                Log.w(f2300a, "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            createUShort = ExifAttribute.createUShort(iArr[0], this.p1);
            createUShort2 = ExifAttribute.createUShort(iArr[1], this.p1);
        }
        this.n1[i2].put(TAG_IMAGE_WIDTH, createUShort);
        this.n1[i2].put(TAG_IMAGE_LENGTH, createUShort2);
    }

    private void J(InputStream inputStream) throws IOException {
        G(0, 5);
        G(0, 4);
        G(5, 4);
        ExifAttribute exifAttribute = this.n1[1].get(TAG_PIXEL_X_DIMENSION);
        ExifAttribute exifAttribute2 = this.n1[1].get(TAG_PIXEL_Y_DIMENSION);
        if (exifAttribute != null && exifAttribute2 != null) {
            this.n1[0].put(TAG_IMAGE_WIDTH, exifAttribute);
            this.n1[0].put(TAG_IMAGE_LENGTH, exifAttribute2);
        }
        if (this.n1[4].isEmpty() && v(this.n1[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.n1;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (v(this.n1[4])) {
            return;
        }
        Log.d(f2300a, "No image meets the size requirements of a thumbnail image.");
    }

    private int K(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i2) throws IOException {
        ExifTag[][] exifTagArr = t0;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : u0) {
            C(exifTag.name);
        }
        C(v0.name);
        C(w0.name);
        for (int i3 = 0; i3 < t0.length; i3++) {
            for (Object obj : this.n1[i3].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.n1[i3].remove(entry.getKey());
                }
            }
        }
        if (!this.n1[1].isEmpty()) {
            this.n1[0].put(u0[1].name, ExifAttribute.createULong(0L, this.p1));
        }
        if (!this.n1[2].isEmpty()) {
            this.n1[0].put(u0[2].name, ExifAttribute.createULong(0L, this.p1));
        }
        if (!this.n1[3].isEmpty()) {
            this.n1[1].put(u0[3].name, ExifAttribute.createULong(0L, this.p1));
        }
        if (this.q1) {
            this.n1[4].put(v0.name, ExifAttribute.createULong(0L, this.p1));
            this.n1[4].put(w0.name, ExifAttribute.createULong(this.s1, this.p1));
        }
        for (int i4 = 0; i4 < t0.length; i4++) {
            Iterator<Map.Entry<String, ExifAttribute>> it = this.n1[i4].entrySet().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                int size = it.next().getValue().size();
                if (size > 4) {
                    i5 += size;
                }
            }
            iArr2[i4] = iArr2[i4] + i5;
        }
        int i6 = 8;
        for (int i7 = 0; i7 < t0.length; i7++) {
            if (!this.n1[i7].isEmpty()) {
                iArr[i7] = i6;
                i6 += (this.n1[i7].size() * 12) + 2 + 4 + iArr2[i7];
            }
        }
        if (this.q1) {
            this.n1[4].put(v0.name, ExifAttribute.createULong(i6, this.p1));
            this.r1 = i2 + i6;
            i6 += this.s1;
        }
        int i8 = i6 + 8;
        if (!this.n1[1].isEmpty()) {
            this.n1[0].put(u0[1].name, ExifAttribute.createULong(iArr[1], this.p1));
        }
        if (!this.n1[2].isEmpty()) {
            this.n1[0].put(u0[2].name, ExifAttribute.createULong(iArr[2], this.p1));
        }
        if (!this.n1[3].isEmpty()) {
            this.n1[1].put(u0[3].name, ExifAttribute.createULong(iArr[3], this.p1));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i8);
        byteOrderedDataOutputStream.write(C0);
        byteOrderedDataOutputStream.writeShort(this.p1 == ByteOrder.BIG_ENDIAN ? G : F);
        byteOrderedDataOutputStream.setByteOrder(this.p1);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8L);
        for (int i9 = 0; i9 < t0.length; i9++) {
            if (!this.n1[i9].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.n1[i9].size());
                int size2 = iArr[i9] + 2 + (this.n1[i9].size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry2 : this.n1[i9].entrySet()) {
                    int i10 = y0[i9].get(entry2.getKey()).number;
                    ExifAttribute value = entry2.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i10);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt(size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i9 != 0 || this.n1[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0L);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt(iArr[4]);
                }
                Iterator<Map.Entry<String, ExifAttribute>> it2 = this.n1[i9].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = it2.next().getValue().bytes;
                    if (bArr.length > 4) {
                        byteOrderedDataOutputStream.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.q1) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i8;
    }

    private void a() {
        String attribute = getAttribute(TAG_DATETIME_ORIGINAL);
        if (attribute != null && getAttribute(TAG_DATETIME) == null) {
            this.n1[0].put(TAG_DATETIME, ExifAttribute.createString(attribute));
        }
        if (getAttribute(TAG_IMAGE_WIDTH) == null) {
            this.n1[0].put(TAG_IMAGE_WIDTH, ExifAttribute.createULong(0L, this.p1));
        }
        if (getAttribute(TAG_IMAGE_LENGTH) == null) {
            this.n1[0].put(TAG_IMAGE_LENGTH, ExifAttribute.createULong(0L, this.p1));
        }
        if (getAttribute(TAG_ORIENTATION) == null) {
            this.n1[0].put(TAG_ORIENTATION, ExifAttribute.createULong(0L, this.p1));
        }
        if (getAttribute(TAG_LIGHT_SOURCE) == null) {
            this.n1[1].put(TAG_LIGHT_SOURCE, ExifAttribute.createULong(0L, this.p1));
        }
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private String c(double d2) {
        long j2 = (long) d2;
        double d3 = j2;
        Double.isNaN(d3);
        double d4 = d2 - d3;
        long j3 = (long) (d4 * 60.0d);
        double d5 = j3;
        Double.isNaN(d5);
        return j2 + "/1," + j3 + "/1," + Math.round((d4 - (d5 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private static double d(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            double parseDouble = Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim());
            String[] split3 = split[1].split("/", -1);
            double parseDouble2 = Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim());
            String[] split4 = split[2].split("/", -1);
            double parseDouble3 = parseDouble + (parseDouble2 / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals(LATITUDE_SOUTH) && !str2.equals(LONGITUDE_WEST)) {
                if (!str2.equals("N") && !str2.equals(LONGITUDE_EAST)) {
                    throw new IllegalArgumentException();
                }
                return parseDouble3;
            }
            return -parseDouble3;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private static long[] e(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            jArr[i2] = iArr[i2];
        }
        return jArr;
    }

    private static int f(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i2;
            }
            i2 += read;
            outputStream.write(bArr, 0, read);
        }
    }

    @Nullable
    private ExifAttribute g(@NonNull String str) {
        if (TAG_ISO_SPEED_RATINGS.equals(str)) {
            str = TAG_PHOTOGRAPHIC_SENSITIVITY;
        }
        for (int i2 = 0; i2 < t0.length; i2++) {
            ExifAttribute exifAttribute = this.n1[i2].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x0115, code lost:
    
        r10.setByteOrder(r9.p1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011a, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0057 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h(androidx.exifinterface.media.ExifInterface.ByteOrderedDataInputStream r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.h(androidx.exifinterface.media.ExifInterface$ByteOrderedDataInputStream, int, int):void");
    }

    private int i(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (q(bArr)) {
            return 4;
        }
        if (s(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 7;
        }
        return t(bArr) ? 10 : 0;
    }

    private void j(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        l(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.n1[1].get(TAG_MAKER_NOTE);
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.p1);
            byte[] bArr = x;
            byte[] bArr2 = new byte[bArr.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            byteOrderedDataInputStream2.seek(0L);
            byte[] bArr3 = y;
            byte[] bArr4 = new byte[bArr3.length];
            byteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                byteOrderedDataInputStream2.seek(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                byteOrderedDataInputStream2.seek(12L);
            }
            B(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.n1[7].get(TAG_ORF_PREVIEW_IMAGE_START);
            ExifAttribute exifAttribute3 = this.n1[7].get(TAG_ORF_PREVIEW_IMAGE_LENGTH);
            if (exifAttribute2 != null && exifAttribute3 != null) {
                this.n1[5].put(TAG_JPEG_INTERCHANGE_FORMAT, exifAttribute2);
                this.n1[5].put(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.n1[8].get(TAG_ORF_ASPECT_FRAME);
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.a(this.p1);
                if (iArr == null || iArr.length != 4) {
                    Log.w(f2300a, "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                    return;
                }
                int i2 = (iArr[2] - iArr[0]) + 1;
                int i3 = (iArr[3] - iArr[1]) + 1;
                if (i2 < i3) {
                    int i4 = i2 + i3;
                    i3 = i4 - i3;
                    i2 = i4 - i3;
                }
                ExifAttribute createUShort = ExifAttribute.createUShort(i2, this.p1);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(i3, this.p1);
                this.n1[0].put(TAG_IMAGE_WIDTH, createUShort);
                this.n1[0].put(TAG_IMAGE_LENGTH, createUShort2);
            }
        }
    }

    private void k(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i2 = ByteBuffer.wrap(bArr).getInt();
        int i3 = ByteBuffer.wrap(bArr2).getInt();
        h(byteOrderedDataInputStream, i2, 5);
        byteOrderedDataInputStream.seek(i3);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        for (int i4 = 0; i4 < readInt; i4++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == e0.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.p1);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.p1);
                this.n1[0].put(TAG_IMAGE_LENGTH, createUShort);
                this.n1[0].put(TAG_IMAGE_WIDTH, createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void l(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        x(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        B(byteOrderedDataInputStream, 0);
        I(byteOrderedDataInputStream, 0);
        I(byteOrderedDataInputStream, 5);
        I(byteOrderedDataInputStream, 4);
        J(byteOrderedDataInputStream);
        if (this.m1 != 8 || (exifAttribute = this.n1[1].get(TAG_MAKER_NOTE)) == null) {
            return;
        }
        ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
        byteOrderedDataInputStream2.setByteOrder(this.p1);
        byteOrderedDataInputStream2.seek(6L);
        B(byteOrderedDataInputStream2, 9);
        ExifAttribute exifAttribute2 = this.n1[9].get(TAG_COLOR_SPACE);
        if (exifAttribute2 != null) {
            this.n1[1].put(TAG_COLOR_SPACE, exifAttribute2);
        }
    }

    private void m(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        l(byteOrderedDataInputStream);
        if (this.n1[0].get(TAG_RW2_JPG_FROM_RAW) != null) {
            h(byteOrderedDataInputStream, this.z1, 5);
        }
        ExifAttribute exifAttribute = this.n1[0].get(TAG_RW2_ISO);
        ExifAttribute exifAttribute2 = this.n1[1].get(TAG_PHOTOGRAPHIC_SENSITIVITY);
        if (exifAttribute == null || exifAttribute2 != null) {
            return;
        }
        this.n1[1].put(TAG_PHOTOGRAPHIC_SENSITIVITY, exifAttribute);
    }

    private static Pair<Integer, Integer> n(String str) {
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> n2 = n(split[0]);
            if (((Integer) n2.first).intValue() == 2) {
                return n2;
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                Pair<Integer, Integer> n3 = n(split[i2]);
                int intValue = (((Integer) n3.first).equals(n2.first) || ((Integer) n3.second).equals(n2.first)) ? ((Integer) n2.first).intValue() : -1;
                int intValue2 = (((Integer) n2.second).intValue() == -1 || !(((Integer) n3.first).equals(n2.second) || ((Integer) n3.second).equals(n2.second))) ? -1 : ((Integer) n2.second).intValue();
                if (intValue == -1 && intValue2 == -1) {
                    return new Pair<>(2, -1);
                }
                if (intValue == -1) {
                    n2 = new Pair<>(Integer.valueOf(intValue2), -1);
                } else if (intValue2 == -1) {
                    n2 = new Pair<>(Integer.valueOf(intValue), -1);
                }
            }
            return n2;
        }
        if (!str.contains("/")) {
            try {
                try {
                    Long valueOf = Long.valueOf(Long.parseLong(str));
                    return (valueOf.longValue() < 0 || valueOf.longValue() > 65535) ? valueOf.longValue() < 0 ? new Pair<>(9, -1) : new Pair<>(4, -1) : new Pair<>(3, 4);
                } catch (NumberFormatException unused) {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                }
            } catch (NumberFormatException unused2) {
                return new Pair<>(2, -1);
            }
        }
        String[] split2 = str.split("/", -1);
        if (split2.length == 2) {
            try {
                long parseDouble = (long) Double.parseDouble(split2[0]);
                long parseDouble2 = (long) Double.parseDouble(split2[1]);
                if (parseDouble >= 0 && parseDouble2 >= 0) {
                    if (parseDouble <= 2147483647L && parseDouble2 <= 2147483647L) {
                        return new Pair<>(10, 5);
                    }
                    return new Pair<>(5, -1);
                }
                return new Pair<>(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair<>(2, -1);
    }

    private void o(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i2;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_JPEG_INTERCHANGE_FORMAT_LENGTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        int intValue = exifAttribute.getIntValue(this.p1);
        int min = Math.min(exifAttribute2.getIntValue(this.p1), byteOrderedDataInputStream.available() - intValue);
        int i3 = this.m1;
        if (i3 != 4 && i3 != 9 && i3 != 10) {
            if (i3 == 7) {
                i2 = this.w1;
            }
            if (intValue > 0 || min <= 0) {
            }
            this.q1 = true;
            this.r1 = intValue;
            this.s1 = min;
            if (this.k1 == null && this.l1 == null) {
                byte[] bArr = new byte[min];
                byteOrderedDataInputStream.seek(intValue);
                byteOrderedDataInputStream.readFully(bArr);
                this.t1 = bArr;
                return;
            }
            return;
        }
        i2 = this.v1;
        intValue += i2;
        if (intValue > 0) {
        }
    }

    private void p(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_STRIP_OFFSETS);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_STRIP_BYTE_COUNTS);
        if (exifAttribute == null || exifAttribute2 == null) {
            return;
        }
        long[] e2 = e(exifAttribute.a(this.p1));
        long[] e3 = e(exifAttribute2.a(this.p1));
        if (e2 == null) {
            Log.w(f2300a, "stripOffsets should not be null.");
            return;
        }
        if (e3 == null) {
            Log.w(f2300a, "stripByteCounts should not be null.");
            return;
        }
        long j2 = 0;
        for (long j3 : e3) {
            j2 += j3;
        }
        int i2 = (int) j2;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < e2.length; i5++) {
            int i6 = (int) e2[i5];
            int i7 = (int) e3[i5];
            int i8 = i6 - i3;
            if (i8 < 0) {
                Log.d(f2300a, "Invalid strip offset value");
            }
            byteOrderedDataInputStream.seek(i8);
            int i9 = i3 + i8;
            byte[] bArr2 = new byte[i7];
            byteOrderedDataInputStream.read(bArr2);
            i3 = i9 + i7;
            System.arraycopy(bArr2, 0, bArr, i4, i7);
            i4 += i7;
        }
        this.q1 = true;
        this.t1 = bArr;
        this.s1 = i2;
    }

    private static boolean q(byte[] bArr) throws IOException {
        int i2 = 0;
        while (true) {
            byte[] bArr2 = q;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    private boolean r(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder z2 = z(byteOrderedDataInputStream);
        this.p1 = z2;
        byteOrderedDataInputStream.setByteOrder(z2);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean s(byte[] bArr) throws IOException {
        byte[] bytes = r.getBytes(Charset.defaultCharset());
        for (int i2 = 0; i2 < bytes.length; i2++) {
            if (bArr[i2] != bytes[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean t(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder z2 = z(byteOrderedDataInputStream);
        this.p1 = z2;
        byteOrderedDataInputStream.setByteOrder(z2);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 85;
    }

    private boolean u(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_BITS_PER_SAMPLE);
        if (exifAttribute2 == null) {
            return false;
        }
        int[] iArr = (int[]) exifAttribute2.a(this.p1);
        int[] iArr2 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.m1 != 3 || (exifAttribute = (ExifAttribute) hashMap.get(TAG_PHOTOMETRIC_INTERPRETATION)) == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.p1);
        return (intValue == 1 && Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) || (intValue == 6 && Arrays.equals(iArr, iArr2));
    }

    private boolean v(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get(TAG_IMAGE_LENGTH);
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get(TAG_IMAGE_WIDTH);
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.p1) <= 512 && exifAttribute2.getIntValue(this.p1) <= 512;
    }

    private void w(@NonNull InputStream inputStream) throws IOException {
        for (int i2 = 0; i2 < t0.length; i2++) {
            try {
                try {
                    this.n1[i2] = new HashMap<>();
                } catch (IOException unused) {
                    this.A1 = false;
                }
            } finally {
                a();
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.m1 = i(bufferedInputStream);
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        switch (this.m1) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                l(byteOrderedDataInputStream);
                break;
            case 4:
                h(byteOrderedDataInputStream, 0, 0);
                break;
            case 7:
                j(byteOrderedDataInputStream);
                break;
            case 9:
                k(byteOrderedDataInputStream);
                break;
            case 10:
                m(byteOrderedDataInputStream);
                break;
        }
        F(byteOrderedDataInputStream);
        this.A1 = true;
    }

    private void x(ByteOrderedDataInputStream byteOrderedDataInputStream, int i2) throws IOException {
        ByteOrder z2 = z(byteOrderedDataInputStream);
        this.p1 = z2;
        byteOrderedDataInputStream.setByteOrder(z2);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i3 = this.m1;
        if (i3 != 7 && i3 != 10 && readUnsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
        }
        int readInt = byteOrderedDataInputStream.readInt();
        if (readInt < 8 || readInt >= i2) {
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        int i4 = readInt - 8;
        if (i4 <= 0 || byteOrderedDataInputStream.skipBytes(i4) == i4) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i4);
    }

    private void y() {
        for (int i2 = 0; i2 < this.n1.length; i2++) {
            Log.d(f2300a, "The size of tag group[" + i2 + "]: " + this.n1[i2].size());
            for (Map.Entry<String, ExifAttribute> entry : this.n1[i2].entrySet()) {
                ExifAttribute value = entry.getValue();
                Log.d(f2300a, "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.p1) + "'");
            }
        }
    }

    private ByteOrder z(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    public void flipHorizontally() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 2;
                break;
            case 2:
                break;
            case 3:
                i2 = 4;
                break;
            case 4:
                i2 = 3;
                break;
            case 5:
                i2 = 6;
                break;
            case 6:
                i2 = 5;
                break;
            case 7:
                i2 = 8;
                break;
            case 8:
                i2 = 7;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public void flipVertically() {
        int i2 = 1;
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 1:
                i2 = 4;
                break;
            case 2:
                i2 = 3;
                break;
            case 3:
                i2 = 2;
                break;
            case 4:
                break;
            case 5:
                i2 = 8;
                break;
            case 6:
                i2 = 7;
                break;
            case 7:
                i2 = 6;
                break;
            case 8:
                i2 = 5;
                break;
            default:
                i2 = 0;
                break;
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(i2));
    }

    public double getAltitude(double d2) {
        double attributeDouble = getAttributeDouble(TAG_GPS_ALTITUDE, -1.0d);
        int attributeInt = getAttributeInt(TAG_GPS_ALTITUDE_REF, -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d2;
        }
        double d3 = attributeInt != 1 ? 1 : -1;
        Double.isNaN(d3);
        return attributeDouble * d3;
    }

    @Nullable
    public String getAttribute(@NonNull String str) {
        ExifAttribute g2 = g(str);
        if (g2 != null) {
            if (!z0.contains(str)) {
                return g2.getStringValue(this.p1);
            }
            if (str.equals(TAG_GPS_TIMESTAMP)) {
                int i2 = g2.format;
                if (i2 != 5 && i2 != 10) {
                    Log.w(f2300a, "GPS Timestamp format is not rational. format=" + g2.format);
                    return null;
                }
                Rational[] rationalArr = (Rational[]) g2.a(this.p1);
                if (rationalArr != null && rationalArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (rationalArr[0].numerator / rationalArr[0].denominator)), Integer.valueOf((int) (rationalArr[1].numerator / rationalArr[1].denominator)), Integer.valueOf((int) (rationalArr[2].numerator / rationalArr[2].denominator)));
                }
                Log.w(f2300a, "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                return null;
            }
            try {
                return Double.toString(g2.getDoubleValue(this.p1));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double getAttributeDouble(@NonNull String str, double d2) {
        ExifAttribute g2 = g(str);
        if (g2 == null) {
            return d2;
        }
        try {
            return g2.getDoubleValue(this.p1);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public int getAttributeInt(@NonNull String str, int i2) {
        ExifAttribute g2 = g(str);
        if (g2 == null) {
            return i2;
        }
        try {
            return g2.getIntValue(this.p1);
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getDateTime() {
        String attribute = getAttribute(TAG_DATETIME);
        if (attribute != null && i1.matcher(attribute).matches()) {
            try {
                Date parse = E.parse(attribute, new ParsePosition(0));
                if (parse == null) {
                    return -1L;
                }
                long time = parse.getTime();
                String attribute2 = getAttribute(TAG_SUBSEC_TIME);
                if (attribute2 == null) {
                    return time;
                }
                try {
                    long parseLong = Long.parseLong(attribute2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    return time + parseLong;
                } catch (NumberFormatException unused) {
                    return time;
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1L;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public long getGpsDateTime() {
        String attribute = getAttribute(TAG_GPS_DATESTAMP);
        String attribute2 = getAttribute(TAG_GPS_TIMESTAMP);
        if (attribute != null && attribute2 != null) {
            Pattern pattern = i1;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    Date parse = E.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1L;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return -1L;
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt(TAG_ORIENTATION, 1)) {
            case 3:
            case 4:
                return TinkerReport.KEY_APPLIED_VERSION_CHECK;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    @Nullable
    public byte[] getThumbnail() {
        int i2 = this.u1;
        if (i2 == 6 || i2 == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    @Nullable
    public Bitmap getThumbnailBitmap() {
        if (!this.q1) {
            return null;
        }
        if (this.t1 == null) {
            this.t1 = getThumbnailBytes();
        }
        int i2 = this.u1;
        if (i2 == 6 || i2 == 7) {
            return BitmapFactory.decodeByteArray(this.t1, 0, this.s1);
        }
        if (i2 == 1) {
            int length = this.t1.length / 3;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                byte[] bArr = this.t1;
                int i4 = i3 * 3;
                iArr[i3] = (bArr[i4] << 16) + 0 + (bArr[i4 + 1] << 8) + bArr[i4 + 2];
            }
            ExifAttribute exifAttribute = this.n1[4].get(TAG_IMAGE_LENGTH);
            ExifAttribute exifAttribute2 = this.n1[4].get(TAG_IMAGE_WIDTH);
            if (exifAttribute != null && exifAttribute2 != null) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.p1), exifAttribute.getIntValue(this.p1), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public byte[] getThumbnailBytes() {
        InputStream inputStream;
        Closeable closeable = null;
        if (!this.q1) {
            return null;
        }
        byte[] bArr = this.t1;
        try {
            if (bArr != 0) {
                return bArr;
            }
            try {
                inputStream = this.l1;
                if (inputStream != null) {
                    try {
                        if (!inputStream.markSupported()) {
                            Log.d(f2300a, "Cannot read thumbnail from inputstream without mark/reset support");
                            b(inputStream);
                            return null;
                        }
                        inputStream.reset();
                    } catch (IOException e2) {
                        e = e2;
                        Log.d(f2300a, "Encountered exception while getting thumbnail", e);
                        b(inputStream);
                        return null;
                    }
                } else {
                    inputStream = this.k1 != null ? new FileInputStream(this.k1) : null;
                }
                if (inputStream == null) {
                    throw new FileNotFoundException();
                }
                if (inputStream.skip(this.r1) != this.r1) {
                    throw new IOException("Corrupted image");
                }
                byte[] bArr2 = new byte[this.s1];
                if (inputStream.read(bArr2) != this.s1) {
                    throw new IOException("Corrupted image");
                }
                this.t1 = bArr2;
                b(inputStream);
                return bArr2;
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            } catch (Throwable th) {
                th = th;
                b(closeable);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable = bArr;
        }
    }

    @Nullable
    public long[] getThumbnailRange() {
        if (this.q1) {
            return new long[]{this.r1, this.s1};
        }
        return null;
    }

    public boolean hasThumbnail() {
        return this.q1;
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public boolean isThumbnailCompressed() {
        int i2 = this.u1;
        return i2 == 6 || i2 == 7;
    }

    public void resetOrientation() {
        setAttribute(TAG_ORIENTATION, Integer.toString(1));
    }

    public void rotate(int i2) {
        if (i2 % 90 != 0) {
            throw new IllegalArgumentException("degree should be a multiple of 90");
        }
        int attributeInt = getAttributeInt(TAG_ORIENTATION, 1);
        List<Integer> list = n;
        if (list.contains(Integer.valueOf(attributeInt))) {
            int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
            r4 = list.get(indexOf + (indexOf < 0 ? 4 : 0)).intValue();
        } else {
            List<Integer> list2 = o;
            if (list2.contains(Integer.valueOf(attributeInt))) {
                int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i2 / 90)) % 4;
                r4 = list2.get(indexOf2 + (indexOf2 < 0 ? 4 : 0)).intValue();
            }
        }
        setAttribute(TAG_ORIENTATION, Integer.toString(r4));
    }

    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        if (!this.A1 || this.m1 != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        }
        if (this.k1 == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.t1 = getThumbnail();
        File file = new File(this.k1 + ".tmp");
        if (!new File(this.k1).renameTo(file)) {
            throw new IOException("Could not rename to " + file.getAbsolutePath());
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(this.k1);
            } catch (Throwable th2) {
                fileOutputStream = null;
                th = th2;
            }
        } catch (Throwable th3) {
            fileOutputStream = null;
            th = th3;
            fileInputStream = null;
        }
        try {
            E(fileInputStream, fileOutputStream);
            b(fileInputStream);
            b(fileOutputStream);
            file.delete();
            this.t1 = null;
        } catch (Throwable th4) {
            th = th4;
            b(fileInputStream);
            b(fileOutputStream);
            file.delete();
            throw th;
        }
    }

    public void setAltitude(double d2) {
        String str = d2 >= 0.0d ? "0" : "1";
        setAttribute(TAG_GPS_ALTITUDE, new Rational(Math.abs(d2)).toString());
        setAttribute(TAG_GPS_ALTITUDE_REF, str);
    }

    public void setAttribute(@NonNull String str, @Nullable String str2) {
        ExifTag exifTag;
        int i2;
        String str3;
        String str4;
        String str5 = str2;
        String str6 = TAG_ISO_SPEED_RATINGS.equals(str) ? TAG_PHOTOGRAPHIC_SENSITIVITY : str;
        int i3 = 2;
        String str7 = f2300a;
        int i4 = 1;
        if (str5 != null && z0.contains(str6)) {
            if (str6.equals(TAG_GPS_TIMESTAMP)) {
                Matcher matcher = j1.matcher(str5);
                if (!matcher.find()) {
                    Log.w(f2300a, "Invalid value for " + str6 + " : " + str5);
                    return;
                }
                str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str5 = new Rational(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    Log.w(f2300a, "Invalid value for " + str6 + " : " + str5);
                    return;
                }
            }
        }
        char c2 = 0;
        int i5 = 0;
        while (i5 < t0.length) {
            if ((i5 != 4 || this.q1) && (exifTag = y0[i5].get(str6)) != null) {
                if (str5 == null) {
                    this.n1[i5].remove(str6);
                } else {
                    Pair<Integer, Integer> n2 = n(str5);
                    int i6 = -1;
                    if (exifTag.primaryFormat == ((Integer) n2.first).intValue() || exifTag.primaryFormat == ((Integer) n2.second).intValue()) {
                        i2 = exifTag.primaryFormat;
                    } else {
                        int i7 = exifTag.secondaryFormat;
                        if (i7 == -1 || !(i7 == ((Integer) n2.first).intValue() || exifTag.secondaryFormat == ((Integer) n2.second).intValue())) {
                            int i8 = exifTag.primaryFormat;
                            if (i8 == i4 || i8 == 7 || i8 == i3) {
                                i2 = i8;
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str6);
                                sb.append(") value didn't match with one of expected ");
                                sb.append("formats: ");
                                String[] strArr = W;
                                sb.append(strArr[exifTag.primaryFormat]);
                                sb.append(exifTag.secondaryFormat == -1 ? "" : ", " + strArr[exifTag.secondaryFormat]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) n2.first).intValue()]);
                                sb.append(((Integer) n2.second).intValue() != -1 ? ", " + strArr[((Integer) n2.second).intValue()] : "");
                                sb.append(")");
                                Log.w(str7, sb.toString());
                            }
                        } else {
                            i2 = exifTag.secondaryFormat;
                        }
                    }
                    switch (i2) {
                        case 1:
                            str3 = str7;
                            this.n1[i5].put(str6, ExifAttribute.createByte(str5));
                            str7 = str3;
                            break;
                        case 2:
                        case 7:
                            str3 = str7;
                            this.n1[i5].put(str6, ExifAttribute.createString(str5));
                            str7 = str3;
                            break;
                        case 3:
                            str3 = str7;
                            String[] split = str5.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i9 = 0; i9 < split.length; i9++) {
                                iArr[i9] = Integer.parseInt(split[i9]);
                            }
                            this.n1[i5].put(str6, ExifAttribute.createUShort(iArr, this.p1));
                            str7 = str3;
                            break;
                        case 4:
                            str3 = str7;
                            String[] split2 = str5.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i10 = 0; i10 < split2.length; i10++) {
                                jArr[i10] = Long.parseLong(split2[i10]);
                            }
                            this.n1[i5].put(str6, ExifAttribute.createULong(jArr, this.p1));
                            str7 = str3;
                            break;
                        case 5:
                            str3 = str7;
                            String[] split3 = str5.split(",", -1);
                            Rational[] rationalArr = new Rational[split3.length];
                            int i11 = 0;
                            while (i11 < split3.length) {
                                String[] split4 = split3[i11].split("/", i6);
                                rationalArr[i11] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                i11++;
                                i6 = -1;
                            }
                            this.n1[i5].put(str6, ExifAttribute.createURational(rationalArr, this.p1));
                            str7 = str3;
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            str7 = str7;
                            Log.w(str7, "Data format isn't one of expected formats: " + i2);
                            break;
                        case 9:
                            str4 = str7;
                            String[] split5 = str5.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i12 = 0; i12 < split5.length; i12++) {
                                iArr2[i12] = Integer.parseInt(split5[i12]);
                            }
                            this.n1[i5].put(str6, ExifAttribute.createSLong(iArr2, this.p1));
                            str7 = str4;
                            break;
                        case 10:
                            String[] split6 = str5.split(",", -1);
                            Rational[] rationalArr2 = new Rational[split6.length];
                            int i13 = 0;
                            while (i13 < split6.length) {
                                String[] split7 = split6[i13].split("/", -1);
                                rationalArr2[i13] = new Rational((long) Double.parseDouble(split7[c2]), (long) Double.parseDouble(split7[i4]));
                                i13++;
                                str7 = str7;
                                i4 = 1;
                                c2 = 0;
                            }
                            str4 = str7;
                            this.n1[i5].put(str6, ExifAttribute.createSRational(rationalArr2, this.p1));
                            str7 = str4;
                            break;
                        case 12:
                            String[] split8 = str5.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i14 = 0; i14 < split8.length; i14++) {
                                dArr[i14] = Double.parseDouble(split8[i14]);
                            }
                            this.n1[i5].put(str6, ExifAttribute.createDouble(dArr, this.p1));
                            break;
                    }
                    i5++;
                    i3 = 2;
                    i4 = 1;
                    c2 = 0;
                }
            }
            i5++;
            i3 = 2;
            i4 = 1;
            c2 = 0;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setDateTime(long j2) {
        setAttribute(TAG_DATETIME, E.format(new Date(j2)));
        setAttribute(TAG_SUBSEC_TIME, Long.toString(j2 % 1000));
    }

    public void setGpsInfo(Location location) {
        if (location == null) {
            return;
        }
        setAttribute(TAG_GPS_PROCESSING_METHOD, location.getProvider());
        setLatLong(location.getLatitude(), location.getLongitude());
        setAltitude(location.getAltitude());
        setAttribute(TAG_GPS_SPEED_REF, "K");
        setAttribute(TAG_GPS_SPEED, new Rational((location.getSpeed() * TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        String[] split = E.format(new Date(location.getTime())).split("\\s+", -1);
        setAttribute(TAG_GPS_DATESTAMP, split[0]);
        setAttribute(TAG_GPS_TIMESTAMP, split[1]);
    }

    public void setLatLong(double d2, double d3) {
        if (d2 < -90.0d || d2 > 90.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
        }
        if (d3 < -180.0d || d3 > 180.0d || Double.isNaN(d3)) {
            throw new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
        }
        setAttribute(TAG_GPS_LATITUDE_REF, d2 >= 0.0d ? "N" : LATITUDE_SOUTH);
        setAttribute(TAG_GPS_LATITUDE, c(Math.abs(d2)));
        setAttribute(TAG_GPS_LONGITUDE_REF, d3 >= 0.0d ? LONGITUDE_EAST : LONGITUDE_WEST);
        setAttribute(TAG_GPS_LONGITUDE, c(Math.abs(d3)));
    }

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {

        /* renamed from: a, reason: collision with root package name */
        private static final ByteOrder f2310a = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: b, reason: collision with root package name */
        private static final ByteOrder f2311b = ByteOrder.BIG_ENDIAN;

        /* renamed from: c, reason: collision with root package name */
        private DataInputStream f2312c;

        /* renamed from: d, reason: collision with root package name */
        private ByteOrder f2313d;

        /* renamed from: e, reason: collision with root package name */
        final int f2314e;

        /* renamed from: f, reason: collision with root package name */
        int f2315f;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.f2313d = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2312c = dataInputStream;
            int available = dataInputStream.available();
            this.f2314e = available;
            this.f2315f = 0;
            this.f2312c.mark(available);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f2312c.available();
        }

        public int peek() {
            return this.f2315f;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f2315f++;
            return this.f2312c.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f2315f++;
            return this.f2312c.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i2 = this.f2315f + 1;
            this.f2315f = i2;
            if (i2 > this.f2314e) {
                throw new EOFException();
            }
            int read = this.f2312c.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f2315f += 2;
            return this.f2312c.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f2315f + i3;
            this.f2315f = i4;
            if (i4 > this.f2314e) {
                throw new EOFException();
            }
            if (this.f2312c.read(bArr, i2, i3) != i3) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i2 = this.f2315f + 4;
            this.f2315f = i2;
            if (i2 > this.f2314e) {
                throw new EOFException();
            }
            int read = this.f2312c.read();
            int read2 = this.f2312c.read();
            int read3 = this.f2312c.read();
            int read4 = this.f2312c.read();
            if ((read | read2 | read3 | read4) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2313d;
            if (byteOrder == f2310a) {
                return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f2311b) {
                return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
            }
            throw new IOException("Invalid byte order: " + this.f2313d);
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d(ExifInterface.f2300a, "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i2 = this.f2315f + 8;
            this.f2315f = i2;
            if (i2 > this.f2314e) {
                throw new EOFException();
            }
            int read = this.f2312c.read();
            int read2 = this.f2312c.read();
            int read3 = this.f2312c.read();
            int read4 = this.f2312c.read();
            int read5 = this.f2312c.read();
            int read6 = this.f2312c.read();
            int read7 = this.f2312c.read();
            int read8 = this.f2312c.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2313d;
            if (byteOrder == f2310a) {
                return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
            }
            if (byteOrder == f2311b) {
                return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
            }
            throw new IOException("Invalid byte order: " + this.f2313d);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i2 = this.f2315f + 2;
            this.f2315f = i2;
            if (i2 > this.f2314e) {
                throw new EOFException();
            }
            int read = this.f2312c.read();
            int read2 = this.f2312c.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2313d;
            if (byteOrder == f2310a) {
                return (short) ((read2 << 8) + read);
            }
            if (byteOrder == f2311b) {
                return (short) ((read << 8) + read2);
            }
            throw new IOException("Invalid byte order: " + this.f2313d);
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f2315f += 2;
            return this.f2312c.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f2315f++;
            return this.f2312c.readUnsignedByte();
        }

        public long readUnsignedInt() throws IOException {
            return readInt() & 4294967295L;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i2 = this.f2315f + 2;
            this.f2315f = i2;
            if (i2 > this.f2314e) {
                throw new EOFException();
            }
            int read = this.f2312c.read();
            int read2 = this.f2312c.read();
            if ((read | read2) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.f2313d;
            if (byteOrder == f2310a) {
                return (read2 << 8) + read;
            }
            if (byteOrder == f2311b) {
                return (read << 8) + read2;
            }
            throw new IOException("Invalid byte order: " + this.f2313d);
        }

        public void seek(long j2) throws IOException {
            int i2 = this.f2315f;
            if (i2 > j2) {
                this.f2315f = 0;
                this.f2312c.reset();
                this.f2312c.mark(this.f2314e);
            } else {
                j2 -= i2;
            }
            int i3 = (int) j2;
            if (skipBytes(i3) != i3) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.f2313d = byteOrder;
        }

        @Override // java.io.DataInput
        public int skipBytes(int i2) throws IOException {
            int min = Math.min(i2, this.f2314e - this.f2315f);
            int i3 = 0;
            while (i3 < min) {
                i3 += this.f2312c.skipBytes(min - i3);
            }
            this.f2315f += i3;
            return i3;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) throws IOException {
            int read = this.f2312c.read(bArr, i2, i3);
            this.f2315f += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.f2315f + bArr.length;
            this.f2315f = length;
            if (length <= this.f2314e) {
                if (this.f2312c.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }
    }

    @Nullable
    public double[] getLatLong() {
        String attribute = getAttribute(TAG_GPS_LATITUDE);
        String attribute2 = getAttribute(TAG_GPS_LATITUDE_REF);
        String attribute3 = getAttribute(TAG_GPS_LONGITUDE);
        String attribute4 = getAttribute(TAG_GPS_LONGITUDE_REF);
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{d(attribute, attribute2), d(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w(f2300a, "Latitude/longitude values are not parseable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    private static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i2, int i3, byte[] bArr) {
            this.format = i2;
            this.numberOfComponents = i3;
            this.bytes = bArr;
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(ExifInterface.B0);
            return new ExifAttribute(1, bytes.length, bytes);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[12] * dArr.length]);
            wrap.order(byteOrder);
            for (double d2 : dArr) {
                wrap.putDouble(d2);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[9] * iArr.length]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putInt(i2);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[10] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes = (str + (char) 0).getBytes(ExifInterface.B0);
            return new ExifAttribute(2, bytes.length, bytes);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[5] * rationalArr.length]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[ExifInterface.X[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a0: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:169:0x01a0 */
        /* JADX WARN: Removed duplicated region for block: B:172:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object a(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 458
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.exifinterface.media.ExifInterface.ExifAttribute.a(java.nio.ByteOrder):java.lang.Object");
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (a2 instanceof String) {
                return Double.parseDouble((String) a2);
            }
            if (a2 instanceof long[]) {
                if (((long[]) a2).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (a2 instanceof int[]) {
                if (((int[]) a2).length == 1) {
                    return r5[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(a2 instanceof Rational[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            Rational[] rationalArr = (Rational[]) a2;
            if (rationalArr.length == 1) {
                return rationalArr[0].calculate();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (a2 instanceof String) {
                return Integer.parseInt((String) a2);
            }
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(a2 instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) a2;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object a2 = a(byteOrder);
            if (a2 == null) {
                return null;
            }
            if (a2 instanceof String) {
                return (String) a2;
            }
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            if (a2 instanceof long[]) {
                long[] jArr = (long[]) a2;
                while (i2 < jArr.length) {
                    sb.append(jArr[i2]);
                    i2++;
                    if (i2 != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (a2 instanceof int[]) {
                int[] iArr = (int[]) a2;
                while (i2 < iArr.length) {
                    sb.append(iArr[i2]);
                    i2++;
                    if (i2 != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (a2 instanceof double[]) {
                double[] dArr = (double[]) a2;
                while (i2 < dArr.length) {
                    sb.append(dArr[i2]);
                    i2++;
                    if (i2 != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(a2 instanceof Rational[])) {
                return null;
            }
            Rational[] rationalArr = (Rational[]) a2;
            while (i2 < rationalArr.length) {
                sb.append(rationalArr[i2].numerator);
                sb.append('/');
                sb.append(rationalArr[i2].denominator);
                i2++;
                if (i2 != rationalArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        public int size() {
            return ExifInterface.X[this.format] * this.numberOfComponents;
        }

        public String toString() {
            return "(" + ExifInterface.W[this.format] + ", data length:" + this.bytes.length + ")";
        }

        public static ExifAttribute createDouble(double d2, ByteOrder byteOrder) {
            return createDouble(new double[]{d2}, byteOrder);
        }

        public static ExifAttribute createSLong(int i2, ByteOrder byteOrder) {
            return createSLong(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute createULong(long j2, ByteOrder byteOrder) {
            return createULong(new long[]{j2}, byteOrder);
        }

        public static ExifAttribute createUShort(int i2, ByteOrder byteOrder) {
            return createUShort(new int[]{i2}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }
    }

    static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i2, int i3) {
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = -1;
        }

        boolean a(int i2) {
            int i3;
            int i4 = this.primaryFormat;
            if (i4 == 7 || i2 == 7 || i4 == i2 || (i3 = this.secondaryFormat) == i2) {
                return true;
            }
            if ((i4 == 4 || i3 == 4) && i2 == 3) {
                return true;
            }
            if ((i4 == 9 || i3 == 9) && i2 == 8) {
                return true;
            }
            return (i4 == 12 || i3 == 12) && i2 == 11;
        }

        ExifTag(String str, int i2, int i3, int i4) {
            this.name = str;
            this.number = i2;
            this.primaryFormat = i3;
            this.secondaryFormat = i4;
        }
    }

    public ExifInterface(@NonNull InputStream inputStream) throws IOException {
        ExifTag[][] exifTagArr = t0;
        this.n1 = new HashMap[exifTagArr.length];
        this.o1 = new HashSet(exifTagArr.length);
        this.p1 = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.k1 = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.l1 = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.l1 = null;
            }
            w(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }
}
