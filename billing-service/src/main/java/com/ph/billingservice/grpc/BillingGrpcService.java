package com.ph.billingservice.grpc;

// NOTE: Need to mark "grpc-java" ("billing-service/target/generated-sources/protobuf/grpc-java")
// and "java" (billing-service/target/generated-sources/protobuf/java) folders as Sources Root.

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc.BillingServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(
            BillingGrpcService.class);

    // Override the createBillingAccount gRPC API from BillingServiceImplBase class
    // and add our own logic in this gRPC API.
    @Override
    public void createBillingAccount(BillingRequest billingRequest,
                                     StreamObserver<BillingResponse> responseObserver) {
        // "StreamObserver" supports streaming responses, meaning you can send one or more messages, not just a single reply.
        // It's perfect to use for real time data update like chat app.
        log.info("createBillingAccount request received {}", billingRequest.toString());

        // TODO: add business logic - e.g save to database, perform calculates etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12345")
                .setStatus("ACTIVE")
                .build();

        // Return the response to client.
        // The gRPC server with "StreamObserver" can return multiple response to client if we want.
        responseObserver.onNext(response);
        // Complete the cycle of response
        responseObserver.onCompleted();
    }
}
