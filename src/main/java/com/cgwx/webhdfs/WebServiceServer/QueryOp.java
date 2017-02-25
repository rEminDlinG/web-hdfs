package com.cgwx.webhdfs.WebServiceServer;

import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

/**
 * Created by hadoop on 2017/2/22.
 */
@WebService
public interface QueryOp {

    @WebMethod
    String SelectByImgGeo(String jsonString)throws IOException;

}
