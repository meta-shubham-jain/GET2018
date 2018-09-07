package com.metacube.training;

import java.util.*;

public class JavaCollection {
    List<String> addressList;
    Set<String> addressSet;
    Map<String, String> addressMap;

    public void setAddressList(List<String> addressList) {
        this.addressList = addressList;
    }

    public List<String> getAddressList() {
        return addressList;
    }

    public void setAddressSet(Set<String> addressSet) {
        this.addressSet = addressSet;
    }

    public Set<String> getAddressSet() {
        return addressSet;
    }

    public void setAddressMap(Map<String, String> addressMap) {
        this.addressMap = addressMap;
    }

    public Map<String, String> getAddressMap() {
        return addressMap;
    }
}