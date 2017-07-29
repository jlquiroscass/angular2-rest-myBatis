package jlquiros.autentia.controllers;

import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Component
@Path("/api/upload")
public class UploadController {

	@POST
	@Consumes("application/x-www-form-urlencoded;charset=UTF-8")
    public String uploadFile(@RequestParam("file")  InputStream fileInputStream) {

		File file = new File(UUID.randomUUID().toString());
	
	    //Dosomething 
		return "something";

	}

}
