import com.opensymphony.xwork2.ActionSupport;
import com.sun.net.httpserver.Authenticator;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

public class SecondRequestAction extends ActionSupport {


    public String requestMethod() {

        HttpServletRequest request = ServletActionContext.getRequest();

        //获取请求数据

        Map<String, String[]> map = request.getParameterMap();
        for (String item : map.keySet()) {
            String[] strings = map.get(item);
            System.out.print(Arrays.toString(strings));
        }
        /***
         *
         ${requestapp}<br>
         ${sessionapp}<br>
         ${applicationapp}<br>
         */

        request.setAttribute("requestapp", "requestValue");
        request.getSession().setAttribute("sessionapp", "sessionValue");
        request.getServletContext().setAttribute("applicationapp", "applicationValue");


        return "success";
    }
}
