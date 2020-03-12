package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.ReturnConsumedCapacity;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UserService implements IUserService {

    @Override
    public User insert(User usr) {
        User user = new User();
        user.setId(usr.getId());

        try {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "local"))
                    .build();
            DynamoDB dynamoDB = new DynamoDB(client);

            String tableName = "Users";
            Table table = dynamoDB.getTable(tableName);

            Item item = new Item()
                    .withPrimaryKey("id", "1", "name", "faroque")
                    .withString("city", "Dallas");

            table.putItem(item);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return user;
    }

    @Override
    public User read(User user) {
        try {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "local"))
                    .build();
            DynamoDB dynamoDB = new DynamoDB(client);

            String tableName = "DataSources";
            Table table = dynamoDB.getTable(tableName);
            QuerySpec spec = new QuerySpec()
                    .withKeyConditionExpression("p_key=:pId and begins_with(sort_key, :s)")
                    .withValueMap(new ValueMap()
                            .withString(":pId", "1")
                            .withString(":s", "f")
                    ).withConsistentRead(true);

            ItemCollection<QueryOutcome> items = table.query(spec);

            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toJSONPretty());
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
