package org.spauny.joy.realvault.client.util;

import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.spauny.joy.realvault.client.model.request.RealExRequest;
import org.spauny.joy.realvault.client.model.response.RealExResponse;

public class RealExHttpUtil {

    public static RealExResponse getResponse(String url, RealExRequest request) throws Exception {
        RealExResponse retVal = RealExBeanToXMLConverterUtil.toResponseBean(
                Request.Post(url).bodyString(RealExBeanToXMLConverterUtil.toXML(request), ContentType.APPLICATION_XML)
                        .execute().returnContent().asString());

        return retVal;
    }

    private RealExHttpUtil() {
    }

}