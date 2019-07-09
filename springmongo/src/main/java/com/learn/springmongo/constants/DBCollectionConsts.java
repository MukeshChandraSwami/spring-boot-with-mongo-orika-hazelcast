package com.learn.springmongo.constants;

public enum DBCollectionConsts {

    AUTHOR("AUTHOR"), BOOKS("BOOKS");

    private String collection;
    DBCollectionConsts(String collection) {
        this.collection = collection;
    }

    public String getCollection(){ return this.collection; }
}