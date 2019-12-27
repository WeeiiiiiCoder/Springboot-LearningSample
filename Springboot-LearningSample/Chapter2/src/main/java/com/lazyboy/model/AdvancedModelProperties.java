package com.lazyboy.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties("com.lazy")
public class AdvancedModelProperties {

    private List<String> phoneList;
    private Map<String, String> phoneName;

    public List<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(List<String> phoneList) {
        this.phoneList = phoneList;
    }

    public Map<String, String> getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(Map<String, String> phoneName) {
        this.phoneName = phoneName;
    }
}
