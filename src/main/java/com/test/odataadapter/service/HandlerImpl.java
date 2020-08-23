package com.test.odataadapter.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.olingo.commons.api.edmx.EdmxReference;
import org.apache.olingo.server.api.*;
import org.apache.olingo.server.api.debug.DebugSupport;
import org.apache.olingo.server.api.etag.CustomETagSupport;
import org.apache.olingo.server.api.processor.Processor;
import org.apache.olingo.server.api.serializer.CustomContentTypeSupport;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class HandlerImpl implements ODataHttpHandler {
    static Logger logger = LogManager.getLogger(HandlerImpl.class);
    ODataHttpHandler oDataHttpHandler;
    public ODataHttpHandler build(){
        OData odata = OData.newInstance();
        ServiceMetadata edm1 = odata.createServiceMetadata(new CarsEdmProvider(), new ArrayList<EdmxReference>());
        oDataHttpHandler = odata.createHandler(edm1);
        com.test.odataadapter.service.Processor processor = new com.test.odataadapter.service.Processor();
        oDataHttpHandler.register(processor);
        return oDataHttpHandler;
    }

    @Override
    public void process(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        logger.info("Hello!!!");
    }

    @Override
    public void setSplit(int i) {

    }

    @Override
    public void register(DebugSupport debugSupport) {

    }

    @Override
    public void register(CustomContentTypeSupport customContentTypeSupport) {

    }

    @Override
    public void register(CustomETagSupport customETagSupport) {

    }

    @Override
    public ODataResponse process(ODataRequest oDataRequest) {
        logger.info("Hello!!!");
        return this.oDataHttpHandler.process(oDataRequest);
    }

    @Override
    public void register(Processor processor) {
        logger.info("Hello!!!");
    }

    @Override
    public void register(OlingoExtension olingoExtension) {

    }
}
