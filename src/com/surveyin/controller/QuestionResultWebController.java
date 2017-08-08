package com.surveyin.controller;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;

import com.surveyin.entity.QuestionResult;
import com.surveyin.server.QuestionResultMySqlDBServer;

@Path("/qrwc")
public class QuestionResultWebController {
	
	@POST
    @Path("/updatequestionresult")
	@Produces({ MediaType.TEXT_PLAIN})
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateQuestionResult(QuestionResult questionResult) {
        if (QuestionResultMySqlDBServer.getInstance().updateResult(questionResult)) {
        	return Response.status(HttpStatus.SC_OK).build();
        }
        return Response.status(HttpStatus.SC_BAD_REQUEST).build();
    }
	
	@GET
    @Path("/getallquestionresults")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<QuestionResult> getAllQuestionResults() {
        return QuestionResultMySqlDBServer.getInstance().getAllQuestionResult();
    }
	
	@GET
	@Path("/getsinglequestionresults/{question}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public ArrayList<QuestionResult> getSingleQuestionResults(@PathParam("question") String question) {
        return QuestionResultMySqlDBServer.getInstance().getSingleQuestionResult(question);
    }
	
	
}