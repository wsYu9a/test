package kotlin.text;

import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.kwad.sdk.api.model.AdnName;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import f.b.a.d;
import f.b.a.e;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0019\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b¢\u0006\u0004\b\u0005\u0010\b\u001a$\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b¢\u0006\u0004\b\t\u0010\u0006\u001a$\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0081\b¢\u0006\u0004\b\t\u0010\b\u001a'\u0010\r\u001a\u00020\u000b*\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012\u001a+\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0015\u001a+\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0012\u001a+\u0010\u0016\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u0014\u0010\u0017\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a\u0013\u0010\u001b\u001a\u00020\u0000*\u00020\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a'\u0010\u001b\u001a\u00020\u0000*\u00020\u001a2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u001b\u0010\u001f\u001a'\u0010 \u001a\u00020\u001a*\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u0003H\u0007¢\u0006\u0004\b \u0010!\u001a\u0013\u0010#\u001a\u00020\u0000*\u00020\"H\u0007¢\u0006\u0004\b#\u0010$\u001a1\u0010#\u001a\u00020\u0000*\u00020\"2\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u000bH\u0007¢\u0006\u0004\b#\u0010&\u001a\u0013\u0010'\u001a\u00020\"*\u00020\u0000H\u0007¢\u0006\u0004\b'\u0010(\u001a1\u0010'\u001a\u00020\"*\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u000bH\u0007¢\u0006\u0004\b'\u0010)\u001a\u0014\u0010 \u001a\u00020\u001a*\u00020\u0000H\u0087\b¢\u0006\u0004\b \u0010*\u001a:\u0010 \u001a\u00020\u001a*\u00020\u00002\u0006\u0010+\u001a\u00020\u001a2\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b \u0010-\u001a,\u00101\u001a\u00020\u0000*\u00020\u00002\u0016\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.\"\u0004\u0018\u00010/H\u0087\b¢\u0006\u0004\b1\u00102\u001a4\u00101\u001a\u00020\u0000*\u0002032\u0006\u00101\u001a\u00020\u00002\u0016\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.\"\u0004\u0018\u00010/H\u0087\b¢\u0006\u0004\b1\u00104\u001a4\u00101\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u0002052\u0016\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.\"\u0004\u0018\u00010/H\u0087\b¢\u0006\u0004\b1\u00107\u001a<\u00101\u001a\u00020\u0000*\u0002032\u0006\u00106\u001a\u0002052\u0006\u00101\u001a\u00020\u00002\u0016\u00100\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.\"\u0004\u0018\u00010/H\u0087\b¢\u0006\u0004\b1\u00108\u001a)\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00000=*\u0002092\u0006\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020\u0003¢\u0006\u0004\b>\u0010?\u001a\u001c\u0010@\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b@\u0010A\u001a$\u0010@\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b@\u0010B\u001a#\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bD\u0010\u000e\u001a+\u0010D\u001a\u00020\u000b*\u00020\u00002\u0006\u0010C\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bD\u0010E\u001a#\u0010G\u001a\u00020\u000b*\u00020\u00002\u0006\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bG\u0010\u000e\u001a0\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010L\u001a\u00020KH\u0087\b¢\u0006\u0004\bM\u0010N\u001a \u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\"2\u0006\u0010L\u001a\u00020KH\u0087\b¢\u0006\u0004\bM\u0010O\u001a(\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\"2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bM\u0010P\u001a\u0018\u0010M\u001a\u00020\u00002\u0006\u0010H\u001a\u00020\"H\u0087\b¢\u0006\u0004\bM\u0010$\u001a\u0018\u0010M\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001aH\u0087\b¢\u0006\u0004\bM\u0010\u001c\u001a(\u0010M\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u001a2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bM\u0010\u001f\u001a(\u0010M\u001a\u00020\u00002\u0006\u0010S\u001a\u00020R2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bM\u0010T\u001a\u0018\u0010M\u001a\u00020\u00002\u0006\u0010V\u001a\u00020UH\u0087\b¢\u0006\u0004\bM\u0010W\u001a\u0018\u0010M\u001a\u00020\u00002\u0006\u0010Y\u001a\u00020XH\u0087\b¢\u0006\u0004\bM\u0010Z\u001a\u001c\u0010\\\u001a\u00020\u0003*\u00020\u00002\u0006\u0010[\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b\\\u0010]\u001a\u001c\u0010^\u001a\u00020\u0003*\u00020\u00002\u0006\u0010[\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b^\u0010]\u001a$\u0010`\u001a\u00020\u0003*\u00020\u00002\u0006\u0010_\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b`\u0010a\u001a#\u0010b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010d\u001a\u000209H\u0087\b¢\u0006\u0004\be\u0010f\u001a\u001c\u0010e\u001a\u00020\u000b*\u00020\u00002\u0006\u0010Y\u001a\u00020UH\u0087\b¢\u0006\u0004\be\u0010g\u001a\u0014\u0010h\u001a\u00020\u0000*\u00020\u0000H\u0087\b¢\u0006\u0004\bh\u0010\u0018\u001a\u0011\u0010i\u001a\u00020\u000b*\u000209¢\u0006\u0004\bi\u0010j\u001a$\u0010l\u001a\u00020\u0003*\u00020\u00002\u0006\u0010[\u001a\u00020\u00032\u0006\u0010k\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bl\u0010a\u001a;\u0010o\u001a\u00020\u000b*\u0002092\u0006\u0010m\u001a\u00020\u00032\u0006\u0010\n\u001a\u0002092\u0006\u0010n\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bo\u0010p\u001a;\u0010o\u001a\u00020\u000b*\u00020\u00002\u0006\u0010m\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\bo\u0010q\u001a\u001c\u0010\u0019\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u000205H\u0087\b¢\u0006\u0004\b\u0019\u0010r\u001a\u001c\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u000205H\u0087\b¢\u0006\u0004\b\u0017\u0010r\u001a\u001e\u0010s\u001a\u00020\"*\u00020\u00002\b\b\u0002\u0010L\u001a\u00020KH\u0087\b¢\u0006\u0004\bs\u0010t\u001a\u001e\u0010v\u001a\u00020:*\u00020\u00002\b\b\u0002\u0010u\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bv\u0010w\u001a\u0011\u0010x\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\bx\u0010\u0018\u001a\u001b\u0010x\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\bx\u0010r\u001a\u0011\u0010y\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\by\u0010\u0018\u001a\u001b\u0010y\u001a\u00020\u0000*\u00020\u00002\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\by\u0010r\u001a\u0019\u0010{\u001a\u00020\u0000*\u0002092\u0006\u0010z\u001a\u00020\u0003¢\u0006\u0004\b{\u0010|\")\u0010\u0081\u0001\u001a\u0012\u0012\u0004\u0012\u00020\u00000}j\b\u0012\u0004\u0012\u00020\u0000`~*\u0002038F@\u0006¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0082\u0001"}, d2 = {"", "", RedirectReqWrapper.KEY_CHANNEL, "", "fromIndex", "nativeIndexOf", "(Ljava/lang/String;CI)I", "str", "(Ljava/lang/String;Ljava/lang/String;I)I", "nativeLastIndexOf", AdnName.OTHER, "", "ignoreCase", "equals", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "oldChar", "newChar", "replace", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "replaceFirst", "toUpperCase", "(Ljava/lang/String;)Ljava/lang/String;", "toLowerCase", "", "concatToString", "([C)Ljava/lang/String;", "startIndex", "endIndex", "([CII)Ljava/lang/String;", "toCharArray", "(Ljava/lang/String;II)[C", "", "decodeToString", "([B)Ljava/lang/String;", "throwOnInvalidSequence", "([BIIZ)Ljava/lang/String;", "encodeToByteArray", "(Ljava/lang/String;)[B", "(Ljava/lang/String;IIZ)[B", "(Ljava/lang/String;)[C", "destination", "destinationOffset", "(Ljava/lang/String;[CIII)[C", "", "", ProcessBridgeProvider.KEY_ARGS, "format", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "", "Ljava/util/regex/Pattern;", "regex", "limit", "", "split", "(Ljava/lang/CharSequence;Ljava/util/regex/Pattern;I)Ljava/util/List;", "substring", "(Ljava/lang/String;I)Ljava/lang/String;", "(Ljava/lang/String;II)Ljava/lang/String;", "prefix", "startsWith", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "suffix", "endsWith", "bytes", "offset", "length", "Ljava/nio/charset/Charset;", "charset", "String", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "([BII)Ljava/lang/String;", "chars", "", "codePoints", "([III)Ljava/lang/String;", "Ljava/lang/StringBuffer;", "stringBuffer", "(Ljava/lang/StringBuffer;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "stringBuilder", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "index", "codePointAt", "(Ljava/lang/String;I)I", "codePointBefore", "beginIndex", "codePointCount", "(Ljava/lang/String;II)I", "compareTo", "(Ljava/lang/String;Ljava/lang/String;Z)I", "charSequence", "contentEquals", "(Ljava/lang/String;Ljava/lang/CharSequence;)Z", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "intern", "isBlank", "(Ljava/lang/CharSequence;)Z", "codePointOffset", "offsetByCodePoints", "thisOffset", "otherOffset", "regionMatches", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "flags", "toPattern", "(Ljava/lang/String;I)Ljava/util/regex/Pattern;", "capitalize", "decapitalize", "n", "repeat", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    @InlineOnly
    private static final String String(byte[] bArr, int i2, int i3, Charset charset) {
        return new String(bArr, i2, i3, charset);
    }

    @d
    public static final String capitalize(@d String capitalize) {
        Intrinsics.checkParameterIsNotNull(capitalize, "$this$capitalize");
        if (!(capitalize.length() > 0) || !Character.isLowerCase(capitalize.charAt(0))) {
            return capitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = capitalize.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = substring.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        String substring2 = capitalize.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @InlineOnly
    private static final int codePointAt(@d String str, int i2) {
        if (str != null) {
            return str.codePointAt(i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    private static final int codePointBefore(@d String str, int i2) {
        if (str != null) {
            return str.codePointBefore(i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    private static final int codePointCount(@d String str, int i2, int i3) {
        if (str != null) {
            return str.codePointCount(i2, i3);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final int compareTo(@d String compareTo, @d String other, boolean z) {
        Intrinsics.checkParameterIsNotNull(compareTo, "$this$compareTo");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return z ? compareTo.compareToIgnoreCase(other) : compareTo.compareTo(other);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String concatToString(@d char[] concatToString) {
        Intrinsics.checkParameterIsNotNull(concatToString, "$this$concatToString");
        return new String(concatToString);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return concatToString(cArr, i2, i3);
    }

    @InlineOnly
    private static final boolean contentEquals(@d String str, CharSequence charSequence) {
        if (str != null) {
            return str.contentEquals(charSequence);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @d
    public static final String decapitalize(@d String decapitalize) {
        Intrinsics.checkParameterIsNotNull(decapitalize, "$this$decapitalize");
        if (!(decapitalize.length() > 0) || !Character.isUpperCase(decapitalize.charAt(0))) {
            return decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = decapitalize.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String substring2 = decapitalize.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String decodeToString(@d byte[] decodeToString) {
        Intrinsics.checkParameterIsNotNull(decodeToString, "$this$decodeToString");
        return new String(decodeToString, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i2, i3, z);
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte[] encodeToByteArray(@d String encodeToByteArray) {
        Intrinsics.checkParameterIsNotNull(encodeToByteArray, "$this$encodeToByteArray");
        byte[] bytes = encodeToByteArray.getBytes(Charsets.UTF_8);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i2, i3, z);
    }

    public static final boolean endsWith(@d String endsWith, @d String suffix, boolean z) {
        Intrinsics.checkParameterIsNotNull(endsWith, "$this$endsWith");
        Intrinsics.checkParameterIsNotNull(suffix, "suffix");
        return !z ? endsWith.endsWith(suffix) : regionMatches(endsWith, endsWith.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(str, str2, z);
    }

    public static final boolean equals(@e String str, @e String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return equals(str, str2, z);
    }

    @InlineOnly
    private static final String format(@d String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
        return format;
    }

    @d
    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(@d StringCompanionObject CASE_INSENSITIVE_ORDER) {
        Intrinsics.checkParameterIsNotNull(CASE_INSENSITIVE_ORDER, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkExpressionValueIsNotNull(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    @InlineOnly
    private static final String intern(@d String str) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String intern = str.intern();
        Intrinsics.checkExpressionValueIsNotNull(intern, "(this as java.lang.String).intern()");
        return intern;
    }

    public static final boolean isBlank(@d CharSequence isBlank) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(isBlank, "$this$isBlank");
        if (isBlank.length() != 0) {
            Iterable indices = StringsKt__StringsKt.getIndices(isBlank);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator it = indices.iterator();
                while (it.hasNext()) {
                    if (!CharsKt__CharJVMKt.isWhitespace(isBlank.charAt(((IntIterator) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @InlineOnly
    private static final int nativeIndexOf(@d String str, char c2, int i2) {
        if (str != null) {
            return str.indexOf(c2, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    private static final int nativeLastIndexOf(@d String str, char c2, int i2) {
        if (str != null) {
            return str.lastIndexOf(c2, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    private static final int offsetByCodePoints(@d String str, int i2, int i3) {
        if (str != null) {
            return str.offsetByCodePoints(i2, i3);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static final boolean regionMatches(@d CharSequence regionMatches, int i2, @d CharSequence other, int i3, int i4, boolean z) {
        Intrinsics.checkParameterIsNotNull(regionMatches, "$this$regionMatches");
        Intrinsics.checkParameterIsNotNull(other, "other");
        return ((regionMatches instanceof String) && (other instanceof String)) ? regionMatches((String) regionMatches, i2, (String) other, i3, i4, z) : StringsKt__StringsKt.regionMatchesImpl(regionMatches, i2, other, i3, i4, z);
    }

    @d
    public static final String repeat(@d CharSequence repeat, int i2) {
        Intrinsics.checkParameterIsNotNull(repeat, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 == 1) {
            return repeat.toString();
        }
        int length = repeat.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = repeat.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = charAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(repeat.length() * i2);
        if (1 <= i2) {
            while (true) {
                sb.append(repeat);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    @d
    public static final String replace(@d String replace, char c2, char c3, boolean z) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(replace, "$this$replace");
        if (z) {
            joinToString$default = SequencesKt___SequencesKt.joinToString$default(StringsKt__StringsKt.splitToSequence$default(replace, new char[]{c2}, z, 0, 4, (Object) null), String.valueOf(c3), null, null, 0, null, null, 62, null);
            return joinToString$default;
        }
        String replace2 = replace.replace(c2, c3);
        Intrinsics.checkExpressionValueIsNotNull(replace2, "(this as java.lang.Strin…replace(oldChar, newChar)");
        return replace2;
    }

    public static /* synthetic */ String replace$default(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, c2, c3, z);
    }

    @d
    public static final String replaceFirst(@d String replaceFirst, char c2, char c3, boolean z) {
        Intrinsics.checkParameterIsNotNull(replaceFirst, "$this$replaceFirst");
        int indexOf$default = StringsKt__StringsKt.indexOf$default(replaceFirst, c2, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? replaceFirst : StringsKt__StringsKt.replaceRange((CharSequence) replaceFirst, indexOf$default, indexOf$default + 1, (CharSequence) String.valueOf(c3)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c2, c3, z);
    }

    @d
    public static final List<String> split(@d CharSequence split, @d Pattern regex, int i2) {
        List<String> asList;
        Intrinsics.checkParameterIsNotNull(split, "$this$split");
        Intrinsics.checkParameterIsNotNull(regex, "regex");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            i2 = -1;
        }
        String[] split2 = regex.split(split, i2);
        Intrinsics.checkExpressionValueIsNotNull(split2, "regex.split(this, if (limit == 0) -1 else limit)");
        asList = ArraysKt___ArraysJvmKt.asList(split2);
        return asList;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return split(charSequence, pattern, i2);
    }

    public static final boolean startsWith(@d String startsWith, @d String prefix, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        return !z ? startsWith.startsWith(prefix) : regionMatches(startsWith, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    @InlineOnly
    private static final String substring(@d String str, int i2) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    @InlineOnly
    private static final byte[] toByteArray(@d String str, Charset charset) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final char[] toCharArray(@d String toCharArray, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(toCharArray, "$this$toCharArray");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i2, i3, toCharArray.length());
        char[] cArr = new char[i3 - i2];
        toCharArray.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return toCharArray(str, i2, i3);
    }

    @InlineOnly
    private static final String toLowerCase(@d String str) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    @InlineOnly
    private static final Pattern toPattern(@d String str, int i2) {
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.checkExpressionValueIsNotNull(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    static /* synthetic */ Pattern toPattern$default(String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        Pattern compile = Pattern.compile(str, i2);
        Intrinsics.checkExpressionValueIsNotNull(compile, "java.util.regex.Pattern.compile(this, flags)");
        return compile;
    }

    @InlineOnly
    private static final String toUpperCase(@d String str) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
        return upperCase;
    }

    @InlineOnly
    private static final String String(byte[] bArr, Charset charset) {
        return new String(bArr, charset);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @d
    @LowPriorityInOverloadResolution
    public static final String capitalize(@d String capitalize, @d Locale locale) {
        Intrinsics.checkParameterIsNotNull(capitalize, "$this$capitalize");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        if (capitalize.length() > 0) {
            char charAt = capitalize.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = capitalize.substring(0, 1);
                    Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring == null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    String upperCase = substring.toUpperCase(locale);
                    Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = capitalize.substring(1);
                Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                String sb2 = sb.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
                return sb2;
            }
        }
        return capitalize;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String concatToString(@d char[] concatToString, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(concatToString, "$this$concatToString");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i2, i3, concatToString.length);
        return new String(concatToString, i2, i3 - i2);
    }

    @InlineOnly
    private static final boolean contentEquals(@d String str, StringBuffer stringBuffer) {
        if (str != null) {
            return str.contentEquals(stringBuffer);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @d
    @LowPriorityInOverloadResolution
    public static final String decapitalize(@d String decapitalize, @d Locale locale) {
        Intrinsics.checkParameterIsNotNull(decapitalize, "$this$decapitalize");
        Intrinsics.checkParameterIsNotNull(locale, "locale");
        if (!(decapitalize.length() > 0) || Character.isLowerCase(decapitalize.charAt(0))) {
            return decapitalize;
        }
        StringBuilder sb = new StringBuilder();
        String substring = decapitalize.substring(0, 1);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (substring == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String substring2 = decapitalize.substring(1);
        Intrinsics.checkExpressionValueIsNotNull(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final String decodeToString(@d byte[] decodeToString, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(decodeToString, "$this$decodeToString");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i2, i3, decodeToString.length);
        if (!z) {
            return new String(decodeToString, i2, i3 - i2, Charsets.UTF_8);
        }
        String charBuffer = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(decodeToString, i2, i3 - i2)).toString();
        Intrinsics.checkExpressionValueIsNotNull(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    @d
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    public static final byte[] encodeToByteArray(@d String encodeToByteArray, int i2, int i3, boolean z) {
        Intrinsics.checkParameterIsNotNull(encodeToByteArray, "$this$encodeToByteArray");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i2, i3, encodeToByteArray.length());
        if (!z) {
            String substring = encodeToByteArray.substring(i2, i3);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = Charsets.UTF_8;
            if (substring == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = substring.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(encodeToByteArray, i2, i3));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            if (array == null) {
                Intrinsics.throwNpe();
            }
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.checkExpressionValueIsNotNull(array2, "byteBuffer.array()");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    @InlineOnly
    private static final String format(@d StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        return format;
    }

    @InlineOnly
    private static final int nativeIndexOf(@d String str, String str2, int i2) {
        if (str != null) {
            return str.indexOf(str2, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @InlineOnly
    private static final int nativeLastIndexOf(@d String str, String str2, int i2) {
        if (str != null) {
            return str.lastIndexOf(str2, i2);
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i2, z);
    }

    @InlineOnly
    private static final String substring(@d String str, int i2, int i3) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = str.substring(i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    static /* synthetic */ char[] toCharArray$default(String str, char[] cArr, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = str.length();
        }
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @InlineOnly
    private static final String toLowerCase(@d String str, Locale locale) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @InlineOnly
    private static final String toUpperCase(@d String str, Locale locale) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @InlineOnly
    private static final String String(byte[] bArr, int i2, int i3) {
        return new String(bArr, i2, i3, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String format(@d String str, Locale locale, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }

    @d
    public static final String replace(@d String replace, @d String oldValue, @d String newValue, boolean z) {
        String joinToString$default;
        Intrinsics.checkParameterIsNotNull(replace, "$this$replace");
        Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        Intrinsics.checkParameterIsNotNull(newValue, "newValue");
        joinToString$default = SequencesKt___SequencesKt.joinToString$default(StringsKt__StringsKt.splitToSequence$default(replace, new String[]{oldValue}, z, 0, 4, (Object) null), newValue, null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    @d
    public static final String replaceFirst(@d String replaceFirst, @d String oldValue, @d String newValue, boolean z) {
        Intrinsics.checkParameterIsNotNull(replaceFirst, "$this$replaceFirst");
        Intrinsics.checkParameterIsNotNull(oldValue, "oldValue");
        Intrinsics.checkParameterIsNotNull(newValue, "newValue");
        int indexOf$default = StringsKt__StringsKt.indexOf$default(replaceFirst, oldValue, 0, z, 2, (Object) null);
        return indexOf$default < 0 ? replaceFirst : StringsKt__StringsKt.replaceRange((CharSequence) replaceFirst, indexOf$default, oldValue.length() + indexOf$default, (CharSequence) newValue).toString();
    }

    public static final boolean startsWith(@d String startsWith, @d String prefix, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(startsWith, "$this$startsWith");
        Intrinsics.checkParameterIsNotNull(prefix, "prefix");
        if (!z) {
            return startsWith.startsWith(prefix, i2);
        }
        return regionMatches(startsWith, i2, prefix, 0, prefix.length(), z);
    }

    @InlineOnly
    private static final char[] toCharArray(@d String str) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        char[] charArray = str.toCharArray();
        Intrinsics.checkExpressionValueIsNotNull(charArray, "(this as java.lang.String).toCharArray()");
        return charArray;
    }

    @InlineOnly
    private static final String String(byte[] bArr) {
        return new String(bArr, Charsets.UTF_8);
    }

    @InlineOnly
    private static final String format(@d StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }

    public static final boolean regionMatches(@d String regionMatches, int i2, @d String other, int i3, int i4, boolean z) {
        Intrinsics.checkParameterIsNotNull(regionMatches, "$this$regionMatches");
        Intrinsics.checkParameterIsNotNull(other, "other");
        if (!z) {
            return regionMatches.regionMatches(i2, other, i3, i4);
        }
        return regionMatches.regionMatches(z, i2, other, i3, i4);
    }

    @InlineOnly
    private static final char[] toCharArray(@d String str, char[] cArr, int i2, int i3, int i4) {
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        str.getChars(i3, i4, cArr, i2);
        return cArr;
    }

    @InlineOnly
    private static final String String(char[] cArr) {
        return new String(cArr);
    }

    @InlineOnly
    private static final String String(char[] cArr, int i2, int i3) {
        return new String(cArr, i2, i3);
    }

    @InlineOnly
    private static final String String(int[] iArr, int i2, int i3) {
        return new String(iArr, i2, i3);
    }

    @InlineOnly
    private static final String String(StringBuffer stringBuffer) {
        return new String(stringBuffer);
    }

    @InlineOnly
    private static final String String(StringBuilder sb) {
        return new String(sb);
    }
}
