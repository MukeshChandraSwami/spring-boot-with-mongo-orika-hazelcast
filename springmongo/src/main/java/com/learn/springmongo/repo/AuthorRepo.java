package com.learn.springmongo.repo;

import com.learn.springmongo.config.CustomMongoConfig;
import com.learn.springmongo.constants.DBCollectionConsts;
import com.learn.springmongo.constants.DBQueryAttributes;
import com.learn.springmongo.entity.AuthorEO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class AuthorRepo {

    public Optional<AuthorEO> findById(String id){

        MongoDatabase mongoDb = CustomMongoConfig.getMongoInstance().getMongoDatabase();
        MongoCollection col = mongoDb.getCollection(DBCollectionConsts.AUTHOR.getCollection()).withDocumentClass(AuthorEO.class);
        AuthorEO authorEO = (AuthorEO)col.find(Filters.eq(DBQueryAttributes.AUTHOR_ID.getParam(),id)).first();
        if(authorEO != null){
            return Optional.of(authorEO);
        }
        return Optional.empty();
    }

    public void save(AuthorEO author) {

        MongoDatabase mongoDb = CustomMongoConfig.getMongoInstance().getMongoDatabase();
        MongoCollection col = mongoDb.getCollection(DBCollectionConsts.AUTHOR.getCollection()).withDocumentClass(AuthorEO.class);
        col.insertOne(author);
    }

    public long getTotalAuthors() {
        MongoDatabase mongoDb = CustomMongoConfig.getMongoInstance().getMongoDatabase();
        MongoCollection col = mongoDb.getCollection(DBCollectionConsts.AUTHOR.getCollection());
        return col.countDocuments();
    }

    public long updateAuthor(AuthorEO author, String id) {

        MongoDatabase mongoDb = CustomMongoConfig.getMongoInstance().getMongoDatabase();
        MongoCollection col = mongoDb.getCollection(DBCollectionConsts.AUTHOR.getCollection()).withDocumentClass(AuthorEO.class);

        Document updateQuery = new Document().append(DBQueryAttributes.CRATED_BY.getParam(),author.getCreatedBy())
                .append(DBQueryAttributes.UPDATED_BY.getParam(),author.getUpdatedBy())
                .append(DBQueryAttributes.AUTHOR_NAME.getParam(),author.getName())
                .append(DBQueryAttributes.AUTHOR_CONTACT_NUMBER.getParam(),author.getContactNum())
                .append(DBQueryAttributes.AUTHOR_BOOKS.getParam(),author.getBooks())
                .append(DBQueryAttributes.UPDATED_AT.getParam(),new Date().getTime());

        UpdateResult updateResult = col.updateOne(Filters.eq(DBQueryAttributes.AUTHOR_ID.getParam(),id),new Document("$set",updateQuery));

        if(updateResult != null){
            return updateResult.getModifiedCount();
        }

        return 0;
    }


    public long purgeAuthor(String id) {
        MongoDatabase mongoDb = CustomMongoConfig.getMongoInstance().getMongoDatabase();
        MongoCollection col = mongoDb.getCollection(DBCollectionConsts.AUTHOR.getCollection()).withDocumentClass(AuthorEO.class);
        DeleteResult result = col.deleteOne(Filters.eq(DBQueryAttributes.AUTHOR_ID.getParam(),id));
        if(result != null){
            return result.getDeletedCount();
        }
        return 0;
    }
}
