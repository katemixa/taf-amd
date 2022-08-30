package model;

import lombok.Data;

import static utils.Constants.PRODUCT_ID;

@Data
public class SearchRequest {
    String id;
    String query;

    public SearchRequest() {
        setId("10763");
        setQuery(PRODUCT_ID);
    }
}
