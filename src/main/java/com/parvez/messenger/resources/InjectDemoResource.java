/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parvez.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Parvez
 */
@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
            @HeaderParam("customHeaderValue") String header,
            @CookieParam("customCookie") String cookie) {
        return "Matrix Param: " + matrixParam + "\nHeader Value: "
                + header + "\nCookie Value: " + cookie;
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo,
            @Context HttpHeaders httpHeaders) {
        String path = uriInfo.getAbsolutePath().toString();
        String pathSegments = uriInfo.getPathSegments().toString();

        String language = httpHeaders.getAcceptableLanguages().toString();
        String acceptableMediaType = httpHeaders.getAcceptableMediaTypes().toString();
        String cookies = httpHeaders.getCookies().toString();

        return "Path: " + path + "\nLanguage: " + language + "\nAcceptable Media Type: " + acceptableMediaType
                + "\nCookie: " + cookies;
    }
}

