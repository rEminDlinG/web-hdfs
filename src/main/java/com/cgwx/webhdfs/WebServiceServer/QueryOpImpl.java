package com.cgwx.webhdfs.WebServiceServer;

import com.cgwx.webhdfs.model.postgresql.HdfsImageStore;
import com.cgwx.webhdfs.model.postgresql.ImageStruct;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

import com.cgwx.webhdfs.service.IImageStoreService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Created by hadoop on 2017/2/22.
 */
@Component
@WebService(serviceName="QueryOpService",endpointInterface="com.cgwx.webhdfs.WebServiceServer.QueryOp")
public class QueryOpImpl extends SpringBeanAutowiringSupport implements QueryOp {

    @Autowired
    private IImageStoreService imageStoreService;

    @WebMethod
    public String SelectByImgGeo(String jsonString)throws IOException
    {

        JSONObject jsonObject = JSONObject.fromObject(jsonString);
        System.out.println("jsonObject：" + jsonObject);
        int ImageCatagory = jsonObject.getInt("ImageCatagory");
        String ImageStartDate = jsonObject.getString("ImageStartDate");
        String ImageEndDate = jsonObject.getString("ImageEndDate");
        String ImageGeo = jsonObject.getString("ImageGeo");
        System.out.println(ImageCatagory);
        System.out.println(ImageStartDate);
        System.out.println(ImageEndDate);
        System.out.println(ImageGeo);
        List<ImageStruct> imageStructList = imageStoreService.selectByGeo(ImageGeo);
        JSONArray jsonObject1 = new JSONArray();
        for (ImageStruct a : imageStructList)
        {
            JSONObject jo = new JSONObject();
            jo.put("image_category",a.getImageCategory());
            jo.put("image_name",a.getImageName());
            jo.put("image_catgegory_extend2",a.getImageCategoryExtends2());
            jo.put("image_file_path",a.getImageFilePath());
            jo.put("image_geo",a.getImageGeo());
            jo.put("image_min_level",a.getImageMinLevel());
            jo.put("image_capture_time",a.getImageCaptureTime());
            jo.put("image_max_level",a.getImageMaxLevel());
            jo.put("image_description",a.getImage_description());
            jsonObject1.add(jo);
        }

        System.out.println(jsonObject1.toString());
        System.out.println(jsonObject1);


        return jsonObject1.toString();
    }
}
