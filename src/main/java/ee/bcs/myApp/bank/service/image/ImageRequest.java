package ee.bcs.myApp.bank.service.image;

import lombok.Data;

@Data
public class ImageRequest {

    private Integer customerId;
    private String title;
    private String description;
    private String data;
}
