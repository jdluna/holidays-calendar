package com.cgr.ctrl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(HttpServletResponse res) throws IOException {
		res.sendRedirect("swagger-ui.html");
	}

}
