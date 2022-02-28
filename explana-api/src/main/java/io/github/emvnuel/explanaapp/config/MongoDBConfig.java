package io.github.emvnuel.explanaapp.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableMongoRepositories
@Slf4j
public class MongoDBConfig extends AbstractMongoClientConfiguration {

    @Value("${mongo.root-user}")
    private String user;

    @Value("${mongo.root-password}")
    private String password;

    @Value("${mongo.host}")
    private String host;

    @Value("${mongo.database}")
    private String db;

    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return this.db;
    }

    @Override
    protected MongoClient createMongoClient(MongoClientSettings settings) {
        log.warn("LOG {}, {}, {}, {}", user, host, password, db);
        return MongoClients.create(new ConnectionString("mongodb://"+this.user+":"+this.password+"@"+host));
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }

    @Override
    public MongoCustomConversions customConversions() {
        return new MongoCustomConversions(converters);
    }

}
