package com.vecinet.apigateway.config;

public enum EMicroservice {

    MS_VECINET_AUTH("MS_VECINET_AUTH"),
    MS_VECINET_POST("ms-vecinet-post");

    private final String serviceName;
    EMicroservice(String serviceName){
        this.serviceName = serviceName;
    }



    public String getUri(){
        return "http://" + this.serviceName;
    }

    public String getContextPath(){
        return "/api/" + this.serviceName;
    }

    public String getPath(){
        return getContextPath() + "/**";
    }

}
