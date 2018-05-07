package com.github.taixiongliu.hapidemo.route;

import com.github.taixiongliu.hapi.http.HapiHttpRequest;
import com.github.taixiongliu.hapi.http.HapiHttpResponse;
import com.github.taixiongliu.hapi.route.RequestMapping;
import com.github.taixiongliu.hapi.route.Route;
import com.github.taixiongliu.hapidemo.service.UserService;
import com.github.taixiongliu.hapidemo.spring.SpringContextFactory;

/**
 * <b>route controller look like directory</b>
 * <br>
 * {@code @Route} means no first route
 * {@code @Route("index")} means {@code "/index"} is first route
 * @author TaiXiong.Liu
 * 
 */
@Route
public class MyRoute {
	/**
	 * <b>route to index</b>
	 * <br>
	 * RequestMapping must set route
	 * @param request request format body
	 * @param response response format body
	 */
	@RequestMapping("index")
	public void index(HapiHttpRequest request, HapiHttpResponse response){
		String requestIp = request.getIpAddress();
		System.out.println("request ip address: "+requestIp);
		String parameter = request.getParameter("parameter");
		System.out.println("parameter value (e.g: request url 'http://127.0.0.1/index?parameter=123'): "+parameter);
		response.setHead("authentication", "id card");
		
		UserService service = null;
		try {
			service = SpringContextFactory.getInstance().getBean(UserService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(service != null){
			service.getUserByAccount("database account");
		}
		
		// response content
		response.setContent("hi partner...");
	}
}
