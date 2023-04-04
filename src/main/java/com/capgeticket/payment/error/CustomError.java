package com.capgeticket.payment.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomError extends DefaultErrorAttributes {
    private String timestamp;
    private int status;
    private String error;
    private List<String> message;

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

        Object timestamp = errorAttributes.get("timestamp");
        if (timestamp == null) {
            errorAttributes.put("timestamp", dateFormat.format(new Date()));
        } else {
            errorAttributes.put("timestamp", dateFormat.format((Date) timestamp));
        }

        errorAttributes.remove("trace");
        errorAttributes.remove("path");

        return errorAttributes;
    }
}
