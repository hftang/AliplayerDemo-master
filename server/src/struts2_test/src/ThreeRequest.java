import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

public class ThreeRequest implements ServletContextAware, ServletRequestAware {
    private ServletContext servletContext;
    private HttpServletRequest httpServletRequest;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }


    public String executedMethod() {

        Map<String, String[]> map = httpServletRequest.getParameterMap();
        for (String item: map.keySet() ) {
            String[] strings = map.get(item);



            System.out.print("key:"+item+";value:"+ Arrays.toString(strings));

        }

        /***
         *
         ${requestapp}<br>
         ${sessionapp}<br>
         ${applicationapp}<br>
         */


        //存数据
        httpServletRequest.setAttribute("requestapp","requestValue");
        httpServletRequest.getSession().setAttribute("sessionapp","sessionValue");
        servletContext.setAttribute("applicationapp","applicationValue");


        return "success";
    }
}
