package com.microservice.partientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClientImpl implements BillingServiceGrpcClient{
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClientImpl.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub bLockingStub;


    //localhost:9001/BillingService/CreatePatientAccount
    public BillingServiceGrpcClientImpl(@Value("${billing.service.address.localHost}") String serverAddress, @Value("${billing.service.grpc.port:9001}") int serverPort)
    {
        log.info("Connecting to grpc service at {}:{}",serverAddress,serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,serverPort).usePlaintext().build();

        this.bLockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    @Override
    public BillingResponse createBillingAccount(String patientId, String name,String email)
    {
        BillingRequest request = BillingRequest.newBuilder().setEmail(email).setPatientId(patientId).setName(name
        ).build();

        BillingResponse response = bLockingStub.createBillingAccount(request);
        log.info("Received response from billing service via GRPC: {}",response);
        return response;
    }
}
