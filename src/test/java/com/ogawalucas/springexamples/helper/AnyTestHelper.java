package com.ogawalucas.springexamples.helper;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;

public class AnyTestHelper {

    public static AnyRequest getAnyRequest() {
        return new AnyRequest(null, "anyField");
    }

    public static AnyResponse getAnyResponse() {
        return new AnyResponse(null, "anyField");
    }
}
