package com.czhj.wire.protobuf;

import com.czhj.wire.EnumAdapter;
import com.czhj.wire.FieldEncoding;
import com.czhj.wire.Message;
import com.czhj.wire.ProtoAdapter;
import com.czhj.wire.ProtoReader;
import com.czhj.wire.ProtoWriter;
import com.czhj.wire.WireEnum;
import com.czhj.wire.WireField;
import com.czhj.wire.internal.Internal;
import com.czhj.wire.okio.ByteString;
import java.io.IOException;
import java.util.List;

/* loaded from: classes2.dex */
public final class FileOptions extends Message<FileOptions, Builder> {
    public static final ProtoAdapter<FileOptions> ADAPTER = new ProtoAdapter_FileOptions();
    public static final Boolean DEFAULT_CC_ENABLE_ARENAS;
    public static final Boolean DEFAULT_CC_GENERIC_SERVICES;
    public static final String DEFAULT_CSHARP_NAMESPACE = "";
    public static final Boolean DEFAULT_DEPRECATED;
    public static final String DEFAULT_GO_PACKAGE = "";
    public static final Boolean DEFAULT_JAVA_GENERATE_EQUALS_AND_HASH;
    public static final Boolean DEFAULT_JAVA_GENERIC_SERVICES;
    public static final Boolean DEFAULT_JAVA_MULTIPLE_FILES;
    public static final String DEFAULT_JAVA_OUTER_CLASSNAME = "";
    public static final String DEFAULT_JAVA_PACKAGE = "";
    public static final Boolean DEFAULT_JAVA_STRING_CHECK_UTF8;
    public static final String DEFAULT_OBJC_CLASS_PREFIX = "";
    public static final OptimizeMode DEFAULT_OPTIMIZE_FOR;
    public static final Boolean DEFAULT_PY_GENERIC_SERVICES;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 31)
    public final Boolean cc_enable_arenas;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 16)
    public final Boolean cc_generic_services;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 37)
    public final String csharp_namespace;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 23)
    public final Boolean deprecated;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String go_package;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 20)
    public final Boolean java_generate_equals_and_hash;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean java_generic_services;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean java_multiple_files;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String java_outer_classname;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String java_package;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 27)
    public final Boolean java_string_check_utf8;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 36)
    public final String objc_class_prefix;

    @WireField(adapter = "com.google.protobuf.FileOptions$OptimizeMode#ADAPTER", tag = 9)
    public final OptimizeMode optimize_for;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 18)
    public final Boolean py_generic_services;

    @WireField(adapter = "com.google.protobuf.UninterpretedOption#ADAPTER", label = WireField.Label.REPEATED, tag = 999)
    public final List<UninterpretedOption> uninterpreted_option;

    public static final class Builder extends Message.Builder<FileOptions, Builder> {
        public Boolean cc_enable_arenas;
        public Boolean cc_generic_services;
        public String csharp_namespace;
        public Boolean deprecated;
        public String go_package;
        public Boolean java_generate_equals_and_hash;
        public Boolean java_generic_services;
        public Boolean java_multiple_files;
        public String java_outer_classname;
        public String java_package;
        public Boolean java_string_check_utf8;
        public String objc_class_prefix;
        public OptimizeMode optimize_for;
        public Boolean py_generic_services;
        public List<UninterpretedOption> uninterpreted_option = Internal.newMutableList();

        public Builder cc_enable_arenas(Boolean bool) {
            this.cc_enable_arenas = bool;
            return this;
        }

        public Builder cc_generic_services(Boolean bool) {
            this.cc_generic_services = bool;
            return this;
        }

        public Builder csharp_namespace(String str) {
            this.csharp_namespace = str;
            return this;
        }

        public Builder deprecated(Boolean bool) {
            this.deprecated = bool;
            return this;
        }

        public Builder go_package(String str) {
            this.go_package = str;
            return this;
        }

        public Builder java_generate_equals_and_hash(Boolean bool) {
            this.java_generate_equals_and_hash = bool;
            return this;
        }

        public Builder java_generic_services(Boolean bool) {
            this.java_generic_services = bool;
            return this;
        }

        public Builder java_multiple_files(Boolean bool) {
            this.java_multiple_files = bool;
            return this;
        }

        public Builder java_outer_classname(String str) {
            this.java_outer_classname = str;
            return this;
        }

        public Builder java_package(String str) {
            this.java_package = str;
            return this;
        }

        public Builder java_string_check_utf8(Boolean bool) {
            this.java_string_check_utf8 = bool;
            return this;
        }

        public Builder objc_class_prefix(String str) {
            this.objc_class_prefix = str;
            return this;
        }

        public Builder optimize_for(OptimizeMode optimizeMode) {
            this.optimize_for = optimizeMode;
            return this;
        }

        public Builder py_generic_services(Boolean bool) {
            this.py_generic_services = bool;
            return this;
        }

        public Builder uninterpreted_option(List<UninterpretedOption> list) {
            Internal.checkElementsNotNull(list);
            this.uninterpreted_option = list;
            return this;
        }

        @Override // com.czhj.wire.Message.Builder
        public FileOptions build() {
            return new FileOptions(this.java_package, this.java_outer_classname, this.java_multiple_files, this.java_generate_equals_and_hash, this.java_string_check_utf8, this.optimize_for, this.go_package, this.cc_generic_services, this.java_generic_services, this.py_generic_services, this.deprecated, this.cc_enable_arenas, this.objc_class_prefix, this.csharp_namespace, this.uninterpreted_option, super.buildUnknownFields());
        }
    }

    public enum OptimizeMode implements WireEnum {
        SPEED(1),
        CODE_SIZE(2),
        LITE_RUNTIME(3);

        public static final ProtoAdapter<OptimizeMode> ADAPTER = new ProtoAdapter_OptimizeMode();
        private final int value;

        public static final class ProtoAdapter_OptimizeMode extends EnumAdapter<OptimizeMode> {
            public ProtoAdapter_OptimizeMode() {
                super(OptimizeMode.class);
            }

            @Override // com.czhj.wire.EnumAdapter
            public OptimizeMode fromValue(int i10) {
                return OptimizeMode.fromValue(i10);
            }
        }

        OptimizeMode(int i10) {
            this.value = i10;
        }

        public static OptimizeMode fromValue(int i10) {
            if (i10 == 1) {
                return SPEED;
            }
            if (i10 == 2) {
                return CODE_SIZE;
            }
            if (i10 != 3) {
                return null;
            }
            return LITE_RUNTIME;
        }

        @Override // com.czhj.wire.WireEnum
        public int getValue() {
            return this.value;
        }
    }

    public static final class ProtoAdapter_FileOptions extends ProtoAdapter<FileOptions> {
        public ProtoAdapter_FileOptions() {
            super(FieldEncoding.LENGTH_DELIMITED, FileOptions.class);
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileOptions decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
                if (nextTag == 1) {
                    builder.java_package(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 20) {
                    builder.java_generate_equals_and_hash(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 23) {
                    builder.deprecated(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 27) {
                    builder.java_string_check_utf8(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 31) {
                    builder.cc_enable_arenas(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 999) {
                    builder.uninterpreted_option.add(UninterpretedOption.ADAPTER.decode(protoReader));
                } else if (nextTag == 36) {
                    builder.objc_class_prefix(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 37) {
                    switch (nextTag) {
                        case 8:
                            builder.java_outer_classname(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            try {
                                builder.optimize_for(OptimizeMode.ADAPTER.decode(protoReader));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e10) {
                                builder.addUnknownField(nextTag, FieldEncoding.VARINT, Long.valueOf(e10.value));
                                break;
                            }
                        case 10:
                            builder.java_multiple_files(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 11:
                            builder.go_package(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            switch (nextTag) {
                                case 16:
                                    builder.cc_generic_services(ProtoAdapter.BOOL.decode(protoReader));
                                    break;
                                case 17:
                                    builder.java_generic_services(ProtoAdapter.BOOL.decode(protoReader));
                                    break;
                                case 18:
                                    builder.py_generic_services(ProtoAdapter.BOOL.decode(protoReader));
                                    break;
                                default:
                                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                                    break;
                            }
                    }
                } else {
                    builder.csharp_namespace(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        @Override // com.czhj.wire.ProtoAdapter
        public void encode(ProtoWriter protoWriter, FileOptions fileOptions) throws IOException {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            protoAdapter.encodeWithTag(protoWriter, 1, fileOptions.java_package);
            protoAdapter.encodeWithTag(protoWriter, 8, fileOptions.java_outer_classname);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            protoAdapter2.encodeWithTag(protoWriter, 10, fileOptions.java_multiple_files);
            protoAdapter2.encodeWithTag(protoWriter, 20, fileOptions.java_generate_equals_and_hash);
            protoAdapter2.encodeWithTag(protoWriter, 27, fileOptions.java_string_check_utf8);
            OptimizeMode.ADAPTER.encodeWithTag(protoWriter, 9, fileOptions.optimize_for);
            protoAdapter.encodeWithTag(protoWriter, 11, fileOptions.go_package);
            protoAdapter2.encodeWithTag(protoWriter, 16, fileOptions.cc_generic_services);
            protoAdapter2.encodeWithTag(protoWriter, 17, fileOptions.java_generic_services);
            protoAdapter2.encodeWithTag(protoWriter, 18, fileOptions.py_generic_services);
            protoAdapter2.encodeWithTag(protoWriter, 23, fileOptions.deprecated);
            protoAdapter2.encodeWithTag(protoWriter, 31, fileOptions.cc_enable_arenas);
            protoAdapter.encodeWithTag(protoWriter, 36, fileOptions.objc_class_prefix);
            protoAdapter.encodeWithTag(protoWriter, 37, fileOptions.csharp_namespace);
            UninterpretedOption.ADAPTER.asRepeated().encodeWithTag(protoWriter, 999, fileOptions.uninterpreted_option);
            protoWriter.writeBytes(fileOptions.unknownFields());
        }

        @Override // com.czhj.wire.ProtoAdapter
        public int encodedSize(FileOptions fileOptions) {
            ProtoAdapter<String> protoAdapter = ProtoAdapter.STRING;
            int encodedSizeWithTag = protoAdapter.encodedSizeWithTag(1, fileOptions.java_package) + protoAdapter.encodedSizeWithTag(8, fileOptions.java_outer_classname);
            ProtoAdapter<Boolean> protoAdapter2 = ProtoAdapter.BOOL;
            return encodedSizeWithTag + protoAdapter2.encodedSizeWithTag(10, fileOptions.java_multiple_files) + protoAdapter2.encodedSizeWithTag(20, fileOptions.java_generate_equals_and_hash) + protoAdapter2.encodedSizeWithTag(27, fileOptions.java_string_check_utf8) + OptimizeMode.ADAPTER.encodedSizeWithTag(9, fileOptions.optimize_for) + protoAdapter.encodedSizeWithTag(11, fileOptions.go_package) + protoAdapter2.encodedSizeWithTag(16, fileOptions.cc_generic_services) + protoAdapter2.encodedSizeWithTag(17, fileOptions.java_generic_services) + protoAdapter2.encodedSizeWithTag(18, fileOptions.py_generic_services) + protoAdapter2.encodedSizeWithTag(23, fileOptions.deprecated) + protoAdapter2.encodedSizeWithTag(31, fileOptions.cc_enable_arenas) + protoAdapter.encodedSizeWithTag(36, fileOptions.objc_class_prefix) + protoAdapter.encodedSizeWithTag(37, fileOptions.csharp_namespace) + UninterpretedOption.ADAPTER.asRepeated().encodedSizeWithTag(999, fileOptions.uninterpreted_option) + fileOptions.unknownFields().size();
        }

        @Override // com.czhj.wire.ProtoAdapter
        public FileOptions redact(FileOptions fileOptions) {
            Builder newBuilder = fileOptions.newBuilder();
            Internal.redactElements(newBuilder.uninterpreted_option, UninterpretedOption.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        DEFAULT_JAVA_MULTIPLE_FILES = bool;
        DEFAULT_JAVA_GENERATE_EQUALS_AND_HASH = bool;
        DEFAULT_JAVA_STRING_CHECK_UTF8 = bool;
        DEFAULT_OPTIMIZE_FOR = OptimizeMode.SPEED;
        DEFAULT_CC_GENERIC_SERVICES = bool;
        DEFAULT_JAVA_GENERIC_SERVICES = bool;
        DEFAULT_PY_GENERIC_SERVICES = bool;
        DEFAULT_DEPRECATED = bool;
        DEFAULT_CC_ENABLE_ARENAS = bool;
    }

    public FileOptions(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, OptimizeMode optimizeMode, String str3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, String str4, String str5, List<UninterpretedOption> list) {
        this(str, str2, bool, bool2, bool3, optimizeMode, str3, bool4, bool5, bool6, bool7, bool8, str4, str5, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FileOptions)) {
            return false;
        }
        FileOptions fileOptions = (FileOptions) obj;
        return unknownFields().equals(fileOptions.unknownFields()) && Internal.equals(this.java_package, fileOptions.java_package) && Internal.equals(this.java_outer_classname, fileOptions.java_outer_classname) && Internal.equals(this.java_multiple_files, fileOptions.java_multiple_files) && Internal.equals(this.java_generate_equals_and_hash, fileOptions.java_generate_equals_and_hash) && Internal.equals(this.java_string_check_utf8, fileOptions.java_string_check_utf8) && Internal.equals(this.optimize_for, fileOptions.optimize_for) && Internal.equals(this.go_package, fileOptions.go_package) && Internal.equals(this.cc_generic_services, fileOptions.cc_generic_services) && Internal.equals(this.java_generic_services, fileOptions.java_generic_services) && Internal.equals(this.py_generic_services, fileOptions.py_generic_services) && Internal.equals(this.deprecated, fileOptions.deprecated) && Internal.equals(this.cc_enable_arenas, fileOptions.cc_enable_arenas) && Internal.equals(this.objc_class_prefix, fileOptions.objc_class_prefix) && Internal.equals(this.csharp_namespace, fileOptions.csharp_namespace) && this.uninterpreted_option.equals(fileOptions.uninterpreted_option);
    }

    public int hashCode() {
        int i10 = this.hashCode;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.java_package;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.java_outer_classname;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.java_multiple_files;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.java_generate_equals_and_hash;
        int hashCode5 = (hashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.java_string_check_utf8;
        int hashCode6 = (hashCode5 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        OptimizeMode optimizeMode = this.optimize_for;
        int hashCode7 = (hashCode6 + (optimizeMode != null ? optimizeMode.hashCode() : 0)) * 37;
        String str3 = this.go_package;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool4 = this.cc_generic_services;
        int hashCode9 = (hashCode8 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.java_generic_services;
        int hashCode10 = (hashCode9 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.py_generic_services;
        int hashCode11 = (hashCode10 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        Boolean bool7 = this.deprecated;
        int hashCode12 = (hashCode11 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Boolean bool8 = this.cc_enable_arenas;
        int hashCode13 = (hashCode12 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        String str4 = this.objc_class_prefix;
        int hashCode14 = (hashCode13 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.csharp_namespace;
        int hashCode15 = ((hashCode14 + (str5 != null ? str5.hashCode() : 0)) * 37) + this.uninterpreted_option.hashCode();
        this.hashCode = hashCode15;
        return hashCode15;
    }

    @Override // com.czhj.wire.Message
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.java_package != null) {
            sb2.append(", java_package=");
            sb2.append(this.java_package);
        }
        if (this.java_outer_classname != null) {
            sb2.append(", java_outer_classname=");
            sb2.append(this.java_outer_classname);
        }
        if (this.java_multiple_files != null) {
            sb2.append(", java_multiple_files=");
            sb2.append(this.java_multiple_files);
        }
        if (this.java_generate_equals_and_hash != null) {
            sb2.append(", java_generate_equals_and_hash=");
            sb2.append(this.java_generate_equals_and_hash);
        }
        if (this.java_string_check_utf8 != null) {
            sb2.append(", java_string_check_utf8=");
            sb2.append(this.java_string_check_utf8);
        }
        if (this.optimize_for != null) {
            sb2.append(", optimize_for=");
            sb2.append(this.optimize_for);
        }
        if (this.go_package != null) {
            sb2.append(", go_package=");
            sb2.append(this.go_package);
        }
        if (this.cc_generic_services != null) {
            sb2.append(", cc_generic_services=");
            sb2.append(this.cc_generic_services);
        }
        if (this.java_generic_services != null) {
            sb2.append(", java_generic_services=");
            sb2.append(this.java_generic_services);
        }
        if (this.py_generic_services != null) {
            sb2.append(", py_generic_services=");
            sb2.append(this.py_generic_services);
        }
        if (this.deprecated != null) {
            sb2.append(", deprecated=");
            sb2.append(this.deprecated);
        }
        if (this.cc_enable_arenas != null) {
            sb2.append(", cc_enable_arenas=");
            sb2.append(this.cc_enable_arenas);
        }
        if (this.objc_class_prefix != null) {
            sb2.append(", objc_class_prefix=");
            sb2.append(this.objc_class_prefix);
        }
        if (this.csharp_namespace != null) {
            sb2.append(", csharp_namespace=");
            sb2.append(this.csharp_namespace);
        }
        if (!this.uninterpreted_option.isEmpty()) {
            sb2.append(", uninterpreted_option=");
            sb2.append(this.uninterpreted_option);
        }
        StringBuilder replace = sb2.replace(0, 2, "FileOptions{");
        replace.append('}');
        return replace.toString();
    }

    public FileOptions(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, OptimizeMode optimizeMode, String str3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, String str4, String str5, List<UninterpretedOption> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.java_package = str;
        this.java_outer_classname = str2;
        this.java_multiple_files = bool;
        this.java_generate_equals_and_hash = bool2;
        this.java_string_check_utf8 = bool3;
        this.optimize_for = optimizeMode;
        this.go_package = str3;
        this.cc_generic_services = bool4;
        this.java_generic_services = bool5;
        this.py_generic_services = bool6;
        this.deprecated = bool7;
        this.cc_enable_arenas = bool8;
        this.objc_class_prefix = str4;
        this.csharp_namespace = str5;
        this.uninterpreted_option = Internal.immutableCopyOf("uninterpreted_option", list);
    }

    @Override // com.czhj.wire.Message
    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.java_package = this.java_package;
        builder.java_outer_classname = this.java_outer_classname;
        builder.java_multiple_files = this.java_multiple_files;
        builder.java_generate_equals_and_hash = this.java_generate_equals_and_hash;
        builder.java_string_check_utf8 = this.java_string_check_utf8;
        builder.optimize_for = this.optimize_for;
        builder.go_package = this.go_package;
        builder.cc_generic_services = this.cc_generic_services;
        builder.java_generic_services = this.java_generic_services;
        builder.py_generic_services = this.py_generic_services;
        builder.deprecated = this.deprecated;
        builder.cc_enable_arenas = this.cc_enable_arenas;
        builder.objc_class_prefix = this.objc_class_prefix;
        builder.csharp_namespace = this.csharp_namespace;
        builder.uninterpreted_option = Internal.copyOf("uninterpreted_option", this.uninterpreted_option);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
