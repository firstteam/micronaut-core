/*
 * Copyright 2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.particleframework.configuration.mongo.reactive;

import com.mongodb.ConnectionString;
import com.mongodb.async.client.MongoClientSettings;
import com.mongodb.connection.*;
import org.particleframework.context.annotation.ConfigurationBuilder;
import org.particleframework.context.annotation.ConfigurationProperties;
import org.particleframework.context.annotation.Requires;

import java.util.Optional;

/**
 * The default MongoDB configuration class
 *
 * @author graemerocher
 * @since 1.0
 */
@Requires(property = MongoSettings.MONGODB_URI)
@Requires(missingProperty = MongoSettings.MONGODB_ADDRESSES)
@ConfigurationProperties(MongoSettings.PREFIX)
public class MongoConfiguration extends AbstractMongoConfiguration {

    @ConfigurationBuilder(prefixes = "")
    protected MongoClientSettings.Builder clientSettings = MongoClientSettings.builder();

    @ConfigurationBuilder(prefixes = "", configurationPrefix = "cluster")
    protected ClusterSettings.Builder clusterSettings = ClusterSettings.builder();

    @ConfigurationBuilder(prefixes = "", configurationPrefix = "server")
    protected ServerSettings.Builder serverSettings = ServerSettings.builder();

    @ConfigurationBuilder(prefixes = "", configurationPrefix = "connectionPool")
    protected ConnectionPoolSettings.Builder poolSettings = ConnectionPoolSettings.builder();

    @ConfigurationBuilder(prefixes = "", configurationPrefix = "socket")
    protected SocketSettings.Builder socketSettings = SocketSettings.builder();

    @ConfigurationBuilder(prefixes = "", configurationPrefix = "ssl")
    protected SslSettings.Builder sslSettings = SslSettings.builder();


    /**
     * @return The {@link ClusterSettings#builder()}
     */
    @Override
    public ClusterSettings.Builder getClusterSettings() {
        return clusterSettings;
    }

    /**
     * @return The {@link MongoClientSettings#builder()}
     */
    @Override
    public MongoClientSettings.Builder getClientSettings() {
        return clientSettings;
    }


    @Override
    public ServerSettings.Builder getServerSettings() {
        return serverSettings;
    }

    @Override
    public ConnectionPoolSettings.Builder getPoolSettings() {
        return poolSettings;
    }

    @Override
    public SocketSettings.Builder getSocketSettings() {
        return socketSettings;
    }

    @Override
    public SslSettings.Builder getSslSettings() {
        return sslSettings;
    }

    @Override
    public String toString() {
        return "MongoConfiguration{" +
                "uri='" + getUri() + '\'' +
                ", clientSettings=" + clientSettings +
                ", clusterSettings=" + clusterSettings +
                '}';
    }
}