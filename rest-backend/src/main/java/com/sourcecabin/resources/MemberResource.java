package com.sourcecabin.resources;

import com.sourcecabin.entities.Member;
import com.sourcecabin.services.MemberService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    @Path("/hello")
    public String hello() {
        return "Hello";
    }

    @POST
    @Consumes("*/*")
    @Path("create")
    public void create(@FormParam("name") String name, @FormParam("age") Integer age, @FormParam("nickname") String nickname, @FormParam("role") String role) {
        LOG.info("POST: Member created");
        memberService.create(name, age, nickname, role);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<Member> findAll() {
        LOG.info(("GET ALL"));
        return memberService.findAllMembers();
    }

    @GET
    @Path("findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Member findById(@PathParam("id") long id) {
        LOG.info("GET: " + id);
        return memberService.find(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(Member member) {
        LOG.info("PUT: " + member);
        memberService.update(member);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        LOG.info("DELETE: " + id);
        memberService.remove(id);
    }
}
