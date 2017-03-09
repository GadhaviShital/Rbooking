package edu.unh.rbooking.constant;

public enum ExceptionEnum {
    DEFAULT_ERROR("default.error", 100),
    VALIDATION_ERROR("validation.error", 101),
    NOT_FOUND_ERROR("not.found.error", 103),
    SIMPLE_ERROR("simple.error", 105),
    NOT_SUPPORTED_ERROR("not.supported.error", 108),
    ALREADY_EXISTS_ERROR("already.exists.error", 109);

    private String name;
    private int code;

   	private ExceptionEnum(String name, int code) {
   		this.name = name;
        this.code = code;
   	}

   	public String getName() {
   		return name;
   	}

    public int getCode() { return code; }
}

