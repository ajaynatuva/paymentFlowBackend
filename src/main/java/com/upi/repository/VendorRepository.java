package com.upi.repository;

import java.util.HashMap;
import java.util.Map;

import com.upi.model.Vendor;

public class VendorRepository {
    private final Map<String, Vendor> vendorMap = new HashMap<>();

    public void save(Vendor vendor) {
        vendorMap.put(vendor.getEmail(), vendor);
    }

    public Map<String, Vendor> findAll() {
        return vendorMap;
    }
}
