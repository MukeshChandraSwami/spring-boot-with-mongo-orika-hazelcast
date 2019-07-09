package com.learn.springmongo.constants;

public enum DBQueryAttributes {

    AUTHOR_ID("authorId"), CRATED_BY("createdBy"), UPDATED_BY("updatedBy"),AUTHOR_NAME("name"),
    AUTHOR_CONTACT_NUMBER("contactNum"),AUTHOR_BOOKS("books"), UPDATED_AT("updatedAt");

    private String queryParams;

    DBQueryAttributes(String queryParams){
        this.queryParams = queryParams;
    }

    public String getParam() {
        return queryParams;
    }
}
