package com.surveyin.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.surveyin.entity.QuestionOptions;
import com.surveyin.server.QuestionOptionsMySqlDBServer;

@Path("/qowc")
public class QuestionOptionsWebController {
	
	@GET
    @Path("/getquestionoptions")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public QuestionOptions getQuestionOptions() {
        return QuestionOptionsMySqlDBServer.getInstance().getCurrentQuestionOptions();
    }
	
}