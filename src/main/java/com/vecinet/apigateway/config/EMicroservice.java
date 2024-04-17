package com.vecinet.apigateway.config;

public enum EMicroservice {

    MS_VECINET_AUTH("ms-vecinet-auth");

    private final String serviceName;
    EMicroservice(String serviceName){
        this.serviceName = serviceName;
    }

    public String getUri(){
        return "lb://" + this.serviceName;
    }

    public String getPath(){
        return "/api/" + this.serviceName + "/**";
    }

}
