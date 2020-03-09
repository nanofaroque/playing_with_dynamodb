package com.nanofaroque.playingwithdynamodb.playingwithdynamodb.services;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.nanofaroque.playingwithdynamodb.playingwithdynamodb.bussiness_models.User;

public class UserService implements IUserService {

    @Override
    public User insert(User usr) {
        User user=new User();
        user.setId(usr.getId());

        try{
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "local"))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

         String tableName = "Users";
        Table table = dynamoDB.getTable(tableName);

        Item item =new Item()
                 .withPrimaryKey("id","1","name","faroque")
                 .withString("city","Dallas");

        table.putItem(item);}
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return user;
    }
}
