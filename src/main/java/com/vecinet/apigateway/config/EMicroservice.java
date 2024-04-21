package com.vecinet.apigateway.config;

public enum EMicroservice {

    MS_VECINET_AUTH("ms-vecinet-auth"),
    MS_VECINET_POST("ms-vecinet-post");

    private final String serviceName;
    EMicroservice(String serviceName){
        this.serviceName = serviceName;
    }



    public String getUri(){
        return "lb://" + this.serviceName;
    }

    public String getContextPath(){
        return "/api/" + this.serviceName;
    }

    public String getPath(){
        return getContextPath() + "/**";
    }

}
