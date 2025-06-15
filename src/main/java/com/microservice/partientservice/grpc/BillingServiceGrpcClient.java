package com.microservice.partientservice.grpc;

import billing.BillingResponse;

public interface BillingServiceGrpcClient {
    public BillingResponse createBillingAccount(String patientId, String name, String email);
}
