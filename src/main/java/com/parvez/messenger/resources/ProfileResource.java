/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parvez.messenger.resources;

import com.parvez.messenger.model.Profile;
import com.parvez.messenger.service.ProfileService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Parvez
 */
@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

    ProfileService profileService = new ProfileService();

    @GET
    public List<Profile> getProfile() {
        return profileService.getAllProfiles();
    }

    @POST
    public Profile addProfile(Profile profile) {
        return profileService.addProfile(profile);
    }

    @GET
    @Path("{profileName}")
    public Profile getProfile(@PathParam("profileName") String profileName) {
        return profileService.getProfiles(profileName);
    }

    @PUT
    @Path("{profileName}")
    public Profile updateProfile(@PathParam("profileName") String profileName, Profile profile) {
        return profileService.updateProfile(profile);
    }

    @DELETE
    @Path("{profileName}")
    public Profile deleteProfile(@PathParam("profileName") String profileName) {
        return profileService.removeProfile(profileName);
    }
}
