package com.daudo.storeo.shop;

import com.daudo.storeo.shop.domain.file.domains.FileUploadRequest;
import com.daudo.storeo.shop.file.application.ports.CreateUploadRequestPort;
import com.daudo.storeo.shop.file.application.ports.DeleteUploadFilePort;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class ShopApplicationTest {

    @Inject
    CreateUploadRequestPort createUploadRequestPort;

    @Inject
    DeleteUploadFilePort deleteUploadFilePort;

    @Test
    public void testCreate() {
        FileUploadRequest request = createUploadRequestPort.create("storeo-statics",
            "1463a0b77da5864ea701940fd3533219.png",
            "image/png",
            2000
        );
        Assertions.assertTrue(request.getObjectKey().equals("1463a0b77da5864ea701940fd3533219.png"));
    }

    @Test
    public void testDelete() {
        deleteUploadFilePort.delete("storeo-statics", "1463a0b77da5864ea701940fd3533219.png");
    }
}
