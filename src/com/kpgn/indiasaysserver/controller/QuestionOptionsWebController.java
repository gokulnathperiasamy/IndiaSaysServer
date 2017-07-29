package com.kpgn.indiasaysserver.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kpgn.indiasaysserver.entity.QuestionOptions;
import com.kpgn.indiasaysserver.server.QuestionOptionsMySqlDBServer;

@Path("/qowc")
public class QuestionOptionsWebController {
	
	/*************************** Check Connection ****************************/
	
	@GET
    @Path("/getquestionoptions")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public QuestionOptions getQuestionOptions() {
        return QuestionOptionsMySqlDBServer.getInstance().getCurrentQuestionOptions();
    }
	
}