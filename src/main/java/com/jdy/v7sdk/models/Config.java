// This file is auto-generated, don't edit it. Thanks.
package com.jdy.v7sdk.models;

import com.aliyun.tea.*;

public class Config extends TeaModel {
    @NameInMap("host")
    @Validation(required = true)
    public String host;

    @NameInMap("protocol")
    @Validation(required = true)
    public String protocol;

    public static Config build(java.util.Map<String, ?> map) throws Exception {
        Config self = new Config();
        return TeaModel.build(map, self);
    }

    public Config setHost(String host) {
        this.host = host;
        return this;
    }
    public String getHost() {
        return this.host;
    }

    public Config setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }
    public String getProtocol() {
        return this.protocol;
    }

}
