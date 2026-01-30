package com.financial.management.domain.enums;

public enum CategoryType {

    RECEITA(1),
    DESPESA(2);

    private Integer code;

    CategoryType(Integer code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static CategoryType valueOf(Integer code){
        for (CategoryType value : CategoryType.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid category type code");
    }
}
