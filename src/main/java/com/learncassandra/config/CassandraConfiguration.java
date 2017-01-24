package com.learncassandra.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;

/**
 * Created by z001qgd on 1/18/17.
 */
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setContactPoints(environment.getProperty("cassandra.contactpoints"));
        cluster.setPort(Integer.parseInt(environment.getProperty("cassandra.port")));
        return cluster;
    }

  @Override
    protected String getKeyspaceName() {
      System.out.println("Key Space Value is : " + environment.getProperty("cassandra.keyspace"));
        return environment.getProperty("cassandra.keyspace");
    }

    @Bean
    public CassandraMappingContext cassandraMapping() throws ClassNotFoundException {
        return new BasicCassandraMappingContext();
    }

    /*@Bean
    public CassandraAdminOperations cassandraTemplate(){

        CassandraOperations cassandraOperations = new CassandraTemplate();

        return cassandraOperations;
    }*/



}
