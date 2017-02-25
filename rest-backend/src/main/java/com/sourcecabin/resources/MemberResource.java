package com.sourcecabin.resources;

import com.sourcecabin.entities.Member;
import com.sourcecabin.services.MemberService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Stateless
@Path("/members")
public class MemberResource {

    private static final Logger LOG = Logger.getLogger(MemberResource.class.getName());

    @Inject
    private MemberService memberService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/apitest")
    public String hello() {
        String message = "API WORKS, AT LEAST PART OF IT :)";
        LOG.info(message);
        return message;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        LOG.info(("GET ALL MEMBERS"));
        return Response
                .status(Response.Status.OK)
                .entity(memberService.findAllMembers())
                .build();
    }

    @POST
    @Consumes("*/*")
    @Path("create")
    public void create(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("nickname") String nickname, @FormParam("role") String role) {
        LOG.info("POST: MEMBER CREATED");
        memberService.create(name, age, nickname, role);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        LOG.info("GET SPECIFIC MEMBER WITH " + id);
        return Response
                .status(Response.Status.OK)
                .entity(memberService.find(id))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Member member) {
        LOG.info("PUT: UPDATE MEMBER WITH " + member);
        memberService.update(member);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") long id) {
        LOG.info("DELETE MEMBER WITH " + id);
        memberService.remove(id);
    }
}
