package com.financial.management.domain.enums;

public enum CategoryType {

    RECEITA(1),
    DESPESA(2);

    private final Integer categoryTypeCode;

    CategoryType(Integer code) {
        this.categoryTypeCode = code;
    }

    public int getCategoryTypeCode() {
        return categoryTypeCode;
    }

    public static CategoryType valueOf(Integer code){
        for (CategoryType value : CategoryType.values()){
            if (value.getCategoryTypeCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid category type code");
    }
}
