package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.DynamoDbClient;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
    public List<User> read(User user) {
        List<User> users= new ArrayList<>();
        try {
            String tableName = "DataSources";
            Table table = DynamoDbClient.getDynamoDb().getTable(tableName);
            QuerySpec spec = new QuerySpec()
                    .withKeyConditionExpression("p_key=:pId and begins_with(sort_key, :s)")
                    .withValueMap(new ValueMap()
                            .withString(":pId", "1")
                            .withString(":s", "f")
                    ).withConsistentRead(true);

            ItemCollection<QueryOutcome> items = table.query(spec);


            Iterator<Item> iterator = items.iterator();
            while (iterator.hasNext()) {
                Item item=iterator.next();
                User u= new User();
                u.setCity(item.getString("city"));
                users.add(u);
            }

            return users;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return users;
    }
}
