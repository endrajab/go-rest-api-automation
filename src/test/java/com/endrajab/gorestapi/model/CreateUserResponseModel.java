package com.endrajab.gorestapi.model;

public class CreateUserResponseModel {
    private String code;

    private String meta;

    private DataCreateUserResponseModel dataCreateUserResponseModel;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    public DataCreateUserResponseModel getDataCreateUserResponseModel() {
        return dataCreateUserResponseModel;
    }

    public void setDataCreateUserResponseModel(DataCreateUserResponseModel dataCreateUserResponseModel) {
        this.dataCreateUserResponseModel = dataCreateUserResponseModel;
    }
}
