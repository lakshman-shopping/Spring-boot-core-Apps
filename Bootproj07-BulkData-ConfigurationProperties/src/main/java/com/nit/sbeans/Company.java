package com.nit.sbeans;


import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("comp")
@ConfigurationProperties(prefix="org.nit")
@Setter
@ToString
public class Company {
    private String name;
    private String addrs;
    private String course;
    private String email;
    @Value("${org.nit.capacity}")
    private Long size;
    
    private String owner;
    
    private String[] branches;
    private List<String> owners;
    private Set<Long> phones;
    
    private Map<String, Object> idDetails ;
    private License licenseDetails; // (Has-A-property)
   
}
