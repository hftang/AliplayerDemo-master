import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Arrays;
import java.util.Map;

public class RequestAction extends ActionSupport {

    public String receiveMethod() {

        ActionContext context = ActionContext.getContext();
        Map<String, Object> parameters = context.getParameters();

        for (String key : parameters.keySet()) {
            String[] values = (String[]) parameters.get(key);
            System.out.print(Arrays.toString(values));
        }

        //向里面放入数据
        context.put("requestapp", "requestValue");
        context.getSession().put("sessionapp", "sessionValue");
        context.getApplication().put("applicationapp", "applicationValue");


        return "success";

    }


}
